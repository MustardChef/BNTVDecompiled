package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes3.dex */
final class DrawingUtils {
    DrawingUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dpToPx(Context context, float f) {
        float applyDimension = TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        int i = (int) (applyDimension + 0.5d);
        if (i != 0 || applyDimension <= 0.0f) {
            return i;
        }
        return 1;
    }
}
