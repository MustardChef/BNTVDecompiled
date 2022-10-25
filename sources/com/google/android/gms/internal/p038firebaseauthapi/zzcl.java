package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcl */
/* loaded from: classes3.dex */
public final class zzcl extends zzas<zzij> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcl() {
        super(zzij.class, new zzcj(zzag.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.REMOTE;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzij zzd(zzym zzymVar) throws zzzw {
        return zzij.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzij zzijVar) throws GeneralSecurityException {
        zzkr.zzb(zzijVar.zza(), 0);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzij> zzi() {
        return new zzck(this, zzim.class);
    }
}
