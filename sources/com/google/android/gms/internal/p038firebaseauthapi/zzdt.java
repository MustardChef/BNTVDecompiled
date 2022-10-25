package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdt */
/* loaded from: classes3.dex */
final class zzdt extends zzar<zzay, zzhd> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzar
    public final /* bridge */ /* synthetic */ zzay zzb(zzhd zzhdVar) throws GeneralSecurityException {
        zzhd zzhdVar2 = zzhdVar;
        zzha zza = zzhdVar2.zzb().zza();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzhdVar2.zzc().zzp(), "HMAC");
        int zzb = zzhdVar2.zzb().zzb();
        zzha zzhaVar = zzha.UNKNOWN_HASH;
        int ordinal = zza.ordinal();
        if (ordinal != 1) {
            if (ordinal != 3) {
                if (ordinal == 4) {
                    return new zzkn(new zzkm("HMACSHA512", secretKeySpec), zzb);
                }
                throw new GeneralSecurityException("unknown hash");
            }
            return new zzkn(new zzkm("HMACSHA256", secretKeySpec), zzb);
        }
        return new zzkn(new zzkm("HMACSHA1", secretKeySpec), zzb);
    }
}
