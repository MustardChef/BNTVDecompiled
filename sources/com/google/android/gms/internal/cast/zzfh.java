package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzfh implements zzou {
    APP_SESSION_REASON_UNKNOWN(0),
    APP_SESSION_REASON_ERROR(1),
    APP_SESSION_NETWORK_ERROR(2),
    APP_SESSION_NETWORK_RECOVERED(3),
    APP_SESSION_RECEIVER_CONNECTION_LOSS(4),
    APP_SESSION_RECEIVER_CONNECTION_RECOVERED(5),
    APP_SESSION_APP_BACKGROUNDED(6),
    APP_SESSION_APP_FOREGROUNDED(7),
    APP_SESSION_APP_STOPPED(8),
    APP_SESSION_CASTING_STOPPED(9),
    APP_SESSION_RESUMED_FROM_SAVED_SESSION(10),
    APP_SESSION_RESUMED_FROM_OPEN_URL(11),
    APP_SESSION_NETWORK_NOT_REACHABLE(12),
    APP_SESSION_GMSCORE_SERVICE_DISCONNECTED(13),
    APP_SESSION_ENDPOINT_SWITCHED(14),
    APP_SESSION_DEVICE_CONNECTION_SUSPENDED(15),
    APP_SESSION_MEDIA_ROUTE_CHANGED(16);
    
    private static final zzov<zzfh> zzr = new zzov<zzfh>() { // from class: com.google.android.gms.internal.cast.zzff
    };
    private final int zzs;

    zzfh(int i) {
        this.zzs = i;
    }

    public static zzow zzb() {
        return zzfg.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzs + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zzs;
    }
}
