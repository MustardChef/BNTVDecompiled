package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tt */
/* loaded from: classes2.dex */
public final class C3090tt extends AbstractC3037ru implements InterfaceC3082tl {

    /* renamed from: a */
    private final C2543ae f8978a;

    /* renamed from: b */
    private final C2537aa f8979b;

    /* renamed from: c */
    private final InterfaceC2636cy f8980c;

    /* renamed from: d */
    private final InterfaceC2921nm f8981d;

    /* renamed from: e */
    private final int f8982e;

    /* renamed from: f */
    private boolean f8983f;

    /* renamed from: g */
    private long f8984g;

    /* renamed from: h */
    private boolean f8985h;

    /* renamed from: i */
    private boolean f8986i;

    /* renamed from: j */
    private InterfaceC2659du f8987j;

    /* renamed from: k */
    private final C3088tr f8988k;

    /* renamed from: l */
    private final C3161wj f8989l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C3090tt(C2543ae c2543ae, InterfaceC2636cy interfaceC2636cy, C3088tr c3088tr, InterfaceC2921nm interfaceC2921nm, C3161wj c3161wj, int i, byte[] bArr) {
        C2537aa c2537aa = c2543ae.f3562b;
        C2616ce.m2689d(c2537aa);
        this.f8979b = c2537aa;
        this.f8978a = c2543ae;
        this.f8980c = interfaceC2636cy;
        this.f8988k = c3088tr;
        this.f8981d = interfaceC2921nm;
        this.f8989l = c3161wj;
        this.f8982e = i;
        this.f8983f = true;
        this.f8984g = C3282C.TIME_UNSET;
    }

    /* renamed from: c */
    private final void m1009c() {
        long j = this.f8984g;
        boolean z = this.f8985h;
        boolean z2 = this.f8986i;
        C2543ae c2543ae = this.f8978a;
        C3102ue c3102ue = new C3102ue(C3282C.TIME_UNSET, C3282C.TIME_UNSET, j, j, 0L, 0L, z, false, false, null, c2543ae, z2 ? c2543ae.f3563c : null);
        m1187F(this.f8983f ? new C3087tq(c3102ue) : c3102ue);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: a */
    public final C2543ae mo1011a() {
        return this.f8978a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3082tl
    /* renamed from: b */
    public final void mo1010b(long j, boolean z, boolean z2) {
        if (j == C3282C.TIME_UNSET) {
            j = this.f8984g;
        }
        if (!this.f8983f && this.f8984g == j && this.f8985h == z && this.f8986i == z2) {
            return;
        }
        this.f8984g = j;
        this.f8985h = z;
        this.f8986i = z2;
        this.f8983f = false;
        m1009c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: h */
    public final void mo1008h() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: n */
    protected final void mo1007n(InterfaceC2659du interfaceC2659du) {
        this.f8987j = interfaceC2659du;
        this.f8981d.mo1584o();
        m1009c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: o */
    public final void mo1006o(InterfaceC3066sw interfaceC3066sw) {
        ((C3086tp) interfaceC3066sw).m1043H();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: p */
    protected final void mo1005p() {
        this.f8981d.mo1583p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: q */
    public final InterfaceC3066sw mo1004q(C3067sx c3067sx, C3154wc c3154wc, long j) {
        C2644df m2483a = ((C2645dg) this.f8980c).m2483a();
        InterfaceC2659du interfaceC2659du = this.f8987j;
        if (interfaceC2659du != null) {
            m2483a.mo1123f(interfaceC2659du);
        }
        return new C3086tp(this.f8979b.f2863a, m2483a, new C3039rw(this.f8988k.f8972a), this.f8981d, m1184u(c3067sx), this.f8989l, m1182w(c3067sx), this, c3154wc, this.f8982e, null);
    }
}
