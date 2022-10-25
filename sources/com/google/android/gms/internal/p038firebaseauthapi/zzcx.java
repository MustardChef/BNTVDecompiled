package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcx */
/* loaded from: classes3.dex */
public final class zzcx extends zzbf<zzgn, zzgq> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcx() {
        super(zzgn.class, zzgq.class, new zzcv(zzak.class));
    }

    public static final void zzj(zzgn zzgnVar) throws GeneralSecurityException {
        if (zzgnVar.zzc().zzc() != 0) {
            zzkr.zzb(zzgnVar.zza(), 0);
            zzdg.zza(zzgnVar.zzb().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzaar zzd(zzym zzymVar) throws zzzw {
        return zzgn.zzd(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzaar zzaarVar) throws GeneralSecurityException {
        zzj((zzgn) zzaarVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<zzgh, zzgn> zzi() {
        return new zzcw(this, zzgh.class);
    }
}
