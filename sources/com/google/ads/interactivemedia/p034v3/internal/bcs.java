package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcs */
/* loaded from: classes2.dex */
final class bcs implements azs {

    /* renamed from: a */
    private final azw f5421a;

    /* renamed from: b */
    private final byte[] f5422b = {0};

    @Override // com.google.ads.interactivemedia.p034v3.internal.azs
    /* renamed from: a */
    public final byte[] mo3739a(byte[] bArr) throws GeneralSecurityException {
        int m4258d = this.f5421a.m4256b().m4258d();
        int i = ben.f5592c;
        if (m4258d != 0) {
            if (m4258d == i) {
                return bfo.m3753h(this.f5421a.m4256b().m4260b(), ((azs) this.f5421a.m4256b().m4261a()).mo3739a(bfo.m3753h(bArr, this.f5422b)));
            }
            return bfo.m3753h(this.f5421a.m4256b().m4260b(), ((azs) this.f5421a.m4256b().m4261a()).mo3739a(bArr));
        }
        throw null;
    }
}
