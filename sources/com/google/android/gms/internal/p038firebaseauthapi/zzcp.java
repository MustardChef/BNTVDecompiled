package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcp */
/* loaded from: classes3.dex */
public final class zzcp extends zzas<zzip> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcp() {
        super(zzip.class, new zzcn(zzag.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.REMOTE;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzip zzd(zzym zzymVar) throws zzzw {
        return zzip.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzip zzipVar) throws GeneralSecurityException {
        zzkr.zzb(zzipVar.zza(), 0);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzip> zzi() {
        return new zzco(this, zzis.class);
    }
}
