package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzhg implements zzou {
    UNKNOWN(0),
    POSIX(1),
    OSSTATUS(2),
    COCOA(3);
    
    private static final zzov<zzhg> zze = new zzov<zzhg>() { // from class: com.google.android.gms.internal.cast.zzhe
    };
    private final int zzf;

    zzhg(int i) {
        this.zzf = i;
    }

    public static zzow zza() {
        return zzhf.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }
}
