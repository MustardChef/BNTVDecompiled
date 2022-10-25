package com.google.android.gms.common.util;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public interface Clock {
    long currentThreadTimeMillis();

    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();
}
