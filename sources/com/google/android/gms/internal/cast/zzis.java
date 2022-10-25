package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzis implements zzou {
    REMOTE_CONTROL_NOTIFICATION_CLICK_THROUGH_RESULT_NO_OP(0),
    REMOTE_CONTROL_NOTIFICATION_CLICK_THROUGH_RESULT_OPEN_PARTNER_APP(1),
    REMOTE_CONTROL_NOTIFICATION_CLICK_THROUGH_RESULT_OPEN_HOME_APP(2),
    REMOTE_CONTROL_NOTIFICATION_CLICK_THROUGH_RESULT_OPEN_PARTNER_APP_PLAY_STORE(3),
    REMOTE_CONTROL_NOTIFICATION_CLICK_THROUGH_RESULT_OPEN_HOME_APP_PLAY_STORE(4);
    
    private static final zzov<zzis> zzf = new zzov<zzis>() { // from class: com.google.android.gms.internal.cast.zziq
    };
    private final int zzg;

    zzis(int i) {
        this.zzg = i;
    }

    public static zzow zza() {
        return zzir.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
