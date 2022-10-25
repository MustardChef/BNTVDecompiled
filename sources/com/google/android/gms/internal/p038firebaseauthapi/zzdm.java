package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Build;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm */
/* loaded from: classes3.dex */
public final class zzdm {
    KeyStore zza;

    public zzdm() {
        this.zza = null;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zza = keyStore;
                keyStore.load(null);
                return;
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
        throw new IllegalStateException("need Android Keystore on Android M or newer");
    }
}
