package com.google.ads.interactivemedia.p034v3.internal;

import android.system.ErrnoException;
import android.system.OsConstants;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dj */
/* loaded from: classes2.dex */
final class C2648dj {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m2478b(Throwable th) {
        return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
    }
}
