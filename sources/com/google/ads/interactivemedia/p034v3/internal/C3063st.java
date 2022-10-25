package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.st */
/* loaded from: classes2.dex */
public final class C3063st extends AbstractC3046sc {

    /* renamed from: a */
    private final InterfaceC3069sz f8865a;

    /* renamed from: b */
    private final boolean f8866b;

    /* renamed from: c */
    private final C2585ba f8867c;

    /* renamed from: d */
    private final C2583az f8868d;

    /* renamed from: e */
    private C3061sr f8869e;

    /* renamed from: f */
    private C3060sq f8870f;

    /* renamed from: g */
    private boolean f8871g;

    /* renamed from: h */
    private boolean f8872h;

    /* renamed from: i */
    private boolean f8873i;

    public C3063st(InterfaceC3069sz interfaceC3069sz, boolean z) {
        this.f8865a = interfaceC3069sz;
        boolean z2 = false;
        if (z && interfaceC3069sz.mo1095K()) {
            z2 = true;
        }
        this.f8866b = z2;
        this.f8867c = new C2585ba();
        this.f8868d = new C2583az();
        AbstractC2586bb mo1094t = interfaceC3069sz.mo1094t();
        if (mo1094t == null) {
            this.f8869e = C3061sr.m1113s(interfaceC3069sz.mo1011a());
            return;
        }
        this.f8869e = C3061sr.m1112t(mo1094t, null, null);
        this.f8873i = true;
    }

    /* renamed from: l */
    private final Object m1106l(Object obj) {
        Object obj2;
        Object obj3;
        obj2 = this.f8869e.f8863e;
        if (obj2 == null || !obj.equals(C3061sr.f8861c)) {
            return obj;
        }
        obj3 = this.f8869e.f8863e;
        return obj3;
    }

