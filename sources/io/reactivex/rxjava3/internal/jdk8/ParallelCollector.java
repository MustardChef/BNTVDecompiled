package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class ParallelCollector<T, A, R> extends Flowable<R> {
    final Collector<T, A, R> collector;
    final ParallelFlowable<? extends T> source;

    public ParallelCollector(ParallelFlowable<? extends T> source, Collector<T, A, R> collector) {
        this.source = source;
        this.collector = collector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        try {
            ParallelCollectorSubscriber parallelCollectorSubscriber = new ParallelCollectorSubscriber(s, this.source.parallelism(), this.collector);
            s.onSubscribe(parallelCollectorSubscriber);
            this.source.subscribe(parallelCollectorSubscriber.subscribers);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ParallelCollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<SlotPair<A>> current;
        final AtomicThrowable error;
        final Function<A, R> finisher;
        final AtomicInteger remaining;
        final ParallelCollectorInnerSubscriber<T, A, R>[] subscribers;

        ParallelCollectorSubscriber(Subscriber<? super R> subscriber, int n, Collector<T, A, R> collector) {
            super(subscriber);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicThrowable();
            this.finisher = collector.finisher();
            ParallelCollectorInnerSubscriber<T, A, R>[] parallelCollectorInnerSubscriberArr = new ParallelCollectorInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                parallelCollectorInnerSubscriberArr[i] = new ParallelCollectorInnerSubscriber<>(this, collector.supplier().get(), collector.accumulator(), collector.combiner());
            }
            this.subscribers = parallelCollectorInnerSubscriberArr;
            this.remaining.lazySet(n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        SlotPair<A> addValue(A value) {
            SlotPair<A> slotPair;
            int tryAcquireSlot;
            while (true) {
                slotPair = this.current.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!this.current.compareAndSet(null, slotPair)) {
                        continue;
                    }
                }
                tryAcquireSlot = slotPair.tryAcquireSlot();
                if (tryAcquireSlot >= 0) {
                    break;
                }
                this.current.compareAndSet(slotPair, null);
            }
            if (tryAcquireSlot == 0) {
                slotPair.first = value;
            } else {
                slotPair.second = value;
            }
            if (slotPair.releaseSlot()) {
                this.current.compareAndSet(slotPair, null);
                return slotPair;
            }
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            for (ParallelCollectorInnerSubscriber<T, A, R> parallelCollectorInnerSubscriber : this.subscribers) {
                parallelCollectorInnerSubscriber.cancel();
            }
        }

        void innerError(Throwable ex) {
            if (this.error.compareAndSet(null, ex)) {
                cancel();
                this.downstream.onError(ex);
            } else if (ex != this.error.get()) {
                RxJavaPlugins.onError(ex);
            }
        }

        void innerComplete(A value, BinaryOperator<A> combiner) {
            while (true) {
                SlotPair<A> addValue = addValue(value);
                if (addValue == null) {
                    break;
                }
                try {
                    value = (A) combiner.apply(addValue.first, addValue.second);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    innerError(th);
                    return;
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                SlotPair<A> slotPair = this.current.get();
                this.current.lazySet(null);
                try {
                    R apply = this.finisher.apply(slotPair.first);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    complete(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    innerError(th2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ParallelCollectorInnerSubscriber<T, A, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        final BiConsumer<A, T> accumulator;
        final BinaryOperator<A> combiner;
        A container;
        boolean done;
        final ParallelCollectorSubscriber<T, A, R> parent;

        ParallelCollectorInnerSubscriber(ParallelCollectorSubscriber<T, A, R> parent, A container, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner) {
            this.parent = parent;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.container = container;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator.accept(this.container, t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.container = null;
            this.done = true;
            this.parent.innerError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            A a = this.container;
            this.container = null;
            this.done = true;
            this.parent.innerComplete(a, this.combiner);
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        SlotPair() {
        }

        int tryAcquireSlot() {
            int i;
            do {
                i = get();
                if (i >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i, i + 1));
            return i;
        }

        boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }
    }
}
