package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjz */
/* loaded from: classes3.dex */
public final class zzjz implements zzkg<Cipher> {
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzkg
    public final /* bridge */ /* synthetic */ Cipher zza(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
    }
}
