package com.google.ads.interactivemedia.p034v3.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aet */
/* loaded from: classes2.dex */
final class aet extends aeu {

    /* renamed from: a */
    private final byte[] f3632a;

    public aet(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f3632a = bArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aeu, java.security.cert.Certificate
    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f3632a;
    }
}
