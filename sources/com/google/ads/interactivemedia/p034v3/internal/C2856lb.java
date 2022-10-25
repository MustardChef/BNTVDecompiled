package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lb */
/* loaded from: classes2.dex */
public final class C2856lb implements InterfaceC2836ki {

    /* renamed from: a */
    protected final C2853kz[] f7960a;

    /* renamed from: b */
    private final InterfaceC3168wq f7961b;

    /* renamed from: c */
    private final C2835kh f7962c;

    /* renamed from: d */
    private final int[] f7963d;

    /* renamed from: e */
    private final int f7964e;

    /* renamed from: f */
    private final InterfaceC2637cz f7965f;

    /* renamed from: g */
    private final long f7966g;

    /* renamed from: h */
    private final C2860lf f7967h;

    /* renamed from: i */
    private InterfaceC3142vr f7968i;

    /* renamed from: j */
    private C2864lj f7969j;

    /* renamed from: k */
    private int f7970k;

    /* renamed from: l */
    private IOException f7971l;

    /* renamed from: m */
    private boolean f7972m;

    public C2856lb(InterfaceC3168wq interfaceC3168wq, C2864lj c2864lj, C2835kh c2835kh, int i, int[] iArr, InterfaceC3142vr interfaceC3142vr, int i2, InterfaceC2637cz interfaceC2637cz, long j, boolean z, List list, C2860lf c2860lf) {
        InterfaceC3229yx acgVar;
        this.f7961b = interfaceC3168wq;
        this.f7969j = c2864lj;
        this.f7962c = c2835kh;
        this.f7963d = iArr;
        this.f7968i = interfaceC3142vr;
        this.f7964e = i2;
        this.f7965f = interfaceC2637cz;
        this.f7970k = i;
        this.f7966g = j;
        this.f7967h = c2860lf;
        long m1710c = c2864lj.m1710c(i);
        ArrayList m1729m = m1729m();
        this.f7960a = new C2853kz[interfaceC3142vr.mo836d()];
        int i3 = 0;
        int i4 = 0;
        while (i4 < this.f7960a.length) {
            AbstractC2874lt abstractC2874lt = (AbstractC2874lt) m1729m.get(interfaceC3142vr.mo839a(i4));
            C2863li m1791b = c2835kh.m1791b(abstractC2874lt.f8058c);
            C2853kz[] c2853kzArr = this.f7960a;
            C2863li c2863li = m1791b == null ? (C2863li) abstractC2874lt.f8058c.get(i3) : m1791b;
            C2962p c2962p = abstractC2874lt.f8057b;
            String str = c2962p.f8371k;
            C3111un c3111un = null;
            if (C2554an.m4961p(str)) {
                if (MimeTypes.APPLICATION_RAWCC.equals(str)) {
                    acgVar = new act(c2962p);
                } else {
                    int i5 = i4;
                    c2853kzArr[i5] = new C2853kz(m1710c, abstractC2874lt, c2863li, c3111un, 0L, abstractC2874lt.mo1675k());
                    i4 = i5 + 1;
                    i3 = 0;
                }
            } else if (C2554an.m4962o(str)) {
                acgVar = new abg(1);
            } else {
                acgVar = new acg(true != z ? 0 : 4, null, list, c2860lf);
                c3111un = new C3111un(acgVar, i2, c2962p);
                int i52 = i4;
                c2853kzArr[i52] = new C2853kz(m1710c, abstractC2874lt, c2863li, c3111un, 0L, abstractC2874lt.mo1675k());
                i4 = i52 + 1;
                i3 = 0;
            }
            c3111un = new C3111un(acgVar, i2, c2962p);
            int i522 = i4;
            c2853kzArr[i522] = new C2853kz(m1710c, abstractC2874lt, c2863li, c3111un, 0L, abstractC2874lt.mo1675k());
            i4 = i522 + 1;
            i3 = 0;
        }
    }

    /* renamed from: k */
    private final long m1731k(long j) {
        C2864lj c2864lj = this.f7969j;
        long j2 = c2864lj.f8008a;
        return j2 == C3282C.TIME_UNSET ? C3282C.TIME_UNSET : j - C2628cq.m2515s(j2 + c2864lj.m1709d(this.f7970k).f8041b);
    }

    /* renamed from: l */
    private final C2853kz m1730l(int i) {
        C2853kz c2853kz = this.f7960a[i];
        C2863li m1791b = this.f7962c.m1791b(c2853kz.f7950b.f8058c);
        if (m1791b == null || m1791b.equals(c2853kz.f7951c)) {
            return c2853kz;
        }
        C2853kz m1739k = c2853kz.m1739k(m1791b);
        this.f7960a[i] = m1739k;
        return m1739k;
    }

