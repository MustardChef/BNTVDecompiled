package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzfq implements zzou {
    RESULT_UNKNOWN(0),
    DECODE_SUCCESS(1),
    REQUEST_TIMED_OUT(2),
    USER_CANCELLED(3),
    USER_INTERRUPTED_AUDIO_PARING(4);
    
    private static final zzov<zzfq> zzf = new zzov<zzfq>() { // from class: com.google.android.gms.internal.cast.zzfo
    };
    private final int zzg;

    zzfq(int i) {
        this.zzg = i;
    }

    public static zzow zza() {
        return zzfp.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
