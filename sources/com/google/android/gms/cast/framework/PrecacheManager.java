package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzjt;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class PrecacheManager {
    private final Logger zza = new Logger("PrecacheManager");
    private final CastOptions zzb;
    private final SessionManager zzc;
    private final com.google.android.gms.cast.internal.zzn zzd;

    public PrecacheManager(CastOptions castOptions, SessionManager sessionManager, com.google.android.gms.cast.internal.zzn zznVar) {
        this.zzb = castOptions;
        this.zzc = sessionManager;
        this.zzd = zznVar;
    }

    public void precache(String str) {
        com.google.android.gms.internal.cast.zzl.zzb(zzjt.PRECACHE);
        Session currentSession = this.zzc.getCurrentSession();
        if (str == null) {
            throw new IllegalArgumentException("No precache data found to be precached");
        }
        if (currentSession == null) {
            this.zzd.zza(new String[]{this.zzb.getReceiverApplicationId()}, str, null);
        } else if (currentSession instanceof CastSession) {
            RemoteMediaClient remoteMediaClient = ((CastSession) currentSession).getRemoteMediaClient();
            if (remoteMediaClient != null) {
                remoteMediaClient.zzf(str, null);
            } else {
                this.zza.m367e("Failed to get RemoteMediaClient from current cast session.", new Object[0]);
            }
        } else {
            this.zza.m367e("Current session is not a CastSession. Precache is not supported.", new Object[0]);
        }
    }
}
