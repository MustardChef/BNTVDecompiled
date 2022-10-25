package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class PermissionUtils {
    private static OnPermissionListener mOnPermissionListener = null;
    private static int mRequestCode = -1;

    /* loaded from: classes.dex */
    public interface OnPermissionListener {
        void onPermissionDenied(String[] strArr);

        void onPermissionGranted();
    }

    /* loaded from: classes.dex */
    public static abstract class RationaleHandler {
        private Context context;
        private String[] permissions;
        private int requestCode;

        public void requestPermissionsAgain() {
            ((Activity) this.context).requestPermissions(this.permissions, this.requestCode);
        }

        protected abstract void showRationale();

        void showRationale(Context context, int i, String[] strArr) {
            this.context = context;
            this.requestCode = i;
            this.permissions = strArr;
            showRationale();
        }
    }

    private static String[] getDeniedPermissions(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) == -1) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean hasAlwaysDeniedPermission(Context context, String... strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (!shouldShowRequestPermissionRationale(context, strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        int i2 = mRequestCode;
        if (i2 == -1 || i != i2 || mOnPermissionListener == null) {
            return;
        }
        String[] deniedPermissions = getDeniedPermissions(activity, strArr);
        if (deniedPermissions.length > 0) {
            mOnPermissionListener.onPermissionDenied(deniedPermissions);
        } else {
            mOnPermissionListener.onPermissionGranted();
        }
    }

    public static void requestPermissions(Context context, int i, String[] strArr, OnPermissionListener onPermissionListener) {
        requestPermissions(context, i, strArr, onPermissionListener, null);
    }

    public static void requestPermissions(Context context, int i, String[] strArr, OnPermissionListener onPermissionListener, RationaleHandler rationaleHandler) {
        if (!(context instanceof Activity)) {
            throw new RuntimeException("Context must be an Activity");
        }
        mRequestCode = i;
        mOnPermissionListener = onPermissionListener;
        String[] deniedPermissions = getDeniedPermissions(context, strArr);
        if (deniedPermissions.length <= 0) {
            OnPermissionListener onPermissionListener2 = mOnPermissionListener;
            if (onPermissionListener2 != null) {
                onPermissionListener2.onPermissionGranted();
            }
        } else if (!shouldShowRequestPermissionRationale(context, deniedPermissions) || rationaleHandler == null) {
            ((Activity) context).requestPermissions(deniedPermissions, i);
        } else {
            rationaleHandler.showRationale(context, i, deniedPermissions);
        }
    }

    private static boolean shouldShowRequestPermissionRationale(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, str)) {
                return true;
            }
        }
        return false;
    }
}
