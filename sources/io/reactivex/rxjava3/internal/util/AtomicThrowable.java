package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean tryAddThrowable(Throwable t) {
        return ExceptionHelper.addThrowable(this, t);
    }

    public boolean tryAddThrowableOrReport(Throwable t) {
        if (tryAddThrowable(t)) {
            return true;
        }
        RxJavaPlugins.onError(t);
        return false;
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }

    public boolean isTerminated() {
        return get() == ExceptionHelper.TERMINATED;
    }

    public void tryTerminateAndReport() {
        Throwable terminate = terminate();
        if (terminate == null || terminate == ExceptionHelper.TERMINATED) {
            return;
        }
        RxJavaPlugins.onError(terminate);
    }

    public void tryTerminateConsumer(Subscriber<?> consumer) {
        Throwable terminate = terminate();
        if (terminate == null) {
            consumer.onComplete();
        } else if (terminate != ExceptionHelper.TERMINATED) {
            consumer.onError(terminate);
        }
    }

    public void tryTerminateConsumer(Observer<?> consumer) {
        Throwable terminate = terminate();
        if (terminate == null) {
            consumer.onComplete();
        } else if (terminate != ExceptionHelper.TERMINATED) {
            consumer.onError(terminate);
        }
    }

    public void tryTerminateConsumer(MaybeObserver<?> consumer) {
        Throwable terminate = terminate();
        if (terminate == null) {
            consumer.onComplete();
        } else if (terminate != ExceptionHelper.TERMINATED) {
            consumer.onError(terminate);
        }
    }

    public void tryTerminateConsumer(SingleObserver<?> consumer) {
        Throwable terminate = terminate();
        if (terminate == null || terminate == ExceptionHelper.TERMINATED) {
            return;
        }
        consumer.onError(terminate);
    }

    public void tryTerminateConsumer(CompletableObserver consumer) {
        Throwable terminate = terminate();
        if (terminate == null) {
            consumer.onComplete();
        } else if (terminate != ExceptionHelper.TERMINATED) {
            consumer.onError(terminate);
        }
    }

    public void tryTerminateConsumer(Emitter<?> consumer) {
        Throwable terminate = terminate();
        if (terminate == null) {
            consumer.onComplete();
        } else if (terminate != ExceptionHelper.TERMINATED) {
            consumer.onError(terminate);
        }
    }
}
