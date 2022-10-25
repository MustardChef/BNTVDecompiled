package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdb */
/* loaded from: classes3.dex */
final class zzdb implements zzak {
    private final zzbc<zzak> zza;

    public zzdb(zzbc<zzak> zzbcVar) {
        this.zza = zzbcVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzak
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Logger logger;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzba<zzak> zzbaVar : this.zza.zza(copyOfRange)) {
                try {
                    return zzbaVar.zza().zza(copyOfRange2, null);
                } catch (GeneralSecurityException e) {
                    logger = zzdc.zza;
                    Level level = Level.INFO;
                    String valueOf = String.valueOf(e.toString());
                    logger.logp(level, "com.google.crypto.tink.hybrid.HybridDecryptWrapper$WrappedHybridDecrypt", "decrypt", valueOf.length() != 0 ? "ciphertext prefix matches a key, but cannot decrypt: ".concat(valueOf) : new String("ciphertext prefix matches a key, but cannot decrypt: "));
                }
            }
        }
        for (zzba<zzak> zzbaVar2 : this.zza.zza(zzaj.zza)) {
            try {
                return zzbaVar2.zza().zza(bArr, null);
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
