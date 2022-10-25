package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzhu implements zzou {
    LOCAL_NETWORK_ACCESS_PERMISSION_STATUS_UNKNOWN(0),
    LOCAL_NETWORK_ACCESS_PERMISSION_STATUS_ALLOWED(1),
    LOCAL_NETWORK_ACCESS_PERMISSION_STATUS_DENIED(2);
    
    private static final zzov<zzhu> zzd = new zzov<zzhu>() { // from class: com.google.android.gms.internal.cast.zzhs
    };
    private final int zze;

    zzhu(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzht.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
