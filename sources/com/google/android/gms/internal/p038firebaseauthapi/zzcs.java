package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcs */
/* loaded from: classes3.dex */
public final class zzcs extends zzas<zzja> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcs() {
        super(zzja.class, new zzcq(zzag.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzja zzd(zzym zzymVar) throws zzzw {
        return zzja.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzja zzjaVar) throws GeneralSecurityException {
        zzja zzjaVar2 = zzjaVar;
        zzkr.zzb(zzjaVar2.zza(), 0);
        if (zzjaVar2.zzb().zzc() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzja> zzi() {
        return new zzcr(this, zzjd.class);
    }
}
