package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzdz implements zzou {
    AUDIO_FORMAT_UNKNOWN(0),
    AUDIO_FORMAT_AV_AUDIO_PCM_FLOAT_32(1),
    AUDIO_FORMAT_AV_AUDIO_PCM_FLOAT_64(2),
    AUDIO_FORMAT_AV_AUDIO_PCM_INT_16(3),
    AUDIO_FORMAT_AV_AUDIO_PCM_INT_32(4);
    
    private static final zzov<zzdz> zzf = new zzov<zzdz>() { // from class: com.google.android.gms.internal.cast.zzdx
    };
    private final int zzg;

    zzdz(int i) {
        this.zzg = i;
    }

    public static zzow zza() {
        return zzdy.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
