package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class ServiceUtils {
    private ServiceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void bindService(Class<?> cls, ServiceConnection serviceConnection, int i) {
        Utils.getContext().bindService(new Intent(Utils.getContext(), cls), serviceConnection, i);
    }

    public static void bindService(String str, ServiceConnection serviceConnection, int i) {
        try {
            bindService(Class.forName(str), serviceConnection, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set getAllRunningService() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getContext().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        HashSet hashSet = new HashSet();
        if (runningServices == null || runningServices.size() == 0) {
            return null;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            hashSet.add(runningServiceInfo.service.getClassName());
        }
        return hashSet;
    }

    public static boolean isServiceRunning(String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getContext().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices != null && runningServices.size() != 0) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (str.equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void startService(Class<?> cls) {
        Utils.getContext().startService(new Intent(Utils.getContext(), cls));
    }

    public static void startService(String str) {
        try {
            startService(Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean stopService(Class<?> cls) {
        return Utils.getContext().stopService(new Intent(Utils.getContext(), cls));
    }

    public static boolean stopService(String str) {
        try {
            return stopService(Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void unbindService(ServiceConnection serviceConnection) {
        Utils.getContext().unbindService(serviceConnection);
    }
}
