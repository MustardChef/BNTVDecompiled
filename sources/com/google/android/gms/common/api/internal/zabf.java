package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zabf implements Executor {
    private final Handler zaa;

    private zabf(Handler handler) {
        this.zaa = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor zaa(Handler handler) {
        return new zabf(handler);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zaa.post(runnable);
    }
}
