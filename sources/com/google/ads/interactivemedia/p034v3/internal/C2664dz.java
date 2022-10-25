package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dz */
/* loaded from: classes2.dex */
final class C2664dz {

    /* renamed from: a */
    private final MediaCodec.CryptoInfo f7078a;

    /* renamed from: b */
    private final MediaCodec.CryptoInfo.Pattern f7079b = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ void m2457a(C2664dz c2664dz, int i, int i2) {
        c2664dz.f7079b.set(i, i2);
        c2664dz.f7078a.setPattern(c2664dz.f7079b);
    }
}
