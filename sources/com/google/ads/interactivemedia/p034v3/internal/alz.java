package com.google.ads.interactivemedia.p034v3.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alz */
/* loaded from: classes2.dex */
final class alz implements Runnable {
    private alz() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ alz(byte[] bArr) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            ama.m5006b(MessageDigest.getInstance("MD5"));
            countDownLatch = ama.f4426b;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = ama.f4426b;
        } catch (Throwable th) {
            ama.f4426b.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
