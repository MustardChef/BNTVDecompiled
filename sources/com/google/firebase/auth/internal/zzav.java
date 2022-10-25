package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p038firebaseauthapi.zzte;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzav extends BroadcastReceiver {
    final /* synthetic */ zzax zza;
    private final WeakReference<Activity> zzb;
    private final TaskCompletionSource<AuthResult> zzc;
    private final FirebaseAuth zzd;
    private final FirebaseUser zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzax zzaxVar, Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zza = zzaxVar;
        this.zzb = new WeakReference<>(activity);
        this.zzc = taskCompletionSource;
        this.zzd = firebaseAuth;
        this.zze = firebaseUser;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zzb.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzc.setException(zzte.zza(new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zzd(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                this.zzd.signInWithCredential(zzax.zzi(intent)).addOnSuccessListener(new zzaq(r0, r1, context)).addOnFailureListener(new zzap(this.zza, this.zzc, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                this.zze.linkWithCredential(zzax.zzi(intent)).addOnSuccessListener(new zzas(r0, r1, context)).addOnFailureListener(new zzar(this.zza, this.zzc, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                this.zze.reauthenticateAndRetrieveData(zzax.zzi(intent)).addOnSuccessListener(new zzau(r0, r1, context)).addOnFailureListener(new zzat(this.zza, this.zzc, context));
            } else {
                TaskCompletionSource<AuthResult> taskCompletionSource = this.zzc;
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 50);
                sb.append("WEB_CONTEXT_CANCELED:Unknown operation received (");
                sb.append(stringExtra);
                sb.append(")");
                taskCompletionSource.setException(zzte.zza(zzai.zza(sb.toString())));
            }
        } else if (zzbl.zzb(intent)) {
            this.zzc.setException(zzte.zza(zzbl.zzc(intent)));
            zzax.zzd(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzc.setException(zzte.zza(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.zzd(context);
        }
    }
}
