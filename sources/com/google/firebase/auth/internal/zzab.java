package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
final class zzab implements Continuation<GetTokenResult, Task<MultiFactorSession>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzac zzacVar) {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Task<MultiFactorSession> then(Task<GetTokenResult> task) throws Exception {
        return !task.isSuccessful() ? Tasks.forException(task.getException()) : Tasks.forResult(zzag.zza(task.getResult().getToken()));
    }
}
