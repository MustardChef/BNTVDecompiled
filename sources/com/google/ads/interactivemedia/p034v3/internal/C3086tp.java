package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tp */
/* loaded from: classes2.dex */
public final class C3086tp implements InterfaceC3066sw, InterfaceC3233za, InterfaceC3160wi, InterfaceC3164wm, InterfaceC3095ty {

    /* renamed from: a */
    private static final Map f8933a;

    /* renamed from: c */
    private static final C2962p f8934c;

    /* renamed from: B */
    private boolean f8936B;

    /* renamed from: C */
    private boolean f8937C;

    /* renamed from: D */
    private int f8938D;

    /* renamed from: F */
    private long f8940F;

    /* renamed from: H */
    private boolean f8942H;

    /* renamed from: I */
    private int f8943I;

    /* renamed from: J */
    private boolean f8944J;

    /* renamed from: K */
    private boolean f8945K;

    /* renamed from: L */
    private final C3154wc f8946L;

    /* renamed from: N */
    private final C3161wj f8948N;

    /* renamed from: d */
    private final Uri f8949d;

    /* renamed from: e */
    private final InterfaceC2637cz f8950e;

    /* renamed from: f */
    private final InterfaceC2921nm f8951f;

    /* renamed from: g */
    private final C3076tf f8952g;

    /* renamed from: h */
    private final C2915ng f8953h;

    /* renamed from: i */
    private final InterfaceC3082tl f8954i;

    /* renamed from: j */
    private final long f8955j;

    /* renamed from: l */
    private final InterfaceC3078th f8957l;

    /* renamed from: p */
    private InterfaceC3065sv f8961p;

    /* renamed from: q */
    private aae f8962q;

    /* renamed from: t */
    private boolean f8965t;

    /* renamed from: u */
    private boolean f8966u;

    /* renamed from: v */
    private boolean f8967v;

    /* renamed from: w */
    private C3085to f8968w;

    /* renamed from: x */
    private InterfaceC3250zr f8969x;

    /* renamed from: z */
    private boolean f8971z;

    /* renamed from: k */
    private final C3167wp f8956k = new C3167wp("ProgressiveMediaPeriod");

    /* renamed from: M */
    private final age f8947M = new age();

    /* renamed from: m */
    private final Runnable f8958m = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.ti

        /* renamed from: a */
        public final /* synthetic */ C3086tp f8906a;

