package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicBoolean once;
    volatile long size;
    Node<T> tail;
    int tailOffset;

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable d) {
    }

    public ObservableCache(Observable<T> source, int capacityHint) {
        super(source);
        this.capacityHint = capacityHint;
        this.once = new AtomicBoolean();
        Node<T> node = new Node<>(capacityHint);
        this.head = node;
        this.tail = node;
        this.observers = new AtomicReference<>(EMPTY);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> t) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(t, this);
        t.onSubscribe(cacheDisposable);
        add(cacheDisposable);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.source.subscribe(this);
        } else {
            replay(cacheDisposable);
        }
    }

    boolean isConnected() {
        return this.once.get();
    }

    boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    long cachedEventCount() {
        return this.size;
    }

    void add(CacheDisposable<T> consumer) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            if (cacheDisposableArr == TERMINATED) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = consumer;
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void remove(CacheDisposable<T> consumer) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (cacheDisposableArr[i2] == consumer) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = EMPTY;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    void replay(CacheDisposable<T> consumer) {
        if (consumer.getAndIncrement() != 0) {
            return;
        }
        long j = consumer.index;
        int i = consumer.offset;
        Node<T> node = consumer.node;
        Observer<? super T> observer = consumer.downstream;
        int i2 = this.capacityHint;
        int i3 = 1;
        while (!consumer.disposed) {
            boolean z = this.done;
            boolean z2 = this.size == j;
            if (z && z2) {
                consumer.node = null;
                Throwable th = this.error;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            } else if (!z2) {
                if (i == i2) {
                    node = node.next;
                    i = 0;
                }
                observer.onNext((Object) node.values[i]);
                i++;
                j++;
            } else {
                consumer.index = j;
                consumer.offset = i;
                consumer.node = node;
                i3 = consumer.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        consumer.node = null;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        int i = this.tailOffset;
        if (i == this.capacityHint) {
            Node<T> node = new Node<>(i);
            node.values[0] = t;
            this.tailOffset = 1;
            this.tail.next = node;
            this.tail = node;
        } else {
            this.tail.values[i] = t;
            this.tailOffset = i + 1;
        }
        this.size++;
        for (CacheDisposable<T> cacheDisposable : this.observers.get()) {
            replay(cacheDisposable);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        this.error = t;
        this.done = true;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
            replay(cacheDisposable);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        this.done = true;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
            replay(cacheDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(Observer<? super T> downstream, ObservableCache<T> parent) {
            this.downstream = downstream;
            this.parent = parent;
            this.node = parent.head;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.parent.remove(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int capacityHint) {
            this.values = (T[]) new Object[capacityHint];
        }
    }
}
