package com.google.ads.interactivemedia.p034v3.internal;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfw */
/* loaded from: classes2.dex */
final class bfw extends bfa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bfw(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bfa
    /* renamed from: b */
    public final int mo3734b() {
        return 24;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bfa
    /* renamed from: c */
    final int[] mo3733c(int[] iArr, int i) {
        int length = iArr.length;
        if (length != 6) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        bfa.m3777g(r0, this.f5628a);
        int[] iArr3 = {0, 0, 0, 0, iArr3[12], iArr3[13], iArr3[14], iArr3[15], 0, 0, 0, 0, iArr[0], iArr[1], iArr[2], iArr[3]};
        bfa.m3776h(iArr3);
        bfa.m3777g(iArr2, Arrays.copyOf(iArr3, 8));
        iArr2[12] = i;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }
}
