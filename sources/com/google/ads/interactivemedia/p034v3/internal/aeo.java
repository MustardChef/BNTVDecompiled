package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aeo */
/* loaded from: classes2.dex */
final class aeo implements aep {

    /* renamed from: a */
    private final ByteBuffer f3623a;

    public aeo(ByteBuffer byteBuffer) {
        this.f3623a = byteBuffer.slice();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aep
    /* renamed from: a */
    public final long mo5720a() {
        return this.f3623a.capacity();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aep
    /* renamed from: b */
    public final void mo5719b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.f3623a) {
            int i2 = (int) j;
            this.f3623a.position(i2);
            this.f3623a.limit(i2 + i);
            slice = this.f3623a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            slice.position(0);
            messageDigest.update(slice);
        }
    }
}
