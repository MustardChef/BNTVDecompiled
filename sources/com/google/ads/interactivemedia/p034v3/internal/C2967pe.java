package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pe */
/* loaded from: classes2.dex */
public final class C2967pe implements InterfaceC3160wi, InterfaceC3164wm, InterfaceC3100uc, InterfaceC3233za, InterfaceC3095ty {

    /* renamed from: a */
    private static final Set f8398a = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));

    /* renamed from: A */
    private int f8399A;

    /* renamed from: B */
    private boolean f8400B;

    /* renamed from: C */
    private boolean f8401C;

    /* renamed from: D */
    private int f8402D;

    /* renamed from: E */
    private C2962p f8403E;

    /* renamed from: F */
    private C2962p f8404F;

    /* renamed from: G */
    private boolean f8405G;

    /* renamed from: H */
    private C2588bd f8406H;

    /* renamed from: I */
    private Set f8407I;

    /* renamed from: J */
    private int[] f8408J;

    /* renamed from: K */
    private int f8409K;

    /* renamed from: L */
    private boolean f8410L;

    /* renamed from: M */
    private boolean[] f8411M;

    /* renamed from: N */
    private boolean[] f8412N;

    /* renamed from: O */
    private long f8413O;

    /* renamed from: P */
    private long f8414P;

    /* renamed from: Q */
    private boolean f8415Q;

    /* renamed from: R */
    private boolean f8416R;

    /* renamed from: S */
    private boolean f8417S;

    /* renamed from: T */
    private boolean f8418T;

    /* renamed from: U */
    private long f8419U;

    /* renamed from: V */
    private C2854l f8420V;

    /* renamed from: W */
    private C2955ot f8421W;

    /* renamed from: X */
    private final C3154wc f8422X;

    /* renamed from: Y */
    private final C3161wj f8423Y;

    /* renamed from: c */
    private final int f8424c;

    /* renamed from: d */
    private final InterfaceC2964pb f8425d;

    /* renamed from: e */
    private final C2953or f8426e;

    /* renamed from: f */
    private final C2962p f8427f;

    /* renamed from: g */
    private final InterfaceC2921nm f8428g;

    /* renamed from: h */
    private final C2915ng f8429h;

    /* renamed from: j */
    private final C3076tf f8431j;

    /* renamed from: m */
    private final ArrayList f8434m;

    /* renamed from: n */
    private final List f8435n;

    /* renamed from: o */
    private final Runnable f8436o;

    /* renamed from: p */
    private final Runnable f8437p;

    /* renamed from: q */
    private final Handler f8438q;

    /* renamed from: r */
    private final ArrayList f8439r;

    /* renamed from: s */
    private final Map f8440s;

    /* renamed from: t */
    private AbstractC3112uo f8441t;

    /* renamed from: u */
    private C2966pd[] f8442u;

    /* renamed from: w */
    private final Set f8444w;

    /* renamed from: x */
    private final SparseIntArray f8445x;

    /* renamed from: y */
    private InterfaceC3253zu f8446y;

    /* renamed from: z */
    private int f8447z;

    /* renamed from: k */
    private final int f8432k = 1;

    /* renamed from: i */
    private final C3167wp f8430i = new C3167wp("Loader:HlsSampleStreamWrapper");

    /* renamed from: l */
    private final C2949on f8433l = new C2949on();

    /* renamed from: v */
    private int[] f8443v = new int[0];

    public C2967pe(int i, InterfaceC2964pb interfaceC2964pb, C2953or c2953or, Map map, C3154wc c3154wc, long j, C2962p c2962p, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng, C3161wj c3161wj, C3076tf c3076tf, int i2, byte[] bArr) {
        this.f8424c = i;
        this.f8425d = interfaceC2964pb;
        this.f8426e = c2953or;
        this.f8440s = map;
        this.f8422X = c3154wc;
        this.f8427f = c2962p;
        this.f8428g = interfaceC2921nm;
        this.f8429h = c2915ng;
        this.f8423Y = c3161wj;
        this.f8431j = c3076tf;
        Set set = f8398a;
        this.f8444w = new HashSet(set.size());
        this.f8445x = new SparseIntArray(set.size());
        this.f8442u = new C2966pd[0];
        this.f8412N = new boolean[0];
        this.f8411M = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f8434m = arrayList;
        this.f8435n = Collections.unmodifiableList(arrayList);
        this.f8439r = new ArrayList();
        this.f8436o = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.pa

            /* renamed from: a */
            public final /* synthetic */ C2967pe f8387a;

            {
                this.f8387a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (r2 != 0) {
                    C2967pe.m1395i(this.f8387a);
                } else {
                    this.f8387a.m1403P();
                }
            }
        };
        this.f8437p = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.pa

            /* renamed from: a */
            public final /* synthetic */ C2967pe f8387a;

            {
                this.f8387a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (r2 != 0) {
                    C2967pe.m1395i(this.f8387a);
                } else {
                    this.f8387a.m1403P();
                }
            }
        };
        this.f8438q = C2628cq.m2508z();
        this.f8413O = j;
        this.f8414P = j;
    }

    /* renamed from: I */
    private static int m1410I(int i) {
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0 : 1;
            }
            return 3;
        }
        return 2;
    }

    /* renamed from: J */
    private static C2962p m1409J(C2962p c2962p, C2962p c2962p2, boolean z) {
        String m4972e;
        String str;
        if (c2962p == null) {
            return c2962p2;
        }
        int m4976a = C2554an.m4976a(c2962p2.f8372l);
        if (C2628cq.m2527g(c2962p.f8369i, m4976a) == 1) {
            m4972e = C2628cq.m2574I(c2962p.f8369i, m4976a);
            str = C2554an.m4971f(m4972e);
        } else {
            m4972e = C2554an.m4972e(c2962p.f8369i, c2962p2.f8372l);
            str = c2962p2.f8372l;
        }
        C2935o m1426b = c2962p2.m1426b();
        m1426b.m1545S(c2962p.f8361a);
        m1426b.m1543U(c2962p.f8362b);
        m1426b.m1542V(c2962p.f8363c);
        m1426b.m1530ag(c2962p.f8364d);
        m1426b.m1534ac(c2962p.f8365e);
        m1426b.m1557G(z ? c2962p.f8366f : -1);
        m1426b.m1538Z(z ? c2962p.f8367g : -1);
        m1426b.m1555I(m4972e);
        if (m4976a == 2) {
            m1426b.m1527aj(c2962p.f8377q);
            m1426b.m1547Q(c2962p.f8378r);
            m1426b.m1548P(c2962p.f8379s);
            m4976a = 2;
        }
        if (str != null) {
            m1426b.m1532ae(str);
        }
        int i = c2962p.f8385y;
        if (i != -1 && m4976a == 1) {
            m1426b.m1556H(i);
        }
        C2549ak c2549ak = c2962p.f8370j;
        if (c2549ak != null) {
            C2549ak c2549ak2 = c2962p2.f8370j;
            if (c2549ak2 != null) {
                c2549ak = c2549ak2.m5124d(c2549ak);
            }
            m1426b.m1540X(c2549ak);
        }
        return m1426b.m1506v();
    }

    /* renamed from: K */
    private final C2588bd m1408K(C2587bc[] c2587bcArr) {
        for (int i = 0; i < c2587bcArr.length; i++) {
            C2587bc c2587bc = c2587bcArr[i];
            C2962p[] c2962pArr = new C2962p[c2587bc.f5406a];
            for (int i2 = 0; i2 < c2587bc.f5406a; i2++) {
                C2962p m4193b = c2587bc.m4193b(i2);
                c2962pArr[i2] = m4193b.m1425c(this.f8428g.mo1587b(m4193b));
            }
            c2587bcArr[i] = new C2587bc(c2962pArr);
        }
        return new C2588bd(c2587bcArr);
    }

    /* renamed from: L */
    private final C2955ot m1407L() {
        ArrayList arrayList = this.f8434m;
        return (C2955ot) arrayList.get(arrayList.size() - 1);
    }

    /* renamed from: M */
    private static C3228yw m1406M(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unmapped track with id ");
        sb.append(i);
        sb.append(" of type ");
        sb.append(i2);
        Log.w("HlsSampleStreamWrapper", sb.toString());
        return new C3228yw();
    }

    /* renamed from: N */
    private final void m1405N() {
        C2616ce.m2685h(this.f8401C);
        C2616ce.m2689d(this.f8406H);
        C2616ce.m2689d(this.f8407I);
    }

    /* renamed from: O */
    private final void m1404O(int i) {
        int i2;
        C2616ce.m2685h(!this.f8430i.m717m());
        loop0: while (true) {
            if (i >= this.f8434m.size()) {
                i = -1;
                break;
            }
            int i3 = i;
            while (true) {
                if (i3 < this.f8434m.size()) {
                    if (((C2955ot) this.f8434m.get(i3)).f8297d) {
                        break;
                    }
                    i3++;
                } else {
                    C2955ot c2955ot = (C2955ot) this.f8434m.get(i);
                    while (i2 < this.f8442u.length) {
                        i2 = this.f8442u[i2].m950k() <= c2955ot.m1452a(i2) ? i2 + 1 : 0;
                    }
                    break loop0;
                }
            }
            i++;
        }
        if (i == -1) {
            return;
        }
        long j = m1407L().f9102m;
        C2955ot c2955ot2 = (C2955ot) this.f8434m.get(i);
        ArrayList arrayList = this.f8434m;
        C2628cq.m2565R(arrayList, i, arrayList.size());
        for (int i4 = 0; i4 < this.f8442u.length; i4++) {
            this.f8442u[i4].m938w(c2955ot2.m1452a(i4));
        }
        if (this.f8434m.isEmpty()) {
            this.f8414P = this.f8413O;
        } else {
            ((C2955ot) axd.m4386z(this.f8434m)).m1450d();
        }
        this.f8417S = false;
        this.f8431j.m1077n(this.f8447z, c2955ot2.f9101l, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public final void m1403P() {
        if (!this.f8405G && this.f8408J == null && this.f8400B) {
            for (C2966pd c2966pd : this.f8442u) {
                if (c2966pd.m941t() == null) {
                    return;
                }
            }
            C2588bd c2588bd = this.f8406H;
            if (c2588bd == null) {
                int length = this.f8442u.length;
                int i = 0;
                int i2 = -2;
                int i3 = -1;
                while (true) {
                    int i4 = 2;
                    if (i >= length) {
                        break;
                    }
                    C2962p m941t = this.f8442u[i].m941t();
                    C2616ce.m2688e(m941t);
                    String str = m941t.f8372l;
                    if (!C2554an.m4960q(str)) {
                        if (C2554an.m4964m(str)) {
                            i4 = 1;
                        } else {
                            i4 = C2554an.m4961p(str) ? 3 : -2;
                        }
                    }
                    if (m1410I(i4) > m1410I(i2)) {
                        i3 = i;
                        i2 = i4;
                    } else if (i4 == i2) {
                        i3 = -1;
                    }
                    i++;
                }
                C2587bc m1468c = this.f8426e.m1468c();
                int i5 = m1468c.f5406a;
                this.f8409K = -1;
                this.f8408J = new int[length];
                for (int i6 = 0; i6 < length; i6++) {
                    this.f8408J[i6] = i6;
                }
                C2587bc[] c2587bcArr = new C2587bc[length];
                for (int i7 = 0; i7 < length; i7++) {
                    C2962p m941t2 = this.f8442u[i7].m941t();
                    C2616ce.m2688e(m941t2);
                    if (i7 == i3) {
                        C2962p[] c2962pArr = new C2962p[i5];
                        if (i5 == 1) {
                            c2962pArr[0] = m941t2.m1424d(m1468c.m4193b(0));
                        } else {
                            for (int i8 = 0; i8 < i5; i8++) {
                                c2962pArr[i8] = m1409J(m1468c.m4193b(i8), m941t2, true);
                            }
                        }
                        c2587bcArr[i7] = new C2587bc(c2962pArr);
                        this.f8409K = i7;
                    } else {
                        C2962p c2962p = null;
                        if (i2 == 2 && C2554an.m4964m(m941t2.f8372l)) {
                            c2962p = this.f8427f;
                        }
                        c2587bcArr[i7] = new C2587bc(m1409J(c2962p, m941t2, false));
                    }
                }
                this.f8406H = m1408K(c2587bcArr);
                C2616ce.m2685h(this.f8407I == null);
                this.f8407I = Collections.emptySet();
                m1401R();
                this.f8425d.mo1421n();
                return;
            }
            int i9 = c2588bd.f5440b;
            int[] iArr = new int[i9];
            this.f8408J = iArr;
            Arrays.fill(iArr, -1);
            for (int i10 = 0; i10 < i9; i10++) {
                int i11 = 0;
                while (true) {
                    C2966pd[] c2966pdArr = this.f8442u;
                    if (i11 < c2966pdArr.length) {
                        C2962p m941t3 = c2966pdArr[i11].m941t();
                        C2616ce.m2688e(m941t3);
                        C2962p m4193b = this.f8406H.m4121b(i10).m4193b(0);
                        String str2 = m941t3.f8372l;
                        String str3 = m4193b.f8372l;
                        int m4976a = C2554an.m4976a(str2);
                        if (m4976a != 3) {
                            if (m4976a == C2554an.m4976a(str3)) {
                                break;
                            }
                            i11++;
                        } else {
                            if (!C2628cq.m2563T(str2, str3)) {
                                continue;
                            } else if ((!MimeTypes.APPLICATION_CEA608.equals(str2) && !MimeTypes.APPLICATION_CEA708.equals(str2)) || m941t3.f8358D == m4193b.f8358D) {
                                break;
                            }
                            i11++;
                        }
                    }
                }
                this.f8408J[i10] = i11;
            }
            ArrayList arrayList = this.f8439r;
            int size = arrayList.size();
            for (int i12 = 0; i12 < size; i12++) {
                ((C2960oy) arrayList.get(i12)).m1430c();
            }
        }
    }

    /* renamed from: Q */
    private final void m1402Q() {
        for (C2966pd c2966pd : this.f8442u) {
            c2966pd.m982C(this.f8415Q);
        }
        this.f8415Q = false;
    }

    /* renamed from: R */
    private final void m1401R() {
        this.f8401C = true;
    }

    /* renamed from: S */
    private final boolean m1400S() {
        return this.f8414P != C3282C.TIME_UNSET;
    }

    /* renamed from: i */
    public static /* synthetic */ void m1395i(C2967pe c2967pe) {
        c2967pe.f8400B = true;
        c2967pe.m1403P();
    }

    /* renamed from: A */
    public final void m1417A(int i) {
        m1405N();
        C2616ce.m2689d(this.f8408J);
        int i2 = this.f8408J[i];
        C2616ce.m2685h(this.f8411M[i2]);
        this.f8411M[i2] = false;
    }

    /* renamed from: B */
    public final boolean m1416B(int i) {
        return !m1400S() && this.f8442u[i].m974K(this.f8417S);
    }

    /* renamed from: C */
    public final boolean m1415C(Uri uri, C3159wh c3159wh, boolean z) {
        C3158wg m740a;
        if (this.f8426e.m1459l(uri)) {
            long j = (z || (m740a = C3161wj.m740a(C3161wj.m736e(this.f8426e.m1467d()), c3159wh)) == null || m740a.f9294a != 2) ? -9223372036854775807L : m740a.f9295b;
            return this.f8426e.m1458m(uri, j) && j != C3282C.TIME_UNSET;
        }
        return true;
    }

    /* renamed from: D */
    public final boolean m1414D(long j, boolean z) {
        int i;
        this.f8413O = j;
        if (m1400S()) {
            this.f8414P = j;
            return true;
        }
        if (this.f8400B && !z) {
            int length = this.f8442u.length;
            while (i < length) {
                i = (this.f8442u[i].m972M(j, false) || (!this.f8412N[i] && this.f8410L)) ? i + 1 : 0;
            }
            return false;
        }
        this.f8414P = j;
        this.f8417S = false;
        this.f8434m.clear();
        C3167wp c3167wp = this.f8430i;
        if (c3167wp.m717m()) {
            if (this.f8400B) {
                for (C2966pd c2966pd : this.f8442u) {
                    c2966pd.m940u();
                }
            }
            this.f8430i.m723g();
        } else {
            c3167wp.m722h();
            m1402Q();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0116, code lost:
        if (r14.mo802p() != r19.f8426e.m1468c().m4194a(r1.f9098i)) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0121  */
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m1413E(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr[] r20, boolean[] r21, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2967pe.m1413E(com.google.ads.interactivemedia.v3.internal.vr[], boolean[], com.google.ads.interactivemedia.v3.internal.ua[], boolean[], long, boolean):boolean");
    }

    /* renamed from: F */
    public final void m1412F(long j) {
        if (!this.f8400B || m1400S()) {
            return;
        }
        int length = this.f8442u.length;
        for (int i = 0; i < length; i++) {
            this.f8442u[i].m969P(j, this.f8411M[i]);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3095ty
    /* renamed from: G */
    public final void mo985G() {
        this.f8438q.post(this.f8436o);
    }

    /* renamed from: H */
    public final void m1411H(C2587bc[] c2587bcArr, int... iArr) {
        this.f8406H = m1408K(c2587bcArr);
        this.f8407I = new HashSet();
        this.f8409K = 0;
        Handler handler = this.f8438q;
        final InterfaceC2964pb interfaceC2964pb = this.f8425d;
        handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.oz
            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC2964pb.this.mo1421n();
            }
        });
        m1401R();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bb */
    public final /* bridge */ /* synthetic */ void mo704bb(InterfaceC3163wl interfaceC3163wl, long j, long j2) {
        AbstractC3112uo abstractC3112uo = (AbstractC3112uo) interfaceC3163wl;
        this.f8441t = null;
        this.f8426e.m1464g(abstractC3112uo);
        long j3 = abstractC3112uo.f9095f;
        C2642dd c2642dd = abstractC3112uo.f9096g;
        abstractC3112uo.m901l();
        abstractC3112uo.m900m();
        abstractC3112uo.m902k();
        C3059sp c3059sp = new C3059sp();
        long j4 = abstractC3112uo.f9095f;
        C3076tf c3076tf = this.f8431j;
        int i = abstractC3112uo.f9097h;
        int i2 = this.f8424c;
        C2962p c2962p = abstractC3112uo.f9098i;
        int i3 = abstractC3112uo.f9099j;
        Object obj = abstractC3112uo.f9100k;
        c3076tf.m1074q(c3059sp, i, i2, c2962p, i3, abstractC3112uo.f9101l, abstractC3112uo.f9102m);
        if (!this.f8401C) {
            mo875o(this.f8413O);
        } else {
            this.f8425d.mo934g(this);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bc */
    public final /* bridge */ /* synthetic */ C3158wg mo703bc(InterfaceC3163wl interfaceC3163wl, long j, long j2, IOException iOException, int i) {
        C3158wg m716n;
        int i2;
        AbstractC3112uo abstractC3112uo = (AbstractC3112uo) interfaceC3163wl;
        boolean z = abstractC3112uo instanceof C2955ot;
        if (z && !((C2955ot) abstractC3112uo).m1448h() && (iOException instanceof C2653do) && ((i2 = ((C2653do) iOException).f7052b) == 410 || i2 == 404)) {
            return C3167wp.f9309a;
        }
        long m902k = abstractC3112uo.m902k();
        long j3 = abstractC3112uo.f9095f;
        C2642dd c2642dd = abstractC3112uo.f9096g;
        abstractC3112uo.m901l();
        abstractC3112uo.m900m();
        C3059sp c3059sp = new C3059sp();
        int i3 = abstractC3112uo.f9097h;
        C2962p c2962p = abstractC3112uo.f9098i;
        int i4 = abstractC3112uo.f9099j;
        Object obj = abstractC3112uo.f9100k;
        long j4 = abstractC3112uo.f9101l;
        int i5 = C2628cq.f6961a;
        long j5 = abstractC3112uo.f9102m;
        C3159wh c3159wh = new C3159wh(iOException, i);
        C3158wg m740a = C3161wj.m740a(C3161wj.m736e(this.f8426e.m1467d()), c3159wh);
        boolean m1460k = (m740a == null || m740a.f9294a != 2) ? false : this.f8426e.m1460k(abstractC3112uo, m740a.f9295b);
        if (m1460k) {
            if (z && m902k == 0) {
                ArrayList arrayList = this.f8434m;
                C2616ce.m2685h(((C2955ot) arrayList.remove(arrayList.size() + (-1))) == abstractC3112uo);
                if (this.f8434m.isEmpty()) {
                    this.f8414P = this.f8413O;
                } else {
                    ((C2955ot) axd.m4386z(this.f8434m)).m1450d();
                }
            }
            m716n = C3167wp.f9310b;
        } else {
            long m738c = C3161wj.m738c(c3159wh);
            m716n = m738c != C3282C.TIME_UNSET ? C3167wp.m716n(false, m738c) : C3167wp.f9311c;
        }
        C3158wg c3158wg = m716n;
        boolean z2 = !c3158wg.m743a();
        C3076tf c3076tf = this.f8431j;
        int i6 = abstractC3112uo.f9097h;
        int i7 = this.f8424c;
        C2962p c2962p2 = abstractC3112uo.f9098i;
        int i8 = abstractC3112uo.f9099j;
        Object obj2 = abstractC3112uo.f9100k;
        c3076tf.m1073r(c3059sp, i6, i7, c2962p2, i8, abstractC3112uo.f9101l, abstractC3112uo.f9102m, iOException, z2);
        if (z2) {
            this.f8441t = null;
            long j6 = abstractC3112uo.f9095f;
        }
        if (m1460k) {
            if (!this.f8401C) {
                mo875o(this.f8413O);
            } else {
                this.f8425d.mo934g(this);
            }
        }
        return c3158wg;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: be */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu mo489be(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2967pe.mo489be(int, int):com.google.ads.interactivemedia.v3.internal.zu");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bf */
    public final /* bridge */ /* synthetic */ void mo702bf(InterfaceC3163wl interfaceC3163wl, long j, long j2, boolean z) {
        AbstractC3112uo abstractC3112uo = (AbstractC3112uo) interfaceC3163wl;
        this.f8441t = null;
        long j3 = abstractC3112uo.f9095f;
        C2642dd c2642dd = abstractC3112uo.f9096g;
        abstractC3112uo.m901l();
        abstractC3112uo.m900m();
        abstractC3112uo.m902k();
        C3059sp c3059sp = new C3059sp();
        long j4 = abstractC3112uo.f9095f;
        C3076tf c3076tf = this.f8431j;
        int i = abstractC3112uo.f9097h;
        int i2 = this.f8424c;
        C2962p c2962p = abstractC3112uo.f9098i;
        int i3 = abstractC3112uo.f9099j;
        Object obj = abstractC3112uo.f9100k;
        c3076tf.m1075p(c3059sp, i, i2, c2962p, i3, abstractC3112uo.f9101l, abstractC3112uo.f9102m);
        if (z) {
            return;
        }
        if (m1400S() || this.f8402D == 0) {
            m1402Q();
        }
        if (this.f8402D > 0) {
            this.f8425d.mo934g(this);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        ArrayList arrayList;
        if (this.f8417S) {
            return Long.MIN_VALUE;
        }
        if (m1400S()) {
            return this.f8414P;
        }
        long j = this.f8413O;
        C2955ot m1407L = m1407L();
        if (!m1407L.mo849g()) {
            m1407L = this.f8434m.size() > 1 ? (C2955ot) this.f8434m.get(arrayList.size() - 2) : null;
        }
        if (m1407L != null) {
            j = Math.max(j, m1407L.f9102m);
        }
        if (this.f8400B) {
            for (C2966pd c2966pd : this.f8442u) {
                j = Math.max(j, c2966pd.m943r());
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        if (m1400S()) {
            return this.f8414P;
        }
        if (this.f8417S) {
            return Long.MIN_VALUE;
        }
        return m1407L().f9102m;
    }

    /* renamed from: d */
    public final int m1399d(int i) {
        m1405N();
        C2616ce.m2689d(this.f8408J);
        int i2 = this.f8408J[i];
        if (i2 == -1) {
            return this.f8407I.contains(this.f8406H.m4121b(i)) ? -3 : -2;
        }
        boolean[] zArr = this.f8411M;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    /* renamed from: e */
    public final int m1398e(int i, C2717fy c2717fy, C2669ed c2669ed, int i2) {
        C2962p c2962p;
        if (m1400S()) {
            return -3;
        }
        int i3 = 0;
        if (!this.f8434m.isEmpty()) {
            int i4 = 0;
            loop0: while (i4 < this.f8434m.size() - 1) {
                int i5 = ((C2955ot) this.f8434m.get(i4)).f8294a;
                int length = this.f8442u.length;
                for (int i6 = 0; i6 < length; i6++) {
                    if (this.f8411M[i6] && this.f8442u[i6].m947n() == i5) {
                        break loop0;
                    }
                }
                i4++;
            }
            C2628cq.m2565R(this.f8434m, 0, i4);
            C2955ot c2955ot = (C2955ot) this.f8434m.get(0);
            C2962p c2962p2 = c2955ot.f9098i;
            if (!c2962p2.equals(this.f8404F)) {
                C3076tf c3076tf = this.f8431j;
                int i7 = this.f8424c;
                int i8 = c2955ot.f9099j;
                Object obj = c2955ot.f9100k;
                c3076tf.m1076o(i7, c2962p2, i8, c2955ot.f9101l);
            }
            this.f8404F = c2962p2;
        }
        if (this.f8434m.isEmpty() || ((C2955ot) this.f8434m.get(0)).m1448h()) {
            int m946o = this.f8442u[i].m946o(c2717fy, c2669ed, i2, this.f8417S);
            if (m946o == -5) {
                C2962p c2962p3 = c2717fy.f7335b;
                C2616ce.m2689d(c2962p3);
                if (i == this.f8399A) {
                    int m947n = this.f8442u[i].m947n();
                    while (i3 < this.f8434m.size() && ((C2955ot) this.f8434m.get(i3)).f8294a != m947n) {
                        i3++;
                    }
                    if (i3 < this.f8434m.size()) {
                        c2962p = ((C2955ot) this.f8434m.get(i3)).f9098i;
                    } else {
                        c2962p = this.f8403E;
                        C2616ce.m2689d(c2962p);
                    }
                    c2962p3 = c2962p3.m1424d(c2962p);
                }
                c2717fy.f7335b = c2962p3;
            }
            return m946o;
        }
        return -3;
    }

    /* renamed from: f */
    public final int m1397f(int i, long j) {
        if (m1400S()) {
            return 0;
        }
        C2966pd c2966pd = this.f8442u[i];
        int m949l = c2966pd.m949l(j, this.f8417S);
        C2955ot c2955ot = (C2955ot) axd.m4419C(this.f8434m);
        if (c2955ot != null && !c2955ot.m1448h()) {
            m949l = Math.min(m949l, c2955ot.m1452a(i) - c2966pd.m950k());
        }
        c2966pd.m978G(m949l);
        return m949l;
    }

    /* renamed from: g */
    public final C2588bd m1396g() {
        m1405N();
        return this.f8406H;
    }

    /* renamed from: k */
    public final void m1393k() {
        if (this.f8401C) {
            return;
        }
        mo875o(this.f8413O);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
        C3167wp c3167wp = this.f8430i;
        if (c3167wp.m718l() || m1400S()) {
            return;
        }
        if (c3167wp.m717m()) {
            C2616ce.m2689d(this.f8441t);
            this.f8426e.m1456o(j, this.f8441t, this.f8435n);
            return;
        }
        int size = this.f8435n.size();
        while (size > 0) {
            int i = size - 1;
            if (this.f8426e.m1470a((C2955ot) this.f8435n.get(i)) != 2) {
                break;
            }
            size = i;
        }
        if (size < this.f8435n.size()) {
            m1404O(size);
        }
        int m1469b = this.f8426e.m1469b(j, this.f8435n);
        if (m1469b < this.f8434m.size()) {
            m1404O(m1469b);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: m */
    public final void mo488m() {
        this.f8418T = true;
        this.f8438q.post(this.f8437p);
    }

    /* renamed from: n */
    public final void m1392n() throws IOException {
        this.f8430i.mo715a();
        this.f8426e.m1465f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        List list;
        long max;
        C2966pd[] c2966pdArr;
        if (!this.f8417S) {
            C3167wp c3167wp = this.f8430i;
            if (!c3167wp.m717m() && !c3167wp.m718l()) {
                if (m1400S()) {
                    list = Collections.emptyList();
                    max = this.f8414P;
                    for (C2966pd c2966pd : this.f8442u) {
                        c2966pd.m980E(this.f8414P);
                    }
                } else {
                    list = this.f8435n;
                    C2955ot m1407L = m1407L();
                    if (m1407L.mo849g()) {
                        max = m1407L.f9102m;
                    } else {
                        max = Math.max(this.f8413O, m1407L.f9101l);
                    }
                }
                List list2 = list;
                long j2 = max;
                this.f8433l.m1471a();
                this.f8426e.m1466e(j, j2, list2, this.f8401C || !list2.isEmpty(), this.f8433l);
                C2949on c2949on = this.f8433l;
                boolean z = c2949on.f8253b;
                AbstractC3112uo abstractC3112uo = c2949on.f8252a;
                Uri uri = c2949on.f8254c;
                if (z) {
                    this.f8414P = C3282C.TIME_UNSET;
                    this.f8417S = true;
                    return true;
                } else if (abstractC3112uo == null) {
                    if (uri != null) {
                        this.f8425d.mo1422m(uri);
                    }
                    return false;
                } else {
                    if (abstractC3112uo instanceof C2955ot) {
                        C2955ot c2955ot = (C2955ot) abstractC3112uo;
                        this.f8421W = c2955ot;
                        this.f8403E = c2955ot.f9098i;
                        this.f8414P = C3282C.TIME_UNSET;
                        this.f8434m.add(c2955ot);
                        avm m4509t = avg.m4509t();
                        for (C2966pd c2966pd2 : this.f8442u) {
                            m4509t.m4498f(Integer.valueOf(c2966pd2.m948m()));
                        }
                        c2955ot.m1451c(this, m4509t.m4499e());
                        for (C2966pd c2966pd3 : this.f8442u) {
                            c2966pd3.m1418g(c2955ot);
                            if (c2955ot.f8297d) {
                                c2966pd3.m976I();
                            }
                        }
                    }
                    this.f8441t = abstractC3112uo;
                    this.f8430i.m728b(abstractC3112uo, this, C3161wj.m739b(abstractC3112uo.f9097h));
                    this.f8431j.m1072s(new C3059sp(abstractC3112uo.f9096g), abstractC3112uo.f9097h, this.f8424c, abstractC3112uo.f9098i, abstractC3112uo.f9099j, abstractC3112uo.f9101l, abstractC3112uo.f9102m);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        return this.f8430i.m717m();
    }

    /* renamed from: q */
    public final void m1391q(int i) throws IOException {
        m1392n();
        this.f8442u[i].m936y();
    }

    /* renamed from: r */
    public final void m1390r() throws IOException {
        m1392n();
        if (this.f8417S && !this.f8401C) {
            throw C2555ao.m4866a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3164wm
    /* renamed from: s */
    public final void mo729s() {
        for (C2966pd c2966pd : this.f8442u) {
            c2966pd.m984A();
        }
    }

    /* renamed from: t */
    public final void m1389t() {
        this.f8444w.clear();
    }

    /* renamed from: u */
    public final void m1388u() {
        if (this.f8434m.isEmpty()) {
            return;
        }
        C2955ot c2955ot = (C2955ot) axd.m4386z(this.f8434m);
        int m1470a = this.f8426e.m1470a(c2955ot);
        if (m1470a == 1) {
            c2955ot.m1449f();
        } else if (m1470a != 2 || this.f8417S) {
        } else {
            C3167wp c3167wp = this.f8430i;
            if (c3167wp.m717m()) {
                c3167wp.m723g();
            }
        }
    }

    /* renamed from: v */
    public final void m1387v() {
        if (this.f8401C) {
            for (C2966pd c2966pd : this.f8442u) {
                c2966pd.m935z();
            }
        }
        this.f8430i.m719k(this);
        this.f8438q.removeCallbacksAndMessages(null);
        this.f8405G = true;
        this.f8439r.clear();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: w */
    public final void mo487w(InterfaceC3250zr interfaceC3250zr) {
    }

    /* renamed from: x */
    public final void m1386x(C2854l c2854l) {
        if (C2628cq.m2563T(this.f8420V, c2854l)) {
            return;
        }
        this.f8420V = c2854l;
        int i = 0;
        while (true) {
            C2966pd[] c2966pdArr = this.f8442u;
            if (i >= c2966pdArr.length) {
                return;
            }
            if (this.f8412N[i]) {
                c2966pdArr[i].m1419d(c2854l);
            }
            i++;
        }
    }

    /* renamed from: y */
    public final void m1385y(boolean z) {
        this.f8426e.m1462i(z);
    }

    /* renamed from: z */
    public final void m1384z(long j) {
        if (this.f8419U != j) {
            this.f8419U = j;
            for (C2966pd c2966pd : this.f8442u) {
                c2966pd.m981D(j);
            }
        }
    }
}
