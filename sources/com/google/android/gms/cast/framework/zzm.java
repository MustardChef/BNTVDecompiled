package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzm extends Cast.Listener {
    final /* synthetic */ CastSession zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzm(CastSession castSession, zzi zziVar) {
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onActiveInputStateChanged(int i) {
        Set set;
        set = this.zza.zzd;
        for (Cast.Listener listener : new HashSet(set)) {
            listener.onActiveInputStateChanged(i);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onApplicationDisconnected(int i) {
        Set set;
        CastSession.zzf(this.zza, i);
        this.zza.notifySessionEnded(i);
        set = this.zza.zzd;
        for (Cast.Listener listener : new HashSet(set)) {
            listener.onApplicationDisconnected(i);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        Set set;
        set = this.zza.zzd;
        for (Cast.Listener listener : new HashSet(set)) {
            listener.onApplicationMetadataChanged(applicationMetadata);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onApplicationStatusChanged() {
        Set set;
        set = this.zza.zzd;
        for (Cast.Listener listener : new HashSet(set)) {
            listener.onApplicationStatusChanged();
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onStandbyStateChanged(int i) {
        Set set;
        set = this.zza.zzd;
        for (Cast.Listener listener : new HashSet(set)) {
            listener.onStandbyStateChanged(i);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onVolumeChanged() {
        Set set;
        set = this.zza.zzd;
        for (Cast.Listener listener : new HashSet(set)) {
            listener.onVolumeChanged();
        }
    }
}
