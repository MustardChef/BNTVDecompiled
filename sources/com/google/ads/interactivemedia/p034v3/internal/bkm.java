package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkm */
/* loaded from: classes2.dex */
final class bkm extends bgy {

    /* renamed from: a */
    static final bgz f5945a = new bkn(1);

    /* renamed from: b */
    private final DateFormat f5946b = new SimpleDateFormat("MMM d, yyyy");

    private bkm() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    /* renamed from: a */
    public final Date read(bkv bkvVar) throws IOException {
        java.util.Date parse;
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        String mo3584h = bkvVar.mo3584h();
        try {
            synchronized (this) {
                parse = this.f5946b.parse(mo3584h);
            }
            return new Date(parse.getTime());
        } catch (ParseException e) {
            String mo3586f = bkvVar.mo3586f();
            StringBuilder sb = new StringBuilder(String.valueOf(mo3584h).length() + 39 + String.valueOf(mo3586f).length());
            sb.append("Failed parsing '");
            sb.append(mo3584h);
            sb.append("' as SQL Date; at path ");
            sb.append(mo3586f);
            throw new bgt(sb.toString(), e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            bkxVar.mo3558g();
            return;
        }
        synchronized (this) {
            format = this.f5946b.format((java.util.Date) date);
        }
        bkxVar.mo3554k(format);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bkm(byte[] bArr) {
    }
}
