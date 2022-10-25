package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.source.hls.HlsMediaChunk;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ot */
/* loaded from: classes2.dex */
public final class C2955ot extends AbstractC3122uy {

    /* renamed from: p */
    private static final AtomicInteger f8281p = new AtomicInteger();

    /* renamed from: A */
    private final boolean f8282A;

    /* renamed from: B */
    private final boolean f8283B;

    /* renamed from: C */
    private C2967pe f8284C;

    /* renamed from: D */
    private int f8285D;

    /* renamed from: E */
    private boolean f8286E;

    /* renamed from: F */
    private volatile boolean f8287F;

    /* renamed from: G */
    private boolean f8288G;

    /* renamed from: H */
    private avg f8289H;

    /* renamed from: I */
    private boolean f8290I;

    /* renamed from: J */
    private boolean f8291J;

    /* renamed from: K */
    private final C2943oh f8292K;

    /* renamed from: L */
    private C2943oh f8293L;

    /* renamed from: a */
    public final int f8294a;

    /* renamed from: b */
    public final int f8295b;

    /* renamed from: c */
    public final Uri f8296c;

    /* renamed from: d */
    public final boolean f8297d;

    /* renamed from: e */
    public final int f8298e;

    /* renamed from: q */
    private final InterfaceC2637cz f8299q;

    /* renamed from: r */
    private final C2642dd f8300r;

    /* renamed from: s */
    private final boolean f8301s;

    /* renamed from: t */
    private final boolean f8302t;

    /* renamed from: u */
    private final C2626co f8303u;

    /* renamed from: v */
    private final InterfaceC2954os f8304v;

    /* renamed from: w */
    private final List f8305w;

    /* renamed from: x */
    private final C2854l f8306x;

    /* renamed from: y */
    private final aap f8307y;

    /* renamed from: z */
    private final C2621cj f8308z;

    private C2955ot(InterfaceC2954os interfaceC2954os, InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, boolean z, InterfaceC2637cz interfaceC2637cz2, C2642dd c2642dd2, boolean z2, Uri uri, List list, int i, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, C2626co c2626co, C2854l c2854l, C2943oh c2943oh, aap aapVar, C2621cj c2621cj, boolean z6) {
        super(interfaceC2637cz, c2642dd, c2962p, i, j, j2, j3);
        this.f8282A = z;
        this.f8298e = i2;
        this.f8291J = z3;
        this.f8295b = i3;
        this.f8300r = c2642dd2;
        this.f8299q = interfaceC2637cz2;
        this.f8286E = c2642dd2 != null;
        this.f8283B = z2;
        this.f8296c = uri;
        this.f8301s = z5;
        this.f8303u = c2626co;
        this.f8302t = z4;
        this.f8304v = interfaceC2954os;
        this.f8305w = list;
        this.f8306x = c2854l;
        this.f8292K = c2943oh;
        this.f8307y = aapVar;
        this.f8308z = c2621cj;
        this.f8297d = z6;
        this.f8289H = avg.m4515n();
        this.f8294a = f8281p.getAndIncrement();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
        if (r5.f8561v != false) goto L24;
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m1447i(com.google.ads.interactivemedia.p034v3.internal.C2955ot r3, android.net.Uri r4, com.google.ads.interactivemedia.p034v3.internal.C2990qa r5, com.google.ads.interactivemedia.p034v3.internal.C2952oq r6, long r7) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            android.net.Uri r1 = r3.f8296c
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L12
            boolean r4 = r3.f8288G
            if (r4 != 0) goto L11
            goto L12
        L11:
            return r0
        L12:
            com.google.ads.interactivemedia.v3.internal.py r4 = r6.f8258a
            long r1 = r4.f8528g
            long r7 = r7 + r1
            boolean r1 = r4 instanceof com.google.ads.interactivemedia.p034v3.internal.C2984pv
            r2 = 1
            if (r1 == 0) goto L2f
            com.google.ads.interactivemedia.v3.internal.pv r4 = (com.google.ads.interactivemedia.p034v3.internal.C2984pv) r4
            boolean r4 = r4.f8517a
            if (r4 != 0) goto L2d
            int r4 = r6.f8260c
            if (r4 != 0) goto L2b
            boolean r4 = r5.f8561v
            if (r4 == 0) goto L3b
            goto L2d
        L2b:
            r4 = 0
            goto L31
        L2d:
            r4 = 1
            goto L31
        L2f:
            boolean r4 = r5.f8561v
        L31:
            if (r4 == 0) goto L3b
            long r3 = r3.f9102m
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L3a
            goto L3b
        L3a:
            return r0
        L3b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2955ot.m1447i(com.google.ads.interactivemedia.v3.internal.ot, android.net.Uri, com.google.ads.interactivemedia.v3.internal.qa, com.google.ads.interactivemedia.v3.internal.oq, long):boolean");
    }

