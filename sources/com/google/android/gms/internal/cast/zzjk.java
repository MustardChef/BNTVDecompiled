package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzjk implements zzou {
    TCP_PROBER_RESULT_UNKNOWN(0),
    TCP_PROBER_RESULT_SUCCESS(1),
    TCP_PROBER_RESULT_CONNECTION_ERROR(2),
    TCP_PROBER_RESULT_OTHER(99);
    
    private static final zzov<zzjk> zze = new zzov<zzjk>() { // from class: com.google.android.gms.internal.cast.zzji
    };
    private final int zzf;

    zzjk(int i) {
        this.zzf = i;
    }

    public static zzow zza() {
        return zzjj.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }
}
