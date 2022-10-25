package com.google.ads.interactivemedia.p034v3.impl.data;

import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.m */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2522m {
    /* renamed from: a */
    public static Application m5993a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m5992b(Context context, TestingConfiguration testingConfiguration) {
        if (testingConfiguration == null || !testingConfiguration.forceTvMode()) {
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
        }
        return true;
    }
}
