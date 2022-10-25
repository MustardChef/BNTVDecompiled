package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bck */
/* loaded from: classes2.dex */
public final class bck {

    /* renamed from: a */
    private final azb f5417a;

    /* renamed from: b */
    private final aze f5418b;

    public bck(azb azbVar) {
        this.f5417a = azbVar;
        this.f5418b = null;
    }

    public bck(aze azeVar) {
        this.f5417a = null;
        this.f5418b = azeVar;
    }

    /* renamed from: a */
    public final byte[] m4183a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        azb azbVar = this.f5417a;
        return azbVar != null ? azbVar.mo3767a(bArr, bArr2) : this.f5418b.mo3781a(bArr, bArr2);
    }
}
