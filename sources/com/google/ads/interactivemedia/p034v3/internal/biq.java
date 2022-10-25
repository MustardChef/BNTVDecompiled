package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.biq */
/* loaded from: classes2.dex */
final class biq extends bgy {

    /* renamed from: a */
    private final bgy f5810a;

    /* renamed from: b */
    private final bgy f5811b;

    /* renamed from: c */
    private final bhz f5812c;

    public biq(bgh bghVar, Type type, bgy bgyVar, Type type2, bgy bgyVar2, bhz bhzVar) {
        this.f5810a = new bjb(bghVar, bgyVar, type);
        this.f5811b = new bjb(bghVar, bgyVar2, type2);
        this.f5812c = bhzVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        int mo3574r = bkvVar.mo3574r();
        if (mo3574r == 9) {
            bkvVar.mo3579m();
            return null;
        }
        Map map = (Map) this.f5812c.mo3659a();
        if (mo3574r == 1) {
            bkvVar.mo3583i();
            while (bkvVar.mo3576p()) {
                bkvVar.mo3583i();
                Object read = this.f5810a.read(bkvVar);
                if (map.put(read, this.f5811b.read(bkvVar)) == null) {
                    bkvVar.mo3581k();
                } else {
                    String valueOf = String.valueOf(read);
                    String.valueOf(valueOf).length();
                    throw new bgt("duplicate key: ".concat(String.valueOf(valueOf)));
                }
            }
            bkvVar.mo3581k();
        } else {
            bkvVar.mo3582j();
            while (bkvVar.mo3576p()) {
                bhp.f5742a.mo3598a(bkvVar);
                Object read2 = this.f5810a.read(bkvVar);
                if (map.put(read2, this.f5811b.read(bkvVar)) != null) {
                    String valueOf2 = String.valueOf(read2);
                    String.valueOf(valueOf2).length();
                    throw new bgt("duplicate key: ".concat(String.valueOf(valueOf2)));
                }
            }
            bkvVar.mo3580l();
        }
        return map;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            bkxVar.mo3558g();
            return;
        }
        bkxVar.mo3562c();
        for (Map.Entry entry : map.entrySet()) {
            bkxVar.mo3559f(String.valueOf(entry.getKey()));
            this.f5811b.write(bkxVar, entry.getValue());
        }
        bkxVar.mo3560e();
    }
}
