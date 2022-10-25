package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p038firebaseauthapi.zzte;
import com.google.android.gms.internal.p038firebaseauthapi.zzua;
import com.google.android.gms.internal.p038firebaseauthapi.zzvh;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzf {
    private static final String zza = "zzf";
    private static final zzf zzb = new zzf();

    private zzf() {
    }

    public static zzf zza() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity, TaskCompletionSource<zze> taskCompletionSource) {
        Task<String> task;
        zzbmVar.zzb(firebaseAuth.zze().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource<String> taskCompletionSource2 = new TaskCompletionSource<>();
        if (zzax.zza().zzb(activity, taskCompletionSource2)) {
            Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass(activity, RecaptchaActivity.class);
            intent.setPackage(activity.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.zze().getOptions().getApiKey());
            if (!TextUtils.isEmpty(firebaseAuth.getTenantId())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzua.zzb().zza());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.zze().getName());
            activity.startActivity(intent);
            task = taskCompletionSource2.getTask();
        } else {
            task = Tasks.forException(zzte.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        task.addOnSuccessListener(new zzd(this, taskCompletionSource)).addOnFailureListener(new zzc(this, taskCompletionSource));
    }

    public final Task<zze> zzb(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z) {
        zzw zzwVar = (zzw) firebaseAuth.getFirebaseAuthSettings();
        SafetyNetClient client = z ? SafetyNet.getClient(firebaseAuth.zze().getApplicationContext()) : null;
        zzbm zza2 = zzbm.zza();
        if (zzvh.zzb(firebaseAuth.zze()) || zzwVar.zzd()) {
            return Tasks.forResult(new zze(null, null));
        }
        TaskCompletionSource<zze> taskCompletionSource = new TaskCompletionSource<>();
        Task<String> zze = zza2.zze();
        if (zze != null) {
            if (zze.isSuccessful()) {
                return Tasks.forResult(new zze(null, zze.getResult()));
            }
            String str2 = zza;
            String valueOf = String.valueOf(zze.getException().getMessage());
            Log.e(str2, valueOf.length() != 0 ? "Error in previous reCAPTCHA flow: ".concat(valueOf) : new String("Error in previous reCAPTCHA flow: "));
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (client == null || zzwVar.zze()) {
            zze(firebaseAuth, zza2, activity, taskCompletionSource);
        } else {
            FirebaseApp zze2 = firebaseAuth.zze();
            byte[] bArr = new byte[0];
            if (str != null) {
                try {
                    bArr = str.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    String str3 = zza;
                    String valueOf2 = String.valueOf(e.getMessage());
                    Log.e(str3, valueOf2.length() != 0 ? "Failed to getBytes with exception: ".concat(valueOf2) : new String("Failed to getBytes with exception: "));
                }
            }
            client.attest(bArr, zze2.getOptions().getApiKey()).addOnSuccessListener(new zzb(this, taskCompletionSource, firebaseAuth, zza2, activity)).addOnFailureListener(new zza(this, firebaseAuth, zza2, activity, taskCompletionSource));
        }
        return taskCompletionSource.getTask();
    }
}
