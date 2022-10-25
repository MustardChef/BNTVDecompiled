package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gb */
/* loaded from: classes2.dex */
final class C2721gb {

    /* renamed from: a */
    public final C3067sx f7356a;

    /* renamed from: b */
    public final long f7357b;

    /* renamed from: c */
    public final long f7358c;

    /* renamed from: d */
    public final long f7359d;

    /* renamed from: e */
    public final long f7360e;

    /* renamed from: f */
    public final boolean f7361f;

    /* renamed from: g */
    public final boolean f7362g;

    /* renamed from: h */
    public final boolean f7363h;

    /* renamed from: i */
    public final boolean f7364i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2721gb(C3067sx c3067sx, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        C2616ce.m2687f(!z4 || z2);
        C2616ce.m2687f(!z3 || z2);
        C2616ce.m2687f(true);
        this.f7356a = c3067sx;
        this.f7357b = j;
        this.f7358c = j2;
        this.f7359d = j3;
        this.f7360e = j4;
        this.f7361f = false;
        this.f7362g = z2;
        this.f7363h = z3;
        this.f7364i = z4;
    }

    /* renamed from: a */
    public final C2721gb m2270a(long j) {
        return j == this.f7358c ? this : new C2721gb(this.f7356a, this.f7357b, j, this.f7359d, this.f7360e, false, this.f7362g, this.f7363h, this.f7364i);
    }

    /* renamed from: b */
    public final C2721gb m2269b(long j) {
        return j == this.f7357b ? this : new C2721gb(this.f7356a, j, this.f7358c, this.f7359d, this.f7360e, false, this.f7362g, this.f7363h, this.f7364i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2721gb c2721gb = (C2721gb) obj;
            if (this.f7357b == c2721gb.f7357b && this.f7358c == c2721gb.f7358c && this.f7359d == c2721gb.f7359d && this.f7360e == c2721gb.f7360e && this.f7362g == c2721gb.f7362g && this.f7363h == c2721gb.f7363h && this.f7364i == c2721gb.f7364i && C2628cq.m2563T(this.f7356a, c2721gb.f7356a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.f7356a.hashCode() + 527) * 31) + ((int) this.f7357b)) * 31) + ((int) this.f7358c)) * 31) + ((int) this.f7359d)) * 31) + ((int) this.f7360e)) * 961) + (this.f7362g ? 1 : 0)) * 31) + (this.f7363h ? 1 : 0)) * 31) + (this.f7364i ? 1 : 0);
    }
}
