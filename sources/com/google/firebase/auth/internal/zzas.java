package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzas implements OnSuccessListener<AuthResult> {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ Context zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.zza = taskCompletionSource;
        this.zzb = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(AuthResult authResult) {
        this.zza.setResult(authResult);
        zzax.zzd(this.zzb);
    }
}
