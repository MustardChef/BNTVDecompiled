package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfs */
/* loaded from: classes2.dex */
public final class bfs implements azs {

    /* renamed from: a */
    private final bcu f5665a;

    /* renamed from: b */
    private final int f5666b;

    public bfs(bcu bcuVar, int i) throws GeneralSecurityException {
        this.f5665a = bcuVar;
        this.f5666b = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        bcuVar.mo3742a(new byte[0], i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azs
    /* renamed from: a */
    public final byte[] mo3739a(byte[] bArr) throws GeneralSecurityException {
        return this.f5665a.mo3742a(bArr, this.f5666b);
    }
}
