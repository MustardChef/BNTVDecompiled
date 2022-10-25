package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ba */
/* loaded from: classes2.dex */
public final class C2585ba {

    /* renamed from: a */
    public static final Object f5346a = new Object();

    /* renamed from: r */
    private static final C2543ae f5347r;

    /* renamed from: b */
    public Object f5348b = f5346a;

    /* renamed from: c */
    public C2543ae f5349c = f5347r;

    /* renamed from: d */
    public Object f5350d;

    /* renamed from: e */
    public long f5351e;

    /* renamed from: f */
    public long f5352f;

    /* renamed from: g */
    public long f5353g;

    /* renamed from: h */
    public boolean f5354h;

    /* renamed from: i */
    public boolean f5355i;
    @Deprecated

    /* renamed from: j */
    public boolean f5356j;

    /* renamed from: k */
    public C3232z f5357k;

    /* renamed from: l */
    public boolean f5358l;

    /* renamed from: m */
    public long f5359m;

    /* renamed from: n */
    public long f5360n;

    /* renamed from: o */
    public int f5361o;

    /* renamed from: p */
    public int f5362p;

    /* renamed from: q */
    public long f5363q;

    static {
        C3043s c3043s = new C3043s();
        c3043s.m1176b("bundled.androidx.media3.common.Timeline");
        c3043s.m1173e(Uri.EMPTY);
        f5347r = c3043s.m1177a();
    }

    /* renamed from: a */
    public final long m4251a() {
        return C2628cq.m2511w(this.f5359m);
    }

    /* renamed from: b */
    public final boolean m4250b() {
        C2616ce.m2685h(this.f5356j == (this.f5357k != null));
        return this.f5357k != null;
    }

    /* renamed from: c */
    public final void m4249c(Object obj, C2543ae c2543ae, Object obj2, long j, long j2, long j3, boolean z, boolean z2, C3232z c3232z, long j4, long j5, int i, long j6) {
        this.f5348b = obj;
        this.f5349c = c2543ae != null ? c2543ae : f5347r;
        this.f5350d = obj2;
        this.f5351e = j;
        this.f5352f = j2;
        this.f5353g = j3;
        this.f5354h = z;
        this.f5355i = z2;
        this.f5356j = c3232z != null;
        this.f5357k = c3232z;
        this.f5359m = j4;
        this.f5360n = j5;
        this.f5361o = 0;
        this.f5362p = i;
        this.f5363q = j6;
        this.f5358l = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass().equals(obj.getClass())) {
            C2585ba c2585ba = (C2585ba) obj;
            if (C2628cq.m2563T(this.f5348b, c2585ba.f5348b) && C2628cq.m2563T(this.f5349c, c2585ba.f5349c) && C2628cq.m2563T(this.f5350d, c2585ba.f5350d) && C2628cq.m2563T(this.f5357k, c2585ba.f5357k) && this.f5351e == c2585ba.f5351e && this.f5352f == c2585ba.f5352f && this.f5353g == c2585ba.f5353g && this.f5354h == c2585ba.f5354h && this.f5355i == c2585ba.f5355i && this.f5358l == c2585ba.f5358l && this.f5359m == c2585ba.f5359m && this.f5360n == c2585ba.f5360n && this.f5361o == c2585ba.f5361o && this.f5362p == c2585ba.f5362p && this.f5363q == c2585ba.f5363q) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.f5348b.hashCode() + bqk.f6556bP) * 31) + this.f5349c.hashCode()) * 31;
        Object obj = this.f5350d;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        C3232z c3232z = this.f5357k;
        int hashCode3 = c3232z != null ? c3232z.hashCode() : 0;
        long j = this.f5351e;
        long j2 = this.f5352f;
        long j3 = this.f5353g;
        boolean z = this.f5354h;
        boolean z2 = this.f5355i;
        boolean z3 = this.f5358l;
        long j4 = this.f5359m;
        long j5 = this.f5360n;
        int i = this.f5361o;
        int i2 = this.f5362p;
        long j6 = this.f5363q;
        return ((((((((((((((((((((((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 31) + ((int) ((j4 >>> 32) ^ j4))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + i) * 31) + i2) * 31) + ((int) ((j6 >>> 32) ^ j6));
    }
}
