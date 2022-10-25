package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgi implements zzou {
    UNKNOWN_FEATURE(0),
    GET_IP_ADDRESS(1),
    GET_INET_ADDRESS(2);
    
    private static final zzov<zzgi> zzd = new zzov<zzgi>() { // from class: com.google.android.gms.internal.cast.zzgg
    };
    private final int zze;

    zzgi(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzgh.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
