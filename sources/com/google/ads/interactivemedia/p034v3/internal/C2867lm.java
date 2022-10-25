package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lm */
/* loaded from: classes2.dex */
public final class C2867lm {

    /* renamed from: a */
    public final String f8033a;

    /* renamed from: b */
    public final String f8034b;

    /* renamed from: c */
    public final String f8035c;

    public C2867lm(String str, String str2, String str3) {
        this.f8033a = str;
        this.f8034b = str2;
        this.f8035c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2867lm c2867lm = (C2867lm) obj;
            if (C2628cq.m2563T(this.f8033a, c2867lm.f8033a) && C2628cq.m2563T(this.f8034b, c2867lm.f8034b) && C2628cq.m2563T(this.f8035c, c2867lm.f8035c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f8033a.hashCode() * 31;
        String str = this.f8034b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8035c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
