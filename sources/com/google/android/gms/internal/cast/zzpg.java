package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public class zzpg {
    private static final zzoh zzb = zzoh.zza();
    protected volatile zzpy zza;
    private volatile zzny zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpg) {
            zzpg zzpgVar = (zzpg) obj;
            zzpy zzpyVar = this.zza;
            zzpy zzpyVar2 = zzpgVar.zza;
            if (zzpyVar == null && zzpyVar2 == null) {
                return zzb().equals(zzpgVar.zzb());
            }
            if (zzpyVar == null || zzpyVar2 == null) {
                if (zzpyVar != null) {
                    zzpgVar.zzc(zzpyVar.zzs());
                    return zzpyVar.equals(zzpgVar.zza);
                }
                zzc(zzpyVar2.zzs());
                return this.zza.equals(zzpyVar2);
            }
            return zzpyVar.equals(zzpyVar2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zznw) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzr();
        }
        return 0;
    }

    public final zzny zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzny.zzb;
            } else {
                this.zzc = this.zza.zzm();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzpy zzpyVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzpyVar;
                    this.zzc = zzny.zzb;
                } catch (zzpd unused) {
                    this.zza = zzpyVar;
                    this.zzc = zzny.zzb;
                }
            }
        }
    }
}
