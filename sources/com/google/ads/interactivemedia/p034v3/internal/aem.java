package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aem */
/* loaded from: classes2.dex */
final class aem implements Runnable {

    /* renamed from: a */
    final /* synthetic */ aen f3618a;

    /* renamed from: b */
    private boolean f3619b;

    /* renamed from: a */
    public final void m5722a() {
        if (this.f3619b) {
            return;
        }
        this.f3619b = true;
        this.f3618a.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3619b = false;
    }
}