    /* renamed from: j */
    public static C2955ot m1446j(InterfaceC2954os interfaceC2954os, InterfaceC2637cz interfaceC2637cz, C2962p c2962p, long j, C2990qa c2990qa, C2952oq c2952oq, Uri uri, List list, int i, boolean z, C2972pj c2972pj, C2955ot c2955ot, byte[] bArr, byte[] bArr2, boolean z2) {
        byte[] bArr3;
        C2642dd c2642dd;
        InterfaceC2637cz interfaceC2637cz2;
        boolean z3;
        aap aapVar;
        C2943oh c2943oh;
        C2621cj c2621cj;
        byte[] bArr4;
        C2987py c2987py = c2952oq.f8258a;
        C2641dc c2641dc = new C2641dc();
        c2641dc.m2492i(C2616ce.m2675r(c2990qa.f8559t, c2987py.f8524c));
        c2641dc.m2493h(c2987py.f8532k);
        c2641dc.m2494g(c2987py.f8533l);
        c2641dc.m2499b(true != c2952oq.f8261d ? 0 : 8);
        C2642dd m2500a = c2641dc.m2500a();
        boolean z4 = bArr != null;
        if (z4) {
            String str = c2987py.f8531j;
            C2616ce.m2689d(str);
            bArr3 = m1442q(str);
        } else {
            bArr3 = null;
        }
        InterfaceC2637cz m1444o = m1444o(interfaceC2637cz, bArr, bArr3);
        C2986px c2986px = c2987py.f8525d;
        if (c2986px != null) {
            boolean z5 = bArr2 != null;
            if (z5) {
                String str2 = c2986px.f8531j;
                C2616ce.m2689d(str2);
                bArr4 = m1442q(str2);
            } else {
                bArr4 = null;
            }
            C2642dd c2642dd2 = new C2642dd(C2616ce.m2675r(c2990qa.f8559t, c2986px.f8524c), c2986px.f8532k, c2986px.f8533l);
            z3 = z5;
            interfaceC2637cz2 = m1444o(interfaceC2637cz, bArr2, bArr4);
            c2642dd = c2642dd2;
        } else {
            c2642dd = null;
            interfaceC2637cz2 = null;
            z3 = false;
        }
        long j2 = j + c2987py.f8528g;
        long j3 = j2 + c2987py.f8526e;
        int i2 = c2990qa.f8546g + c2987py.f8527f;
        if (c2955ot != null) {
            C2642dd c2642dd3 = c2955ot.f8300r;
            boolean z6 = c2642dd == c2642dd3 || (c2642dd != null && c2642dd3 != null && c2642dd.f7011a.equals(c2642dd3.f7011a) && c2642dd.f7015e == c2955ot.f8300r.f7015e);
            boolean z7 = uri.equals(c2955ot.f8296c) && c2955ot.f8288G;
            aap aapVar2 = c2955ot.f8307y;
            C2621cj c2621cj2 = c2955ot.f8308z;
            c2943oh = (z6 && z7 && !c2955ot.f8290I && c2955ot.f8295b == i2) ? c2955ot.f8293L : null;
            aapVar = aapVar2;
            c2621cj = c2621cj2;
        } else {
            aapVar = new aap(null);
            c2943oh = null;
            c2621cj = new C2621cj(10);
        }
        return new C2955ot(interfaceC2954os, m1444o, m2500a, c2962p, z4, interfaceC2637cz2, c2642dd, z3, uri, list, i, j2, j3, c2952oq.f8259b, c2952oq.f8260c, !c2952oq.f8261d, i2, c2987py.f8534m, z, c2972pj.m1382a(i2), c2987py.f8529h, c2943oh, aapVar, c2621cj, z2);
    }

