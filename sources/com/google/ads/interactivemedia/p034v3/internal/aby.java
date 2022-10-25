package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aby */
/* loaded from: classes2.dex */
final class aby implements abv {

    /* renamed from: a */
    private final C2621cj f3124a;

    /* renamed from: b */
    private final int f3125b;

    /* renamed from: c */
    private final int f3126c;

    /* renamed from: d */
    private int f3127d;

    /* renamed from: e */
    private int f3128e;

    public aby(abs absVar) {
        C2621cj c2621cj = absVar.f3106a;
        this.f3124a = c2621cj;
        c2621cj.m2644F(12);
        this.f3126c = c2621cj.m2630l() & 255;
        this.f3125b = c2621cj.m2630l();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abv
    /* renamed from: a */
    public final int mo5885a() {
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abv
    /* renamed from: b */
    public final int mo5884b() {
        return this.f3125b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abv
    /* renamed from: c */
    public final int mo5883c() {
        int i = this.f3126c;
        if (i == 8) {
            return this.f3124a.m2633i();
        }
        if (i == 16) {
            return this.f3124a.m2629m();
        }
        int i2 = this.f3127d;
        this.f3127d = i2 + 1;
        if (i2 % 2 == 0) {
            int m2633i = this.f3124a.m2633i();
            this.f3128e = m2633i;
            return (m2633i & 240) >> 4;
        }
        return this.f3128e & 15;
    }
}
