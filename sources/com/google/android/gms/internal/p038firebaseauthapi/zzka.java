package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzka */
/* loaded from: classes3.dex */
public final class zzka implements zzkg<KeyAgreement> {
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzkg
    public final /* bridge */ /* synthetic */ KeyAgreement zza(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
