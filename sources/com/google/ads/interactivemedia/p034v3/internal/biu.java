package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.biu */
/* loaded from: classes2.dex */
public final class biu extends bgy {

    /* renamed from: a */
    private static final bgz f5817a = m3624b(bgv.DOUBLE);

    /* renamed from: b */
    private final bgh f5818b;

    /* renamed from: c */
    private final bgw f5819c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ biu(bgh bghVar, bgw bgwVar) {
        this.f5818b = bghVar;
        this.f5819c = bgwVar;
    }

    /* renamed from: a */
    public static bgz m3625a(bgw bgwVar) {
        return bgwVar == bgv.DOUBLE ? f5817a : m3624b(bgwVar);
    }

    /* renamed from: b */
    private static bgz m3624b(bgw bgwVar) {
        return new bit(bgwVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final Object read(bkv bkvVar) throws IOException {
        int mo3574r = bkvVar.mo3574r() - 1;
        if (mo3574r == 0) {
            ArrayList arrayList = new ArrayList();
            bkvVar.mo3583i();
            while (bkvVar.mo3576p()) {
                arrayList.add(read(bkvVar));
            }
            bkvVar.mo3581k();
            return arrayList;
        } else if (mo3574r == 2) {
            bhy bhyVar = new bhy();
            bkvVar.mo3582j();
            while (bkvVar.mo3576p()) {
                bhyVar.put(bkvVar.mo3585g(), read(bkvVar));
            }
            bkvVar.mo3580l();
            return bhyVar;
        } else if (mo3574r != 5) {
            if (mo3574r != 6) {
                if (mo3574r != 7) {
                    if (mo3574r == 8) {
                        bkvVar.mo3579m();
                        return null;
                    }
                    throw new IllegalStateException();
                }
                return Boolean.valueOf(bkvVar.mo3575q());
            }
            return this.f5819c.mo3700a(bkvVar);
        } else {
            return bkvVar.mo3584h();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, Object obj) throws IOException {
        if (obj == null) {
            bkxVar.mo3558g();
            return;
        }
        bgy m3727b = this.f5818b.m3727b(obj.getClass());
        if (m3727b instanceof biu) {
            bkxVar.mo3562c();
            bkxVar.mo3560e();
            return;
        }
        m3727b.write(bkxVar, obj);
    }
}
