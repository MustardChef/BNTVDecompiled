package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkp */
/* loaded from: classes2.dex */
final class bkp extends bgy {

    /* renamed from: a */
    static final bgz f5950a = new bkn(2);

    /* renamed from: b */
    private final bgy f5951b;

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        Date date = (Date) this.f5951b.read(bkvVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        this.f5951b.write(bkxVar, (Timestamp) obj);
    }
}
