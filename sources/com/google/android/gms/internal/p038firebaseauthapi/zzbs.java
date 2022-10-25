package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbs */
/* loaded from: classes3.dex */
final class zzbs extends zzaq<zzep, zzem> {
    final /* synthetic */ zzbt zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbs(zzbt zzbtVar, Class cls) {
        super(cls);
        this.zza = zzbtVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ void zzb(zzep zzepVar) throws GeneralSecurityException {
        zzep zzepVar2 = zzepVar;
        ((zzbv) new zzbw().zzi()).zzb(zzepVar2.zza());
        new zzdv().zzi().zzb(zzepVar2.zzb());
        zzkr.zza(zzepVar2.zza().zzb());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzep zzc(zzym zzymVar) throws zzzw {
        return zzep.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzem zzd(zzep zzepVar) throws GeneralSecurityException {
        zzep zzepVar2 = zzepVar;
        new zzbw();
        zzes zzf = zzbv.zzf(zzepVar2.zza());
        zzhd zzd = new zzdv().zzi().zzd(zzepVar2.zzb());
        zzel zze = zzem.zze();
        zze.zzb(zzf);
        zze.zzc(zzd);
        zze.zza(0);
        return zze.zzl();
    }
}
