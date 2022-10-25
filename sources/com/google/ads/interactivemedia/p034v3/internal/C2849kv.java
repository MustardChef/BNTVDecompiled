package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kv */
/* loaded from: classes2.dex */
public final class C2849kv extends AbstractC3037ru {

    /* renamed from: A */
    private int f7912A;

    /* renamed from: B */
    private long f7913B;

    /* renamed from: C */
    private int f7914C;

    /* renamed from: D */
    private final C2852ky f7915D;

    /* renamed from: E */
    private final C2847kt f7916E;

    /* renamed from: F */
    private final C3161wj f7917F;

    /* renamed from: G */
    private final C3161wj f7918G;

    /* renamed from: a */
    private final C2543ae f7919a;

    /* renamed from: b */
    private final InterfaceC2636cy f7920b;

    /* renamed from: c */
    private final InterfaceC2921nm f7921c;

    /* renamed from: d */
    private final C2835kh f7922d;

    /* renamed from: e */
    private final long f7923e;

    /* renamed from: f */
    private final C3076tf f7924f;

    /* renamed from: g */
    private final InterfaceC3169wr f7925g;

    /* renamed from: h */
    private final Object f7926h;

    /* renamed from: i */
    private final SparseArray f7927i;

    /* renamed from: j */
    private final Runnable f7928j;

    /* renamed from: k */
    private final Runnable f7929k;

    /* renamed from: l */
    private final InterfaceC2859le f7930l;

    /* renamed from: m */
    private final InterfaceC3168wq f7931m;

    /* renamed from: n */
    private InterfaceC2637cz f7932n;

    /* renamed from: o */
    private C3167wp f7933o;

    /* renamed from: p */
    private InterfaceC2659du f7934p;

    /* renamed from: q */
    private IOException f7935q;

    /* renamed from: r */
    private Handler f7936r;

    /* renamed from: s */
    private C3232z f7937s;

    /* renamed from: t */
    private Uri f7938t;

    /* renamed from: u */
    private final Uri f7939u;

    /* renamed from: v */
    private C2864lj f7940v;

    /* renamed from: w */
    private boolean f7941w;

    /* renamed from: x */
    private long f7942x;

    /* renamed from: y */
    private long f7943y;

    /* renamed from: z */
    private long f7944z;

