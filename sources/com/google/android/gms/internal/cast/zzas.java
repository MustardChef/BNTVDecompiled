package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
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
public final class zzas extends UIController {
    private final ImageView zza;
    private final ImageHints zzb;
    private final Bitmap zzc;
    private final View zzd;
    private final ImagePicker zze;
    private final com.google.android.gms.cast.framework.media.internal.zzb zzf;

    public zzas(ImageView imageView, Context context, ImageHints imageHints, int i, View view) {
        this.zza = imageView;
        this.zzb = imageHints;
        this.zzc = i != 0 ? BitmapFactory.decodeResource(context.getResources(), i) : null;
        this.zzd = view;
        CastContext zza = CastContext.zza(context);
        if (zza != null) {
            CastMediaOptions castMediaOptions = zza.getCastOptions().getCastMediaOptions();
            this.zze = castMediaOptions != null ? castMediaOptions.getImagePicker() : null;
        } else {
            this.zze = null;
        }
        this.zzf = new com.google.android.gms.cast.framework.media.internal.zzb(context.getApplicationContext());
    }

    private final void zzc() {
        Uri imageUri;
        WebImage onPickImage;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            zzd();
            return;
        }
        MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
        if (mediaInfo == null) {
            imageUri = null;
        } else {
            ImagePicker imagePicker = this.zze;
            if (imagePicker == null || (onPickImage = imagePicker.onPickImage(mediaInfo.getMetadata(), this.zzb)) == null || onPickImage.getUrl() == null) {
                imageUri = MediaUtils.getImageUri(mediaInfo, 0);
            } else {
                imageUri = onPickImage.getUrl();
            }
        }
        if (imageUri == null) {
            zzd();
        } else {
            this.zzf.zzb(imageUri);
        }
    }

    private final void zzd() {
        View view = this.zzd;
        if (view != null) {
            view.setVisibility(0);
            this.zza.setVisibility(4);
        }
        Bitmap bitmap = this.zzc;
        if (bitmap != null) {
            this.zza.setImageBitmap(bitmap);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zzc();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zzf.zza(new zzar(this));
        zzd();
        zzc();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zzf.zzc();
        zzd();
        super.onSessionEnded();
    }
}
