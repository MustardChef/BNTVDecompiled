package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.or */
/* loaded from: classes2.dex */
final class C2953or {

    /* renamed from: a */
    private final InterfaceC2954os f8262a;

    /* renamed from: b */
    private final InterfaceC2637cz f8263b;

    /* renamed from: c */
    private final InterfaceC2637cz f8264c;

    /* renamed from: d */
    private final C2972pj f8265d;

    /* renamed from: e */
    private final Uri[] f8266e;

    /* renamed from: f */
    private final C2962p[] f8267f;

    /* renamed from: g */
    private final InterfaceC3000qk f8268g;

    /* renamed from: h */
    private final C2587bc f8269h;

    /* renamed from: i */
    private final List f8270i;

    /* renamed from: k */
    private boolean f8272k;

    /* renamed from: m */
    private IOException f8274m;

    /* renamed from: n */
    private Uri f8275n;

    /* renamed from: o */
    private boolean f8276o;

    /* renamed from: p */
    private InterfaceC3142vr f8277p;

    /* renamed from: r */
    private boolean f8279r;

    /* renamed from: j */
    private final C2947ol f8271j = new C2947ol();

    /* renamed from: l */
    private byte[] f8273l = C2628cq.f6966f;

    /* renamed from: q */
    private long f8278q = C3282C.TIME_UNSET;

