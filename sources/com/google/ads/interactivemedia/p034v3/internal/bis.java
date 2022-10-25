package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bis */
/* loaded from: classes2.dex */
public final class bis extends bgy {

    /* renamed from: a */
    private static final bgz f5814a = m3626b(bgv.LAZILY_PARSED_NUMBER);

    /* renamed from: b */
    private final bgw f5815b;

    private bis(bgw bgwVar) {
        this.f5815b = bgwVar;
    }

    /* renamed from: a */
    public static bgz m3627a(bgw bgwVar) {
        return bgwVar == bgv.LAZILY_PARSED_NUMBER ? f5814a : m3626b(bgwVar);
    }

    /* renamed from: b */
    private static bgz m3626b(bgw bgwVar) {
        return new bir(new bis(bgwVar));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        int mo3574r = bkvVar.mo3574r();
        int i = mo3574r - 1;
        if (i == 5 || i == 6) {
            return this.f5815b.mo3700a(bkvVar);
        }
        if (i != 8) {
            String m3565a = bkw.m3565a(mo3574r);
            String mo3587e = bkvVar.mo3587e();
            StringBuilder sb = new StringBuilder(m3565a.length() + 33 + String.valueOf(mo3587e).length());
            sb.append("Expecting number, got: ");
            sb.append(m3565a);
            sb.append("; at path ");
            sb.append(mo3587e);
            throw new bgt(sb.toString());
        }
        bkvVar.mo3579m();
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        bkxVar.mo3555j((Number) obj);
    }
}
