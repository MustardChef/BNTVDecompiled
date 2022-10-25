package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcw */
/* loaded from: classes3.dex */
final class zzcw extends zzaq<zzgh, zzgn> {
    final /* synthetic */ zzcx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(zzcx zzcxVar, Class cls) {
        super(cls);
        this.zza = zzcxVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ void zzb(zzgh zzghVar) throws GeneralSecurityException {
        zzdg.zza(zzghVar.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzgh zzc(zzym zzymVar) throws zzzw {
        return zzgh.zzb(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaq
    public final /* bridge */ /* synthetic */ zzgn zzd(zzgh zzghVar) throws GeneralSecurityException {
        zzgh zzghVar2 = zzghVar;
        ECParameterSpec zze = zzjw.zze(zzdg.zzc(zzghVar2.zza().zza().zza()));
        KeyPairGenerator zza = zzjy.zzf.zza("EC");
        zza.initialize(zze);
        KeyPair generateKeyPair = zza.generateKeyPair();
        ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
        zzgp zzf = zzgq.zzf();
        zzf.zza(0);
        zzf.zzb(zzghVar2.zza());
        zzf.zzc(zzym.zzm(w.getAffineX().toByteArray()));
        zzf.zzd(zzym.zzm(w.getAffineY().toByteArray()));
        zzgm zze2 = zzgn.zze();
        zze2.zza(0);
        zze2.zzb(zzf.zzl());
        zze2.zzc(zzym.zzm(((ECPrivateKey) generateKeyPair.getPrivate()).getS().toByteArray()));
        return zze2.zzl();
    }
}
