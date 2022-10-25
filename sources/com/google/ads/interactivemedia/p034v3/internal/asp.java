package com.google.ads.interactivemedia.p034v3.internal;

import java.io.File;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asp */
/* loaded from: classes2.dex */
public final class asp {

    /* renamed from: a */
    private final apk f4997a;

    /* renamed from: b */
    private final File f4998b;

    /* renamed from: c */
    private final File f4999c;

    /* renamed from: d */
    private final File f5000d;

    /* renamed from: e */
    private byte[] f5001e;

    public asp(apk apkVar, File file, File file2, File file3) {
        this.f4997a = apkVar;
        this.f4998b = file;
        this.f4999c = file3;
        this.f5000d = file2;
    }

    /* renamed from: a */
    public final apk m4673a() {
        return this.f4997a;
    }

    /* renamed from: b */
    public final File m4672b() {
        return this.f4999c;
    }

    /* renamed from: c */
    public final File m4671c() {
        return this.f4998b;
    }

    /* renamed from: d */
    public final boolean m4670d() {
        return this.f4997a.m4828b() - (System.currentTimeMillis() / 1000) < 3600;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] m4669e() {
        /*
            r3 = this;
            byte[] r0 = r3.f5001e
            r1 = 0
            if (r0 != 0) goto L27
            java.io.File r0 = r3.f5000d
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            com.google.ads.interactivemedia.v3.internal.bls r0 = com.google.ads.interactivemedia.p034v3.internal.bls.m3501w(r2)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L21
            byte[] r0 = r0.m3509C()     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L21
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            goto L25
        L18:
            r0 = move-exception
            r1 = r2
            goto L1c
        L1b:
            r0 = move-exception
        L1c:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            throw r0
        L20:
            r2 = r1
        L21:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            r0 = r1
        L25:
            r3.f5001e = r0
        L27:
            byte[] r0 = r3.f5001e
            if (r0 != 0) goto L2c
            return r1
        L2c:
            int r1 = r0.length
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.asp.m4669e():byte[]");
    }
}
