package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bge */
/* loaded from: classes2.dex */
final class bge extends bgy {

    /* renamed from: a */
    final /* synthetic */ bgy f5676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bge(bgy bgyVar) {
        this.f5676a = bgyVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        return new AtomicLong(((Number) this.f5676a.read(bkvVar)).longValue());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        this.f5676a.write(bkxVar, Long.valueOf(((AtomicLong) obj).get()));
    }
}
