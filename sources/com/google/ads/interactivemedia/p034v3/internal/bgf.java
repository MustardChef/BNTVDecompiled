package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgf */
/* loaded from: classes2.dex */
final class bgf extends bgy {

    /* renamed from: a */
    final /* synthetic */ bgy f5677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bgf(bgy bgyVar) {
        this.f5677a = bgyVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        bkvVar.mo3583i();
        while (bkvVar.mo3576p()) {
            arrayList.add(Long.valueOf(((Number) this.f5677a.read(bkvVar)).longValue()));
        }
        bkvVar.mo3581k();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; i++) {
            atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
        }
        return atomicLongArray;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        bkxVar.mo3563b();
        int length = atomicLongArray.length();
        for (int i = 0; i < length; i++) {
            this.f5677a.write(bkxVar, Long.valueOf(atomicLongArray.get(i)));
        }
        bkxVar.mo3561d();
    }
}
