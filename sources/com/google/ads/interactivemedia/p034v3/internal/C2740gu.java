package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gu */
/* loaded from: classes2.dex */
public final class C2740gu {

    /* renamed from: a */
    public static final C2740gu f7447a;

    /* renamed from: b */
    public static final C2740gu f7448b;

    /* renamed from: c */
    public final long f7449c;

    /* renamed from: d */
    public final long f7450d;

    static {
        C2740gu c2740gu = new C2740gu(0L, 0L);
        f7447a = c2740gu;
        new C2740gu(Long.MAX_VALUE, Long.MAX_VALUE);
        new C2740gu(Long.MAX_VALUE, 0L);
        new C2740gu(0L, Long.MAX_VALUE);
        f7448b = c2740gu;
    }

    public C2740gu(long j, long j2) {
        C2616ce.m2687f(j >= 0);
        C2616ce.m2687f(j2 >= 0);
        this.f7449c = j;
        this.f7450d = j2;
    }

    /* renamed from: a */
    public final long m2169a(long j, long j2, long j3) {
        long j4 = this.f7449c;
        if (j4 == 0 && this.f7450d == 0) {
            return j;
        }
        long m2535au = C2628cq.m2535au(j, j4);
        long m2544al = C2628cq.m2544al(j, this.f7450d);
        boolean z = true;
        boolean z2 = m2535au <= j2 && j2 <= m2544al;
        z = (m2535au > j3 || j3 > m2544al) ? false : false;
        return (z2 && z) ? Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3 : z2 ? j2 : z ? j3 : m2535au;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2740gu c2740gu = (C2740gu) obj;
            if (this.f7449c == c2740gu.f7449c && this.f7450d == c2740gu.f7450d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f7449c) * 31) + ((int) this.f7450d);
    }
}
