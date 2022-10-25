package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.re */
/* loaded from: classes2.dex */
public abstract class AbstractC3021re extends AbstractC2678em {

    /* renamed from: b */
    private static final byte[] f8687b = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.f9766SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.f9757CR, -50, 113, Ascii.CAN, -96, 0, 47, ByteSourceJsonBootstrapper.UTF8_BOM_3, Ascii.f9760FS, 49, -61, 39, 93, 120};

    /* renamed from: A */
    private MediaFormat f8688A;

    /* renamed from: B */
    private boolean f8689B;

    /* renamed from: C */
    private float f8690C;

    /* renamed from: D */
    private ArrayDeque f8691D;

    /* renamed from: E */
    private C3020rd f8692E;

    /* renamed from: F */
    private C3019rc f8693F;

    /* renamed from: G */
    private int f8694G;

    /* renamed from: H */
    private boolean f8695H;

    /* renamed from: I */
    private boolean f8696I;

    /* renamed from: J */
    private boolean f8697J;

    /* renamed from: K */
    private boolean f8698K;

    /* renamed from: L */
    private boolean f8699L;

    /* renamed from: M */
    private boolean f8700M;

    /* renamed from: N */
    private boolean f8701N;

    /* renamed from: O */
    private boolean f8702O;

    /* renamed from: P */
    private boolean f8703P;

    /* renamed from: Q */
    private boolean f8704Q;

    /* renamed from: R */
    private C3011qv f8705R;

    /* renamed from: S */
    private long f8706S;

    /* renamed from: T */
    private int f8707T;

    /* renamed from: U */
    private int f8708U;

    /* renamed from: V */
    private ByteBuffer f8709V;

    /* renamed from: W */
    private boolean f8710W;

    /* renamed from: X */
    private boolean f8711X;

    /* renamed from: Y */
    private boolean f8712Y;

    /* renamed from: Z */
    private boolean f8713Z;

    /* renamed from: a */
    protected C2679en f8714a;

    /* renamed from: aa */
    private boolean f8715aa;

    /* renamed from: ab */
    private boolean f8716ab;

    /* renamed from: ac */
    private int f8717ac;

    /* renamed from: ad */
    private int f8718ad;

    /* renamed from: ae */
    private int f8719ae;

    /* renamed from: af */
    private boolean f8720af;

    /* renamed from: ag */
    private boolean f8721ag;

    /* renamed from: ah */
    private boolean f8722ah;

    /* renamed from: ai */
    private long f8723ai;

    /* renamed from: aj */
    private long f8724aj;

    /* renamed from: ak */
    private boolean f8725ak;

    /* renamed from: al */
    private boolean f8726al;

    /* renamed from: am */
    private boolean f8727am;

    /* renamed from: an */
    private boolean f8728an;

    /* renamed from: ao */
    private C2685et f8729ao;

    /* renamed from: ap */
    private long f8730ap;

    /* renamed from: aq */
    private long f8731aq;

    /* renamed from: ar */
    private int f8732ar;

    /* renamed from: c */
    private final InterfaceC3015qz f8733c;

    /* renamed from: d */
    private final InterfaceC3023rg f8734d;

    /* renamed from: e */
    private final float f8735e;

    /* renamed from: f */
    private final C2669ed f8736f;

    /* renamed from: g */
    private final C2669ed f8737g;

    /* renamed from: h */
    private final C2669ed f8738h;

    /* renamed from: i */
    private final C3010qu f8739i;

    /* renamed from: j */
    private final C2625cn f8740j;

    /* renamed from: k */
    private final ArrayList f8741k;

    /* renamed from: l */
    private final MediaCodec.BufferInfo f8742l;

    /* renamed from: m */
    private final long[] f8743m;

    /* renamed from: n */
    private final long[] f8744n;

    /* renamed from: o */
    private final long[] f8745o;

    /* renamed from: p */
    private C2962p f8746p;

    /* renamed from: q */
    private C2962p f8747q;

    /* renamed from: r */
    private InterfaceC2910nb f8748r;

    /* renamed from: s */
    private InterfaceC2910nb f8749s;

    /* renamed from: t */
    private MediaCrypto f8750t;

    /* renamed from: u */
    private boolean f8751u;

    /* renamed from: v */
    private final long f8752v;

    /* renamed from: w */
    private float f8753w;

    /* renamed from: x */
    private float f8754x;

    /* renamed from: y */
    private InterfaceC3017ra f8755y;

    /* renamed from: z */
    private C2962p f8756z;

    public AbstractC3021re(int i, InterfaceC3015qz interfaceC3015qz, InterfaceC3023rg interfaceC3023rg, float f) {
        super(i);
        this.f8733c = interfaceC3015qz;
        C2616ce.m2689d(interfaceC3023rg);
        this.f8734d = interfaceC3023rg;
        this.f8735e = f;
        this.f8736f = new C2669ed(0);
        this.f8737g = new C2669ed(0);
        this.f8738h = new C2669ed(2);
        C3010qu c3010qu = new C3010qu();
        this.f8739i = c3010qu;
        this.f8740j = new C2625cn();
        this.f8741k = new ArrayList();
        this.f8742l = new MediaCodec.BufferInfo();
        this.f8753w = 1.0f;
        this.f8754x = 1.0f;
        this.f8752v = C3282C.TIME_UNSET;
        this.f8743m = new long[10];
        this.f8744n = new long[10];
        this.f8745o = new long[10];
        this.f8730ap = C3282C.TIME_UNSET;
        this.f8731aq = C3282C.TIME_UNSET;
        c3010qu.m2448l(0);
        c3010qu.f7092b.order(ByteOrder.nativeOrder());
        this.f8690C = -1.0f;
        this.f8694G = 0;
        this.f8717ac = 0;
        this.f8707T = -1;
        this.f8708U = -1;
        this.f8706S = C3282C.TIME_UNSET;
        this.f8723ai = C3282C.TIME_UNSET;
        this.f8724aj = C3282C.TIME_UNSET;
        this.f8718ad = 0;
        this.f8719ae = 0;
    }

    /* renamed from: S */
    private final void m1251S() {
        this.f8715aa = false;
        this.f8739i.mo1278b();
        this.f8738h.mo1278b();
        this.f8713Z = false;
        this.f8712Y = false;
    }

    /* renamed from: T */
    private final void m1250T() throws C2685et {
        if (!this.f8720af) {
            m1222az();
            return;
        }
        this.f8718ad = 1;
        this.f8719ae = 3;
    }

    /* renamed from: aA */
    private final void m1249aA() {
        this.f8707T = -1;
        this.f8737g.f7092b = null;
    }

    /* renamed from: aB */
    private final void m1248aB() {
        this.f8708U = -1;
        this.f8709V = null;
    }

    /* renamed from: aC */
    private final void m1247aC(InterfaceC2910nb interfaceC2910nb) {
        C2958ow.m1437b(this.f8748r, interfaceC2910nb);
        this.f8748r = interfaceC2910nb;
    }

    /* renamed from: aD */
    private final void m1246aD(InterfaceC2910nb interfaceC2910nb) {
        C2958ow.m1437b(this.f8749s, interfaceC2910nb);
        this.f8749s = interfaceC2910nb;
    }

    /* renamed from: aE */
    private final void m1245aE() throws C2685et {
        try {
            this.f8750t.setMediaDrmSession(m1238aL(this.f8749s).f8194c);
            m1247aC(this.f8749s);
            this.f8718ad = 0;
            this.f8719ae = 0;
        } catch (MediaCryptoException e) {
            throw m2427ba(e, this.f8746p, PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR);
        }
    }

    /* renamed from: aF */
    private final boolean m1244aF() throws C2685et {
        if (this.f8720af) {
            this.f8718ad = 1;
            if (this.f8696I || this.f8698K) {
                this.f8719ae = 3;
                return false;
            }
            this.f8719ae = 2;
        } else {
            m1245aE();
        }
        return true;
    }

    /* renamed from: aG */
    private final boolean m1243aG() throws C2685et {
        InterfaceC3017ra interfaceC3017ra = this.f8755y;
        if (interfaceC3017ra == null || this.f8718ad == 2 || this.f8725ak) {
            return false;
        }
        if (this.f8707T < 0) {
            int mo1203a = interfaceC3017ra.mo1203a();
            this.f8707T = mo1203a;
            if (mo1203a < 0) {
                return false;
            }
            this.f8737g.f7092b = this.f8755y.mo1200f(mo1203a);
            this.f8737g.mo1278b();
        }
        if (this.f8718ad == 1) {
            if (!this.f8704Q) {
                this.f8721ag = true;
                this.f8755y.mo1190q(this.f8707T, 0, 0L, 4);
                m1249aA();
            }
            this.f8718ad = 2;
            return false;
        } else if (this.f8702O) {
            this.f8702O = false;
            this.f8737g.f7092b.put(f8687b);
            this.f8755y.mo1190q(this.f8707T, 38, 0L, 0);
            m1249aA();
            this.f8720af = true;
            return true;
        } else {
            if (this.f8717ac == 1) {
                for (int i = 0; i < this.f8756z.f8374n.size(); i++) {
                    this.f8737g.f7092b.put((byte[]) this.f8756z.f8374n.get(i));
                }
                this.f8717ac = 2;
            }
            int position = this.f8737g.f7092b.position();
            C2717fy m2424i = m2424i();
            try {
                int m2428aZ = m2428aZ(m2424i, this.f8737g, 0);
                if (mo2182F()) {
                    this.f8724aj = this.f8723ai;
                }
                if (m2428aZ == -3) {
                    return false;
                }
                if (m2428aZ == -5) {
                    if (this.f8717ac == 2) {
                        this.f8737g.mo1278b();
                        this.f8717ac = 1;
                    }
                    mo663R(m2424i);
                    return true;
                }
                C2669ed c2669ed = this.f8737g;
                if (!c2669ed.m2462g()) {
                    if (this.f8720af || c2669ed.m2461h()) {
                        boolean m2446n = c2669ed.m2446n();
                        if (m2446n) {
                            c2669ed.f7091a.m2450b(position);
                        }
                        if (this.f8695H && !m2446n) {
                            ByteBuffer byteBuffer = this.f8737g.f7092b;
                            byte[] bArr = C3245zm.f9602a;
                            int position2 = byteBuffer.position();
                            int i2 = 0;
                            int i3 = 0;
                            while (true) {
                                int i4 = i2 + 1;
                                if (i4 < position2) {
                                    int i5 = byteBuffer.get(i2) & 255;
                                    if (i3 == 3) {
                                        if (i5 == 1) {
                                            if ((byteBuffer.get(i4) & Ascii.f9769US) == 7) {
                                                ByteBuffer duplicate = byteBuffer.duplicate();
                                                duplicate.position(i2 - 3);
                                                duplicate.limit(position2);
                                                byteBuffer.position(0);
                                                byteBuffer.put(duplicate);
                                                break;
                                            }
                                            i5 = 1;
                                        }
                                    } else if (i5 == 0) {
                                        i3++;
                                    }
                                    if (i5 != 0) {
                                        i3 = 0;
                                    }
                                    i2 = i4;
                                } else {
                                    byteBuffer.clear();
                                    break;
                                }
                            }
                            if (this.f8737g.f7092b.position() == 0) {
                                return true;
                            }
                            this.f8695H = false;
                        }
                        C2669ed c2669ed2 = this.f8737g;
                        long j = c2669ed2.f7094d;
                        C3011qv c3011qv = this.f8705R;
                        if (c3011qv != null) {
                            j = c3011qv.m1271b(this.f8746p, c2669ed2);
                            this.f8723ai = Math.max(this.f8723ai, this.f8705R.m1272a(this.f8746p));
                        }
                        long j2 = j;
                        if (this.f8737g.m2463f()) {
                            this.f8741k.add(Long.valueOf(j2));
                        }
                        if (this.f8727am) {
                            this.f8740j.m2594d(j2, this.f8746p);
                            this.f8727am = false;
                        }
                        this.f8723ai = Math.max(this.f8723ai, j2);
                        this.f8737g.m2447m();
                        C2669ed c2669ed3 = this.f8737g;
                        if (c2669ed3.m2464e()) {
                            mo634am(c2669ed3);
                        }
                        mo638ac(this.f8737g);
                        try {
                            if (m2446n) {
                                this.f8755y.mo1189r(this.f8707T, this.f8737g.f7091a, j2);
                            } else {
                                this.f8755y.mo1190q(this.f8707T, this.f8737g.f7092b.limit(), j2, 0);
                            }
                            m1249aA();
                            this.f8720af = true;
                            this.f8717ac = 0;
                            this.f8714a.f7129c++;
                            return true;
                        } catch (MediaCodec.CryptoException e) {
                            throw m2427ba(e, this.f8746p, C2628cq.m2526h(e.getErrorCode()));
                        }
                    } else {
                        c2669ed.mo1278b();
                        if (this.f8717ac == 2) {
                            this.f8717ac = 1;
                        }
                        return true;
                    }
                }
                if (this.f8717ac == 2) {
                    c2669ed.mo1278b();
                    this.f8717ac = 1;
                }
                this.f8725ak = true;
                if (!this.f8720af) {
                    m1223ay();
                    return false;
                }
                try {
                    if (!this.f8704Q) {
                        this.f8721ag = true;
                        this.f8755y.mo1190q(this.f8707T, 0, 0L, 4);
                        m1249aA();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw m2427ba(e2, this.f8746p, C2628cq.m2526h(e2.getErrorCode()));
                }
            } catch (C2668ec e3) {
                mo658W(e3);
                m1241aI(0);
                m1237aa();
                return true;
            }
        }
    }

    /* renamed from: aH */
    private final boolean m1242aH() {
        return this.f8708U >= 0;
    }

    /* renamed from: aI */
    private final boolean m1241aI(int i) throws C2685et {
        C2717fy m2424i = m2424i();
        this.f8736f.mo1278b();
        int m2428aZ = m2428aZ(m2424i, this.f8736f, i | 4);
        if (m2428aZ == -5) {
            mo663R(m2424i);
            return true;
        } else if (m2428aZ == -4 && this.f8736f.m2462g()) {
            this.f8725ak = true;
            m1223ay();
            return false;
        } else {
            return false;
        }
    }

    /* renamed from: aJ */
    private final boolean m1240aJ(long j) {
        return true;
    }

    /* renamed from: aK */
    private final boolean m1239aK(C2962p c2962p) throws C2685et {
        if (C2628cq.f6961a >= 23 && this.f8755y != null && this.f8719ae != 3 && mo2180aY() != 0) {
            float mo636ag = mo636ag(this.f8754x, m2429I());
            float f = this.f8690C;
            if (f == mo636ag) {
                return true;
            }
            if (mo636ag == -1.0f) {
                m1250T();
                return false;
            } else if (f == -1.0f && mo636ag <= this.f8735e) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", mo636ag);
                this.f8755y.mo1193m(bundle);
                this.f8690C = mo636ag;
            }
        }
        return true;
    }

    /* renamed from: aL */
    private static final C2931nw m1238aL(InterfaceC2910nb interfaceC2910nb) throws C2685et {
        return (C2931nw) interfaceC2910nb.mo1575b();
    }

    /* renamed from: aa */
    private final void m1237aa() {
        try {
            this.f8755y.mo1198h();
        } finally {
            mo632aq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aw */
    public static boolean m1225aw(C2962p c2962p) {
        int i = c2962p.f8359E;
        return i == 0 || i == 2;
    }

    /* renamed from: az */
    private final void m1222az() throws C2685et {
        m1229ap();
        m1230an();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: C */
    public void mo668C(float f, float f2) throws C2685et {
        this.f8753w = f;
        this.f8754x = f2;
        m1239aK(this.f8756z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: J */
    protected final void mo848J(long j, long j2) throws C2685et {
        if (this.f8731aq == C3282C.TIME_UNSET) {
            C2616ce.m2685h(this.f8730ap == C3282C.TIME_UNSET);
            this.f8730ap = j;
            this.f8731aq = j2;
            return;
        }
        int i = this.f8732ar;
        if (i == 10) {
            long j3 = this.f8744n[9];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j3);
            Log.w("MediaCodecRenderer", sb.toString());
        } else {
            this.f8732ar = i + 1;
        }
        long[] jArr = this.f8743m;
        int i2 = this.f8732ar - 1;
        jArr[i2] = j;
        this.f8744n[i2] = j2;
        this.f8745o[i2] = this.f8723ai;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:55|(5:(6:57|(1:139)(2:61|62)|(2:64|(2:66|(3:87|(1:89)|90)(1:72))(3:91|92|(1:99)(0)))(2:100|(1:102)(2:103|(9:109|(1:111)|112|(2:118|(1:120))|121|(1:(2:123|(2:126|127)(1:125))(2:133|134))|128|(1:130)(1:132)|131)(2:107|108)))|73|74|(2:77|78)(1:76))|(3:142|143|(6:145|146|147|148|149|(3:151|152|(2:155|156)(3:154|74|(0)(0)))(2:158|159)))|185|186|(0)(0))|140|182|183|184) */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x033e, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x031f A[LOOP:0: B:82:0x015a->B:182:0x031f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x032f A[Catch: IllegalStateException -> 0x0360, TryCatch #7 {IllegalStateException -> 0x0360, blocks: (B:179:0x0318, B:184:0x0329, B:186:0x032f, B:188:0x0335, B:175:0x0300, B:177:0x0312, B:195:0x0346), top: B:245:0x014f }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x031e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0326 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r14v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v9 */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo847L(long r24, long r26) throws com.google.ads.interactivemedia.p034v3.internal.C2685et {
        /*
            Method dump skipped, instructions count: 953
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re.mo847L(long, long):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: M */
    public boolean mo846M() {
        return this.f8726al;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: N */
    public boolean mo666N() {
        if (this.f8746p != null) {
            if (m2430H() || m1242aH()) {
                return true;
            }
            if (this.f8706S != C3282C.TIME_UNSET && SystemClock.elapsedRealtime() < this.f8706S) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2738gs
    /* renamed from: O */
    public final int mo845O(C2962p c2962p) throws C2685et {
        try {
            return mo665P(this.f8734d, c2962p);
        } catch (C3028rl e) {
            throw m2427ba(e, c2962p, PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED);
        }
    }

    /* renamed from: P */
    protected abstract int mo665P(InterfaceC3023rg interfaceC3023rg, C2962p c2962p) throws C3028rl;

    /* renamed from: Q */
    protected C2680eo mo664Q(C3019rc c3019rc, C2962p c2962p, C2962p c2962p2) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
        if (r2 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
        if (m1244aF() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cb, code lost:
        if (m1244aF() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00df, code lost:
        if (m1244aF() == false) goto L48;
     */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.ads.interactivemedia.p034v3.internal.C2680eo mo663R(com.google.ads.interactivemedia.p034v3.internal.C2717fy r13) throws com.google.ads.interactivemedia.p034v3.internal.C2685et {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re.mo663R(com.google.ads.interactivemedia.v3.internal.fy):com.google.ads.interactivemedia.v3.internal.eo");
    }

    /* renamed from: U */
    protected abstract C3014qy mo660U(C3019rc c3019rc, C2962p c2962p, MediaCrypto mediaCrypto, float f);

    /* renamed from: V */
    protected abstract List mo659V(InterfaceC3023rg interfaceC3023rg, C2962p c2962p, boolean z) throws C3028rl;

    /* renamed from: W */
    protected void mo658W(Exception exc) {
        throw null;
    }

    /* renamed from: X */
    protected void mo657X(String str, long j, long j2) {
        throw null;
    }

    /* renamed from: Y */
    protected void mo656Y(String str) {
        throw null;
    }

    /* renamed from: Z */
    protected void mo655Z(C2962p c2962p, MediaFormat mediaFormat) throws C2685et {
        throw null;
    }

    /* renamed from: ab */
    protected void mo639ab() {
    }

    /* renamed from: ac */
    protected void mo638ac(C2669ed c2669ed) throws C2685et {
        throw null;
    }

    /* renamed from: ad */
    protected void mo1236ad() throws C2685et {
    }

    /* renamed from: ae */
    protected abstract boolean mo637ae(long j, long j2, InterfaceC3017ra interfaceC3017ra, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, C2962p c2962p) throws C2685et;

    /* renamed from: af */
    protected boolean mo1235af(C2962p c2962p) {
        return false;
    }

    /* renamed from: ag */
    protected float mo636ag(float f, C2962p[] c2962pArr) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ah */
    public final float m1234ah() {
        return this.f8753w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ai */
    public final long m1233ai() {
        return this.f8731aq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aj */
    public final InterfaceC3017ra m1232aj() {
        return this.f8755y;
    }

    /* renamed from: ak */
    protected C3018rb mo635ak(Throwable th, C3019rc c3019rc) {
        return new C3018rb(th, c3019rc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: al */
    public final C3019rc m1231al() {
        return this.f8693F;
    }

    /* renamed from: am */
    protected void mo634am(C2669ed c2669ed) throws C2685et {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:171:0x031d A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0358 A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0369 A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03c2 A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03da A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03eb A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0439 A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0446 A[Catch: Exception -> 0x0466, TryCatch #4 {Exception -> 0x0466, blocks: (B:94:0x01a6, B:96:0x01c0, B:98:0x01ca, B:106:0x021f, B:109:0x0236, B:111:0x023c, B:113:0x0246, B:115:0x0250, B:117:0x025a, B:136:0x02a7, B:138:0x02b1, B:140:0x02b9, B:144:0x02c4, B:146:0x02ce, B:148:0x02d2, B:150:0x02da, B:152:0x02e2, B:154:0x02e6, B:156:0x02f0, B:158:0x02f8, B:163:0x0302, B:165:0x030a, B:169:0x0315, B:171:0x031d, B:187:0x0352, B:189:0x0358, B:193:0x0363, B:195:0x0369, B:197:0x0371, B:199:0x037b, B:201:0x0385, B:203:0x038f, B:205:0x0399, B:207:0x03a3, B:209:0x03ad, B:213:0x03ba, B:215:0x03c2, B:217:0x03c7, B:221:0x03d2, B:223:0x03da, B:248:0x0428, B:250:0x0439, B:251:0x0440, B:253:0x0446, B:254:0x044f, B:227:0x03e5, B:229:0x03eb, B:231:0x03f3, B:233:0x03f7, B:235:0x03ff, B:237:0x0407, B:239:0x0411, B:241:0x041b, B:244:0x0420, B:175:0x0328, B:177:0x032c, B:179:0x0336, B:181:0x0340, B:183:0x0348, B:120:0x0266, B:122:0x026c, B:124:0x0274, B:126:0x027c, B:128:0x0286, B:130:0x0290, B:132:0x029a, B:97:0x01c5, B:100:0x01d7, B:102:0x01ea, B:104:0x01f4, B:105:0x01fe, B:103:0x01ef), top: B:292:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0470 A[Catch: Exception -> 0x0474, TryCatch #5 {Exception -> 0x0474, blocks: (B:78:0x015e, B:82:0x0175, B:86:0x017d, B:89:0x018d, B:91:0x0197, B:256:0x0455, B:268:0x0470, B:269:0x0473, B:90:0x0192, B:81:0x016b), top: B:294:0x015e }] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.ads.interactivemedia.v3.internal.em, com.google.ads.interactivemedia.v3.internal.re] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.ArrayDeque] */
    /* renamed from: an */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1230an() throws com.google.ads.interactivemedia.p034v3.internal.C2685et {
        /*
            Method dump skipped, instructions count: 1235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re.m1230an():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ao */
    public void mo633ao(long j) {
        while (true) {
            int i = this.f8732ar;
            if (i == 0 || j < this.f8745o[0]) {
                return;
            }
            long[] jArr = this.f8743m;
            this.f8730ap = jArr[0];
            this.f8731aq = this.f8744n[0];
            int i2 = i - 1;
            this.f8732ar = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.f8744n;
            System.arraycopy(jArr2, 1, jArr2, 0, this.f8732ar);
            long[] jArr3 = this.f8745o;
            System.arraycopy(jArr3, 1, jArr3, 0, this.f8732ar);
            mo639ab();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.media.MediaCrypto, com.google.ads.interactivemedia.v3.internal.nb] */
    /* renamed from: ap */
    public final void m1229ap() {
        try {
            InterfaceC3017ra interfaceC3017ra = this.f8755y;
            if (interfaceC3017ra != null) {
                interfaceC3017ra.mo1197i();
                this.f8714a.f7128b++;
                mo656Y(this.f8693F.f8676a);
            }
            this.f8755y = null;
            try {
                MediaCrypto mediaCrypto = this.f8750t;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.f8755y = null;
            try {
                MediaCrypto mediaCrypto2 = this.f8750t;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aq */
    public void mo632aq() {
        m1249aA();
        m1248aB();
        this.f8706S = C3282C.TIME_UNSET;
        this.f8721ag = false;
        this.f8720af = false;
        this.f8702O = false;
        this.f8703P = false;
        this.f8710W = false;
        this.f8711X = false;
        this.f8741k.clear();
        this.f8723ai = C3282C.TIME_UNSET;
        this.f8724aj = C3282C.TIME_UNSET;
        C3011qv c3011qv = this.f8705R;
        if (c3011qv != null) {
            c3011qv.m1270c();
        }
        this.f8718ad = 0;
        this.f8719ae = 0;
        this.f8717ac = this.f8716ab ? 1 : 0;
    }

    /* renamed from: ar */
    protected final void m1228ar() {
        mo632aq();
        this.f8729ao = null;
        this.f8705R = null;
        this.f8691D = null;
        this.f8693F = null;
        this.f8756z = null;
        this.f8688A = null;
        this.f8689B = false;
        this.f8722ah = false;
        this.f8690C = -1.0f;
        this.f8694G = 0;
        this.f8695H = false;
        this.f8696I = false;
        this.f8697J = false;
        this.f8698K = false;
        this.f8699L = false;
        this.f8700M = false;
        this.f8701N = false;
        this.f8704Q = false;
        this.f8716ab = false;
        this.f8717ac = 0;
        this.f8751u = false;
    }

    /* renamed from: as */
    protected final void m1227as(long j) throws C2685et {
        C2962p c2962p = (C2962p) this.f8740j.m2595c(j);
        if (c2962p == null && this.f8689B) {
            c2962p = (C2962p) this.f8740j.m2596b();
        }
        if (c2962p != null) {
            this.f8747q = c2962p;
        } else if (!this.f8689B || this.f8747q == null) {
            return;
        }
        mo655Z(this.f8747q, this.f8688A);
        this.f8689B = false;
    }

    /* renamed from: au */
    protected boolean mo631au() {
        return false;
    }

    /* renamed from: av */
    protected boolean mo630av(C3019rc c3019rc) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ax */
    public final void m1224ax() throws C2685et {
        if (m1226at()) {
            m1230an();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2738gs
    /* renamed from: e */
    public final int mo1221e() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: r */
    public void mo626r() {
        this.f8746p = null;
        this.f8730ap = C3282C.TIME_UNSET;
        this.f8731aq = C3282C.TIME_UNSET;
        this.f8732ar = 0;
        m1226at();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: s */
    public void mo625s(boolean z, boolean z2) throws C2685et {
        this.f8714a = new C2679en();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: t */
    public void mo624t(long j, boolean z) throws C2685et {
        this.f8725ak = false;
        this.f8726al = false;
        this.f8728an = false;
        if (this.f8712Y) {
            this.f8739i.mo1278b();
            this.f8738h.mo1278b();
            this.f8713Z = false;
        } else {
            m1224ax();
        }
        C2625cn c2625cn = this.f8740j;
        if (c2625cn.m2597a() > 0) {
            this.f8727am = true;
        }
        c2625cn.m2593e();
        int i = this.f8732ar;
        if (i != 0) {
            int i2 = i - 1;
            this.f8731aq = this.f8744n[i2];
            this.f8730ap = this.f8743m[i2];
            this.f8732ar = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: u */
    public void mo623u() {
        try {
            m1251S();
            m1229ap();
        } finally {
            m1246aD(null);
        }
    }

    /* renamed from: at */
    protected final boolean m1226at() {
        if (this.f8755y == null) {
            return false;
        }
        if (this.f8719ae != 3 && !this.f8696I && ((!this.f8697J || this.f8722ah) && (!this.f8698K || !this.f8721ag))) {
            m1237aa();
            return false;
        }
        m1229ap();
        return true;
    }

    /* renamed from: ay */
    private final void m1223ay() throws C2685et {
        int i = this.f8719ae;
        if (i == 1) {
            m1237aa();
        } else if (i == 2) {
            m1237aa();
            m1245aE();
        } else if (i == 3) {
            m1222az();
        } else {
            this.f8726al = true;
            mo1236ad();
        }
    }
}
