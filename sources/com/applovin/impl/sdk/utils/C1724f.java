package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.applovin.impl.sdk.utils.f */
/* loaded from: classes.dex */
public class C1724f {
    /* renamed from: a */
    public static Point m6279a(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (m6277b()) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
        }
        return point;
    }

    /* renamed from: a */
    public static void m6280a() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m6278a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* renamed from: b */
    public static boolean m6277b() {
        return Build.VERSION.SDK_INT >= 17;
    }

    /* renamed from: c */
    public static boolean m6276c() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* renamed from: d */
    public static boolean m6275d() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: e */
    public static boolean m6274e() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: f */
    public static boolean m6273f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: g */
    public static boolean m6272g() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* renamed from: h */
    public static boolean m6271h() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
