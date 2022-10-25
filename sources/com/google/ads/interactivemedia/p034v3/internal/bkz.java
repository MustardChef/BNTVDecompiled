package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkz */
/* loaded from: classes2.dex */
public final class bkz {

    /* renamed from: a */
    private final byte[] f5986a = new byte[256];

    /* renamed from: b */
    private int f5987b;

    /* renamed from: c */
    private int f5988c;

    public bkz(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f5986a[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.f5986a;
            byte b = bArr2[i3];
            i2 = (i2 + b + bArr[i3 % bArr.length]) & 255;
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
        }
        this.f5987b = 0;
        this.f5988c = 0;
    }

    /* renamed from: a */
    public final void m3539a(byte[] bArr) {
        int i = this.f5987b;
        int i2 = this.f5988c;
        for (int i3 = 0; i3 < 256; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.f5986a;
            byte b = bArr2[i];
            i2 = (i2 + b) & 255;
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + b) & 255] ^ bArr[i3]);
        }
        this.f5987b = i;
        this.f5988c = i2;
    }
}
