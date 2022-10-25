package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgo implements zzou {
    DEVICE_CONNECTION_TYPE_UNKNOWN(0),
    DEVICE_CONNECTION_TYPE_LOCAL(1),
    DEVICE_CONNECTION_TYPE_OPENCAST(2),
    DEVICE_CONNECTION_TYPE_RELAY(3),
    DEVICE_CONNECTION_TYPE_REMOTE_CASTING(4);
    
    private static final zzov<zzgo> zzf = new zzov<zzgo>() { // from class: com.google.android.gms.internal.cast.zzgm
    };
    private final int zzg;

    zzgo(int i) {
        this.zzg = i;
    }

    public static zzow zza() {
        return zzgn.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
