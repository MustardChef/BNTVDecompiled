package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axu */
/* loaded from: classes2.dex */
final class axu extends axt {

    /* renamed from: a */
    final AtomicIntegerFieldUpdater f5283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public axu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        this.f5283a = atomicIntegerFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.axt
    /* renamed from: a */
    public final int mo4347a(axw axwVar) {
        return this.f5283a.decrementAndGet(axwVar);
    }
}
