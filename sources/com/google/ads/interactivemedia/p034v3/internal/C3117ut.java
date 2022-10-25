package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Looper;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ut */
/* loaded from: classes2.dex */
public final class C3117ut implements InterfaceC3098ua, InterfaceC3100uc, InterfaceC3160wi, InterfaceC3164wm {

    /* renamed from: a */
    public final int f9111a;

    /* renamed from: b */
    boolean f9112b;

    /* renamed from: c */
    private final int[] f9113c;

    /* renamed from: d */
    private final C2962p[] f9114d;

    /* renamed from: e */
    private final boolean[] f9115e;

    /* renamed from: f */
    private final InterfaceC3118uu f9116f;

    /* renamed from: g */
    private final InterfaceC3099ub f9117g;

    /* renamed from: h */
    private final C3076tf f9118h;

    /* renamed from: i */
    private final C3167wp f9119i;

    /* renamed from: j */
    private final C3114uq f9120j;

    /* renamed from: k */
    private final ArrayList f9121k;

    /* renamed from: l */
    private final List f9122l;

    /* renamed from: m */
    private final C3096tz f9123m;

    /* renamed from: n */
    private final C3096tz[] f9124n;

    /* renamed from: o */
    private final C3108uk f9125o;

    /* renamed from: p */
    private AbstractC3112uo f9126p;

    /* renamed from: q */
    private C2962p f9127q;

    /* renamed from: r */
    private InterfaceC3116us f9128r;

    /* renamed from: s */
    private long f9129s;

    /* renamed from: t */
    private long f9130t;

    /* renamed from: u */
    private int f9131u;

    /* renamed from: v */
    private AbstractC3106ui f9132v;

    /* renamed from: w */
    private final C3161wj f9133w;

    public C3117ut(int i, int[] iArr, C2962p[] c2962pArr, InterfaceC3118uu interfaceC3118uu, InterfaceC3099ub interfaceC3099ub, C3154wc c3154wc, long j, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng, C3161wj c3161wj, C3076tf c3076tf, byte[] bArr) {
        this.f9111a = i;
        int i2 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f9113c = iArr;
        this.f9114d = c2962pArr == null ? new C2962p[0] : c2962pArr;
        this.f9116f = interfaceC3118uu;
        this.f9117g = interfaceC3099ub;
        this.f9118h = c3076tf;
        this.f9133w = c3161wj;
        this.f9119i = new C3167wp("ChunkSampleStream");
        this.f9120j = new C3114uq();
        ArrayList arrayList = new ArrayList();
        this.f9121k = arrayList;
        this.f9122l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f9124n = new C3096tz[length];
        this.f9115e = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        C3096tz[] c3096tzArr = new C3096tz[i3];
        Looper myLooper = Looper.myLooper();
        C2616ce.m2689d(myLooper);
        C3096tz m971N = C3096tz.m971N(c3154wc, myLooper, interfaceC2921nm, c2915ng);
        this.f9123m = m971N;
        iArr2[0] = i;
        c3096tzArr[0] = m971N;
        while (i2 < length) {
            C3096tz m970O = C3096tz.m970O(c3154wc);
            this.f9124n[i2] = m970O;
            int i4 = i2 + 1;
            c3096tzArr[i4] = m970O;
            iArr2[i4] = this.f9113c[i2];
            i2 = i4;
        }
        this.f9125o = new C3108uk(iArr2, c3096tzArr);
        this.f9129s = j;
        this.f9130t = j;
    }

    /* renamed from: A */
    private final boolean m891A(int i) {
        AbstractC3106ui abstractC3106ui = (AbstractC3106ui) this.f9121k.get(i);
        if (this.f9123m.m950k() > abstractC3106ui.m911a(0)) {
            return true;
        }
        int i2 = 0;
        while (true) {
            C3096tz[] c3096tzArr = this.f9124n;
            if (i2 >= c3096tzArr.length) {
                return false;
            }
            int i3 = i2 + 1;
            if (c3096tzArr[i2].m950k() > abstractC3106ui.m911a(i3)) {
                return true;
            }
            i2 = i3;
        }
    }

