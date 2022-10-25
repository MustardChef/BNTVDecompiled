package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzim implements zzou {
    PRECACHE_MESSAGE_TYPE_UNKNOWN(0),
    PRECACHE_MESSAGE_TYPE_ACTIVE_CONNECTION(1),
    PRECACHE_MESSAGE_TYPE_BROADCAST(2);
    
    private static final zzov<zzim> zzd = new zzov<zzim>() { // from class: com.google.android.gms.internal.cast.zzik
    };
    private final int zze;

    zzim(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzil.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
