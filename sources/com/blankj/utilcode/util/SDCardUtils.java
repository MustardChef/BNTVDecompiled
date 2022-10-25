package com.blankj.utilcode.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public final class SDCardUtils {

    /* loaded from: classes.dex */
    public static class SDCardInfo {
        long availableBlocks;
        long availableBytes;
        long blockByteSize;
        long freeBlocks;
        long freeBytes;
        boolean isExist;
        long totalBlocks;
        long totalBytes;

        public String toString() {
            return "isExist=" + this.isExist + "\ntotalBlocks=" + this.totalBlocks + "\nfreeBlocks=" + this.freeBlocks + "\navailableBlocks=" + this.availableBlocks + "\nblockByteSize=" + this.blockByteSize + "\ntotalBytes=" + this.totalBytes + "\nfreeBytes=" + this.freeBytes + "\navailableBytes=" + this.availableBytes;
        }
    }

    private SDCardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getDataPath() {
        if (isSDCardEnable()) {
            return Environment.getExternalStorageDirectory().getPath() + File.separator + "data" + File.separator;
        }
        return null;
    }

    public static String getFreeSpace() {
        if (isSDCardEnable()) {
            StatFs statFs = new StatFs(getSDCardPath());
            return ConvertUtils.byte2FitMemorySize(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        }
        return null;
    }

    public static String getSDCardInfo() {
        if (isSDCardEnable()) {
            SDCardInfo sDCardInfo = new SDCardInfo();
            sDCardInfo.isExist = true;
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            sDCardInfo.totalBlocks = statFs.getBlockCountLong();
            sDCardInfo.blockByteSize = statFs.getBlockSizeLong();
            sDCardInfo.availableBlocks = statFs.getAvailableBlocksLong();
            sDCardInfo.availableBytes = statFs.getAvailableBytes();
            sDCardInfo.freeBlocks = statFs.getFreeBlocksLong();
            sDCardInfo.freeBytes = statFs.getFreeBytes();
            sDCardInfo.totalBytes = statFs.getTotalBytes();
            return sDCardInfo.toString();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getSDCardPath() {
        String[] split;
        String str = null;
        if (!isSDCardEnable()) {
            return null;
        }
        try {
            try {
                Process exec = Runtime.getRuntime().exec("cat /proc/mounts");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(exec.getInputStream())));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (readLine.contains("sdcard") && readLine.contains(".android_secure")) {
                                if (readLine.split(" ").length >= 5) {
                                    String str2 = split[1].replace("/.android_secure", "") + File.separator;
                                    CloseUtils.closeIO(bufferedReader);
                                    return str2;
                                }
                            }
                            if (exec.waitFor() != 0 && exec.exitValue() == 1) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        e = e;
                        str = bufferedReader;
                        e.printStackTrace();
                        CloseUtils.closeIO(str);
                        StringBuilder sb = new StringBuilder();
                        sb.append(Environment.getExternalStorageDirectory().getPath());
                        str = File.separator;
                        sb.append(str);
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        str = bufferedReader;
                        CloseUtils.closeIO(str);
                        throw th;
                    }
                }
                CloseUtils.closeIO(bufferedReader);
            } catch (Exception e2) {
                e = e2;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Environment.getExternalStorageDirectory().getPath());
            str = File.separator;
            sb2.append(str);
            return sb2.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isSDCardEnable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
