package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrd */
/* loaded from: classes3.dex */
public final class zzrd extends zzun<Void, zzg> {
    private final zzmy zza;

    public zzrd(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
        phoneAuthCredential.zzf(false);
        this.zza = new zzmy(phoneAuthCredential, str);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final String zza() {
        return "reauthenticateWithPhoneCredential";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final TaskApiCall<zztc, Void> zzb() {
        return TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.firebase-auth-api.zzrc
            private final zzrd zza;

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
        zztcVar.zzo().zzv(this.zza, this.zzc);
    }
}
