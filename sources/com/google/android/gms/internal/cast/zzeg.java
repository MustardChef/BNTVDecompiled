package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzeg implements zzou {
    RENDER_BACKEND_UNKNOWN(0),
    RENDER_BACKEND_OPENGL_ES_2(1),
    RENDER_BACKEND_OPENGL_ES_3(2),
    RENDER_BACKEND_METAL(3);
    
    private static final zzov<zzeg> zze = new zzov<zzeg>() { // from class: com.google.android.gms.internal.cast.zzee
    };
    private final int zzf;

    zzeg(int i) {
        this.zzf = i;
    }

    public static zzow zza() {
        return zzef.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }
}
