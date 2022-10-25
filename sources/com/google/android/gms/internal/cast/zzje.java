package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzje implements zzou {
    SLOW_MDNS_UNKNOWN(0),
    SLOW_MDNS_RESPONSE_FROM_NON_SUBTYPE_AWARE_DEVICE(1),
    SLOW_MDNS_SUBTYPE_RESPONSE(2);
    
    private static final zzov<zzje> zzd = new zzov<zzje>() { // from class: com.google.android.gms.internal.cast.zzjc
    };
    private final int zze;

    zzje(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzjd.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
