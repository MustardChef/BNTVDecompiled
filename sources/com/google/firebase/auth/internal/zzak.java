package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
final class zzak implements OnFailureListener {
    final /* synthetic */ zzal zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzal zzalVar) {
        this.zza = zzalVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Logger logger;
        if (exc instanceof FirebaseNetworkException) {
            logger = zzam.zzg;
            logger.m340v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zza.zza.zzb();
        }
    }
}
