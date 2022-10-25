package com.blankj.utilcode.util;

import java.io.File;

/* loaded from: classes.dex */
public final class CleanUtils {
    private CleanUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean cleanCustomCache(File file) {
        return FileUtils.deleteFilesInDir(file);
    }

    public static boolean cleanCustomCache(String str) {
        return FileUtils.deleteFilesInDir(str);
    }

    public static boolean cleanExternalCache() {
        return SDCardUtils.isSDCardEnable() && FileUtils.deleteFilesInDir(Utils.getContext().getExternalCacheDir());
    }

    public static boolean cleanInternalCache() {
        return FileUtils.deleteFilesInDir(Utils.getContext().getCacheDir());
    }

    public static boolean cleanInternalDbByName(String str) {
        return Utils.getContext().deleteDatabase(str);
    }

    public static boolean cleanInternalDbs() {
        return FileUtils.deleteFilesInDir(Utils.getContext().getFilesDir().getParent() + File.separator + "databases");
    }

    public static boolean cleanInternalFiles() {
        return FileUtils.deleteFilesInDir(Utils.getContext().getFilesDir());
    }

    public static boolean cleanInternalSP() {
        return FileUtils.deleteFilesInDir(Utils.getContext().getFilesDir().getParent() + File.separator + "shared_prefs");
    }
}
