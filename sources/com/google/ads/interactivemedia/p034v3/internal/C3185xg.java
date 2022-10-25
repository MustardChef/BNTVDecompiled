package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.Scopes;
import com.google.firebase.messaging.Constants;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xg */
/* loaded from: classes2.dex */
public final class C3185xg extends AbstractC3021re {

    /* renamed from: c */
    private static final int[] f9373c = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: d */
    private static boolean f9374d;

    /* renamed from: e */
    private static boolean f9375e;

    /* renamed from: A */
    private long f9376A;

    /* renamed from: B */
    private int f9377B;

    /* renamed from: C */
    private int f9378C;

    /* renamed from: D */
    private int f9379D;

    /* renamed from: E */
    private int f9380E;

    /* renamed from: F */
    private float f9381F;

    /* renamed from: G */
    private C2597bm f9382G;

    /* renamed from: H */
    private int f9383H;

    /* renamed from: I */
    private InterfaceC3186xh f9384I;

    /* renamed from: J */
    private C3211yf f9385J;

    /* renamed from: b */
    C3184xf f9386b;

    /* renamed from: f */
    private final Context f9387f;

    /* renamed from: g */
    private final C3193xo f9388g;

    /* renamed from: h */
    private final C3202xx f9389h;

    /* renamed from: i */
    private final boolean f9390i;

    /* renamed from: j */
    private boolean f9391j;

    /* renamed from: k */
    private boolean f9392k;

    /* renamed from: l */
    private Surface f9393l;

    /* renamed from: m */
    private C3180xb f9394m;

    /* renamed from: n */
    private boolean f9395n;

    /* renamed from: o */
    private int f9396o;

    /* renamed from: p */
    private boolean f9397p;

    /* renamed from: q */
    private boolean f9398q;

    /* renamed from: r */
    private boolean f9399r;

    /* renamed from: s */
    private long f9400s;

    /* renamed from: t */
    private long f9401t;

    /* renamed from: u */
    private long f9402u;

    /* renamed from: v */
    private int f9403v;

    /* renamed from: w */
    private int f9404w;

    /* renamed from: x */
    private int f9405x;

    /* renamed from: y */
    private long f9406y;

    /* renamed from: z */
    private long f9407z;

    public C3185xg(Context context, InterfaceC3015qz interfaceC3015qz, InterfaceC3023rg interfaceC3023rg, Handler handler, InterfaceC3203xy interfaceC3203xy) {
        super(2, interfaceC3015qz, interfaceC3023rg, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.f9387f = applicationContext;
        this.f9388g = new C3193xo(applicationContext);
        this.f9389h = new C3202xx(handler, interfaceC3203xy);
        this.f9390i = "NVIDIA".equals(C2628cq.f6963c);
        this.f9401t = C3282C.TIME_UNSET;
        this.f9378C = -1;
        this.f9379D = -1;
        this.f9381F = -1.0f;
        this.f9396o = 1;
        this.f9383H = 0;
        m648aG();
    }

    /* renamed from: S */
    protected static int m662S(C3019rc c3019rc, C2962p c2962p) {
        if (c2962p.f8373m != -1) {
            int size = c2962p.f8374n.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += ((byte[]) c2962p.f8374n.get(i2)).length;
            }
            return c2962p.f8373m + i;
        }
        return m651aD(c3019rc, c2962p);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: aD */
    private static int m651aD(C3019rc c3019rc, C2962p c2962p) {
        char c;
        int i;
        int intValue;
        int i2 = c2962p.f8377q;
        int i3 = c2962p.f8378r;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        String str = c2962p.f8372l;
        int i4 = 2;
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
            Pair m1211b = C3033rq.m1211b(c2962p);
            str = (m1211b == null || !((intValue = ((Integer) m1211b.first).intValue()) == 512 || intValue == 1 || intValue == 2)) ? MimeTypes.VIDEO_H265 : MimeTypes.VIDEO_H264;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0 && c != 1) {
            if (c != 2) {
                if (c != 3) {
                    if (c != 4 && c != 5) {
                        return -1;
                    }
                    i = i2 * i3;
                    i4 = 4;
                }
            } else if ("BRAVIA 4K 2015".equals(C2628cq.f6964d) || ("Amazon".equals(C2628cq.f6963c) && ("KFSOWI".equals(C2628cq.f6964d) || ("AFTS".equals(C2628cq.f6964d) && c3019rc.f8681f)))) {
                return -1;
            } else {
                i = C2628cq.m2532b(i2, 16) * C2628cq.m2532b(i3, 16) * 256;
            }
            return (i * 3) / (i4 + i4);
        }
        i = i2 * i3;
        return (i * 3) / (i4 + i4);
    }

