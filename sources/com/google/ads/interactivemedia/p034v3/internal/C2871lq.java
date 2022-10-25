package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lq */
/* loaded from: classes2.dex */
public final class C2871lq {

    /* renamed from: a */
    public final long f8049a;

    /* renamed from: b */
    public final long f8050b;

    /* renamed from: c */
    private final String f8051c;

    /* renamed from: d */
    private int f8052d;

    public C2871lq(String str, long j, long j2) {
        this.f8051c = str == null ? "" : str;
        this.f8049a = j;
        this.f8050b = j2;
    }

    /* renamed from: a */
    public final Uri m1678a(String str) {
        return C2616ce.m2675r(str, this.f8051c);
    }

    /* renamed from: b */
    public final C2871lq m1677b(C2871lq c2871lq, String str) {
        String m1676c = m1676c(str);
        if (c2871lq != null && m1676c.equals(c2871lq.m1676c(str))) {
            long j = this.f8050b;
            int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i != 0) {
                long j2 = this.f8049a;
                if (j2 + j == c2871lq.f8049a) {
                    long j3 = c2871lq.f8050b;
                    return new C2871lq(m1676c, j2, j3 == -1 ? -1L : j + j3);
                }
            }
            long j4 = c2871lq.f8050b;
            if (j4 != -1) {
                long j5 = c2871lq.f8049a;
                if (j5 + j4 == this.f8049a) {
                    return new C2871lq(m1676c, j5, i == 0 ? -1L : j4 + j);
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public final String m1676c(String str) {
        return C2616ce.m2674s(str, this.f8051c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2871lq c2871lq = (C2871lq) obj;
            if (this.f8049a == c2871lq.f8049a && this.f8050b == c2871lq.f8050b && this.f8051c.equals(c2871lq.f8051c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f8052d;
        if (i == 0) {
            int hashCode = ((((((int) this.f8049a) + 527) * 31) + ((int) this.f8050b)) * 31) + this.f8051c.hashCode();
            this.f8052d = hashCode;
            return hashCode;
        }
        return i;
    }

    public final String toString() {
        String str = this.f8051c;
        long j = this.f8049a;
        long j2 = this.f8050b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 81);
        sb.append("RangedUri(referenceUri=");
        sb.append(str);
        sb.append(", start=");
        sb.append(j);
        sb.append(", length=");
        sb.append(j2);
        sb.append(")");
        return sb.toString();
    }
}
