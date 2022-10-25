package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adi */
/* loaded from: classes2.dex */
public final class adi implements adg {

    /* renamed from: a */
    private static final double[] f3375a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: b */
    private String f3376b;

    /* renamed from: c */
    private InterfaceC3253zu f3377c;

    /* renamed from: d */
    private final ael f3378d;

    /* renamed from: e */
    private final C2621cj f3379e;

    /* renamed from: f */
    private final adu f3380f;

    /* renamed from: g */
    private final boolean[] f3381g;

    /* renamed from: h */
    private final adh f3382h;

    /* renamed from: i */
    private long f3383i;

    /* renamed from: j */
    private boolean f3384j;

    /* renamed from: k */
    private boolean f3385k;

    /* renamed from: l */
    private long f3386l;

    /* renamed from: m */
    private long f3387m;

    /* renamed from: n */
    private long f3388n;

    /* renamed from: o */
    private long f3389o;

    /* renamed from: p */
    private boolean f3390p;

    /* renamed from: q */
    private boolean f3391q;

    public adi() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e1  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo5771a(com.google.ads.interactivemedia.p034v3.internal.C2621cj r20) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.adi.mo5771a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3376b = aejVar.m5730b();
        this.f3377c = interfaceC3233za.mo489be(aejVar.m5731a(), 2);
        ael aelVar = this.f3378d;
        if (aelVar != null) {
            aelVar.m5723b(interfaceC3233za, aejVar);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        this.f3387m = j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        C3245zm.m463d(this.f3381g);
        this.f3382h.m5801b();
        adu aduVar = this.f3380f;
        if (aduVar != null) {
            aduVar.m5765b();
        }
        this.f3383i = 0L;
        this.f3384j = false;
        this.f3387m = C3282C.TIME_UNSET;
        this.f3389o = C3282C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public adi(ael aelVar) {
        C2621cj c2621cj;
        this.f3378d = aelVar;
        this.f3381g = new boolean[4];
        this.f3382h = new adh();
        if (aelVar != null) {
            this.f3380f = new adu(178);
            c2621cj = new C2621cj();
        } else {
            c2621cj = null;
            this.f3380f = null;
        }
        this.f3379e = c2621cj;
        this.f3387m = C3282C.TIME_UNSET;
        this.f3389o = C3282C.TIME_UNSET;
    }
}
