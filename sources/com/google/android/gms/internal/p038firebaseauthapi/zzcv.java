package com.google.android.gms.internal.p038firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcv */
/* loaded from: classes3.dex */
public final class zzcv extends zzar<zzak, zzgn> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcv(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzar
    public final /* bridge */ /* synthetic */ zzak zzb(zzgn zzgnVar) throws GeneralSecurityException {
        zzgn zzgnVar2 = zzgnVar;
        zzgk zzb = zzgnVar2.zzb().zzb();
        zzgt zza = zzb.zza();
        int zzc = zzdg.zzc(zza.zza());
        byte[] zzp = zzgnVar2.zzc().zzp();
        return new zzjs((ECPrivateKey) zzjy.zzg.zza("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, zzp), zzjw.zze(zzc))), zza.zzc().zzp(), zzdg.zzb(zza.zzb()), zzdg.zzd(zzb.zzc()), new zzdh(zzb.zzb().zza()));
    }
}
