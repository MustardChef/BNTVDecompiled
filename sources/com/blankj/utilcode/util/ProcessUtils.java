package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class ProcessUtils {
    private ProcessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Set<String> getAllBackgroundProcesses() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) Utils.getContext().getSystemService("activity")).getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            Collections.addAll(hashSet, runningAppProcessInfo.pkgList);
        }
        return hashSet;
    }

    public static String getForegroundProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) Utils.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        if (Build.VERSION.SDK_INT > 21) {
            PackageManager packageManager = Utils.getContext().getPackageManager();
            Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            System.out.println(queryIntentActivities);
            if (queryIntentActivities.size() > 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(Utils.getContext().getPackageName(), 0);
                    AppOpsManager appOpsManager = (AppOpsManager) Utils.getContext().getSystemService("appops");
                    if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                        Utils.getContext().startActivity(intent);
                    }
                    if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                        LogUtils.m6080d("getForegroundApp", "没有打开\"有权查看使用权限的应用\"选项");
                        return null;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    List<UsageStats> queryUsageStats = ((UsageStatsManager) Utils.getContext().getSystemService("usagestats")).queryUsageStats(4, currentTimeMillis - 604800000, currentTimeMillis);
                    if (queryUsageStats != null && !queryUsageStats.isEmpty()) {
                        UsageStats usageStats = null;
                        for (UsageStats usageStats2 : queryUsageStats) {
                            if (usageStats == null || usageStats2.getLastTimeUsed() > usageStats.getLastTimeUsed()) {
                                usageStats = usageStats2;
                            }
                        }
                        if (usageStats == null) {
                            return null;
                        }
                        return usageStats.getPackageName();
                    }
                    return null;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                LogUtils.m6080d("getForegroundApp", "无\"有权查看使用权限的应用\"选项");
            }
        }
        return null;
    }

    public static Set<String> killAllBackgroundProcesses() {
        String[] strArr;
        ActivityManager activityManager = (ActivityManager) Utils.getContext().getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            for (String str : it.next().pkgList) {
                activityManager.killBackgroundProcesses(str);
                hashSet.add(str);
            }
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            for (String str2 : runningAppProcessInfo.pkgList) {
                hashSet.remove(str2);
            }
        }
        return hashSet;
    }

    public static boolean killBackgroundProcesses(String str) {
        ActivityManager activityManager = (ActivityManager) Utils.getContext().getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    activityManager.killBackgroundProcesses(str);
                }
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = activityManager.getRunningAppProcesses();
            if (runningAppProcesses2 != null && runningAppProcesses2.size() != 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses2) {
                    if (Arrays.asList(runningAppProcessInfo2.pkgList).contains(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