    /* renamed from: n */
    private final long m1445n(InterfaceC3230yy interfaceC3230yy) throws IOException {
        interfaceC3230yy.mo494h();
        try {
            this.f8308z.m2648B(10);
            interfaceC3230yy.mo496f(this.f8308z.m2642H(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.f8308z.m2631k() != 4801587) {
            return C3282C.TIME_UNSET;
        }
        this.f8308z.m2643G(3);
        int m2634h = this.f8308z.m2634h();
        int i = m2634h + 10;
        if (i > this.f8308z.m2640b()) {
            C2621cj c2621cj = this.f8308z;
            byte[] m2642H = c2621cj.m2642H();
            c2621cj.m2648B(i);
            System.arraycopy(m2642H, 0, this.f8308z.m2642H(), 0, 10);
        }
        interfaceC3230yy.mo496f(this.f8308z.m2642H(), 10, m2634h);
        C2549ak m5975c = this.f8307y.m5975c(this.f8308z.m2642H(), m2634h);
        if (m5975c == null) {
            return C3282C.TIME_UNSET;
        }
        int m5127a = m5975c.m5127a();
        for (int i2 = 0; i2 < m5127a; i2++) {
            InterfaceC2548aj m5126b = m5975c.m5126b(i2);
            if (m5126b instanceof aat) {
                aat aatVar = (aat) m5126b;
                if (HlsMediaChunk.PRIV_TIMESTAMP_FRAME_OWNER.equals(aatVar.f2926a)) {
                    System.arraycopy(aatVar.f2927b, 0, this.f8308z.m2642H(), 0, 8);
                    this.f8308z.m2644F(0);
                    this.f8308z.m2645E(8);
                    return this.f8308z.m2627o() & 8589934591L;
                }
            }
        }
        return C3282C.TIME_UNSET;
    }

    /* renamed from: o */
    private static InterfaceC2637cz m1444o(InterfaceC2637cz interfaceC2637cz, byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            C2616ce.m2689d(bArr2);
            return new C2942og(interfaceC2637cz, bArr, bArr2);
        }
        return interfaceC2637cz;
    }

    /* renamed from: q */
    private static byte[] m1442q(String str) {
        if (anx.m4881c(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length;
        int i = length > 16 ? length - 16 : 0;
        System.arraycopy(byteArray, i, bArr, (16 - length) + i, length - i);
        return bArr;
    }

    /* renamed from: a */
    public final int m1452a(int i) {
        C2616ce.m2685h(!this.f8297d);
        if (i >= this.f8289H.size()) {
            return 0;
        }
        return ((Integer) this.f8289H.get(i)).intValue();
    }

    /* renamed from: c */
    public final void m1451c(C2967pe c2967pe, avg avgVar) {
        this.f8284C = c2967pe;
        this.f8289H = avgVar;
    }

    /* renamed from: d */
    public final void m1450d() {
        this.f8290I = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: e */
    public final void mo701e() throws IOException {
        C2943oh c2943oh;
        C2616ce.m2689d(this.f8284C);
        if (this.f8293L == null && (c2943oh = this.f8292K) != null && c2943oh.m1482a()) {
            this.f8293L = this.f8292K;
            this.f8286E = false;
        }
        if (this.f8286E) {
            C2616ce.m2689d(this.f8299q);
            C2616ce.m2689d(this.f8300r);
            m1443p(this.f8299q, this.f8300r, this.f8283B);
            this.f8285D = 0;
            this.f8286E = false;
        }
        if (this.f8287F) {
            return;
        }
        if (!this.f8302t) {
            try {
                this.f8303u.m2583i(this.f8301s, this.f9101l);
                m1443p(this.f9103n, this.f9096g, this.f8282A);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        this.f8288G = !this.f8287F;
    }

    /* renamed from: f */
    public final void m1449f() {
        this.f8291J = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3122uy
    /* renamed from: g */
    public final boolean mo849g() {
        return this.f8288G;
    }

    /* renamed from: h */
    public final boolean m1448h() {
        return this.f8291J;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: r */
    public final void mo700r() {
        this.f8287F = true;
    }

    /* renamed from: p */
    private final void m1443p(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, boolean z) throws IOException {
        C2642dd m2489b;
        InterfaceC2637cz interfaceC2637cz2;
        C3223yr c3223yr;
        long mo498d;
        long j;
        C2943oh m1478a;
        long j2;
        if (!z) {
            m2489b = c2642dd.m2489b(this.f8285D);
            interfaceC2637cz2 = interfaceC2637cz;
        } else {
            r0 = this.f8285D != 0;
            interfaceC2637cz2 = interfaceC2637cz;
            m2489b = c2642dd;
        }
        try {
            C3223yr c3223yr2 = new C3223yr(interfaceC2637cz, m2489b.f7015e, interfaceC2637cz2.mo1127b(m2489b));
            if (this.f8293L == null) {
                long m1445n = m1445n(c3223yr2);
                c3223yr2.mo494h();
                C2943oh c2943oh = this.f8292K;
                if (c2943oh != null) {
                    m1478a = c2943oh.m1480c();
                    c3223yr = c3223yr2;
                } else {
                    c3223yr = c3223yr2;
                    m1478a = ((C2945oj) this.f8304v).m1478a(m2489b.f7011a, this.f9098i, this.f8305w, this.f8303u, interfaceC2637cz.mo1124e(), c3223yr);
                }
                this.f8293L = m1478a;
                InterfaceC3229yx interfaceC3229yx = m1478a.f8245a;
                if (!(interfaceC3229yx instanceof adb) && !(interfaceC3229yx instanceof acw) && !(interfaceC3229yx instanceof acz) && !(interfaceC3229yx instanceof abn)) {
                    this.f8284C.m1384z(0L);
                    this.f8284C.m1389t();
                    this.f8293L.f8245a.mo431b(this.f8284C);
                }
                C2967pe c2967pe = this.f8284C;
                if (m1445n != C3282C.TIME_UNSET) {
                    j2 = this.f8303u.m2590b(m1445n);
                } else {
                    j2 = this.f9101l;
                }
                c2967pe.m1384z(j2);
                this.f8284C.m1389t();
                this.f8293L.f8245a.mo431b(this.f8284C);
            } else {
                c3223yr = c3223yr2;
            }
            this.f8284C.m1386x(this.f8306x);
            if (r0) {
                c3223yr.mo493i(this.f8285D);
            }
            do {
                try {
                    if (this.f8287F) {
                        break;
                    }
                } catch (EOFException e) {
                    if ((this.f9098i.f8365e & 16384) != 0) {
                        this.f8293L.f8245a.mo429d(0L, 0L);
                        mo498d = c3223yr.mo498d();
                        j = c2642dd.f7015e;
                    } else {
                        throw e;
                    }
                }
            } while (this.f8293L.m1481b(c3223yr));
            mo498d = c3223yr.mo498d();
            j = c2642dd.f7015e;
            this.f8285D = (int) (mo498d - j);
        } finally {
            C2616ce.m2682k(interfaceC2637cz);
        }
    }
}
