package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayt */
/* loaded from: classes2.dex */
public final class ayt extends axp implements ScheduledExecutorService, ayr {

    /* renamed from: a */
    final ScheduledExecutorService f5308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ayt(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        atm.m4612j(scheduledExecutorService);
        this.f5308a = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ayx m4303r = ayx.m4303r(runnable, null);
        return new ayd(m4303r, this.f5308a.schedule(m4303r, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ays aysVar = new ays(runnable);
        return new ayd(aysVar, this.f5308a.scheduleAtFixedRate(aysVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ays aysVar = new ays(runnable);
        return new ayd(aysVar, this.f5308a.scheduleWithFixedDelay(aysVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        ayx m4304q = ayx.m4304q(callable);
        return new ayd(m4304q, this.f5308a.schedule(m4304q, j, timeUnit));
    }
}
