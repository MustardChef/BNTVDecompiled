package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ObservableBlockingSubscribe {
    private ObservableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> void subscribe(io.reactivex.rxjava3.core.ObservableSource<? extends T> r3, io.reactivex.rxjava3.core.Observer<? super T> r4) {
        /*
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            io.reactivex.rxjava3.internal.observers.BlockingObserver r1 = new io.reactivex.rxjava3.internal.observers.BlockingObserver
            r1.<init>(r0)
            r4.onSubscribe(r1)
            r3.subscribe(r1)
        L10:
            boolean r3 = r1.isDisposed()
            if (r3 == 0) goto L17
            goto L3a
        L17:
            java.lang.Object r3 = r0.poll()
            if (r3 != 0) goto L2a
            java.lang.Object r3 = r0.take()     // Catch: java.lang.InterruptedException -> L22
            goto L2a
        L22:
            r3 = move-exception
            r1.dispose()
            r4.onError(r3)
            return
        L2a:
            boolean r2 = r1.isDisposed()
            if (r2 != 0) goto L3a
            java.lang.Object r2 = io.reactivex.rxjava3.internal.observers.BlockingObserver.TERMINATED
            if (r3 == r2) goto L3a
            boolean r3 = io.reactivex.rxjava3.internal.util.NotificationLite.acceptFull(r3, r4)
            if (r3 == 0) goto L10
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBlockingSubscribe.subscribe(io.reactivex.rxjava3.core.ObservableSource, io.reactivex.rxjava3.core.Observer):void");
    }

    public static <T> void subscribe(ObservableSource<? extends T> o) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.emptyConsumer());
        o.subscribe(lambdaObserver);
        BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaObserver);
        Throwable th = blockingIgnoringReceiver.error;
        if (th != null) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static <T> void subscribe(ObservableSource<? extends T> o, final Consumer<? super T> onNext, final Consumer<? super Throwable> onError, final Action onComplete) {
        Objects.requireNonNull(onNext, "onNext is null");
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        subscribe(o, new LambdaObserver(onNext, onError, onComplete, Functions.emptyConsumer()));
    }
}
