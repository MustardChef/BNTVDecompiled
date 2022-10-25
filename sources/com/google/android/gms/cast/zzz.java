package com.google.android.gms.cast;

import androidx.mediarouter.media.MediaRouter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzz extends MediaRouter.Callback {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        CastDevice castDevice;
        CastDevice castDevice2;
        this.zza.zzx("onRouteUnselected");
        castDevice = this.zza.zzl;
        if (castDevice == null) {
            this.zza.zzx("onRouteUnselected, no device was selected");
            return;
        }
        CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.getExtras());
        if (fromBundle != null) {
            String deviceId = fromBundle.getDeviceId();
            castDevice2 = this.zza.zzl;
            if (deviceId.equals(castDevice2.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
                return;
            }
        }
        this.zza.zzx("onRouteUnselected, device does not match");
    }
}
