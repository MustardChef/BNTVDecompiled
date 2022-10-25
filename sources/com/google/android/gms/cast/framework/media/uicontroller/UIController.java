package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class UIController {
    private RemoteMediaClient zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public RemoteMediaClient getRemoteMediaClient() {
        return this.zza;
    }

    public void onMediaStatusUpdated() {
    }

    public void onSendingRemoteMediaRequest() {
    }

    public void onSessionConnected(CastSession castSession) {
        this.zza = castSession != null ? castSession.getRemoteMediaClient() : null;
    }

    public void onSessionEnded() {
        this.zza = null;
    }
}
