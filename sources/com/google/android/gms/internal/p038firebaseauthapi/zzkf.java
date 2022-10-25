package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkf */
/* loaded from: classes3.dex */
public final class zzkf implements zzkg<Signature> {
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzkg
    public final /* bridge */ /* synthetic */ Signature zza(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
