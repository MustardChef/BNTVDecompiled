package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.bgy;
import com.google.ads.interactivemedia.p034v3.internal.bkv;
import com.google.ads.interactivemedia.p034v3.internal.bkx;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.by */
/* loaded from: classes2.dex */
final class C2507by extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public C2508bz read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        return new C2508bz(bkvVar.mo3584h());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public void write(bkx bkxVar, C2508bz c2508bz) throws IOException {
        if (c2508bz == null) {
            bkxVar.mo3558g();
        } else {
            bkxVar.mo3554k(c2508bz.getName());
        }
    }
}
