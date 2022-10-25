package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjs */
/* loaded from: classes2.dex */
final class bjs extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    /* renamed from: a */
    public final bgm read(bkv bkvVar) throws IOException {
        if (bkvVar instanceof bin) {
            return ((bin) bkvVar).m3636d();
        }
        int mo3574r = bkvVar.mo3574r() - 1;
        if (mo3574r == 0) {
            bgk bgkVar = new bgk();
            bkvVar.mo3583i();
            while (bkvVar.mo3576p()) {
                bgkVar.m3713a(read(bkvVar));
            }
            bkvVar.mo3581k();
            return bgkVar;
        } else if (mo3574r == 2) {
            bgp bgpVar = new bgp();
            bkvVar.mo3582j();
            while (bkvVar.mo3576p()) {
                bgpVar.m3710b(bkvVar.mo3585g(), read(bkvVar));
            }
            bkvVar.mo3580l();
            return bgpVar;
        } else if (mo3574r != 5) {
            if (mo3574r != 6) {
                if (mo3574r != 7) {
                    if (mo3574r == 8) {
                        bkvVar.mo3579m();
                        return bgo.f5697a;
                    }
                    throw new IllegalArgumentException();
                }
                return new bgr(Boolean.valueOf(bkvVar.mo3575q()));
            }
            return new bgr(new bhq(bkvVar.mo3584h()));
        } else {
            return new bgr(bkvVar.mo3584h());
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    /* renamed from: b */
    public final void write(bkx bkxVar, bgm bgmVar) throws IOException {
        if (bgmVar == null || (bgmVar instanceof bgo)) {
            bkxVar.mo3558g();
        } else if (!(bgmVar instanceof bgr)) {
            if (!(bgmVar instanceof bgk)) {
                if (bgmVar instanceof bgp) {
                    bkxVar.mo3562c();
                    for (Map.Entry entry : ((bgp) bgmVar).m3711a()) {
                        bkxVar.mo3559f((String) entry.getKey());
                        write(bkxVar, (bgm) entry.getValue());
                    }
                    bkxVar.mo3560e();
                    return;
                }
                String valueOf = String.valueOf(bgmVar.getClass());
                String.valueOf(valueOf).length();
                throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(valueOf)));
            }
            bkxVar.mo3563b();
            Iterator it = ((bgk) bgmVar).iterator();
            while (it.hasNext()) {
                write(bkxVar, (bgm) it.next());
            }
            bkxVar.mo3561d();
        } else {
            bgr bgrVar = (bgr) bgmVar;
            if (bgrVar.m3705e()) {
                bkxVar.mo3555j(bgrVar.m3709a());
            } else if (bgrVar.m3706d()) {
                bkxVar.mo3553l(bgrVar.m3707c());
            } else {
                bkxVar.mo3554k(bgrVar.m3708b());
            }
        }
    }
}
