package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkd */
/* loaded from: classes2.dex */
final class bkd extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        try {
            return new AtomicInteger(bkvVar.mo3590b());
        } catch (NumberFormatException e) {
            throw new bgt(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        bkxVar.mo3557h(((AtomicInteger) obj).get());
    }
}
