package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrh */
/* loaded from: classes3.dex */
public final class zzrh extends zzun<Void, zzg> {
    public zzrh() {
        super(2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final String zza() {
        return "reload";
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpn
    public final TaskApiCall<zztc, Void> zzb() {
        return TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.firebase-auth-api.zzrg
            private final zzrh zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzrh zzrhVar = this.zza;
                zzrhVar.zzv = new zzum(zzrhVar, (TaskCompletionSource) obj2);
                ((zztc) obj).zzo().zzo(new zzme(zzrhVar.zze.zzg()), zzrhVar.zzc);
            }
        }).build();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzun
    public final void zzc() {
        ((zzg) this.zzf).zza(this.zzj, zzsy.zzS(this.zzd, this.zzk));
        zzj(null);
    }
}
