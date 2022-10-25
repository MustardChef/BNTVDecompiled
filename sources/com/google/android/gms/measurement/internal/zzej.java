package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzej<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzeh<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzej(String str, V v, V v2, zzeh<V> zzehVar) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzehVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zza(V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzeg.zza == null) {
            return this.zzc;
        }
        synchronized (zzf) {
            if (zzw.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
            try {
                for (zzej zzejVar : zzas.zzcl()) {
                    if (zzw.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v2 = null;
                    try {
                        zzeh<V> zzehVar = zzejVar.zzb;
                        if (zzehVar != null) {
                            v2 = zzehVar.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zzf) {
                        zzejVar.zzh = v2;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzeh<V> zzehVar2 = this.zzb;
            if (zzehVar2 == null) {
                return this.zzc;
            }
            try {
                return zzehVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzc;
            } catch (SecurityException unused4) {
                return this.zzc;
            }
        }
    }
}
