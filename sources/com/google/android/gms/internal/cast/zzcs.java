package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzcs {
    private static final ThreadLocal<zzcs> zza = new zzcm();

    public static zzcs zzb() {
        return zza.get();
    }

    public abstract void zza(zzcp zzcpVar);
}
