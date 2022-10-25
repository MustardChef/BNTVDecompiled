package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzci */
/* loaded from: classes3.dex */
public final class zzci extends zzas<zzfw> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzci() {
        super(zzfw.class, new zzcg(zzag.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzfw zzd(zzym zzymVar) throws zzzw {
        return zzfw.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzfw zzfwVar) throws GeneralSecurityException {
        zzfw zzfwVar2 = zzfwVar;
        zzkr.zzb(zzfwVar2.zza(), 0);
        if (zzfwVar2.zzb().zzc() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzfw> zzi() {
        return new zzch(this, zzfz.class);
    }
}
