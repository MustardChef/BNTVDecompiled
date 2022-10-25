package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjf */
/* loaded from: classes2.dex */
final class bjf extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        int mo3574r = bkvVar.mo3574r();
        if (mo3574r == 9) {
            bkvVar.mo3579m();
            return null;
        } else if (mo3574r == 8) {
            return Boolean.toString(bkvVar.mo3575q());
        } else {
            return bkvVar.mo3584h();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        bkxVar.mo3554k((String) obj);
    }
}
