package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzha implements zzou {
    DISCOVERY_START_UNKNOWN(0),
    DISCOVERY_START_CRITERIA_CHANGED(1),
    DISCOVERY_START_NETWORK_CHANGE(2),
    DISCOVERY_START_SCREEN_ON(3),
    DISCOVERY_START_FOREGROUND_MODE(4),
    DISCOVERY_START_CONFIGURATION_UPDATED(5);
    
    private static final zzov<zzha> zzg = new zzov<zzha>() { // from class: com.google.android.gms.internal.cast.zzgy
    };
    private final int zzh;

    zzha(int i) {
        this.zzh = i;
    }

    public static zzow zza() {
        return zzgz.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
    }
}
