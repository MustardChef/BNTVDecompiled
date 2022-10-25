package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz */
/* loaded from: classes3.dex */
public final class zzbz extends zzas<zzfb> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbz() {
        super(zzfb.class, new zzbx(zzag.class));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzfb zzd(zzym zzymVar) throws zzzw {
        return zzfb.zzd(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzfb zzfbVar) throws GeneralSecurityException {
        zzfb zzfbVar2 = zzfbVar;
        zzkr.zzb(zzfbVar2.zza(), 0);
        zzkr.zza(zzfbVar2.zzc().zzc());
        if (zzfbVar2.zzb().zza() != 12 && zzfbVar2.zzb().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzfb> zzi() {
        return new zzby(this, zzfe.class);
    }
}
