package com.google.android.gms.cast;

import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
@Deprecated
/* loaded from: classes2.dex */
public interface CastRemoteDisplayApi {
    PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, String str);

    PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient);
}