    public C2953or(InterfaceC2954os interfaceC2954os, InterfaceC3000qk interfaceC3000qk, Uri[] uriArr, C2962p[] c2962pArr, C2944oi c2944oi, InterfaceC2659du interfaceC2659du, C2972pj c2972pj, List list) {
        this.f8262a = interfaceC2954os;
        this.f8268g = interfaceC3000qk;
        this.f8266e = uriArr;
        this.f8267f = c2962pArr;
        this.f8265d = c2972pj;
        this.f8270i = list;
        InterfaceC2637cz m1479a = c2944oi.m1479a();
        this.f8263b = m1479a;
        if (interfaceC2659du != null) {
            m1479a.mo1123f(interfaceC2659du);
        }
        this.f8264c = c2944oi.m1479a();
        this.f8269h = new C2587bc(c2962pArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((c2962pArr[i].f8365e & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.f8277p = new C2951op(this.f8269h, axn.m4380a(arrayList));
    }

    /* renamed from: p */
    private static Uri m1455p(C2990qa c2990qa, C2987py c2987py) {
        String str;
        if (c2987py == null || (str = c2987py.f8530i) == null) {
            return null;
        }
        return C2616ce.m2675r(c2990qa.f8559t, str);
    }

    /* renamed from: r */
    private final AbstractC3112uo m1453r(Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] m1474b = this.f8271j.m1474b(uri);
        if (m1474b != null) {
            this.f8271j.m1473c(uri, m1474b);
            return null;
        }
        C2641dc c2641dc = new C2641dc();
        c2641dc.m2492i(uri);
        c2641dc.m2499b(1);
        C2642dd m2500a = c2641dc.m2500a();
        InterfaceC2637cz interfaceC2637cz = this.f8264c;
        C2962p c2962p = this.f8267f[i];
        int mo796h = this.f8277p.mo796h();
        this.f8277p.mo795i();
        return new C2948om(interfaceC2637cz, m2500a, c2962p, mo796h, this.f8273l);
    }

    /* renamed from: a */
    public final int m1470a(C2955ot c2955ot) {
        List list;
        if (c2955ot.f8298e == -1) {
            return 1;
        }
        C2990qa mo1317k = this.f8268g.mo1317k(this.f8266e[this.f8269h.m4194a(c2955ot.f9098i)], false);
        C2616ce.m2689d(mo1317k);
        int i = (int) (c2955ot.f9146o - mo1317k.f8547h);
        if (i < 0) {
            return 1;
        }
        if (i < mo1317k.f8554o.size()) {
            list = ((C2986px) mo1317k.f8554o.get(i)).f8523b;
        } else {
            list = mo1317k.f8555p;
        }
        if (c2955ot.f8298e >= list.size()) {
            return 2;
        }
        C2984pv c2984pv = (C2984pv) list.get(c2955ot.f8298e);
        if (c2984pv.f8518b) {
            return 0;
        }
        return C2628cq.m2563T(Uri.parse(C2616ce.m2674s(mo1317k.f8559t, c2984pv.f8524c)), c2955ot.f9096g.f7011a) ? 1 : 2;
    }

    /* renamed from: b */
    public final int m1469b(long j, List list) {
        if (this.f8274m != null || this.f8277p.mo836d() < 2) {
            return list.size();
        }
        return this.f8277p.mo806k(j, list);
    }

    /* renamed from: c */
    public final C2587bc m1468c() {
        return this.f8269h;
    }

    /* renamed from: d */
    public final InterfaceC3142vr m1467d() {
        return this.f8277p;
    }

    /* renamed from: e */
    public final void m1466e(long j, long j2, List list, boolean z, C2949on c2949on) {
        int i;
        C2990qa c2990qa;
        long j3;
        C2952oq c2952oq;
        C2955ot c2955ot = list.isEmpty() ? null : (C2955ot) axd.m4386z(list);
        int m4194a = c2955ot == null ? -1 : this.f8269h.m4194a(c2955ot.f9098i);
        long j4 = j2 - j;
        long j5 = this.f8278q;
        long j6 = C3282C.TIME_UNSET;
        long j7 = j5 != C3282C.TIME_UNSET ? j5 - j : -9223372036854775807L;
        if (c2955ot != null && !this.f8276o) {
            long j8 = c2955ot.f9102m - c2955ot.f9101l;
            j4 = Math.max(0L, j4 - j8);
            if (j7 != C3282C.TIME_UNSET) {
                j7 = Math.max(0L, j7 - j8);
            }
        }
        this.f8277p.mo794j(j4, j7, list, m1457n(c2955ot, j2));
        int mo802p = this.f8277p.mo802p();
        boolean z2 = m4194a != mo802p;
        Uri uri = this.f8266e[mo802p];
        if (!this.f8268g.mo1320B(uri)) {
            c2949on.f8254c = uri;
            this.f8279r &= uri.equals(this.f8275n);
            this.f8275n = uri;
            return;
        }
        C2990qa mo1317k = this.f8268g.mo1317k(uri, true);
        C2616ce.m2689d(mo1317k);
        this.f8276o = mo1317k.f8561v;
        if (!mo1317k.f8551l) {
            j6 = mo1317k.m1346a() - this.f8268g.mo1319d();
        }
        this.f8278q = j6;
        long mo1319d = mo1317k.f8544e - this.f8268g.mo1319d();
        Uri uri2 = uri;
        Pair m1454q = m1454q(c2955ot, z2, mo1317k, mo1319d, j2);
        long longValue = ((Long) m1454q.first).longValue();
        int intValue = ((Integer) m1454q.second).intValue();
        if (longValue >= mo1317k.f8547h || c2955ot == null || !z2) {
            i = intValue;
            m4194a = mo802p;
            c2990qa = mo1317k;
            j3 = mo1319d;
        } else {
            uri2 = this.f8266e[m4194a];
            c2990qa = this.f8268g.mo1317k(uri2, true);
            C2616ce.m2689d(c2990qa);
            j3 = c2990qa.f8544e - this.f8268g.mo1319d();
            Pair m1454q2 = m1454q(c2955ot, false, c2990qa, j3, j2);
            longValue = ((Long) m1454q2.first).longValue();
            i = ((Integer) m1454q2.second).intValue();
        }
        long j9 = c2990qa.f8547h;
        if (longValue >= j9) {
            int i2 = (int) (longValue - j9);
            if (i2 == c2990qa.f8554o.size()) {
                if (i == -1) {
                    i = 0;
                }
                if (i < c2990qa.f8555p.size()) {
                    c2952oq = new C2952oq((C2987py) c2990qa.f8555p.get(i), longValue, i);
                }
                c2952oq = null;
            } else {
                C2986px c2986px = (C2986px) c2990qa.f8554o.get(i2);
                if (i == -1) {
                    c2952oq = new C2952oq(c2986px, longValue, -1);
                } else if (i < c2986px.f8523b.size()) {
                    c2952oq = new C2952oq((C2987py) c2986px.f8523b.get(i), longValue, i);
                } else {
                    int i3 = i2 + 1;
                    if (i3 < c2990qa.f8554o.size()) {
                        c2952oq = new C2952oq((C2987py) c2990qa.f8554o.get(i3), longValue + 1, -1);
                    } else {
                        if (!c2990qa.f8555p.isEmpty()) {
                            c2952oq = new C2952oq((C2987py) c2990qa.f8555p.get(0), longValue + 1, 0);
                        }
                        c2952oq = null;
                    }
                }
            }
            if (c2952oq == null) {
                if (!c2990qa.f8551l) {
                    c2949on.f8254c = uri2;
                    this.f8279r &= uri2.equals(this.f8275n);
                    this.f8275n = uri2;
                    return;
                } else if (z || c2990qa.f8554o.isEmpty()) {
                    c2949on.f8253b = true;
                    return;
                } else {
                    c2952oq = new C2952oq((C2987py) axd.m4386z(c2990qa.f8554o), (c2990qa.f8547h + c2990qa.f8554o.size()) - 1, -1);
                }
            }
            this.f8279r = false;
            this.f8275n = null;
            Uri m1455p = m1455p(c2990qa, c2952oq.f8258a.f8525d);
            c2949on.f8252a = m1453r(m1455p, m4194a);
            if (c2949on.f8252a != null) {
                return;
            }
            Uri m1455p2 = m1455p(c2990qa, c2952oq.f8258a);
            c2949on.f8252a = m1453r(m1455p2, m4194a);
            if (c2949on.f8252a != null) {
                return;
            }
            boolean m1447i = C2955ot.m1447i(c2955ot, uri2, c2990qa, c2952oq, j3);
            if (m1447i && c2952oq.f8261d) {
                return;
            }
            InterfaceC2954os interfaceC2954os = this.f8262a;
            InterfaceC2637cz interfaceC2637cz = this.f8263b;
            C2962p c2962p = this.f8267f[m4194a];
            List list2 = this.f8270i;
            int mo796h = this.f8277p.mo796h();
            this.f8277p.mo795i();
            c2949on.f8252a = C2955ot.m1446j(interfaceC2954os, interfaceC2637cz, c2962p, j3, c2990qa, c2952oq, uri2, list2, mo796h, this.f8272k, this.f8265d, c2955ot, this.f8271j.m1475a(m1455p2), this.f8271j.m1475a(m1455p), m1447i);
            return;
        }
        this.f8274m = new C3038rv();
    }

    /* renamed from: f */
    public final void m1465f() throws IOException {
        IOException iOException = this.f8274m;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f8275n;
        if (uri == null || !this.f8279r) {
            return;
        }
        this.f8268g.mo1315r(uri);
    }

    /* renamed from: g */
    public final void m1464g(AbstractC3112uo abstractC3112uo) {
        if (abstractC3112uo instanceof C2948om) {
            C2948om c2948om = (C2948om) abstractC3112uo;
            this.f8273l = c2948om.m855c();
            this.f8271j.m1473c(c2948om.f9096g.f7011a, (byte[]) C2616ce.m2689d(c2948om.m1472b()));
        }
    }

    /* renamed from: h */
    public final void m1463h() {
        this.f8274m = null;
    }

    /* renamed from: i */
    public final void m1462i(boolean z) {
        this.f8272k = z;
    }

    /* renamed from: j */
    public final void m1461j(InterfaceC3142vr interfaceC3142vr) {
        this.f8277p = interfaceC3142vr;
    }

    /* renamed from: k */
    public final boolean m1460k(AbstractC3112uo abstractC3112uo, long j) {
        InterfaceC3142vr interfaceC3142vr = this.f8277p;
        return interfaceC3142vr.mo800r(interfaceC3142vr.mo838b(this.f8269h.m4194a(abstractC3112uo.f9098i)), j);
    }

    /* renamed from: l */
    public final boolean m1459l(Uri uri) {
        return C2628cq.m2562U(this.f8266e, uri);
    }

    /* renamed from: m */
    public final boolean m1458m(Uri uri, long j) {
        int b;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.f8266e;
            if (i >= uriArr.length) {
                i = -1;
                break;
            } else if (uriArr[i].equals(uri)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1 || (b = this.f8277p.mo838b(i)) == -1) {
            return true;
        }
        this.f8279r |= uri.equals(this.f8275n);
        return j == C3282C.TIME_UNSET || (this.f8277p.mo800r(b, j) && this.f8268g.mo1309z(uri, j));
    }

    /* renamed from: o */
    public final void m1456o(long j, AbstractC3112uo abstractC3112uo, List list) {
        if (this.f8274m != null) {
            return;
        }
        this.f8277p.mo798t();
    }

    /* renamed from: q */
    private final Pair m1454q(C2955ot c2955ot, boolean z, C2990qa c2990qa, long j, long j2) {
        List list;
        boolean z2 = true;
        if (c2955ot == null || z) {
            long j3 = c2990qa.f8557r + j;
            if (c2955ot != null && !this.f8276o) {
                j2 = c2955ot.f9101l;
            }
            if (c2990qa.f8551l || j2 < j3) {
                long j4 = j2 - j;
                List list2 = c2990qa.f8554o;
                Long valueOf = Long.valueOf(j4);
                int i = 0;
                if (this.f8268g.mo1321A() && c2955ot != null) {
                    z2 = false;
                }
                int m2542an = C2628cq.m2542an(list2, valueOf, z2);
                long j5 = m2542an + c2990qa.f8547h;
                if (m2542an >= 0) {
                    C2986px c2986px = (C2986px) c2990qa.f8554o.get(m2542an);
                    if (j4 < c2986px.f8528g + c2986px.f8526e) {
                        list = c2986px.f8523b;
                    } else {
                        list = c2990qa.f8555p;
                    }
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        }
                        C2984pv c2984pv = (C2984pv) list.get(i);
                        if (j4 >= c2984pv.f8528g + c2984pv.f8526e) {
                            i++;
                        } else if (c2984pv.f8517a) {
                            j5 += list == c2990qa.f8555p ? 1L : 0L;
                            r1 = i;
                        }
                    }
                }
                return new Pair(Long.valueOf(j5), Integer.valueOf(r1));
            }
            return new Pair(Long.valueOf(c2990qa.f8547h + c2990qa.f8554o.size()), -1);
        } else if (c2955ot.mo849g()) {
            Long valueOf2 = Long.valueOf(c2955ot.f8298e == -1 ? c2955ot.mo853s() : c2955ot.f9146o);
            int i2 = c2955ot.f8298e;
            return new Pair(valueOf2, Integer.valueOf(i2 != -1 ? i2 + 1 : -1));
        } else {
            return new Pair(Long.valueOf(c2955ot.f9146o), Integer.valueOf(c2955ot.f8298e));
        }
    }

