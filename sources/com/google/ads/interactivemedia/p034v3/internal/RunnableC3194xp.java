package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xp */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC3194xp implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C3202xx f9435a;

    /* renamed from: b */
    public final /* synthetic */ long f9436b;

    /* renamed from: c */
    public final /* synthetic */ int f9437c;

    /* renamed from: d */
    private final /* synthetic */ int f9438d;

    public /* synthetic */ RunnableC3194xp(C3202xx c3202xx, int i, long j, int i2) {
        this.f9438d = i2;
        this.f9435a = c3202xx;
        this.f9437c = i;
        this.f9436b = j;
    }

    public /* synthetic */ RunnableC3194xp(C3202xx c3202xx, long j, int i, int i2) {
        this.f9438d = i2;
        this.f9435a = c3202xx;
        this.f9436b = j;
        this.f9437c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9438d != 0) {
            this.f9435a.m585j(this.f9437c, this.f9436b);
        } else {
            this.f9435a.m581n(this.f9436b, this.f9437c);
        }
    }
}
