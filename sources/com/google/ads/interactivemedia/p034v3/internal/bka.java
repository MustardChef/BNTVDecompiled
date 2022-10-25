package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bka */
/* loaded from: classes2.dex */
final class bka extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        try {
            int mo3590b = bkvVar.mo3590b();
            if (mo3590b > 255 || mo3590b < -128) {
                String mo3586f = bkvVar.mo3586f();
                StringBuilder sb = new StringBuilder(String.valueOf(mo3586f).length() + 51);
                sb.append("Lossy conversion from ");
                sb.append(mo3590b);
                sb.append(" to byte; at path ");
                sb.append(mo3586f);
                throw new bgt(sb.toString());
            }
            return Byte.valueOf((byte) mo3590b);
        } catch (NumberFormatException e) {
            throw new bgt(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        bkxVar.mo3555j((Number) obj);
    }
}
