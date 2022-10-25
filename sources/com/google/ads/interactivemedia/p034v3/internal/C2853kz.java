package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kz */
/* loaded from: classes2.dex */
public final class C2853kz {

    /* renamed from: a */
    final InterfaceC3113up f7949a;

    /* renamed from: b */
    public final AbstractC2874lt f7950b;

    /* renamed from: c */
    public final C2863li f7951c;

    /* renamed from: d */
    public final InterfaceC2850kw f7952d;

    /* renamed from: e */
    private final long f7953e;

    /* renamed from: f */
    private final long f7954f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2853kz(long j, AbstractC2874lt abstractC2874lt, C2863li c2863li, InterfaceC3113up interfaceC3113up, long j2, InterfaceC2850kw interfaceC2850kw) {
        this.f7953e = j;
        this.f7950b = abstractC2874lt;
        this.f7951c = c2863li;
        this.f7954f = j2;
        this.f7949a = interfaceC3113up;
        this.f7952d = interfaceC2850kw;
    }

    /* renamed from: b */
    public final long m1748b(long j) {
        return this.f7952d.mo1658c(this.f7953e, j) + this.f7954f;
    }

    /* renamed from: c */
    public final long m1747c() {
        return this.f7952d.mo1657d() + this.f7954f;
    }

    /* renamed from: d */
    public final long m1746d(long j) {
        return (m1748b(j) + this.f7952d.mo1660a(this.f7953e, j)) - 1;
    }

    /* renamed from: e */
    public final long m1745e() {
        return this.f7952d.mo1655f(this.f7953e);
    }

    /* renamed from: f */
    public final long m1744f(long j) {
        return m1742h(j) + this.f7952d.mo1659b(j - this.f7954f, this.f7953e);
    }

    /* renamed from: g */
    public final long m1743g(long j) {
        return this.f7952d.mo1654g(j, this.f7953e) + this.f7954f;
    }

    /* renamed from: h */
    public final long m1742h(long j) {
        return this.f7952d.mo1653h(j - this.f7954f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final C2853kz m1741i(long j, AbstractC2874lt abstractC2874lt) throws C3038rv {
        long mo1654g;
        InterfaceC2850kw mo1675k = this.f7950b.mo1675k();
        InterfaceC2850kw mo1675k2 = abstractC2874lt.mo1675k();
        if (mo1675k == null) {
            return new C2853kz(j, abstractC2874lt, this.f7951c, this.f7949a, this.f7954f, null);
        }
        if (mo1675k.mo1651j()) {
            long mo1655f = mo1675k.mo1655f(j);
            if (mo1655f == 0) {
                return new C2853kz(j, abstractC2874lt, this.f7951c, this.f7949a, this.f7954f, mo1675k2);
            }
            long mo1657d = mo1675k.mo1657d();
            long mo1653h = mo1675k.mo1653h(mo1657d);
            long j2 = (mo1655f + mo1657d) - 1;
            long mo1653h2 = mo1675k.mo1653h(j2) + mo1675k.mo1659b(j2, j);
            long mo1657d2 = mo1675k2.mo1657d();
            long mo1653h3 = mo1675k2.mo1653h(mo1657d2);
            long j3 = this.f7954f;
            int i = (mo1653h2 > mo1653h3 ? 1 : (mo1653h2 == mo1653h3 ? 0 : -1));
            if (i == 0) {
                mo1654g = j3 + ((j2 + 1) - mo1657d2);
            } else if (i < 0) {
                throw new C3038rv();
            } else {
                if (mo1653h3 < mo1653h) {
                    mo1654g = j3 - (mo1675k2.mo1654g(mo1653h, j) - mo1657d);
                } else {
                    mo1654g = j3 + (mo1675k.mo1654g(mo1653h3, j) - mo1657d2);
                }
            }
            return new C2853kz(j, abstractC2874lt, this.f7951c, this.f7949a, mo1654g, mo1675k2);
        }
        return new C2853kz(j, abstractC2874lt, this.f7951c, this.f7949a, this.f7954f, mo1675k2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final C2853kz m1740j(InterfaceC2850kw interfaceC2850kw) {
        return new C2853kz(this.f7953e, this.f7950b, this.f7951c, this.f7949a, this.f7954f, interfaceC2850kw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final C2853kz m1739k(C2863li c2863li) {
        return new C2853kz(this.f7953e, this.f7950b, c2863li, this.f7949a, this.f7954f, this.f7952d);
    }

    /* renamed from: l */
    public final C2871lq m1738l(long j) {
        return this.f7952d.mo1652i(j - this.f7954f);
    }

    /* renamed from: m */
    public final boolean m1737m(long j, long j2) {
        return this.f7952d.mo1651j() || j2 == C3282C.TIME_UNSET || m1744f(j) <= j2;
    }
}
