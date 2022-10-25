package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjc */
/* loaded from: classes2.dex */
final class bjc extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        bkvVar.mo3583i();
        while (bkvVar.mo3576p()) {
            try {
                arrayList.add(Integer.valueOf(bkvVar.mo3590b()));
            } catch (NumberFormatException e) {
                throw new bgt(e);
            }
        }
        bkvVar.mo3581k();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
        bkxVar.mo3563b();
        int length = atomicIntegerArray.length();
        for (int i = 0; i < length; i++) {
            bkxVar.mo3557h(atomicIntegerArray.get(i));
        }
        bkxVar.mo3561d();
    }
}
