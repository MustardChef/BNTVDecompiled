package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds */
/* loaded from: classes3.dex */
public final class zzds extends zzas<zzed> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzds() {
        super(zzed.class, new zzdq(zzay.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzl(zzej zzejVar) throws GeneralSecurityException {
        if (zzejVar.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzejVar.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzm(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzed zzd(zzym zzymVar) throws zzzw {
        return zzed.zzd(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzed zzedVar) throws GeneralSecurityException {
        zzed zzedVar2 = zzedVar;
        zzkr.zzb(zzedVar2.zza(), 0);
        zzm(zzedVar2.zzb().zzc());
        zzl(zzedVar2.zzc());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzed> zzi() {
        return new zzdr(this, zzeg.class);
    }
}
