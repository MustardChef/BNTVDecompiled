package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends ObservableSource<V>> closingIndicator;
    final ObservableSource<B> open;

    public ObservableWindowBoundarySelector(ObservableSource<T> source, ObservableSource<B> open, Function<? super B, ? extends ObservableSource<V>> closingIndicator, int bufferSize) {
        super(source);
        this.open = open;
        this.closingIndicator = closingIndicator;
        this.bufferSize = bufferSize;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> t) {
        this.source.subscribe(new WindowBoundaryMainObserver(t, this.open, this.closingIndicator, this.bufferSize));
    }

    /* loaded from: classes4.dex */
    static final class WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;
        final int bufferSize;
        final Function<? super B, ? extends ObservableSource<V>> closingIndicator;
        final Observer<? super Observable<T>> downstream;
        long emitted;
        final ObservableSource<B> open;
        volatile boolean openDone;
        Disposable upstream;
        volatile boolean upstreamCanceled;
        volatile boolean upstreamDone;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final CompositeDisposable resources = new CompositeDisposable();
        final List<UnicastSubject<T>> windows = new ArrayList();
        final AtomicLong windowCount = new AtomicLong(1);
        final AtomicBoolean downstreamDisposed = new AtomicBoolean();
        final AtomicThrowable error = new AtomicThrowable();
        final WindowStartObserver<B> startObserver = new WindowStartObserver<>(this);
        final AtomicLong requested = new AtomicLong();

        WindowBoundaryMainObserver(Observer<? super Observable<T>> downstream, ObservableSource<B> open, Function<? super B, ? extends ObservableSource<V>> closingIndicator, int bufferSize) {
            this.downstream = downstream;
            this.open = open;
            this.closingIndicator = closingIndicator;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
                this.open.subscribe(this.startObserver);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.startObserver.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(t)) {
                this.upstreamDone = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.startObserver.dispose();
            this.resources.dispose();
            this.upstreamDone = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.downstreamDisposed.compareAndSet(false, true)) {
                if (this.windowCount.decrementAndGet() == 0) {
                    this.upstream.dispose();
                    this.startObserver.dispose();
                    this.resources.dispose();
                    this.error.tryTerminateAndReport();
                    this.upstreamCanceled = true;
                    drain();
                    return;
                }
                this.startObserver.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.downstreamDisposed.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.dispose();
                this.startObserver.dispose();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
            }
        }

        void open(B startValue) {
            this.queue.offer(new WindowStartItem(startValue));
            drain();
        }

        void openError(Throwable t) {
            this.upstream.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(t)) {
                this.upstreamDone = true;
                drain();
            }
        }

        void openComplete() {
            this.openDone = true;
            drain();
        }

        void close(WindowEndObserverIntercept<T, V> what) {
            this.queue.offer(what);
            drain();
        }

        void closeError(Throwable t) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(t)) {
                this.upstreamDone = true;
                drain();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.downstream;
            SimplePlainQueue<Object> simplePlainQueue = this.queue;
            List<UnicastSubject<T>> list = this.windows;
            int i = 1;
            while (true) {
                if (this.upstreamCanceled) {
                    simplePlainQueue.clear();
                    list.clear();
                } else {
                    boolean z = this.upstreamDone;
                    Object poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (z && (z2 || this.error.get() != null)) {
                        terminateDownstream(observer);
                        this.upstreamCanceled = true;
                    } else if (!z2) {
                        if (poll instanceof WindowStartItem) {
                            if (!this.downstreamDisposed.get()) {
                                try {
                                    ObservableSource<V> apply = this.closingIndicator.apply(((WindowStartItem) poll).item);
                                    Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                    ObservableSource<V> observableSource = apply;
                                    this.windowCount.getAndIncrement();
                                    UnicastSubject<T> create = UnicastSubject.create(this.bufferSize, this);
                                    WindowEndObserverIntercept windowEndObserverIntercept = new WindowEndObserverIntercept(this, create);
                                    observer.onNext(windowEndObserverIntercept);
                                    if (windowEndObserverIntercept.tryAbandon()) {
                                        create.onComplete();
                                    } else {
                                        list.add(create);
                                        this.resources.add(windowEndObserverIntercept);
                                        observableSource.subscribe(windowEndObserverIntercept);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.upstream.dispose();
                                    this.startObserver.dispose();
                                    this.resources.dispose();
                                    Exceptions.throwIfFatal(th);
                                    this.error.tryAddThrowableOrReport(th);
                                    this.upstreamDone = true;
                                }
                            }
                        } else if (poll instanceof WindowEndObserverIntercept) {
                            UnicastSubject<T> unicastSubject = ((WindowEndObserverIntercept) poll).window;
                            list.remove(unicastSubject);
                            this.resources.delete((Disposable) poll);
                            unicastSubject.onComplete();
                        } else {
                            for (UnicastSubject<T> unicastSubject2 : list) {
                                unicastSubject2.onNext(poll);
                            }
                        }
                    } else if (this.openDone && list.size() == 0) {
                        this.upstream.dispose();
                        this.startObserver.dispose();
                        this.resources.dispose();
                        terminateDownstream(observer);
                        this.upstreamCanceled = true;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        void terminateDownstream(Observer<?> downstream) {
            Throwable terminate = this.error.terminate();
            if (terminate == null) {
                for (UnicastSubject<T> unicastSubject : this.windows) {
                    unicastSubject.onComplete();
                }
                downstream.onComplete();
            } else if (terminate != ExceptionHelper.TERMINATED) {
                for (UnicastSubject<T> unicastSubject2 : this.windows) {
                    unicastSubject2.onError(terminate);
                }
                downstream.onError(terminate);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class WindowStartItem<B> {
            final B item;

            WindowStartItem(B item) {
                this.item = item;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class WindowStartObserver<B> extends AtomicReference<Disposable> implements Observer<B> {
            private static final long serialVersionUID = -3326496781427702834L;
            final WindowBoundaryMainObserver<?, B, ?> parent;

            WindowStartObserver(WindowBoundaryMainObserver<?, B, ?> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(B t) {
                this.parent.open(t);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable t) {
                this.parent.openError(t);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                this.parent.openComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class WindowEndObserverIntercept<T, V> extends Observable<T> implements Observer<V>, Disposable {
            final WindowBoundaryMainObserver<T, ?, V> parent;
            final UnicastSubject<T> window;
            final AtomicReference<Disposable> upstream = new AtomicReference<>();
            final AtomicBoolean once = new AtomicBoolean();

            WindowEndObserverIntercept(WindowBoundaryMainObserver<T, ?, V> parent, UnicastSubject<T> window) {
                this.parent = parent;
                this.window = window;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this.upstream, d);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(V t) {
                if (DisposableHelper.dispose(this.upstream)) {
                    this.parent.close(this);
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable t) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(t);
                } else {
                    this.parent.closeError(t);
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                this.parent.close(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this.upstream);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return this.upstream.get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.rxjava3.core.Observable
            protected void subscribeActual(Observer<? super T> o) {
                this.window.subscribe(o);
                this.once.set(true);
            }

            boolean tryAbandon() {
                return !this.once.get() && this.once.compareAndSet(false, true);
            }
        }
    }
}
