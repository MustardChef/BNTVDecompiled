package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ActivityUtils {
    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Intent getComponentIntent(String str, String str2, Bundle bundle) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return intent.addFlags(268435456);
    }

    public static String getLauncherActivity(String str) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        for (ResolveInfo resolveInfo : Utils.getContext().getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.equals(str)) {
                return resolveInfo.activityInfo.name;
            }
        }
        return "no " + str;
    }

    public static Activity getTopActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : (Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(invoke) : (ArrayMap) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isActivityExists(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        return (Utils.getContext().getPackageManager().resolveActivity(intent, 0) == null || intent.resolveActivity(Utils.getContext().getPackageManager()) == null || Utils.getContext().getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static void launchActivity(String str, String str2) {
        launchActivity(str, str2, null);
    }

    public static void launchActivity(String str, String str2, Bundle bundle) {
        Utils.getContext().startActivity(getComponentIntent(str, str2, bundle));
    }
}