    /* renamed from: m */
    private final void m1105m(long j) {
        C3060sq c3060sq = this.f8870f;
        int mo925a = this.f8869e.mo925a(c3060sq.f8854a.f4115a);
        if (mo925a == -1) {
            return;
        }
        long j2 = this.f8869e.m4206m(mo925a, this.f8868d).f5315d;
        if (j2 != C3282C.TIME_UNSET && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        c3060sq.m1118r(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: a */
    public final C2543ae mo1011a() {
        return this.f8865a.mo1011a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ C3067sx mo1110c(Object obj, C3067sx c3067sx) {
        Object obj2;
        Object obj3;
        Void r2 = (Void) obj;
        Object obj4 = c3067sx.f4115a;
        obj2 = this.f8869e.f8863e;
        if (obj2 != null) {
            obj3 = this.f8869e.f8863e;
            if (obj3.equals(obj4)) {
                obj4 = C3061sr.f8861c;
            }
        }
        return c3067sx.m1103c(obj4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: h */
    public final void mo1008h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void mo1109i(java.lang.Object r11, com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb r12) {
        /*
            r10 = this;
            r0 = r11
            java.lang.Void r0 = (java.lang.Void) r0
            boolean r0 = r10.f8872h
            r6 = 0
            if (r0 == 0) goto L1d
            com.google.ads.interactivemedia.v3.internal.sr r0 = r10.f8869e
            com.google.ads.interactivemedia.v3.internal.sr r0 = r0.m1114r(r12)
            r10.f8869e = r0
            com.google.ads.interactivemedia.v3.internal.sq r0 = r10.f8870f
            if (r0 == 0) goto La9
            long r0 = r0.m1121j()
            r10.m1105m(r0)
            goto La9
        L1d:
            boolean r0 = r12.m4204p()
            if (r0 == 0) goto L3a
            boolean r0 = r10.f8873i
            if (r0 == 0) goto L2e
            com.google.ads.interactivemedia.v3.internal.sr r0 = r10.f8869e
            com.google.ads.interactivemedia.v3.internal.sr r0 = r0.m1114r(r12)
            goto L36
        L2e:
            java.lang.Object r0 = com.google.ads.interactivemedia.p034v3.internal.C2585ba.f5346a
            java.lang.Object r1 = com.google.ads.interactivemedia.p034v3.internal.C3061sr.f8861c
            com.google.ads.interactivemedia.v3.internal.sr r0 = com.google.ads.interactivemedia.p034v3.internal.C3061sr.m1112t(r12, r0, r1)
        L36:
            r10.f8869e = r0
            goto La9
        L3a:
            com.google.ads.interactivemedia.v3.internal.ba r0 = r10.f8867c
            r1 = 0
            r12.m4205o(r1, r0)
            com.google.ads.interactivemedia.v3.internal.ba r0 = r10.f8867c
            long r2 = r0.f5359m
            java.lang.Object r7 = r0.f5348b
            com.google.ads.interactivemedia.v3.internal.sq r0 = r10.f8870f
            if (r0 == 0) goto L70
            long r4 = r0.m1120m()
            com.google.ads.interactivemedia.v3.internal.sr r0 = r10.f8869e
            com.google.ads.interactivemedia.v3.internal.sq r8 = r10.f8870f
            com.google.ads.interactivemedia.v3.internal.sx r8 = r8.f8854a
            java.lang.Object r8 = r8.f4115a
            com.google.ads.interactivemedia.v3.internal.az r9 = r10.f8868d
            r0.mo2442n(r8, r9)
            com.google.ads.interactivemedia.v3.internal.az r0 = r10.f8868d
            long r8 = r0.f5316e
            long r8 = r8 + r4
            com.google.ads.interactivemedia.v3.internal.sr r0 = r10.f8869e
            com.google.ads.interactivemedia.v3.internal.ba r4 = r10.f8867c
            com.google.ads.interactivemedia.v3.internal.ba r0 = r0.m4205o(r1, r4)
            long r0 = r0.f5359m
            int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r4 == 0) goto L70
            r4 = r8
            goto L71
        L70:
            r4 = r2
        L71:
            com.google.ads.interactivemedia.v3.internal.ba r1 = r10.f8867c
            com.google.ads.interactivemedia.v3.internal.az r2 = r10.f8868d
            r3 = 0
            r0 = r12
            android.util.Pair r0 = r0.m4208k(r1, r2, r3, r4)
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            boolean r0 = r10.f8873i
            if (r0 == 0) goto L90
            com.google.ads.interactivemedia.v3.internal.sr r0 = r10.f8869e
            com.google.ads.interactivemedia.v3.internal.sr r0 = r0.m1114r(r12)
            goto L94
        L90:
            com.google.ads.interactivemedia.v3.internal.sr r0 = com.google.ads.interactivemedia.p034v3.internal.C3061sr.m1112t(r12, r7, r1)
        L94:
            r10.f8869e = r0
            com.google.ads.interactivemedia.v3.internal.sq r0 = r10.f8870f
            if (r0 == 0) goto La9
            r10.m1105m(r2)
            com.google.ads.interactivemedia.v3.internal.sx r0 = r0.f8854a
            java.lang.Object r1 = r0.f4115a
            java.lang.Object r1 = r10.m1106l(r1)
            com.google.ads.interactivemedia.v3.internal.sx r6 = r0.m1103c(r1)
        La9:
            r0 = 1
            r10.f8873i = r0
            r10.f8872h = r0
            com.google.ads.interactivemedia.v3.internal.sr r0 = r10.f8869e
            r10.m1187F(r0)
            if (r6 == 0) goto Lbd
            com.google.ads.interactivemedia.v3.internal.sq r0 = r10.f8870f
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2689d(r0)
            r0.m1119n(r6)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3063st.mo1109i(java.lang.Object, com.google.ads.interactivemedia.v3.internal.bb):void");
    }

    /* renamed from: j */
    public final AbstractC2586bb m1108j() {
        return this.f8869e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: k */
    public final C3060sq mo1004q(C3067sx c3067sx, C3154wc c3154wc, long j) {
        C3060sq c3060sq = new C3060sq(c3067sx, c3154wc, j);
        c3060sq.m1116t(this.f8865a);
        if (this.f8872h) {
            c3060sq.m1119n(c3067sx.m1103c(m1106l(c3067sx.f4115a)));
        } else {
            this.f8870f = c3060sq;
            if (!this.f8871g) {
                this.f8871g = true;
                m1162f(null, this.f8865a);
            }
        }
        return c3060sq;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc, com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: n */
    public final void mo1007n(InterfaceC2659du interfaceC2659du) {
        super.mo1007n(interfaceC2659du);
        if (this.f8866b) {
            return;
        }
        this.f8871g = true;
        m1162f(null, this.f8865a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: o */
    public final void mo1006o(InterfaceC3066sw interfaceC3066sw) {
        ((C3060sq) interfaceC3066sw).m1117s();
        if (interfaceC3066sw == this.f8870f) {
            this.f8870f = null;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc, com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: p */
    public final void mo1005p() {
        this.f8872h = false;
        this.f8871g = false;
        super.mo1005p();
    }
}
