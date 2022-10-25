package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzec implements zzou {
    BITRATE_MODE_UNKNOWN(0),
    BITRATE_MODE_FIXED(1),
    BITRATE_MODE_ADAPTIVE(2);
    
    private static final zzov<zzec> zzd = new zzov<zzec>() { // from class: com.google.android.gms.internal.cast.zzea
    };
    private final int zze;

    zzec(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzeb.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
