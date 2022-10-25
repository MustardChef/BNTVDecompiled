package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbp */
/* loaded from: classes3.dex */
final class zzbp implements zzag {
    private final zzbc<zzag> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbp(zzbc zzbcVar, zzbo zzboVar) {
        this.zza = zzbcVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzag
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzag
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Logger logger;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzba<zzag> zzbaVar : this.zza.zza(copyOfRange)) {
                try {
                    return zzbaVar.zza().zzb(copyOfRange2, bArr2);
                } catch (GeneralSecurityException e) {
                    logger = zzbq.zza;
                    Level level = Level.INFO;
                    String valueOf = String.valueOf(e.toString());
                    logger.logp(level, "com.google.crypto.tink.aead.AeadWrapper$WrappedAead", "decrypt", valueOf.length() != 0 ? "ciphertext prefix matches a key, but cannot decrypt: ".concat(valueOf) : new String("ciphertext prefix matches a key, but cannot decrypt: "));
                }
            }
        }
        for (zzba<zzag> zzbaVar2 : this.zza.zza(zzaj.zza)) {
            try {
                return zzbaVar2.zza().zzb(bArr, bArr2);
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
