package com.google.android.gms.internal.p038firebaseauthapi;

import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdn */
/* loaded from: classes3.dex */
public final class zzdn implements zzaw {
    private static final String zza = "zzdn";
    private KeyStore zzb = new zzdm().zza;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaw
    public final synchronized boolean zza(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaw
    public final synchronized zzag zzb(String str) throws GeneralSecurityException {
        zzdl zzdlVar;
        zzdlVar = new zzdl(zzkr.zzc("android-keystore://", str), this.zzb);
        byte[] zza2 = zzkp.zza(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(zza2, zzdlVar.zzb(zzdlVar.zza(zza2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzdlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zzc(String str) throws GeneralSecurityException {
        String str2;
        try {
        } catch (NullPointerException unused) {
            Log.w(zza, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zzb = keyStore;
                keyStore.load(null);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            } catch (InterruptedException unused2) {
            }
            return this.zzb.containsAlias(str2);
        }
        return this.zzb.containsAlias(zzkr.zzc("android-keystore://", str));
    }
}
