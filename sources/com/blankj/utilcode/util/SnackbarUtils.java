package com.blankj.utilcode.util;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.snackbar.Snackbar;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class SnackbarUtils {
    private static WeakReference<Snackbar> snackbarWeakReference;

    private SnackbarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addView(int i, int i2) {
        Snackbar snackbar = snackbarWeakReference.get();
        if (snackbar != null) {
            View view = snackbar.getView();
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
            View inflate = LayoutInflater.from(view.getContext()).inflate(i, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            snackbarLayout.addView(inflate, i2, layoutParams);
        }
    }

    public static void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Snackbar snackbar = snackbarWeakReference.get();
        if (snackbar != null) {
            ((Snackbar.SnackbarLayout) snackbar.getView()).addView(view, i, layoutParams);
        }
    }

    public static void dismiss() {
        WeakReference<Snackbar> weakReference = snackbarWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        snackbarWeakReference.get().dismiss();
        snackbarWeakReference = null;
    }

    private static void show(View view, CharSequence charSequence, int i, int i2, int i3, CharSequence charSequence2, int i4, View.OnClickListener onClickListener) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 33);
        WeakReference<Snackbar> weakReference = new WeakReference<>(Snackbar.make(view, spannableString, i));
        snackbarWeakReference = weakReference;
        Snackbar snackbar = weakReference.get();
        snackbar.getView().setBackgroundColor(i3);
        if (charSequence2 != null && charSequence2.length() > 0 && onClickListener != null) {
            snackbar.setActionTextColor(i4);
            snackbar.setAction(charSequence2, onClickListener);
        }
        snackbar.show();
    }

    public static void showIndefinite(View view, CharSequence charSequence, int i, int i2) {
        show(view, charSequence, -2, i, i2, null, -1, null);
    }

    public static void showIndefinite(View view, CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, View.OnClickListener onClickListener) {
        show(view, charSequence, -2, i, i2, charSequence2, i3, onClickListener);
    }

    public static void showLong(View view, CharSequence charSequence, int i, int i2) {
        show(view, charSequence, 0, i, i2, null, -1, null);
    }

    public static void showLong(View view, CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, View.OnClickListener onClickListener) {
        show(view, charSequence, 0, i, i2, charSequence2, i3, onClickListener);
    }

    public static void showShort(View view, CharSequence charSequence, int i, int i2) {
        show(view, charSequence, -1, i, i2, null, -1, null);
    }

    public static void showShort(View view, CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, View.OnClickListener onClickListener) {
        show(view, charSequence, -1, i, i2, charSequence2, i3, onClickListener);
    }
}