    static {
        C2544af.m5676b("media3.exoplayer.dash");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2849kv(C2543ae c2543ae, InterfaceC2636cy interfaceC2636cy, InterfaceC3169wr interfaceC3169wr, C2852ky c2852ky, C3161wj c3161wj, InterfaceC2921nm interfaceC2921nm, C3161wj c3161wj2, long j, byte[] bArr, byte[] bArr2) {
        this.f7919a = c2543ae;
        this.f7937s = c2543ae.f3563c;
        C2537aa c2537aa = c2543ae.f3562b;
        C2616ce.m2689d(c2537aa);
        this.f7938t = c2537aa.f2863a;
        this.f7939u = c2543ae.f3562b.f2863a;
        this.f7940v = null;
        this.f7920b = interfaceC2636cy;
        this.f7925g = interfaceC3169wr;
        this.f7915D = c2852ky;
        this.f7921c = interfaceC2921nm;
        this.f7917F = c3161wj2;
        this.f7923e = 30000L;
        this.f7918G = c3161wj;
        this.f7922d = new C2835kh();
        this.f7924f = m1182w(null);
        this.f7926h = new Object();
        this.f7927i = new SparseArray();
        this.f7930l = new C2843kp(this);
        this.f7913B = C3282C.TIME_UNSET;
        this.f7944z = C3282C.TIME_UNSET;
        this.f7916E = new C2847kt(this, 1);
        this.f7931m = new C2846ks(this);
        this.f7928j = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.km

            /* renamed from: a */
            public final /* synthetic */ C2849kv f7886a;

            {
                this.f7886a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (r2 != 0) {
                    this.f7886a.m1758g();
                } else {
                    this.f7886a.m1765T();
                }
            }
        };
        this.f7929k = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.km

            /* renamed from: a */
            public final /* synthetic */ C2849kv f7886a;

            {
                this.f7886a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (r2 != 0) {
                    this.f7886a.m1758g();
                } else {
                    this.f7886a.m1765T();
                }
            }
        };
    }

    /* renamed from: M */
    private final void m1772M() {
        C3177wz.m694f(this.f7933o, new C2841kn(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final void m1771N(IOException iOException) {
        C2613cb.m2698a(DashMediaSource.DEFAULT_MEDIA_ID, "Failed to resolve time offset.", iOException);
        m1769P(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public final void m1770O(long j) {
        this.f7944z = j;
        m1769P(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a6, code lost:
        if (r5 == com.google.android.exoplayer2.C3282C.TIME_UNSET) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01bb, code lost:
        if (r13 == com.google.android.exoplayer2.C3282C.TIME_UNSET) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017e  */
    /* renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m1769P(boolean r38) {
        /*
            Method dump skipped, instructions count: 911
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2849kv.m1769P(boolean):void");
    }

    /* renamed from: Q */
    private final void m1768Q(C2885md c2885md, InterfaceC3169wr interfaceC3169wr) {
        m1766S(new C3170ws(this.f7932n, Uri.parse(c2885md.f8091b), 5, interfaceC3169wr), new C2847kt(this, 0), 1);
    }

    /* renamed from: R */
    private final void m1767R(long j) {
        this.f7936r.postDelayed(this.f7928j, j);
    }

    /* renamed from: S */
    private final void m1766S(C3170ws c3170ws, InterfaceC3160wi interfaceC3160wi, int i) {
        this.f7933o.m728b(c3170ws, interfaceC3160wi, i);
        this.f7924f.m1081j(new C3059sp(c3170ws.f9316b), c3170ws.f9317c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public final void m1765T() {
        Uri uri;
        this.f7936r.removeCallbacks(this.f7928j);
        if (this.f7933o.m718l()) {
            return;
        }
        if (this.f7933o.m717m()) {
            this.f7941w = true;
            return;
        }
        synchronized (this.f7926h) {
            uri = this.f7938t;
        }
        this.f7941w = false;
        m1766S(new C3170ws(this.f7932n, uri, 4, this.f7925g), this.f7916E, C3161wj.m739b(4));
    }

    /* renamed from: U */
    private static boolean m1764U(C2869lo c2869lo) {
        for (int i = 0; i < c2869lo.f8042c.size(); i++) {
            int i2 = ((C2862lh) c2869lo.f8042c.get(i)).f7999b;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: a */
    public final C2543ae mo1011a() {
        return this.f7919a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final /* synthetic */ void m1758g() {
        m1769P(false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: h */
    public final void mo1008h() throws IOException {
        this.f7931m.mo715a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final void m1757i(long j) {
        long j2 = this.f7913B;
        if (j2 == C3282C.TIME_UNSET || j2 < j) {
            this.f7913B = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final void m1756j() {
        this.f7936r.removeCallbacks(this.f7929k);
        m1765T();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final void m1755k(C3170ws c3170ws, long j, long j2) {
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        long j4 = c3170ws.f9315a;
        this.f7924f.m1087d(c3059sp, c3170ws.f9317c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final void m1754l(C3170ws c3170ws, long j, long j2) {
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        long j4 = c3170ws.f9315a;
        this.f7924f.m1085f(c3059sp, c3170ws.f9317c);
        C2864lj c2864lj = (C2864lj) c3170ws.m711d();
        C2864lj c2864lj2 = this.f7940v;
        int m1712a = c2864lj2 == null ? 0 : c2864lj2.m1712a();
        long j5 = c2864lj.m1709d(0).f8041b;
        int i = 0;
        while (i < m1712a && this.f7940v.m1709d(i).f8041b < j5) {
            i++;
        }
        if (c2864lj.f8011d) {
            if (m1712a - i > c2864lj.m1712a()) {
                Log.w(DashMediaSource.DEFAULT_MEDIA_ID, "Loaded out of sync manifest");
            } else {
                long j6 = this.f7913B;
                if (j6 != C3282C.TIME_UNSET) {
                    long j7 = c2864lj.f8015h;
                    if (1000 * j7 <= j6) {
                        StringBuilder sb = new StringBuilder(73);
                        sb.append("Loaded stale dynamic manifest: ");
                        sb.append(j7);
                        sb.append(", ");
                        sb.append(j6);
                        Log.w(DashMediaSource.DEFAULT_MEDIA_ID, sb.toString());
                    }
                }
                this.f7912A = 0;
            }
            int i2 = this.f7912A;
            this.f7912A = i2 + 1;
            if (i2 < C3161wj.m739b(c3170ws.f9317c)) {
                m1767R(Math.min((this.f7912A - 1) * 1000, 5000));
                return;
            } else {
                this.f7935q = new C2837kj();
                return;
            }
        }
        this.f7940v = c2864lj;
        this.f7941w = c2864lj.f8011d & this.f7941w;
        this.f7942x = j - j2;
        this.f7943y = j;
        synchronized (this.f7926h) {
            if (c3170ws.f9316b.f7011a == this.f7938t) {
                Uri uri = this.f7940v.f8018k;
                if (uri == null) {
                    uri = c3170ws.m712c();
                }
                this.f7938t = uri;
            }
        }
        if (m1712a == 0) {
            C2864lj c2864lj3 = this.f7940v;
            if (c2864lj3.f8011d) {
                C2885md c2885md = c2864lj3.f8016i;
                if (c2885md != null) {
                    String str = c2885md.f8090a;
                    if (C2628cq.m2563T(str, "urn:mpeg:dash:utc:direct:2014") || C2628cq.m2563T(str, "urn:mpeg:dash:utc:direct:2012")) {
                        try {
                            m1770O(C2628cq.m2514t(c2885md.f8091b) - this.f7943y);
                            return;
                        } catch (C2555ao e) {
                            m1771N(e);
                            return;
                        }
                    } else if (C2628cq.m2563T(str, "urn:mpeg:dash:utc:http-iso:2014") || C2628cq.m2563T(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                        m1768Q(c2885md, new C2845kr());
                        return;
                    } else if (C2628cq.m2563T(str, "urn:mpeg:dash:utc:http-xsdate:2014") || C2628cq.m2563T(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                        m1768Q(c2885md, new C2848ku(null));
                        return;
                    } else if (C2628cq.m2563T(str, "urn:mpeg:dash:utc:ntp:2014") || C2628cq.m2563T(str, "urn:mpeg:dash:utc:ntp:2012")) {
                        m1772M();
                        return;
                    } else {
                        m1771N(new IOException("Unsupported UTC timing scheme"));
                        return;
                    }
                }
                m1772M();
                return;
            }
            m1769P(true);
            return;
        }
        this.f7914C += i;
        m1769P(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public final void m1753m(C3170ws c3170ws, long j, long j2) {
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        long j4 = c3170ws.f9315a;
        this.f7924f.m1085f(c3059sp, c3170ws.f9317c);
        m1770O(((Long) c3170ws.m711d()).longValue() - j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: n */
    protected final void mo1007n(InterfaceC2659du interfaceC2659du) {
        this.f7934p = interfaceC2659du;
        this.f7921c.mo1584o();
        this.f7932n = ((C2645dg) this.f7920b).m2483a();
        this.f7933o = new C3167wp(DashMediaSource.DEFAULT_MEDIA_ID);
        this.f7936r = C2628cq.m2508z();
        m1765T();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: o */
    public final void mo1006o(InterfaceC3066sw interfaceC3066sw) {
        C2839kl c2839kl = (C2839kl) interfaceC3066sw;
        c2839kl.m1781m();
        this.f7927i.remove(c2839kl.f7863a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: p */
    protected final void mo1005p() {
        this.f7941w = false;
        this.f7932n = null;
        C3167wp c3167wp = this.f7933o;
        if (c3167wp != null) {
            c3167wp.m720j();
            this.f7933o = null;
        }
        this.f7942x = 0L;
        this.f7943y = 0L;
        this.f7940v = null;
        this.f7938t = this.f7939u;
        this.f7935q = null;
        Handler handler = this.f7936r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f7936r = null;
        }
        this.f7944z = C3282C.TIME_UNSET;
        this.f7912A = 0;
        this.f7913B = C3282C.TIME_UNSET;
        this.f7914C = 0;
        this.f7927i.clear();
        this.f7922d.m1789d();
        this.f7921c.mo1583p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: q */
    public final InterfaceC3066sw mo1004q(C3067sx c3067sx, C3154wc c3154wc, long j) {
        int intValue = ((Integer) c3067sx.f4115a).intValue() - this.f7914C;
        C3076tf m1181x = m1181x(c3067sx, this.f7940v.m1709d(intValue).f8041b);
        C2839kl c2839kl = new C2839kl(intValue + this.f7914C, this.f7940v, this.f7922d, intValue, this.f7915D, this.f7934p, this.f7921c, m1184u(c3067sx), this.f7917F, m1181x, this.f7944z, this.f7931m, c3154wc, this.f7918G, this.f7930l, null, null);
        this.f7927i.put(c2839kl.f7863a, c2839kl);
        return c2839kl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public final C3158wg m1752r(C3170ws c3170ws, long j, long j2, IOException iOException, int i) {
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        int i2 = c3170ws.f9317c;
        long m738c = C3161wj.m738c(new C3159wh(iOException, i));
        C3158wg m716n = m738c == C3282C.TIME_UNSET ? C3167wp.f9311c : C3167wp.m716n(false, m738c);
        boolean z = !m716n.m743a();
        this.f7924f.m1083h(c3059sp, c3170ws.f9317c, iOException, z);
        if (z) {
            long j4 = c3170ws.f9315a;
        }
        return m716n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public final C3158wg m1751s(C3170ws c3170ws, long j, long j2, IOException iOException) {
        C3076tf c3076tf = this.f7924f;
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        c3076tf.m1083h(new C3059sp(), c3170ws.f9317c, iOException, true);
        long j4 = c3170ws.f9315a;
        m1771N(iOException);
        return C3167wp.f9310b;
    }
}
