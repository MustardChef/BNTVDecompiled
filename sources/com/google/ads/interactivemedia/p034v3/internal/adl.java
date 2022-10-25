package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adl */
/* loaded from: classes2.dex */
public final class adl implements adg {

    /* renamed from: a */
    private static final float[] f3406a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: b */
    private final ael f3407b;

    /* renamed from: c */
    private final C2621cj f3408c;

    /* renamed from: d */
    private final boolean[] f3409d;

    /* renamed from: e */
    private final adj f3410e;

    /* renamed from: f */
    private final adu f3411f;

    /* renamed from: g */
    private adk f3412g;

    /* renamed from: h */
    private long f3413h;

    /* renamed from: i */
    private String f3414i;

    /* renamed from: j */
    private InterfaceC3253zu f3415j;

    /* renamed from: k */
    private boolean f3416k;

    /* renamed from: l */
    private long f3417l;

    public adl() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01cd A[SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo5771a(com.google.ads.interactivemedia.p034v3.internal.C2621cj r19) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.adl.mo5771a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3414i = aejVar.m5730b();
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 2);
        this.f3415j = mo489be;
        this.f3412g = new adk(mo489be);
        this.f3407b.m5723b(interfaceC3233za, aejVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3417l = j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        C3245zm.m463d(this.f3409d);
        this.f3410e.m5798b();
        adk adkVar = this.f3412g;
        if (adkVar != null) {
            adkVar.m5793d();
        }
        this.f3411f.m5765b();
        this.f3413h = 0L;
        this.f3417l = C3282C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public adl(ael aelVar) {
        this.f3407b = aelVar;
        this.f3409d = new boolean[4];
        this.f3410e = new adj();
        this.f3417l = C3282C.TIME_UNSET;
        this.f3411f = new adu(178);
        this.f3408c = new C2621cj();
    }
}
