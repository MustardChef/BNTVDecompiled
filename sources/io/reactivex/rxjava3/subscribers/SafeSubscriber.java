package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    boolean done;
    final Subscriber<? super T> downstream;
    Subscription upstream;

    public SafeSubscriber(Subscriber<? super T> downstream) {
        this.downstream = downstream;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.validate(this.upstream, s)) {
            this.upstream = s;
            try {
                this.downstream.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.done = true;
                try {
                    s.cancel();
                    RxJavaPlugins.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.upstream == null) {
            onNextNoSubscription();
        } else if (t == null) {
            NullPointerException createNullPointerException = ExceptionHelper.createNullPointerException("onNext called with a null Throwable.");
            try {
                this.upstream.cancel();
                onError(createNullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(new CompositeException(createNullPointerException, th));
            }
        } else {
            try {
                this.downstream.onNext(t);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                try {
                    this.upstream.cancel();
                    onError(th2);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(new CompositeException(th2, th3));
                }
            }
        }
    }

    void onNextNoSubscription() {
        this.done = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.downstream.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        if (this.done) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.downstream.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.downstream.onError(new CompositeException(t, nullPointerException));
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(t, nullPointerException, th));
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(t, nullPointerException, th2));
                return;
            }
        }
        if (t == null) {
            t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        try {
            this.downstream.onError(t);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(t, th3));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            onCompleteNoSubscription();
            return;
        }
        try {
            this.downstream.onComplete();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    void onCompleteNoSubscription() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.downstream.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long n) {
        try {
            this.upstream.request(n);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            try {
                this.upstream.cancel();
                RxJavaPlugins.onError(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        try {
            this.upstream.cancel();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }
}
