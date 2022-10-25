package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ada */
/* loaded from: classes2.dex */
public final class ada implements adg {

    /* renamed from: a */
    private final C2620ci f3305a;

    /* renamed from: b */
    private final C2621cj f3306b;

    /* renamed from: c */
    private final String f3307c;

    /* renamed from: d */
    private String f3308d;

    /* renamed from: e */
    private InterfaceC3253zu f3309e;

    /* renamed from: f */
    private int f3310f;

    /* renamed from: g */
    private int f3311g;

    /* renamed from: h */
    private boolean f3312h;

    /* renamed from: i */
    private boolean f3313i;

    /* renamed from: j */
    private long f3314j;

    /* renamed from: k */
    private C2962p f3315k;

    /* renamed from: l */
    private int f3316l;

    /* renamed from: m */
    private long f3317m;

    public ada() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo5771a(com.google.ads.interactivemedia.p034v3.internal.C2621cj r11) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.ada.mo5771a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3308d = aejVar.m5730b();
        this.f3309e = interfaceC3233za.mo489be(aejVar.m5731a(), 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3317m = j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3310f = 0;
        this.f3311g = 0;
        this.f3312h = false;
        this.f3313i = false;
        this.f3317m = C3282C.TIME_UNSET;
    }

    public ada(String str) {
        C2620ci c2620ci = new C2620ci(new byte[16]);
        this.f3305a = c2620ci;
        this.f3306b = new C2621cj(c2620ci.f6942a);
        this.f3310f = 0;
        this.f3311g = 0;
        this.f3312h = false;
        this.f3313i = false;
        this.f3317m = C3282C.TIME_UNSET;
        this.f3307c = str;
    }
}
