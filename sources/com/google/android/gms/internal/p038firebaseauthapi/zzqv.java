package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqv */
/* loaded from: classes3.dex */
public final class zzqv extends zzun<Void, zzg> {
    private final zzmw zza;

    public zzqv(EmailAuthCredential emailAuthCredential) {
        super(2);
        Preconditions.checkNotNull(emailAuthCredential, "Credential cannot be null");
        this.zza = new zzmw(emailAuthCredential);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final String zza() {
        return "reauthenticateWithEmailLink";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final TaskApiCall<zztc, Void> zzb() {
        return TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.firebase-auth-api.zzqu
            private final zzqv zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zza.zzd((zztc) obj, (TaskCompletionSource) obj2);
            }
        }).build();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzun
    public final void zzc() {
        zzx zzS = zzsy.zzS(this.zzd, this.zzk);
        if (this.zze.getUid().equalsIgnoreCase(zzS.getUid())) {
            ((zzg) this.zzf).zza(this.zzj, zzS);
            zzj(null);
            return;
        }
        zzk(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztc zztcVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzum(this, taskCompletionSource);
        zztcVar.zzo().zzA(this.zza, this.zzc);
    }
}
