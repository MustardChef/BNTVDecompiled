package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.messaging.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ka */
/* loaded from: classes2.dex */
public final class C2828ka extends AbstractC3021re implements InterfaceC2718fz {

    /* renamed from: b */
    private final Context f7785b;

    /* renamed from: c */
    private final C2801ja f7786c;

    /* renamed from: d */
    private final InterfaceC2808jh f7787d;

    /* renamed from: e */
    private int f7788e;

    /* renamed from: f */
    private boolean f7789f;

    /* renamed from: g */
    private C2962p f7790g;

    /* renamed from: h */
    private long f7791h;

    /* renamed from: i */
    private boolean f7792i;

    /* renamed from: j */
    private boolean f7793j;

    /* renamed from: k */
    private boolean f7794k;

    /* renamed from: l */
    private InterfaceC2736gq f7795l;

    public C2828ka(Context context, InterfaceC3015qz interfaceC3015qz, InterfaceC3023rg interfaceC3023rg, Handler handler, InterfaceC2802jb interfaceC2802jb, InterfaceC2808jh interfaceC2808jh) {
        super(1, interfaceC3015qz, interfaceC3023rg, 44100.0f);
        this.f7785b = context.getApplicationContext();
        this.f7787d = interfaceC2808jh;
        this.f7786c = new C2801ja(handler, interfaceC2802jb);
        interfaceC2808jh.mo1856n(new C2826jz(this));
    }

    /* renamed from: ay */
    private final int m1833ay(C3019rc c3019rc, C2962p c2962p) {
        if (!"OMX.google.raw.decoder".equals(c3019rc.f8676a) || C2628cq.f6961a >= 24 || (C2628cq.f6961a == 23 && C2628cq.m2557Z(this.f7785b))) {
            return c2962p.f8373m;
        }
        return -1;
    }

