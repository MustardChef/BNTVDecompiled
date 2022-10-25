package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzfk implements zzou {
    APPLICATION_CONNECTION_FAILED_REASON_UNKNOWN(0),
    APPLICATION_NOT_FOUND(1),
    APPLICATION_NOT_RUNNING(2),
    APPLICATION_NOT_ALLOWED(3),
    LAUNCH_CANCELLED(4),
    LAUNCH_TIMED_OUT(5),
    INVALID_REQUEST(6);
    
    private static final zzov<zzfk> zzh = new zzov<zzfk>() { // from class: com.google.android.gms.internal.cast.zzfi
    };
    private final int zzi;

    zzfk(int i) {
        this.zzi = i;
    }

    public static zzow zza() {
        return zzfj.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
    }
}
