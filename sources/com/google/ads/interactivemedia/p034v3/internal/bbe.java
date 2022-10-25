package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbe */
/* loaded from: classes2.dex */
public final class bbe implements azb {

    /* renamed from: a */
    private static final byte[] f5386a = new byte[0];

    /* renamed from: b */
    private final bed f5387b;

    /* renamed from: c */
    private final azb f5388c;

    public bbe(bed bedVar, azb azbVar) {
        this.f5387b = bedVar;
        this.f5388c = azbVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azb
    /* renamed from: a */
    public final byte[] mo3767a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] mo3176ar = bae.m4240c(this.f5387b).mo3176ar();
        byte[] mo3767a = this.f5388c.mo3767a(mo3176ar, f5386a);
        byte[] mo3767a2 = ((azb) bae.m4236g(this.f5387b.m3934d(), mo3176ar, azb.class)).mo3767a(bArr, bArr2);
        int length = mo3767a.length;
        return ByteBuffer.allocate(length + 4 + mo3767a2.length).putInt(length).put(mo3767a).put(mo3767a2).array();
    }
}
