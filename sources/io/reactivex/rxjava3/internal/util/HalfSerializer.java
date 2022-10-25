package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean onNext(Subscriber<? super T> subscriber, T value, AtomicInteger wip, AtomicThrowable errors) {
        if (wip.get() == 0 && wip.compareAndSet(0, 1)) {
            subscriber.onNext(value);
            if (wip.decrementAndGet() == 0) {
                return true;
            }
            errors.tryTerminateConsumer(subscriber);
        }
        return false;
    }

    public static void onError(Subscriber<?> subscriber, Throwable ex, AtomicInteger wip, AtomicThrowable errors) {
        if (errors.tryAddThrowableOrReport(ex) && wip.getAndIncrement() == 0) {
            errors.tryTerminateConsumer(subscriber);
        }
    }

    public static void onComplete(Subscriber<?> subscriber, AtomicInteger wip, AtomicThrowable errors) {
        if (wip.getAndIncrement() == 0) {
            errors.tryTerminateConsumer(subscriber);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(Observer<? super T> observer, T value, AtomicInteger wip, AtomicThrowable errors) {
        if (wip.get() == 0 && wip.compareAndSet(0, 1)) {
            observer.onNext(value);
            if (wip.decrementAndGet() != 0) {
                errors.tryTerminateConsumer(observer);
            }
        }
    }

    public static void onError(Observer<?> observer, Throwable ex, AtomicInteger wip, AtomicThrowable errors) {
        if (errors.tryAddThrowableOrReport(ex) && wip.getAndIncrement() == 0) {
            errors.tryTerminateConsumer(observer);
        }
    }

    public static void onComplete(Observer<?> observer, AtomicInteger wip, AtomicThrowable errors) {
        if (wip.getAndIncrement() == 0) {
            errors.tryTerminateConsumer(observer);
        }
    }
}
