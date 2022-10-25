package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaav */
/* loaded from: classes3.dex */
final class zzaav<T> implements zzabd<T> {
    private final zzaar zza;
    private final zzabr<?, ?> zzb;
    private final boolean zzc;
    private final zzzc<?> zzd;

    private zzaav(zzabr<?, ?> zzabrVar, zzzc<?> zzzcVar, zzaar zzaarVar) {
        this.zzb = zzabrVar;
        this.zzc = zzzcVar.zza(zzaarVar);
        this.zzd = zzzcVar;
        this.zza = zzaarVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzaav<T> zzg(zzabr<?, ?> zzabrVar, zzzc<?> zzzcVar, zzaar zzaarVar) {
        return new zzaav<>(zzabrVar, zzzcVar, zzaarVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final T zza() {
        return (T) this.zza.zzH().zzn();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final boolean zzb(T t, T t2) {
        if (this.zzb.zzj(t).equals(this.zzb.zzj(t2))) {
            if (this.zzc) {
                this.zzd.zzb(t);
                this.zzd.zzb(t2);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final int zzc(T t) {
        int hashCode = this.zzb.zzj(t).hashCode();
        if (this.zzc) {
            this.zzd.zzb(t);
            throw null;
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzd(T t, T t2) {
        zzabf.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzabf.zzE(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final int zze(T t) {
        zzabr<?, ?> zzabrVar = this.zzb;
        int zzp = zzabrVar.zzp(zzabrVar.zzj(t));
        if (this.zzc) {
            this.zzd.zzb(t);
            throw null;
        }
        return zzp;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzf(T t, zzabc zzabcVar, zzzb zzzbVar) throws IOException {
        boolean zzd;
        zzabr<?, ?> zzabrVar = this.zzb;
        zzzc<?> zzzcVar = this.zzd;
        Object zzk = zzabrVar.zzk(t);
        zzzg<?> zzc = zzzcVar.zzc(t);
        while (zzabcVar.zzb() != Integer.MAX_VALUE) {
            try {
                int zzc2 = zzabcVar.zzc();
                if (zzc2 != 11) {
                    if ((zzc2 & 7) == 2) {
                        Object zzf = zzzcVar.zzf(zzzbVar, this.zza, zzc2 >>> 3);
                        if (zzf != null) {
                            zzzcVar.zzg(zzabcVar, zzf, zzzbVar, zzc);
                        } else {
                            zzd = zzabrVar.zzn(zzk, zzabcVar);
                        }
                    } else {
                        zzd = zzabcVar.zzd();
                    }
                    if (!zzd) {
                        return;
                    }
                } else {
                    int i = 0;
                    Object obj = null;
                    zzym zzymVar = null;
                    while (zzabcVar.zzb() != Integer.MAX_VALUE) {
                        int zzc3 = zzabcVar.zzc();
                        if (zzc3 == 16) {
                            i = zzabcVar.zzr();
                            obj = zzzcVar.zzf(zzzbVar, this.zza, i);
                        } else if (zzc3 == 26) {
                            if (obj != null) {
                                zzzcVar.zzg(zzabcVar, obj, zzzbVar, zzc);
                            } else {
                                zzymVar = zzabcVar.zzq();
                            }
                        } else if (!zzabcVar.zzd()) {
                            break;
                        }
                    }
                    if (zzabcVar.zzc() != 12) {
                        throw zzzw.zzf();
                    } else if (zzymVar != null) {
                        if (obj != null) {
                            zzzcVar.zzh(zzymVar, obj, zzzbVar, zzc);
                        } else {
                            zzabrVar.zze(zzk, i, zzymVar);
                        }
                    }
                }
            } finally {
                zzabrVar.zzl(t, zzk);
            }
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzi(T t, byte[] bArr, int i, int i2, zzxx zzxxVar) throws IOException {
        zzzo zzzoVar = (zzzo) t;
        if (zzzoVar.zzc == zzabs.zza()) {
            zzzoVar.zzc = zzabs.zzb();
        }
        zzzl zzzlVar = (zzzl) t;
        throw null;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzj(T t) {
        this.zzb.zzm(t);
        this.zzd.zzd(t);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final boolean zzk(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzn(T t, zzyx zzyxVar) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
