package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sp */
/* loaded from: classes2.dex */
public final class C3059sp {

    /* renamed from: a */
    public static final /* synthetic */ int f8852a = 0;

    /* renamed from: b */
    private static final AtomicLong f8853b = new AtomicLong();

    public C3059sp() {
    }

    public C3059sp(C2642dd c2642dd) {
        Uri uri = c2642dd.f7011a;
        Collections.emptyMap();
    }

    /* renamed from: a */
    public static long m1122a() {
        return f8853b.getAndIncrement();
    }
}
