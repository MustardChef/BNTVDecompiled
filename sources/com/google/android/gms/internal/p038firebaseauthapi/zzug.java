package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug */
/* loaded from: classes3.dex */
final class zzug implements zzul {
    final /* synthetic */ PhoneAuthCredential zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzug(zzuk zzukVar, PhoneAuthCredential phoneAuthCredential) {
        this.zza = phoneAuthCredential;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzul
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zza);
    }
}
