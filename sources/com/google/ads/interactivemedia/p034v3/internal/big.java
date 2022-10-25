package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.big */
/* loaded from: classes2.dex */
final class big extends bgy {

    /* renamed from: a */
    private final bgy f5790a;

    /* renamed from: b */
    private final bhz f5791b;

    public big(bgh bghVar, Type type, bgy bgyVar, bhz bhzVar) {
        this.f5790a = new bjb(bghVar, bgyVar, type);
        this.f5791b = bhzVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        Collection collection = (Collection) this.f5791b.mo3659a();
        bkvVar.mo3583i();
        while (bkvVar.mo3576p()) {
            collection.add(this.f5790a.read(bkvVar));
        }
        bkvVar.mo3581k();
        return collection;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        Collection<Object> collection = (Collection) obj;
        if (collection == null) {
            bkxVar.mo3558g();
            return;
        }
        bkxVar.mo3563b();
        for (Object obj2 : collection) {
            this.f5790a.write(bkxVar, obj2);
        }
        bkxVar.mo3561d();
    }
}
