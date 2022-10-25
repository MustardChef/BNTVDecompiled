package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ant */
/* loaded from: classes2.dex */
final class ant implements ThreadFactory {

    /* renamed from: a */
    private final ThreadFactory f4735a = Executors.defaultThreadFactory();

    /* renamed from: b */
    private final AtomicInteger f4736b = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f4735a.newThread(runnable);
        int andIncrement = this.f4736b.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
