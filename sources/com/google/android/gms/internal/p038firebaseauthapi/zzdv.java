package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdv */
/* loaded from: classes3.dex */
public final class zzdv extends zzas<zzhd> {
    public zzdv() {
        super(zzhd.class, new zzdt(zzay.class));
    }

    public static final void zzk(zzhd zzhdVar) throws GeneralSecurityException {
        zzkr.zzb(zzhdVar.zza(), 0);
        if (zzhdVar.zzc().zzc() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzl(zzhdVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzl(zzhj zzhjVar) throws GeneralSecurityException {
        if (zzhjVar.zzb() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        zzha zzhaVar = zzha.UNKNOWN_HASH;
        int ordinal = zzhjVar.zza().ordinal();
        if (ordinal == 1) {
            if (zzhjVar.zzb() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (ordinal == 3) {
            if (zzhjVar.zzb() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (ordinal == 4) {
            if (zzhjVar.zzb() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzhd zzd(zzym zzymVar) throws zzzw {
        return zzhd.zzd(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzhd zzhdVar) throws GeneralSecurityException {
        zzk(zzhdVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzhd> zzi() {
        return new zzdu(this, zzhg.class);
    }
}
