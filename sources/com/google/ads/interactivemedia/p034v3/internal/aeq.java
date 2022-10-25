package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aeq */
/* loaded from: classes2.dex */
final class aeq implements aep {

    /* renamed from: a */
    private final FileChannel f3624a;

    /* renamed from: b */
    private final long f3625b;

    /* renamed from: c */
    private final long f3626c;

    public aeq(FileChannel fileChannel, long j, long j2) {
        this.f3624a = fileChannel;
        this.f3625b = j;
        this.f3626c = j2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aep
    /* renamed from: a */
    public final long mo5720a() {
        return this.f3626c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aep
    /* renamed from: b */
    public final void mo5719b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f3624a.map(FileChannel.MapMode.READ_ONLY, this.f3625b + j, i);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
