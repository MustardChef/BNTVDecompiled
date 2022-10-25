package com.applovin.impl.sdk.p030d;

/* renamed from: com.applovin.impl.sdk.d.e */
/* loaded from: classes.dex */
public final class C1585e {

    /* renamed from: a */
    private long f2025a;

    /* renamed from: b */
    private long f2026b;

    /* renamed from: c */
    private boolean f2027c;

    /* renamed from: d */
    private long f2028d;

    /* renamed from: e */
    private long f2029e;

    /* renamed from: f */
    private int f2030f;

    /* renamed from: g */
    private Exception f2031g;

    /* renamed from: a */
    public void m6912a() {
        this.f2027c = true;
    }

    /* renamed from: a */
    public void m6911a(int i) {
        this.f2030f = i;
    }

    /* renamed from: a */
    public void m6910a(long j) {
        this.f2025a += j;
    }

    /* renamed from: a */
    public void m6909a(Exception exc) {
        this.f2031g = exc;
    }

    /* renamed from: b */
    public void m6907b(long j) {
        this.f2026b += j;
    }

    /* renamed from: b */
    public boolean m6908b() {
        return this.f2027c;
    }

    /* renamed from: c */
    public long m6906c() {
        return this.f2025a;
    }

    /* renamed from: d */
    public long m6905d() {
        return this.f2026b;
    }

    /* renamed from: e */
    public void m6904e() {
        this.f2028d++;
    }

    /* renamed from: f */
    public void m6903f() {
        this.f2029e++;
    }

    /* renamed from: g */
    public long m6902g() {
        return this.f2028d;
    }

    /* renamed from: h */
    public long m6901h() {
        return this.f2029e;
    }

    /* renamed from: i */
    public Exception m6900i() {
        return this.f2031g;
    }

    /* renamed from: j */
    public int m6899j() {
        return this.f2030f;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.f2025a + ", totalCachedBytes=" + this.f2026b + ", isHTMLCachingCancelled=" + this.f2027c + ", htmlResourceCacheSuccessCount=" + this.f2028d + ", htmlResourceCacheFailureCount=" + this.f2029e + '}';
    }
}
