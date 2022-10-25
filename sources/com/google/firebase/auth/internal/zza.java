package com.google.firebase.auth.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zza implements OnFailureListener {
    final /* synthetic */ FirebaseAuth zza;
    final /* synthetic */ zzbm zzb;
    final /* synthetic */ Activity zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzf zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzf zzfVar, FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        this.zze = zzfVar;
        this.zza = firebaseAuth;
        this.zzb = zzbmVar;
        this.zzc = activity;
        this.zzd = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        String str;
        str = zzf.zza;
        String valueOf = String.valueOf(exc.getMessage());
        Log.e(str, valueOf.length() != 0 ? "Problem retrieving SafetyNet Token: ".concat(valueOf) : new String("Problem retrieving SafetyNet Token: "));
        this.zze.zze(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
