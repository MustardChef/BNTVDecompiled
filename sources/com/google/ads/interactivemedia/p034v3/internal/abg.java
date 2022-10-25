package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;
import com.blankj.utilcode.util.CacheUtils;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abg */
/* loaded from: classes2.dex */
public final class abg implements InterfaceC3229yx {

    /* renamed from: a */
    private static final byte[] f3006a;

    /* renamed from: b */
    private static final byte[] f3007b;

    /* renamed from: c */
    private static final byte[] f3008c;

    /* renamed from: d */
    private static final UUID f3009d;

    /* renamed from: e */
    private static final Map f3010e;

    /* renamed from: A */
    private int f3011A;

    /* renamed from: B */
    private long f3012B;

    /* renamed from: C */
    private boolean f3013C;

    /* renamed from: D */
    private long f3014D;

    /* renamed from: E */
    private long f3015E;

    /* renamed from: F */
    private long f3016F;

    /* renamed from: G */
    private C2614cc f3017G;

    /* renamed from: H */
    private C2614cc f3018H;

    /* renamed from: I */
    private boolean f3019I;

    /* renamed from: J */
    private boolean f3020J;

    /* renamed from: K */
    private int f3021K;

    /* renamed from: L */
    private long f3022L;

    /* renamed from: M */
    private long f3023M;

    /* renamed from: N */
    private int f3024N;

    /* renamed from: O */
    private int f3025O;

    /* renamed from: P */
    private int[] f3026P;

    /* renamed from: Q */
    private int f3027Q;

    /* renamed from: R */
    private int f3028R;

    /* renamed from: S */
    private int f3029S;

    /* renamed from: T */
    private int f3030T;

    /* renamed from: U */
    private boolean f3031U;

    /* renamed from: V */
    private int f3032V;

    /* renamed from: W */
    private int f3033W;

    /* renamed from: X */
    private int f3034X;

    /* renamed from: Y */
    private boolean f3035Y;

    /* renamed from: Z */
    private boolean f3036Z;

    /* renamed from: aa */
    private boolean f3037aa;

    /* renamed from: ab */
    private int f3038ab;

    /* renamed from: ac */
    private byte f3039ac;

    /* renamed from: ad */
    private boolean f3040ad;

    /* renamed from: ae */
    private InterfaceC3233za f3041ae;

    /* renamed from: af */
    private final abb f3042af;

    /* renamed from: f */
    private final abi f3043f;

    /* renamed from: g */
    private final SparseArray f3044g;

    /* renamed from: h */
    private final boolean f3045h;

    /* renamed from: i */
    private final C2621cj f3046i;

    /* renamed from: j */
    private final C2621cj f3047j;

    /* renamed from: k */
    private final C2621cj f3048k;

    /* renamed from: l */
    private final C2621cj f3049l;

    /* renamed from: m */
    private final C2621cj f3050m;

    /* renamed from: n */
    private final C2621cj f3051n;

    /* renamed from: o */
    private final C2621cj f3052o;

    /* renamed from: p */
    private final C2621cj f3053p;

    /* renamed from: q */
    private final C2621cj f3054q;

    /* renamed from: r */
    private final C2621cj f3055r;

    /* renamed from: s */
    private ByteBuffer f3056s;

    /* renamed from: t */
    private long f3057t;

    /* renamed from: u */
    private long f3058u;

    /* renamed from: v */
    private long f3059v;

    /* renamed from: w */
    private long f3060w;

    /* renamed from: x */
    private long f3061x;

    /* renamed from: y */
    private abf f3062y;

    /* renamed from: z */
    private boolean f3063z;

    static {
        abd abdVar = abd.f2953a;
        f3006a = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        f3007b = C2628cq.m2554ab("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        f3008c = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f3009d = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", Integer.valueOf((int) bqk.f6530aq));
        f3010e = Collections.unmodifiableMap(hashMap);
    }

    public abg() {
        this(0);
    }

