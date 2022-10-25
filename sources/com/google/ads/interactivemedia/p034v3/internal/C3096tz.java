package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Looper;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tz */
/* loaded from: classes2.dex */
public class C3096tz implements InterfaceC3253zu {

    /* renamed from: A */
    private boolean f9006A;

    /* renamed from: B */
    private C2962p f9007B;

    /* renamed from: C */
    private C2962p f9008C;

    /* renamed from: D */
    private int f9009D;

    /* renamed from: E */
    private boolean f9010E;

    /* renamed from: F */
    private boolean f9011F;

    /* renamed from: G */
    private long f9012G;

    /* renamed from: H */
    private boolean f9013H;

    /* renamed from: a */
    private final C3092tv f9014a;

    /* renamed from: d */
    private final InterfaceC2921nm f9017d;

    /* renamed from: e */
    private final C2915ng f9018e;

    /* renamed from: f */
    private final Looper f9019f;

    /* renamed from: g */
    private InterfaceC3095ty f9020g;

    /* renamed from: h */
    private C2962p f9021h;

    /* renamed from: i */
    private InterfaceC2910nb f9022i;

    /* renamed from: q */
    private int f9030q;

    /* renamed from: r */
    private int f9031r;

    /* renamed from: s */
    private int f9032s;

    /* renamed from: t */
    private int f9033t;

    /* renamed from: x */
    private boolean f9037x;

    /* renamed from: b */
    private final C3093tw f9015b = new C3093tw();

    /* renamed from: j */
    private int f9023j = 1000;

    /* renamed from: k */
    private int[] f9024k = new int[1000];

    /* renamed from: l */
    private long[] f9025l = new long[1000];

    /* renamed from: o */
    private long[] f9028o = new long[1000];

    /* renamed from: n */
    private int[] f9027n = new int[1000];

    /* renamed from: m */
    private int[] f9026m = new int[1000];

    /* renamed from: p */
    private C3252zt[] f9029p = new C3252zt[1000];

    /* renamed from: c */
    private final C3104ug f9016c = new C3104ug(C3103uf.f9062b);

    /* renamed from: u */
    private long f9034u = Long.MIN_VALUE;

    /* renamed from: v */
    private long f9035v = Long.MIN_VALUE;

    /* renamed from: w */
    private long f9036w = Long.MIN_VALUE;

    /* renamed from: z */
    private boolean f9039z = true;

    /* renamed from: y */
    private boolean f9038y = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C3096tz(C3154wc c3154wc, Looper looper, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng) {
        this.f9019f = looper;
        this.f9017d = interfaceC2921nm;
        this.f9018e = c2915ng;
        this.f9014a = new C3092tv(c3154wc);
    }

    /* renamed from: N */
    public static C3096tz m971N(C3154wc c3154wc, Looper looper, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng) {
        C2616ce.m2689d(looper);
        C2616ce.m2689d(interfaceC2921nm);
        return new C3096tz(c3154wc, looper, interfaceC2921nm, c2915ng);
    }

    /* renamed from: O */
    public static C3096tz m970O(C3154wc c3154wc) {
        return new C3096tz(c3154wc, null, null, null);
    }

    /* renamed from: Q */
    private final synchronized int m968Q(C2717fy c2717fy, C2669ed c2669ed, boolean z, boolean z2, C3093tw c3093tw) {
        c2669ed.f7093c = false;
        if (!m958aa()) {
            if (!z2 && !this.f9037x) {
                C2962p c2962p = this.f9008C;
                if (c2962p == null || (!z && c2962p == this.f9021h)) {
                    return -3;
                }
                C2616ce.m2689d(c2962p);
                m962W(c2962p, c2717fy);
                return -5;
            }
            c2669ed.m2466c(4);
            return -4;
        }
        C2962p c2962p2 = ((C3094tx) this.f9016c.m918a(m950k())).f9004a;
        if (!z && c2962p2 == this.f9021h) {
            int m952g = m952g(this.f9033t);
            if (!m957ab(m952g)) {
                c2669ed.f7093c = true;
                return -3;
            }
            c2669ed.m2466c(this.f9027n[m952g]);
            long j = this.f9028o[m952g];
            c2669ed.f7094d = j;
            if (j < this.f9034u) {
                c2669ed.m2467a(Integer.MIN_VALUE);
            }
            c3093tw.f9001a = this.f9026m[m952g];
            c3093tw.f9002b = this.f9025l[m952g];
            c3093tw.f9003c = this.f9029p[m952g];
            return -4;
        }
        m962W(c2962p2, c2717fy);
        return -5;
    }