    /* renamed from: aE */
    private static List m650aE(InterfaceC3023rg interfaceC3023rg, C2962p c2962p, boolean z, boolean z2) throws C3028rl {
        Pair m1211b;
        String str = c2962p.f8372l;
        if (str == null) {
            return Collections.emptyList();
        }
        List m1208e = C3033rq.m1208e(interfaceC3023rg.mo1220a(str, z, z2), c2962p);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str) && (m1211b = C3033rq.m1211b(c2962p)) != null) {
            int intValue = ((Integer) m1211b.first).intValue();
            if (intValue == 16 || intValue == 256) {
                m1208e.addAll(interfaceC3023rg.mo1220a(MimeTypes.VIDEO_H265, z, z2));
            } else if (intValue == 512) {
                m1208e.addAll(interfaceC3023rg.mo1220a(MimeTypes.VIDEO_H264, z, z2));
            }
        }
        return Collections.unmodifiableList(m1208e);
    }

    /* renamed from: aF */
    private final void m649aF() {
        this.f9397p = false;
        int i = C2628cq.f6961a;
    }

    /* renamed from: aG */
    private final void m648aG() {
        this.f9382G = null;
    }

    /* renamed from: aH */
    private final void m647aH() {
        if (this.f9403v > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f9389h.m591d(this.f9403v, elapsedRealtime - this.f9402u);
            this.f9403v = 0;
            this.f9402u = elapsedRealtime;
        }
    }

    /* renamed from: aI */
    private final void m646aI() {
        int i = this.f9378C;
        if (i == -1 && this.f9379D == -1) {
            return;
        }
        C2597bm c2597bm = this.f9382G;
        if (c2597bm != null && c2597bm.f6057b == i && c2597bm.f6058c == this.f9379D && c2597bm.f6059d == this.f9380E && c2597bm.f6060e == this.f9381F) {
            return;
        }
        C2597bm c2597bm2 = new C2597bm(i, this.f9379D, this.f9380E, this.f9381F);
        this.f9382G = c2597bm2;
        this.f9389h.m575t(c2597bm2);
    }

    /* renamed from: aJ */
    private final void m645aJ() {
        C2597bm c2597bm = this.f9382G;
        if (c2597bm != null) {
            this.f9389h.m575t(c2597bm);
        }
    }

    /* renamed from: aK */
    private final void m644aK() {
        Surface surface = this.f9393l;
        C3180xb c3180xb = this.f9394m;
        if (surface == c3180xb) {
            this.f9393l = null;
        }
        c3180xb.release();
        this.f9394m = null;
    }

    /* renamed from: aL */
    private final void m643aL() {
        this.f9401t = SystemClock.elapsedRealtime() + 5000;
    }

    /* renamed from: aM */
    private static boolean m642aM(long j) {
        return j < -30000;
    }

    /* renamed from: aN */
    private final boolean m641aN(C3019rc c3019rc) {
        return C2628cq.f6961a >= 23 && !m628az(c3019rc.f8676a) && (!c3019rc.f8681f || C3180xb.m683b(this.f9387f));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0355, code lost:
        if (r1.equals("602LV") != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x0751, code lost:
        if (r7 != 2) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073 A[FALL_THROUGH] */
    /* renamed from: az */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static final boolean m628az(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 2780
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3185xg.m628az(java.lang.String):boolean");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: C */
    public final void mo668C(float f, float f2) throws C2685et {
        super.mo668C(f, f2);
        this.f9388g.m604g(f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2738gs
    /* renamed from: K */
    public final String mo667K() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: N */
    public final boolean mo666N() {
        C3180xb c3180xb;
        if (!super.mo666N() || (!this.f9397p && (((c3180xb = this.f9394m) == null || this.f9393l != c3180xb) && m1232aj() != null))) {
            if (this.f9401t == C3282C.TIME_UNSET) {
                return false;
            }
            if (SystemClock.elapsedRealtime() < this.f9401t) {
                return true;
            }
            this.f9401t = C3282C.TIME_UNSET;
            return false;
        }
        this.f9401t = C3282C.TIME_UNSET;
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: P */
    protected final int mo665P(InterfaceC3023rg interfaceC3023rg, C2962p c2962p) throws C3028rl {
        int i = 0;
        if (C2554an.m4960q(c2962p.f8372l)) {
            boolean z = c2962p.f8375o != null;
            List m650aE = m650aE(interfaceC3023rg, c2962p, z, false);
            if (z && m650aE.isEmpty()) {
                m650aE = m650aE(interfaceC3023rg, c2962p, false, false);
            }
            if (m650aE.isEmpty()) {
                return C2742gw.m2167a(1);
            }
            if (m1225aw(c2962p)) {
                C3019rc c3019rc = (C3019rc) m650aE.get(0);
                boolean m1260c = c3019rc.m1260c(c2962p);
                int i2 = true != c3019rc.m1259d(c2962p) ? 8 : 16;
                if (m1260c) {
                    List m650aE2 = m650aE(interfaceC3023rg, c2962p, z, true);
                    if (!m650aE2.isEmpty()) {
                        C3019rc c3019rc2 = (C3019rc) m650aE2.get(0);
                        if (c3019rc2.m1260c(c2962p) && c3019rc2.m1259d(c2962p)) {
                            i = 32;
                        }
                    }
                }
                return (true != m1260c ? 3 : 4) | i2 | i;
            }
            return C2742gw.m2167a(2);
        }
        return C2742gw.m2167a(0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: Q */
    protected final C2680eo mo664Q(C3019rc c3019rc, C2962p c2962p, C2962p c2962p2) {
        int i;
        int i2;
        C2680eo m1261b = c3019rc.m1261b(c2962p, c2962p2);
        int i3 = m1261b.f7142e;
        int i4 = c2962p2.f8377q;
        C3211yf c3211yf = this.f9385J;
        if (i4 > c3211yf.f9483a || c2962p2.f8378r > c3211yf.f9484b) {
            i3 |= 256;
        }
        if (m662S(c3019rc, c2962p2) > this.f9385J.f9485c) {
            i3 |= 64;
        }
        String str = c3019rc.f8676a;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = m1261b.f7141d;
            i2 = 0;
        }
        return new C2680eo(str, c2962p, c2962p2, i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: R */
    protected final C2680eo mo663R(C2717fy c2717fy) throws C2685et {
        C2680eo mo663R = super.mo663R(c2717fy);
        this.f9389h.m589f(c2717fy.f7335b, mo663R);
        return mo663R;
    }

    /* renamed from: T */
    final void m661T() {
        this.f9399r = true;
        if (this.f9397p) {
            return;
        }
        this.f9397p = true;
        this.f9389h.m578q(this.f9393l);
        this.f9395n = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: U */
    protected final C3014qy mo660U(C3019rc c3019rc, C2962p c2962p, MediaCrypto mediaCrypto, float f) {
        String str;
        C3211yf c3211yf;
        String str2;
        String str3;
        Point point;
        Pair m1211b;
        int m651aD;
        C3180xb c3180xb = this.f9394m;
        if (c3180xb != null && c3180xb.f9357a != c3019rc.f8681f) {
            m644aK();
        }
        String str4 = c3019rc.f8678c;
        C2962p[] m2429I = m2429I();
        int i = c2962p.f8377q;
        int i2 = c2962p.f8378r;
        int m662S = m662S(c3019rc, c2962p);
        int length = m2429I.length;
        if (length == 1) {
            if (m662S != -1 && (m651aD = m651aD(c3019rc, c2962p)) != -1) {
                m662S = Math.min((int) (m662S * 1.5f), m651aD);
            }
            c3211yf = new C3211yf(i, i2, m662S, null);
            str = str4;
        } else {
            boolean z = false;
            for (int i3 = 0; i3 < length; i3++) {
                C2962p c2962p2 = m2429I[i3];
                if (c2962p.f8384x != null && c2962p2.f8384x == null) {
                    C2935o m1426b = c2962p2.m1426b();
                    m1426b.m1554J(c2962p.f8384x);
                    c2962p2 = m1426b.m1506v();
                }
                if (c3019rc.m1261b(c2962p, c2962p2).f7141d != 0) {
                    int i4 = c2962p2.f8377q;
                    z |= i4 == -1 || c2962p2.f8378r == -1;
                    i = Math.max(i, i4);
                    i2 = Math.max(i2, c2962p2.f8378r);
                    m662S = Math.max(m662S, m662S(c3019rc, c2962p2));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i);
                String str5 = "x";
                sb.append("x");
                sb.append(i2);
                String str6 = "MediaCodecVideoRenderer";
                Log.w("MediaCodecVideoRenderer", sb.toString());
                int i5 = c2962p.f8378r;
                int i6 = c2962p.f8377q;
                int i7 = i5 > i6 ? i5 : i6;
                int i8 = i5 <= i6 ? i5 : i6;
                float f2 = i8 / i7;
                int[] iArr = f9373c;
                str = str4;
                int i9 = 0;
                while (i9 < 9) {
                    int i10 = iArr[i9];
                    int[] iArr2 = iArr;
                    int i11 = (int) (i10 * f2);
                    if (i10 <= i7 || i11 <= i8) {
                        break;
                    }
                    int i12 = i7;
                    int i13 = i8;
                    if (C2628cq.f6961a >= 21) {
                        int i14 = i5 <= i6 ? i10 : i11;
                        if (i5 <= i6) {
                            i10 = i11;
                        }
                        point = c3019rc.m1262a(i14, i10);
                        str2 = str5;
                        str3 = str6;
                        if (c3019rc.m1258e(point.x, point.y, c2962p.f8379s)) {
                            break;
                        }
                        i9++;
                        iArr = iArr2;
                        i7 = i12;
                        i8 = i13;
                        str5 = str2;
                        str6 = str3;
                    } else {
                        str2 = str5;
                        str3 = str6;
                        try {
                            int m2532b = C2628cq.m2532b(i10, 16) * 16;
                            int m2532b2 = C2628cq.m2532b(i11, 16) * 16;
                            if (m2532b * m2532b2 <= C3033rq.m1212a()) {
                                int i15 = i5 <= i6 ? m2532b : m2532b2;
                                if (i5 <= i6) {
                                    m2532b = m2532b2;
                                }
                                point = new Point(i15, m2532b);
                            } else {
                                i9++;
                                iArr = iArr2;
                                i7 = i12;
                                i8 = i13;
                                str5 = str2;
                                str6 = str3;
                            }
                        } catch (C3028rl unused) {
                        }
                    }
                }
                str2 = str5;
                str3 = str6;
                point = null;
                if (point != null) {
                    i = Math.max(i, point.x);
                    i2 = Math.max(i2, point.y);
                    C2935o m1426b2 = c2962p.m1426b();
                    m1426b2.m1527aj(i);
                    m1426b2.m1547Q(i2);
                    m662S = Math.max(m662S, m651aD(c3019rc, m1426b2.m1506v()));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i);
                    sb2.append(str2);
                    sb2.append(i2);
                    Log.w(str3, sb2.toString());
                }
            } else {
                str = str4;
            }
            c3211yf = new C3211yf(i, i2, m662S, null);
        }
        this.f9385J = c3211yf;
        boolean z2 = this.f9390i;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, c2962p.f8377q);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, c2962p.f8378r);
        C2616ce.m2690c(mediaFormat, c2962p.f8374n);
        float f3 = c2962p.f8379s;
        if (f3 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f3);
        }
        C2616ce.m2691b(mediaFormat, "rotation-degrees", c2962p.f8380t);
        C2719g c2719g = c2962p.f8384x;
        if (c2719g != null) {
            C2616ce.m2691b(mediaFormat, "color-transfer", c2719g.f7338c);
            C2616ce.m2691b(mediaFormat, "color-standard", c2719g.f7336a);
            C2616ce.m2691b(mediaFormat, "color-range", c2719g.f7337b);
            byte[] bArr = c2719g.f7339d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(c2962p.f8372l) && (m1211b = C3033rq.m1211b(c2962p)) != null) {
            C2616ce.m2691b(mediaFormat, Scopes.PROFILE, ((Integer) m1211b.first).intValue());
        }
        mediaFormat.setInteger("max-width", c3211yf.f9483a);
        mediaFormat.setInteger("max-height", c3211yf.f9484b);
        C2616ce.m2691b(mediaFormat, "max-input-size", c3211yf.f9485c);
        if (C2628cq.f6961a >= 23) {
            mediaFormat.setInteger(Constants.FirelogAnalytics.PARAM_PRIORITY, 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z2) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (this.f9393l == null) {
            if (m641aN(c3019rc)) {
                if (this.f9394m == null) {
                    this.f9394m = C3180xb.m684a(this.f9387f, c3019rc.f8681f);
                }
                this.f9393l = this.f9394m;
            } else {
                throw new IllegalStateException();
            }
        }
        return C3014qy.m1263b(c3019rc, mediaFormat, c2962p, this.f9393l, mediaCrypto);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: V */
    protected final List mo659V(InterfaceC3023rg interfaceC3023rg, C2962p c2962p, boolean z) throws C3028rl {
        return m650aE(interfaceC3023rg, c2962p, z, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: W */
    protected final void mo658W(Exception exc) {
        C2613cb.m2698a("MediaCodecVideoRenderer", "Video codec error", exc);
        this.f9389h.m576s(exc);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: X */
    protected final void mo657X(String str, long j, long j2) {
        this.f9389h.m594a(str, j, j2);
        this.f9391j = m628az(str);
        C3019rc m1231al = m1231al();
        C2616ce.m2689d(m1231al);
        boolean z = false;
        if (C2628cq.f6961a >= 29 && MimeTypes.VIDEO_VP9.equals(m1231al.f8677b)) {
            MediaCodecInfo.CodecProfileLevel[] m1257f = m1231al.m1257f();
            int length = m1257f.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (m1257f[i].profile == 16384) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        this.f9392k = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: Y */
    protected final void mo656Y(String str) {
        this.f9389h.m593b(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: Z */
    protected final void mo655Z(C2962p c2962p, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        InterfaceC3017ra m1232aj = m1232aj();
        if (m1232aj != null) {
            m1232aj.mo1192n(this.f9396o);
        }
        C2616ce.m2689d(mediaFormat);
        boolean z = false;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z = true;
        }
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        }
        this.f9378C = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        }
        this.f9379D = integer2;
        this.f9381F = c2962p.f8381u;
        if (C2628cq.f6961a >= 21) {
            int i = c2962p.f8380t;
            if (i == 90 || i == 270) {
                int i2 = this.f9378C;
                this.f9378C = this.f9379D;
                this.f9379D = i2;
                this.f9381F = 1.0f / this.f9381F;
            }
        } else {
            this.f9380E = c2962p.f8380t;
        }
        this.f9388g.m606e(c2962p.f8379s);
    }

    /* renamed from: aA */
    protected final void m654aA(InterfaceC3017ra interfaceC3017ra, int i) {
        m646aI();
        C2616ce.m2672u("releaseOutputBuffer");
        interfaceC3017ra.mo1195k(i, true);
        C2616ce.m2671v();
        this.f9407z = SystemClock.elapsedRealtime() * 1000;
        this.f8714a.f7131e++;
        this.f9404w = 0;
        m661T();
    }

    /* renamed from: aB */
    protected final void m653aB(InterfaceC3017ra interfaceC3017ra, int i, long j) {
        m646aI();
        C2616ce.m2672u("releaseOutputBuffer");
        interfaceC3017ra.mo1196j(i, j);
        C2616ce.m2671v();
        this.f9407z = SystemClock.elapsedRealtime() * 1000;
        this.f8714a.f7131e++;
        this.f9404w = 0;
        m661T();
    }

    /* renamed from: aC */
    protected final void m652aC(InterfaceC3017ra interfaceC3017ra, int i) {
        C2616ce.m2672u("skipVideoBuffer");
        interfaceC3017ra.mo1195k(i, false);
        C2616ce.m2671v();
        this.f8714a.f7132f++;
    }

    /* renamed from: aa */
    protected final void m640aa(int i) {
        C2679en c2679en = this.f8714a;
        c2679en.f7133g += i;
        this.f9403v += i;
        int i2 = this.f9404w + i;
        this.f9404w = i2;
        c2679en.f7134h = Math.max(i2, c2679en.f7134h);
        if (this.f9403v >= 50) {
            m647aH();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ab */
    protected final void mo639ab() {
        m649aF();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ac */
    protected final void mo638ac(C2669ed c2669ed) throws C2685et {
        this.f9405x++;
        int i = C2628cq.f6961a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x009d, code lost:
        if (r14 > 100000) goto L86;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ae */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean mo637ae(long r22, long r24, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra r26, java.nio.ByteBuffer r27, int r28, int r29, int r30, long r31, boolean r33, boolean r34, com.google.ads.interactivemedia.p034v3.internal.C2962p r35) throws com.google.ads.interactivemedia.p034v3.internal.C2685et {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3185xg.mo637ae(long, long, com.google.ads.interactivemedia.v3.internal.ra, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, com.google.ads.interactivemedia.v3.internal.p):boolean");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ag */
    protected final float mo636ag(float f, C2962p[] c2962pArr) {
        float f2 = -1.0f;
        for (C2962p c2962p : c2962pArr) {
            float f3 = c2962p.f8379s;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ak */
    protected final C3018rb mo635ak(Throwable th, C3019rc c3019rc) {
        return new C3183xe(th, c3019rc, this.f9393l);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: am */
    protected final void mo634am(C2669ed c2669ed) throws C2685et {
        if (this.f9392k) {
            ByteBuffer byteBuffer = c2669ed.f7095e;
            C2616ce.m2689d(byteBuffer);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    InterfaceC3017ra m1232aj = m1232aj();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    m1232aj.mo1193m(bundle);
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ao */
    protected final void mo633ao(long j) {
        super.mo633ao(j);
        this.f9405x--;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: aq */
    protected final void mo632aq() {
        super.mo632aq();
        this.f9405x = 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: au */
    protected final boolean mo631au() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: av */
    protected final boolean mo630av(C3019rc c3019rc) {
        return this.f9393l != null || m641aN(c3019rc);
    }

    /* renamed from: ay */
    protected final void m629ay(long j) {
        C2679en c2679en = this.f8714a;
        c2679en.f7136j += j;
        c2679en.f7137k++;
        this.f9376A += j;
        this.f9377B++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: r */
    protected final void mo626r() {
        m648aG();
        m649aF();
        this.f9395n = false;
        this.f9388g.m608c();
        this.f9386b = null;
        try {
            super.mo626r();
        } finally {
            this.f9389h.m592c(this.f8714a);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: s */
    protected final void mo625s(boolean z, boolean z2) throws C2685et {
        super.mo625s(z, z2);
        m2423l();
        C2616ce.m2685h(true);
        this.f9389h.m590e(this.f8714a);
        this.f9388g.m607d();
        this.f9398q = z2;
        this.f9399r = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: t */
    protected final void mo624t(long j, boolean z) throws C2685et {
        super.mo624t(j, z);
        m649aF();
        this.f9388g.m603h();
        this.f9406y = C3282C.TIME_UNSET;
        this.f9400s = C3282C.TIME_UNSET;
        this.f9404w = 0;
        if (z) {
            m643aL();
        } else {
            this.f9401t = C3282C.TIME_UNSET;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: u */
    protected final void mo623u() {
        try {
            super.mo623u();
            if (this.f9394m != null) {
                m644aK();
            }
        } catch (Throwable th) {
            if (this.f9394m != null) {
                m644aK();
            }
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: v */
    protected final void mo622v() {
        this.f9403v = 0;
        this.f9402u = SystemClock.elapsedRealtime();
        this.f9407z = SystemClock.elapsedRealtime() * 1000;
        this.f9376A = 0L;
        this.f9377B = 0;
        this.f9388g.m602i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: w */
    protected final void mo621w() {
        this.f9401t = C3282C.TIME_UNSET;
        m647aH();
        int i = this.f9377B;
        if (i != 0) {
            this.f9389h.m577r(this.f9376A, i);
            this.f9376A = 0L;
            this.f9377B = 0;
        }
        this.f9388g.m601j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.view.Surface] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2733gn
    /* renamed from: p */
    public final void mo627p(int i, Object obj) throws C2685et {
        if (i != 1) {
            if (i == 7) {
                this.f9384I = (InterfaceC3186xh) obj;
                return;
            } else if (i == 10) {
                int intValue = ((Integer) obj).intValue();
                if (this.f9383H != intValue) {
                    this.f9383H = intValue;
                    return;
                }
                return;
            } else if (i != 4) {
                if (i != 5) {
                    return;
                }
                this.f9388g.m599l(((Integer) obj).intValue());
                return;
            } else {
                int intValue2 = ((Integer) obj).intValue();
                this.f9396o = intValue2;
                InterfaceC3017ra m1232aj = m1232aj();
                if (m1232aj != null) {
                    m1232aj.mo1192n(intValue2);
                    return;
                }
                return;
            }
        }
        C3180xb c3180xb = obj instanceof Surface ? (Surface) obj : null;
        if (c3180xb == null) {
            C3180xb c3180xb2 = this.f9394m;
            if (c3180xb2 != null) {
                c3180xb = c3180xb2;
            } else {
                C3019rc m1231al = m1231al();
                if (m1231al != null && m641aN(m1231al)) {
                    c3180xb = C3180xb.m684a(this.f9387f, m1231al.f8681f);
                    this.f9394m = c3180xb;
                }
            }
        }
        if (this.f9393l != c3180xb) {
            this.f9393l = c3180xb;
            this.f9388g.m600k(c3180xb);
            this.f9395n = false;
            int mo2180aY = mo2180aY();
            InterfaceC3017ra m1232aj2 = m1232aj();
            if (m1232aj2 != null) {
                if (C2628cq.f6961a < 23 || c3180xb == null || this.f9391j) {
                    m1229ap();
                    m1230an();
                } else {
                    m1232aj2.mo1194l(c3180xb);
                }
            }
            if (c3180xb == null || c3180xb == this.f9394m) {
                m648aG();
                m649aF();
                return;
            }
            m645aJ();
            m649aF();
            if (mo2180aY == 2) {
                m643aL();
            }
        } else if (c3180xb == null || c3180xb == this.f9394m) {
        } else {
            m645aJ();
            if (this.f9395n) {
                this.f9389h.m578q(this.f9393l);
            }
        }
    }
}
