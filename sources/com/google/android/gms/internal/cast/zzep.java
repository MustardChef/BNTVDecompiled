package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzep implements zzou {
    TARGET_FPS_UNKNOWN(0),
    TARGET_FPS_15(1),
    TARGET_FPS_24(2),
    TARGET_FPS_25(3),
    TARGET_FPS_30(4),
    TARGET_FPS_60(5);
    
    private static final zzov<zzep> zzg = new zzov<zzep>() { // from class: com.google.android.gms.internal.cast.zzen
    };
    private final int zzh;

    zzep(int i) {
        this.zzh = i;
    }

    public static zzow zza() {
        return zzeo.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
    }
}
