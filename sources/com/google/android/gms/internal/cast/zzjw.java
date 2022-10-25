package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzjw implements zzou {
    WIFI_AUTH_TYPE_OTHER(0),
    WIFI_AUTH_TYPE_WEP(1),
    WIFI_AUTH_TYPE_WPA(2);
    
    private static final zzov<zzjw> zzd = new zzov<zzjw>() { // from class: com.google.android.gms.internal.cast.zzju
    };
    private final int zze;

    zzjw(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzjv.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
