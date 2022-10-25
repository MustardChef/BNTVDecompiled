package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzby */
/* loaded from: classes3.dex */
final class zzby extends zzaq<zzfe, zzfb> {
    final /* synthetic */ zzbz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzby(zzbz zzbzVar, Class cls) {
        super(cls);
        this.zza = zzbzVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ void zzb(zzfe zzfeVar) throws GeneralSecurityException {
        zzfe zzfeVar2 = zzfeVar;
        zzkr.zza(zzfeVar2.zzb());
        if (zzfeVar2.zza().zza() != 12 && zzfeVar2.zza().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzfe zzc(zzym zzymVar) throws zzzw {
        return zzfe.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzfb zzd(zzfe zzfeVar) throws GeneralSecurityException {
        zzfe zzfeVar2 = zzfeVar;
        zzfa zze = zzfb.zze();
        zze.zzc(zzym.zzm(zzkp.zza(zzfeVar2.zzb())));
        zze.zzb(zzfeVar2.zza());
        zze.zza(0);
        return zze.zzl();
    }
}
