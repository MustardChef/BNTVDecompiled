package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgc implements zzou {
    CONNECTION_TYPE_UNKNOWN(0),
    CONNECTION_TYPE_STRONG(1),
    CONNECTION_TYPE_INVISIBLE(2);
    
    private static final zzov<zzgc> zzd = new zzov<zzgc>() { // from class: com.google.android.gms.internal.cast.zzga
    };
    private final int zze;

    zzgc(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzgb.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
