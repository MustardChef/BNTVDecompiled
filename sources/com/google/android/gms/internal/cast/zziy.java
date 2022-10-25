package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zziy implements zzou {
    SEND_MESSAGE_RESULT_UNKNOWN(0),
    SEND_MESSAGE_RESULT_SUCCESS(1),
    SEND_MESSAGE_RESULT_FAIL_INVALID_REQUEST(2),
    SEND_MESSAGE_RESULT_FAIL_BUFFER_TOO_FULL(3),
    SEND_MESSAGE_RESULT_FAIL_MESSAGE_TOO_LARGE(4),
    SEND_MESSAGE_RESULT_FAIL_NETWORK_ERROR(5);
    
    private static final zzov<zziy> zzg = new zzov<zziy>() { // from class: com.google.android.gms.internal.cast.zziw
    };
    private final int zzh;

    zziy(int i) {
        this.zzh = i;
    }

    public static zzow zza() {
        return zzix.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
    }
}
