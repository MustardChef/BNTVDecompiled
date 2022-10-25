package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdh */
/* loaded from: classes3.dex */
final class zzdh implements zzjr {
    private final String zza;
    private final int zzb;
    private zzfk zzc;
    private zzem zzd;
    private int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdh(zzht zzhtVar) throws GeneralSecurityException {
        String zza = zzhtVar.zza();
        this.zza = zza;
        if (zza.equals(zzbm.zzb)) {
            try {
                zzfn zzb = zzfn.zzb(zzhtVar.zzb(), zzzb.zza());
                this.zzc = (zzfk) zzbk.zzf(zzhtVar);
                this.zzb = zzb.zza();
            } catch (zzzw e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zza.equals(zzbm.zza)) {
            try {
                zzep zzc = zzep.zzc(zzhtVar.zzb(), zzzb.zza());
                this.zzd = (zzem) zzbk.zzf(zzhtVar);
                this.zze = zzc.zza().zzb();
                this.zzb = this.zze + zzc.zzb().zzb();
            } catch (zzzw e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(zza);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzjr
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzjr
    public final zzag zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.zza.equals(zzbm.zzb)) {
            zzfj zzd = zzfk.zzd();
            zzd.zzm(this.zzc);
            zzd.zzb(zzym.zzl(bArr, 0, this.zzb));
            return (zzag) zzbk.zzh(this.zza, zzd.zzl(), zzag.class);
        } else if (this.zza.equals(zzbm.zza)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            zzer zze = zzes.zze();
            zze.zzm(this.zzd.zzb());
            zze.zzc(zzym.zzm(copyOfRange));
            zzhc zze2 = zzhd.zze();
            zze2.zzm(this.zzd.zzc());
            zze2.zzc(zzym.zzm(copyOfRange2));
            zzel zze3 = zzem.zze();
            zze3.zza(this.zzd.zza());
            zze3.zzb(zze.zzl());
            zze3.zzc(zze2.zzl());
            return (zzag) zzbk.zzh(this.zza, zze3.zzl(), zzag.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
