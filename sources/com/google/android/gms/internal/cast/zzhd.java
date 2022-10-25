package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzhd implements zzou {
    DISCOVERY_STOP_UNKNOWN(0),
    DISCOVERY_STOP_CRITERIA_CHANGED(1),
    DISCOVERY_STOP_NETWORK_CHANGE(2),
    DISCOVERY_STOP_SCREEN_OFF(3),
    DISCOVERY_STOP_BACKGROUND_MODE(4),
    DISCOVERY_STOP_CONFIGURATION_UPDATED(5),
    DISCOVERY_STOP_APPLICATION_FINISHED(6);
    
    private static final zzov<zzhd> zzh = new zzov<zzhd>() { // from class: com.google.android.gms.internal.cast.zzhb
    };
    private final int zzi;

    zzhd(int i) {
        this.zzi = i;
    }

    public static zzow zza() {
        return zzhc.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
    }
}
