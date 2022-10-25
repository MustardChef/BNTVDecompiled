package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    public FlowableZip(Publisher<? extends T>[] sources, Iterable<? extends Publisher<? extends T>> sourcesIterable, Function<? super Object[], ? extends R> zipper, int bufferSize, boolean delayError) {
        this.sources = sources;
        this.sourcesIterable = sourcesIterable;
        this.zipper = zipper;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> s) {
        int length;
        Publisher<? extends T>[] publisherArr = this.sources;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher<? extends T> publisher : this.sourcesIterable) {
                if (length == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(s);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(s, this.zipper, i, this.bufferSize, this.delayError);
        s.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(publisherArr, i);
    }

    /* loaded from: classes4.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(Subscriber<? super R> actual, Function<? super Object[], ? extends R> zipper, int n, int prefetch, boolean delayErrors) {
            this.downstream = actual;
            this.zipper = zipper;
            this.delayErrors = delayErrors;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[n];
            for (int i = 0; i < n; i++) {
                zipSubscriberArr[i] = new ZipSubscriber<>(this, prefetch);
            }
            this.current = new Object[n];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        void subscribe(Publisher<? extends T>[] sources, int n) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i = 0; i < n && !this.cancelled; i++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                sources[i].subscribe(zipSubscriberArr[i]);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        void error(ZipSubscriber<T, R> inner, Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                inner.done = true;
                drain();
            }
        }

        void cancelAll() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b7, code lost:
            if (r16 != 0) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00bb, code lost:
            if (r20.cancelled == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00bd, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00c0, code lost:
            if (r20.delayErrors != false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00c8, code lost:
            if (r20.errors.get() == null) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ca, code lost:
            cancelAll();
            r20.errors.tryTerminateConsumer(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00d2, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00d4, code lost:
            if (r6 >= r4) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00d6, code lost:
            r0 = r3[r6];
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00da, code lost:
            if (r5[r6] != null) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00dc, code lost:
            r15 = r0.done;
            r0 = r0.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00e0, code lost:
            if (r0 == null) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00e2, code lost:
            r0 = r0.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00e7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00e8, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
            r20.errors.tryAddThrowableOrReport(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00f3, code lost:
            if (r20.delayErrors == false) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00f5, code lost:
            cancelAll();
            r20.errors.tryTerminateConsumer(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00fd, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00fe, code lost:
            r0 = null;
            r15 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0101, code lost:
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0102, code lost:
            if (r0 != null) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0104, code lost:
            r16 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0107, code lost:
            r16 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0109, code lost:
            if (r15 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x010b, code lost:
            if (r16 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x010d, code lost:
            cancelAll();
            r20.errors.tryTerminateConsumer(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0115, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0116, code lost:
            if (r16 != false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0118, code lost:
            r5[r6] = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x011a, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x011f, code lost:
            if (r12 == 0) goto L113;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0121, code lost:
            r0 = r3.length;
            r15 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0123, code lost:
            if (r15 >= r0) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0125, code lost:
            r3[r15].request(r12);
            r15 = r15 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0134, code lost:
            if (r8 == Long.MAX_VALUE) goto L113;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0136, code lost:
            r20.requested.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x013c, code lost:
            r7 = addAndGet(-r7);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 324
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableZip.ZipCoordinator.drain():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> parent, int prefetch) {
            this.parent = parent;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) s;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        s.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                s.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.parent.error(this, t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (this.sourceMode != 1) {
                long j = this.produced + n;
                if (j >= this.limit) {
                    this.produced = 0L;
                    get().request(j);
                    return;
                }
                this.produced = j;
            }
        }
    }
}
