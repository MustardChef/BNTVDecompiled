package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wj */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3161wj {
    /* renamed from: a */
    public static final C3158wg m740a(C3157wf c3157wf, C3159wh c3159wh) {
        int i;
        IOException iOException = c3159wh.f9296a;
        if ((iOException instanceof C2653do) && ((i = ((C2653do) iOException).f7052b) == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503)) {
            if (c3157wf.m744a(1)) {
                return new C3158wg(1, 300000L);
            }
            if (c3157wf.m744a(2)) {
                return new C3158wg(2, 60000L);
            }
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public static final int m739b(int i) {
        return i == 7 ? 6 : 3;
    }

    /* renamed from: c */
    public static final long m738c(C3159wh c3159wh) {
        Throwable th = c3159wh.f9296a;
        if ((th instanceof C2555ao) || (th instanceof FileNotFoundException) || (th instanceof C2651dm) || (th instanceof C3166wo)) {
            return C3282C.TIME_UNSET;
        }
        while (th != null) {
            if ((th instanceof C2639da) && ((C2639da) th).f6996a == 2008) {
                return C3282C.TIME_UNSET;
            }
            th = th.getCause();
        }
        return Math.min((c3159wh.f9297b - 1) * 1000, 5000);
    }

    /* renamed from: d */
    public static final C3156we m737d(Context context, Map map, int i, InterfaceC2598bn interfaceC2598bn, boolean z) {
        return new C3156we(context, map, 2000, interfaceC2598bn, true);
    }

    /* renamed from: e */
    public static C3157wf m736e(InterfaceC3142vr interfaceC3142vr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int d = interfaceC3142vr.mo836d();
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            if (interfaceC3142vr.mo799s(i2, elapsedRealtime)) {
                i++;
            }
        }
        return new C3157wf(1, 0, d, i);
    }

    /* renamed from: f */
    public static final InterfaceC3100uc m735f(InterfaceC3100uc... interfaceC3100ucArr) {
        return new C3047sd(interfaceC3100ucArr);
    }
}
