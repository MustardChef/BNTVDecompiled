package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuh */
/* loaded from: classes3.dex */
final class zzuh implements zzul {
    final /* synthetic */ String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuh(zzuk zzukVar, String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzul
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeAutoRetrievalTimeOut(this.zza);
    }
}
