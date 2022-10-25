package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsh */
/* loaded from: classes3.dex */
public final class zzsh extends zzun<AuthResult, zzg> {
    public zzsh() {
        super(2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final String zza() {
        return "unlinkEmailCredential";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final TaskApiCall<zztc, AuthResult> zzb() {
        return TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.firebase-auth-api.zzsg
            private final zzsh zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzsh zzshVar = this.zza;
                zzshVar.zzv = new zzum(zzshVar, (TaskCompletionSource) obj2);
                ((zztc) obj).zzo().zzm(new zzng(zzshVar.zze.zzg()), zzshVar.zzc);
            }
        }).build();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzun
    public final void zzc() {
        zzx zzS = zzsy.zzS(this.zzd, this.zzk);
        ((zzg) this.zzf).zza(this.zzj, zzS);
        zzj(new zzr(zzS));
    }
}
