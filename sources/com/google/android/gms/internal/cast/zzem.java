package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzem implements zzou {
    TARGET_DELAY_UNKNOWN(0),
    TARGET_DELAY_MINIMUM(1),
    TARGET_DELAY_LOW(2),
    TARGET_DELAY_NORMAL(3),
    TARGET_DELAY_HIGH(4);
    
    private static final zzov<zzem> zzf = new zzov<zzem>() { // from class: com.google.android.gms.internal.cast.zzek
    };
    private final int zzg;

    zzem(int i) {
        this.zzg = i;
    }

    public static zzow zza() {
        return zzel.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
