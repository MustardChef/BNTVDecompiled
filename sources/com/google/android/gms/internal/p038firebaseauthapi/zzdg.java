package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdg */
/* loaded from: classes3.dex */
public final class zzdg {
    public static void zza(zzgk zzgkVar) throws GeneralSecurityException {
        zzjw.zze(zzc(zzgkVar.zza().zza()));
        zzb(zzgkVar.zza().zzb());
        if (zzgkVar.zzc() == zzgb.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzbk.zze(zzgkVar.zzb().zza());
    }

    public static String zzb(zzha zzhaVar) throws NoSuchAlgorithmException {
        zzgb zzgbVar = zzgb.UNKNOWN_FORMAT;
        zzgv zzgvVar = zzgv.UNKNOWN_CURVE;
        zzha zzhaVar2 = zzha.UNKNOWN_HASH;
        int ordinal = zzhaVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 3) {
                if (ordinal == 4) {
                    return "HmacSha512";
                }
                String valueOf = String.valueOf(zzhaVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
            }
            return "HmacSha256";
        }
        return "HmacSha1";
    }

    public static int zzc(zzgv zzgvVar) throws GeneralSecurityException {
        zzgb zzgbVar = zzgb.UNKNOWN_FORMAT;
        zzgv zzgvVar2 = zzgv.UNKNOWN_CURVE;
        zzha zzhaVar = zzha.UNKNOWN_HASH;
        int ordinal = zzgvVar.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzgvVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }

    public static int zzd(zzgb zzgbVar) throws GeneralSecurityException {
        zzgb zzgbVar2 = zzgb.UNKNOWN_FORMAT;
        zzgv zzgvVar = zzgv.UNKNOWN_CURVE;
        zzha zzhaVar = zzha.UNKNOWN_HASH;
        int ordinal = zzgbVar.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzgbVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }
}
