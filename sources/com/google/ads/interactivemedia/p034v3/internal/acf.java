package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acf */
/* loaded from: classes2.dex */
public final class acf {

    /* renamed from: a */
    public final InterfaceC3253zu f3146a;

    /* renamed from: d */
    public acs f3149d;

    /* renamed from: e */
    public acb f3150e;

    /* renamed from: f */
    public int f3151f;

    /* renamed from: g */
    public int f3152g;

    /* renamed from: h */
    public int f3153h;

    /* renamed from: i */
    public int f3154i;

    /* renamed from: l */
    private boolean f3157l;

    /* renamed from: b */
    public final acr f3147b = new acr();

    /* renamed from: c */
    public final C2621cj f3148c = new C2621cj();

    /* renamed from: j */
    private final C2621cj f3155j = new C2621cj(1);

    /* renamed from: k */
    private final C2621cj f3156k = new C2621cj();

    public acf(InterfaceC3253zu interfaceC3253zu, acs acsVar, acb acbVar) {
        this.f3146a = interfaceC3253zu;
        this.f3149d = acsVar;
        this.f3150e = acbVar;
        m5860g(acsVar, acbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* bridge */ /* synthetic */ boolean m5858i(acf acfVar) {
        return acfVar.f3157l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* bridge */ /* synthetic */ void m5856k(acf acfVar) {
        acfVar.f3157l = true;
    }

    /* renamed from: a */
    public final int m5866a() {
        int i;
        if (this.f3157l) {
            i = this.f3147b.f3255j[this.f3151f] ? 1 : 0;
        } else {
            i = this.f3149d.f3269g[this.f3151f];
        }
        return m5861f() != null ? i | 1073741824 : i;
    }

    /* renamed from: b */
    public final int m5865b() {
        return !this.f3157l ? this.f3149d.f3266d[this.f3151f] : this.f3147b.f3253h[this.f3151f];
    }

    /* renamed from: c */
    public final int m5864c(int i, int i2) {
        C2621cj c2621cj;
        acq m5861f = m5861f();
        if (m5861f == null) {
            return 0;
        }
        int i3 = m5861f.f3244d;
        if (i3 != 0) {
            c2621cj = this.f3147b.f3259n;
        } else {
            byte[] bArr = (byte[]) C2628cq.m2578E(m5861f.f3245e);
            C2621cj c2621cj2 = this.f3156k;
            int length = bArr.length;
            c2621cj2.m2646D(bArr, length);
            c2621cj = this.f3156k;
            i3 = length;
        }
        boolean m5823c = this.f3147b.m5823c(this.f3151f);
        boolean z = m5823c || i2 != 0;
        C2621cj c2621cj3 = this.f3155j;
        c2621cj3.m2642H()[0] = (byte) ((true != z ? 0 : 128) | i3);
        c2621cj3.m2644F(0);
        this.f3146a.mo439i(this.f3155j, 1);
        this.f3146a.mo439i(c2621cj, i3);
        if (z) {
            if (!m5823c) {
                this.f3148c.m2648B(8);
                C2621cj c2621cj4 = this.f3148c;
                byte[] m2642H = c2621cj4.m2642H();
                m2642H[0] = 0;
                m2642H[1] = 1;
                m2642H[2] = 0;
                m2642H[3] = (byte) i2;
                m2642H[4] = (byte) ((i >> 24) & 255);
                m2642H[5] = (byte) ((i >> 16) & 255);
                m2642H[6] = (byte) ((i >> 8) & 255);
                m2642H[7] = (byte) (i & 255);
                this.f3146a.mo439i(c2621cj4, 8);
                return i3 + 9;
            }
            C2621cj c2621cj5 = this.f3147b.f3259n;
            int m2629m = c2621cj5.m2629m();
            c2621cj5.m2643G(-2);
            int i4 = (m2629m * 6) + 2;
            if (i2 != 0) {
                this.f3148c.m2648B(i4);
                byte[] m2642H2 = this.f3148c.m2642H();
                c2621cj5.m2649A(m2642H2, 0, i4);
                int i5 = (((m2642H2[2] & 255) << 8) | (m2642H2[3] & 255)) + i2;
                m2642H2[2] = (byte) ((i5 >> 8) & 255);
                m2642H2[3] = (byte) (i5 & 255);
                c2621cj5 = this.f3148c;
            }
            this.f3146a.mo439i(c2621cj5, i4);
            return i3 + 1 + i4;
        }
        return i3 + 1;
    }

    /* renamed from: d */
    public final long m5863d() {
        return !this.f3157l ? this.f3149d.f3265c[this.f3151f] : this.f3147b.f3251f[this.f3153h];
    }

    /* renamed from: e */
    public final long m5862e() {
        return !this.f3157l ? this.f3149d.f3268f[this.f3151f] : this.f3147b.m5825a(this.f3151f);
    }

    /* renamed from: f */
    public final acq m5861f() {
        if (this.f3157l) {
            acr acrVar = this.f3147b;
            acb acbVar = acrVar.f3246a;
            int i = C2628cq.f6961a;
            int i2 = acbVar.f3133a;
            acq acqVar = acrVar.f3258m;
            if (acqVar == null) {
                acqVar = this.f3149d.f3263a.m5826a(i2);
            }
            if (acqVar == null || !acqVar.f3241a) {
                return null;
            }
            return acqVar;
        }
        return null;
    }

    /* renamed from: g */
    public final void m5860g(acs acsVar, acb acbVar) {
        this.f3149d = acsVar;
        this.f3150e = acbVar;
        this.f3146a.mo443b(acsVar.f3263a.f3235f);
        m5859h();
    }

    /* renamed from: h */
    public final void m5859h() {
        acr acrVar = this.f3147b;
        acrVar.f3249d = 0;
        acrVar.f3261p = 0L;
        acrVar.f3262q = false;
        acrVar.f3256k = false;
        acrVar.f3260o = false;
        acrVar.f3258m = null;
        this.f3151f = 0;
        this.f3153h = 0;
        this.f3152g = 0;
        this.f3154i = 0;
        this.f3157l = false;
    }

    /* renamed from: j */
    public final boolean m5857j() {
        this.f3151f++;
        if (this.f3157l) {
            int i = this.f3152g + 1;
            this.f3152g = i;
            int[] iArr = this.f3147b.f3252g;
            int i2 = this.f3153h;
            if (i == iArr[i2]) {
                this.f3153h = i2 + 1;
                this.f3152g = 0;
                return false;
            }
            return true;
        }
        return false;
    }
}
