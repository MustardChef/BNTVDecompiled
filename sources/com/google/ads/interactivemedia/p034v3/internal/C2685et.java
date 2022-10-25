package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.et */
/* loaded from: classes2.dex */
public final class C2685et extends C2556ap {

    /* renamed from: c */
    public final int f7176c;

    /* renamed from: d */
    public final String f7177d;

    /* renamed from: e */
    public final int f7178e;

    /* renamed from: f */
    public final C2962p f7179f;

    /* renamed from: g */
    public final int f7180g;

    /* renamed from: h */
    public final C2547ai f7181h;

    /* renamed from: i */
    final boolean f7182i;

    private C2685et(int i, Throwable th, int i2) {
        this(i, th, i2, null, -1, null, 4, false);
    }

    /* renamed from: b */
    public static C2685et m2397b(Throwable th, String str, int i, C2962p c2962p, int i2, boolean z, int i3) {
        return new C2685et(1, th, i3, str, i, c2962p, c2962p == null ? 4 : i2, z);
    }

    /* renamed from: c */
    public static C2685et m2396c(IOException iOException, int i) {
        return new C2685et(0, iOException, i);
    }

    /* renamed from: d */
    public static C2685et m2395d(RuntimeException runtimeException, int i) {
        return new C2685et(2, runtimeException, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final C2685et m2398a(C2547ai c2547ai) {
        String message = getMessage();
        int i = C2628cq.f6961a;
        return new C2685et(message, getCause(), this.f4817a, this.f7176c, this.f7177d, this.f7178e, this.f7179f, this.f7180g, c2547ai, this.f4818b, this.f7182i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private C2685et(int r14, java.lang.Throwable r15, int r16, java.lang.String r17, int r18, com.google.ads.interactivemedia.p034v3.internal.C2962p r19, int r20, boolean r21) {
        /*
            r13 = this;
            r4 = r14
            if (r4 == 0) goto L56
            r0 = 1
            if (r4 == r0) goto Ld
            java.lang.String r0 = "Unexpected runtime error"
            r6 = r17
            r7 = r18
            goto L5c
        Ld:
            java.lang.String r0 = java.lang.String.valueOf(r19)
            java.lang.String r1 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.m2571L(r20)
            java.lang.String r2 = java.lang.String.valueOf(r17)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r2 = r2 + 53
            int r2 = r2 + r3
            int r3 = r1.length()
            int r2 = r2 + r3
            r5.<init>(r2)
            r6 = r17
            r5.append(r6)
            java.lang.String r2 = " error, index="
            r5.append(r2)
            r7 = r18
            r5.append(r7)
            java.lang.String r2 = ", format="
            r5.append(r2)
            r5.append(r0)
            java.lang.String r0 = ", format_supported="
            r5.append(r0)
            r5.append(r1)
            java.lang.String r0 = r5.toString()
            goto L5c
        L56:
            r6 = r17
            r7 = r18
            java.lang.String r0 = "Source error"
        L5c:
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L87
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = r2 + 2
            int r2 = r2 + 4
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = ": "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
        L87:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r2 = r15
            r3 = r16
            r4 = r14
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r12 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2685et.<init>(int, java.lang.Throwable, int, java.lang.String, int, com.google.ads.interactivemedia.v3.internal.p, int, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private C2685et(java.lang.String r9, java.lang.Throwable r10, int r11, int r12, java.lang.String r13, int r14, com.google.ads.interactivemedia.p034v3.internal.C2962p r15, int r16, com.google.ads.interactivemedia.p034v3.internal.C2547ai r17, long r18, boolean r20) {
        /*
            r8 = this;
            r6 = r8
            r7 = r20
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r18
            r0.<init>(r1, r2, r3, r4)
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L17
            r2 = r12
            if (r2 != r1) goto L15
            r2 = 1
            goto L18
        L15:
            r3 = 0
            goto L19
        L17:
            r2 = r12
        L18:
            r3 = 1
        L19:
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2687f(r3)
            if (r10 != 0) goto L1f
            goto L20
        L1f:
            r0 = 1
        L20:
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2687f(r0)
            r6.f7176c = r2
            r0 = r13
            r6.f7177d = r0
            r0 = r14
            r6.f7178e = r0
            r0 = r15
            r6.f7179f = r0
            r0 = r16
            r6.f7180g = r0
            r0 = r17
            r6.f7181h = r0
            r6.f7182i = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2685et.<init>(java.lang.String, java.lang.Throwable, int, int, java.lang.String, int, com.google.ads.interactivemedia.v3.internal.p, int, com.google.ads.interactivemedia.v3.internal.ai, long, boolean):void");
    }
}
