package com.google.ads.interactivemedia.p034v3.internal;

import java.security.InvalidKeyException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bez */
/* loaded from: classes2.dex */
final class bez extends bfa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bez(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bfa
    /* renamed from: b */
    public final int mo3734b() {
        return 12;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bfa
    /* renamed from: c */
    final int[] mo3733c(int[] iArr, int i) {
        int length = iArr.length;
        if (length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        bfa.m3777g(iArr2, this.f5628a);
        iArr2[12] = i;
        System.arraycopy(iArr, 0, iArr2, 13, 3);
        return iArr2;
    }
}
