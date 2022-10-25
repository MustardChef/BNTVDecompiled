package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ry */
/* loaded from: classes2.dex */
public final class C3041ry implements InterfaceC3066sw, InterfaceC3065sv {

    /* renamed from: a */
    public final InterfaceC3066sw f8791a;

    /* renamed from: b */
    long f8792b;

    /* renamed from: c */
    private InterfaceC3065sv f8793c;

    /* renamed from: d */
    private C3040rx[] f8794d = new C3040rx[0];

    /* renamed from: e */
    private long f8795e = 0;

    public C3041ry(InterfaceC3066sw interfaceC3066sw, long j) {
        this.f8791a = interfaceC3066sw;
        this.f8792b = j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: a */
    public final long mo1030a(long j, C2740gu c2740gu) {
        if (j != 0) {
            long m2519o = C2628cq.m2519o(c2740gu.f7449c, 0L, j);
            long j2 = c2740gu.f7450d;
            long j3 = this.f8792b;
            long m2519o2 = C2628cq.m2519o(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
            if (m2519o != c2740gu.f7449c || m2519o2 != c2740gu.f7450d) {
                c2740gu = new C2740gu(m2519o, m2519o2);
            }
            return this.f8791a.mo1030a(j, c2740gu);
        }
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3065sv
    /* renamed from: bd */
    public final void mo1104bd(InterfaceC3066sw interfaceC3066sw) {
        InterfaceC3065sv interfaceC3065sv = this.f8793c;
        C2616ce.m2689d(interfaceC3065sv);
        interfaceC3065sv.mo1104bd(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        long mo888bg = this.f8791a.mo888bg();
        if (mo888bg != Long.MIN_VALUE) {
            long j = this.f8792b;
            if (j == Long.MIN_VALUE || mo888bg < j) {
                return mo888bg;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        long mo887c = this.f8791a.mo887c();
        if (mo887c != Long.MIN_VALUE) {
            long j = this.f8792b;
            if (j == Long.MIN_VALUE || mo887c < j) {
                return mo887c;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: d */
    public final long mo1029d() {
        if (m1179j()) {
            long j = this.f8795e;
            this.f8795e = C3282C.TIME_UNSET;
            long mo1029d = mo1029d();
            return mo1029d != C3282C.TIME_UNSET ? mo1029d : j;
        }
        long mo1029d2 = this.f8791a.mo1029d();
        if (mo1029d2 == C3282C.TIME_UNSET) {
            return C3282C.TIME_UNSET;
        }
        boolean z = false;
        C2616ce.m2685h(mo1029d2 >= 0);
        long j2 = this.f8792b;
        C2616ce.m2685h((j2 == Long.MIN_VALUE || mo1029d2 <= j2) ? true : true);
        return mo1029d2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: e */
    public final long mo1028e(long j) {
        C3040rx[] c3040rxArr;
        this.f8795e = C3282C.TIME_UNSET;
        boolean z = false;
        for (C3040rx c3040rx : this.f8794d) {
            if (c3040rx != null) {
                c3040rx.m1180c();
            }
        }
        long mo1028e = this.f8791a.mo1028e(j);
        if (mo1028e != j) {
            if (mo1028e >= 0) {
                long j2 = this.f8792b;
                if (j2 != Long.MIN_VALUE) {
                    if (mo1028e <= j2) {
                        mo1028e = 0;
                    }
                }
            }
            C2616ce.m2685h(z);
            return mo1028e;
        }
        z = true;
        C2616ce.m2685h(z);
        return mo1028e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: f */
    public final long mo1027f(InterfaceC3142vr[] interfaceC3142vrArr, boolean[] zArr, InterfaceC3098ua[] interfaceC3098uaArr, boolean[] zArr2, long j) {
        int length = interfaceC3098uaArr.length;
        this.f8794d = new C3040rx[length];
        InterfaceC3098ua[] interfaceC3098uaArr2 = new InterfaceC3098ua[length];
        int i = 0;
        while (true) {
            InterfaceC3098ua interfaceC3098ua = null;
            if (i >= interfaceC3098uaArr.length) {
                break;
            }
            C3040rx[] c3040rxArr = this.f8794d;
            C3040rx c3040rx = (C3040rx) interfaceC3098uaArr[i];
            c3040rxArr[i] = c3040rx;
            if (c3040rx != null) {
                interfaceC3098ua = c3040rx.f8788a;
            }
            interfaceC3098uaArr2[i] = interfaceC3098ua;
            i++;
        }
        long mo1027f = this.f8791a.mo1027f(interfaceC3142vrArr, zArr, interfaceC3098uaArr2, zArr2, j);
        long j2 = (m1179j() && j == 0) ? 0L : j;
        this.f8795e = C3282C.TIME_UNSET;
        boolean z = true;
        if (mo1027f != j2) {
            if (mo1027f >= 0) {
                long j3 = this.f8792b;
                if (j3 != Long.MIN_VALUE) {
                    if (mo1027f <= j3) {
                        mo1027f = 0;
                    }
                }
            }
            z = false;
        }
        C2616ce.m2685h(z);
        for (int i2 = 0; i2 < interfaceC3098uaArr.length; i2++) {
            InterfaceC3098ua interfaceC3098ua2 = interfaceC3098uaArr2[i2];
            if (interfaceC3098ua2 == null) {
                this.f8794d[i2] = null;
            } else {
                C3040rx[] c3040rxArr2 = this.f8794d;
                C3040rx c3040rx2 = c3040rxArr2[i2];
                if (c3040rx2 == null || c3040rx2.f8788a != interfaceC3098ua2) {
                    c3040rxArr2[i2] = new C3040rx(this, interfaceC3098ua2);
                }
            }
            interfaceC3098uaArr[i2] = this.f8794d[i2];
        }
        return mo1027f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3099ub
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo934g(InterfaceC3100uc interfaceC3100uc) {
        InterfaceC3066sw interfaceC3066sw = (InterfaceC3066sw) interfaceC3100uc;
        InterfaceC3065sv interfaceC3065sv = this.f8793c;
        C2616ce.m2689d(interfaceC3065sv);
        interfaceC3065sv.mo934g(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: h */
    public final C2588bd mo1025h() {
        return this.f8791a.mo1025h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: i */
    public final void mo1024i() throws IOException {
        this.f8791a.mo1024i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final boolean m1179j() {
        return this.f8795e != C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: k */
    public final void mo1022k(InterfaceC3065sv interfaceC3065sv, long j) {
        this.f8793c = interfaceC3065sv;
        this.f8791a.mo1022k(this, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
        this.f8791a.mo878l(j);
    }

    /* renamed from: m */
    public final void m1178m(long j) {
        this.f8792b = j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        return this.f8791a.mo875o(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        return this.f8791a.mo874p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: q */
    public final void mo1020q(long j) {
        this.f8791a.mo1020q(j);
    }
}
