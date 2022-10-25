package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zziv implements zzou {
    REMOTE_CONTROL_NOTIFICATION_FAILURE_UNKNOWN(0),
    REMOTE_CONTROL_NOTIFICATION_FAILED_TO_CONNECT(1),
    REMOTE_CONTROL_NOTIFICATION_FAILED_TO_JOIN_APPLICATION(2),
    REMOTE_CONTROL_NOTIFICATION_RECEIVED_INVALID_DEVICE_STATUS(3),
    REMOTE_CONTROL_NOTIFICATION_RECEIVED_INVALID_MEDIA_STATUS(4),
    REMOTE_CONTROL_NOTIFICATION_FAILED_TO_SET_MEDIA_NAMESPACE_CALLBACK(5),
    REMOTE_CONTROL_NOTIFICATION_FAILED_TO_REQUEST_RECEIVER_STATUS(6);
    
    private static final zzov<zziv> zzh = new zzov<zziv>() { // from class: com.google.android.gms.internal.cast.zzit
    };
    private final int zzi;

    zziv(int i) {
        this.zzi = i;
    }

    public static zzow zza() {
        return zziu.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
    }
}
