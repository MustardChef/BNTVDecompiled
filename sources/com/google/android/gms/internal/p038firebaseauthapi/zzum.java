package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzum */
/* loaded from: classes3.dex */
public final class zzum<ResultT, CallbackT> {
    private final zzun<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzum(zzun<ResultT, CallbackT> zzunVar, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzunVar;
        this.zzb = taskCompletionSource;
    }

    public final void zza(ResultT resultt, Status status) {
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(resultt);
            return;
        }
        zzun<ResultT, CallbackT> zzunVar = this.zza;
        if (zzunVar.zzs != null) {
            TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzunVar.zzd);
            zzun<ResultT, CallbackT> zzunVar2 = this.zza;
            taskCompletionSource.setException(zzte.zzc(firebaseAuth, zzunVar2.zzs, ("reauthenticateWithCredential".equals(zzunVar2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) ? this.zza.zze : null));
            return;
        }
        AuthCredential authCredential = zzunVar.zzp;
        if (authCredential != null) {
            this.zzb.setException(zzte.zzb(status, authCredential, zzunVar.zzq, zzunVar.zzr));
        } else {
            this.zzb.setException(zzte.zza(status));
        }
    }
}