        {
            this.f8906a = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (r2 != 0) {
                this.f8906a.m1047C();
            } else {
                this.f8906a.m1036O();
            }
        }
    };

    /* renamed from: n */
    private final Runnable f8959n = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.ti

        /* renamed from: a */
        public final /* synthetic */ C3086tp f8906a;

        {
            this.f8906a = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (r2 != 0) {
                this.f8906a.m1047C();
            } else {
                this.f8906a.m1036O();
            }
        }
    };

    /* renamed from: o */
    private final Handler f8960o = C2628cq.m2508z();

    /* renamed from: s */
    private C3084tn[] f8964s = new C3084tn[0];

    /* renamed from: r */
    private C3096tz[] f8963r = new C3096tz[0];

    /* renamed from: G */
    private long f8941G = C3282C.TIME_UNSET;

    /* renamed from: E */
    private long f8939E = -1;

    /* renamed from: y */
    private long f8970y = C3282C.TIME_UNSET;

    /* renamed from: A */
    private int f8935A = 1;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        f8933a = Collections.unmodifiableMap(hashMap);
        C2935o c2935o = new C2935o();
        c2935o.m1545S("icy");
        c2935o.m1532ae(MimeTypes.APPLICATION_ICY);
        f8934c = c2935o.m1506v();
    }

    public C3086tp(Uri uri, InterfaceC2637cz interfaceC2637cz, InterfaceC3078th interfaceC3078th, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng, C3161wj c3161wj, C3076tf c3076tf, InterfaceC3082tl interfaceC3082tl, C3154wc c3154wc, int i, byte[] bArr) {
        this.f8949d = uri;
        this.f8950e = interfaceC2637cz;
        this.f8951f = interfaceC2921nm;
        this.f8953h = c2915ng;
        this.f8948N = c3161wj;
        this.f8952g = c3076tf;
        this.f8954i = interfaceC3082tl;
        this.f8946L = c3154wc;
        this.f8955j = i;
        this.f8957l = interfaceC3078th;
    }

    /* renamed from: J */
    private final int m1041J() {
        int i = 0;
        for (C3096tz c3096tz : this.f8963r) {
            i += c3096tz.m948m();
        }
        return i;
    }

    /* renamed from: K */
    public final long m1040K() {
        long j = Long.MIN_VALUE;
        for (C3096tz c3096tz : this.f8963r) {
            j = Math.max(j, c3096tz.m943r());
        }
        return j;
    }

    /* renamed from: L */
    private final InterfaceC3253zu m1039L(C3084tn c3084tn) {
        int length = this.f8963r.length;
        for (int i = 0; i < length; i++) {
            if (c3084tn.equals(this.f8964s[i])) {
                return this.f8963r[i];
            }
        }
        C3096tz m971N = C3096tz.m971N(this.f8946L, this.f8960o.getLooper(), this.f8951f, this.f8953h);
        m971N.m979F(this);
        int i2 = length + 1;
        C3084tn[] c3084tnArr = (C3084tn[]) Arrays.copyOf(this.f8964s, i2);
        c3084tnArr[length] = c3084tn;
        this.f8964s = (C3084tn[]) C2628cq.m2552ad(c3084tnArr);
        C3096tz[] c3096tzArr = (C3096tz[]) Arrays.copyOf(this.f8963r, i2);
        c3096tzArr[length] = m971N;
        this.f8963r = (C3096tz[]) C2628cq.m2552ad(c3096tzArr);
        return m971N;
    }

    /* renamed from: M */
    private final void m1038M() {
        C2616ce.m2685h(this.f8966u);
        C2616ce.m2689d(this.f8968w);
        C2616ce.m2689d(this.f8969x);
    }

    /* renamed from: N */
    private final void m1037N(C3081tk c3081tk) {
        long j;
        if (this.f8939E == -1) {
            j = c3081tk.f8921l;
            this.f8939E = j;
        }
    }

    /* renamed from: O */
    public final void m1036O() {
        C2549ak m5125c;
        int i;
        if (this.f8945K || this.f8966u || !this.f8965t || this.f8969x == null) {
            return;
        }
        for (C3096tz c3096tz : this.f8963r) {
            if (c3096tz.m941t() == null) {
                return;
            }
        }
        this.f8947M.m5361g();
        int length = this.f8963r.length;
        C2587bc[] c2587bcArr = new C2587bc[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            C2962p m941t = this.f8963r[i2].m941t();
            C2616ce.m2689d(m941t);
            String str = m941t.f8372l;
            boolean m4964m = C2554an.m4964m(str);
            boolean z = m4964m || C2554an.m4960q(str);
            zArr[i2] = z;
            this.f8967v = z | this.f8967v;
            aae aaeVar = this.f8962q;
            if (aaeVar != null) {
                if (m4964m || this.f8964s[i2].f8928b) {
                    C2549ak c2549ak = m941t.f8370j;
                    if (c2549ak == null) {
                        m5125c = new C2549ak(aaeVar);
                    } else {
                        m5125c = c2549ak.m5125c(aaeVar);
                    }
                    C2935o m1426b = m941t.m1426b();
                    m1426b.m1540X(m5125c);
                    m941t = m1426b.m1506v();
                }
                if (m4964m && m941t.f8366f == -1 && m941t.f8367g == -1 && (i = aaeVar.f2881a) != -1) {
                    C2935o m1426b2 = m941t.m1426b();
                    m1426b2.m1557G(i);
                    m941t = m1426b2.m1506v();
                }
            }
            c2587bcArr[i2] = new C2587bc(m941t.m1425c(this.f8951f.mo1587b(m941t)));
        }
        this.f8968w = new C3085to(new C2588bd(c2587bcArr), zArr);
        this.f8966u = true;
        InterfaceC3065sv interfaceC3065sv = this.f8961p;
        C2616ce.m2689d(interfaceC3065sv);
        interfaceC3065sv.mo1104bd(this);
    }

    /* renamed from: P */
    private final void m1035P(int i) {
        m1038M();
        C3085to c3085to = this.f8968w;
        boolean[] zArr = c3085to.f8932d;
        if (zArr[i]) {
            return;
        }
        C2962p m4193b = c3085to.f8929a.m4121b(i).m4193b(0);
        this.f8952g.m1076o(C2554an.m4976a(m4193b.f8372l), m4193b, 0, this.f8940F);
        zArr[i] = true;
    }

    /* renamed from: Q */
    private final void m1034Q(int i) {
        m1038M();
        boolean[] zArr = this.f8968w.f8930b;
        if (this.f8942H && zArr[i]) {
            if (this.f8963r[i].m974K(false)) {
                return;
            }
            this.f8941G = 0L;
            this.f8942H = false;
            this.f8937C = true;
            this.f8940F = 0L;
            this.f8943I = 0;
            for (C3096tz c3096tz : this.f8963r) {
                c3096tz.m983B();
            }
            InterfaceC3065sv interfaceC3065sv = this.f8961p;
            C2616ce.m2689d(interfaceC3065sv);
            interfaceC3065sv.mo934g(this);
        }
    }

    /* renamed from: R */
    private final void m1033R() {
        C2642dd c2642dd;
        long j;
        long unused;
        C3081tk c3081tk = new C3081tk(this, this.f8949d, this.f8950e, this.f8957l, this, this.f8947M, null);
        if (this.f8966u) {
            C2616ce.m2685h(m1032S());
            long j2 = this.f8970y;
            if (j2 == C3282C.TIME_UNSET || this.f8941G <= j2) {
                InterfaceC3250zr interfaceC3250zr = this.f8969x;
                C2616ce.m2689d(interfaceC3250zr);
                C3081tk.m1052i(c3081tk, interfaceC3250zr.mo446g(this.f8941G).f9611a.f9617c, this.f8941G);
                for (C3096tz c3096tz : this.f8963r) {
                    c3096tz.m980E(this.f8941G);
                }
                this.f8941G = C3282C.TIME_UNSET;
            } else {
                this.f8944J = true;
                this.f8941G = C3282C.TIME_UNSET;
                return;
            }
        }
        this.f8943I = m1041J();
        this.f8956k.m728b(c3081tk, this, C3161wj.m739b(this.f8935A));
        c2642dd = c3081tk.f8920k;
        C3076tf c3076tf = this.f8952g;
        unused = c3081tk.f8911b;
        C3059sp c3059sp = new C3059sp(c2642dd);
        j = c3081tk.f8919j;
        c3076tf.m1072s(c3059sp, 1, -1, null, 0, j, this.f8970y);
    }

    /* renamed from: S */
    private final boolean m1032S() {
        return this.f8941G != C3282C.TIME_UNSET;
    }

    /* renamed from: T */
    private final boolean m1031T() {
        return this.f8937C || m1032S();
    }

    /* renamed from: C */
    public final /* synthetic */ void m1047C() {
        if (this.f8945K) {
            return;
        }
        InterfaceC3065sv interfaceC3065sv = this.f8961p;
        C2616ce.m2689d(interfaceC3065sv);
        interfaceC3065sv.mo934g(this);
    }

    /* renamed from: E */
    final void m1045E() throws IOException {
        this.f8956k.m721i(C3161wj.m739b(this.f8935A));
    }

    /* renamed from: F */
    public final void m1044F(int i) throws IOException {
        this.f8963r[i].m936y();
        m1045E();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3095ty
    /* renamed from: G */
    public final void mo985G() {
        this.f8960o.post(this.f8958m);
    }

    /* renamed from: H */
    public final void m1043H() {
        if (this.f8966u) {
            for (C3096tz c3096tz : this.f8963r) {
                c3096tz.m935z();
            }
        }
        this.f8956k.m719k(this);
        this.f8960o.removeCallbacksAndMessages(null);
        this.f8961p = null;
        this.f8945K = true;
    }

    /* renamed from: I */
    public final boolean m1042I(int i) {
        return !m1031T() && this.f8963r[i].m974K(this.f8944J);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: a */
    public final long mo1030a(long j, C2740gu c2740gu) {
        m1038M();
        if (this.f8969x.mo445h()) {
            C3248zp mo446g = this.f8969x.mo446g(j);
            return c2740gu.m2169a(j, mo446g.f9611a.f9616b, mo446g.f9612b.f9616b);
        }
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bb */
    public final /* bridge */ /* synthetic */ void mo704bb(InterfaceC3163wl interfaceC3163wl, long j, long j2) {
        long j3;
        InterfaceC3250zr interfaceC3250zr;
        C2658dt unused;
        long unused2;
        C2642dd unused3;
        long unused4;
        C3081tk c3081tk = (C3081tk) interfaceC3163wl;
        if (this.f8970y == C3282C.TIME_UNSET && (interfaceC3250zr = this.f8969x) != null) {
            boolean mo445h = interfaceC3250zr.mo445h();
            long m1040K = m1040K();
            long j4 = m1040K == Long.MIN_VALUE ? 0L : m1040K + 10000;
            this.f8970y = j4;
            this.f8954i.mo1010b(j4, mo445h, this.f8971z);
        }
        unused = c3081tk.f8913d;
        unused2 = c3081tk.f8911b;
        unused3 = c3081tk.f8920k;
        C3059sp c3059sp = new C3059sp();
        unused4 = c3081tk.f8911b;
        C3076tf c3076tf = this.f8952g;
        j3 = c3081tk.f8919j;
        c3076tf.m1074q(c3059sp, 1, -1, null, 0, j3, this.f8970y);
        m1037N(c3081tk);
        this.f8944J = true;
        InterfaceC3065sv interfaceC3065sv = this.f8961p;
        C2616ce.m2689d(interfaceC3065sv);
        interfaceC3065sv.mo934g(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bc */
    public final /* bridge */ /* synthetic */ C3158wg mo703bc(InterfaceC3163wl interfaceC3163wl, long j, long j2, IOException iOException, int i) {
        C3158wg m716n;
        InterfaceC3250zr interfaceC3250zr;
        long j3;
        C2658dt unused;
        long unused2;
        C2642dd unused3;
        long unused4;
        long unused5;
        C3081tk c3081tk = (C3081tk) interfaceC3163wl;
        m1037N(c3081tk);
        unused = c3081tk.f8913d;
        unused2 = c3081tk.f8911b;
        unused3 = c3081tk.f8920k;
        C3059sp c3059sp = new C3059sp();
        unused4 = c3081tk.f8919j;
        int i2 = C2628cq.f6961a;
        long m738c = C3161wj.m738c(new C3159wh(iOException, i));
        if (m738c == C3282C.TIME_UNSET) {
            m716n = C3167wp.f9311c;
        } else {
            int m1041J = m1041J();
            boolean z = m1041J > this.f8943I;
            if (this.f8939E == -1 && ((interfaceC3250zr = this.f8969x) == null || interfaceC3250zr.mo447e() == C3282C.TIME_UNSET)) {
                boolean z2 = this.f8966u;
                if (!z2 || m1031T()) {
                    this.f8937C = z2;
                    this.f8940F = 0L;
                    this.f8943I = 0;
                    for (C3096tz c3096tz : this.f8963r) {
                        c3096tz.m983B();
                    }
                    C3081tk.m1052i(c3081tk, 0L, 0L);
                } else {
                    this.f8942H = true;
                    m716n = C3167wp.f9310b;
                }
            } else {
                this.f8943I = m1041J;
            }
            m716n = C3167wp.m716n(z, m738c);
        }
        C3158wg c3158wg = m716n;
        boolean z3 = !c3158wg.m743a();
        C3076tf c3076tf = this.f8952g;
        j3 = c3081tk.f8919j;
        c3076tf.m1073r(c3059sp, 1, -1, null, 0, j3, this.f8970y, iOException, z3);
        if (z3) {
            unused5 = c3081tk.f8911b;
        }
        return c3158wg;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: be */
    public final InterfaceC3253zu mo489be(int i, int i2) {
        return m1039L(new C3084tn(i, false));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bf */
    public final /* bridge */ /* synthetic */ void mo702bf(InterfaceC3163wl interfaceC3163wl, long j, long j2, boolean z) {
        long j3;
        C2658dt unused;
        long unused2;
        C2642dd unused3;
        long unused4;
        C3081tk c3081tk = (C3081tk) interfaceC3163wl;
        unused = c3081tk.f8913d;
        unused2 = c3081tk.f8911b;
        unused3 = c3081tk.f8920k;
        C3059sp c3059sp = new C3059sp();
        unused4 = c3081tk.f8911b;
        C3076tf c3076tf = this.f8952g;
        j3 = c3081tk.f8919j;
        c3076tf.m1075p(c3059sp, 1, -1, null, 0, j3, this.f8970y);
        if (z) {
            return;
        }
        m1037N(c3081tk);
        for (C3096tz c3096tz : this.f8963r) {
            c3096tz.m983B();
        }
        if (this.f8938D > 0) {
            InterfaceC3065sv interfaceC3065sv = this.f8961p;
            C2616ce.m2689d(interfaceC3065sv);
            interfaceC3065sv.mo934g(this);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        long j;
        m1038M();
        boolean[] zArr = this.f8968w.f8930b;
        if (this.f8944J) {
            return Long.MIN_VALUE;
        }
        if (m1032S()) {
            return this.f8941G;
        }
        if (this.f8967v) {
            int length = this.f8963r.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.f8963r[i].m975J()) {
                    j = Math.min(j, this.f8963r[i].m943r());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = m1040K();
        }
        return j == Long.MIN_VALUE ? this.f8940F : j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        if (this.f8938D == 0) {
            return Long.MIN_VALUE;
        }
        return mo888bg();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: d */
    public final long mo1029d() {
        if (this.f8937C) {
            if (this.f8944J || m1041J() > this.f8943I) {
                this.f8937C = false;
                return this.f8940F;
            }
            return C3282C.TIME_UNSET;
        }
        return C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: e */
    public final long mo1028e(long j) {
        int i;
        m1038M();
        boolean[] zArr = this.f8968w.f8930b;
        if (true != this.f8969x.mo445h()) {
            j = 0;
        }
        int i2 = 0;
        this.f8937C = false;
        this.f8940F = j;
        if (m1032S()) {
            this.f8941G = j;
            return j;
        }
        if (this.f8935A != 7) {
            int length = this.f8963r.length;
            while (i < length) {
                i = (this.f8963r[i].m972M(j, false) || (!zArr[i] && this.f8967v)) ? i + 1 : 0;
            }
            return j;
        }
        this.f8942H = false;
        this.f8941G = j;
        this.f8944J = false;
        C3167wp c3167wp = this.f8956k;
        if (c3167wp.m717m()) {
            C3096tz[] c3096tzArr = this.f8963r;
            int length2 = c3096tzArr.length;
            while (i2 < length2) {
                c3096tzArr[i2].m940u();
                i2++;
            }
            this.f8956k.m723g();
        } else {
            c3167wp.m722h();
            C3096tz[] c3096tzArr2 = this.f8963r;
            int length3 = c3096tzArr2.length;
            while (i2 < length3) {
                c3096tzArr2[i2].m983B();
                i2++;
            }
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x003c, code lost:
        if (r2 == 0) goto L77;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long mo1027f(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr[] r8, boolean[] r9, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua[] r10, boolean[] r11, long r12) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3086tp.mo1027f(com.google.ads.interactivemedia.v3.internal.vr[], boolean[], com.google.ads.interactivemedia.v3.internal.ua[], boolean[], long):long");
    }

    /* renamed from: g */
    public final int m1026g(int i, C2717fy c2717fy, C2669ed c2669ed, int i2) {
        if (m1031T()) {
            return -3;
        }
        m1035P(i);
        int m946o = this.f8963r[i].m946o(c2717fy, c2669ed, i2, this.f8944J);
        if (m946o == -3) {
            m1034Q(i);
        }
        return m946o;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: h */
    public final C2588bd mo1025h() {
        m1038M();
        return this.f8968w.f8929a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: i */
    public final void mo1024i() throws IOException {
        m1045E();
        if (this.f8944J && !this.f8966u) {
            throw C2555ao.m4866a("Loading finished before preparation is complete.", null);
        }
    }

    /* renamed from: j */
    public final int m1023j(int i, long j) {
        if (m1031T()) {
            return 0;
        }
        m1035P(i);
        C3096tz c3096tz = this.f8963r[i];
        int m949l = c3096tz.m949l(j, this.f8944J);
        c3096tz.m978G(m949l);
        if (m949l == 0) {
            m1034Q(i);
            return 0;
        }
        return m949l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: k */
    public final void mo1022k(InterfaceC3065sv interfaceC3065sv, long j) {
        this.f8961p = interfaceC3065sv;
        this.f8947M.m5362f();
        m1033R();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: m */
    public final void mo488m() {
        this.f8965t = true;
        this.f8960o.post(this.f8958m);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        if (this.f8944J || this.f8956k.m718l() || this.f8942H) {
            return false;
        }
        if (this.f8966u && this.f8938D == 0) {
            return false;
        }
        boolean m5362f = this.f8947M.m5362f();
        if (this.f8956k.m717m()) {
            return m5362f;
        }
        m1033R();
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        return this.f8956k.m717m() && this.f8947M.m5363e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: q */
    public final void mo1020q(long j) {
        m1038M();
        if (m1032S()) {
            return;
        }
        boolean[] zArr = this.f8968w.f8931c;
        int length = this.f8963r.length;
        for (int i = 0; i < length; i++) {
            this.f8963r[i].m969P(j, zArr[i]);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3164wm
    /* renamed from: s */
    public final void mo729s() {
        for (C3096tz c3096tz : this.f8963r) {
            c3096tz.m984A();
        }
        this.f8957l.mo1060e();
    }

    /* renamed from: v */
    public final InterfaceC3253zu m1016v() {
        return m1039L(new C3084tn(0, true));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: w */
    public final void mo487w(final InterfaceC3250zr interfaceC3250zr) {
        this.f8960o.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.tj
            @Override // java.lang.Runnable
            public final void run() {
                C3086tp.this.m1046D(interfaceC3250zr);
            }
        });
    }

    /* renamed from: D */
    public final /* synthetic */ void m1046D(InterfaceC3250zr interfaceC3250zr) {
        this.f8969x = this.f8962q == null ? interfaceC3250zr : new C3249zq(C3282C.TIME_UNSET);
        this.f8970y = interfaceC3250zr.mo447e();
        boolean z = false;
        if (this.f8939E == -1 && interfaceC3250zr.mo447e() == C3282C.TIME_UNSET) {
            z = true;
        }
        this.f8971z = z;
        this.f8935A = true == z ? 7 : 1;
        this.f8954i.mo1010b(this.f8970y, interfaceC3250zr.mo445h(), this.f8971z);
        if (this.f8966u) {
            return;
        }
        m1036O();
    }
}
