package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzhl implements zzou {
    SUCCESS(0),
    LOW_API_LEVEL(1),
    DEVICE_AUTH_FAILURE(2),
    DEVICE_UNAUTHENTICATED(3),
    PASSWORD_ENCRYPTION_FAILURE(4),
    NO_WIFI_MANAGER(5),
    WEP_RESTRICTION_PRE_O(6),
    NO_MATCHING_NETWORK(7),
    EMPTY_PASSWORD(8);
    
    private static final zzov<zzhl> zzj = new zzov<zzhl>() { // from class: com.google.android.gms.internal.cast.zzhj
    };
    private final int zzk;

    zzhl(int i) {
        this.zzk = i;
    }

    public static zzow zza() {
        return zzhk.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + Typography.greater;
    }
}
