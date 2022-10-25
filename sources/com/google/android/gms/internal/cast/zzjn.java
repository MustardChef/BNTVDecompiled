package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzjn implements zzou {
    TCP_PROBER_IP_SOURCE_UNKNOWN(0),
    TCP_PROBER_IP_SOURCE_CACHED(1),
    TCP_PROBER_IP_SOURCE_BLE(2),
    TCP_PROBER_IP_SOURCE_GAIA(3);
    
    private static final zzov<zzjn> zze = new zzov<zzjn>() { // from class: com.google.android.gms.internal.cast.zzjl
    };
    private final int zzf;

    zzjn(int i) {
        this.zzf = i;
    }

    public static zzow zza() {
        return zzjm.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }
}
