package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bko */
/* loaded from: classes2.dex */
final class bko extends bgy {

    /* renamed from: a */
    static final bgz f5948a = new bkn(0);

    /* renamed from: b */
    private final DateFormat f5949b = new SimpleDateFormat("hh:mm:ss a");

    private bko() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    /* renamed from: a */
    public final Time read(bkv bkvVar) throws IOException {
        Time time;
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        String mo3584h = bkvVar.mo3584h();
        try {
            synchronized (this) {
                time = new Time(this.f5949b.parse(mo3584h).getTime());
            }
            return time;
        } catch (ParseException e) {
            String mo3586f = bkvVar.mo3586f();
            StringBuilder sb = new StringBuilder(String.valueOf(mo3584h).length() + 39 + String.valueOf(mo3586f).length());
            sb.append("Failed parsing '");
            sb.append(mo3584h);
            sb.append("' as SQL Time; at path ");
            sb.append(mo3586f);
            throw new bgt(sb.toString(), e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        String format;
        Time time = (Time) obj;
        if (time == null) {
            bkxVar.mo3558g();
            return;
        }
        synchronized (this) {
            format = this.f5949b.format((Date) time);
        }
        bkxVar.mo3554k(format);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bko(byte[] bArr) {
    }
}
