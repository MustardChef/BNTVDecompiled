package com.blankj.utilcode.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class CrashUtils implements Thread.UncaughtExceptionHandler {
    private static volatile CrashUtils mInstance;
    private String crashDir;
    private Thread.UncaughtExceptionHandler mHandler;
    private boolean mInitialized;
    private int versionCode;
    private String versionName;

    private CrashUtils() {
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean createOrExistsFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCrashHead() {
        return "\n************* Crash Log Head ****************\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\nApp VersionName    : " + this.versionName + "\nApp VersionCode    : " + this.versionCode + "\n************* Crash Log Head ****************\n\n";
    }

    public static CrashUtils getInstance() {
        if (mInstance == null) {
            synchronized (CrashUtils.class) {
                if (mInstance == null) {
                    mInstance = new CrashUtils();
                }
            }
        }
        return mInstance;
    }

    public boolean init() {
        File cacheDir;
        StringBuilder sb;
        if (this.mInitialized) {
            return true;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = Utils.getContext().getExternalCacheDir();
            if (cacheDir == null) {
                return false;
            }
            sb = new StringBuilder();
        } else {
            cacheDir = Utils.getContext().getCacheDir();
            if (cacheDir == null) {
                return false;
            }
            sb = new StringBuilder();
        }
        sb.append(cacheDir.getPath());
        sb.append(File.separator);
        sb.append(AppMeasurement.CRASH_ORIGIN);
        sb.append(File.separator);
        this.crashDir = sb.toString();
        try {
            PackageInfo packageInfo = Utils.getContext().getPackageManager().getPackageInfo(Utils.getContext().getPackageName(), 0);
            this.versionName = packageInfo.versionName;
            this.versionCode = packageInfo.versionCode;
            this.mHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.mInitialized = true;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, final Throwable th) {
        final String str = this.crashDir + new SimpleDateFormat("yyMMdd HH-mm-ss", Locale.getDefault()).format(new Date()) + ".txt";
        if (createOrExistsFile(str)) {
            new Thread(new Runnable() { // from class: com.blankj.utilcode.util.CrashUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    Throwable th2;
                    PrintWriter printWriter;
                    IOException e;
                    try {
                        try {
                            printWriter = new PrintWriter(new FileWriter(str, false));
                        } catch (IOException e2) {
                            printWriter = null;
                            e = e2;
                        } catch (Throwable th3) {
                            th2 = th3;
                            CloseUtils.closeIO(null);
                            throw th2;
                        }
                        try {
                            printWriter.write(CrashUtils.this.getCrashHead());
                            th.printStackTrace(printWriter);
                            Throwable th4 = th;
                            while (true) {
                                th4 = th4.getCause();
                                if (th4 == null) {
                                    CloseUtils.closeIO(printWriter);
                                    return;
                                }
                                th4.printStackTrace(printWriter);
                            }
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            CloseUtils.closeIO(printWriter);
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        CloseUtils.closeIO(null);
                        throw th2;
                    }
                }
            }).start();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
