package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
final class zzw implements Continuation<GetTokenResult, Task<Void>> {
    final /* synthetic */ FirebaseUser zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Task<Void> then(Task<GetTokenResult> task) throws Exception {
        return FirebaseAuth.getInstance(this.zza.zzd()).zzt(null, task.getResult().getToken());
    }
}
