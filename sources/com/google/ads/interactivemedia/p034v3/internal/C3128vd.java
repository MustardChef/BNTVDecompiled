package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vd */
/* loaded from: classes2.dex */
public final class C3128vd {

    /* renamed from: a */
    public final long f9152a;

    /* renamed from: b */
    public final long f9153b;

    public C3128vd(long j, long j2) {
        this.f9152a = j;
        this.f9153b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3128vd) {
            C3128vd c3128vd = (C3128vd) obj;
            return this.f9152a == c3128vd.f9152a && this.f9153b == c3128vd.f9153b;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f9152a) * 31) + ((int) this.f9153b);
    }
}
