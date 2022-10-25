package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.Looper;
import android.support.p002v4.media.session.MediaSessionCompat;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.mediarouter.media.MediaRouterParams;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzag extends zzr {
    private final MediaRouter zza;
    private final Map<MediaRouteSelector, Set<MediaRouter.Callback>> zzb = new HashMap();

    public zzag(MediaRouter mediaRouter, CastOptions castOptions) {
        this.zza = mediaRouter;
        if (PlatformVersion.isAtLeastR()) {
            boolean zzc = castOptions.zzc();
            boolean zzd = castOptions.zzd();
            mediaRouter.setRouterParams(new MediaRouterParams.Builder().setOutputSwitcherEnabled(zzc).setTransferToLocalEnabled(zzd).build());
            if (zzc) {
                zzl.zzb(zzjt.CAST_OUTPUT_SWITCHER_ENABLED);
            }
            if (zzd) {
                zzl.zzb(zzjt.CAST_TRANSFER_TO_LOCAL_ENABLED);
            }
        }
    }

    private final void zzo(MediaRouteSelector mediaRouteSelector, int i) {
        for (MediaRouter.Callback callback : this.zzb.get(mediaRouteSelector)) {
            this.zza.addCallback(mediaRouteSelector, callback, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzp */
    public final void zzm(MediaRouteSelector mediaRouteSelector) {
        for (MediaRouter.Callback callback : this.zzb.get(mediaRouteSelector)) {
            this.zza.removeCallback(callback);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzb(Bundle bundle, zzu zzuVar) {
        MediaRouteSelector fromBundle = MediaRouteSelector.fromBundle(bundle);
        if (!this.zzb.containsKey(fromBundle)) {
            this.zzb.put(fromBundle, new HashSet());
        }
        this.zzb.get(fromBundle).add(new zzad(zzuVar));
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzc(Bundle bundle, final int i) {
        final MediaRouteSelector fromBundle = MediaRouteSelector.fromBundle(bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzo(fromBundle, i);
        } else {
            new zzci(Looper.getMainLooper()).post(new Runnable(this, fromBundle, i) { // from class: com.google.android.gms.internal.cast.zzae
                private final zzag zza;
                private final MediaRouteSelector zzb;
                private final int zzc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = fromBundle;
                    this.zzc = i;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(this.zzb, this.zzc);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzd(Bundle bundle) {
        final MediaRouteSelector fromBundle = MediaRouteSelector.fromBundle(bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzm(fromBundle);
        } else {
            new zzci(Looper.getMainLooper()).post(new Runnable(this, fromBundle) { // from class: com.google.android.gms.internal.cast.zzaf
                private final zzag zza;
                private final MediaRouteSelector zzb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = fromBundle;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(this.zzb);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final boolean zze(Bundle bundle, int i) {
        return this.zza.isRouteAvailable(MediaRouteSelector.fromBundle(bundle), i);
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzf(String str) {
        for (MediaRouter.RouteInfo routeInfo : this.zza.getRoutes()) {
            if (routeInfo.getId().equals(str)) {
                this.zza.selectRoute(routeInfo);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzg() {
        MediaRouter mediaRouter = this.zza;
        mediaRouter.selectRoute(mediaRouter.getDefaultRoute());
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final boolean zzh() {
        return this.zza.getSelectedRoute().getId().equals(this.zza.getDefaultRoute().getId());
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final Bundle zzi(String str) {
        for (MediaRouter.RouteInfo routeInfo : this.zza.getRoutes()) {
            if (routeInfo.getId().equals(str)) {
                return routeInfo.getExtras();
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final String zzj() {
        return this.zza.getSelectedRoute().getId();
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzk() {
        for (Set<MediaRouter.Callback> set : this.zzb.values()) {
            for (MediaRouter.Callback callback : set) {
                this.zza.removeCallback(callback);
            }
        }
        this.zzb.clear();
    }

    public final void zzl(MediaSessionCompat mediaSessionCompat) {
        this.zza.setMediaSessionCompat(mediaSessionCompat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(MediaRouteSelector mediaRouteSelector, int i) {
        synchronized (this.zzb) {
            zzo(mediaRouteSelector, i);
        }
    }
}
