package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdy */
/* loaded from: classes3.dex */
final class zzdy implements zzay {
    private final zzbc<zzay> zza;
    private final byte[] zzb = {0};

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdy(zzbc zzbcVar, zzdx zzdxVar) {
        this.zza = zzbcVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzay
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Logger logger;
        int length = bArr.length;
        if (length <= 5) {
            throw new GeneralSecurityException("tag too short");
        }
        byte[] copyOf = Arrays.copyOf(bArr, 5);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
        for (zzba<zzay> zzbaVar : this.zza.zza(copyOf)) {
            try {
                if (zzbaVar.zzc().equals(zziu.LEGACY)) {
                    zzbaVar.zza().zza(copyOfRange, zzjm.zzb(bArr2, this.zzb));
                    return;
                } else {
                    zzbaVar.zza().zza(copyOfRange, bArr2);
                    return;
                }
            } catch (GeneralSecurityException e) {
                logger = zzdz.zza;
                Level level = Level.INFO;
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 45);
                sb.append("tag prefix matches a key, but cannot verify: ");
                sb.append(valueOf);
                logger.logp(level, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", sb.toString());
            }
        }
        for (zzba<zzay> zzbaVar2 : this.zza.zza(zzaj.zza)) {
            try {
                zzbaVar2.zza().zza(bArr, bArr2);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
