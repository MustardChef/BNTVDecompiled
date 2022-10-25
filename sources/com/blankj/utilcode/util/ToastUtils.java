package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/* loaded from: classes.dex */
public final class ToastUtils {
    private static View customView = null;
    private static int gravity = 81;
    private static Toast sToast;
    private static int xOffset;
    private static int yOffset = (int) ((Utils.getContext().getResources().getDisplayMetrics().density * 64.0f) + 0.5d);
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void cancel() {
        Toast toast = sToast;
        if (toast != null) {
            toast.cancel();
            sToast = null;
        }
    }

    public static View getView() {
        View view = customView;
        if (view != null) {
            return view;
        }
        Toast toast = sToast;
        if (toast != null) {
            return toast.getView();
        }
        return null;
    }

    public static void setGravity(int i, int i2, int i3) {
        gravity = i;
        xOffset = i2;
        yOffset = i3;
    }

    public static void setView(int i) {
        customView = ((LayoutInflater) Utils.getContext().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }

    public static void setView(View view) {
        customView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void show(int i, int i2) {
        show(Utils.getContext().getResources().getText(i).toString(), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void show(int i, int i2, Object... objArr) {
        show(String.format(Utils.getContext().getResources().getString(i), objArr), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void show(CharSequence charSequence, int i) {
        cancel();
        if (customView != null) {
            Toast toast = new Toast(Utils.getContext());
            sToast = toast;
            toast.setView(customView);
            sToast.setDuration(i);
        } else {
            sToast = Toast.makeText(Utils.getContext(), charSequence, i);
        }
        sToast.setGravity(gravity, xOffset, yOffset);
        sToast.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void show(String str, int i, Object... objArr) {
        show(String.format(str, objArr), i);
    }

    public static void showLong(int i) {
        show(i, 1);
    }

    public static void showLong(int i, Object... objArr) {
        show(i, 1, objArr);
    }

    public static void showLong(CharSequence charSequence) {
        show(charSequence, 1);
    }

    public static void showLong(String str, Object... objArr) {
        show(str, 1, objArr);
    }

    public static void showLongSafe(final int i) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.6
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(i, 1);
            }
        });
    }

    public static void showLongSafe(final int i, final Object... objArr) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.7
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(i, 1, objArr);
            }
        });
    }

    public static void showLongSafe(final CharSequence charSequence) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.5
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(charSequence, 1);
            }
        });
    }

    public static void showLongSafe(final String str, final Object... objArr) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.8
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(str, 1, objArr);
            }
        });
    }

    public static void showShort(int i) {
        show(i, 0);
    }

    public static void showShort(int i, Object... objArr) {
        show(i, 0, objArr);
    }

    public static void showShort(CharSequence charSequence) {
        show(charSequence, 0);
    }

    public static void showShort(String str, Object... objArr) {
        show(str, 0, objArr);
    }

    public static void showShortSafe(final int i) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(i, 0);
            }
        });
    }

    public static void showShortSafe(final int i, final Object... objArr) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.3
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(i, 0, objArr);
            }
        });
    }

    public static void showShortSafe(final CharSequence charSequence) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(charSequence, 0);
            }
        });
    }

    public static void showShortSafe(final String str, final Object... objArr) {
        sHandler.post(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.4
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(str, 0, objArr);
            }
        });
    }
}
