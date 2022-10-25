package com.google.firebase.auth;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzo implements OnCompleteListener<com.google.firebase.auth.internal.zze> {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ TimeUnit zzc;
    final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
    final /* synthetic */ Activity zze;
    final /* synthetic */ Executor zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ FirebaseAuth zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(FirebaseAuth firebaseAuth, String str, long j, TimeUnit timeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z) {
        this.zzh = firebaseAuth;
        this.zza = str;
        this.zzb = j;
        this.zzc = timeUnit;
        this.zzd = onVerificationStateChangedCallbacks;
        this.zze = activity;
        this.zzf = executor;
        this.zzg = z;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zze> task) {
        String zzb;
        String str;
        if (!task.isSuccessful()) {
            String valueOf = String.valueOf(task.getException().getMessage());
            Log.e("FirebaseAuth", valueOf.length() != 0 ? "Error while validating application identity: ".concat(valueOf) : new String("Error while validating application identity: "));
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            zzb = null;
            str = null;
        } else {
            String zza = task.getResult().zza();
            zzb = task.getResult().zzb();
            str = zza;
        }
        this.zzh.zzk(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzb, str);
    }
}
