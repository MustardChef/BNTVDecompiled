package com.google.android.gms.cast.framework.media.widget;

import android.widget.TextView;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzl implements RemoteMediaClient.Listener {
    final /* synthetic */ ExpandedControllerActivity zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzl(ExpandedControllerActivity expandedControllerActivity, zzh zzhVar) {
        this.zza = expandedControllerActivity;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onAdBreakStatusUpdated() {
        this.zza.zzp();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onMetadataUpdated() {
        this.zza.zzn();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onPreloadStatusUpdated() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onQueueStatusUpdated() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onSendingRemoteMediaRequest() {
        TextView textView;
        textView = this.zza.zzu;
        textView.setText(this.zza.getResources().getString(C3616R.string.cast_expanded_controller_loading));
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onStatusUpdated() {
        RemoteMediaClient zzm;
        boolean z;
        zzm = this.zza.zzm();
        if (zzm == null || !zzm.hasMediaSession()) {
            z = this.zza.zzL;
            if (z) {
                return;
            }
            this.zza.finish();
            return;
        }
        this.zza.zzL = false;
        this.zza.zzo();
        this.zza.zzp();
    }
}
