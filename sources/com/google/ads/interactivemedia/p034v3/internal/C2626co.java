package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.co */
/* loaded from: classes2.dex */
public final class C2626co {

    /* renamed from: a */
    private long f6956a;

    /* renamed from: b */
    private long f6957b;

    /* renamed from: c */
    private long f6958c;

    /* renamed from: d */
    private final ThreadLocal f6959d = new ThreadLocal();

    public C2626co(long j) {
        m2584h(j);
    }

    /* renamed from: f */
    public static long m2586f(long j) {
        return (j * 1000000) / 90000;
    }

    /* renamed from: g */
    public static long m2585g(long j) {
        return (j * 90000) / 1000000;
    }

    /* renamed from: a */
    public final synchronized long m2591a(long j) {
        if (j == C3282C.TIME_UNSET) {
            return C3282C.TIME_UNSET;
        }
        if (this.f6957b == C3282C.TIME_UNSET) {
            long j2 = this.f6956a;
            if (j2 == TimestampAdjuster.MODE_SHARED) {
                Long l = (Long) this.f6959d.get();
                C2616ce.m2689d(l);
                j2 = l.longValue();
            }
            this.f6957b = j2 - j;
            notifyAll();
        }
        this.f6958c = j;
        return j + this.f6957b;
    }

    /* renamed from: b */
    public final synchronized long m2590b(long j) {
        if (j == C3282C.TIME_UNSET) {
            return C3282C.TIME_UNSET;
        }
        long j2 = this.f6958c;
        if (j2 != C3282C.TIME_UNSET) {
            long m2585g = m2585g(j2);
            long j3 = (4294967296L + m2585g) / 8589934592L;
            long j4 = (((-1) + j3) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - m2585g) < Math.abs(j - m2585g)) {
                j = j4;
            }
        }
        return m2591a(m2586f(j));
    }

    /* renamed from: c */
    public final synchronized long m2589c() {
        long j = this.f6956a;
        return (j == Long.MAX_VALUE || j == TimestampAdjuster.MODE_SHARED) ? C3282C.TIME_UNSET : j;
    }

    /* renamed from: d */
    public final synchronized long m2588d() {
        long j;
        j = this.f6958c;
        return j != C3282C.TIME_UNSET ? j + this.f6957b : m2589c();
    }

    /* renamed from: e */
    public final synchronized long m2587e() {
        return this.f6957b;
    }

    /* renamed from: h */
    public final synchronized void m2584h(long j) {
        this.f6956a = j;
        this.f6957b = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f6958c = C3282C.TIME_UNSET;
    }

    /* renamed from: i */
    public final synchronized void m2583i(boolean z, long j) throws InterruptedException {
        C2616ce.m2685h(this.f6956a == TimestampAdjuster.MODE_SHARED);
        if (this.f6957b != C3282C.TIME_UNSET) {
            return;
        }
        if (z) {
            this.f6959d.set(Long.valueOf(j));
            return;
        }
        while (this.f6957b == C3282C.TIME_UNSET) {
            wait();
        }
    }
}
