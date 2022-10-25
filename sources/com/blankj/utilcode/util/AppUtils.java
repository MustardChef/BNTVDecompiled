package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import com.blankj.utilcode.util.ShellUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppUtils {

    /* loaded from: classes.dex */
    public static class AppInfo {
        private Drawable icon;
        private boolean isSystem;
        private String name;
        private String packageName;
        private String packagePath;
        private int versionCode;
        private String versionName;

        public AppInfo(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            setName(str2);
            setIcon(drawable);
            setPackageName(str);
            setPackagePath(str3);
            setVersionName(str4);
            setVersionCode(i);
            setSystem(z);
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public String getName() {
            return this.name;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getPackagePath() {
            return this.packagePath;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public boolean isSystem() {
            return this.isSystem;
        }

        public void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setPackagePath(String str) {
            this.packagePath = str;
        }

        public void setSystem(boolean z) {
            this.isSystem = z;
        }

        public void setVersionCode(int i) {
            this.versionCode = i;
        }

        public void setVersionName(String str) {
            this.versionName = str;
        }

        public String toString() {
            return "pkg name: " + getPackageName() + "\napp name: " + getName() + "\napp path: " + getPackagePath() + "\napp v name: " + getVersionName() + "\napp v code: " + getVersionCode() + "\nis system: " + isSystem();
        }
    }

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean cleanAppData(File... fileArr) {
        boolean cleanInternalCache = CleanUtils.cleanInternalCache() & CleanUtils.cleanInternalDbs() & CleanUtils.cleanInternalSP() & CleanUtils.cleanInternalFiles() & CleanUtils.cleanExternalCache();
        for (File file : fileArr) {
            cleanInternalCache &= CleanUtils.cleanCustomCache(file);
        }
        return cleanInternalCache;
    }

    public static boolean cleanAppData(String... strArr) {
        File[] fileArr = new File[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            fileArr[i2] = new File(strArr[i]);
            i++;
            i2++;
        }
        return cleanAppData(fileArr);
    }

    public static void getAppDetailsSettings() {
        getAppDetailsSettings(Utils.getContext().getPackageName());
    }

    public static void getAppDetailsSettings(String str) {
        if (isSpace(str)) {
            return;
        }
        Utils.getContext().startActivity(IntentUtils.getAppDetailsSettingsIntent(str));
    }

    public static Drawable getAppIcon() {
        return getAppIcon(Utils.getContext().getPackageName());
    }

    public static Drawable getAppIcon(String str) {
        if (isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AppInfo getAppInfo() {
        return getAppInfo(Utils.getContext().getPackageName());
    }

    public static AppInfo getAppInfo(String str) {
        try {
            PackageManager packageManager = Utils.getContext().getPackageManager();
            return getBean(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppName() {
        return getAppName(Utils.getContext().getPackageName());
    }

    public static String getAppName(String str) {
        if (isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppPackageName() {
        return Utils.getContext().getPackageName();
    }

    public static String getAppPath() {
        return getAppPath(Utils.getContext().getPackageName());
    }

    public static String getAppPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = Utils.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Signature[] getAppSignature() {
        return getAppSignature(Utils.getContext().getPackageName());
    }

    public static Signature[] getAppSignature(String str) {
        if (isSpace(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = Utils.getContext().getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppSignatureSHA1() {
        return getAppSignatureSHA1(Utils.getContext().getPackageName());
    }

    public static String getAppSignatureSHA1(String str) {
        Signature[] appSignature = getAppSignature(str);
        if (appSignature == null) {
            return null;
        }
        return EncryptUtils.encryptSHA1ToString(appSignature[0].toByteArray()).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0");
    }

    public static int getAppVersionCode() {
        return getAppVersionCode(Utils.getContext().getPackageName());
    }

    public static int getAppVersionCode(String str) {
        if (isSpace(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getAppVersionName() {
        return getAppVersionName(Utils.getContext().getPackageName());
    }

    public static String getAppVersionName(String str) {
        if (isSpace(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = Utils.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<AppInfo> getAppsInfo() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = Utils.getContext().getPackageManager();
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
            AppInfo bean = getBean(packageManager, packageInfo);
            if (bean != null) {
                arrayList.add(bean);
            }
        }
        return arrayList;
    }

    private static AppInfo getBean(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageManager == null || packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return new AppInfo(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static void installApp(Activity activity, File file, String str, int i) {
        if (FileUtils.isFileExists(file)) {
            activity.startActivityForResult(IntentUtils.getInstallAppIntent(file, str), i);
        }
    }

    public static void installApp(Activity activity, String str, String str2, int i) {
        installApp(activity, FileUtils.getFileByPath(str), str2, i);
    }

    public static void installApp(File file, String str) {
        if (FileUtils.isFileExists(file)) {
            Utils.getContext().startActivity(IntentUtils.getInstallAppIntent(file, str));
        }
    }

    public static void installApp(String str, String str2) {
        installApp(FileUtils.getFileByPath(str), str2);
    }

    public static boolean installAppSilent(String str) {
        if (FileUtils.isFileExists(FileUtils.getFileByPath(str))) {
            ShellUtils.CommandResult execCmd = ShellUtils.execCmd("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install " + str, !isSystemApp(), true);
            return execCmd.successMsg != null && execCmd.successMsg.toLowerCase().contains("success");
        }
        return false;
    }

    public static boolean isAppDebug() {
        return isAppDebug(Utils.getContext().getPackageName());
    }

    public static boolean isAppDebug(String str) {
        if (isSpace(str)) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = Utils.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 2) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAppForeground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) Utils.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    return runningAppProcessInfo.processName.equals(Utils.getContext().getPackageName());
                }
            }
        }
        return false;
    }

    public static boolean isAppForeground(String str) {
        return !isSpace(str) && str.equals(ProcessUtils.getForegroundProcessName());
    }

    public static boolean isAppRoot() {
        ShellUtils.CommandResult execCmd = ShellUtils.execCmd("echo root", true);
        if (execCmd.result == 0) {
            return true;
        }
        if (execCmd.errorMsg != null) {
            LogUtils.m6080d("isAppRoot", execCmd.errorMsg);
        }
        return false;
    }

    public static boolean isInstallApp(String str) {
        return (isSpace(str) || IntentUtils.getLaunchAppIntent(str) == null) ? false : true;
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSystemApp() {
        return isSystemApp(Utils.getContext().getPackageName());
    }

    public static boolean isSystemApp(String str) {
        if (isSpace(str)) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = Utils.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 1) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void launchApp(Activity activity, String str, int i) {
        if (isSpace(str)) {
            return;
        }
        activity.startActivityForResult(IntentUtils.getLaunchAppIntent(str), i);
    }

    public static void launchApp(String str) {
        if (isSpace(str)) {
            return;
        }
        Utils.getContext().startActivity(IntentUtils.getLaunchAppIntent(str));
    }

    public static void uninstallApp(Activity activity, String str, int i) {
        if (isSpace(str)) {
            return;
        }
        activity.startActivityForResult(IntentUtils.getUninstallAppIntent(str), i);
    }

    public static void uninstallApp(String str) {
        if (isSpace(str)) {
            return;
        }
        Utils.getContext().startActivity(IntentUtils.getUninstallAppIntent(str));
    }

    public static boolean uninstallAppSilent(String str, boolean z) {
        if (isSpace(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm uninstall ");
        sb.append(z ? "-k " : "");
        sb.append(str);
        ShellUtils.CommandResult execCmd = ShellUtils.execCmd(sb.toString(), !isSystemApp(), true);
        return execCmd.successMsg != null && execCmd.successMsg.toLowerCase().contains("success");
    }
}
