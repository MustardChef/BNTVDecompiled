package com.google.ads.interactivemedia.p034v3.impl.data;

import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.aq */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2472aq {
    /* renamed from: a */
    public static File m6008a(String str, String str2, File file) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new File(m6007b(str, file), str2);
    }

    /* renamed from: b */
    public static File m6007b(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        m6004e(file2, false);
        return file2;
    }

    /* renamed from: c */
    public static boolean m6006c(File file) {
        boolean z;
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                z = true;
                for (int i = 0; i < length; i++) {
                    File file2 = listFiles[i];
                    z = file2 != null && m6006c(file2) && z;
                }
            } else {
                z = true;
            }
            return file.delete() && z;
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m6005d(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            IOUtils.closeQuietly(fileOutputStream);
            return true;
        } catch (IOException unused2) {
            fileOutputStream2 = fileOutputStream;
            IOUtils.closeQuietly(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            IOUtils.closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    /* renamed from: e */
    public static void m6004e(File file, boolean z) {
        if (z && file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
