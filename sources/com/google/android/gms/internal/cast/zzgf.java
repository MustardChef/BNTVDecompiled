package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgf implements zzou {
    CONSUME_CHUNK_RESULT_UNKNOWN(0),
    CONSUME_CHUNK_RESULT_SUCCESS(1),
    CONSUME_CHUNK_RESULT_FAIL_STRING_PAYLOAD_NOT_ALLOWED(3),
    CONSUME_CHUNK_RESULT_FAIL_NO_PAYLOAD(4),
    CONSUME_CHUNK_RESULT_FAIL_MISMATCHING_CONTINUATION_PAYLOAD_TYPE(5);
    
    private static final zzov<zzgf> zzf = new zzov<zzgf>() { // from class: com.google.android.gms.internal.cast.zzgd
    };
    private final int zzg;

    zzgf(int i) {
        this.zzg = i;
    }

    public static zzow zza() {
        return zzge.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
