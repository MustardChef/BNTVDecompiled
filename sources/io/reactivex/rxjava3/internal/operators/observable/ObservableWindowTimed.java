package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public ObservableWindowTimed(Observable<T> source, long timespan, long timeskip, TimeUnit unit, Scheduler scheduler, long maxSize, int bufferSize, boolean restartTimerOnMaxSize) {
        super(source);
        this.timespan = timespan;
        this.timeskip = timeskip;
        this.unit = unit;
        this.scheduler = scheduler;
        this.maxSize = maxSize;
        this.bufferSize = bufferSize;
        this.restartTimerOnMaxSize = restartTimerOnMaxSize;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super Observable<T>> downstream) {
        if (this.timespan == this.timeskip) {
            if (this.maxSize == Long.MAX_VALUE) {
                this.source.subscribe(new WindowExactUnboundedObserver(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize));
                return;
            } else {
                this.source.subscribe(new WindowExactBoundedObserver(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
                return;
            }
        }
        this.source.subscribe(new WindowSkipObserver(downstream, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class AbstractWindowObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final Observer<? super Observable<T>> downstream;
        long emitted;
        Throwable error;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        volatile boolean upstreamCancelled;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final AtomicBoolean downstreamCancelled = new AtomicBoolean();
        final AtomicInteger windowCount = new AtomicInteger(1);

        abstract void cleanupResources();

        abstract void createFirstWindow();

        abstract void drain();

        AbstractWindowObserver(Observer<? super Observable<T>> downstream, long timespan, TimeUnit unit, int bufferSize) {
            this.downstream = downstream;
            this.timespan = timespan;
            this.unit = unit;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onError(Throwable t) {
            this.error = t;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final void dispose() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final boolean isDisposed() {
            return this.downstreamCancelled.get();
        }

        final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.dispose();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowExactUnboundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastSubject<T> window;
        final Runnable windowRunnable;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.scheduler = scheduler;
            this.timer = new SequentialDisposable();
            this.windowRunnable = new WindowRunnable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            this.windowCount.getAndIncrement();
            this.window = UnicastSubject.create(this.bufferSize, this.windowRunnable);
            this.emitted = 1L;
            ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(this.window);
            this.downstream.onNext(observableWindowSubscribeIntercept);
            this.timer.replace(this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit));
            if (observableWindowSubscribeIntercept.tryAbandon()) {
                this.window.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> simplePlainQueue = this.queue;
            Observer<? super Observable<T>> observer = this.downstream;
            UnicastSubject<T> unicastSubject = this.window;
            int i = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    simplePlainQueue.clear();
                    this.window = null;
                    unicastSubject = (UnicastSubject<T>) null;
                } else {
                    boolean z = this.done;
                    Object poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            if (unicastSubject != null) {
                                unicastSubject.onError(th);
                            }
                            observer.onError(th);
                        } else {
                            if (unicastSubject != null) {
                                unicastSubject.onComplete();
                            }
                            observer.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z2) {
                        if (poll == NEXT_WINDOW) {
                            if (unicastSubject != null) {
                                unicastSubject.onComplete();
                                this.window = null;
                                unicastSubject = (UnicastSubject<T>) null;
                            }
                            if (this.downstreamCancelled.get()) {
                                this.timer.dispose();
                            } else {
                                this.emitted++;
                                this.windowCount.getAndIncrement();
                                unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize, this.windowRunnable);
                                this.window = unicastSubject;
                                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                                observer.onNext(observableWindowSubscribeIntercept);
                                if (observableWindowSubscribeIntercept.tryAbandon()) {
                                    unicastSubject.onComplete();
                                }
                            }
                        } else if (unicastSubject != null) {
                            unicastSubject.onNext(poll);
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void cleanupResources() {
            this.timer.dispose();
        }

        /* loaded from: classes4.dex */
        final class WindowRunnable implements Runnable {
            WindowRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactUnboundedObserver.this.windowDone();
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowExactBoundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastSubject<T> window;
        final Scheduler.Worker worker;

        WindowExactBoundedObserver(Observer<? super Observable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize, long maxSize, boolean restartTimerOnMaxSize) {
            super(actual, timespan, unit, bufferSize);
            this.scheduler = scheduler;
            this.maxSize = maxSize;
            this.restartTimerOnMaxSize = restartTimerOnMaxSize;
            if (restartTimerOnMaxSize) {
                this.worker = scheduler.createWorker();
            } else {
                this.worker = null;
            }
            this.timer = new SequentialDisposable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            this.emitted = 1L;
            this.windowCount.getAndIncrement();
            UnicastSubject<T> create = UnicastSubject.create(this.bufferSize, this);
            this.window = create;
            ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
            this.downstream.onNext(observableWindowSubscribeIntercept);
            WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1L);
            if (this.restartTimerOnMaxSize) {
                this.timer.replace(this.worker.schedulePeriodically(windowBoundaryRunnable, this.timespan, this.timespan, this.unit));
            } else {
                this.timer.replace(this.scheduler.schedulePeriodicallyDirect(windowBoundaryRunnable, this.timespan, this.timespan, this.unit));
            }
            if (observableWindowSubscribeIntercept.tryAbandon()) {
                this.window.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            windowDone();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void cleanupResources() {
            this.timer.dispose();
            Scheduler.Worker worker = this.worker;
            if (worker != null) {
                worker.dispose();
            }
        }

        void boundary(WindowBoundaryRunnable sender) {
            this.queue.offer(sender);
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> simplePlainQueue = this.queue;
            Observer<? super Observable<T>> observer = this.downstream;
            UnicastSubject<T> unicastSubject = this.window;
            int i = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    simplePlainQueue.clear();
                    this.window = null;
                    unicastSubject = null;
                } else {
                    boolean z = this.done;
                    Object poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            if (unicastSubject != 0) {
                                unicastSubject.onError(th);
                            }
                            observer.onError(th);
                        } else {
                            if (unicastSubject != 0) {
                                unicastSubject.onComplete();
                            }
                            observer.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z2) {
                        if (poll instanceof WindowBoundaryRunnable) {
                            if (((WindowBoundaryRunnable) poll).index == this.emitted || !this.restartTimerOnMaxSize) {
                                this.count = 0L;
                                unicastSubject = createNewWindow(unicastSubject);
                            }
                        } else if (unicastSubject != null) {
                            unicastSubject.onNext(poll);
                            long j = this.count + 1;
                            if (j == this.maxSize) {
                                this.count = 0L;
                                unicastSubject = createNewWindow(unicastSubject);
                            } else {
                                this.count = j;
                            }
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        UnicastSubject<T> createNewWindow(UnicastSubject<T> window) {
            if (window != null) {
                window.onComplete();
                window = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long j = this.emitted + 1;
                this.emitted = j;
                this.windowCount.getAndIncrement();
                window = UnicastSubject.create(this.bufferSize, this);
                this.window = window;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(window);
                this.downstream.onNext(observableWindowSubscribeIntercept);
                if (this.restartTimerOnMaxSize) {
                    this.timer.update(this.worker.schedulePeriodically(new WindowBoundaryRunnable(this, j), this.timespan, this.timespan, this.unit));
                }
                if (observableWindowSubscribeIntercept.tryAbandon()) {
                    window.onComplete();
                }
            }
            return window;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class WindowBoundaryRunnable implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            WindowBoundaryRunnable(WindowExactBoundedObserver<?> parent, long index) {
                this.parent = parent;
                this.index = index;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowSkipObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<UnicastSubject<T>> windows;
        final Scheduler.Worker worker;
        static final Object WINDOW_OPEN = new Object();
        static final Object WINDOW_CLOSE = new Object();

        WindowSkipObserver(Observer<? super Observable<T>> actual, long timespan, long timeskip, TimeUnit unit, Scheduler.Worker worker, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.timeskip = timeskip;
            this.worker = worker;
            this.windows = new LinkedList();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            this.emitted = 1L;
            this.windowCount.getAndIncrement();
            UnicastSubject<T> create = UnicastSubject.create(this.bufferSize, this);
            this.windows.add(create);
            ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
            this.downstream.onNext(observableWindowSubscribeIntercept);
            this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
            Scheduler.Worker worker = this.worker;
            WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
            long j = this.timeskip;
            worker.schedulePeriodically(windowBoundaryRunnable, j, j, this.unit);
            if (observableWindowSubscribeIntercept.tryAbandon()) {
                create.onComplete();
                this.windows.remove(create);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void cleanupResources() {
            this.worker.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.AbstractWindowObserver
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> simplePlainQueue = this.queue;
            Observer<? super Observable<T>> observer = this.downstream;
            List<UnicastSubject<T>> list = this.windows;
            int i = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    simplePlainQueue.clear();
                    list.clear();
                } else {
                    boolean z = this.done;
                    Object poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            for (UnicastSubject<T> unicastSubject : list) {
                                unicastSubject.onError(th);
                            }
                            observer.onError(th);
                        } else {
                            for (UnicastSubject<T> unicastSubject2 : list) {
                                unicastSubject2.onComplete();
                            }
                            observer.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z2) {
                        if (poll == WINDOW_OPEN) {
                            if (!this.downstreamCancelled.get()) {
                                this.emitted++;
                                this.windowCount.getAndIncrement();
                                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize, this);
                                list.add(create);
                                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                                observer.onNext(observableWindowSubscribeIntercept);
                                this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                                if (observableWindowSubscribeIntercept.tryAbandon()) {
                                    create.onComplete();
                                }
                            }
                        } else if (poll == WINDOW_CLOSE) {
                            if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        } else {
                            for (UnicastSubject<T> unicastSubject3 : list) {
                                unicastSubject3.onNext(poll);
                            }
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            windowDone();
        }

        void boundary(boolean isOpen) {
            this.queue.offer(isOpen ? WINDOW_OPEN : WINDOW_CLOSE);
            drain();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class WindowBoundaryRunnable implements Runnable {
            final boolean isOpen;
            final WindowSkipObserver<?> parent;

            WindowBoundaryRunnable(WindowSkipObserver<?> parent, boolean isOpen) {
                this.parent = parent;
                this.isOpen = isOpen;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this.isOpen);
            }
        }
    }
}
