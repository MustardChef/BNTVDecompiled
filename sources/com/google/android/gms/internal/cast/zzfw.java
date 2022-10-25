package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzfw implements zzou {
    CLOUD_DISCOVERY_RESULT_CODE_UNKNOWN(0),
    CLOUD_DISCOVERY_RESULT_CODE_SUCCESS(1),
    CLOUD_DISCOVERY_RESULT_CODE_FAILURE(2);
    
    private static final zzov<zzfw> zzd = new zzov<zzfw>() { // from class: com.google.android.gms.internal.cast.zzfu
    };
    private final int zze;

    zzfw(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzfv.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
