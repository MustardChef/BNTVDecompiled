package com.google.ads.interactivemedia.p034v3.internal;

import java.sql.Date;
import java.sql.Timestamp;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bks */
/* loaded from: classes2.dex */
public final class bks {

    /* renamed from: a */
    public static final boolean f5952a;

    /* renamed from: b */
    public static final bik f5953b;

    /* renamed from: c */
    public static final bik f5954c;

    /* renamed from: d */
    public static final bgz f5955d;

    /* renamed from: e */
    public static final bgz f5956e;

    /* renamed from: f */
    public static final bgz f5957f;

    static {
        boolean z;
        bgz bgzVar;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f5952a = z;
        if (z) {
            f5953b = new bkq(Date.class);
            f5954c = new bkr(Timestamp.class);
            f5955d = bkm.f5945a;
            f5956e = bko.f5948a;
            bgzVar = bkp.f5950a;
        } else {
            bgzVar = null;
            f5953b = null;
            f5954c = null;
            f5955d = null;
            f5956e = null;
        }
        f5957f = bgzVar;
    }
}
