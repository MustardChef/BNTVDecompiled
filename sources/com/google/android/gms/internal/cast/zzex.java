package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzex implements zzou {
    PLUGIN_TYPE_UNKNOWN(0),
    PLUGIN_TYPE_UNITY_3D(1);
    
    private static final zzov<zzex> zzc = new zzov<zzex>() { // from class: com.google.android.gms.internal.cast.zzev
    };
    private final int zzd;

    zzex(int i) {
        this.zzd = i;
    }

    public static zzow zza() {
        return zzew.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
    }
}
