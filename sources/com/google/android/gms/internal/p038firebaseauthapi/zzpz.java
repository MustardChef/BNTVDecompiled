package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzan;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpz */
/* loaded from: classes3.dex */
public final class zzpz extends zzun<Void, zzan> {
    public zzpz() {
        super(5);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final String zza() {
        return "delete";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final TaskApiCall<zztc, Void> zzb() {
        return TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.firebase-auth-api.zzpy
            private final zzpz zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzpz zzpzVar = this.zza;
                zzpzVar.zzv = new zzum(zzpzVar, (TaskCompletionSource) obj2);
                ((zztc) obj).zzo().zzq(new zzlo(zzpzVar.zze.zzg()), zzpzVar.zzc);
            }
        }).build();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzun
    public final void zzc() {
        ((zzan) this.zzf).zza();
        zzj(null);
    }
}
