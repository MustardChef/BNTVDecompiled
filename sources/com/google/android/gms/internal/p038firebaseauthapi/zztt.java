package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztt */
/* loaded from: classes3.dex */
public final class zztt extends Api.AbstractClientBuilder<zztc, zztv> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ zztc buildClient(Context context, Looper looper, ClientSettings clientSettings, zztv zztvVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zztd(context, looper, clientSettings, zztvVar, connectionCallbacks, onConnectionFailedListener);
    }
}
