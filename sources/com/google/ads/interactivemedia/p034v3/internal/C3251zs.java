package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zs */
/* loaded from: classes2.dex */
public final class C3251zs {

    /* renamed from: a */
    public static final C3251zs f9615a = new C3251zs(0, 0);

    /* renamed from: b */
    public final long f9616b;

    /* renamed from: c */
    public final long f9617c;

    public C3251zs(long j, long j2) {
        this.f9616b = j;
        this.f9617c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C3251zs c3251zs = (C3251zs) obj;
            if (this.f9616b == c3251zs.f9616b && this.f9617c == c3251zs.f9617c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f9616b) * 31) + ((int) this.f9617c);
    }

    public final String toString() {
        long j = this.f9616b;
        long j2 = this.f9617c;
        StringBuilder sb = new StringBuilder(60);
        sb.append("[timeUs=");
        sb.append(j);
        sb.append(", position=");
        sb.append(j2);
        sb.append("]");
        return sb.toString();
    }
}
