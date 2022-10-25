package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableWindowTimed(Flowable<T> source, long timespan, long timeskip, TimeUnit unit, Scheduler scheduler, long maxSize, int bufferSize, boolean restartTimerOnMaxSize) {
        super(source);
        this.timespan = timespan;
        this.timeskip = timeskip;
        this.unit = unit;
        this.scheduler = scheduler;
        this.maxSize = maxSize;
        this.bufferSize = bufferSize;
        this.restartTimerOnMaxSize = restartTimerOnMaxSize;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> downstream) {
        if (this.timespan == this.timeskip) {
            if (this.maxSize == Long.MAX_VALUE) {
                this.source.subscribe((FlowableSubscriber) new WindowExactUnboundedSubscriber(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize));
                return;
            } else {
                this.source.subscribe((FlowableSubscriber) new WindowExactBoundedSubscriber(downstream, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
                return;
            }
        }
        this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(downstream, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class AbstractWindowSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        long emitted;
        Throwable error;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        volatile boolean upstreamCancelled;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean downstreamCancelled = new AtomicBoolean();
        final AtomicInteger windowCount = new AtomicInteger(1);

        abstract void cleanupResources();

        abstract void createFirstWindow();

        abstract void drain();

        AbstractWindowSubscriber(Subscriber<? super Flowable<T>> downstream, long timespan, TimeUnit unit, int bufferSize) {
            this.downstream = downstream;
            this.timespan = timespan;
            this.unit = unit;
            this.bufferSize = bufferSize;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable t) {
            this.error = t;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.cancel();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowExactUnboundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastProcessor<T> window;
        final Runnable windowRunnable;

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.scheduler = scheduler;
            this.timer = new SequentialDisposable();
            this.windowRunnable = new WindowRunnable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.windowCount.getAndIncrement();
                this.window = UnicastProcessor.create(this.bufferSize, this.windowRunnable);
                this.emitted = 1L;
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.window);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
                this.timer.replace(this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit));
                if (flowableWindowSubscribeIntercept.tryAbandon()) {
                    this.window.onComplete();
                }
                this.upstream.request(Long.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> simplePlainQueue = this.queue;
            Subscriber<? super Flowable<T>> subscriber = this.downstream;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    simplePlainQueue.clear();
                    this.window = null;
                    unicastProcessor = (UnicastProcessor<T>) null;
                } else {
                    boolean z = this.done;
                    Object poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            if (unicastProcessor != null) {
                                unicastProcessor.onError(th);
                            }
                            subscriber.onError(th);
                        } else {
                            if (unicastProcessor != null) {
                                unicastProcessor.onComplete();
                            }
                            subscriber.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z2) {
                        if (poll == NEXT_WINDOW) {
                            if (unicastProcessor != null) {
                                unicastProcessor.onComplete();
                                this.window = null;
                                unicastProcessor = (UnicastProcessor<T>) null;
                            }
                            if (this.downstreamCancelled.get()) {
                                this.timer.dispose();
                            } else if (this.requested.get() == this.emitted) {
                                this.upstream.cancel();
                                cleanupResources();
                                this.upstreamCancelled = true;
                                subscriber.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
                            } else {
                                this.emitted++;
                                this.windowCount.getAndIncrement();
                                unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.create(this.bufferSize, this.windowRunnable);
                                this.window = unicastProcessor;
                                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                                subscriber.onNext(flowableWindowSubscribeIntercept);
                                if (flowableWindowSubscribeIntercept.tryAbandon()) {
                                    unicastProcessor.onComplete();
                                }
                            }
                        } else if (unicastProcessor != null) {
                            unicastProcessor.onNext(poll);
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void cleanupResources() {
            this.timer.dispose();
        }

        /* loaded from: classes4.dex */
        final class WindowRunnable implements Runnable {
            WindowRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactUnboundedSubscriber.this.windowDone();
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class WindowExactBoundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastProcessor<T> window;
        final Scheduler.Worker worker;

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> actual, long timespan, TimeUnit unit, Scheduler scheduler, int bufferSize, long maxSize, boolean restartTimerOnMaxSize) {
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

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.emitted = 1L;
                this.windowCount.getAndIncrement();
                this.window = UnicastProcessor.create(this.bufferSize, this);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.window);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1L);
                if (this.restartTimerOnMaxSize) {
                    this.timer.replace(this.worker.schedulePeriodically(windowBoundaryRunnable, this.timespan, this.timespan, this.unit));
                } else {
                    this.timer.replace(this.scheduler.schedulePeriodicallyDirect(windowBoundaryRunnable, this.timespan, this.timespan, this.unit));
                }
                if (flowableWindowSubscribeIntercept.tryAbandon()) {
                    this.window.onComplete();
                }
                this.upstream.request(Long.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            windowDone();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
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
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> simplePlainQueue = this.queue;
            Subscriber<? super Flowable<T>> subscriber = this.downstream;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    simplePlainQueue.clear();
                    this.window = null;
                    unicastProcessor = null;
                } else {
                    boolean z = this.done;
                    Object poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            if (unicastProcessor != 0) {
                                unicastProcessor.onError(th);
                            }
                            subscriber.onError(th);
                        } else {
                            if (unicastProcessor != 0) {
                                unicastProcessor.onComplete();
                            }
                            subscriber.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z2) {
                        if (poll instanceof WindowBoundaryRunnable) {
                            if (((WindowBoundaryRunnable) poll).index == this.emitted || !this.restartTimerOnMaxSize) {
                                this.count = 0L;
                                unicastProcessor = createNewWindow(unicastProcessor);
                            }
                        } else if (unicastProcessor != null) {
                            unicastProcessor.onNext(poll);
                            long j = this.count + 1;
                            if (j == this.maxSize) {
                                this.count = 0L;
                                unicastProcessor = createNewWindow(unicastProcessor);
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

        UnicastProcessor<T> createNewWindow(UnicastProcessor<T> window) {
            if (window != null) {
                window.onComplete();
                window = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long j = this.emitted;
                if (this.requested.get() == j) {
                    this.upstream.cancel();
                    cleanupResources();
                    this.upstreamCancelled = true;
                    this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(j)));
                } else {
                    long j2 = j + 1;
                    this.emitted = j2;
                    this.windowCount.getAndIncrement();
                    window = UnicastProcessor.create(this.bufferSize, this);
                    this.window = window;
                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(window);
                    this.downstream.onNext(flowableWindowSubscribeIntercept);
                    if (this.restartTimerOnMaxSize) {
                        this.timer.update(this.worker.schedulePeriodically(new WindowBoundaryRunnable(this, j2), this.timespan, this.timespan, this.unit));
                    }
                    if (flowableWindowSubscribeIntercept.tryAbandon()) {
                        window.onComplete();
                    }
                }
            }
            return window;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class WindowBoundaryRunnable implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            WindowBoundaryRunnable(WindowExactBoundedSubscriber<?> parent, long index) {
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
    static final class WindowSkipSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<UnicastProcessor<T>> windows;
        final Scheduler.Worker worker;
        static final Object WINDOW_OPEN = new Object();
        static final Object WINDOW_CLOSE = new Object();

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> actual, long timespan, long timeskip, TimeUnit unit, Scheduler.Worker worker, int bufferSize) {
            super(actual, timespan, unit, bufferSize);
            this.timeskip = timeskip;
            this.worker = worker;
            this.windows = new LinkedList();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.emitted = 1L;
                this.windowCount.getAndIncrement();
                UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize, this);
                this.windows.add(create);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(create);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
                this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                Scheduler.Worker worker = this.worker;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
                long j = this.timeskip;
                worker.schedulePeriodically(windowBoundaryRunnable, j, j, this.unit);
                if (flowableWindowSubscribeIntercept.tryAbandon()) {
                    create.onComplete();
                    this.windows.remove(create);
                }
                this.upstream.request(Long.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void cleanupResources() {
            this.worker.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.AbstractWindowSubscriber
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimplePlainQueue<Object> simplePlainQueue = this.queue;
            Subscriber<? super Flowable<T>> subscriber = this.downstream;
            List<UnicastProcessor<T>> list = this.windows;
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
                            for (UnicastProcessor<T> unicastProcessor : list) {
                                unicastProcessor.onError(th);
                            }
                            subscriber.onError(th);
                        } else {
                            for (UnicastProcessor<T> unicastProcessor2 : list) {
                                unicastProcessor2.onComplete();
                            }
                            subscriber.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z2) {
                        if (poll == WINDOW_OPEN) {
                            if (!this.downstreamCancelled.get()) {
                                long j = this.emitted;
                                if (this.requested.get() != j) {
                                    this.emitted = j + 1;
                                    this.windowCount.getAndIncrement();
                                    UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize, this);
                                    list.add(create);
                                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(create);
                                    subscriber.onNext(flowableWindowSubscribeIntercept);
                                    this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                                    if (flowableWindowSubscribeIntercept.tryAbandon()) {
                                        create.onComplete();
                                    }
                                } else {
                                    this.upstream.cancel();
                                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(j));
                                    for (UnicastProcessor<T> unicastProcessor3 : list) {
                                        unicastProcessor3.onError(missingBackpressureException);
                                    }
                                    subscriber.onError(missingBackpressureException);
                                    cleanupResources();
                                    this.upstreamCancelled = true;
                                }
                            }
                        } else if (poll == WINDOW_CLOSE) {
                            if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        } else {
                            for (UnicastProcessor<T> unicastProcessor4 : list) {
                                unicastProcessor4.onNext(poll);
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
            final WindowSkipSubscriber<?> parent;

            WindowBoundaryRunnable(WindowSkipSubscriber<?> parent, boolean isOpen) {
                this.parent = parent;
                this.isOpen = isOpen;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.parent.boundary(this.isOpen);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String missingBackpressureMessage(long index) {
        return "Unable to emit the next window (#" + index + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }
}
