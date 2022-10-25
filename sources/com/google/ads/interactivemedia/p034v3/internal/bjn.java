package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.net.InetAddress;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjn */
/* loaded from: classes2.dex */
final class bjn extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        return InetAddress.getByName(bkvVar.mo3584h());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        InetAddress inetAddress = (InetAddress) obj;
        bkxVar.mo3554k(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
