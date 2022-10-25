package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgb */
/* loaded from: classes2.dex */
public final class bgb extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        return Double.valueOf(bkvVar.mo3591a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            bkxVar.mo3558g();
            return;
        }
        bgh.m3721h(number.doubleValue());
        bkxVar.mo3555j(number);
    }
}
