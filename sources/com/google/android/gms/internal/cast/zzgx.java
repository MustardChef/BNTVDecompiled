package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgx implements zzou {
    DISCOVERY_PROTOCOL_TYPE_UNKNOWN(0),
    MDNS(1),
    CAST_NEARBY(2),
    MDNS_UNICAST_RESPONSE(3),
    SSDP(4),
    BLE(5),
    ADAPTIVE_DISCOVERY(6),
    TCP_FILTER(7);
    
    private static final zzov<zzgx> zzi = new zzov<zzgx>() { // from class: com.google.android.gms.internal.cast.zzgv
    };
    private final int zzj;

    zzgx(int i) {
        this.zzj = i;
    }

    public static zzow zza() {
        return zzgw.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzj + " name=" + name() + Typography.greater;
    }
}
