package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfi */
/* loaded from: classes2.dex */
public final class bfi implements azb {

    /* renamed from: a */
    private final bfn f5642a;

    /* renamed from: b */
    private final azs f5643b;

    public bfi(bfn bfnVar, azs azsVar) {
        this.f5642a = bfnVar;
        this.f5643b = azsVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azb
    /* renamed from: a */
    public final byte[] mo3767a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] mo3761a = this.f5642a.mo3761a(bArr);
        return bfo.m3753h(mo3761a, this.f5643b.mo3739a(bfo.m3753h(bArr2, mo3761a, Arrays.copyOf(ByteBuffer.allocate(8).putLong(0L).array(), 8))));
    }
}
