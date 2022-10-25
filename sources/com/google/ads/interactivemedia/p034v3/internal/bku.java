package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bku */
/* loaded from: classes2.dex */
final class bku extends bhp {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bhp
    /* renamed from: a */
    public final void mo3598a(bkv bkvVar) throws IOException {
        if (bkvVar instanceof bin) {
            ((bin) bkvVar).m3635n();
            return;
        }
        int i = bkvVar.f5961a;
        if (i == 0) {
            i = bkvVar.m3573s();
        }
        if (i == 13) {
            bkvVar.f5961a = 9;
        } else if (i == 12) {
            bkvVar.f5961a = 8;
        } else if (i == 14) {
            bkvVar.f5961a = 10;
        } else {
            String m3565a = bkw.m3565a(bkvVar.mo3574r());
            String m3572t = bkvVar.m3572t();
            StringBuilder sb = new StringBuilder(m3565a.length() + 24 + String.valueOf(m3572t).length());
            sb.append("Expected a name but was ");
            sb.append(m3565a);
            sb.append(m3572t);
            throw new IllegalStateException(sb.toString());
        }
    }
}
