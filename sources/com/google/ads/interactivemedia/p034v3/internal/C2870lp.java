package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lp */
/* loaded from: classes2.dex */
public final class C2870lp {

    /* renamed from: a */
    public final String f8044a;

    /* renamed from: b */
    public final String f8045b;

    /* renamed from: c */
    public final String f8046c;

    /* renamed from: d */
    public final String f8047d;

    /* renamed from: e */
    public final String f8048e;

    public C2870lp(String str, String str2, String str3, String str4, String str5) {
        this.f8044a = str;
        this.f8045b = str2;
        this.f8046c = str3;
        this.f8047d = str4;
        this.f8048e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2870lp) {
            C2870lp c2870lp = (C2870lp) obj;
            return C2628cq.m2563T(this.f8044a, c2870lp.f8044a) && C2628cq.m2563T(this.f8045b, c2870lp.f8045b) && C2628cq.m2563T(this.f8046c, c2870lp.f8046c) && C2628cq.m2563T(this.f8047d, c2870lp.f8047d) && C2628cq.m2563T(this.f8048e, c2870lp.f8048e);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8044a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f8045b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8046c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8047d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f8048e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
