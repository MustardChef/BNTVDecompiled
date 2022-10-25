package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.az */
/* loaded from: classes2.dex */
public final class C2583az {

    /* renamed from: a */
    public Object f5312a;

    /* renamed from: b */
    public Object f5313b;

    /* renamed from: c */
    public int f5314c;

    /* renamed from: d */
    public long f5315d;

    /* renamed from: e */
    public long f5316e;

    /* renamed from: f */
    public boolean f5317f;

    /* renamed from: g */
    private C2584b f5318g = C2584b.f5342a;

    /* renamed from: a */
    public final int m4301a(int i) {
        return this.f5318g.m4252a(i).f2857b;
    }

    /* renamed from: b */
    public final int m4300b(long j) {
        long j2 = this.f5315d;
        if (j == Long.MIN_VALUE || j2 == C3282C.TIME_UNSET) {
            return -1;
        }
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        return -1;
    }

    /* renamed from: c */
    public final int m4299c(long j) {
        return -1;
    }

    /* renamed from: d */
    public final int m4298d(int i) {
        return this.f5318g.m4252a(i).m5985a();
    }

    /* renamed from: e */
    public final int m4297e(int i, int i2) {
        return this.f5318g.m4252a(i).m5984b(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass().equals(obj.getClass())) {
            C2583az c2583az = (C2583az) obj;
            if (C2628cq.m2563T(this.f5312a, c2583az.f5312a) && C2628cq.m2563T(this.f5313b, c2583az.f5313b) && this.f5314c == c2583az.f5314c && this.f5315d == c2583az.f5315d && this.f5316e == c2583az.f5316e && this.f5317f == c2583az.f5317f && C2628cq.m2563T(this.f5318g, c2583az.f5318g)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final long m4296f(int i, int i2) {
        C2536a m4252a = this.f5318g.m4252a(i);
        return m4252a.f2857b != -1 ? m4252a.f2860e[i2] : C3282C.TIME_UNSET;
    }

    /* renamed from: g */
    public final void m4295g(int i) {
        long j = this.f5318g.m4252a(i).f2856a;
    }

    /* renamed from: h */
    public final void m4294h() {
        long j = this.f5318g.f5344b;
    }

    /* renamed from: i */
    public final void m4293i(int i) {
        long j = this.f5318g.m4252a(i).f2861f;
    }

    /* renamed from: j */
    public final void m4292j(int i) {
        boolean z = this.f5318g.m4252a(i).f2862g;
    }

    /* renamed from: k */
    public final C2583az m4291k(Object obj, Object obj2, long j, long j2) {
        m4290l(obj, obj2, j, j2, C2584b.f5342a, false);
        return this;
    }

    /* renamed from: l */
    public final void m4290l(Object obj, Object obj2, long j, long j2, C2584b c2584b, boolean z) {
        this.f5312a = obj;
        this.f5313b = obj2;
        this.f5314c = 0;
        this.f5315d = j;
        this.f5316e = j2;
        this.f5318g = c2584b;
        this.f5317f = z;
    }

    public final int hashCode() {
        Object obj = this.f5312a;
        int hashCode = ((obj == null ? 0 : obj.hashCode()) + bqk.f6556bP) * 31;
        Object obj2 = this.f5313b;
        int hashCode2 = obj2 != null ? obj2.hashCode() : 0;
        int i = this.f5314c;
        long j = this.f5315d;
        long j2 = this.f5316e;
        return ((((((((((hashCode + hashCode2) * 31) + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.f5317f ? 1 : 0)) * 31) + this.f5318g.hashCode();
    }
}
