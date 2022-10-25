package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zze extends Api.AbstractClientBuilder<com.google.android.gms.cast.internal.zzw, Cast.CastOptions> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ com.google.android.gms.cast.internal.zzw buildClient(Context context, Looper looper, ClientSettings clientSettings, Cast.CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Cast.CastOptions castOptions2 = castOptions;
        Preconditions.checkNotNull(castOptions2, "Setting the API options is required.");
        return new com.google.android.gms.cast.internal.zzw(context, looper, clientSettings, castOptions2.zza, castOptions2.zzd, castOptions2.zzb, castOptions2.zzc, connectionCallbacks, onConnectionFailedListener);
    }
}
