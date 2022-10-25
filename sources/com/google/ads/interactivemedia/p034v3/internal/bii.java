package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bii */
/* loaded from: classes2.dex */
public final class bii extends bgy {

    /* renamed from: a */
    public static final bgz f5793a = new bih(0);

    /* renamed from: b */
    private final List f5794b;

    public bii() {
        ArrayList arrayList = new ArrayList();
        this.f5794b = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (bho.m3670b()) {
            arrayList.add(axn.m4376e(2, 2));
        }
    }

    /* renamed from: a */
    private final Date m3640a(bkv bkvVar) throws IOException {
        String mo3584h = bkvVar.mo3584h();
        synchronized (this.f5794b) {
            for (DateFormat dateFormat : this.f5794b) {
                try {
                    return dateFormat.parse(mo3584h);
                } catch (ParseException unused) {
                }
            }
            try {
                return bki.m3610a(mo3584h, new ParsePosition(0));
            } catch (ParseException e) {
                String mo3586f = bkvVar.mo3586f();
                StringBuilder sb = new StringBuilder(String.valueOf(mo3584h).length() + 35 + String.valueOf(mo3586f).length());
                sb.append("Failed parsing '");
                sb.append(mo3584h);
                sb.append("' as Date; at path ");
                sb.append(mo3586f);
                throw new bgt(sb.toString(), e);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        return m3640a(bkvVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            bkxVar.mo3558g();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f5794b.get(0);
        synchronized (this.f5794b) {
            format = dateFormat.format(date);
        }
        bkxVar.mo3554k(format);
    }
}
