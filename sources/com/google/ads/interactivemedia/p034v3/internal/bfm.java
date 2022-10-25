package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfm */
/* loaded from: classes2.dex */
public final class bfm {

    /* renamed from: a */
    private final byte[] f5654a;

    private bfm(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        this.f5654a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i);
    }

    /* renamed from: a */
    public static bfm m3763a(byte[] bArr) {
        return new bfm(bArr, bArr.length);
    }

    /* renamed from: b */
    public final byte[] m3762b() {
        byte[] bArr = this.f5654a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
