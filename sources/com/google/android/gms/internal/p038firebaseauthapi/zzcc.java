package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcc */
/* loaded from: classes3.dex */
public final class zzcc extends zzas<zzfk> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcc() {
        super(zzfk.class, new zzca(zzag.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzfk zzd(zzym zzymVar) throws zzzw {
        return zzfk.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzfk zzfkVar) throws GeneralSecurityException {
        zzfk zzfkVar2 = zzfkVar;
        zzkr.zzb(zzfkVar2.zza(), 0);
        zzkr.zza(zzfkVar2.zzb().zzc());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzfk> zzi() {
        return new zzcb(this, zzfn.class);
    }
}