    /* renamed from: az */
    private final void m1832az() {
        long mo1868b = this.f7787d.mo1868b(mo846M());
        if (mo1868b != Long.MIN_VALUE) {
            if (!this.f7793j) {
                mo1868b = Math.max(this.f7791h, mo1868b);
            }
            this.f7791h = mo1868b;
            this.f7793j = false;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2738gs
    /* renamed from: K */
    public final String mo667K() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: M */
    public final boolean mo846M() {
        return super.mo846M() && this.f7787d.mo1850t();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: N */
    public final boolean mo666N() {
        return this.f7787d.mo1851s() || super.mo666N();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: P */
    protected final int mo665P(InterfaceC3023rg interfaceC3023rg, C2962p c2962p) throws C3028rl {
        if (C2554an.m4964m(c2962p.f8372l)) {
            int i = C2628cq.f6961a >= 21 ? 32 : 0;
            int i2 = c2962p.f8359E;
            boolean aw = m1225aw(c2962p);
            if (aw && this.f7787d.mo1849u(c2962p) && (i2 == 0 || C3033rq.m1210c() != null)) {
                return i | 12;
            }
            if (!MimeTypes.AUDIO_RAW.equals(c2962p.f8372l) || this.f7787d.mo1849u(c2962p)) {
                if (this.f7787d.mo1849u(C2628cq.m2579D(2, c2962p.f8385y, c2962p.f8386z))) {
                    List mo659V = mo659V(interfaceC3023rg, c2962p, false);
                    if (mo659V.isEmpty()) {
                        return C2742gw.m2167a(1);
                    }
                    if (aw) {
                        C3019rc c3019rc = (C3019rc) mo659V.get(0);
                        boolean m1260c = c3019rc.m1260c(c2962p);
                        int i3 = 8;
                        if (m1260c && c3019rc.m1259d(c2962p)) {
                            i3 = 16;
                        }
                        return (true != m1260c ? 3 : 4) | i3 | i;
                    }
                    return C2742gw.m2167a(2);
                }
                return C2742gw.m2167a(1);
            }
            return C2742gw.m2167a(1);
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
        if (m1833ay(c3019rc, c2962p2) > this.f7788e) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: R */
    public final C2680eo mo663R(C2717fy c2717fy) throws C2685et {
        C2680eo mo663R = super.mo663R(c2717fy);
        this.f7786c.m1967g(c2717fy.f7335b, mo663R);
        return mo663R;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: U */
    protected final C3014qy mo660U(C3019rc c3019rc, C2962p c2962p, MediaCrypto mediaCrypto, float f) {
        C2962p[] m2429I = m2429I();
        int m1833ay = m1833ay(c3019rc, c2962p);
        if (m2429I.length != 1) {
            for (C2962p c2962p2 : m2429I) {
                if (c3019rc.m1261b(c2962p, c2962p2).f7141d != 0) {
                    m1833ay = Math.max(m1833ay, m1833ay(c3019rc, c2962p2));
                }
            }
        }
        this.f7788e = m1833ay;
        this.f7789f = C2628cq.f6961a < 24 && "OMX.SEC.aac.dec".equals(c3019rc.f8676a) && "samsung".equals(C2628cq.f6963c) && (C2628cq.f6962b.startsWith("zeroflte") || C2628cq.f6962b.startsWith("herolte") || C2628cq.f6962b.startsWith("heroqlte"));
        String str = c3019rc.f8678c;
        int i = this.f7788e;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", c2962p.f8385y);
        mediaFormat.setInteger("sample-rate", c2962p.f8386z);
        C2616ce.m2690c(mediaFormat, c2962p.f8374n);
        C2616ce.m2691b(mediaFormat, "max-input-size", i);
        if (C2628cq.f6961a >= 23) {
            mediaFormat.setInteger(Constants.FirelogAnalytics.PARAM_PRIORITY, 0);
            if (f != -1.0f && (C2628cq.f6961a != 23 || (!"ZTE B2017G".equals(C2628cq.f6964d) && !"AXON 7 mini".equals(C2628cq.f6964d)))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (C2628cq.f6961a <= 28 && MimeTypes.AUDIO_AC4.equals(c2962p.f8372l)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (C2628cq.f6961a >= 24 && this.f7787d.mo1869a(C2628cq.m2579D(4, c2962p.f8385y, c2962p.f8386z)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        C2962p c2962p3 = null;
        if (MimeTypes.AUDIO_RAW.equals(c3019rc.f8677b) && !MimeTypes.AUDIO_RAW.equals(c2962p.f8372l)) {
            c2962p3 = c2962p;
        }
        this.f7790g = c2962p3;
        return C3014qy.m1264a(c3019rc, mediaFormat, c2962p, mediaCrypto);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: V */
    protected final List mo659V(InterfaceC3023rg interfaceC3023rg, C2962p c2962p, boolean z) throws C3028rl {
        C3019rc m1210c;
        String str = c2962p.f8372l;
        if (str == null) {
            return Collections.emptyList();
        }
        if (!this.f7787d.mo1849u(c2962p) || (m1210c = C3033rq.m1210c()) == null) {
            List m1208e = C3033rq.m1208e(interfaceC3023rg.mo1220a(str, z, false), c2962p);
            if (MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
                ArrayList arrayList = new ArrayList(m1208e);
                arrayList.addAll(interfaceC3023rg.mo1220a(MimeTypes.AUDIO_E_AC3, z, false));
                m1208e = arrayList;
            }
            return Collections.unmodifiableList(m1208e);
        }
        return Collections.singletonList(m1210c);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: W */
    protected final void mo658W(Exception exc) {
        C2613cb.m2698a("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.f7786c.m1973a(exc);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: X */
    protected final void mo657X(String str, long j, long j2) {
        this.f7786c.m1971c(str, j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: Y */
    protected final void mo656Y(String str) {
        this.f7786c.m1970d(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: a */
    public final long mo1835a() {
        if (mo2180aY() == 2) {
            m1832az();
        }
        return this.f7791h;
    }

    /* renamed from: aa */
    public final void m1834aa() {
        this.f7793j = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ab */
    protected final void mo639ab() {
        this.f7787d.mo1864f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ac */
    protected final void mo638ac(C2669ed c2669ed) {
        if (!this.f7792i || c2669ed.m2463f()) {
            return;
        }
        if (Math.abs(c2669ed.f7094d - this.f7791h) > 500000) {
            this.f7791h = c2669ed.f7094d;
        }
        this.f7792i = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ae */
    protected final boolean mo637ae(long j, long j2, InterfaceC3017ra interfaceC3017ra, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, C2962p c2962p) throws C2685et {
        C2616ce.m2689d(byteBuffer);
        if (this.f7790g != null && (i2 & 2) != 0) {
            C2616ce.m2689d(interfaceC3017ra);
            interfaceC3017ra.mo1195k(i, false);
            return true;
        } else if (z) {
            if (interfaceC3017ra != null) {
                interfaceC3017ra.mo1195k(i, false);
            }
            this.f8714a.f7132f += i3;
            this.f7787d.mo1864f();
            return true;
        } else {
            try {
                if (this.f7787d.mo1852r(byteBuffer, j3, i3)) {
                    if (interfaceC3017ra != null) {
                        interfaceC3017ra.mo1195k(i, false);
                    }
                    this.f8714a.f7131e += i3;
                    return true;
                }
                return false;
            } catch (C2804jd e) {
                throw m2425h(e, e.f7646b, e.f7645a, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
            } catch (C2807jg e2) {
                throw m2425h(e2, c2962p, e2.f7647a, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: af */
    protected final boolean mo1235af(C2962p c2962p) {
        return this.f7787d.mo1849u(c2962p);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ag */
    protected final float mo636ag(float f, C2962p[] c2962pArr) {
        int i = -1;
        for (C2962p c2962p : c2962pArr) {
            int i2 = c2962p.f8386z;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return i * f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: c */
    public final C2559aq mo1831c() {
        return this.f7787d.mo1867c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: g */
    public final void mo1830g(C2559aq c2559aq) {
        this.f7787d.mo1855o(c2559aq);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2737gr
    /* renamed from: j */
    public final InterfaceC2718fz mo1829j() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2733gn
    /* renamed from: p */
    public final void mo627p(int i, Object obj) throws C2685et {
        if (i == 2) {
            this.f7787d.mo1853q(((Float) obj).floatValue());
        } else if (i == 3) {
            this.f7787d.mo1859k((C2611c) obj);
        } else if (i != 6) {
            switch (i) {
                case 9:
                    this.f7787d.mo1854p(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    this.f7787d.mo1858l(((Integer) obj).intValue());
                    return;
                case 11:
                    this.f7795l = (InterfaceC2736gq) obj;
                    return;
                default:
                    return;
            }
        } else {
            this.f7787d.mo1857m((C2638d) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: r */
    public final void mo626r() {
        this.f7794k = true;
        try {
            this.f7787d.mo1865e();
            try {
                super.mo626r();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.mo626r();
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: s */
    public final void mo625s(boolean z, boolean z2) throws C2685et {
        super.mo625s(z, z2);
        this.f7786c.m1968f(this.f8714a);
        m2423l();
        this.f7787d.mo1866d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: t */
    public final void mo624t(long j, boolean z) throws C2685et {
        super.mo624t(j, z);
        this.f7787d.mo1865e();
        this.f7791h = j;
        this.f7792i = true;
        this.f7793j = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re, com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: u */
    public final void mo623u() {
        try {
            super.mo623u();
            if (this.f7794k) {
                this.f7794k = false;
                this.f7787d.mo1860j();
            }
        } catch (Throwable th) {
            if (this.f7794k) {
                this.f7794k = false;
                this.f7787d.mo1860j();
            }
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: v */
    protected final void mo622v() {
        this.f7787d.mo1862h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2678em
    /* renamed from: w */
    protected final void mo621w() {
        m1832az();
        this.f7787d.mo1863g();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: ad */
    protected final void mo1236ad() throws C2685et {
        try {
            this.f7787d.mo1861i();
        } catch (C2807jg e) {
            throw m2425h(e, e.f7648b, e.f7647a, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3021re
    /* renamed from: Z */
    protected final void mo655Z(C2962p c2962p, MediaFormat mediaFormat) throws C2685et {
        int i;
        int i2;
        C2962p c2962p2 = this.f7790g;
        int[] iArr = null;
        if (c2962p2 != null) {
            c2962p = c2962p2;
        } else if (m1232aj() != null) {
            if (MimeTypes.AUDIO_RAW.equals(c2962p.f8372l)) {
                i = c2962p.f8355A;
            } else if (C2628cq.f6961a < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                if (mediaFormat.containsKey("v-bits-per-sample")) {
                    i = C2628cq.m2524j(mediaFormat.getInteger("v-bits-per-sample"));
                } else {
                    i = MimeTypes.AUDIO_RAW.equals(c2962p.f8372l) ? c2962p.f8355A : 2;
                }
            } else {
                i = mediaFormat.getInteger("pcm-encoding");
            }
            C2935o c2935o = new C2935o();
            c2935o.m1532ae(MimeTypes.AUDIO_RAW);
            c2935o.m1539Y(i);
            c2935o.m1550N(c2962p.f8356B);
            c2935o.m1549O(c2962p.f8357C);
            c2935o.m1556H(mediaFormat.getInteger("channel-count"));
            c2935o.m1531af(mediaFormat.getInteger("sample-rate"));
            C2962p m1506v = c2935o.m1506v();
            if (this.f7789f && m1506v.f8385y == 6 && (i2 = c2962p.f8385y) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < c2962p.f8385y; i3++) {
                    iArr[i3] = i3;
                }
            }
            c2962p = m1506v;
        }
        try {
            this.f7787d.mo1848v(c2962p, iArr);
        } catch (C2803jc e) {
            throw m2427ba(e, e.f7644a, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        }
    }
}
