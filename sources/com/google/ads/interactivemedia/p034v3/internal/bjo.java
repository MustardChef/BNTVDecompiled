package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjo */
/* loaded from: classes2.dex */
final class bjo extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        String mo3584h = bkvVar.mo3584h();
        try {
            return UUID.fromString(mo3584h);
        } catch (IllegalArgumentException e) {
            String mo3586f = bkvVar.mo3586f();
            StringBuilder sb = new StringBuilder(String.valueOf(mo3584h).length() + 35 + String.valueOf(mo3586f).length());
            sb.append("Failed parsing '");
            sb.append(mo3584h);
            sb.append("' as UUID; at path ");
            sb.append(mo3586f);
            throw new bgt(sb.toString(), e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        UUID uuid = (UUID) obj;
        bkxVar.mo3554k(uuid == null ? null : uuid.toString());
    }
}
