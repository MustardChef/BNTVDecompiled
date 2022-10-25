package com.google.android.gms.cast.framework.media.internal;

import android.content.Intent;
import android.support.p002v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzo extends MediaSessionCompat.Callback {
    final /* synthetic */ zzp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzp zzpVar) {
        this.zza = zzpVar;
    }

    @Override // android.support.p002v4.media.session.MediaSessionCompat.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        RemoteMediaClient remoteMediaClient;
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent != null) {
            if (keyEvent.getKeyCode() == 127 || keyEvent.getKeyCode() == 126) {
                remoteMediaClient = this.zza.zzj;
                remoteMediaClient.togglePlayback();
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.support.p002v4.media.session.MediaSessionCompat.Callback
    public final void onPause() {
        RemoteMediaClient remoteMediaClient;
        remoteMediaClient = this.zza.zzj;
        remoteMediaClient.togglePlayback();
    }

    @Override // android.support.p002v4.media.session.MediaSessionCompat.Callback
    public final void onPlay() {
        RemoteMediaClient remoteMediaClient;
        remoteMediaClient = this.zza.zzj;
        remoteMediaClient.togglePlayback();
    }

    @Override // android.support.p002v4.media.session.MediaSessionCompat.Callback
    public final void onSeekTo(long j) {
        RemoteMediaClient remoteMediaClient;
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(j);
        MediaSeekOptions build = builder.build();
        remoteMediaClient = this.zza.zzj;
        remoteMediaClient.seek(build);
    }
}
