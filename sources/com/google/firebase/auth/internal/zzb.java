package com.google.firebase.auth.internal;

import android.app.Activity;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzb implements OnSuccessListener<SafetyNetApi.AttestationResponse> {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ FirebaseAuth zzb;
    final /* synthetic */ zzbm zzc;
    final /* synthetic */ Activity zzd;
    final /* synthetic */ zzf zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzf zzfVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity) {
        this.zze = zzfVar;
        this.zza = taskCompletionSource;
        this.zzb = firebaseAuth;
        this.zzc = zzbmVar;
        this.zzd = activity;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(SafetyNetApi.AttestationResponse attestationResponse) {
        SafetyNetApi.AttestationResponse attestationResponse2 = attestationResponse;
        if (zzbf.zza(attestationResponse2)) {
            this.zza.setResult(new zze(attestationResponse2.getJwsResult(), null));
        } else {
            this.zze.zze(this.zzb, this.zzc, this.zzd, this.zza);
        }
    }
}
