package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abu */
/* loaded from: classes2.dex */
final class abu {

    /* renamed from: a */
    public final int f3108a;

    /* renamed from: b */
    public int f3109b;

    /* renamed from: c */
    public int f3110c;

    /* renamed from: d */
    public long f3111d;

    /* renamed from: e */
    private final boolean f3112e;

    /* renamed from: f */
    private final C2621cj f3113f;

    /* renamed from: g */
    private final C2621cj f3114g;

    /* renamed from: h */
    private int f3115h;

    /* renamed from: i */
    private int f3116i;

    public abu(C2621cj c2621cj, C2621cj c2621cj2, boolean z) throws C2555ao {
        this.f3114g = c2621cj;
        this.f3113f = c2621cj2;
        this.f3112e = z;
        c2621cj2.m2644F(12);
        this.f3108a = c2621cj2.m2630l();
        c2621cj.m2644F(12);
        this.f3116i = c2621cj.m2630l();
        C2539ab.m5956h(c2621cj.m2637e() == 1, "first_chunk must be 1");
        this.f3109b = -1;
    }

    /* renamed from: a */
    public final boolean m5886a() {
        int i = this.f3109b + 1;
        this.f3109b = i;
        if (i == this.f3108a) {
            return false;
        }
        this.f3111d = this.f3112e ? this.f3113f.m2625q() : this.f3113f.m2626p();
        if (this.f3109b == this.f3115h) {
            this.f3110c = this.f3114g.m2630l();
            this.f3114g.m2643G(4);
            int i2 = this.f3116i - 1;
            this.f3116i = i2;
            this.f3115h = i2 > 0 ? (-1) + this.f3114g.m2630l() : -1;
        }
        return true;
    }
}
