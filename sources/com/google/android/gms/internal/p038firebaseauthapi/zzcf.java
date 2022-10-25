package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcf */
/* loaded from: classes3.dex */
public final class zzcf extends zzas<zzfq> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcf() {
        super(zzfq.class, new zzcd(zzag.class));
    }

    public static void zzj(boolean z) throws GeneralSecurityException {
        if (zzk()) {
            zzbk.zza(new zzcf(), true);
        }
    }

    private static boolean zzk() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzhn zzc() {
        return zzhn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ zzfq zzd(zzym zzymVar) throws zzzw {
        return zzfq.zzc(zzymVar, zzzb.zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final /* bridge */ /* synthetic */ void zze(zzfq zzfqVar) throws GeneralSecurityException {
        zzfq zzfqVar2 = zzfqVar;
        zzkr.zzb(zzfqVar2.zza(), 0);
        zzkr.zza(zzfqVar2.zzb().zzc());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzas
    public final zzaq<?, zzfq> zzi() {
        return new zzce(this, zzft.class);
    }
}
