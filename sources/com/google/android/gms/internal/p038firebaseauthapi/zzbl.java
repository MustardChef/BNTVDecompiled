package com.google.android.gms.internal.p038firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbl */
/* loaded from: classes3.dex */
final class zzbl {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzig zza(zzib zzibVar) {
        zzid zzb = zzig.zzb();
        zzb.zza(zzibVar.zza());
        for (zzia zziaVar : zzibVar.zzb()) {
            zzie zzb2 = zzif.zzb();
            zzb2.zza(zziaVar.zzb().zza());
            zzb2.zzb(zziaVar.zzc());
            zzb2.zzd(zziaVar.zze());
            zzb2.zzc(zziaVar.zzd());
            zzb.zzb(zzb2.zzl());
        }
        return zzb.zzl();
    }

    public static void zzb(zzib zzibVar) throws GeneralSecurityException {
        int zza2 = zzibVar.zza();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzia zziaVar : zzibVar.zzb()) {
            if (zziaVar.zzc() == zzhq.ENABLED) {
                if (zziaVar.zza()) {
                    if (zziaVar.zze() != zziu.UNKNOWN_PREFIX) {
                        if (zziaVar.zzc() != zzhq.UNKNOWN_STATUS) {
                            if (zziaVar.zzd() == zza2) {
                                if (z) {
                                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                                }
                                z = true;
                            }
                            z2 &= zziaVar.zzb().zzc() == zzhn.ASYMMETRIC_PUBLIC;
                            i++;
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zziaVar.zzd())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zziaVar.zzd())));
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zziaVar.zzd())));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
