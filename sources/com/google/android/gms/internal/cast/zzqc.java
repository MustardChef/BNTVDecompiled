package com.google.android.gms.internal.cast;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzqc<T> implements zzqj<T> {
    private final zzpy zza;
    private final zzqx<?, ?> zzb;
    private final boolean zzc;
    private final zzoi<?> zzd;

    private zzqc(zzqx<?, ?> zzqxVar, zzoi<?> zzoiVar, zzpy zzpyVar) {
        this.zzb = zzqxVar;
        this.zzc = zzoiVar.zza(zzpyVar);
        this.zzd = zzoiVar;
        this.zza = zzpyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzqc<T> zzg(zzqx<?, ?> zzqxVar, zzoi<?> zzoiVar, zzpy zzpyVar) {
        return new zzqc<>(zzqxVar, zzoiVar, zzpyVar);
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final boolean zza(T t, T t2) {
        if (this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            if (this.zzc) {
                this.zzd.zzb(t);
                this.zzd.zzb(t2);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final int zzb(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        if (this.zzc) {
            this.zzd.zzb(t);
            throw null;
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final void zzc(T t, T t2) {
        zzql.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzql.zzE(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final int zzd(T t) {
        zzqx<?, ?> zzqxVar = this.zzb;
        int zze = zzqxVar.zze(zzqxVar.zzb(t));
        if (this.zzc) {
            this.zzd.zzb(t);
            throw null;
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final void zze(T t) {
        this.zzb.zzc(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final boolean zzf(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final void zzi(T t, zzog zzogVar) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