    /* renamed from: R */
    private final synchronized long m967R() {
        int i = this.f9030q;
        if (i == 0) {
            return -1L;
        }
        return m966S(i);
    }

    /* renamed from: S */
    private final long m966S(int i) {
        int i2;
        this.f9035v = Math.max(this.f9035v, m964U(i));
        this.f9030q -= i;
        int i3 = this.f9031r + i;
        this.f9031r = i3;
        int i4 = this.f9032s + i;
        this.f9032s = i4;
        int i5 = this.f9023j;
        if (i4 >= i5) {
            this.f9032s = i4 - i5;
        }
        int i6 = this.f9033t - i;
        this.f9033t = i6;
        if (i6 < 0) {
            this.f9033t = 0;
        }
        this.f9016c.m913f(i3);
        if (this.f9030q == 0) {
            int i7 = this.f9032s;
            if (i7 == 0) {
                i7 = this.f9023j;
            }
            return this.f9025l[i7 - 1] + this.f9026m[i2];
        }
        return this.f9025l[this.f9032s];
    }

    /* renamed from: T */
    private final long m965T(int i) {
        int m948m = m948m() - i;
        boolean z = true;
        C2616ce.m2687f(m948m >= 0 && m948m <= this.f9030q - this.f9033t);
        int i2 = this.f9030q - m948m;
        this.f9030q = i2;
        this.f9036w = Math.max(this.f9035v, m964U(i2));
        this.f9037x = (m948m == 0 && this.f9037x) ? false : false;
        this.f9016c.m914e(i);
        int i3 = this.f9030q;
        if (i3 != 0) {
            int m952g = m952g(i3 - 1);
            return this.f9025l[m952g] + this.f9026m[m952g];
        }
        return 0L;
    }

