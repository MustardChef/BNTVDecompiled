package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgg */
/* loaded from: classes2.dex */
final class bgg<T> extends bgy<T> {

    /* renamed from: a */
    private bgy f5678a;

    /* renamed from: a */
    public final void m3729a(bgy bgyVar) {
        if (this.f5678a != null) {
            throw new AssertionError();
        }
        this.f5678a = bgyVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final T read(bkv bkvVar) throws IOException {
        bgy bgyVar = this.f5678a;
        if (bgyVar == null) {
            throw new IllegalStateException();
        }
        return (T) bgyVar.read(bkvVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, T t) throws IOException {
        bgy bgyVar = this.f5678a;
        if (bgyVar == null) {
            throw new IllegalStateException();
        }
        bgyVar.write(bkxVar, t);
    }
}
