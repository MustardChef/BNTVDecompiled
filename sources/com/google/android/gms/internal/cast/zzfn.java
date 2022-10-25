package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzfn implements zzou {
    BROADCAST_ERROR_UNKNOWN(0),
    BROADCAST_ERROR_ENCRYPTION_FAILED(1),
    BROADCAST_ERROR_SOCKET_ERROR(2),
    BROADCAST_ERROR_DROPPED(3),
    BROADCAST_ERROR_KEY_EXCHANGE_INVALID_INPUT(4),
    BROADCAST_ERROR_KEY_EXCHANGE_INVALID_RESPONSE(5),
    BROADCAST_ERROR_KEY_EXCHANGE_EMPTY_RESPONSE(6),
    BROADCAST_ERROR_KEY_EXCHANGE_FAILED_TO_FIND_DEVICE(7),
    BROADCAST_ERROR_KEY_EXCHANGE_FAILED_TO_CONNECT(8),
    BROADCAST_ERROR_KEY_EXCHANGE_REQUEST_TIMED_OUT(9);
    
    private static final zzov<zzfn> zzk = new zzov<zzfn>() { // from class: com.google.android.gms.internal.cast.zzfl
    };
    private final int zzl;

    zzfn(int i) {
        this.zzl = i;
    }

    public static zzow zza() {
        return zzfm.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzl + " name=" + name() + Typography.greater;
    }
}
