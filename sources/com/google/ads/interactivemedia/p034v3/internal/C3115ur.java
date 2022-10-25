package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ur */
/* loaded from: classes2.dex */
public final class C3115ur implements InterfaceC3098ua {

    /* renamed from: a */
    public final C3117ut f9106a;

    /* renamed from: b */
    final /* synthetic */ C3117ut f9107b;

    /* renamed from: c */
    private final C3096tz f9108c;

    /* renamed from: d */
    private final int f9109d;

    /* renamed from: e */
    private boolean f9110e;

    public C3115ur(C3117ut c3117ut, C3117ut c3117ut2, C3096tz c3096tz, int i) {
        this.f9107b = c3117ut;
        this.f9106a = c3117ut2;
        this.f9108c = c3096tz;
        this.f9109d = i;
    }

    /* renamed from: e */
    private final void m893e() {
        C3076tf c3076tf;
        int[] iArr;
        C2962p[] c2962pArr;
        long j;
        if (this.f9110e) {
            return;
        }
        C3117ut c3117ut = this.f9107b;
        c3076tf = c3117ut.f9118h;
        iArr = c3117ut.f9113c;
        int i = this.f9109d;
        int i2 = iArr[i];
        c2962pArr = c3117ut.f9114d;
        C2962p c2962p = c2962pArr[i];
        j = c3117ut.f9130t;
        c3076tf.m1076o(i2, c2962p, 0, j);
        this.f9110e = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: a */
    public final int mo890a(C2717fy c2717fy, C2669ed c2669ed, int i) {
        if (this.f9107b.m876n()) {
            return -3;
        }
        m893e();
        return this.f9108c.m946o(c2717fy, c2669ed, i, this.f9107b.f9112b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: b */
    public final int mo889b(long j) {
        C3117ut c3117ut = this.f9107b;
        if (c3117ut.m876n()) {
            return 0;
        }
        int m949l = this.f9108c.m949l(j, c3117ut.f9112b);
        this.f9108c.m978G(m949l);
        if (m949l > 0) {
            m893e();
        }
        return m949l;
    }

    /* renamed from: c */
    public final void m894c() {
        boolean[] zArr;
        boolean[] zArr2;
        zArr = this.f9107b.f9115e;
        C2616ce.m2685h(zArr[this.f9109d]);
        zArr2 = this.f9107b.f9115e;
        zArr2[this.f9109d] = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: d */
    public final void mo886d() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: g */
    public final boolean mo883g() {
        C3117ut c3117ut = this.f9107b;
        return !c3117ut.m876n() && this.f9108c.m974K(c3117ut.f9112b);
    }
}
