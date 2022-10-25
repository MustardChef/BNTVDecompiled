package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class ParallelPeek<T> extends ParallelFlowable<T> {
    final Consumer<? super T> onAfterNext;
    final Action onAfterTerminated;
    final Action onCancel;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final LongConsumer onRequest;
    final Consumer<? super Subscription> onSubscribe;
    final ParallelFlowable<T> source;

    public ParallelPeek(ParallelFlowable<T> source, Consumer<? super T> onNext, Consumer<? super T> onAfterNext, Consumer<? super Throwable> onError, Action onComplete, Action onAfterTerminated, Consumer<? super Subscription> onSubscribe, LongConsumer onRequest, Action onCancel) {
        this.source = source;
        Objects.requireNonNull(onNext, "onNext is null");
        this.onNext = onNext;
        Objects.requireNonNull(onAfterNext, "onAfterNext is null");
        this.onAfterNext = onAfterNext;
        Objects.requireNonNull(onError, "onError is null");
        this.onError = onError;
        Objects.requireNonNull(onComplete, "onComplete is null");
        this.onComplete = onComplete;
        Objects.requireNonNull(onAfterTerminated, "onAfterTerminated is null");
        this.onAfterTerminated = onAfterTerminated;
        Objects.requireNonNull(onSubscribe, "onSubscribe is null");
        this.onSubscribe = onSubscribe;
        Objects.requireNonNull(onRequest, "onRequest is null");
        this.onRequest = onRequest;
        Objects.requireNonNull(onCancel, "onCancel is null");
        this.onCancel = onCancel;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscribers) {
        if (validate(subscribers)) {
            int length = subscribers.length;
            Subscriber<? super T>[] subscriberArr = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr[i] = new ParallelPeekSubscriber(subscribers[i], this);
            }
            this.source.subscribe(subscriberArr);
        }
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    /* loaded from: classes4.dex */
    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final ParallelPeek<T> parent;
        Subscription upstream;

        ParallelPeekSubscriber(Subscriber<? super T> actual, ParallelPeek<T> parent) {
            this.downstream = actual;
            this.parent = parent;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            try {
                this.parent.onRequest.accept(n);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.request(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            try {
                this.parent.onCancel.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                try {
                    this.parent.onSubscribe.accept(s);
                    this.downstream.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    s.cancel();
                    this.downstream.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.parent.onNext.accept(t);
                this.downstream.onNext(t);
                try {
                    this.parent.onAfterNext.accept(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            try {
                this.parent.onError.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                t = new CompositeException(t, th);
            }
            this.downstream.onError(t);
            try {
                this.parent.onAfterTerminated.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            try {
                this.parent.onComplete.run();
                this.downstream.onComplete();
                try {
                    this.parent.onAfterTerminated.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }
    }
}
