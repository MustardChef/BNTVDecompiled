package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzfz implements zzou {
    CLOUD_DISCOVERY_TRIGGERING_SOURCE_UNKNOWN(0),
    CLOUD_DISCOVERY_TRIGGERING_SOURCE_CAST_BUTTON_CLICK(1),
    CLOUD_DISCOVERY_TRIGGERING_SOURCE_REMOTE_CASTING(2);
    
    private static final zzov<zzfz> zzd = new zzov<zzfz>() { // from class: com.google.android.gms.internal.cast.zzfx
    };
    private final int zze;

    zzfz(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzfy.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
