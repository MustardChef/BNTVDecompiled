package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public class zzio {
    private static final zzhl zza = zzhl.zza();
    private zzgp zzb;
    private volatile zzjj zzc;
    private volatile zzgp zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzio) {
            zzio zzioVar = (zzio) obj;
            zzjj zzjjVar = this.zzc;
            zzjj zzjjVar2 = zzioVar.zzc;
            if (zzjjVar == null && zzjjVar2 == null) {
                return zzc().equals(zzioVar.zzc());
            }
            if (zzjjVar == null || zzjjVar2 == null) {
                if (zzjjVar != null) {
                    return zzjjVar.equals(zzioVar.zzb(zzjjVar.zzbv()));
                }
                return zzb(zzjjVar2.zzbv()).equals(zzjjVar2);
            }
            return zzjjVar.equals(zzjjVar2);
        }
        return false;
    }

    private final zzjj zzb(zzjj zzjjVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzjjVar;
                        this.zzd = zzgp.zza;
                    } catch (zzij unused) {
                        this.zzc = zzjjVar;
                        this.zzd = zzgp.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzjj zza(zzjj zzjjVar) {
        zzjj zzjjVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjjVar;
        return zzjjVar2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbp();
        }
        return 0;
    }

    public final zzgp zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzgp.zza;
            } else {
                this.zzd = this.zzc.zzbj();
            }
            return this.zzd;
        }
    }
}
