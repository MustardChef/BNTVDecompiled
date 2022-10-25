package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ae */
/* loaded from: classes2.dex */
public final class C2543ae {

    /* renamed from: a */
    public final String f3561a;

    /* renamed from: b */
    public final C2537aa f3562b;

    /* renamed from: c */
    public final C3232z f3563c;

    /* renamed from: d */
    public final C2546ah f3564d;

    /* renamed from: e */
    public final C3097u f3565e;

    static {
        new C3043s().m1177a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2543ae(String str, C3124v c3124v, C2540ac c2540ac, C3232z c3232z, C2546ah c2546ah) {
        this.f3561a = str;
        this.f3562b = c2540ac;
        this.f3563c = c3232z;
        this.f3564d = c2546ah;
        this.f3565e = c3124v;
    }

    /* renamed from: a */
    public final C3043s m5757a() {
        return new C3043s(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2543ae) {
            C2543ae c2543ae = (C2543ae) obj;
            return C2628cq.m2563T(this.f3561a, c2543ae.f3561a) && this.f3565e.equals(c2543ae.f3565e) && C2628cq.m2563T(this.f3562b, c2543ae.f3562b) && C2628cq.m2563T(this.f3563c, c2543ae.f3563c) && C2628cq.m2563T(this.f3564d, c2543ae.f3564d);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f3561a.hashCode() * 31;
        C2537aa c2537aa = this.f3562b;
        return ((((((hashCode + (c2537aa != null ? c2537aa.hashCode() : 0)) * 31) + this.f3563c.hashCode()) * 31) + this.f3565e.hashCode()) * 31) + this.f3564d.hashCode();
    }
}
