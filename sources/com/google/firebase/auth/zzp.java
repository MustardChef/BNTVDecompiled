package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.internal.p038firebaseauthapi.zzsy;
import com.google.android.gms.internal.p038firebaseauthapi.zzta;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzp implements OnCompleteListener<com.google.firebase.auth.internal.zze> {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ FirebaseAuth zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions) {
        this.zzb = firebaseAuth;
        this.zza = phoneAuthOptions;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zze> task) {
        String zzb;
        String str;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzJ;
        zzsy zzsyVar;
        String str2;
        zzsy zzsyVar2;
        String str3;
        if (!task.isSuccessful()) {
            String valueOf = String.valueOf(task.getException().getMessage());
            Log.e("FirebaseAuth", valueOf.length() != 0 ? "Error while validating application identity: ".concat(valueOf) : new String("Error while validating application identity: "));
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str = null;
            zzb = null;
        } else {
            String zza = task.getResult().zza();
            zzb = task.getResult().zzb();
            str = zza;
        }
        long longValue = this.zza.zzc().longValue();
        zzJ = this.zzb.zzJ(this.zza.zzb(), this.zza.zzd());
        com.google.firebase.auth.internal.zzag zzagVar = (com.google.firebase.auth.internal.zzag) this.zza.zzg();
        if (zzagVar.zze()) {
            zzsyVar2 = this.zzb.zze;
            String zzb2 = this.zza.zzb();
            str3 = this.zzb.zzi;
            zzsyVar2.zzM(zzagVar, zzb2, str3, longValue, this.zza.zzf() != null, this.zza.zzh(), str, zzb, zzta.zza(), zzJ, this.zza.zze(), this.zza.zzi());
            return;
        }
        zzsyVar = this.zzb.zze;
        PhoneMultiFactorInfo zzj = this.zza.zzj();
        str2 = this.zzb.zzi;
        zzsyVar.zzO(zzagVar, zzj, str2, longValue, this.zza.zzf() != null, this.zza.zzh(), str, zzb, zzta.zza(), zzJ, this.zza.zze(), this.zza.zzi());
    }
}
