package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzid implements zzou {
    NETWORK_CONNECTION_STATE_UNKNOWN(0),
    CONNECTED(1),
    CONNECTING(2),
    DISCONNECTED(3),
    DISCONNECTING(4),
    SUSPENDED(6);
    
    private static final zzov<zzid> zzg = new zzov<zzid>() { // from class: com.google.android.gms.internal.cast.zzib
    };
    private final int zzh;

    zzid(int i) {
        this.zzh = i;
    }

    public static zzow zza() {
        return zzic.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
    }
}
