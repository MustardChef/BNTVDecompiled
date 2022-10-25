package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaDrm;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.np */
/* loaded from: classes2.dex */
final class C2924np {
    /* renamed from: a */
    public static int m1579a(Throwable th) {
        return C2628cq.m2526h(C2628cq.m2525i(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
    }

    /* renamed from: b */
    public static boolean m1578b(Throwable th) {
        return th instanceof MediaDrm.MediaDrmStateException;
    }
}
