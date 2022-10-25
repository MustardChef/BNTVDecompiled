package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzig implements zzou {
    NETWORK_CONNECTION_TYPE_UNKNOWN(0),
    MOBILE(1),
    WIFI(2),
    MOBILE_MMS(3),
    MOBILE_SUPL(4),
    MOBILE_DUN(5),
    MOBILE_HIPRI(6),
    WIMAX(7),
    BLUETOOTH(8),
    DUMMY(9),
    ETHERNET(10),
    VPN(11);
    
    private static final zzov<zzig> zzm = new zzov<zzig>() { // from class: com.google.android.gms.internal.cast.zzie
    };
    private final int zzn;

    zzig(int i) {
        this.zzn = i;
    }

    public static zzow zza() {
        return zzif.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
    }
}
