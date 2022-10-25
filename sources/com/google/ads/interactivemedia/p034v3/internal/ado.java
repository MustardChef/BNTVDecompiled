package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ado */
/* loaded from: classes2.dex */
public final class ado implements adg {

    /* renamed from: a */
    private final adz f3452a;

    /* renamed from: b */
    private final boolean f3453b;

    /* renamed from: c */
    private final boolean f3454c;

    /* renamed from: g */
    private long f3458g;

    /* renamed from: i */
    private String f3460i;

    /* renamed from: j */
    private InterfaceC3253zu f3461j;

    /* renamed from: k */
    private adn f3462k;

    /* renamed from: l */
    private boolean f3463l;

    /* renamed from: n */
    private boolean f3465n;

    /* renamed from: h */
    private final boolean[] f3459h = new boolean[3];

    /* renamed from: d */
    private final adu f3455d = new adu(7);

    /* renamed from: e */
    private final adu f3456e = new adu(8);

    /* renamed from: f */
    private final adu f3457f = new adu(6);

    /* renamed from: m */
    private long f3464m = C3282C.TIME_UNSET;

    /* renamed from: o */
    private final C2621cj f3466o = new C2621cj();

    public ado(adz adzVar, boolean z, boolean z2) {
        this.f3452a = adzVar;
        this.f3453b = z;
        this.f3454c = z2;
    }

    /* renamed from: f */
    private final void m5780f(byte[] bArr, int i, int i2) {
        if (!this.f3463l || this.f3462k.m5781g()) {
            this.f3455d.m5766a(bArr, i, i2);
            this.f3456e.m5766a(bArr, i, i2);
        }
        this.f3457f.m5766a(bArr, i, i2);
        this.f3462k.m5787a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0175  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo5771a(com.google.ads.interactivemedia.p034v3.internal.C2621cj r20) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.ado.mo5771a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3460i = aejVar.m5730b();
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 2);
        this.f3461j = mo489be;
        this.f3462k = new adn(mo489be, this.f3453b, this.f3454c);
        this.f3452a.m5758b(interfaceC3233za, aejVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3464m = j;
        }
        this.f3465n |= (i & 2) != 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3458g = 0L;
        this.f3465n = false;
        this.f3464m = C3282C.TIME_UNSET;
        C3245zm.m463d(this.f3459h);
        this.f3455d.m5765b();
        this.f3456e.m5765b();
        this.f3457f.m5765b();
        adn adnVar = this.f3462k;
        if (adnVar != null) {
            adnVar.m5784d();
        }
    }
}
