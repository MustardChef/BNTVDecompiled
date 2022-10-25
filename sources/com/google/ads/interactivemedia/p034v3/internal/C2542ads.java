package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ads */
/* loaded from: classes2.dex */
public final class C2542ads implements adg {

    /* renamed from: a */
    private final String f3500a;

    /* renamed from: b */
    private final C2621cj f3501b;

    /* renamed from: c */
    private final C2620ci f3502c;

    /* renamed from: d */
    private InterfaceC3253zu f3503d;

    /* renamed from: e */
    private String f3504e;

    /* renamed from: f */
    private C2962p f3505f;

    /* renamed from: g */
    private int f3506g;

    /* renamed from: h */
    private int f3507h;

    /* renamed from: i */
    private int f3508i;

    /* renamed from: j */
    private int f3509j;

    /* renamed from: k */
    private long f3510k;

    /* renamed from: l */
    private boolean f3511l;

    /* renamed from: m */
    private int f3512m;

    /* renamed from: n */
    private int f3513n;

    /* renamed from: o */
    private int f3514o;

    /* renamed from: p */
    private boolean f3515p;

    /* renamed from: q */
    private long f3516q;

    /* renamed from: r */
    private int f3517r;

    /* renamed from: s */
    private long f3518s;

    /* renamed from: t */
    private int f3519t;

    /* renamed from: u */
    private String f3520u;

    public C2542ads(String str) {
        this.f3500a = str;
        C2621cj c2621cj = new C2621cj(1024);
        this.f3501b = c2621cj;
        this.f3502c = new C2620ci(c2621cj.m2642H());
        this.f3510k = C3282C.TIME_UNSET;
    }

    /* renamed from: f */
    private final int m5773f(C2620ci c2620ci) throws C2555ao {
        int m2663a = c2620ci.m2663a();
        C3207yb m556b = C3208yc.m556b(c2620ci, true);
        this.f3520u = m556b.f9467c;
        this.f3517r = m556b.f9465a;
        this.f3519t = m556b.f9466b;
        return m2663a - c2620ci.m2663a();
    }

    /* renamed from: g */
    private static long m5772g(C2620ci c2620ci) {
        return c2620ci.m2661c((c2620ci.m2661c(2) + 1) * 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0153, code lost:
        if (r14.f3511l == false) goto L105;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo5771a(com.google.ads.interactivemedia.p034v3.internal.C2621cj r15) throws com.google.ads.interactivemedia.p034v3.internal.C2555ao {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2542ads.mo5771a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3503d = interfaceC3233za.mo489be(aejVar.m5731a(), 1);
        this.f3504e = aejVar.m5730b();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3510k = j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3506g = 0;
        this.f3510k = C3282C.TIME_UNSET;
        this.f3511l = false;
    }
}
