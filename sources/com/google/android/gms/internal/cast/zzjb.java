package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzjb implements zzou {
    SESSION_ID_TYPE_UNKNOWN(0),
    DEVICE_CONTROLLER_CONNECTION(1),
    DEVICE_CONTROLLER_APPLICATION_CONNECTION(2),
    DEVICE_FILTER(3),
    REMOTE_DISPLAY_PLUGIN_SESSION(4),
    REMOTE_CONTROL_NOTIFICATION_SESSION(5);
    
    private static final zzov<zzjb> zzg = new zzov<zzjb>() { // from class: com.google.android.gms.internal.cast.zziz
    };
    private final int zzh;

    zzjb(int i) {
        this.zzh = i;
    }

    public static zzow zza() {
        return zzja.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
    }
}
