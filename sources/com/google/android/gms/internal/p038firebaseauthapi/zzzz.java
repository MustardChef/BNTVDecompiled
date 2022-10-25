package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzz */
/* loaded from: classes3.dex */
public class zzzz {
    private static final zzzb zzb = zzzb.zza();
    protected volatile zzaar zza;
    private volatile zzym zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzzz) {
            zzzz zzzzVar = (zzzz) obj;
            zzaar zzaarVar = this.zza;
            zzaar zzaarVar2 = zzzzVar.zza;
            if (zzaarVar == null && zzaarVar2 == null) {
                return zzb().equals(zzzzVar.zzb());
            }
            if (zzaarVar == null || zzaarVar2 == null) {
                if (zzaarVar != null) {
                    zzzzVar.zzc(zzaarVar.zzo());
                    return zzaarVar.equals(zzzzVar.zza);
                }
                zzc(zzaarVar2.zzo());
                return this.zza.equals(zzaarVar2);
            }
            return zzaarVar.equals(zzaarVar2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzyk) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzw();
        }
        return 0;
    }

    public final zzym zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzym.zzb;
            } else {
                this.zzc = this.zza.zzn();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzaar zzaarVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzaarVar;
                    this.zzc = zzym.zzb;
                } catch (zzzw unused) {
                    this.zza = zzaarVar;
                    this.zzc = zzym.zzb;
                }
            }
        }
    }
}
