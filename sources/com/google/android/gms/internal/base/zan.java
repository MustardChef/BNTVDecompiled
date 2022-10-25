package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes.dex */
final class zan implements zal {
    private zan() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zan(zam zamVar) {
    }

    @Override // com.google.android.gms.internal.base.zal
    public final ExecutorService zaa(int i, int i2) {
        return zab(4, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.base.zal
    public final ExecutorService zab(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.base.zal
    public final ExecutorService zac(ThreadFactory threadFactory, int i) {
        return zab(1, threadFactory, 1);
    }
}
