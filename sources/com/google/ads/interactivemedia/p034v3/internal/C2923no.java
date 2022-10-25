package com.google.ads.interactivemedia.p034v3.internal;

import android.media.DeniedByServerException;
import android.media.NotProvisionedException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.no */
/* loaded from: classes2.dex */
final class C2923no {
    /* renamed from: a */
    public static boolean m1581a(Throwable th) {
        return th instanceof DeniedByServerException;
    }

    /* renamed from: b */
    public static boolean m1580b(Throwable th) {
        return th instanceof NotProvisionedException;
    }
}
