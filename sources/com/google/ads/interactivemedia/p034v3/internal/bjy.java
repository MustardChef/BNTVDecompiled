package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjy */
/* loaded from: classes2.dex */
final class bjy extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        int mo3574r = bkvVar.mo3574r();
        if (mo3574r == 9) {
            bkvVar.mo3579m();
            return null;
        } else if (mo3574r == 6) {
            return Boolean.valueOf(Boolean.parseBoolean(bkvVar.mo3584h()));
        } else {
            return Boolean.valueOf(bkvVar.mo3575q());
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        bkxVar.mo3556i((Boolean) obj);
    }
}
