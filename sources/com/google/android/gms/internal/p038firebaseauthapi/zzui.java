package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzui */
/* loaded from: classes3.dex */
final class zzui implements zzul {
    final /* synthetic */ Status zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzui(zzuk zzukVar, Status status) {
        this.zza = status;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzul
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzte.zza(this.zza));
    }
}
