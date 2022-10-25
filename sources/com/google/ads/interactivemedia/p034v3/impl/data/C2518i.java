package com.google.ads.interactivemedia.p034v3.impl.data;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.internal.agc;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.i */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2518i {
    /* renamed from: a */
    public static float m6000a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* renamed from: b */
    public static String m5999b(View view) {
        if (Build.VERSION.SDK_INT < 19 || view.isAttachedToWindow()) {
            int visibility = view.getVisibility();
            if (visibility != 0) {
                return visibility != 4 ? visibility != 8 ? "viewNotVisible" : "viewGone" : "viewInvisible";
            } else if (view.getAlpha() == 0.0f) {
                return "viewAlphaZero";
            } else {
                return null;
            }
        }
        return "notAttached";
    }

    /* renamed from: c */
    public static void m5998c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: d */
    public static void m5997d(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: e */
    public static void m5996e(String str, Exception exc) {
        agc.f3950a.booleanValue();
        Log.e("OMIDLIB", str, exc);
    }
}
