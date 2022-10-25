package com.blankj.utilcode.util;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class SizeUtils {

    /* loaded from: classes.dex */
    public interface onGetSizeListener {
        void onGetSize(View view);
    }

    private SizeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static float applyDimension(int i, float f, DisplayMetrics displayMetrics) {
        float f2;
        if (i != 0) {
            if (i == 1) {
                f2 = displayMetrics.density;
            } else if (i == 2) {
                f2 = displayMetrics.scaledDensity;
            } else if (i == 3) {
                f *= displayMetrics.xdpi;
                f2 = 0.013888889f;
            } else if (i == 4) {
                f2 = displayMetrics.xdpi;
            } else if (i != 5) {
                return 0.0f;
            } else {
                f *= displayMetrics.xdpi;
                f2 = 0.03937008f;
            }
            return f * f2;
        }
        return f;
    }

    public static int dp2px(float f) {
        return (int) ((f * Utils.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void forceGetViewSize(final View view, final onGetSizeListener ongetsizelistener) {
        view.post(new Runnable() { // from class: com.blankj.utilcode.util.SizeUtils.1
            @Override // java.lang.Runnable
            public void run() {
                onGetSizeListener ongetsizelistener2 = onGetSizeListener.this;
                if (ongetsizelistener2 != null) {
                    ongetsizelistener2.onGetSize(view);
                }
            }
        });
    }

    public static int getMeasuredHeight(View view) {
        return measureView(view)[1];
    }

    public static int getMeasuredWidth(View view) {
        return measureView(view)[0];
    }

    public static int[] measureView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static int px2dp(float f) {
        return (int) ((f / Utils.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / Utils.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * Utils.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
