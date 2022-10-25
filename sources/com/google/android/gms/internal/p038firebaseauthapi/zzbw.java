package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbw */
/* loaded from: classes3.dex */
public final class zzbw extends zzas<zzes> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbw() {
        super(zzes.class, new zzbu(zzki.class));
    }

    public static final void zzk(zzes zzesVar) throws GeneralSecurityException {
        zzkr.zzb(zzesVar.zza(), 0);
        zzkr.zza(zzesVar.zzc().zzc());
        zzl(zzesVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzl(zzey zzeyVar) throws GeneralSecurityException {
        if (zzeyVar.zza() < 12 || zzeyVar.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzes zzd(zzym zzymVar) throws zzzw {
        return zzes.zzd(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzes zzesVar) throws GeneralSecurityException {
        zzk(zzesVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzes> zzi() {
        return new zzbv(this, zzev.class);
    }
}
