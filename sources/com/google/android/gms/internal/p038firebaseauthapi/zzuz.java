package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuz */
/* loaded from: classes3.dex */
public final class zzuz implements OnFailureListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuz(zzvd zzvdVar) {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Logger logger;
        logger = zzvd.zza;
        String valueOf = String.valueOf(exc.getMessage());
        logger.m343e(valueOf.length() != 0 ? "SmsRetrieverClient failed to start: ".concat(valueOf) : new String("SmsRetrieverClient failed to start: "), new Object[0]);
    }
}
