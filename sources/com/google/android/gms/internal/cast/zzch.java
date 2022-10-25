package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzch {
    public static final int zza;

    static {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'S' && Build.VERSION.CODENAME.charAt(0) <= 'Z') {
            i = 33554432;
        }
        zza = i;
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getActivity(context, i, intent, i2);
    }

    public static PendingIntent zzb(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, i, intent, i2);
    }
}
