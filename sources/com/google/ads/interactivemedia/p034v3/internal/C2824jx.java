package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jx */
/* loaded from: classes2.dex */
public final class C2824jx implements InterfaceC2808jh {

    /* renamed from: A */
    private long f7727A;

    /* renamed from: B */
    private int f7728B;

    /* renamed from: C */
    private boolean f7729C;

    /* renamed from: D */
    private boolean f7730D;

    /* renamed from: E */
    private long f7731E;

    /* renamed from: F */
    private float f7732F;

    /* renamed from: G */
    private InterfaceC2791ir[] f7733G;

    /* renamed from: H */
    private ByteBuffer[] f7734H;

    /* renamed from: I */
    private ByteBuffer f7735I;

    /* renamed from: J */
    private int f7736J;

    /* renamed from: K */
    private ByteBuffer f7737K;

    /* renamed from: L */
    private byte[] f7738L;

    /* renamed from: M */
    private int f7739M;

    /* renamed from: N */
    private int f7740N;

    /* renamed from: O */
    private boolean f7741O;

    /* renamed from: P */
    private boolean f7742P;

    /* renamed from: Q */
    private boolean f7743Q;

    /* renamed from: R */
    private boolean f7744R;

    /* renamed from: S */
    private int f7745S;

    /* renamed from: T */
    private C2638d f7746T;

    /* renamed from: U */
    private boolean f7747U;

    /* renamed from: V */
    private long f7748V;

    /* renamed from: W */
    private boolean f7749W;

    /* renamed from: X */
    private boolean f7750X;

    /* renamed from: Y */
    private final C2817jq f7751Y;

    /* renamed from: a */
    private final C2788io f7752a = null;

    /* renamed from: b */
    private final boolean f7753b;

    /* renamed from: c */
    private final C2814jn f7754c;

    /* renamed from: d */
    private final C2833kf f7755d;

    /* renamed from: e */
    private final InterfaceC2791ir[] f7756e;

    /* renamed from: f */
    private final InterfaceC2791ir[] f7757f;

    /* renamed from: g */
    private final ConditionVariable f7758g;

    /* renamed from: h */
    private final C2812jl f7759h;

    /* renamed from: i */
    private final ArrayDeque f7760i;

    /* renamed from: j */
    private final boolean f7761j;

    /* renamed from: k */
    private C2823jw f7762k;

    /* renamed from: l */
    private final C2819js f7763l;

    /* renamed from: m */
    private final C2819js f7764m;

    /* renamed from: n */
    private InterfaceC2805je f7765n;

    /* renamed from: o */
    private C2816jp f7766o;

    /* renamed from: p */
    private C2816jp f7767p;

    /* renamed from: q */
    private AudioTrack f7768q;

    /* renamed from: r */
    private C2611c f7769r;

    /* renamed from: s */
    private C2818jr f7770s;

    /* renamed from: t */
    private C2818jr f7771t;

    /* renamed from: u */
    private C2559aq f7772u;

    /* renamed from: v */
    private ByteBuffer f7773v;

    /* renamed from: w */
    private int f7774w;

    /* renamed from: x */
    private long f7775x;

    /* renamed from: y */
    private long f7776y;

    /* renamed from: z */
    private long f7777z;

