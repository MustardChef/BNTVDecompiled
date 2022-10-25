package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgx */
/* loaded from: classes2.dex */
public final class bgx extends bgy {

    /* renamed from: a */
    final /* synthetic */ bgy f5708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bgx(bgy bgyVar) {
        this.f5708a = bgyVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        return this.f5708a.read(bkvVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, Object obj) throws IOException {
        if (obj == null) {
            bkxVar.mo3558g();
        } else {
            this.f5708a.write(bkxVar, obj);
        }
    }
}
