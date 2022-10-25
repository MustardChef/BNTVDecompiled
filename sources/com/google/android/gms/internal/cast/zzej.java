package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzej implements zzou {
    RENDER_TARGET_UNKNOWN(0),
    RENDER_TARGET_CAMERA(1),
    RENDER_TARGET_RENDER_TEXTURE_SET_ON_CAMERA(2),
    RENDER_TARGET_RENDER_TEXTURE(3);
    
    private static final zzov<zzej> zze = new zzov<zzej>() { // from class: com.google.android.gms.internal.cast.zzeh
    };
    private final int zzf;

    zzej(int i) {
        this.zzf = i;
    }

    public static zzow zza() {
        return zzei.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }
}
