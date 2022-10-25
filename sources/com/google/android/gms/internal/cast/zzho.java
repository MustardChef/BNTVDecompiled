package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzho implements zzou {
    KEY_EXCHANGE_UNKNOWN(0),
    KEY_EXCHANGE_SUCCEEDED(1),
    KEY_EXCHANGE_FAILED(2);
    
    private static final zzov<zzho> zzd = new zzov<zzho>() { // from class: com.google.android.gms.internal.cast.zzhm
    };
    private final int zze;

    zzho(int i) {
        this.zze = i;
    }

    public static zzow zza() {
        return zzhn.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
