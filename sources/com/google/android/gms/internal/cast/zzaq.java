package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaUtils;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.images.WebImage;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzaq extends UIController {
    private final ImageView zza;
    private final ImageHints zzb;
    private final Bitmap zzc;
    private final ImagePicker zzd;
    private final com.google.android.gms.cast.framework.media.internal.zzb zze;

    public zzaq(ImageView imageView, Context context, ImageHints imageHints, int i) {
        this.zza = imageView;
        this.zzb = imageHints;
        this.zzc = BitmapFactory.decodeResource(context.getResources(), i);
        CastContext zza = CastContext.zza(context);
        if (zza != null) {
            CastMediaOptions castMediaOptions = zza.getCastOptions().getCastMediaOptions();
            this.zzd = castMediaOptions != null ? castMediaOptions.getImagePicker() : null;
        } else {
            this.zzd = null;
        }
        this.zze = new com.google.android.gms.cast.framework.media.internal.zzb(context.getApplicationContext());
    }

    private final void zzb() {
        MediaInfo media;
        WebImage onPickImage;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            this.zza.setImageBitmap(this.zzc);
            return;
        }
        MediaQueueItem preloadedItem = remoteMediaClient.getPreloadedItem();
        Uri uri = null;
        if (preloadedItem != null && (media = preloadedItem.getMedia()) != null) {
            ImagePicker imagePicker = this.zzd;
            if (imagePicker == null || (onPickImage = imagePicker.onPickImage(media.getMetadata(), this.zzb)) == null || onPickImage.getUrl() == null) {
                uri = MediaUtils.getImageUri(media, 0);
            } else {
                uri = onPickImage.getUrl();
            }
        }
        if (uri == null) {
            this.zza.setImageBitmap(this.zzc);
        } else {
            this.zze.zzb(uri);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zzb();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zze.zza(new zzap(this));
        this.zza.setImageBitmap(this.zzc);
        zzb();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zze.zzc();
        this.zza.setImageBitmap(this.zzc);
        super.onSessionEnded();
    }
}
