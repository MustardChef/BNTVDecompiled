package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgr implements zzou {
    DEVICE_DISCONNECT_REASON_UNKNOWN(0),
    STATUS_ERROR_NETWORK(1),
    STATUS_ERROR_HEARTBEAT_TIMEOUT(2),
    STATUS_EXPLICIT_DISCONNECT(3),
    STATUS_IMPLICIT_DISCONNECT(4);
    
    private static final zzov<zzgr> zzf = new zzov<zzgr>() { // from class: com.google.android.gms.internal.cast.zzgp
    };
    private final int zzg;

    zzgr(int i) {
        this.zzg = i;
    }

    public static zzow zza() {
        return zzgq.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
