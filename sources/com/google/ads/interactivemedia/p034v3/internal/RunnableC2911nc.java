package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.nc */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC2911nc implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2915ng f8171a;

    /* renamed from: b */
    public final /* synthetic */ InterfaceC2916nh f8172b;

    /* renamed from: c */
    private final /* synthetic */ int f8173c;

    public /* synthetic */ RunnableC2911nc(C2915ng c2915ng, InterfaceC2916nh interfaceC2916nh, int i) {
        this.f8173c = i;
        this.f8171a = c2915ng;
        this.f8172b = interfaceC2916nh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f8173c;
        if (i == 0) {
            C2915ng c2915ng = this.f8171a;
            this.f8172b.mo1170c(c2915ng.f8182a, c2915ng.f8183b);
        } else if (i != 1) {
            C2915ng c2915ng2 = this.f8171a;
            this.f8172b.mo1167f(c2915ng2.f8182a, c2915ng2.f8183b);
        } else {
            C2915ng c2915ng3 = this.f8171a;
            this.f8172b.mo1171b(c2915ng3.f8182a, c2915ng3.f8183b);
        }
    }
}
