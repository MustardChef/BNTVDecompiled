package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbt */
/* loaded from: classes3.dex */
public final class zzbt extends zzas<zzem> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbt() {
        super(zzem.class, new zzbr(zzag.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzem zzd(zzym zzymVar) throws zzzw {
        return zzem.zzd(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzem zzemVar) throws GeneralSecurityException {
        zzem zzemVar2 = zzemVar;
        zzkr.zzb(zzemVar2.zza(), 0);
        new zzbw();
        zzbw.zzk(zzemVar2.zzb());
        new zzdv();
        zzdv.zzk(zzemVar2.zzc());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzem> zzi() {
        return new zzbs(this, zzep.class);
    }
}
