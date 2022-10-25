package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adq */
/* loaded from: classes2.dex */
public final class adq implements adg {

    /* renamed from: a */
    private final adz f3480a;

    /* renamed from: b */
    private String f3481b;

    /* renamed from: c */
    private InterfaceC3253zu f3482c;

    /* renamed from: d */
    private adp f3483d;

    /* renamed from: e */
    private boolean f3484e;

    /* renamed from: l */
    private long f3491l;

    /* renamed from: f */
    private final boolean[] f3485f = new boolean[3];

    /* renamed from: g */
    private final adu f3486g = new adu(32);

    /* renamed from: h */
    private final adu f3487h = new adu(33);

    /* renamed from: i */
    private final adu f3488i = new adu(34);

    /* renamed from: j */
    private final adu f3489j = new adu(39);

    /* renamed from: k */
    private final adu f3490k = new adu(40);

    /* renamed from: m */
    private long f3492m = C3282C.TIME_UNSET;

    /* renamed from: n */
    private final C2621cj f3493n = new C2621cj();

    public adq(adz adzVar) {
        this.f3480a = adzVar;
    }

    /* renamed from: f */
    private final void m5774f(byte[] bArr, int i, int i2) {
        this.f3483d.m5778b(bArr, i, i2);
        if (!this.f3484e) {
            this.f3486g.m5766a(bArr, i, i2);
            this.f3487h.m5766a(bArr, i, i2);
            this.f3488i.m5766a(bArr, i, i2);
        }
        this.f3489j.m5766a(bArr, i, i2);
        this.f3490k.m5766a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03c1  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo5771a(com.google.ads.interactivemedia.p034v3.internal.C2621cj r38) {
        /*
            Method dump skipped, instructions count: 987
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.adq.mo5771a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3481b = aejVar.m5730b();
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 2);
        this.f3482c = mo489be;
        this.f3483d = new adp(mo489be);
        this.f3480a.m5758b(interfaceC3233za, aejVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3492m = j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3491l = 0L;
        this.f3492m = C3282C.TIME_UNSET;
        C3245zm.m463d(this.f3485f);
        this.f3486g.m5765b();
        this.f3487h.m5765b();
        this.f3488i.m5765b();
        this.f3489j.m5765b();
        this.f3490k.m5765b();
        adp adpVar = this.f3483d;
        if (adpVar != null) {
            adpVar.m5777c();
        }
    }
}
