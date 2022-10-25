package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rd */
/* loaded from: classes2.dex */
public final class C3020rd extends Exception {

    /* renamed from: a */
    public final String f8683a;

    /* renamed from: b */
    public final boolean f8684b;

    /* renamed from: c */
    public final C3019rc f8685c;

    /* renamed from: d */
    public final String f8686d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C3020rd(com.google.ads.interactivemedia.p034v3.internal.C2962p r11, java.lang.Throwable r12, boolean r13, int r14) {
        /*
            r10 = this;
            java.lang.String r0 = java.lang.String.valueOf(r11)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 36
            r2.<init>(r1)
            java.lang.String r1 = "Decoder init failed: ["
            r2.append(r1)
            r2.append(r14)
            java.lang.String r1 = "], "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r6 = r11.f8372l
            int r11 = java.lang.Math.abs(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r0 = 75
            r14.<init>(r0)
            java.lang.String r0 = "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_"
            r14.append(r0)
            java.lang.String r0 = "neg_"
            r14.append(r0)
            r14.append(r11)
            java.lang.String r4 = r2.toString()
            java.lang.String r9 = r14.toString()
            r8 = 0
            r3 = r10
            r5 = r12
            r7 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3020rd.<init>(com.google.ads.interactivemedia.v3.internal.p, java.lang.Throwable, boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ C3020rd m1252a(C3020rd c3020rd, C3020rd c3020rd2) {
        return new C3020rd(c3020rd.getMessage(), c3020rd.getCause(), c3020rd.f8683a, c3020rd.f8684b, c3020rd.f8685c, c3020rd.f8686d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C3020rd(com.google.ads.interactivemedia.p034v3.internal.C2962p r8, java.lang.Throwable r9, boolean r10, com.google.ads.interactivemedia.p034v3.internal.C3019rc r11) {
        /*
            r7 = this;
            java.lang.String r0 = r11.f8676a
            java.lang.String r1 = java.lang.String.valueOf(r8)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r3 = r3 + 23
            int r3 = r3 + r4
            r6.<init>(r3)
            java.lang.String r3 = "Decoder init failed: "
            r6.append(r3)
            r6.append(r0)
            java.lang.String r0 = ", "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            java.lang.String r3 = r8.f8372l
            int r0 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            r4 = 0
            r6 = 21
            if (r0 < r6) goto L48
            boolean r0 = r9 instanceof android.media.MediaCodec.CodecException
            if (r0 == 0) goto L48
            r0 = r9
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            java.lang.String r0 = r0.getDiagnosticInfo()
            r6 = r0
            goto L49
        L48:
            r6 = r4
        L49:
            r0 = r7
            r2 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3020rd.<init>(com.google.ads.interactivemedia.v3.internal.p, java.lang.Throwable, boolean, com.google.ads.interactivemedia.v3.internal.rc):void");
    }

    private C3020rd(String str, Throwable th, String str2, boolean z, C3019rc c3019rc, String str3) {
        super(str, th);
        this.f8683a = str2;
        this.f8684b = z;
        this.f8685c = c3019rc;
        this.f8686d = str3;
    }
}
