package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.extractor.p035ts.TsExtractor;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aea */
/* loaded from: classes2.dex */
final class aea implements InterfaceC3219yn {

    /* renamed from: a */
    private final C2626co f3566a;

    /* renamed from: c */
    private final int f3568c;

    /* renamed from: d */
    private final int f3569d = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    /* renamed from: b */
    private final C2621cj f3567b = new C2621cj();

    public aea(int i, C2626co c2626co, int i2) {
        this.f3568c = i;
        this.f3566a = c2626co;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3219yn
    /* renamed from: a */
    public final C3218ym mo522a(InterfaceC3230yy interfaceC3230yy, long j) throws IOException {
        int m5708f;
        int m5708f2;
        long j2;
        long mo498d = interfaceC3230yy.mo498d();
        int min = (int) Math.min(112800L, interfaceC3230yy.mo500b() - mo498d);
        this.f3567b.m2648B(min);
        interfaceC3230yy.mo496f(this.f3567b.m2642H(), 0, min);
        C2621cj c2621cj = this.f3567b;
        int m2638d = c2621cj.m2638d();
        long j3 = -1;
        long j4 = -1;
        long j5 = -9223372036854775807L;
        while (c2621cj.m2641a() >= 188 && (m5708f2 = (m5708f = aev.m5708f(c2621cj.m2642H(), c2621cj.m2639c(), m2638d)) + 188) <= m2638d) {
            long m5707g = aev.m5707g(c2621cj, m5708f, this.f3568c);
            if (m5707g != C3282C.TIME_UNSET) {
                long m2590b = this.f3566a.m2590b(m5707g);
                if (m2590b > j) {
                    if (j5 == C3282C.TIME_UNSET) {
                        return C3218ym.m525d(m2590b, mo498d);
                    }
                    j2 = mo498d + j4;
                } else if (100000 + m2590b > j) {
                    j2 = mo498d + m5708f;
                } else {
                    j4 = m5708f;
                    j5 = m2590b;
                }
                return C3218ym.m524e(j2);
            }
            c2621cj.m2644F(m5708f2);
            j3 = m5708f2;
        }
        return j5 != C3282C.TIME_UNSET ? C3218ym.m523f(j5, mo498d + j3) : C3218ym.f9508a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3219yn
    /* renamed from: b */
    public final void mo521b() {
        this.f3567b.m2647C(C2628cq.f6966f);
    }
}
