package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableFromRunnable<T> extends Flowable<T> implements Supplier<T> {
    final Runnable run;

    public FlowableFromRunnable(Runnable run) {
        this.run = run;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        subscriber.onSubscribe(cancellableQueueFuseable);
        if (cancellableQueueFuseable.isDisposed()) {
            return;
        }
        try {
            this.run.run();
            if (cancellableQueueFuseable.isDisposed()) {
                return;
            }
            subscriber.onComplete();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!cancellableQueueFuseable.isDisposed()) {
                subscriber.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        this.run.run();
        return null;
    }
}