    /* renamed from: U */
    private final long m964U(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int m952g = m952g(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.f9028o[m952g]);
            if ((this.f9027n[m952g] & 1) != 0) {
                break;
            }
            m952g--;
            if (m952g == -1) {
                m952g = this.f9023j - 1;
            }
        }
        return j;
    }

    /* renamed from: V */
    private final synchronized void m963V(long j, int i, long j2, int i2, C3252zt c3252zt) {
        InterfaceC2920nl interfaceC2920nl;
        int i3 = this.f9030q;
        if (i3 > 0) {
            int m952g = m952g(i3 - 1);
            C2616ce.m2687f(this.f9025l[m952g] + ((long) this.f9026m[m952g]) <= j2);
        }
        this.f9037x = (536870912 & i) != 0;
        this.f9036w = Math.max(this.f9036w, j);
        int m952g2 = m952g(this.f9030q);
        this.f9028o[m952g2] = j;
        this.f9025l[m952g2] = j2;
        this.f9026m[m952g2] = i2;
        this.f9027n[m952g2] = i;
        this.f9029p[m952g2] = c3252zt;
        this.f9024k[m952g2] = this.f9009D;
        if (this.f9016c.m912g() || !((C3094tx) this.f9016c.m917b()).f9004a.equals(this.f9008C)) {
            InterfaceC2921nm interfaceC2921nm = this.f9017d;
            if (interfaceC2921nm != null) {
                Looper looper = this.f9019f;
                C2616ce.m2689d(looper);
                interfaceC2920nl = interfaceC2921nm.mo1585j(looper, this.f9018e, this.f9008C);
            } else {
                interfaceC2920nl = InterfaceC2920nl.f8187b;
            }
            C3104ug c3104ug = this.f9016c;
            int m948m = m948m();
            C2962p c2962p = this.f9008C;
            C2616ce.m2689d(c2962p);
            c3104ug.m916c(m948m, new C3094tx(c2962p, interfaceC2920nl));
        }
        int i4 = this.f9030q + 1;
        this.f9030q = i4;
        int i5 = this.f9023j;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            C3252zt[] c3252ztArr = new C3252zt[i6];
            int i7 = this.f9032s;
            int i8 = i5 - i7;
            System.arraycopy(this.f9025l, i7, jArr, 0, i8);
            System.arraycopy(this.f9028o, this.f9032s, jArr2, 0, i8);
            System.arraycopy(this.f9027n, this.f9032s, iArr2, 0, i8);
            System.arraycopy(this.f9026m, this.f9032s, iArr3, 0, i8);
            System.arraycopy(this.f9029p, this.f9032s, c3252ztArr, 0, i8);
            System.arraycopy(this.f9024k, this.f9032s, iArr, 0, i8);
            int i9 = this.f9032s;
            System.arraycopy(this.f9025l, 0, jArr, i8, i9);
            System.arraycopy(this.f9028o, 0, jArr2, i8, i9);
            System.arraycopy(this.f9027n, 0, iArr2, i8, i9);
            System.arraycopy(this.f9026m, 0, iArr3, i8, i9);
            System.arraycopy(this.f9029p, 0, c3252ztArr, i8, i9);
            System.arraycopy(this.f9024k, 0, iArr, i8, i9);
            this.f9025l = jArr;
            this.f9028o = jArr2;
            this.f9027n = iArr2;
            this.f9026m = iArr3;
            this.f9029p = c3252ztArr;
            this.f9024k = iArr;
            this.f9032s = 0;
            this.f9023j = i6;
        }
    }

    /* renamed from: X */
    private final void m961X() {
        InterfaceC2910nb interfaceC2910nb = this.f9022i;
        if (interfaceC2910nb != null) {
            interfaceC2910nb.mo1570m(this.f9018e);
            this.f9022i = null;
            this.f9021h = null;
        }
    }

    /* renamed from: Y */
    private final synchronized void m960Y() {
        this.f9033t = 0;
        this.f9014a.m994h();
    }

    /* renamed from: Z */
    private final synchronized boolean m959Z(long j) {
        if (this.f9030q == 0) {
            return j > this.f9035v;
        } else if (m942s() >= j) {
            return false;
        } else {
            int i = this.f9030q;
            int m952g = m952g(i - 1);
            while (i > this.f9033t && this.f9028o[m952g] >= j) {
                i--;
                m952g--;
                if (m952g == -1) {
                    m952g = this.f9023j - 1;
                }
            }
            m965T(this.f9031r + i);
            return true;
        }
    }

    /* renamed from: aa */
    private final boolean m958aa() {
        return this.f9033t != this.f9030q;
    }

    /* renamed from: ab */
    private final boolean m957ab(int i) {
        InterfaceC2910nb interfaceC2910nb = this.f9022i;
        return interfaceC2910nb == null || interfaceC2910nb.mo1576a() == 4 || ((this.f9027n[i] & 1073741824) == 0 && this.f9022i.mo1569o());
    }

    /* renamed from: ac */
    private final synchronized boolean m956ac(C2962p c2962p) {
        this.f9039z = false;
        if (C2628cq.m2563T(c2962p, this.f9008C)) {
            return false;
        }
        if (!this.f9016c.m912g() && ((C3094tx) this.f9016c.m917b()).f9004a.equals(c2962p)) {
            this.f9008C = ((C3094tx) this.f9016c.m917b()).f9004a;
        } else {
            this.f9008C = c2962p;
        }
        C2962p c2962p2 = this.f9008C;
        this.f9010E = C2554an.m4966k(c2962p2.f8372l, c2962p2.f8369i);
        this.f9011F = false;
        return true;
    }

    /* renamed from: ad */
    private final synchronized long m955ad(long j, boolean z) {
        int i;
        int i2 = this.f9030q;
        if (i2 != 0) {
            long[] jArr = this.f9028o;
            int i3 = this.f9032s;
            if (j >= jArr[i3]) {
                if (z && (i = this.f9033t) != i2) {
                    i2 = i + 1;
                }
                int m953d = m953d(i3, i2, j, false);
                if (m953d == -1) {
                    return -1L;
                }
                return m966S(m953d);
            }
        }
        return -1L;
    }

    /* renamed from: d */
    private final int m953d(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (this.f9028o[i] > j ? 1 : (this.f9028o[i] == j ? 0 : -1));
            if (i5 > 0) {
                break;
            }
            if (!z || (this.f9027n[i] & 1) != 0) {
                i3 = i4;
                if (i5 == 0) {
                    break;
                }
            }
            i++;
            if (i == this.f9023j) {
                i = 0;
            }
        }
        return i3;
    }

    /* renamed from: g */
    private final int m952g(int i) {
        int i2 = this.f9032s + i;
        int i3 = this.f9023j;
        return i2 < i3 ? i2 : i2 - i3;
    }

    /* renamed from: A */
    public final void m984A() {
        m982C(true);
        m961X();
    }

    /* renamed from: B */
    public final void m983B() {
        m982C(false);
    }

    /* renamed from: C */
    public final void m982C(boolean z) {
        this.f9014a.m995g();
        this.f9030q = 0;
        this.f9031r = 0;
        this.f9032s = 0;
        this.f9033t = 0;
        this.f9038y = true;
        this.f9034u = Long.MIN_VALUE;
        this.f9035v = Long.MIN_VALUE;
        this.f9036w = Long.MIN_VALUE;
        this.f9037x = false;
        this.f9016c.m915d();
        if (z) {
            this.f9007B = null;
            this.f9008C = null;
            this.f9039z = true;
        }
    }

    /* renamed from: D */
    public final void m981D(long j) {
        if (this.f9012G != j) {
            this.f9012G = j;
            m937x();
        }
    }

    /* renamed from: E */
    public final void m980E(long j) {
        this.f9034u = j;
    }

    /* renamed from: F */
    public final void m979F(InterfaceC3095ty interfaceC3095ty) {
        this.f9020g = interfaceC3095ty;
    }

    /* renamed from: G */
    public final synchronized void m978G(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.f9033t + i <= this.f9030q) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C2616ce.m2687f(z);
        this.f9033t += i;
    }

    /* renamed from: H */
    public final void m977H(int i) {
        this.f9009D = i;
    }

    /* renamed from: I */
    public final void m976I() {
        this.f9013H = true;
    }

    /* renamed from: J */
    public final synchronized boolean m975J() {
        return this.f9037x;
    }

    /* renamed from: K */
    public final synchronized boolean m974K(boolean z) {
        boolean z2 = true;
        if (m958aa()) {
            if (((C3094tx) this.f9016c.m918a(m950k())).f9004a != this.f9021h) {
                return true;
            }
            return m957ab(m952g(this.f9033t));
        }
        if (!z && !this.f9037x) {
            C2962p c2962p = this.f9008C;
            if (c2962p == null) {
                z2 = false;
            } else if (c2962p == this.f9021h) {
                return false;
            }
        }
        return z2;
    }

    /* renamed from: L */
    public final synchronized boolean m973L(int i) {
        boolean z;
        m960Y();
        int i2 = this.f9031r;
        if (i >= i2 && i <= this.f9030q + i2) {
            this.f9034u = Long.MIN_VALUE;
            this.f9033t = i - i2;
            z = true;
        }
        z = false;
        return z;
    }

    /* renamed from: M */
    public final synchronized boolean m972M(long j, boolean z) {
        m960Y();
        int i = this.f9033t;
        int m952g = m952g(i);
        if (!m958aa() || j < this.f9028o[m952g] || (j > this.f9036w && !z)) {
            return false;
        }
        int m953d = m953d(m952g, this.f9030q - i, j, true);
        if (m953d == -1) {
            return false;
        }
        this.f9034u = j;
        this.f9033t += m953d;
        return true;
    }

    /* renamed from: P */
    public final void m969P(long j, boolean z) {
        this.f9014a.m999c(m955ad(j, z));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: a */
    public final /* synthetic */ int mo444a(InterfaceC2746h interfaceC2746h, int i, boolean z) {
        return C2539ab.m5959e(this, interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: b */
    public final void mo443b(C2962p c2962p) {
        C2962p mo954c = mo954c(c2962p);
        this.f9006A = false;
        this.f9007B = c2962p;
        boolean m956ac = m956ac(mo954c);
        InterfaceC3095ty interfaceC3095ty = this.f9020g;
        if (interfaceC3095ty == null || !m956ac) {
            return;
        }
        interfaceC3095ty.mo985G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public C2962p mo954c(C2962p c2962p) {
        if (this.f9012G == 0 || c2962p.f8376p == Long.MAX_VALUE) {
            return c2962p;
        }
        C2935o m1426b = c2962p.m1426b();
        m1426b.m1528ai(c2962p.f8376p + this.f9012G);
        return m1426b.m1506v();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: e */
    public final /* synthetic */ void mo442e(C2621cj c2621cj, int i) {
        C2539ab.m5958f(this, c2621cj, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo441f(long r12, int r14, int r15, int r16, com.google.ads.interactivemedia.p034v3.internal.C3252zt r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f9006A
            if (r0 == 0) goto Ld
            com.google.ads.interactivemedia.v3.internal.p r0 = r8.f9007B
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2688e(r0)
            r11.mo443b(r0)
        Ld:
            r0 = r14 & 1
            boolean r1 = r8.f9038y
            r2 = 0
            if (r1 == 0) goto L19
            if (r0 != 0) goto L17
            return
        L17:
            r8.f9038y = r2
        L19:
            long r3 = r8.f9012G
            long r3 = r3 + r12
            boolean r1 = r8.f9010E
            if (r1 == 0) goto L50
            long r5 = r8.f9034u
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L27
            return
        L27:
            if (r0 != 0) goto L50
            boolean r1 = r8.f9011F
            if (r1 != 0) goto L4c
            com.google.ads.interactivemedia.v3.internal.p r1 = r8.f9008C
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = java.lang.String.valueOf(r1)
            r5.length()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "Overriding unexpected non-sync sample for format: "
            java.lang.String r1 = r5.concat(r1)
            java.lang.String r5 = "SampleQueue"
            android.util.Log.w(r5, r1)
            r1 = 1
            r8.f9011F = r1
        L4c:
            r1 = r14 | 1
            r5 = r1
            goto L51
        L50:
            r5 = r14
        L51:
            boolean r1 = r8.f9013H
            if (r1 == 0) goto L62
            if (r0 == 0) goto L61
            boolean r0 = r11.m959Z(r3)
            if (r0 != 0) goto L5e
            goto L61
        L5e:
            r8.f9013H = r2
            goto L62
        L61:
            return
        L62:
            com.google.ads.interactivemedia.v3.internal.tv r0 = r8.f9014a
            long r0 = r0.m1000b()
            r6 = r15
            long r9 = (long) r6
            long r0 = r0 - r9
            r2 = r16
            long r9 = (long) r2
            long r9 = r0 - r9
            r0 = r11
            r1 = r3
            r3 = r5
            r4 = r9
            r7 = r17
            r0.m963V(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3096tz.mo441f(long, int, int, int, com.google.ads.interactivemedia.v3.internal.zt):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: h */
    public final int mo440h(InterfaceC2746h interfaceC2746h, int i, boolean z) throws IOException {
        return this.f9014a.m1001a(interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: i */
    public final void mo439i(C2621cj c2621cj, int i) {
        this.f9014a.m993i(c2621cj, i);
    }

    /* renamed from: j */
    public final int m951j() {
        return this.f9031r;
    }

    /* renamed from: k */
    public final int m950k() {
        return this.f9031r + this.f9033t;
    }

    /* renamed from: l */
    public final synchronized int m949l(long j, boolean z) {
        int i = this.f9033t;
        int m952g = m952g(i);
        if (m958aa() && j >= this.f9028o[m952g]) {
            if (j > this.f9036w && z) {
                return this.f9030q - i;
            }
            int m953d = m953d(m952g, this.f9030q - i, j, true);
            if (m953d == -1) {
                return 0;
            }
            return m953d;
        }
        return 0;
    }

    /* renamed from: m */
    public final int m948m() {
        return this.f9031r + this.f9030q;
    }

    /* renamed from: n */
    public final synchronized int m947n() {
        return m958aa() ? this.f9024k[m952g(this.f9033t)] : this.f9009D;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r9 != 0) goto L17;
     */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m946o(com.google.ads.interactivemedia.p034v3.internal.C2717fy r9, com.google.ads.interactivemedia.p034v3.internal.C2669ed r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L7
            r5 = 1
            goto L9
        L7:
            r0 = 0
            r5 = 0
        L9:
            com.google.ads.interactivemedia.v3.internal.tw r7 = r8.f9015b
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.m968Q(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L3e
            boolean r9 = r10.m2462g()
            if (r9 != 0) goto L3d
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L34
            if (r9 == 0) goto L2c
            com.google.ads.interactivemedia.v3.internal.tv r9 = r8.f9014a
            com.google.ads.interactivemedia.v3.internal.tw r11 = r8.f9015b
            r9.m997e(r10, r11)
            goto L3d
        L2c:
            com.google.ads.interactivemedia.v3.internal.tv r9 = r8.f9014a
            com.google.ads.interactivemedia.v3.internal.tw r11 = r8.f9015b
            r9.m996f(r10, r11)
            goto L37
        L34:
            if (r9 == 0) goto L37
            goto L3d
        L37:
            int r9 = r8.f9033t
            int r9 = r9 + r1
            r8.f9033t = r9
            return r12
        L3d:
            r9 = -4
        L3e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3096tz.m946o(com.google.ads.interactivemedia.v3.internal.fy, com.google.ads.interactivemedia.v3.internal.ed, int, boolean):int");
    }

    /* renamed from: p */
    public final synchronized long m945p() {
        int i = this.f9033t;
        if (i == 0) {
            return -1L;
        }
        return m966S(i);
    }

    /* renamed from: q */
    public final synchronized long m944q() {
        if (this.f9030q == 0) {
            return Long.MIN_VALUE;
        }
        return this.f9028o[this.f9032s];
    }

    /* renamed from: r */
    public final synchronized long m943r() {
        return this.f9036w;
    }

    /* renamed from: s */
    public final synchronized long m942s() {
        return Math.max(this.f9035v, m964U(this.f9033t));
    }

    /* renamed from: t */
    public final synchronized C2962p m941t() {
        if (this.f9039z) {
            return null;
        }
        return this.f9008C;
    }

    /* renamed from: u */
    public final void m940u() {
        this.f9014a.m999c(m967R());
    }

    /* renamed from: v */
    public final void m939v() {
        this.f9014a.m999c(m945p());
    }

    /* renamed from: w */
    public final void m938w(int i) {
        this.f9014a.m998d(m965T(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public final void m937x() {
        this.f9006A = true;
    }

    /* renamed from: y */
    public final void m936y() throws IOException {
        InterfaceC2910nb interfaceC2910nb = this.f9022i;
        if (interfaceC2910nb == null || interfaceC2910nb.mo1576a() != 1) {
            return;
        }
        C2909na mo1574c = this.f9022i.mo1574c();
        C2616ce.m2689d(mo1574c);
        throw mo1574c;
    }

    /* renamed from: z */
    public final void m935z() {
        m940u();
        m961X();
    }

    /* renamed from: W */
    private final void m962W(C2962p c2962p, C2717fy c2717fy) {
        C2962p c2962p2 = this.f9021h;
        C2854l c2854l = c2962p2 == null ? null : c2962p2.f8375o;
        this.f9021h = c2962p;
        C2854l c2854l2 = c2962p.f8375o;
        InterfaceC2921nm interfaceC2921nm = this.f9017d;
        c2717fy.f7335b = interfaceC2921nm != null ? c2962p.m1425c(interfaceC2921nm.mo1587b(c2962p)) : c2962p;
        c2717fy.f7334a = this.f9022i;
        if (this.f9017d == null) {
            return;
        }
        if (c2962p2 == null || !C2628cq.m2563T(c2854l, c2854l2)) {
            InterfaceC2910nb interfaceC2910nb = this.f9022i;
            InterfaceC2921nm interfaceC2921nm2 = this.f9017d;
            Looper looper = this.f9019f;
            C2616ce.m2689d(looper);
            InterfaceC2910nb mo1586i = interfaceC2921nm2.mo1586i(looper, this.f9018e, c2962p);
            this.f9022i = mo1586i;
            c2717fy.f7334a = mo1586i;
            if (interfaceC2910nb != null) {
                interfaceC2910nb.mo1570m(this.f9018e);
            }
        }
    }
}
