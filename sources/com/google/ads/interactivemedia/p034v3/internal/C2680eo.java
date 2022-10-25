package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.eo */
/* loaded from: classes2.dex */
public final class C2680eo {

    /* renamed from: a */
    public final String f7138a;

    /* renamed from: b */
    public final C2962p f7139b;

    /* renamed from: c */
    public final C2962p f7140c;

    /* renamed from: d */
    public final int f7141d;

    /* renamed from: e */
    public final int f7142e;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2680eo(java.lang.String r3, com.google.ads.interactivemedia.p034v3.internal.C2962p r4, com.google.ads.interactivemedia.p034v3.internal.C2962p r5, int r6, int r7) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r1 = 1
            if (r6 == 0) goto La
            if (r7 != 0) goto Lb
            r7 = 0
        La:
            r0 = 1
        Lb:
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2687f(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L25
            r2.f7138a = r3
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2689d(r4)
            r2.f7139b = r4
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2689d(r5)
            r2.f7140c = r5
            r2.f7141d = r6
            r2.f7142e = r7
            return
        L25:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2680eo.<init>(java.lang.String, com.google.ads.interactivemedia.v3.internal.p, com.google.ads.interactivemedia.v3.internal.p, int, int):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2680eo c2680eo = (C2680eo) obj;
            if (this.f7141d == c2680eo.f7141d && this.f7142e == c2680eo.f7142e && this.f7138a.equals(c2680eo.f7138a) && this.f7139b.equals(c2680eo.f7139b) && this.f7140c.equals(c2680eo.f7140c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.f7141d + 527) * 31) + this.f7142e) * 31) + this.f7138a.hashCode()) * 31) + this.f7139b.hashCode()) * 31) + this.f7140c.hashCode();
    }
}
