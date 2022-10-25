package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzij implements zzou {
    PRECACHE_MESSAGE_RESULT_UNKNOWN(0),
    PRECACHE_MESSAGE_RESULT_SENT(1),
    PRECACHE_MESSAGE_RESULT_FAILED(2);
    
    private static final zzov<zzij> zzd = new zzov<zzij>() { // from class: com.google.android.gms.internal.cast.zzih
    };
    private final int zze;

    zzij(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzii.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
