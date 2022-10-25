package com.google.ads.interactivemedia.p034v3.internal;

import java.security.SecureRandom;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfu */
/* loaded from: classes2.dex */
public final class bfu {

    /* renamed from: a */
    private static final ThreadLocal f5667a = new bft();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ SecureRandom m3738a() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    /* renamed from: b */
    public static byte[] m3737b(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) f5667a.get()).nextBytes(bArr);
        return bArr;
    }
}
