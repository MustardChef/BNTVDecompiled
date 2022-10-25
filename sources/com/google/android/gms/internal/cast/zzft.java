package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzft implements zzou {
    CLOUD_DEVICE_PROBING_STATUS_CODE_UNKNOWN(0),
    CLOUD_DEVICE_PROBING_STATUS_CODE_SCHEDULED(1),
    CLOUD_DEVICE_PROBING_STATUS_CODE_SKIPPED_CLOUD_PROBING_DISABLED(2),
    CLOUD_DEVICE_PROBING_STATUS_CODE_SKIPPED_INVALID_IP_FRAGMENT(3),
    CLOUD_DEVICE_PROBING_STATUS_CODE_SKIPPED_INVALID_NETWORK_INFO(4),
    CLOUD_DEVICE_PROBING_STATUS_CODE_SKIPPED_INVALID_NETWORK_IP(5),
    CLOUD_DEVICE_PROBING_STATUS_CODE_SKIPPED_STRUCTURE_OFFLINE(6),
    CLOUD_DEVICE_PROBING_STATUS_CODE_SKIPPED_CLOUD_DEVICE_OFFLINE(7);
    
    private static final zzov<zzft> zzi = new zzov<zzft>() { // from class: com.google.android.gms.internal.cast.zzfr
    };
    private final int zzj;

    zzft(int i) {
        this.zzj = i;
    }

    public static zzow zza() {
        return zzfs.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzj + " name=" + name() + Typography.greater;
    }
}
