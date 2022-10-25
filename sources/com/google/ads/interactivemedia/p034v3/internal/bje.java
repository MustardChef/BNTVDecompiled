package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bje */
/* loaded from: classes2.dex */
final class bje extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        String mo3584h = bkvVar.mo3584h();
        if (mo3584h.length() != 1) {
            String mo3586f = bkvVar.mo3586f();
            StringBuilder sb = new StringBuilder(String.valueOf(mo3584h).length() + 31 + String.valueOf(mo3586f).length());
            sb.append("Expecting character, got: ");
            sb.append(mo3584h);
            sb.append("; at ");
            sb.append(mo3586f);
            throw new bgt(sb.toString());
        }
        return Character.valueOf(mo3584h.charAt(0));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        Character ch = (Character) obj;
        bkxVar.mo3554k(ch == null ? null : ch.toString());
    }
}
