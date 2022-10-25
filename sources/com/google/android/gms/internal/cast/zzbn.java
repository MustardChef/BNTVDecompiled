package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzbn extends UIController implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final ImageView zzb;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzc;

    public zzbn(View view, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zza = (TextView) view.findViewById(C3616R.C3619id.live_indicator_text);
        ImageView imageView = (ImageView) view.findViewById(C3616R.C3619id.live_indicator_dot);
        this.zzb = imageView;
        this.zzc = zzaVar;
        TypedArray obtainStyledAttributes = imageView.getContext().obtainStyledAttributes(null, C3616R.styleable.CastExpandedController, C3616R.attr.castExpandedControllerStyle, C3616R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(C3616R.styleable.CastExpandedController_castLiveIndicatorColor, 0);
        obtainStyledAttributes.recycle();
        imageView.getDrawable().setColorFilter(imageView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
    public final void onProgressUpdated(long j, long j2) {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        if (getRemoteMediaClient() != null) {
            getRemoteMediaClient().addProgressListener(this, 1000L);
        }
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        if (getRemoteMediaClient() != null) {
            getRemoteMediaClient().removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    final void zza() {
        boolean zze;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !remoteMediaClient.isLiveStream()) {
            this.zza.setVisibility(8);
            this.zzb.setVisibility(8);
            return;
        }
        if (!remoteMediaClient.zzh()) {
            zze = remoteMediaClient.isPlaying();
        } else {
            zze = this.zzc.zze();
        }
        this.zza.setVisibility(0);
        this.zzb.setVisibility(true == zze ? 0 : 8);
        zzl.zzb(zzjt.CAF_EXPANDED_CONTROLLER_WITH_LIVE_CONTENT);
    }
}
