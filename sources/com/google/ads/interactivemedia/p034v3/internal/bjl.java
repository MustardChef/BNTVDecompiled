package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.net.URL;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjl */
/* loaded from: classes2.dex */
final class bjl extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        String mo3584h = bkvVar.mo3584h();
        if ("null".equals(mo3584h)) {
            return null;
        }
        return new URL(mo3584h);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        URL url = (URL) obj;
        bkxVar.mo3554k(url == null ? null : url.toExternalForm());
    }
}
