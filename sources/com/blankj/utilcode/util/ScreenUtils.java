package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.KeyguardManager;
import android.graphics.Bitmap;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.ads.interactivemedia.p034v3.internal.bqk;

/* loaded from: classes.dex */
public final class ScreenUtils {
    private ScreenUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Bitmap captureWithStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    public static Bitmap captureWithoutStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        int statusBarHeight = BarUtils.getStatusBarHeight(activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, statusBarHeight, displayMetrics.widthPixels, displayMetrics.heightPixels - statusBarHeight);
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    public static int getScreenHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) Utils.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenRotation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return bqk.f6530aq;
            }
            return 180;
        }
        return 90;
    }

    public static int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) Utils.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getSleepDuration() {
        try {
            return Settings.System.getInt(Utils.getContext().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return -123;
        }
    }

    public static boolean isLandscape() {
        return Utils.getContext().getResources().getConfiguration().orientation == 2;
    }

    public static boolean isPortrait() {
        return Utils.getContext().getResources().getConfiguration().orientation == 1;
    }

    public static boolean isScreenLock() {
        return ((KeyguardManager) Utils.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static void setLandscape(Activity activity) {
        activity.setRequestedOrientation(0);
    }

    public static void setPortrait(Activity activity) {
        activity.setRequestedOrientation(1);
    }

    public static void setSleepDuration(int i) {
        Settings.System.putInt(Utils.getContext().getContentResolver(), "screen_off_timeout", i);
    }
}