    /* renamed from: A */
    private static byte[] m5935A(long j, String str, long j2) {
        C2616ce.m2687f(j != C3282C.TIME_UNSET);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((i * CacheUtils.TIME_HOUR) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((i2 * 60) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return C2628cq.m2554ab(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    /* renamed from: B */
    private static int[] m5934B(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    /* renamed from: o */
    private final int m5924o() {
        int i = this.f3033W;
        m5914y();
        return i;
    }

    /* renamed from: p */
    private final int m5923p(InterfaceC3230yy interfaceC3230yy, abf abfVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(abfVar.f2981b)) {
            m5913z(interfaceC3230yy, f3006a, i);
            return m5924o();
        } else if ("S_TEXT/ASS".equals(abfVar.f2981b)) {
            m5913z(interfaceC3230yy, f3008c, i);
            return m5924o();
        } else {
            InterfaceC3253zu interfaceC3253zu = abfVar.f2976V;
            if (!this.f3035Y) {
                if (abfVar.f2986g) {
                    this.f3029S &= -1073741825;
                    if (!this.f3036Z) {
                        interfaceC3230yy.mo495g(this.f3048k.m2642H(), 0, 1);
                        this.f3032V++;
                        if ((this.f3048k.m2642H()[0] & 128) == 128) {
                            throw C2555ao.m4866a("Extension bit is set in signal byte", null);
                        }
                        this.f3039ac = this.f3048k.m2642H()[0];
                        this.f3036Z = true;
                    }
                    byte b = this.f3039ac;
                    if ((b & 1) == 1) {
                        int i3 = b & 2;
                        this.f3029S |= 1073741824;
                        if (!this.f3040ad) {
                            interfaceC3230yy.mo495g(this.f3053p.m2642H(), 0, 8);
                            this.f3032V += 8;
                            this.f3040ad = true;
                            this.f3048k.m2642H()[0] = (byte) ((i3 != 2 ? 0 : 128) | 8);
                            this.f3048k.m2644F(0);
                            interfaceC3253zu.mo439i(this.f3048k, 1);
                            this.f3033W++;
                            this.f3053p.m2644F(0);
                            interfaceC3253zu.mo439i(this.f3053p, 8);
                            this.f3033W += 8;
                        }
                        if (i3 == 2) {
                            if (!this.f3037aa) {
                                interfaceC3230yy.mo495g(this.f3048k.m2642H(), 0, 1);
                                this.f3032V++;
                                this.f3048k.m2644F(0);
                                this.f3038ab = this.f3048k.m2633i();
                                this.f3037aa = true;
                            }
                            int i4 = this.f3038ab * 4;
                            this.f3048k.m2648B(i4);
                            interfaceC3230yy.mo495g(this.f3048k.m2642H(), 0, i4);
                            this.f3032V += i4;
                            int i5 = (this.f3038ab >> 1) + 1;
                            int i6 = (i5 * 6) + 2;
                            ByteBuffer byteBuffer = this.f3056s;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.f3056s = ByteBuffer.allocate(i6);
                            }
                            this.f3056s.position(0);
                            this.f3056s.putShort((short) i5);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i2 = this.f3038ab;
                                if (i7 >= i2) {
                                    break;
                                }
                                int m2630l = this.f3048k.m2630l();
                                if (i7 % 2 == 0) {
                                    this.f3056s.putShort((short) (m2630l - i8));
                                } else {
                                    this.f3056s.putInt(m2630l - i8);
                                }
                                i7++;
                                i8 = m2630l;
                            }
                            int i9 = (i - this.f3032V) - i8;
                            if ((i2 & 1) == 1) {
                                this.f3056s.putInt(i9);
                            } else {
                                this.f3056s.putShort((short) i9);
                                this.f3056s.putInt(0);
                            }
                            this.f3054q.m2646D(this.f3056s.array(), i6);
                            interfaceC3253zu.mo439i(this.f3054q, i6);
                            this.f3033W += i6;
                        }
                    }
                } else {
                    byte[] bArr = abfVar.f2987h;
                    if (bArr != null) {
                        this.f3051n.m2646D(bArr, bArr.length);
                    }
                }
                if (abfVar.f2985f > 0) {
                    this.f3029S |= 268435456;
                    this.f3055r.m2648B(0);
                    this.f3048k.m2648B(4);
                    this.f3048k.m2642H()[0] = (byte) ((i >> 24) & 255);
                    this.f3048k.m2642H()[1] = (byte) ((i >> 16) & 255);
                    this.f3048k.m2642H()[2] = (byte) ((i >> 8) & 255);
                    this.f3048k.m2642H()[3] = (byte) (i & 255);
                    interfaceC3253zu.mo439i(this.f3048k, 4);
                    this.f3033W += 4;
                }
                this.f3035Y = true;
            }
            int m2638d = i + this.f3051n.m2638d();
            if ("V_MPEG4/ISO/AVC".equals(abfVar.f2981b) || "V_MPEGH/ISO/HEVC".equals(abfVar.f2981b)) {
                byte[] m2642H = this.f3047j.m2642H();
                m2642H[0] = 0;
                m2642H[1] = 0;
                m2642H[2] = 0;
                int i10 = abfVar.f2977W;
                int i11 = 4 - i10;
                while (this.f3032V < m2638d) {
                    int i12 = this.f3034X;
                    if (i12 == 0) {
                        int min = Math.min(i10, this.f3051n.m2641a());
                        interfaceC3230yy.mo495g(m2642H, i11 + min, i10 - min);
                        if (min > 0) {
                            this.f3051n.m2649A(m2642H, i11, min);
                        }
                        this.f3032V += i10;
                        this.f3047j.m2644F(0);
                        this.f3034X = this.f3047j.m2630l();
                        this.f3046i.m2644F(0);
                        interfaceC3253zu.mo442e(this.f3046i, 4);
                        this.f3033W += 4;
                    } else {
                        int m5922q = m5922q(interfaceC3230yy, interfaceC3253zu, i12);
                        this.f3032V += m5922q;
                        this.f3033W += m5922q;
                        this.f3034X -= m5922q;
                    }
                }
            } else {
                if (abfVar.f2973S != null) {
                    C2616ce.m2685h(this.f3051n.m2638d() == 0);
                    abfVar.f2973S.m435d(interfaceC3230yy);
                }
                while (true) {
                    int i13 = this.f3032V;
                    if (i13 >= m2638d) {
                        break;
                    }
                    int m5922q2 = m5922q(interfaceC3230yy, interfaceC3253zu, m2638d - i13);
                    this.f3032V += m5922q2;
                    this.f3033W += m5922q2;
                }
            }
            if ("A_VORBIS".equals(abfVar.f2981b)) {
                this.f3049l.m2644F(0);
                interfaceC3253zu.mo442e(this.f3049l, 4);
                this.f3033W += 4;
            }
            return m5924o();
        }
    }

    /* renamed from: q */
    private final int m5922q(InterfaceC3230yy interfaceC3230yy, InterfaceC3253zu interfaceC3253zu, int i) throws IOException {
        int m2641a = this.f3051n.m2641a();
        if (m2641a > 0) {
            int min = Math.min(i, m2641a);
            interfaceC3253zu.mo442e(this.f3051n, min);
            return min;
        }
        return interfaceC3253zu.mo444a(interfaceC3230yy, i, false);
    }

    /* renamed from: r */
    private final long m5921r(long j) throws C2555ao {
        long j2 = this.f3059v;
        if (j2 == C3282C.TIME_UNSET) {
            throw C2555ao.m4866a("Can't scale timecode prior to timecodeScale being set.", null);
        }
        return C2628cq.m2512v(j, j2, 1000L);
    }

    /* renamed from: s */
    private final abf m5920s(int i) throws C2555ao {
        m5918u(i);
        return this.f3062y;
    }

    /* renamed from: t */
    private final void m5919t(int i) throws C2555ao {
        if (this.f3017G == null || this.f3018H == null) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Element ");
            sb.append(i);
            sb.append(" must be in a Cues");
            throw C2555ao.m4866a(sb.toString(), null);
        }
    }

    /* renamed from: u */
    private final void m5918u(int i) throws C2555ao {
        if (this.f3062y != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a TrackEntry");
        throw C2555ao.m4866a(sb.toString(), null);
    }

    /* renamed from: v */
    private final void m5917v() {
        C2616ce.m2688e(this.f3041ae);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd A[EDGE_INSN: B:53:0x00bd->B:41:0x00bd ?: BREAK  , SYNTHETIC] */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m5916w(com.google.ads.interactivemedia.p034v3.internal.abf r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.abg.m5916w(com.google.ads.interactivemedia.v3.internal.abf, long, int, int, int):void");
    }

    /* renamed from: x */
    private final void m5915x(InterfaceC3230yy interfaceC3230yy, int i) throws IOException {
        if (this.f3048k.m2638d() >= i) {
            return;
        }
        if (this.f3048k.m2640b() < i) {
            C2621cj c2621cj = this.f3048k;
            int m2640b = c2621cj.m2640b();
            c2621cj.m2617y(Math.max(m2640b + m2640b, i));
        }
        interfaceC3230yy.mo495g(this.f3048k.m2642H(), this.f3048k.m2638d(), i - this.f3048k.m2638d());
        this.f3048k.m2645E(i);
    }

    /* renamed from: y */
    private final void m5914y() {
        this.f3032V = 0;
        this.f3033W = 0;
        this.f3034X = 0;
        this.f3035Y = false;
        this.f3036Z = false;
        this.f3037aa = false;
        this.f3038ab = 0;
        this.f3039ac = (byte) 0;
        this.f3040ad = false;
        this.f3051n.m2648B(0);
    }

    /* renamed from: z */
    private final void m5913z(InterfaceC3230yy interfaceC3230yy, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = i + 32;
        if (this.f3052o.m2640b() < i2) {
            this.f3052o.m2647C(Arrays.copyOf(bArr, i2 + i));
        } else {
            System.arraycopy(bArr, 0, this.f3052o.m2642H(), 0, 32);
        }
        interfaceC3230yy.mo495g(this.f3052o.m2642H(), 32, i);
        this.f3052o.m2644F(0);
        this.f3052o.m2645E(i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return new abh().m5912a(interfaceC3230yy);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        this.f3020J = false;
        while (!this.f3020J) {
            if (!this.f3042af.m5946c(interfaceC3230yy)) {
                for (int i = 0; i < this.f3044g.size(); i++) {
                    abf abfVar = (abf) this.f3044g.valueAt(i);
                    abf.m5941d(abfVar);
                    C3254zv c3254zv = abfVar.f2973S;
                    if (c3254zv != null) {
                        c3254zv.m438a(abfVar.f2976V, abfVar.f2988i);
                    }
                }
                return -1;
            }
            long mo498d = interfaceC3230yy.mo498d();
            if (this.f3013C) {
                this.f3015E = mo498d;
                c3247zo.f9610a = this.f3014D;
                this.f3013C = false;
                return 1;
            } else if (this.f3063z) {
                long j = this.f3015E;
                if (j != -1) {
                    c3247zo.f9610a = j;
                    this.f3015E = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f3041ae = interfaceC3233za;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        this.f3016F = C3282C.TIME_UNSET;
        this.f3021K = 0;
        this.f3042af.m5947b();
        this.f3043f.m5906e();
        m5914y();
        for (int i = 0; i < this.f3044g.size(); i++) {
            C3254zv c3254zv = ((abf) this.f3044g.valueAt(i)).f2973S;
            if (c3254zv != null) {
                c3254zv.m437b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0269, code lost:
        throw com.google.ads.interactivemedia.p034v3.internal.C2555ao.m4866a("EBML lacing sample size out of range.", null);
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5931h(int r19, int r20, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.abg.m5931h(int, int, com.google.ads.interactivemedia.v3.internal.yy):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0244, code lost:
        if (r1.equals("V_AV1") != false) goto L94;
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5930i(int r19) throws com.google.ads.interactivemedia.p034v3.internal.C2555ao {
        /*
            Method dump skipped, instructions count: 1072
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.abg.m5930i(int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final void m5929j(int i, double d) throws C2555ao {
        if (i == 181) {
            m5920s(i).f2970P = (int) d;
        } else if (i == 17545) {
            this.f3060w = (long) d;
        } else {
            switch (i) {
                case 21969:
                    m5920s(i).f2957C = (float) d;
                    return;
                case 21970:
                    m5920s(i).f2958D = (float) d;
                    return;
                case 21971:
                    m5920s(i).f2959E = (float) d;
                    return;
                case 21972:
                    m5920s(i).f2960F = (float) d;
                    return;
                case 21973:
                    m5920s(i).f2961G = (float) d;
                    return;
                case 21974:
                    m5920s(i).f2962H = (float) d;
                    return;
                case 21975:
                    m5920s(i).f2963I = (float) d;
                    return;
                case 21976:
                    m5920s(i).f2964J = (float) d;
                    return;
                case 21977:
                    m5920s(i).f2965K = (float) d;
                    return;
                case 21978:
                    m5920s(i).f2966L = (float) d;
                    return;
                default:
                    switch (i) {
                        case 30323:
                            m5920s(i).f2997r = (float) d;
                            return;
                        case 30324:
                            m5920s(i).f2998s = (float) d;
                            return;
                        case 30325:
                            m5920s(i).f2999t = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public final void m5927l(int i, long j, long j2) throws C2555ao {
        m5917v();
        if (i == 160) {
            this.f3031U = false;
        } else if (i == 174) {
            this.f3062y = new abf(null);
        } else if (i == 187) {
            this.f3019I = false;
        } else if (i == 19899) {
            this.f3011A = -1;
            this.f3012B = -1L;
        } else if (i == 20533) {
            m5920s(i).f2986g = true;
        } else if (i == 21968) {
            m5920s(i).f3002w = true;
        } else if (i == 408125543) {
            long j3 = this.f3058u;
            if (j3 != -1 && j3 != j) {
                throw C2555ao.m4866a("Multiple Segment elements not supported", null);
            }
            this.f3058u = j;
            this.f3057t = j2;
        } else if (i == 475249515) {
            this.f3017G = new C2614cc();
            this.f3018H = new C2614cc();
        } else if (i == 524531317 && !this.f3063z) {
            if (this.f3045h && this.f3014D != -1) {
                this.f3013C = true;
                return;
            }
            this.f3041ae.mo487w(new C3249zq(this.f3061x));
            this.f3063z = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public final void m5926m(int i, String str) throws C2555ao {
        if (i == 134) {
            m5920s(i).f2981b = str;
        } else if (i != 17026) {
            if (i == 21358) {
                m5920s(i).f2980a = str;
            } else if (i != 2274716) {
            } else {
                abf.m5942c(m5920s(i), str);
            }
        } else if ("webm".equals(str) || "matroska".equals(str)) {
        } else {
            StringBuilder sb = new StringBuilder(str.length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw C2555ao.m4866a(sb.toString(), null);
        }
    }

    public abg(int i) {
        abb abbVar = new abb();
        this.f3058u = -1L;
        this.f3059v = C3282C.TIME_UNSET;
        this.f3060w = C3282C.TIME_UNSET;
        this.f3061x = C3282C.TIME_UNSET;
        this.f3014D = -1L;
        this.f3015E = -1L;
        this.f3016F = C3282C.TIME_UNSET;
        this.f3042af = abbVar;
        abbVar.m5948a(new abe(this));
        this.f3045h = 1 == (i ^ 1);
        this.f3043f = new abi();
        this.f3044g = new SparseArray();
        this.f3048k = new C2621cj(4);
        this.f3049l = new C2621cj(ByteBuffer.allocate(4).putInt(-1).array());
        this.f3050m = new C2621cj(4);
        this.f3046i = new C2621cj(C3245zm.f9602a);
        this.f3047j = new C2621cj(4);
        this.f3051n = new C2621cj();
        this.f3052o = new C2621cj();
        this.f3053p = new C2621cj(8);
        this.f3054q = new C2621cj();
        this.f3055r = new C2621cj();
        this.f3026P = new int[1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public final void m5928k(int i, long j) throws C2555ao {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw C2555ao.m4866a(sb.toString(), null);
        } else if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw C2555ao.m4866a(sb2.toString(), null);
        } else {
            switch (i) {
                case 131:
                    m5920s(i).f2983d = (int) j;
                    return;
                case 136:
                    m5920s(i).f2975U = j == 1;
                    return;
                case 155:
                    this.f3023M = m5921r(j);
                    return;
                case 159:
                    m5920s(i).f2968N = (int) j;
                    return;
                case 176:
                    m5920s(i).f2991l = (int) j;
                    return;
                case 179:
                    m5919t(i);
                    this.f3017G.m2693c(m5921r(j));
                    return;
                case 186:
                    m5920s(i).f2992m = (int) j;
                    return;
                case bqk.f6554bN /* 215 */:
                    m5920s(i).f2982c = (int) j;
                    return;
                case bqk.f6597cd /* 231 */:
                    this.f3016F = m5921r(j);
                    return;
                case 238:
                    this.f3030T = (int) j;
                    return;
                case 241:
                    if (this.f3019I) {
                        return;
                    }
                    m5919t(i);
                    this.f3018H.m2693c(j);
                    this.f3019I = true;
                    return;
                case bqk.f6602ci /* 251 */:
                    this.f3031U = true;
                    return;
                case 16871:
                    abf.m5943b(m5920s(i), (int) j);
                    return;
                case 16980:
                    if (j == 3) {
                        return;
                    }
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("ContentCompAlgo ");
                    sb3.append(j);
                    sb3.append(" not supported");
                    throw C2555ao.m4866a(sb3.toString(), null);
                case 17029:
                    if (j < 1 || j > 2) {
                        StringBuilder sb4 = new StringBuilder(53);
                        sb4.append("DocTypeReadVersion ");
                        sb4.append(j);
                        sb4.append(" not supported");
                        throw C2555ao.m4866a(sb4.toString(), null);
                    }
                    return;
                case 17143:
                    if (j == 1) {
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder(50);
                    sb5.append("EBMLReadVersion ");
                    sb5.append(j);
                    sb5.append(" not supported");
                    throw C2555ao.m4866a(sb5.toString(), null);
                case 18401:
                    if (j == 5) {
                        return;
                    }
                    StringBuilder sb6 = new StringBuilder(49);
                    sb6.append("ContentEncAlgo ");
                    sb6.append(j);
                    sb6.append(" not supported");
                    throw C2555ao.m4866a(sb6.toString(), null);
                case 18408:
                    if (j == 1) {
                        return;
                    }
                    StringBuilder sb7 = new StringBuilder(56);
                    sb7.append("AESSettingsCipherMode ");
                    sb7.append(j);
                    sb7.append(" not supported");
                    throw C2555ao.m4866a(sb7.toString(), null);
                case 21420:
                    this.f3012B = j + this.f3058u;
                    return;
                case 21432:
                    m5918u(i);
                    int i2 = (int) j;
                    if (i2 == 0) {
                        this.f3062y.f3001v = 0;
                        return;
                    } else if (i2 == 1) {
                        this.f3062y.f3001v = 2;
                        return;
                    } else if (i2 == 3) {
                        this.f3062y.f3001v = 1;
                        return;
                    } else if (i2 != 15) {
                        return;
                    } else {
                        this.f3062y.f3001v = 3;
                        return;
                    }
                case 21680:
                    m5920s(i).f2993n = (int) j;
                    return;
                case 21682:
                    m5920s(i).f2995p = (int) j;
                    return;
                case 21690:
                    m5920s(i).f2994o = (int) j;
                    return;
                case 21930:
                    m5920s(i).f2974T = j == 1;
                    return;
                case 21998:
                    m5920s(i).f2985f = (int) j;
                    return;
                case 22186:
                    m5920s(i).f2971Q = j;
                    return;
                case 22203:
                    m5920s(i).f2972R = j;
                    return;
                case 25188:
                    m5920s(i).f2969O = (int) j;
                    return;
                case 30321:
                    m5918u(i);
                    int i3 = (int) j;
                    if (i3 == 0) {
                        this.f3062y.f2996q = 0;
                        return;
                    } else if (i3 == 1) {
                        this.f3062y.f2996q = 1;
                        return;
                    } else if (i3 == 2) {
                        this.f3062y.f2996q = 2;
                        return;
                    } else if (i3 != 3) {
                        return;
                    } else {
                        this.f3062y.f2996q = 3;
                        return;
                    }
                case 2352003:
                    m5920s(i).f2984e = (int) j;
                    return;
                case 2807729:
                    this.f3059v = j;
                    return;
                default:
                    switch (i) {
                        case 21945:
                            m5918u(i);
                            int i4 = (int) j;
                            if (i4 == 1) {
                                this.f3062y.f3005z = 2;
                                return;
                            } else if (i4 != 2) {
                                return;
                            } else {
                                this.f3062y.f3005z = 1;
                                return;
                            }
                        case 21946:
                            m5918u(i);
                            int m2294b = C2719g.m2294b((int) j);
                            if (m2294b != -1) {
                                this.f3062y.f3004y = m2294b;
                                return;
                            }
                            return;
                        case 21947:
                            m5918u(i);
                            abf abfVar = this.f3062y;
                            abfVar.f3002w = true;
                            int m2295a = C2719g.m2295a((int) j);
                            if (m2295a != -1) {
                                abfVar.f3003x = m2295a;
                                return;
                            }
                            return;
                        case 21948:
                            m5920s(i).f2955A = (int) j;
                            return;
                        case 21949:
                            m5920s(i).f2956B = (int) j;
                            return;
                        default:
                            return;
                    }
            }
        }
    }
}
