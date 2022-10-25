package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
final class zzad implements Continuation<AuthResult, Task<AuthResult>> {
    final /* synthetic */ zzae zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzae zzaeVar) {
        this.zza = zzaeVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Task<AuthResult> then(Task<AuthResult> task) throws Exception {
        com.google.firebase.auth.zze zzeVar;
        com.google.firebase.auth.zze zzeVar2;
        com.google.firebase.auth.zze zzeVar3;
        zzeVar = this.zza.zzd;
        if (zzeVar == null) {
            return task;
        }
        if (task.isSuccessful()) {
            AuthResult result = task.getResult();
            zzeVar3 = this.zza.zzd;
            return Tasks.forResult(new zzr((zzx) result.getUser(), (zzp) result.getAdditionalUserInfo(), zzeVar3));
        }
        Exception exception = task.getException();
        if (exception instanceof FirebaseAuthUserCollisionException) {
            zzeVar2 = this.zza.zzd;
            ((FirebaseAuthUserCollisionException) exception).zzb(zzeVar2);
        }
        return Tasks.forException(exception);
    }
}
