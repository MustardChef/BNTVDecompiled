package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjq */
/* loaded from: classes2.dex */
final class bjq extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        bkvVar.mo3582j();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (bkvVar.mo3574r() != 4) {
            String mo3585g = bkvVar.mo3585g();
            int mo3590b = bkvVar.mo3590b();
            if ("year".equals(mo3585g)) {
                i = mo3590b;
            } else if ("month".equals(mo3585g)) {
                i2 = mo3590b;
            } else if ("dayOfMonth".equals(mo3585g)) {
                i3 = mo3590b;
            } else if ("hourOfDay".equals(mo3585g)) {
                i4 = mo3590b;
            } else if ("minute".equals(mo3585g)) {
                i5 = mo3590b;
            } else if ("second".equals(mo3585g)) {
                i6 = mo3590b;
            }
        }
        bkvVar.mo3580l();
        return new GregorianCalendar(i, i2, i3, i4, i5, i6);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (calendar == null) {
            bkxVar.mo3558g();
            return;
        }
        bkxVar.mo3562c();
        bkxVar.mo3559f("year");
        bkxVar.mo3557h(calendar.get(1));
        bkxVar.mo3559f("month");
        bkxVar.mo3557h(calendar.get(2));
        bkxVar.mo3559f("dayOfMonth");
        bkxVar.mo3557h(calendar.get(5));
        bkxVar.mo3559f("hourOfDay");
        bkxVar.mo3557h(calendar.get(11));
        bkxVar.mo3559f("minute");
        bkxVar.mo3557h(calendar.get(12));
        bkxVar.mo3559f("second");
        bkxVar.mo3557h(calendar.get(13));
        bkxVar.mo3560e();
    }
}
