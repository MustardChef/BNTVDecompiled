package com.google.ads.interactivemedia.p034v3.internal;

import android.os.StrictMode;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqm */
/* loaded from: classes2.dex */
public final class aqm {
    /* renamed from: a */
    public static Object m4754a(atn atnVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return atnVar.mo1308a();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
