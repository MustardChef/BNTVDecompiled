package com.google.android.gms.internal.cast;

import android.hardware.display.VirtualDisplay;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzby implements CastRemoteDisplayApi {
    private static final Logger zza = new Logger("CastRemoteDisplayApiImpl");
    private final Api<?> zzb;
    private VirtualDisplay zzc;
    private final zzcg zzd = new zzbq(this);

    public zzby(Api api) {
        this.zzb = api;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzby zzbyVar) {
        VirtualDisplay virtualDisplay = zzbyVar.zzc;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                Logger logger = zza;
                int displayId = virtualDisplay.getDisplay().getDisplayId();
                StringBuilder sb = new StringBuilder(38);
                sb.append("releasing virtual display: ");
                sb.append(displayId);
                logger.m369d(sb.toString(), new Object[0]);
            }
            virtualDisplay.release();
        }
        zzbyVar.zzc = null;
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, String str) {
        zza.m369d("startRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzbr(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zza.m369d("stopRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzbs(this, googleApiClient));
    }
}
