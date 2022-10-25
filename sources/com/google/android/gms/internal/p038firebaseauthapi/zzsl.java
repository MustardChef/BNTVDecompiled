package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsl */
/* loaded from: classes3.dex */
public final class zzsl extends zzun<Void, zzg> {
    private final String zza;

    public zzsl(String str) {
        super(2);
        this.zza = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final String zza() {
        return "updateEmail";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final TaskApiCall<zztc, Void> zzb() {
        return TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.firebase-auth-api.zzsk
            private final zzsl zza;

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
        ((zzg) this.zzf).zza(this.zzj, zzsy.zzS(this.zzd, this.zzk));
        zzj(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztc zztcVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzum(this, taskCompletionSource);
        zztcVar.zzo().zzf(new zzle(this.zze.zzg(), this.zza), this.zzc);
    }
}
