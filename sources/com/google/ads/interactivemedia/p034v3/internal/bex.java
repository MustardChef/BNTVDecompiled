package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bex */
/* loaded from: classes2.dex */
public final class bex implements azb {

    /* renamed from: a */
    public static final int f5618a = bbp.f5397b;

    /* renamed from: b */
    private final bbm f5619b;

    public bex(byte[] bArr) throws GeneralSecurityException {
        if (!bbp.m4200a(f5618a)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.f5619b = new bbm(bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azb
    /* renamed from: a */
    public final byte[] mo3767a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.f5619b.m4202a(bfu.m3737b(12), bArr);
    }
}
