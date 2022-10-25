package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.extractor.p035ts.TsExtractor;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aec */
/* loaded from: classes2.dex */
public final class aec {

    /* renamed from: d */
    private boolean f3573d;

    /* renamed from: e */
    private boolean f3574e;

    /* renamed from: f */
    private boolean f3575f;

    /* renamed from: a */
    private final int f3570a = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    /* renamed from: b */
    private final C2626co f3571b = new C2626co(0);

    /* renamed from: g */
    private long f3576g = C3282C.TIME_UNSET;

    /* renamed from: h */
    private long f3577h = C3282C.TIME_UNSET;

    /* renamed from: i */
    private long f3578i = C3282C.TIME_UNSET;

    /* renamed from: c */
    private final C2621cj f3572c = new C2621cj();

    /* JADX INFO: Access modifiers changed from: package-private */
    public aec(int i) {
    }

    /* renamed from: e */
    private final void m5752e(InterfaceC3230yy interfaceC3230yy) {
        this.f3572c.m2647C(C2628cq.f6966f);
        this.f3573d = true;
        interfaceC3230yy.mo494h();
    }

    /* renamed from: a */
    public final int m5756a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo, int i) throws IOException {
        if (i <= 0) {
            m5752e(interfaceC3230yy);
            return 0;
        }
        boolean z = this.f3575f;
        long j = C3282C.TIME_UNSET;
        if (!z) {
            long mo500b = interfaceC3230yy.mo500b();
            int min = (int) Math.min(112800L, mo500b);
            long j2 = mo500b - min;
            if (interfaceC3230yy.mo498d() != j2) {
                c3247zo.f9610a = j2;
                return 1;
            }
            this.f3572c.m2648B(min);
            interfaceC3230yy.mo494h();
            interfaceC3230yy.mo496f(this.f3572c.m2642H(), 0, min);
            C2621cj c2621cj = this.f3572c;
            int m2639c = c2621cj.m2639c();
            int m2638d = c2621cj.m2638d();
            int i2 = m2638d - 188;
            while (true) {
                if (i2 < m2639c) {
                    break;
                }
                byte[] m2642H = c2621cj.m2642H();
                int i3 = -4;
                int i4 = 0;
                while (true) {
                    if (i3 > 4) {
                        break;
                    }
                    int i5 = (i3 * 188) + i2;
                    if (i5 < m2639c || i5 >= m2638d || m2642H[i5] != 71) {
                        i4 = 0;
                    } else {
                        i4++;
                        if (i4 == 5) {
                            long m5707g = aev.m5707g(c2621cj, i2, i);
                            if (m5707g != C3282C.TIME_UNSET) {
                                j = m5707g;
                                break;
                            }
                        }
                    }
                    i3++;
                }
                i2--;
            }
            this.f3577h = j;
            this.f3575f = true;
            return 0;
        } else if (this.f3577h == C3282C.TIME_UNSET) {
            m5752e(interfaceC3230yy);
            return 0;
        } else if (this.f3574e) {
            long j3 = this.f3576g;
            if (j3 == C3282C.TIME_UNSET) {
                m5752e(interfaceC3230yy);
                return 0;
            }
            long m2590b = this.f3571b.m2590b(this.f3577h) - this.f3571b.m2590b(j3);
            this.f3578i = m2590b;
            if (m2590b < 0) {
                StringBuilder sb = new StringBuilder(65);
                sb.append("Invalid duration: ");
                sb.append(m2590b);
                sb.append(". Using TIME_UNSET instead.");
                Log.w("TsDurationReader", sb.toString());
                this.f3578i = C3282C.TIME_UNSET;
            }
            m5752e(interfaceC3230yy);
            return 0;
        } else {
            int min2 = (int) Math.min(112800L, interfaceC3230yy.mo500b());
            if (interfaceC3230yy.mo498d() != 0) {
                c3247zo.f9610a = 0L;
                return 1;
            }
            this.f3572c.m2648B(min2);
            interfaceC3230yy.mo494h();
            interfaceC3230yy.mo496f(this.f3572c.m2642H(), 0, min2);
            C2621cj c2621cj2 = this.f3572c;
            int m2639c2 = c2621cj2.m2639c();
            int m2638d2 = c2621cj2.m2638d();
            while (true) {
                if (m2639c2 >= m2638d2) {
                    break;
                }
                if (c2621cj2.m2642H()[m2639c2] == 71) {
                    long m5707g2 = aev.m5707g(c2621cj2, m2639c2, i);
                    if (m5707g2 != C3282C.TIME_UNSET) {
                        j = m5707g2;
                        break;
                    }
                }
                m2639c2++;
            }
            this.f3576g = j;
            this.f3574e = true;
            return 0;
        }
    }

    /* renamed from: b */
    public final long m5755b() {
        return this.f3578i;
    }

    /* renamed from: c */
    public final C2626co m5754c() {
        return this.f3571b;
    }

    /* renamed from: d */
    public final boolean m5753d() {
        return this.f3573d;
    }
}
