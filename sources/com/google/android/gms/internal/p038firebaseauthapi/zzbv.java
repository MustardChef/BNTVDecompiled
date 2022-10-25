package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbv */
/* loaded from: classes3.dex */
final class zzbv extends zzaq<zzev, zzes> {
    final /* synthetic */ zzbw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbv(zzbw zzbwVar, Class cls) {
        super(cls);
        this.zza = zzbwVar;
    }

    public static final zzes zzf(zzev zzevVar) throws GeneralSecurityException {
        zzer zze = zzes.zze();
        zze.zzb(zzevVar.zza());
        zze.zzc(zzym.zzm(zzkp.zza(zzevVar.zzb())));
        zze.zza(0);
        return zze.zzl();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzev zzc(zzym zzymVar) throws zzzw {
        return zzev.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzes zzd(zzev zzevVar) throws GeneralSecurityException {
        return zzf(zzevVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    /* renamed from: zze */
    public final void zzb(zzev zzevVar) throws GeneralSecurityException {
        zzkr.zza(zzevVar.zzb());
        zzbw zzbwVar = this.zza;
        zzbw.zzl(zzevVar.zza());
    }
}
