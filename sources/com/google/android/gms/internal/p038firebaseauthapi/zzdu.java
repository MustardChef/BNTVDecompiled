package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdu */
/* loaded from: classes3.dex */
final class zzdu extends zzaq<zzhg, zzhd> {
    final /* synthetic */ zzdv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdu(zzdv zzdvVar, Class cls) {
        super(cls);
        this.zza = zzdvVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ void zzb(zzhg zzhgVar) throws GeneralSecurityException {
        zzhg zzhgVar2 = zzhgVar;
        if (zzhgVar2.zzb() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzdv.zzl(zzhgVar2.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzhg zzc(zzym zzymVar) throws zzzw {
        return zzhg.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzhd zzd(zzhg zzhgVar) throws GeneralSecurityException {
        zzhg zzhgVar2 = zzhgVar;
        zzhc zze = zzhd.zze();
        zze.zza(0);
        zze.zzb(zzhgVar2.zza());
        zze.zzc(zzym.zzm(zzkp.zza(zzhgVar2.zzb())));
        return zze.zzl();
    }
}
