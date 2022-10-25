package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.p038firebaseauthapi.zzxg;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzax {
    private static zzax zzc;
    private boolean zza = false;
    private BroadcastReceiver zzb;

    private zzax() {
    }

    public static zzax zza() {
        if (zzc == null) {
            zzc = new zzax();
        }
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(Context context) {
        zzax zzaxVar = zzc;
        zzaxVar.zza = false;
        if (zzaxVar.zzb != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(zzc.zzb);
        }
        zzc.zzb = null;
    }

    private final void zzh(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.zzb = broadcastReceiver;
        LocalBroadcastManager.getInstance(activity).registerReceiver(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    private static final AuthCredential zzi(Intent intent) {
        Preconditions.checkNotNull(intent);
        zzxg zzxgVar = (zzxg) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzxg.CREATOR);
        zzxgVar.zze(true);
        return com.google.firebase.auth.zze.zzc(zzxgVar);
    }

    public final boolean zzb(Activity activity, TaskCompletionSource<String> taskCompletionSource) {
        if (this.zza) {
            return false;
        }
        zzh(activity, new zzaw(this, activity, taskCompletionSource));
        this.zza = true;
        return true;
    }

    public final boolean zzc(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (this.zza) {
            return false;
        }
        zzh(activity, new zzav(this, activity, taskCompletionSource, firebaseAuth, firebaseUser));
        this.zza = true;
        return true;
    }
}
