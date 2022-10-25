package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgu implements zzou {
    DEVICE_LINK_STATE_UNKNOWN(0),
    DEVICE_LINK_STATE_NOT_LINKED(1),
    DEVICE_LINK_STATE_LINKED(2);
    
    private static final zzov<zzgu> zzd = new zzov<zzgu>() { // from class: com.google.android.gms.internal.cast.zzgs
    };
    private final int zze;

    zzgu(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzgt.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
