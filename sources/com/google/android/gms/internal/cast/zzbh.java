package com.google.android.gms.internal.cast;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzbh extends UIController implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final String zzb;
    private final View zzc;

    public zzbh(TextView textView, String str, View view) {
        this.zza = textView;
        this.zzb = str;
        this.zzc = view;
    }

    private final void zza(long j, boolean z) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            this.zza.setVisibility(0);
            this.zza.setText(this.zzb);
            View view = this.zzc;
            if (view != null) {
                view.setVisibility(4);
            }
        } else if (!remoteMediaClient.isLiveStream()) {
            if (z) {
                j = remoteMediaClient.getStreamDuration();
            }
            this.zza.setVisibility(0);
            this.zza.setText(DateUtils.formatElapsedTime(j / 1000));
            View view2 = this.zzc;
            if (view2 != null) {
                view2.setVisibility(4);
            }
        } else {
            this.zza.setText(this.zzb);
            if (this.zzc != null) {
                this.zza.setVisibility(4);
                this.zzc.setVisibility(0);
            }
        }
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zza(-1L, true);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
    public final void onProgressUpdated(long j, long j2) {
        zza(j2, false);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, 1000L);
        }
        zza(-1L, true);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setText(this.zzb);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
    }
}
