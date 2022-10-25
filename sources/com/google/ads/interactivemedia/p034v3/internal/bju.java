package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.BitSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bju */
/* loaded from: classes2.dex */
final class bju extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        BitSet bitSet = new BitSet();
        bkvVar.mo3583i();
        int mo3574r = bkvVar.mo3574r();
        int i = 0;
        while (mo3574r != 2) {
            int i2 = mo3574r - 1;
            if (i2 == 5 || i2 == 6) {
                int mo3590b = bkvVar.mo3590b();
                if (mo3590b != 0) {
                    if (mo3590b != 1) {
                        String mo3586f = bkvVar.mo3586f();
                        StringBuilder sb = new StringBuilder(String.valueOf(mo3586f).length() + 59);
                        sb.append("Invalid bitset value ");
                        sb.append(mo3590b);
                        sb.append(", expected 0 or 1; at path ");
                        sb.append(mo3586f);
                        throw new bgt(sb.toString());
                    }
                    bitSet.set(i);
                    i++;
                    mo3574r = bkvVar.mo3574r();
                } else {
                    continue;
                    i++;
                    mo3574r = bkvVar.mo3574r();
                }
            } else if (i2 == 7) {
                if (!bkvVar.mo3575q()) {
                    i++;
                    mo3574r = bkvVar.mo3574r();
                }
                bitSet.set(i);
                i++;
                mo3574r = bkvVar.mo3574r();
            } else {
                String m3565a = bkw.m3565a(mo3574r);
                String mo3587e = bkvVar.mo3587e();
                StringBuilder sb2 = new StringBuilder(m3565a.length() + 37 + String.valueOf(mo3587e).length());
                sb2.append("Invalid bitset value type: ");
                sb2.append(m3565a);
                sb2.append("; at path ");
                sb2.append(mo3587e);
                throw new bgt(sb2.toString());
            }
        }
        bkvVar.mo3581k();
        return bitSet;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        bkxVar.mo3563b();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            bkxVar.mo3557h(bitSet.get(i) ? 1L : 0L);
        }
        bkxVar.mo3561d();
    }
}
