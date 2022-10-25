package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public final class BlockingIgnoringReceiver extends CountDownLatch implements Consumer<Throwable>, Action {
    public Throwable error;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable e) {
        this.error = e;
        countDown();
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        countDown();
    }
}
