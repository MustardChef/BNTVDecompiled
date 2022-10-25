package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bif */
/* loaded from: classes2.dex */
public final class bif extends bgy {

    /* renamed from: a */
    public static final bgz f5787a = new bih(1);

    /* renamed from: b */
    private final Class f5788b;

    /* renamed from: c */
    private final bgy f5789c;

    public bif(bgh bghVar, bgy bgyVar, Class cls) {
        this.f5789c = new bjb(bghVar, bgyVar, cls);
        this.f5788b = cls;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bkvVar.mo3583i();
        while (bkvVar.mo3576p()) {
            arrayList.add(this.f5789c.read(bkvVar));
        }
        bkvVar.mo3581k();
        int size = arrayList.size();
        Object newInstance = Array.newInstance(this.f5788b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, Object obj) throws IOException {
        if (obj == null) {
            bkxVar.mo3558g();
            return;
        }
        bkxVar.mo3563b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f5789c.write(bkxVar, Array.get(obj, i));
        }
        bkxVar.mo3561d();
    }
}