    /* renamed from: m */
    private final ArrayList m1729m() {
        List list = this.f7969j.m1709d(this.f7970k).f8042c;
        ArrayList arrayList = new ArrayList();
        for (int i : this.f7963d) {
            arrayList.addAll(((C2862lh) list.get(i)).f8000c);
        }
        return arrayList;
    }

    /* renamed from: n */
    private static final long m1728n(C2853kz c2853kz, AbstractC3122uy abstractC3122uy, long j, long j2, long j3) {
        if (abstractC3122uy != null) {
            return abstractC3122uy.mo853s();
        }
        return C2628cq.m2519o(c2853kz.m1743g(j), j2, j3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2836ki
    /* renamed from: a */
    public final void mo1733a(C2864lj c2864lj, int i) {
        try {
            this.f7969j = c2864lj;
            this.f7970k = i;
            long m1710c = c2864lj.m1710c(i);
            ArrayList m1729m = m1729m();
            for (int i2 = 0; i2 < this.f7960a.length; i2++) {
                C2853kz[] c2853kzArr = this.f7960a;
                c2853kzArr[i2] = c2853kzArr[i2].m1741i(m1710c, (AbstractC2874lt) m1729m.get(this.f7968i.mo839a(i2)));
            }
        } catch (C3038rv e) {
            this.f7971l = e;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2836ki
    /* renamed from: b */
    public final void mo1732b(InterfaceC3142vr interfaceC3142vr) {
        this.f7968i = interfaceC3142vr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: c */
    public final int mo864c(long j, List list) {
        if (this.f7971l != null || this.f7968i.mo836d() < 2) {
            return list.size();
        }
        return this.f7968i.mo806k(j, list);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: d */
    public final long mo863d(long j, C2740gu c2740gu) {
        C2853kz[] c2853kzArr;
        for (C2853kz c2853kz : this.f7960a) {
            if (c2853kz.f7952d != null) {
                long m1743g = c2853kz.m1743g(j);
                long m1742h = c2853kz.m1742h(m1743g);
                long m1745e = c2853kz.m1745e();
                return c2740gu.m2169a(j, m1742h, (m1742h >= j || (m1745e != -1 && m1743g >= (c2853kz.m1747c() + m1745e) + (-1))) ? m1742h : c2853kz.m1742h(m1743g + 1));
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: e */
    public final void mo862e(long j, long j2, List list, C3114uq c3114uq) {
        long j3;
        long j4;
        AbstractC3112uo c3119uv;
        long j5;
        int i;
        InterfaceC3125va[] interfaceC3125vaArr;
        int i2;
        if (this.f7971l != null) {
            return;
        }
        long j6 = j2 - j;
        C2864lj c2864lj = this.f7969j;
        long m2515s = C2628cq.m2515s(c2864lj.f8008a) + C2628cq.m2515s(c2864lj.m1709d(this.f7970k).f8041b) + j2;
        C2860lf c2860lf = this.f7967h;
        if (c2860lf == null || !c2860lf.f7983a.m1716f(m2515s)) {
            long m2515s2 = C2628cq.m2515s(C2628cq.m2517q(this.f7966g));
            long m1731k = m1731k(m2515s2);
            AbstractC3122uy abstractC3122uy = list.isEmpty() ? null : (AbstractC3122uy) list.get(list.size() - 1);
            int d = this.f7968i.mo836d();
            InterfaceC3125va[] interfaceC3125vaArr2 = new InterfaceC3125va[d];
            int i3 = 0;
            while (i3 < d) {
                C2853kz c2853kz = this.f7960a[i3];
                if (c2853kz.f7952d == null) {
                    interfaceC3125vaArr2[i3] = InterfaceC3125va.f9147a;
                    interfaceC3125vaArr = interfaceC3125vaArr2;
                    i2 = d;
                    j5 = m1731k;
                    i = i3;
                } else {
                    long m1748b = c2853kz.m1748b(m2515s2);
                    long m1746d = c2853kz.m1746d(m2515s2);
                    j5 = m1731k;
                    i = i3;
                    interfaceC3125vaArr = interfaceC3125vaArr2;
                    i2 = d;
                    long m1728n = m1728n(c2853kz, abstractC3122uy, j2, m1748b, m1746d);
                    if (m1728n < m1748b) {
                        interfaceC3125vaArr[i] = InterfaceC3125va.f9147a;
                    } else {
                        interfaceC3125vaArr[i] = new C2855la(m1730l(i), m1728n, m1746d);
                    }
                }
                i3 = i + 1;
                m1731k = j5;
                interfaceC3125vaArr2 = interfaceC3125vaArr;
                d = i2;
            }
            long j7 = m1731k;
            this.f7968i.mo794j(j6, !this.f7969j.f8011d ? -9223372036854775807L : Math.max(0L, Math.min(m1731k(m2515s2), this.f7960a[0].m1744f(this.f7960a[0].m1746d(m2515s2))) - j), list, interfaceC3125vaArr2);
            C2853kz m1730l = m1730l(this.f7968i.mo797g());
            InterfaceC3113up interfaceC3113up = m1730l.f7949a;
            if (interfaceC3113up != null) {
                AbstractC2874lt abstractC2874lt = m1730l.f7950b;
                C2871lq m1672n = interfaceC3113up.mo896d() == null ? abstractC2874lt.m1672n() : null;
                C2871lq mo1674l = m1730l.f7952d == null ? abstractC2874lt.mo1674l() : null;
                if (m1672n != null || mo1674l != null) {
                    InterfaceC2637cz interfaceC2637cz = this.f7965f;
                    C2962p mo801q = this.f7968i.mo801q();
                    int mo796h = this.f7968i.mo796h();
                    this.f7968i.mo795i();
                    AbstractC2874lt abstractC2874lt2 = m1730l.f7950b;
                    if (m1672n == null || (mo1674l = m1672n.m1677b(mo1674l, m1730l.f7951c.f8004a)) != null) {
                        m1672n = mo1674l;
                    }
                    c3114uq.f9104a = new C3121ux(interfaceC2637cz, C2958ow.m1435d(abstractC2874lt2, m1730l.f7951c.f8004a, m1672n, 0), mo801q, mo796h, m1730l.f7949a);
                    return;
                }
            }
            j3 = m1730l.f7953e;
            int i4 = (j3 > C3282C.TIME_UNSET ? 1 : (j3 == C3282C.TIME_UNSET ? 0 : -1));
            boolean z = i4 != 0;
            if (m1730l.m1745e() == 0) {
                c3114uq.f9105b = z;
                return;
            }
            long m1748b2 = m1730l.m1748b(m2515s2);
            long m1746d2 = m1730l.m1746d(m2515s2);
            boolean z2 = z;
            long m1728n2 = m1728n(m1730l, abstractC3122uy, j2, m1748b2, m1746d2);
            if (m1728n2 < m1748b2) {
                this.f7971l = new C3038rv();
                return;
            }
            int i5 = (m1728n2 > m1746d2 ? 1 : (m1728n2 == m1746d2 ? 0 : -1));
            if (i5 > 0 || (this.f7972m && i5 >= 0)) {
                c3114uq.f9105b = z2;
            } else if (z2 && m1730l.m1742h(m1728n2) >= j3) {
                c3114uq.f9105b = true;
            } else {
                int min = (int) Math.min(1L, (m1746d2 - m1728n2) + 1);
                if (i4 != 0) {
                    while (min > 1 && m1730l.m1742h((min + m1728n2) - 1) >= j3) {
                        min--;
                    }
                }
                long j8 = true != list.isEmpty() ? -9223372036854775807L : j2;
                InterfaceC2637cz interfaceC2637cz2 = this.f7965f;
                int i6 = this.f7964e;
                C2962p mo801q2 = this.f7968i.mo801q();
                int mo796h2 = this.f7968i.mo796h();
                this.f7968i.mo795i();
                AbstractC2874lt abstractC2874lt3 = m1730l.f7950b;
                long m1742h = m1730l.m1742h(m1728n2);
                C2871lq m1738l = m1730l.m1738l(m1728n2);
                if (m1730l.f7949a == null) {
                    c3119uv = new C3126vb(interfaceC2637cz2, C2958ow.m1435d(abstractC2874lt3, m1730l.f7951c.f8004a, m1738l, true != m1730l.m1737m(m1728n2, j7) ? 8 : 0), mo801q2, mo796h2, m1742h, m1730l.m1744f(m1728n2), m1728n2, i6, mo801q2);
                } else {
                    int i7 = 1;
                    int i8 = 1;
                    while (i7 < min) {
                        C2871lq m1677b = m1738l.m1677b(m1730l.m1738l(i7 + m1728n2), m1730l.f7951c.f8004a);
                        if (m1677b == null) {
                            break;
                        }
                        i8++;
                        i7++;
                        m1738l = m1677b;
                    }
                    long j9 = (i8 + m1728n2) - 1;
                    long m1744f = m1730l.m1744f(j9);
                    j4 = m1730l.f7953e;
                    c3119uv = new C3119uv(interfaceC2637cz2, C2958ow.m1435d(abstractC2874lt3, m1730l.f7951c.f8004a, m1738l, true != m1730l.m1737m(j9, j7) ? 8 : 0), mo801q2, mo796h2, m1742h, m1744f, j8, (j4 == C3282C.TIME_UNSET || j4 > m1744f) ? -9223372036854775807L : j4, m1728n2, i8, -abstractC2874lt3.f8059d, m1730l.f7949a);
                }
                c3114uq.f9104a = c3119uv;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: f */
    public final void mo861f() throws IOException {
        IOException iOException = this.f7971l;
        if (iOException != null) {
            throw iOException;
        }
        this.f7961b.mo715a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: g */
    public final void mo860g(AbstractC3112uo abstractC3112uo) {
        C3221yp mo899a;
        if (abstractC3112uo instanceof C3121ux) {
            int c = this.f7968i.mo837c(((C3121ux) abstractC3112uo).f9098i);
            C2853kz c2853kz = this.f7960a[c];
            if (c2853kz.f7952d == null && (mo899a = c2853kz.f7949a.mo899a()) != null) {
                this.f7960a[c] = c2853kz.m1740j(new C2851kx(mo899a, c2853kz.f7950b.f8059d));
            }
        }
        C2860lf c2860lf = this.f7967h;
        if (c2860lf != null) {
            c2860lf.m1724c(abstractC3112uo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: h */
    public final void mo859h() {
        for (C2853kz c2853kz : this.f7960a) {
            InterfaceC3113up interfaceC3113up = c2853kz.f7949a;
            if (interfaceC3113up != null) {
                interfaceC3113up.mo898b();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: i */
    public final void mo858i(long j, AbstractC3112uo abstractC3112uo, List list) {
        if (this.f7971l != null) {
            return;
        }
        this.f7968i.mo798t();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3118uu
    /* renamed from: j */
    public final boolean mo857j(AbstractC3112uo abstractC3112uo, boolean z, C3159wh c3159wh, C3161wj c3161wj) {
        C3158wg m740a;
        if (z) {
            C2860lf c2860lf = this.f7967h;
            if (c2860lf == null || !c2860lf.m1722g(abstractC3112uo)) {
                if (!this.f7969j.f8011d && (abstractC3112uo instanceof AbstractC3122uy)) {
                    IOException iOException = c3159wh.f9296a;
                    if ((iOException instanceof C2653do) && ((C2653do) iOException).f7052b == 404) {
                        C2853kz c2853kz = this.f7960a[this.f7968i.mo837c(abstractC3112uo.f9098i)];
                        long m1745e = c2853kz.m1745e();
                        if (m1745e != -1 && m1745e != 0) {
                            if (((AbstractC3122uy) abstractC3112uo).mo853s() > (c2853kz.m1747c() + m1745e) - 1) {
                                this.f7972m = true;
                                return true;
                            }
                        }
                    }
                }
                C2853kz c2853kz2 = this.f7960a[this.f7968i.mo837c(abstractC3112uo.f9098i)];
                C2863li m1791b = this.f7962c.m1791b(c2853kz2.f7950b.f8058c);
                if (m1791b == null || c2853kz2.f7951c.equals(m1791b)) {
                    InterfaceC3142vr interfaceC3142vr = this.f7968i;
                    avg avgVar = c2853kz2.f7950b.f8058c;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    int d = interfaceC3142vr.mo836d();
                    int i = 0;
                    for (int i2 = 0; i2 < d; i2++) {
                        if (interfaceC3142vr.mo799s(i2, elapsedRealtime)) {
                            i++;
                        }
                    }
                    HashSet hashSet = new HashSet();
                    for (int i3 = 0; i3 < avgVar.size(); i3++) {
                        hashSet.add(Integer.valueOf(((C2863li) avgVar.get(i3)).f8006c));
                    }
                    int size = hashSet.size();
                    C3157wf c3157wf = new C3157wf(size, size - this.f7962c.m1792a(avgVar), d, i);
                    if ((c3157wf.m744a(2) || c3157wf.m744a(1)) && (m740a = C3161wj.m740a(c3157wf, c3159wh)) != null) {
                        int i4 = m740a.f9294a;
                        if (c3157wf.m744a(i4)) {
                            if (i4 == 2) {
                                InterfaceC3142vr interfaceC3142vr2 = this.f7968i;
                                return interfaceC3142vr2.mo800r(interfaceC3142vr2.mo837c(abstractC3112uo.f9098i), m740a.f9295b);
                            }
                            this.f7962c.m1790c(c2853kz2.f7951c, m740a.f9295b);
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
