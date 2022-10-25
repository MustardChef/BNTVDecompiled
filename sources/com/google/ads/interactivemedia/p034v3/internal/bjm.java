package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjm */
/* loaded from: classes2.dex */
final class bjm extends bgy {
    /* renamed from: a */
    public static final URI m3617a(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        try {
            String mo3584h = bkvVar.mo3584h();
            if ("null".equals(mo3584h)) {
                return null;
            }
            return new URI(mo3584h);
        } catch (URISyntaxException e) {
            throw new bgn(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        return m3617a(bkvVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        URI uri = (URI) obj;
        bkxVar.mo3554k(uri == null ? null : uri.toASCIIString());
    }
}
