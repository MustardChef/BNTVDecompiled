package com.google.firebase.auth.api.fallback.service;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.FallbackServiceBroker;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.internal.p038firebaseauthapi.zztf;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
final class zza extends FallbackServiceBroker {
    final /* synthetic */ FirebaseAuthFallbackService zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(FirebaseAuthFallbackService firebaseAuthFallbackService, Context context) {
        this.zza = firebaseAuthFallbackService;
    }

    @Override // com.google.android.gms.common.internal.IGmsServiceBroker
    public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
        Bundle extraArgs = getServiceRequest.getExtraArgs();
        if (extraArgs == null) {
            throw new IllegalArgumentException("ExtraArgs is null.");
        }
        String string = extraArgs.getString("com.google.firebase.auth.API_KEY");
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException("ApiKey must not be empty.");
        }
        iGmsCallbacks.onPostInitComplete(0, new zztf(this.zza, string), null);
    }
}
