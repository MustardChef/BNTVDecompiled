package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Delayed;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayd */
/* loaded from: classes2.dex */
public final class ayd extends ayc implements ScheduledFuture, ayq {

    /* renamed from: a */
    private final ayq f5293a;

    /* renamed from: b */
    private final ScheduledFuture f5294b;

    protected ayd(ayq ayqVar) {
        super(null);
        this.f5293a = ayqVar;
    }

    public ayd(ayq ayqVar, ScheduledFuture scheduledFuture) {
        this(ayqVar);
        this.f5294b = scheduledFuture;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayc, com.google.ads.interactivemedia.p034v3.internal.aup
    /* renamed from: a */
    protected final /* synthetic */ Object mo4337a() {
        return this.f5293a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayc
    /* renamed from: b */
    protected final ayq mo4336b() {
        return this.f5293a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.ayc
    /* renamed from: c */
    public final /* synthetic */ Future mo4335c() {
        return this.f5293a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayc, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = mo4335c().cancel(z);
        if (cancel) {
            this.f5294b.cancel(z);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.f5294b.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f5294b.getDelay(timeUnit);
    }
}
