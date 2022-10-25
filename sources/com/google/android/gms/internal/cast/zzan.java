package com.google.android.gms.internal.cast;

import android.content.Context;
import android.view.View;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzan extends UIController {
    private final View zza;
    private final String zzb;
    private final String zzc;

    public zzan(View view, Context context) {
        this.zza = view;
        this.zzb = context.getString(C3616R.string.cast_closed_captions);
        this.zzc = context.getString(C3616R.string.cast_closed_captions_unavailable);
        view.setEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zza() {
        /*
            r8 = this;
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r8.getRemoteMediaClient()
            r1 = 0
            if (r0 == 0) goto L57
            boolean r2 = r0.hasMediaSession()
            if (r2 == 0) goto L57
            com.google.android.gms.cast.MediaInfo r2 = r0.getMediaInfo()
            if (r2 != 0) goto L14
            goto L57
        L14:
            java.util.List r2 = r2.getMediaTracks()
            if (r2 == 0) goto L57
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L57
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
        L25:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L57
            java.lang.Object r4 = r2.next()
            com.google.android.gms.cast.MediaTrack r4 = (com.google.android.gms.cast.MediaTrack) r4
            int r5 = r4.getType()
            r6 = 2
            r7 = 1
            if (r5 != r6) goto L3e
            int r3 = r3 + 1
            if (r3 <= r7) goto L25
            goto L44
        L3e:
            int r4 = r4.getType()
            if (r4 != r7) goto L25
        L44:
            boolean r0 = r0.isPlayingAd()
            if (r0 != 0) goto L57
            android.view.View r0 = r8.zza
            r0.setEnabled(r7)
            android.view.View r0 = r8.zza
            java.lang.String r1 = r8.zzb
            r0.setContentDescription(r1)
            return
        L57:
            android.view.View r0 = r8.zza
            r0.setEnabled(r1)
            android.view.View r0 = r8.zza
            java.lang.String r1 = r8.zzc
            r0.setContentDescription(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzan.zza():void");
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zza.setEnabled(true);
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}