    /* renamed from: v */
    private final int m869v(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.f9121k.size()) {
                return this.f9121k.size() - 1;
            }
        } while (((AbstractC3106ui) this.f9121k.get(i2)).m911a(0) <= i);
        return i2 - 1;
    }

    /* renamed from: w */
    private final AbstractC3106ui m868w(int i) {
        AbstractC3106ui abstractC3106ui = (AbstractC3106ui) this.f9121k.get(i);
        ArrayList arrayList = this.f9121k;
        C2628cq.m2565R(arrayList, i, arrayList.size());
        this.f9131u = Math.max(this.f9131u, this.f9121k.size());
        int i2 = 0;
        this.f9123m.m938w(abstractC3106ui.m911a(0));
        while (true) {
            C3096tz[] c3096tzArr = this.f9124n;
            if (i2 >= c3096tzArr.length) {
                return abstractC3106ui;
            }
            int i3 = i2 + 1;
            c3096tzArr[i2].m938w(abstractC3106ui.m911a(i3));
            i2 = i3;
        }
    }

    /* renamed from: x */
    private final AbstractC3106ui m867x() {
        ArrayList arrayList = this.f9121k;
        return (AbstractC3106ui) arrayList.get(arrayList.size() - 1);
    }

    /* renamed from: y */
    private final void m866y() {
        int m869v = m869v(this.f9123m.m950k(), this.f9131u - 1);
        while (true) {
            int i = this.f9131u;
            if (i > m869v) {
                return;
            }
            this.f9131u = i + 1;
            AbstractC3106ui abstractC3106ui = (AbstractC3106ui) this.f9121k.get(i);
            C2962p c2962p = abstractC3106ui.f9098i;
            if (!c2962p.equals(this.f9127q)) {
                C3076tf c3076tf = this.f9118h;
                int i2 = this.f9111a;
                int i3 = abstractC3106ui.f9099j;
                Object obj = abstractC3106ui.f9100k;
                c3076tf.m1076o(i2, c2962p, i3, abstractC3106ui.f9101l);
            }
            this.f9127q = c2962p;
        }
    }

    /* renamed from: z */
    private final void m865z() {
        this.f9123m.m983B();
        for (C3096tz c3096tz : this.f9124n) {
            c3096tz.m983B();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: a */
    public final int mo890a(C2717fy c2717fy, C2669ed c2669ed, int i) {
        if (m876n()) {
            return -3;
        }
        m866y();
        return this.f9123m.m946o(c2717fy, c2669ed, i, this.f9112b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: b */
    public final int mo889b(long j) {
        if (m876n()) {
            return 0;
        }
        int m949l = this.f9123m.m949l(j, this.f9112b);
        this.f9123m.m978G(m949l);
        m866y();
        return m949l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bb */
    public final /* bridge */ /* synthetic */ void mo704bb(InterfaceC3163wl interfaceC3163wl, long j, long j2) {
        AbstractC3112uo abstractC3112uo = (AbstractC3112uo) interfaceC3163wl;
        this.f9126p = null;
        this.f9116f.mo860g(abstractC3112uo);
        long j3 = abstractC3112uo.f9095f;
        C2642dd c2642dd = abstractC3112uo.f9096g;
        abstractC3112uo.m901l();
        abstractC3112uo.m900m();
        abstractC3112uo.m902k();
        C3059sp c3059sp = new C3059sp();
        long j4 = abstractC3112uo.f9095f;
        C3076tf c3076tf = this.f9118h;
        int i = abstractC3112uo.f9097h;
        int i2 = this.f9111a;
        C2962p c2962p = abstractC3112uo.f9098i;
        int i3 = abstractC3112uo.f9099j;
        Object obj = abstractC3112uo.f9100k;
        c3076tf.m1074q(c3059sp, i, i2, c2962p, i3, abstractC3112uo.f9101l, abstractC3112uo.f9102m);
        this.f9117g.mo934g(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ com.google.ads.interactivemedia.p034v3.internal.C3158wg mo703bc(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl r21, long r22, long r24, java.io.IOException r26, int r27) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            com.google.ads.interactivemedia.v3.internal.uo r1 = (com.google.ads.interactivemedia.p034v3.internal.AbstractC3112uo) r1
            long r2 = r1.m902k()
            boolean r4 = r1 instanceof com.google.ads.interactivemedia.p034v3.internal.AbstractC3106ui
            java.util.ArrayList r5 = r0.f9121k
            int r5 = r5.size()
            int r5 = r5 + (-1)
            r6 = 0
            r7 = 1
            r8 = 0
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 == 0) goto L27
            if (r4 == 0) goto L27
            boolean r2 = r0.m891A(r5)
            if (r2 != 0) goto L25
            goto L27
        L25:
            r2 = 0
            goto L28
        L27:
            r2 = 1
        L28:
            com.google.ads.interactivemedia.v3.internal.sp r9 = new com.google.ads.interactivemedia.v3.internal.sp
            long r10 = r1.f9095f
            com.google.ads.interactivemedia.v3.internal.dd r3 = r1.f9096g
            r1.m901l()
            r1.m900m()
            r9.<init>()
            int r3 = r1.f9097h
            com.google.ads.interactivemedia.v3.internal.p r3 = r1.f9098i
            int r3 = r1.f9099j
            java.lang.Object r3 = r1.f9100k
            long r10 = r1.f9101l
            int r3 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            long r10 = r1.f9102m
            com.google.ads.interactivemedia.v3.internal.wh r3 = new com.google.ads.interactivemedia.v3.internal.wh
            r14 = r26
            r8 = r27
            r3.<init>(r14, r8)
            com.google.ads.interactivemedia.v3.internal.uu r8 = r0.f9116f
            com.google.ads.interactivemedia.v3.internal.wj r10 = r0.f9133w
            boolean r8 = r8.mo857j(r1, r2, r3, r10)
            r15 = 0
            if (r8 == 0) goto L7f
            if (r2 == 0) goto L78
            com.google.ads.interactivemedia.v3.internal.wg r2 = com.google.ads.interactivemedia.p034v3.internal.C3167wp.f9310b
            if (r4 == 0) goto L80
            com.google.ads.interactivemedia.v3.internal.ui r4 = r0.m868w(r5)
            if (r4 != r1) goto L67
            r4 = 1
            goto L68
        L67:
            r4 = 0
        L68:
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2685h(r4)
            java.util.ArrayList r4 = r0.f9121k
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L80
            long r4 = r0.f9130t
            r0.f9129s = r4
            goto L80
        L78:
            java.lang.String r2 = "ChunkSampleStream"
            java.lang.String r4 = "Ignoring attempt to cancel non-cancelable load."
            android.util.Log.w(r2, r4)
        L7f:
            r2 = r15
        L80:
            if (r2 != 0) goto L96
            long r2 = com.google.ads.interactivemedia.p034v3.internal.C3161wj.m738c(r3)
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L94
            com.google.ads.interactivemedia.v3.internal.wg r2 = com.google.ads.interactivemedia.p034v3.internal.C3167wp.m716n(r6, r2)
            goto L96
        L94:
            com.google.ads.interactivemedia.v3.internal.wg r2 = com.google.ads.interactivemedia.p034v3.internal.C3167wp.f9311c
        L96:
            boolean r3 = r2.m743a()
            r3 = r3 ^ r7
            com.google.ads.interactivemedia.v3.internal.tf r8 = r0.f9118h
            int r10 = r1.f9097h
            int r11 = r0.f9111a
            com.google.ads.interactivemedia.v3.internal.p r12 = r1.f9098i
            int r13 = r1.f9099j
            java.lang.Object r4 = r1.f9100k
            long r4 = r1.f9101l
            long r6 = r1.f9102m
            r21 = r2
            r2 = r15
            r14 = r4
            r16 = r6
            r18 = r26
            r19 = r3
            r8.m1073r(r9, r10, r11, r12, r13, r14, r16, r18, r19)
            if (r3 == 0) goto Lc3
            r0.f9126p = r2
            long r1 = r1.f9095f
            com.google.ads.interactivemedia.v3.internal.ub r1 = r0.f9117g
            r1.mo934g(r0)
        Lc3:
            return r21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3117ut.mo703bc(com.google.ads.interactivemedia.v3.internal.wl, long, long, java.io.IOException, int):com.google.ads.interactivemedia.v3.internal.wg");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bf */
    public final /* bridge */ /* synthetic */ void mo702bf(InterfaceC3163wl interfaceC3163wl, long j, long j2, boolean z) {
        AbstractC3112uo abstractC3112uo = (AbstractC3112uo) interfaceC3163wl;
        this.f9126p = null;
        this.f9132v = null;
        long j3 = abstractC3112uo.f9095f;
        C2642dd c2642dd = abstractC3112uo.f9096g;
        abstractC3112uo.m901l();
        abstractC3112uo.m900m();
        abstractC3112uo.m902k();
        C3059sp c3059sp = new C3059sp();
        long j4 = abstractC3112uo.f9095f;
        C3076tf c3076tf = this.f9118h;
        int i = abstractC3112uo.f9097h;
        int i2 = this.f9111a;
        C2962p c2962p = abstractC3112uo.f9098i;
        int i3 = abstractC3112uo.f9099j;
        Object obj = abstractC3112uo.f9100k;
        c3076tf.m1075p(c3059sp, i, i2, c2962p, i3, abstractC3112uo.f9101l, abstractC3112uo.f9102m);
        if (z) {
            return;
        }
        if (!m876n()) {
            if (abstractC3112uo instanceof AbstractC3106ui) {
                m868w(this.f9121k.size() - 1);
                if (this.f9121k.isEmpty()) {
                    this.f9129s = this.f9130t;
                }
            }
        } else {
            m865z();
        }
        this.f9117g.mo934g(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        if (this.f9112b) {
            return Long.MIN_VALUE;
        }
        if (m876n()) {
            return this.f9129s;
        }
        long j = this.f9130t;
        AbstractC3106ui m867x = m867x();
        if (!m867x.mo849g()) {
            if (this.f9121k.size() > 1) {
                ArrayList arrayList = this.f9121k;
                m867x = (AbstractC3106ui) arrayList.get(arrayList.size() - 2);
            } else {
                m867x = null;
            }
        }
        if (m867x != null) {
            j = Math.max(j, m867x.f9102m);
        }
        return Math.max(j, this.f9123m.m943r());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        if (m876n()) {
            return this.f9129s;
        }
        if (this.f9112b) {
            return Long.MIN_VALUE;
        }
        return m867x().f9102m;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: d */
    public final void mo886d() throws IOException {
        this.f9119i.mo715a();
        this.f9123m.m936y();
        if (this.f9119i.m717m()) {
            return;
        }
        this.f9116f.mo861f();
    }

    /* renamed from: f */
    public final long m884f(long j, C2740gu c2740gu) {
        return this.f9116f.mo863d(j, c2740gu);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: g */
    public final boolean mo883g() {
        return !m876n() && this.f9123m.m974K(this.f9112b);
    }

    /* renamed from: i */
    public final C3115ur m881i(long j, int i) {
        for (int i2 = 0; i2 < this.f9124n.length; i2++) {
            if (this.f9113c[i2] == i) {
                C2616ce.m2685h(!this.f9115e[i2]);
                this.f9115e[i2] = true;
                this.f9124n[i2].m972M(j, true);
                return new C3115ur(this, this, this.f9124n[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: j */
    public final InterfaceC3118uu m880j() {
        return this.f9116f;
    }

    /* renamed from: k */
    public final void m879k(InterfaceC3116us interfaceC3116us) {
        this.f9128r = interfaceC3116us;
        this.f9123m.m935z();
        for (C3096tz c3096tz : this.f9124n) {
            c3096tz.m935z();
        }
        this.f9119i.m719k(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
        C3167wp c3167wp = this.f9119i;
        if (c3167wp.m718l() || m876n()) {
            return;
        }
        if (c3167wp.m717m()) {
            AbstractC3112uo abstractC3112uo = this.f9126p;
            C2616ce.m2689d(abstractC3112uo);
            if ((abstractC3112uo instanceof AbstractC3106ui) && m891A(this.f9121k.size() - 1)) {
                return;
            }
            this.f9116f.mo858i(j, abstractC3112uo, this.f9122l);
            return;
        }
        int mo864c = this.f9116f.mo864c(j, this.f9122l);
        if (mo864c < this.f9121k.size()) {
            C2616ce.m2685h(!this.f9119i.m717m());
            int size = this.f9121k.size();
            while (true) {
                if (mo864c >= size) {
                    mo864c = -1;
                    break;
                } else if (!m891A(mo864c)) {
                    break;
                } else {
                    mo864c++;
                }
            }
            if (mo864c == -1) {
                return;
            }
            long j2 = m867x().f9102m;
            AbstractC3106ui m868w = m868w(mo864c);
            if (this.f9121k.isEmpty()) {
                this.f9129s = this.f9130t;
            }
            this.f9112b = false;
            this.f9118h.m1077n(this.f9111a, m868w.f9101l, j2);
        }
    }

    /* renamed from: m */
    public final void m877m(long j) {
        AbstractC3106ui abstractC3106ui;
        boolean m972M;
        this.f9130t = j;
        if (m876n()) {
            this.f9129s = j;
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            abstractC3106ui = null;
            if (i2 >= this.f9121k.size()) {
                break;
            }
            AbstractC3106ui abstractC3106ui2 = (AbstractC3106ui) this.f9121k.get(i2);
            int i3 = (abstractC3106ui2.f9101l > j ? 1 : (abstractC3106ui2.f9101l == j ? 0 : -1));
            if (i3 == 0 && abstractC3106ui2.f9067a == C3282C.TIME_UNSET) {
                abstractC3106ui = abstractC3106ui2;
                break;
            } else if (i3 > 0) {
                break;
            } else {
                i2++;
            }
        }
        if (abstractC3106ui != null) {
            m972M = this.f9123m.m973L(abstractC3106ui.m911a(0));
        } else {
            m972M = this.f9123m.m972M(j, j < mo887c());
        }
        if (m972M) {
            this.f9131u = m869v(this.f9123m.m950k(), 0);
            C3096tz[] c3096tzArr = this.f9124n;
            int length = c3096tzArr.length;
            while (i < length) {
                c3096tzArr[i].m972M(j, true);
                i++;
            }
            return;
        }
        this.f9129s = j;
        this.f9112b = false;
        this.f9121k.clear();
        this.f9131u = 0;
        C3167wp c3167wp = this.f9119i;
        if (c3167wp.m717m()) {
            this.f9123m.m940u();
            C3096tz[] c3096tzArr2 = this.f9124n;
            int length2 = c3096tzArr2.length;
            while (i < length2) {
                c3096tzArr2[i].m940u();
                i++;
            }
            this.f9119i.m723g();
            return;
        }
        c3167wp.m722h();
        m865z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public final boolean m876n() {
        return this.f9129s != C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        List list;
        long j2;
        if (!this.f9112b) {
            C3167wp c3167wp = this.f9119i;
            if (!c3167wp.m717m() && !c3167wp.m718l()) {
                boolean m876n = m876n();
                if (m876n) {
                    list = Collections.emptyList();
                    j2 = this.f9129s;
                } else {
                    list = this.f9122l;
                    j2 = m867x().f9102m;
                }
                this.f9116f.mo862e(j, j2, list, this.f9120j);
                C3114uq c3114uq = this.f9120j;
                boolean z = c3114uq.f9105b;
                AbstractC3112uo abstractC3112uo = c3114uq.f9104a;
                c3114uq.f9104a = null;
                c3114uq.f9105b = false;
                if (z) {
                    this.f9129s = C3282C.TIME_UNSET;
                    this.f9112b = true;
                    return true;
                } else if (abstractC3112uo == null) {
                    return false;
                } else {
                    this.f9126p = abstractC3112uo;
                    if (abstractC3112uo instanceof AbstractC3106ui) {
                        AbstractC3106ui abstractC3106ui = (AbstractC3106ui) abstractC3112uo;
                        if (m876n) {
                            long j3 = abstractC3106ui.f9101l;
                            long j4 = this.f9129s;
                            if (j3 != j4) {
                                this.f9123m.m980E(j4);
                                for (C3096tz c3096tz : this.f9124n) {
                                    c3096tz.m980E(this.f9129s);
                                }
                            }
                            this.f9129s = C3282C.TIME_UNSET;
                        }
                        abstractC3106ui.m909d(this.f9125o);
                        this.f9121k.add(abstractC3106ui);
                    } else if (abstractC3112uo instanceof C3121ux) {
                        ((C3121ux) abstractC3112uo).m854a(this.f9125o);
                    }
                    this.f9119i.m728b(abstractC3112uo, this, C3161wj.m739b(abstractC3112uo.f9097h));
                    this.f9118h.m1072s(new C3059sp(abstractC3112uo.f9096g), abstractC3112uo.f9097h, this.f9111a, abstractC3112uo.f9098i, abstractC3112uo.f9099j, abstractC3112uo.f9101l, abstractC3112uo.f9102m);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        return this.f9119i.m717m();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3164wm
    /* renamed from: s */
    public final void mo729s() {
        this.f9123m.m984A();
        for (C3096tz c3096tz : this.f9124n) {
            c3096tz.m984A();
        }
        this.f9116f.mo859h();
        InterfaceC3116us interfaceC3116us = this.f9128r;
        if (interfaceC3116us != null) {
            interfaceC3116us.mo892j(this);
        }
    }

    /* renamed from: u */
    public final void m870u(long j) {
        if (m876n()) {
            return;
        }
        C3096tz c3096tz = this.f9123m;
        int m951j = c3096tz.m951j();
        c3096tz.m969P(j, true);
        C3096tz c3096tz2 = this.f9123m;
        int m951j2 = c3096tz2.m951j();
        if (m951j2 > m951j) {
            long m944q = c3096tz2.m944q();
            int i = 0;
            while (true) {
                C3096tz[] c3096tzArr = this.f9124n;
                if (i >= c3096tzArr.length) {
                    break;
                }
                c3096tzArr[i].m969P(m944q, this.f9115e[i]);
                i++;
            }
        }
        int min = Math.min(m869v(m951j2, 0), this.f9131u);
        if (min > 0) {
            C2628cq.m2565R(this.f9121k, 0, min);
            this.f9131u -= min;
        }
    }
}
