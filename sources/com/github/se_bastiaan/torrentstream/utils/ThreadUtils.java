package com.github.se_bastiaan.torrentstream.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public final class ThreadUtils {
    private ThreadUtils() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            new Handler(Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }
}
