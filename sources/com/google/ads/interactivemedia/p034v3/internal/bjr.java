package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjr */
/* loaded from: classes2.dex */
final class bjr extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(bkvVar.mo3584h(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        if (nextToken2 == null && nextToken3 == null) {
            return new Locale(nextToken);
        }
        if (nextToken3 == null) {
            return new Locale(nextToken, nextToken2);
        }
        return new Locale(nextToken, nextToken2, nextToken3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        Locale locale = (Locale) obj;
        bkxVar.mo3554k(locale == null ? null : locale.toString());
    }
}
