package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzip implements zzou {
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_UNKNOWN(0),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_USER_DISMISSED(1),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_USER_STOPPED(2),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_RECEIVER_OFFLINE(3),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_SENDER_BECAME_PRIMARY(4),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_RECEIVER_PRIVATE_MODE(5),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_USER_DISABLE_FROM_SETTINGS(6),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_CONNECTION_TO_GMSCORE_FAILED(7),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_CONNECTION_TO_RECEIVER_FAILED(8),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_NEW_SERVICE_STARTED(9),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_INVALID_APPLICATION(10),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_APPLICATION_DISCONNECTED(11),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_NO_MEDIA_SESSION(12),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_REASON_SERVICE_STOPPED(13),
    REMOTE_CONTROL_NOTIFICATION_CANCEL_SCEEN_OFF(14);
    
    private static final zzov<zzip> zzp = new zzov<zzip>() { // from class: com.google.android.gms.internal.cast.zzin
    };
    private final int zzq;

    zzip(int i) {
        this.zzq = i;
    }

    public static zzow zza() {
        return zzio.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzq + " name=" + name() + Typography.greater;
    }
}
