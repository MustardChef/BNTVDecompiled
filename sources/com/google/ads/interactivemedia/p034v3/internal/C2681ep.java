package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ep */
/* loaded from: classes2.dex */
public final class C2681ep {

    /* renamed from: e */
    private final long f7147e;

    /* renamed from: f */
    private final long f7148f;

    /* renamed from: a */
    private final float f7143a = 0.97f;

    /* renamed from: b */
    private final float f7144b = 1.03f;

    /* renamed from: c */
    private final long f7145c = 1000;

    /* renamed from: d */
    private final float f7146d = 1.0E-7f;

    /* renamed from: g */
    private final float f7149g = 0.999f;

    /* renamed from: h */
    private long f7150h = C3282C.TIME_UNSET;

    /* renamed from: i */
    private long f7151i = C3282C.TIME_UNSET;

    /* renamed from: k */
    private long f7153k = C3282C.TIME_UNSET;

    /* renamed from: l */
    private long f7154l = C3282C.TIME_UNSET;

    /* renamed from: o */
    private float f7157o = 0.97f;

    /* renamed from: n */
    private float f7156n = 1.03f;

    /* renamed from: p */
    private float f7158p = 1.0f;

    /* renamed from: q */
    private long f7159q = C3282C.TIME_UNSET;

    /* renamed from: j */
    private long f7152j = C3282C.TIME_UNSET;

    /* renamed from: m */
    private long f7155m = C3282C.TIME_UNSET;

    /* renamed from: r */
    private long f7160r = C3282C.TIME_UNSET;

    /* renamed from: s */
    private long f7161s = C3282C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2681ep(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        this.f7147e = j2;
        this.f7148f = j3;
    }

    /* renamed from: f */
    private static long m2416f(long j, long j2, float f) {
        return (((float) j) * 0.999f) + (((float) j2) * 9.999871E-4f);
    }

    /* renamed from: g */
    private final void m2415g() {
        long j = this.f7150h;
        if (j != C3282C.TIME_UNSET) {
            long j2 = this.f7151i;
            if (j2 != C3282C.TIME_UNSET) {
                j = j2;
            }
            long j3 = this.f7153k;
            if (j3 != C3282C.TIME_UNSET && j < j3) {
                j = j3;
            }
            long j4 = this.f7154l;
            if (j4 != C3282C.TIME_UNSET && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.f7152j == j) {
            return;
        }
        this.f7152j = j;
        this.f7155m = j;
        this.f7160r = C3282C.TIME_UNSET;
        this.f7161s = C3282C.TIME_UNSET;
        this.f7159q = C3282C.TIME_UNSET;
    }

    /* renamed from: b */
    public final long m2420b() {
        return this.f7155m;
    }

    /* renamed from: c */
    public final void m2419c() {
        long j = this.f7155m;
        if (j == C3282C.TIME_UNSET) {
            return;
        }
        long j2 = j + this.f7148f;
        this.f7155m = j2;
        long j3 = this.f7154l;
        if (j3 != C3282C.TIME_UNSET && j2 > j3) {
            this.f7155m = j3;
        }
        this.f7159q = C3282C.TIME_UNSET;
    }

    /* renamed from: d */
    public final void m2418d(C3232z c3232z) {
        this.f7150h = C2628cq.m2515s(c3232z.f9545a);
        this.f7153k = C2628cq.m2515s(c3232z.f9546b);
        this.f7154l = C2628cq.m2515s(c3232z.f9547c);
        float f = c3232z.f9548d;
        if (f == -3.4028235E38f) {
            f = 0.97f;
        }
        this.f7157o = f;
        float f2 = c3232z.f9549e;
        if (f2 == -3.4028235E38f) {
            f2 = 1.03f;
        }
        this.f7156n = f2;
        m2415g();
    }

    /* renamed from: e */
    public final void m2417e(long j) {
        this.f7151i = j;
        m2415g();
    }

    /* renamed from: a */
    public final float m2421a(long j, long j2) {
        long m2519o;
        if (this.f7150h != C3282C.TIME_UNSET) {
            long j3 = j - j2;
            long j4 = this.f7160r;
            if (j4 == C3282C.TIME_UNSET) {
                this.f7160r = j3;
                this.f7161s = 0L;
            } else {
                long max = Math.max(j3, m2416f(j4, j3, 0.999f));
                this.f7160r = max;
                this.f7161s = m2416f(this.f7161s, Math.abs(j3 - max), 0.999f);
            }
            if (this.f7159q == C3282C.TIME_UNSET || SystemClock.elapsedRealtime() - this.f7159q >= 1000) {
                this.f7159q = SystemClock.elapsedRealtime();
                long j5 = this.f7160r + (this.f7161s * 3);
                long j6 = this.f7155m;
                if (j6 > j5) {
                    float m2515s = (float) C2628cq.m2515s(1000L);
                    long[] jArr = {j5, this.f7152j, j6 - (((this.f7158p - 1.0f) * m2515s) + ((this.f7156n - 1.0f) * m2515s))};
                    atm.m4618d(true);
                    m2519o = jArr[0];
                    for (int i = 1; i < 3; i++) {
                        long j7 = jArr[i];
                        if (j7 > m2519o) {
                            m2519o = j7;
                        }
                    }
                    this.f7155m = m2519o;
                } else {
                    m2519o = C2628cq.m2519o(j - (Math.max(0.0f, this.f7158p - 1.0f) / 1.0E-7f), this.f7155m, j5);
                    this.f7155m = m2519o;
                    long j8 = this.f7154l;
                    if (j8 != C3282C.TIME_UNSET && m2519o > j8) {
                        this.f7155m = j8;
                        m2519o = j8;
                    }
                }
                long j9 = j - m2519o;
                if (Math.abs(j9) < this.f7147e) {
                    this.f7158p = 1.0f;
                    return 1.0f;
                }
                float m2556a = C2628cq.m2556a((((float) j9) * 1.0E-7f) + 1.0f, this.f7157o, this.f7156n);
                this.f7158p = m2556a;
                return m2556a;
            }
            return this.f7158p;
        }
        return 1.0f;
    }
}
