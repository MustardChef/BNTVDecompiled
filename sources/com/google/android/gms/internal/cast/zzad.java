package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzad extends MediaRouter.Callback {
    private static final Logger zza = new Logger("MediaRouterCallback");
    private final zzu zzb;

    public zzad(zzu zzuVar) {
        this.zzb = (zzu) Preconditions.checkNotNull(zzuVar);
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zze(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "onRouteAdded", zzu.class.getSimpleName());
        }
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzf(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "onRouteChanged", zzu.class.getSimpleName());
        }
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzg(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "onRouteRemoved", zzu.class.getSimpleName());
        }
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzh(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "onRouteSelected", zzu.class.getSimpleName());
        }
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i) {
        try {
            this.zzb.zzi(routeInfo.getId(), routeInfo.getExtras(), i);
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "onRouteUnselected", zzu.class.getSimpleName());
        }
    }
}
