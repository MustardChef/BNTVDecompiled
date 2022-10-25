package com.google.android.gms.internal.cast;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzbd extends UIController implements RemoteMediaClient.ProgressListener {
    private final SeekBar zza;
    private final long zzb;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzc;
    private boolean zzd = true;
    private Boolean zze;
    private Drawable zzf;

    public zzbd(SeekBar seekBar, long j, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zzf = null;
        this.zza = seekBar;
        this.zzb = j;
        this.zzc = zzaVar;
        seekBar.setEnabled(false);
        this.zzf = com.google.android.gms.cast.framework.media.widget.zzn.zzd(seekBar);
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
            getRemoteMediaClient().addProgressListener(this, this.zzb);
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
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            this.zza.setMax(this.zzc.zzb());
            this.zza.setProgress(this.zzc.zzc());
            this.zza.setEnabled(false);
        } else if (this.zzd) {
            this.zza.setMax(this.zzc.zzb());
            if (!remoteMediaClient.isLiveStream() || !this.zzc.zze()) {
                this.zza.setProgress(this.zzc.zzc());
            } else {
                this.zza.setProgress(this.zzc.zzg());
            }
            if (remoteMediaClient.isPlayingAd()) {
                this.zza.setEnabled(false);
            } else {
                this.zza.setEnabled(true);
            }
            RemoteMediaClient remoteMediaClient2 = getRemoteMediaClient();
            Objects.requireNonNull(remoteMediaClient2);
            Boolean bool = this.zze;
            if (bool == null || bool.booleanValue() != remoteMediaClient2.zzh()) {
                Boolean valueOf = Boolean.valueOf(remoteMediaClient2.zzh());
                this.zze = valueOf;
                if (valueOf.booleanValue()) {
                    Drawable drawable = this.zzf;
                    if (drawable != null) {
                        this.zza.setThumb(drawable);
                    }
                    this.zza.setClickable(true);
                    this.zza.setOnTouchListener(null);
                    return;
                }
                this.zza.setThumb(new ColorDrawable(0));
                this.zza.setClickable(false);
                this.zza.setOnTouchListener(new zzbc(this));
            }
        }
    }

    public final void zzb(boolean z) {
        this.zzd = z;
    }
}
