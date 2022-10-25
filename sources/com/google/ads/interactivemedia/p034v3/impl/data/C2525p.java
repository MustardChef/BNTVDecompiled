package com.google.ads.interactivemedia.p034v3.impl.data;

import android.util.Log;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.p */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2525p {
    /* renamed from: a */
    public static void m5991a(String str) {
        if (m5987e(2)) {
            Log.e("IMASDK", str);
        }
    }

    /* renamed from: b */
    public static void m5990b(String str, Throwable th) {
        if (m5987e(2)) {
            Log.e("IMASDK", str, th);
        }
    }

    /* renamed from: c */
    public static void m5989c(String str) {
        if (m5987e(1)) {
            Log.i("IMASDK", str);
        }
    }

    /* renamed from: d */
    public static void m5988d(String str) {
        if (m5987e(2)) {
            Log.w("IMASDK", str);
        }
    }

    /* renamed from: e */
    private static boolean m5987e(int i) {
        return i + (-1) > 0;
    }
}
