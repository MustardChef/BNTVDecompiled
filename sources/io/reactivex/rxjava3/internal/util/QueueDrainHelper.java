package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class QueueDrainHelper {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> void drainMaxLoop(SimplePlainQueue<T> q, Subscriber<? super U> a, boolean delayError, Disposable dispose, QueueDrain<T, U> qd) {
        int i = 1;
        while (true) {
            boolean done = qd.done();
            T poll = q.poll();
            boolean z = poll == null;
            if (checkTerminated(done, z, a, delayError, q, qd)) {
                if (dispose != null) {
                    dispose.dispose();
                    return;
                }
                return;
            } else if (!z) {
                long requested = qd.requested();
                if (requested != 0) {
                    if (qd.accept(a, poll) && requested != Long.MAX_VALUE) {
                        qd.produced(1L);
                    }
                } else {
                    q.clear();
                    if (dispose != null) {
                        dispose.dispose();
                    }
                    a.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
            } else {
                i = qd.leave(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    public static <T, U> boolean checkTerminated(boolean d, boolean empty, Subscriber<?> s, boolean delayError, SimpleQueue<?> q, QueueDrain<T, U> qd) {
        if (qd.cancelled()) {
            q.clear();
            return true;
        } else if (d) {
            if (delayError) {
                if (empty) {
                    Throwable error = qd.error();
                    if (error != null) {
                        s.onError(error);
                    } else {
                        s.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable error2 = qd.error();
            if (error2 != null) {
                q.clear();
                s.onError(error2);
                return true;
            } else if (empty) {
                s.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> q, Observer<? super U> a, boolean delayError, Disposable dispose, ObservableQueueDrain<T, U> qd) {
        int i = 1;
        while (!checkTerminated(qd.done(), q.isEmpty(), a, delayError, q, dispose, qd)) {
            while (true) {
                boolean done = qd.done();
                T poll = q.poll();
                boolean z = poll == null;
                if (checkTerminated(done, z, a, delayError, q, dispose, qd)) {
                    return;
                }
                if (!z) {
                    qd.accept(a, poll);
                } else {
                    i = qd.leave(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public static <T, U> boolean checkTerminated(boolean d, boolean empty, Observer<?> observer, boolean delayError, SimpleQueue<?> q, Disposable disposable, ObservableQueueDrain<T, U> qd) {
        if (qd.cancelled()) {
            q.clear();
            disposable.dispose();
            return true;
        } else if (d) {
            if (delayError) {
                if (empty) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    Throwable error = qd.error();
                    if (error != null) {
                        observer.onError(error);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable error2 = qd.error();
            if (error2 != null) {
                q.clear();
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onError(error2);
                return true;
            } else if (empty) {
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static <T> SimpleQueue<T> createQueue(int capacityHint) {
        if (capacityHint < 0) {
            return new SpscLinkedArrayQueue(-capacityHint);
        }
        return new SpscArrayQueue(capacityHint);
    }

    public static void request(Subscription s, int prefetch) {
        s.request(prefetch < 0 ? Long.MAX_VALUE : prefetch);
    }

    public static <T> boolean postCompleteRequest(long n, Subscriber<? super T> actual, Queue<T> queue, AtomicLong state, BooleanSupplier isCancelled) {
        long j;
        do {
            j = state.get();
        } while (!state.compareAndSet(j, BackpressureHelper.addCap(Long.MAX_VALUE & j, n) | (j & Long.MIN_VALUE)));
        if (j == Long.MIN_VALUE) {
            postCompleteDrain(n | Long.MIN_VALUE, actual, queue, state, isCancelled);
            return true;
        }
        return false;
    }

    static boolean isCancelled(BooleanSupplier cancelled) {
        try {
            return cancelled.getAsBoolean();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return true;
        }
    }

    static <T> boolean postCompleteDrain(long n, Subscriber<? super T> actual, Queue<T> queue, AtomicLong state, BooleanSupplier isCancelled) {
        long j = n & Long.MIN_VALUE;
        while (true) {
            if (j != n) {
                if (isCancelled(isCancelled)) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    actual.onComplete();
                    return true;
                }
                actual.onNext(obj);
                j++;
            } else if (isCancelled(isCancelled)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    actual.onComplete();
                    return true;
                }
                n = state.get();
                if (n == j) {
                    long addAndGet = state.addAndGet(-(j & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    n = addAndGet;
                    j = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void postComplete(Subscriber<? super T> actual, Queue<T> queue, AtomicLong state, BooleanSupplier isCancelled) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            actual.onComplete();
        } else if (postCompleteDrain(state.get(), actual, queue, state, isCancelled)) {
        } else {
            do {
                j = state.get();
                if ((j & Long.MIN_VALUE) != 0) {
                    return;
                }
                j2 = j | Long.MIN_VALUE;
            } while (!state.compareAndSet(j, j2));
            if (j != 0) {
                postCompleteDrain(j2, actual, queue, state, isCancelled);
            }
        }
    }
}
