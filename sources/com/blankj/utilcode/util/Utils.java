package com.blankj.utilcode.util;

import android.content.Context;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Utils {
    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Context getContext() {
        Context context2 = context;
        Objects.requireNonNull(context2, "u should init first");
        return context2;
    }

    public static void init(Context context2) {
        context = context2.getApplicationContext();
    }
}