    public C2824jx(C2788io c2788io, C2817jq c2817jq) {
        this.f7751Y = c2817jq;
        int i = C2628cq.f6961a;
        this.f7753b = false;
        this.f7761j = false;
        this.f7758g = new ConditionVariable(true);
        this.f7759h = new C2812jl(new C2820jt(this));
        C2814jn c2814jn = new C2814jn();
        this.f7754c = c2814jn;
        C2833kf c2833kf = new C2833kf();
        this.f7755d = c2833kf;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new C2829kb(), c2814jn, c2833kf);
        Collections.addAll(arrayList, c2817jq.m1905c());
        this.f7756e = (InterfaceC2791ir[]) arrayList.toArray(new InterfaceC2791ir[0]);
        this.f7757f = new InterfaceC2791ir[]{new C2825jy()};
        this.f7732F = 1.0f;
        this.f7769r = C2611c.f6917a;
        this.f7745S = 0;
        this.f7746T = new C2638d();
        this.f7771t = new C2818jr(C2559aq.f4867a, false, 0L, 0L);
        this.f7772u = C2559aq.f4867a;
        this.f7740N = -1;
        this.f7733G = new InterfaceC2791ir[0];
        this.f7734H = new ByteBuffer[0];
        this.f7760i = new ArrayDeque();
        this.f7763l = new C2819js();
        this.f7764m = new C2819js();
    }

    /* renamed from: F */
    private static int m1888F(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public final long m1887G() {
        C2816jp c2816jp = this.f7767p;
        return c2816jp.f7705c == 0 ? this.f7775x / c2816jp.f7704b : this.f7776y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public final long m1886H() {
        C2816jp c2816jp = this.f7767p;
        return c2816jp.f7705c == 0 ? this.f7777z / c2816jp.f7706d : this.f7727A;
    }

    /* renamed from: I */
    private static Pair m1885I(C2962p c2962p, C2788io c2788io) {
        return null;
    }

    /* renamed from: J */
    private final C2559aq m1884J() {
        return m1883K().f7715a;
    }

    /* renamed from: K */
    private final C2818jr m1883K() {
        C2818jr c2818jr = this.f7770s;
        return c2818jr != null ? c2818jr : !this.f7760i.isEmpty() ? (C2818jr) this.f7760i.getLast() : this.f7771t;
    }

    /* renamed from: L */
    private final void m1882L(long j) {
        C2559aq c2559aq;
        boolean z;
        if (m1871W()) {
            C2817jq c2817jq = this.f7751Y;
            c2559aq = m1884J();
            c2817jq.m1904d(c2559aq);
        } else {
            c2559aq = C2559aq.f4867a;
        }
        C2559aq c2559aq2 = c2559aq;
        if (m1871W()) {
            C2817jq c2817jq2 = this.f7751Y;
            boolean m1889E = m1889E();
            c2817jq2.m1903e(m1889E);
            z = m1889E;
        } else {
            z = false;
        }
        this.f7760i.add(new C2818jr(c2559aq2, z, Math.max(0L, j), this.f7767p.m1912b(m1886H())));
        InterfaceC2791ir[] interfaceC2791irArr = this.f7767p.f7711i;
        ArrayList arrayList = new ArrayList();
        for (InterfaceC2791ir interfaceC2791ir : interfaceC2791irArr) {
            if (interfaceC2791ir.mo1806g()) {
                arrayList.add(interfaceC2791ir);
            } else {
                interfaceC2791ir.mo1809c();
            }
        }
        int size = arrayList.size();
        this.f7733G = (InterfaceC2791ir[]) arrayList.toArray(new InterfaceC2791ir[size]);
        this.f7734H = new ByteBuffer[size];
        m1881M();
        InterfaceC2805je interfaceC2805je = this.f7765n;
        if (interfaceC2805je != null) {
            C2828ka.m1836T(((C2826jz) interfaceC2805je).f7779a).m1955s(z);
        }
    }

    /* renamed from: M */
    private final void m1881M() {
        int i = 0;
        while (true) {
            InterfaceC2791ir[] interfaceC2791irArr = this.f7733G;
            if (i >= interfaceC2791irArr.length) {
                return;
            }
            InterfaceC2791ir interfaceC2791ir = interfaceC2791irArr[i];
            interfaceC2791ir.mo1809c();
            this.f7734H[i] = interfaceC2791ir.mo1802b();
            i++;
        }
    }

    /* renamed from: N */
    private final void m1880N() {
        if (this.f7767p.m1910d()) {
            this.f7749W = true;
        }
    }

    /* renamed from: O */
    private final void m1879O() {
        if (this.f7742P) {
            return;
        }
        this.f7742P = true;
        this.f7759h.m1929d(m1886H());
        this.f7768q.stop();
        this.f7774w = 0;
    }

    /* renamed from: P */
    private final void m1878P(long j) throws C2807jg {
        ByteBuffer byteBuffer;
        int length = this.f7733G.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.f7734H[i - 1];
            } else {
                byteBuffer = this.f7735I;
                if (byteBuffer == null) {
                    byteBuffer = InterfaceC2791ir.f7617a;
                }
            }
            if (i == length) {
                m1875S(byteBuffer, j);
            } else {
                InterfaceC2791ir interfaceC2791ir = this.f7733G[i];
                if (i > this.f7740N) {
                    interfaceC2791ir.mo1801e(byteBuffer);
                }
                ByteBuffer mo1802b = interfaceC2791ir.mo1802b();
                this.f7734H[i] = mo1802b;
                if (mo1802b.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i--;
        }
    }

    /* renamed from: Q */
    private final void m1877Q(C2559aq c2559aq, boolean z) {
        C2818jr m1883K = m1883K();
        if (c2559aq.equals(m1883K.f7715a) && z == m1883K.f7716b) {
            return;
        }
        C2818jr c2818jr = new C2818jr(c2559aq, z, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
        if (m1873U()) {
            this.f7770s = c2818jr;
        } else {
            this.f7771t = c2818jr;
        }
    }

    /* renamed from: R */
    private final void m1876R() {
        if (m1873U()) {
            if (C2628cq.f6961a >= 21) {
                this.f7768q.setVolume(this.f7732F);
                return;
            }
            AudioTrack audioTrack = this.f7768q;
            float f = this.f7732F;
            audioTrack.setStereoVolume(f, f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
        if (r15 < r14) goto L63;
     */
    /* renamed from: S */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m1875S(java.nio.ByteBuffer r13, long r14) throws com.google.ads.interactivemedia.p034v3.internal.C2807jg {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2824jx.m1875S(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please submit an issue!!! */
    /* renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean m1874T() throws com.google.ads.interactivemedia.p034v3.internal.C2807jg {
        /*
            r9 = this;
            int r0 = r9.f7740N
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto Lb
            r9.f7740N = r3
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.f7740N
            com.google.ads.interactivemedia.v3.internal.ir[] r5 = r9.f7733G
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.mo1808d()
        L1f:
            r9.m1878P(r7)
            boolean r0 = r4.mo1800h()
            if (r0 != 0) goto L29
            return r3
        L29:
            int r0 = r9.f7740N
            int r0 = r0 + r2
            r9.f7740N = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.f7737K
            if (r0 == 0) goto L3b
            r9.m1875S(r0, r7)
            java.nio.ByteBuffer r0 = r9.f7737K
            if (r0 == 0) goto L3b
            return r3
        L3b:
            r9.f7740N = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2824jx.m1874T():boolean");
    }

    /* renamed from: U */
    private final boolean m1873U() {
        return this.f7768q != null;
    }

    /* renamed from: V */
    private static boolean m1872V(AudioTrack audioTrack) {
        return C2628cq.f6961a >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* renamed from: W */
    private final boolean m1871W() {
        return (this.f7747U || !MimeTypes.AUDIO_RAW.equals(this.f7767p.f7703a.f8372l) || m1870X(this.f7767p.f7703a.f8355A)) ? false : true;
    }

    /* renamed from: X */
    private final boolean m1870X(int i) {
        return false;
    }

    /* renamed from: E */
    public final boolean m1889E() {
        return m1883K().f7716b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: a */
    public final int mo1869a(C2962p c2962p) {
        if (!MimeTypes.AUDIO_RAW.equals(c2962p.f8372l)) {
            if (!this.f7749W) {
                int i = C2628cq.f6961a;
            }
            return m1885I(c2962p, null) != null ? 2 : 0;
        }
        int i2 = c2962p.f8355A;
        if (C2628cq.m2560W(i2)) {
            return i2 != 2 ? 1 : 2;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Invalid PCM encoding: ");
        sb.append(i2);
        Log.w("DefaultAudioSink", sb.toString());
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: b */
    public final long mo1868b(boolean z) {
        long m2518p;
        if (!m1873U() || this.f7730D) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.f7759h.m1931b(z), this.f7767p.m1912b(m1886H()));
        while (!this.f7760i.isEmpty() && min >= ((C2818jr) this.f7760i.getFirst()).f7718d) {
            this.f7771t = (C2818jr) this.f7760i.remove();
        }
        C2818jr c2818jr = this.f7771t;
        long j = min - c2818jr.f7718d;
        if (c2818jr.f7715a.equals(C2559aq.f4867a)) {
            m2518p = this.f7771t.f7717c + j;
        } else if (this.f7760i.isEmpty()) {
            m2518p = this.f7751Y.m1907a(j) + this.f7771t.f7717c;
        } else {
            C2818jr c2818jr2 = (C2818jr) this.f7760i.getFirst();
            m2518p = c2818jr2.f7717c - C2628cq.m2518p(c2818jr2.f7718d - min, this.f7771t.f7715a.f4868b);
        }
        return m2518p + this.f7767p.m1912b(this.f7751Y.m1906b());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: c */
    public final C2559aq mo1867c() {
        return m1884J();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: d */
    public final void mo1866d() {
        if (this.f7747U) {
            this.f7747U = false;
            mo1865e();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: e */
    public final void mo1865e() {
        if (m1873U()) {
            this.f7775x = 0L;
            this.f7776y = 0L;
            this.f7777z = 0L;
            this.f7727A = 0L;
            this.f7750X = false;
            this.f7728B = 0;
            this.f7771t = new C2818jr(m1884J(), m1889E(), 0L, 0L);
            this.f7731E = 0L;
            this.f7770s = null;
            this.f7760i.clear();
            this.f7735I = null;
            this.f7736J = 0;
            this.f7737K = null;
            this.f7742P = false;
            this.f7741O = false;
            this.f7740N = -1;
            this.f7773v = null;
            this.f7774w = 0;
            this.f7755d.m1794p();
            m1881M();
            if (this.f7759h.m1924i()) {
                this.f7768q.pause();
            }
            if (m1872V(this.f7768q)) {
                C2823jw c2823jw = this.f7762k;
                C2616ce.m2689d(c2823jw);
                c2823jw.m1894b(this.f7768q);
            }
            AudioTrack audioTrack = this.f7768q;
            this.f7768q = null;
            if (C2628cq.f6961a < 21 && !this.f7744R) {
                this.f7745S = 0;
            }
            C2816jp c2816jp = this.f7766o;
            if (c2816jp != null) {
                this.f7767p = c2816jp;
                this.f7766o = null;
            }
            this.f7759h.m1928e();
            this.f7758g.close();
            new C2815jo(this, audioTrack).start();
        }
        this.f7764m.m1902a();
        this.f7763l.m1902a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: f */
    public final void mo1864f() {
        this.f7729C = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: g */
    public final void mo1863g() {
        this.f7743Q = false;
        if (m1873U() && this.f7759h.m1921l()) {
            this.f7768q.pause();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: h */
    public final void mo1862h() {
        this.f7743Q = true;
        if (m1873U()) {
            this.f7759h.m1926g();
            this.f7768q.play();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: i */
    public final void mo1861i() throws C2807jg {
        if (!this.f7741O && m1873U() && m1874T()) {
            m1879O();
            this.f7741O = true;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: j */
    public final void mo1860j() {
        mo1865e();
        for (InterfaceC2791ir interfaceC2791ir : this.f7756e) {
            interfaceC2791ir.mo1807f();
        }
        InterfaceC2791ir[] interfaceC2791irArr = this.f7757f;
        int length = interfaceC2791irArr.length;
        for (int i = 0; i <= 0; i++) {
            interfaceC2791irArr[i].mo1807f();
        }
        this.f7743Q = false;
        this.f7749W = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: k */
    public final void mo1859k(C2611c c2611c) {
        if (this.f7769r.equals(c2611c)) {
            return;
        }
        this.f7769r = c2611c;
        if (this.f7747U) {
            return;
        }
        mo1865e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: l */
    public final void mo1858l(int i) {
        if (this.f7745S != i) {
            this.f7745S = i;
            this.f7744R = i != 0;
            mo1865e();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: m */
    public final void mo1857m(C2638d c2638d) {
        if (this.f7746T.equals(c2638d)) {
            return;
        }
        int i = c2638d.f6994a;
        float f = c2638d.f6995b;
        if (this.f7768q != null) {
            int i2 = this.f7746T.f6994a;
        }
        this.f7746T = c2638d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: n */
    public final void mo1856n(InterfaceC2805je interfaceC2805je) {
        this.f7765n = interfaceC2805je;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: o */
    public final void mo1855o(C2559aq c2559aq) {
        m1877Q(new C2559aq(C2628cq.m2556a(c2559aq.f4868b, 0.1f, 8.0f), C2628cq.m2556a(c2559aq.f4869c, 0.1f, 8.0f)), m1889E());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: p */
    public final void mo1854p(boolean z) {
        m1877Q(m1884J(), z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: q */
    public final void mo1853q(float f) {
        if (this.f7732F != f) {
            this.f7732F = f;
            m1876R();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: r */
    public final boolean mo1852r(ByteBuffer byteBuffer, long j, int i) throws C2804jd, C2807jg {
        int i2;
        byte b;
        int i3;
        byte b2;
        int i4;
        ByteBuffer byteBuffer2 = this.f7735I;
        C2616ce.m2687f(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f7766o != null) {
            if (!m1874T()) {
                return false;
            }
            C2816jp c2816jp = this.f7766o;
            C2816jp c2816jp2 = this.f7767p;
            if (c2816jp2.f7705c != c2816jp.f7705c || c2816jp2.f7709g != c2816jp.f7709g || c2816jp2.f7707e != c2816jp.f7707e || c2816jp2.f7708f != c2816jp.f7708f || c2816jp2.f7706d != c2816jp.f7706d) {
                m1879O();
                if (mo1851s()) {
                    return false;
                }
                mo1865e();
            } else {
                this.f7767p = c2816jp;
                this.f7766o = null;
                if (m1872V(this.f7768q)) {
                    this.f7768q.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f7768q;
                    C2962p c2962p = this.f7767p.f7703a;
                    audioTrack.setOffloadDelayPadding(c2962p.f8356B, c2962p.f8357C);
                    this.f7750X = true;
                }
            }
            m1882L(j);
        }
        if (!m1873U()) {
            try {
                this.f7758g.block();
                try {
                    C2816jp c2816jp3 = this.f7767p;
                    C2616ce.m2689d(c2816jp3);
                    AudioTrack m1911c = c2816jp3.m1911c(this.f7747U, this.f7769r, this.f7745S);
                    this.f7768q = m1911c;
                    if (m1872V(m1911c)) {
                        AudioTrack audioTrack2 = this.f7768q;
                        if (this.f7762k == null) {
                            this.f7762k = new C2823jw(this);
                        }
                        this.f7762k.m1895a(audioTrack2);
                        AudioTrack audioTrack3 = this.f7768q;
                        C2962p c2962p2 = this.f7767p.f7703a;
                        audioTrack3.setOffloadDelayPadding(c2962p2.f8356B, c2962p2.f8357C);
                    }
                    this.f7745S = this.f7768q.getAudioSessionId();
                    C2812jl c2812jl = this.f7759h;
                    AudioTrack audioTrack4 = this.f7768q;
                    C2816jp c2816jp4 = this.f7767p;
                    c2812jl.m1927f(audioTrack4, c2816jp4.f7705c == 2, c2816jp4.f7709g, c2816jp4.f7706d, c2816jp4.f7710h);
                    m1876R();
                    int i5 = this.f7746T.f6994a;
                    this.f7730D = true;
                } catch (C2804jd e) {
                    m1880N();
                    InterfaceC2805je interfaceC2805je = this.f7765n;
                    if (interfaceC2805je != null) {
                        interfaceC2805je.mo1842a(e);
                    }
                    throw e;
                }
            } catch (C2804jd e2) {
                if (e2.f7645a) {
                    throw e2;
                }
                this.f7763l.m1901b(e2);
                return false;
            }
        }
        this.f7763l.m1902a();
        if (this.f7730D) {
            this.f7731E = Math.max(0L, j);
            this.f7729C = false;
            this.f7730D = false;
            m1882L(j);
            if (this.f7743Q) {
                mo1862h();
            }
        }
        if (this.f7759h.m1922k(m1886H())) {
            if (this.f7735I == null) {
                C2616ce.m2687f(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
                if (!byteBuffer.hasRemaining()) {
                    return true;
                }
                C2816jp c2816jp5 = this.f7767p;
                if (c2816jp5.f7705c != 0 && this.f7728B == 0) {
                    int i6 = c2816jp5.f7709g;
                    int i7 = 1024;
                    switch (i6) {
                        case 5:
                        case 6:
                        case 18:
                            i7 = C3210ye.m553a(byteBuffer);
                            break;
                        case 7:
                        case 8:
                            int i8 = C3227yv.f9540a;
                            int position = byteBuffer.position();
                            byte b3 = byteBuffer.get(position);
                            if (b3 != -2) {
                                if (b3 == -1) {
                                    i2 = (byteBuffer.get(position + 4) & 7) << 4;
                                    b2 = byteBuffer.get(position + 7);
                                } else if (b3 == 31) {
                                    i2 = (byteBuffer.get(position + 5) & 7) << 4;
                                    b2 = byteBuffer.get(position + 6);
                                } else {
                                    i2 = (byteBuffer.get(position + 4) & 1) << 6;
                                    b = byteBuffer.get(position + 5);
                                }
                                i3 = b2 & 60;
                                i7 = (((i3 >> 2) | i2) + 1) * 32;
                                break;
                            } else {
                                i2 = (byteBuffer.get(position + 5) & 1) << 6;
                                b = byteBuffer.get(position + 4);
                            }
                            i3 = b & 252;
                            i7 = (((i3 >> 2) | i2) + 1) * 32;
                        case 9:
                            i7 = C3241zi.m477c(C2628cq.m2528f(byteBuffer, byteBuffer.position()));
                            if (i7 == -1) {
                                throw new IllegalArgumentException();
                            }
                            break;
                        case 10:
                        case 16:
                            break;
                        case 11:
                        case 12:
                            i7 = 2048;
                            break;
                        case 13:
                        default:
                            StringBuilder sb = new StringBuilder(38);
                            sb.append("Unexpected audio encoding: ");
                            sb.append(i6);
                            throw new IllegalStateException(sb.toString());
                        case 14:
                            int i9 = C3210ye.f9476a;
                            int position2 = byteBuffer.position();
                            int limit = byteBuffer.limit() - 10;
                            int i10 = position2;
                            while (true) {
                                if (i10 > limit) {
                                    i4 = -1;
                                } else if ((C2628cq.m2528f(byteBuffer, i10 + 4) & (-2)) == -126718022) {
                                    i4 = i10 - position2;
                                } else {
                                    i10++;
                                }
                            }
                            if (i4 != -1) {
                                i7 = (40 << ((byteBuffer.get((byteBuffer.position() + i4) + ((byteBuffer.get((byteBuffer.position() + i4) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                                break;
                            } else {
                                i7 = 0;
                                break;
                            }
                        case 15:
                            i7 = 512;
                            break;
                        case 17:
                            int i11 = C3212yg.f9486a;
                            byte[] bArr = new byte[16];
                            int position3 = byteBuffer.position();
                            byteBuffer.get(bArr);
                            byteBuffer.position(position3);
                            i7 = C3212yg.m547a(new C2620ci(bArr)).f9485c;
                            break;
                    }
                    this.f7728B = i7;
                    if (i7 == 0) {
                        return true;
                    }
                }
                if (this.f7770s != null) {
                    if (!m1874T()) {
                        return false;
                    }
                    m1882L(j);
                    this.f7770s = null;
                }
                long m1887G = this.f7731E + (((m1887G() - this.f7755d.m1795o()) * 1000000) / this.f7767p.f7703a.f8386z);
                if (!this.f7729C && Math.abs(m1887G - j) > 200000) {
                    this.f7765n.mo1842a(new C2806jf(j, m1887G));
                    this.f7729C = true;
                }
                if (this.f7729C) {
                    if (!m1874T()) {
                        return false;
                    }
                    long j2 = j - m1887G;
                    this.f7731E += j2;
                    this.f7729C = false;
                    m1882L(j);
                    InterfaceC2805je interfaceC2805je2 = this.f7765n;
                    if (interfaceC2805je2 != null && j2 != 0) {
                        ((C2826jz) interfaceC2805je2).f7779a.m1834aa();
                    }
                }
                if (this.f7767p.f7705c == 0) {
                    this.f7775x += byteBuffer.remaining();
                } else {
                    this.f7776y += this.f7728B * i;
                }
                this.f7735I = byteBuffer;
                this.f7736J = i;
            }
            m1878P(j);
            if (!this.f7735I.hasRemaining()) {
                this.f7735I = null;
                this.f7736J = 0;
                return true;
            } else if (this.f7759h.m1923j(m1886H())) {
                Log.w("DefaultAudioSink", "Resetting stalled audio track");
                mo1865e();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: s */
    public final boolean mo1851s() {
        return m1873U() && this.f7759h.m1925h(m1886H());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: t */
    public final boolean mo1850t() {
        return !m1873U() || (this.f7741O && !mo1851s());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: u */
    public final boolean mo1849u(C2962p c2962p) {
        return mo1869a(c2962p) != 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2808jh
    /* renamed from: v */
    public final void mo1848v(C2962p c2962p, int[] iArr) throws C2803jc {
        InterfaceC2791ir[] interfaceC2791irArr;
        int intValue;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr2;
        if (MimeTypes.AUDIO_RAW.equals(c2962p.f8372l)) {
            C2616ce.m2687f(C2628cq.m2560W(c2962p.f8355A));
            i2 = C2628cq.m2523k(c2962p.f8355A, c2962p.f8385y);
            InterfaceC2791ir[] interfaceC2791irArr2 = m1870X(c2962p.f8355A) ? this.f7757f : this.f7756e;
            this.f7755d.m1793q(c2962p.f8356B, c2962p.f8357C);
            if (C2628cq.f6961a < 21 && c2962p.f8385y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i6 = 0; i6 < 6; i6++) {
                    iArr2[i6] = i6;
                }
            } else {
                iArr2 = iArr;
            }
            this.f7754c.m1914o(iArr2);
            C2789ip c2789ip = new C2789ip(c2962p.f8386z, c2962p.f8385y, c2962p.f8355A);
            for (InterfaceC2791ir interfaceC2791ir : interfaceC2791irArr2) {
                try {
                    C2789ip mo1810a = interfaceC2791ir.mo1810a(c2789ip);
                    if (true == interfaceC2791ir.mo1806g()) {
                        c2789ip = mo1810a;
                    }
                } catch (C2790iq e) {
                    throw new C2803jc(e, c2962p);
                }
            }
            int i7 = c2789ip.f7615d;
            i4 = c2789ip.f7613b;
            int i8 = c2789ip.f7614c;
            intValue = C2628cq.m2529e(i8);
            interfaceC2791irArr = interfaceC2791irArr2;
            i = i7;
            i3 = C2628cq.m2523k(i7, i8);
            i5 = 0;
        } else {
            InterfaceC2791ir[] interfaceC2791irArr3 = new InterfaceC2791ir[0];
            int i9 = c2962p.f8386z;
            Pair m1885I = m1885I(c2962p, null);
            int i10 = C2628cq.f6961a;
            if (m1885I == null) {
                String valueOf = String.valueOf(c2962p);
                String.valueOf(valueOf).length();
                throw new C2803jc("Unable to configure passthrough for: ".concat(String.valueOf(valueOf)), c2962p);
            }
            int intValue2 = ((Integer) m1885I.first).intValue();
            interfaceC2791irArr = interfaceC2791irArr3;
            intValue = ((Integer) m1885I.second).intValue();
            i = intValue2;
            i2 = -1;
            i3 = -1;
            i4 = i9;
            i5 = 2;
        }
        if (i == 0) {
            String valueOf2 = String.valueOf(c2962p);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 48);
            sb.append("Invalid output encoding (mode=");
            sb.append(i5);
            sb.append(") for: ");
            sb.append(valueOf2);
            throw new C2803jc(sb.toString(), c2962p);
        } else if (intValue != 0) {
            this.f7749W = false;
            C2816jp c2816jp = new C2816jp(c2962p, i2, i5, i3, i4, intValue, i, false, interfaceC2791irArr);
            if (m1873U()) {
                this.f7766o = c2816jp;
            } else {
                this.f7767p = c2816jp;
            }
        } else {
            String valueOf3 = String.valueOf(c2962p);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 54);
            sb2.append("Invalid output channel config (mode=");
            sb2.append(i5);
            sb2.append(") for: ");
            sb2.append(valueOf3);
            throw new C2803jc(sb2.toString(), c2962p);
        }
    }
}