    /* renamed from: n */
    public final InterfaceC3125va[] m1457n(C2955ot c2955ot, long j) {
        List m4515n;
        int m4194a = c2955ot == null ? -1 : this.f8269h.m4194a(c2955ot.f9098i);
        int d = this.f8277p.mo836d();
        InterfaceC3125va[] interfaceC3125vaArr = new InterfaceC3125va[d];
        boolean z = false;
        int i = 0;
        while (i < d) {
            int a = this.f8277p.mo839a(i);
            Uri uri = this.f8266e[a];
            if (!this.f8268g.mo1320B(uri)) {
                interfaceC3125vaArr[i] = InterfaceC3125va.f9147a;
            } else {
                C2990qa mo1317k = this.f8268g.mo1317k(uri, z);
                C2616ce.m2689d(mo1317k);
                long mo1319d = mo1317k.f8544e - this.f8268g.mo1319d();
                Pair m1454q = m1454q(c2955ot, a != m4194a, mo1317k, mo1319d, j);
                long longValue = ((Long) m1454q.first).longValue();
                int intValue = ((Integer) m1454q.second).intValue();
                String str = mo1317k.f8559t;
                int i2 = (int) (longValue - mo1317k.f8547h);
                if (i2 < 0 || mo1317k.f8554o.size() < i2) {
                    m4515n = avg.m4515n();
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (i2 < mo1317k.f8554o.size()) {
                        if (intValue != -1) {
                            C2986px c2986px = (C2986px) mo1317k.f8554o.get(i2);
                            if (intValue == 0) {
                                arrayList.add(c2986px);
                            } else if (intValue < c2986px.f8523b.size()) {
                                List list = c2986px.f8523b;
                                arrayList.addAll(list.subList(intValue, list.size()));
                            }
                            i2++;
                        }
                        List list2 = mo1317k.f8554o;
                        arrayList.addAll(list2.subList(i2, list2.size()));
                        intValue = 0;
                    }
                    if (mo1317k.f8550k != C3282C.TIME_UNSET) {
                        if (intValue == -1) {
                            intValue = 0;
                        }
                        if (intValue < mo1317k.f8555p.size()) {
                            List list3 = mo1317k.f8555p;
                            arrayList.addAll(list3.subList(intValue, list3.size()));
                        }
                    }
                    m4515n = Collections.unmodifiableList(arrayList);
                }
                interfaceC3125vaArr[i] = new C2950oo(mo1319d, m4515n);
            }
            i++;
            z = false;
        }
        return interfaceC3125vaArr;
    }
}
