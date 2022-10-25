package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ea */
/* loaded from: classes2.dex */
public final class C2666ea {

    /* renamed from: a */
    public byte[] f7081a;

    /* renamed from: b */
    public byte[] f7082b;

    /* renamed from: c */
    public int f7083c;

    /* renamed from: d */
    public int[] f7084d;

    /* renamed from: e */
    public int[] f7085e;

    /* renamed from: f */
    public int f7086f;

    /* renamed from: g */
    public int f7087g;

    /* renamed from: h */
    public int f7088h;

    /* renamed from: i */
    private final MediaCodec.CryptoInfo f7089i;

    /* renamed from: j */
    private final C2664dz f7090j;

    public C2666ea() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f7089i = cryptoInfo;
        this.f7090j = C2628cq.f6961a >= 24 ? new C2664dz(cryptoInfo) : null;
    }

    /* renamed from: a */
    public final MediaCodec.CryptoInfo m2451a() {
        return this.f7089i;
    }

    /* renamed from: b */
    public final void m2450b(int i) {
        if (i == 0) {
            return;
        }
        if (this.f7084d == null) {
            int[] iArr = new int[1];
            this.f7084d = iArr;
            this.f7089i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f7084d;
        iArr2[0] = iArr2[0] + i;
    }

    /* renamed from: c */
    public final void m2449c(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f7086f = i;
        this.f7084d = iArr;
        this.f7085e = iArr2;
        this.f7082b = bArr;
        this.f7081a = bArr2;
        this.f7083c = i2;
        this.f7087g = i3;
        this.f7088h = i4;
        this.f7089i.numSubSamples = i;
        this.f7089i.numBytesOfClearData = iArr;
        this.f7089i.numBytesOfEncryptedData = iArr2;
        this.f7089i.key = bArr;
        this.f7089i.iv = bArr2;
        this.f7089i.mode = i2;
        if (C2628cq.f6961a >= 24) {
            C2664dz c2664dz = this.f7090j;
            C2616ce.m2689d(c2664dz);
            C2664dz.m2457a(c2664dz, i3, i4);
        }
    }
}
