package androidx.core.p005os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* renamed from: androidx.core.os.EnvironmentCompat */
/* loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File file) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getExternalStorageState(file);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.getStorageState(file);
        }
        try {
            return file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) ? Environment.getExternalStorageState() : "unknown";
        } catch (IOException e) {
            Log.w(TAG, "Failed to resolve canonical path: " + e);
            return "unknown";
        }
    }

    private EnvironmentCompat() {
    }

    /* renamed from: androidx.core.os.EnvironmentCompat$Api21Impl */
    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static String getExternalStorageState(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    /* renamed from: androidx.core.os.EnvironmentCompat$Api19Impl */
    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static String getStorageState(File file) {
            return Environment.getStorageState(file);
        }
    }
}
