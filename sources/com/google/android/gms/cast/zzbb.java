package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzbb extends Api.AbstractClientBuilder<com.google.android.gms.cast.internal.zzx, Cast.CastOptions> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ com.google.android.gms.cast.internal.zzx buildClient(Context context, Looper looper, ClientSettings clientSettings, Cast.CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Cast.CastOptions castOptions2 = castOptions;
        Preconditions.checkNotNull(castOptions2, "Setting the API options is required.");
        return new com.google.android.gms.cast.internal.zzx(context, looper, clientSettings, castOptions2.zza, castOptions2.zzd, castOptions2.zzc, castOptions2.zze, connectionCallbacks, onConnectionFailedListener);
    }
}
