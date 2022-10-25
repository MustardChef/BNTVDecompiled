package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xs */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC3197xs implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C3202xx f9444a;

    /* renamed from: b */
    public final /* synthetic */ C2679en f9445b;

    /* renamed from: c */
    private final /* synthetic */ int f9446c;

    public /* synthetic */ RunnableC3197xs(C3202xx c3202xx, C2679en c2679en, int i) {
        this.f9446c = i;
        this.f9444a = c3202xx;
        this.f9445b = c2679en;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9446c != 0) {
            this.f9444a.m586i(this.f9445b);
        } else {
            this.f9444a.m584k(this.f9445b);
        }
    }
}
