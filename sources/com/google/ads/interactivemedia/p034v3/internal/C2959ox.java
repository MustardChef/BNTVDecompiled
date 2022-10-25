package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ox */
/* loaded from: classes2.dex */
public final class C2959ox extends AbstractC3037ru implements InterfaceC2999qj {

    /* renamed from: a */
    private final InterfaceC2954os f8339a;

    /* renamed from: b */
    private final C2537aa f8340b;

    /* renamed from: c */
    private final InterfaceC2921nm f8341c;

    /* renamed from: d */
    private final int f8342d;

    /* renamed from: e */
    private final InterfaceC3000qk f8343e;

    /* renamed from: f */
    private final long f8344f;

    /* renamed from: g */
    private final C2543ae f8345g;

    /* renamed from: h */
    private C3232z f8346h;

    /* renamed from: i */
    private InterfaceC2659du f8347i;

    /* renamed from: j */
    private final C2944oi f8348j;

    /* renamed from: k */
    private final C3161wj f8349k;

    /* renamed from: l */
    private final C3161wj f8350l;

    static {
        C2544af.m5676b("media3.exoplayer.hls");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2959ox(C2543ae c2543ae, C2944oi c2944oi, InterfaceC2954os interfaceC2954os, C3161wj c3161wj, InterfaceC2921nm interfaceC2921nm, C3161wj c3161wj2, InterfaceC3000qk interfaceC3000qk, long j, int i, byte[] bArr, byte[] bArr2) {
        C2537aa c2537aa = c2543ae.f3562b;
        C2616ce.m2689d(c2537aa);
        this.f8340b = c2537aa;
        this.f8345g = c2543ae;
        this.f8346h = c2543ae.f3563c;
        this.f8348j = c2944oi;
        this.f8339a = interfaceC2954os;
        this.f8350l = c3161wj;
        this.f8341c = interfaceC2921nm;
        this.f8349k = c3161wj2;
        this.f8343e = interfaceC3000qk;
        this.f8344f = C3282C.TIME_UNSET;
        this.f8342d = 1;
    }

    /* renamed from: c */
    private static C2984pv m1432c(List list, long j) {
        C2984pv c2984pv = null;
        for (int i = 0; i < list.size(); i++) {
            C2984pv c2984pv2 = (C2984pv) list.get(i);
            int i2 = (c2984pv2.f8528g > j ? 1 : (c2984pv2.f8528g == j ? 0 : -1));
            if (i2 <= 0 && c2984pv2.f8517a) {
                c2984pv = c2984pv2;
            } else if (i2 > 0) {
                break;
            }
        }
        return c2984pv;
    }

    /* renamed from: d */
    private static C2986px m1431d(List list, long j) {
        return (C2986px) list.get(C2628cq.m2542an(list, Long.valueOf(j), true));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: a */
    public final C2543ae mo1011a() {
        return this.f8345g;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2999qj
    /* renamed from: b */
    public final void mo1322b(C2990qa c2990qa) {
        long j;
        C3102ue c3102ue;
        long j2;
        long j3;
        long j4;
        long j5;
        long m2511w = c2990qa.f8552m ? C2628cq.m2511w(c2990qa.f8544e) : -9223372036854775807L;
        int i = c2990qa.f8540a;
        long j6 = (i == 2 || i == 1) ? m2511w : -9223372036854775807L;
        C2616ce.m2689d(this.f8343e.mo1318h());
        C2958ow c2958ow = new C2958ow();
        InterfaceC3000qk interfaceC3000qk = this.f8343e;
        if (!interfaceC3000qk.mo1321A()) {
            if (c2990qa.f8541b == C3282C.TIME_UNSET || c2990qa.f8554o.isEmpty()) {
                j = 0;
            } else {
                if (!c2990qa.f8543d) {
                    long j7 = c2990qa.f8541b;
                    if (j7 != c2990qa.f8557r) {
                        j2 = m1431d(c2990qa.f8554o, j7).f8528g;
                        j = j2;
                    }
                }
                j2 = c2990qa.f8541b;
                j = j2;
            }
            long j8 = c2990qa.f8557r;
            c3102ue = new C3102ue(j6, m2511w, j8, j8, 0L, j, true, false, true, c2958ow, this.f8345g, null);
        } else {
            long mo1319d = c2990qa.f8544e - interfaceC3000qk.mo1319d();
            long j9 = c2990qa.f8551l ? mo1319d + c2990qa.f8557r : -9223372036854775807L;
            long m2515s = c2990qa.f8552m ? C2628cq.m2515s(C2628cq.m2517q(C3282C.TIME_UNSET)) - c2990qa.m1346a() : 0L;
            long j10 = this.f8346h.f9545a;
            if (j10 == C3282C.TIME_UNSET) {
                C2988pz c2988pz = c2990qa.f8558s;
                long j11 = c2990qa.f8541b;
                if (j11 != C3282C.TIME_UNSET) {
                    j3 = c2990qa.f8557r - j11;
                } else {
                    j3 = c2988pz.f8538d;
                    if (j3 == C3282C.TIME_UNSET || c2990qa.f8550k == C3282C.TIME_UNSET) {
                        j3 = c2988pz.f8537c;
                        if (j3 == C3282C.TIME_UNSET) {
                            j3 = c2990qa.f8549j * 3;
                        }
                    }
                }
                j4 = j3 + m2515s;
            } else {
                j4 = C2628cq.m2515s(j10);
            }
            long m2511w2 = C2628cq.m2511w(C2628cq.m2519o(j4, m2515s, c2990qa.f8557r + m2515s));
            C3232z c3232z = this.f8346h;
            if (m2511w2 != c3232z.f9545a) {
                C3205y m490a = c3232z.m490a();
                m490a.m558g(m2511w2);
                this.f8346h = m490a.m559f();
            }
            long j12 = c2990qa.f8541b;
            if (j12 == C3282C.TIME_UNSET) {
                j12 = (c2990qa.f8557r + m2515s) - C2628cq.m2515s(this.f8346h.f9545a);
            }
            if (c2990qa.f8543d) {
                j5 = j12;
            } else {
                C2984pv m1432c = m1432c(c2990qa.f8555p, j12);
                if (m1432c != null) {
                    j5 = m1432c.f8528g;
                } else if (c2990qa.f8554o.isEmpty()) {
                    j5 = 0;
                } else {
                    C2986px m1431d = m1431d(c2990qa.f8554o, j12);
                    C2984pv m1432c2 = m1432c(m1431d.f8523b, j12);
                    j5 = m1432c2 != null ? m1432c2.f8528g : m1431d.f8528g;
                }
            }
            boolean z = false;
            if (c2990qa.f8540a == 2 && c2990qa.f8542c) {
                z = true;
            }
            c3102ue = new C3102ue(j6, m2511w, j9, c2990qa.f8557r, mo1319d, j5, true, !c2990qa.f8551l, z, c2958ow, this.f8345g, this.f8346h);
        }
        m1187F(c3102ue);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: h */
    public final void mo1008h() throws IOException {
        this.f8343e.mo1314s();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: n */
    protected final void mo1007n(InterfaceC2659du interfaceC2659du) {
        this.f8347i = interfaceC2659du;
        this.f8341c.mo1584o();
        this.f8343e.mo1311v(this.f8340b.f2863a, m1182w(null), this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: o */
    public final void mo1006o(InterfaceC3066sw interfaceC3066sw) {
        ((C2956ou) interfaceC3066sw).m1441r();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: p */
    protected final void mo1005p() {
        this.f8343e.mo1310w();
        this.f8341c.mo1583p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: q */
    public final InterfaceC3066sw mo1004q(C3067sx c3067sx, C3154wc c3154wc, long j) {
        C3076tf m1182w = m1182w(c3067sx);
        return new C2956ou(this.f8339a, this.f8343e, this.f8348j, this.f8347i, this.f8341c, m1184u(c3067sx), this.f8349k, m1182w, c3154wc, this.f8350l, 1, null, null);
    }
}
