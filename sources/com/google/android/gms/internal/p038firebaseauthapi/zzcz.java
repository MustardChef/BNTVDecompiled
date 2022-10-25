package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcz */
/* loaded from: classes3.dex */
final class zzcz extends zzas<zzgq> {
    public zzcz() {
        super(zzgq.class, new zzcy(zzal.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzgq zzd(zzym zzymVar) throws zzzw {
        return zzgq.zze(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzgq zzgqVar) throws GeneralSecurityException {
        zzgq zzgqVar2 = zzgqVar;
        zzkr.zzb(zzgqVar2.zza(), 0);
        zzdg.zza(zzgqVar2.zzb());
    }
}
