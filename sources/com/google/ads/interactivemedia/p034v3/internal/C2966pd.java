package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Looper;
import com.google.android.exoplayer2.source.hls.HlsMediaChunk;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pd */
/* loaded from: classes2.dex */
public final class C2966pd extends C3096tz {

    /* renamed from: a */
    private final Map f8396a;

    /* renamed from: b */
    private C2854l f8397b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2966pd(C3154wc c3154wc, Looper looper, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng, Map map) {
        super(c3154wc, looper, interfaceC2921nm, c2915ng);
        this.f8396a = map;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C3096tz
    /* renamed from: c */
    public final C2962p mo954c(C2962p c2962p) {
        C2854l c2854l;
        C2854l c2854l2 = this.f8397b;
        if (c2854l2 == null) {
            c2854l2 = c2962p.f8375o;
        }
        if (c2854l2 != null && (c2854l = (C2854l) this.f8396a.get(c2854l2.f7955a)) != null) {
            c2854l2 = c2854l;
        }
        C2549ak c2549ak = c2962p.f8370j;
        if (c2549ak != null) {
            int m5127a = c2549ak.m5127a();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= m5127a) {
                    i2 = -1;
                    break;
                }
                InterfaceC2548aj m5126b = c2549ak.m5126b(i2);
                if ((m5126b instanceof aat) && HlsMediaChunk.PRIV_TIMESTAMP_FRAME_OWNER.equals(((aat) m5126b).f2926a)) {
                    break;
                }
                i2++;
            }
            if (i2 != -1) {
                if (m5127a != 1) {
                    InterfaceC2548aj[] interfaceC2548ajArr = new InterfaceC2548aj[m5127a - 1];
                    while (i < m5127a) {
                        if (i != i2) {
                            interfaceC2548ajArr[i < i2 ? i : i - 1] = c2549ak.m5126b(i);
                        }
                        i++;
                    }
                    c2549ak = new C2549ak(interfaceC2548ajArr);
                }
            }
            if (c2854l2 == c2962p.f8375o || c2549ak != c2962p.f8370j) {
                C2935o m1426b = c2962p.m1426b();
                m1426b.m1551M(c2854l2);
                m1426b.m1540X(c2549ak);
                c2962p = m1426b.m1506v();
            }
            return super.mo954c(c2962p);
        }
        c2549ak = null;
        if (c2854l2 == c2962p.f8375o) {
        }
        C2935o m1426b2 = c2962p.m1426b();
        m1426b2.m1551M(c2854l2);
        m1426b2.m1540X(c2549ak);
        c2962p = m1426b2.m1506v();
        return super.mo954c(c2962p);
    }

    /* renamed from: d */
    public final void m1419d(C2854l c2854l) {
        this.f8397b = c2854l;
        m937x();
    }

    /* renamed from: g */
    public final void m1418g(C2955ot c2955ot) {
        m977H(c2955ot.f8294a);
    }
}
