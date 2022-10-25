package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzhr implements zzou {
    LAUNCH_UNKNOWN(0),
    JOIN(1),
    LAUNCH(2);
    
    private static final zzov<zzhr> zzd = new zzov<zzhr>() { // from class: com.google.android.gms.internal.cast.zzhp
    };
    private final int zze;

    zzhr(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzhq.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
