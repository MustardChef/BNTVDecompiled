package com.google.android.gms.cast.framework.media.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.p002v4.media.MediaMetadataCompat;
import android.support.p002v4.media.session.MediaSessionCompat;
import android.support.p002v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.media.MediaNotificationService;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzag;
import com.google.android.gms.internal.cast.zzch;
import com.google.android.gms.internal.cast.zzci;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzp implements RemoteMediaClient.Listener {
    private static final Logger zza = new Logger("MediaSessionManager");
    private final Context zzb;
    private final CastOptions zzc;
    private final zzag zzd;
    private final ComponentName zze;
    private final zzb zzf;
    private final zzb zzg;
    private final Handler zzh;
    private final Runnable zzi;
    private RemoteMediaClient zzj;
    private CastDevice zzk;
    private MediaSessionCompat zzl;
    private MediaSessionCompat.Callback zzm;
    private boolean zzn;

    public zzp(Context context, CastOptions castOptions, zzag zzagVar) {
        this.zzb = context;
        this.zzc = castOptions;
        this.zzd = zzagVar;
        if (castOptions.getCastMediaOptions() != null && !TextUtils.isEmpty(castOptions.getCastMediaOptions().getExpandedControllerActivityClassName())) {
            this.zze = new ComponentName(context, castOptions.getCastMediaOptions().getExpandedControllerActivityClassName());
        } else {
            this.zze = null;
        }
        zzb zzbVar = new zzb(context);
        this.zzf = zzbVar;
        zzbVar.zza(new zzm(this));
        zzb zzbVar2 = new zzb(context);
        this.zzg = zzbVar2;
        zzbVar2.zza(new zzn(this));
        this.zzh = new zzci(Looper.getMainLooper());
        this.zzi = new Runnable(this) { // from class: com.google.android.gms.cast.framework.media.internal.zzl
            private final zzp zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze();
            }
        };
    }

    public static Bitmap zza(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = width;
        int i = (int) (((9.0f * f) / 16.0f) + 0.5f);
        float f2 = (i - height) / 2;
        RectF rectF = new RectF(0.0f, f2, f, height + f2);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, i, config);
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        return createBitmap;
    }

    private final void zzh(int i, MediaInfo mediaInfo) {
        PendingIntent zza2;
        MediaSessionCompat mediaSessionCompat = this.zzl;
        if (mediaSessionCompat == null) {
            return;
        }
        if (i == 0) {
            mediaSessionCompat.setPlaybackState(new PlaybackStateCompat.Builder().setState(0, 0L, 1.0f).build());
            this.zzl.setMetadata(new MediaMetadataCompat.Builder().build());
            return;
        }
        this.zzl.setPlaybackState(new PlaybackStateCompat.Builder().setState(i, this.zzj.isLiveStream() ? 0L : this.zzj.getApproximateStreamPosition(), 1.0f).setActions(true != this.zzj.isLiveStream() ? 768L : 512L).build());
        MediaSessionCompat mediaSessionCompat2 = this.zzl;
        if (this.zze == null) {
            zza2 = null;
        } else {
            Intent intent = new Intent();
            intent.setComponent(this.zze);
            zza2 = zzch.zza(this.zzb, 0, intent, zzch.zza | 134217728);
        }
        mediaSessionCompat2.setSessionActivity(zza2);
        if (this.zzl == null) {
            return;
        }
        MediaMetadata metadata = mediaInfo.getMetadata();
        this.zzl.setMetadata(zzk().putString("android.media.metadata.TITLE", metadata.getString(MediaMetadata.KEY_TITLE)).putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, metadata.getString(MediaMetadata.KEY_TITLE)).putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, metadata.getString(MediaMetadata.KEY_SUBTITLE)).putLong("android.media.metadata.DURATION", this.zzj.isLiveStream() ? 0L : mediaInfo.getStreamDuration()).build());
        Uri zzj = zzj(metadata, 0);
        if (zzj != null) {
            this.zzf.zzb(zzj);
        } else {
            zzi(null, 0);
        }
        Uri zzj2 = zzj(metadata, 3);
        if (zzj2 != null) {
            this.zzg.zzb(zzj2);
        } else {
            zzi(null, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(Bitmap bitmap, int i) {
        MediaSessionCompat mediaSessionCompat = this.zzl;
        if (mediaSessionCompat == null) {
            return;
        }
        if (i != 0) {
            if (i == 3) {
                mediaSessionCompat.setMetadata(zzk().putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, bitmap).build());
            }
        } else if (bitmap != null) {
            mediaSessionCompat.setMetadata(zzk().putBitmap(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, bitmap).build());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(0);
            this.zzl.setMetadata(zzk().putBitmap(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, createBitmap).build());
        }
    }

    private final Uri zzj(MediaMetadata mediaMetadata, int i) {
        WebImage webImage;
        if (this.zzc.getCastMediaOptions().getImagePicker() != null) {
            webImage = this.zzc.getCastMediaOptions().getImagePicker().onPickImage(mediaMetadata, i);
        } else {
            webImage = mediaMetadata.hasImages() ? mediaMetadata.getImages().get(0) : null;
        }
        if (webImage == null) {
            return null;
        }
        return webImage.getUrl();
    }

    private final MediaMetadataCompat.Builder zzk() {
        MediaSessionCompat mediaSessionCompat = this.zzl;
        MediaMetadataCompat metadata = mediaSessionCompat == null ? null : mediaSessionCompat.getController().getMetadata();
        if (metadata == null) {
            return new MediaMetadataCompat.Builder();
        }
        return new MediaMetadataCompat.Builder(metadata);
    }

    private final void zzl() {
        if (this.zzc.getCastMediaOptions().getNotificationOptions() == null) {
            return;
        }
        zza.m369d("Stopping notification service.", new Object[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            MediaNotificationService.zza();
            return;
        }
        Intent intent = new Intent(this.zzb, MediaNotificationService.class);
        intent.setPackage(this.zzb.getPackageName());
        intent.setAction(MediaNotificationService.ACTION_UPDATE_NOTIFICATION);
        this.zzb.stopService(intent);
    }

    private final void zzm(boolean z) {
        if (this.zzc.getEnableReconnectionService()) {
            this.zzh.removeCallbacks(this.zzi);
            Intent intent = new Intent(this.zzb, ReconnectionService.class);
            intent.setPackage(this.zzb.getPackageName());
            try {
                this.zzb.startService(intent);
            } catch (IllegalStateException unused) {
                if (z) {
                    this.zzh.postDelayed(this.zzi, 1000L);
                }
            }
        }
    }

    private final void zzn() {
        if (this.zzc.getEnableReconnectionService()) {
            this.zzh.removeCallbacks(this.zzi);
            Intent intent = new Intent(this.zzb, ReconnectionService.class);
            intent.setPackage(this.zzb.getPackageName());
            this.zzb.stopService(intent);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onAdBreakStatusUpdated() {
        zzd(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onMetadataUpdated() {
        zzd(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onPreloadStatusUpdated() {
        zzd(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onQueueStatusUpdated() {
        zzd(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onSendingRemoteMediaRequest() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onStatusUpdated() {
        zzd(false);
    }

    public final void zzb(RemoteMediaClient remoteMediaClient, CastDevice castDevice) {
        CastOptions castOptions;
        if (this.zzn || (castOptions = this.zzc) == null || castOptions.getCastMediaOptions() == null || remoteMediaClient == null || castDevice == null) {
            return;
        }
        this.zzj = remoteMediaClient;
        remoteMediaClient.addListener(this);
        this.zzk = castDevice;
        if (!PlatformVersion.isAtLeastLollipop()) {
            ((AudioManager) this.zzb.getSystemService("audio")).requestAudioFocus(null, 3, 3);
        }
        ComponentName componentName = new ComponentName(this.zzb, this.zzc.getCastMediaOptions().getMediaIntentReceiverClassName());
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        PendingIntent zzb = zzch.zzb(this.zzb, 0, intent, zzch.zza);
        if (this.zzc.getCastMediaOptions().getMediaSessionEnabled()) {
            this.zzl = new MediaSessionCompat(this.zzb, "CastMediaSession", componentName, zzb);
            zzh(0, null);
            CastDevice castDevice2 = this.zzk;
            if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.getFriendlyName())) {
                this.zzl.setMetadata(new MediaMetadataCompat.Builder().putString("android.media.metadata.ALBUM_ARTIST", this.zzb.getResources().getString(C3616R.string.cast_casting_to_device, this.zzk.getFriendlyName())).build());
            }
            zzo zzoVar = new zzo(this);
            this.zzm = zzoVar;
            this.zzl.setCallback(zzoVar);
            this.zzl.setActive(true);
            this.zzd.zzl(this.zzl);
        }
        this.zzn = true;
        zzd(false);
    }

    public final void zzc(int i) {
        if (this.zzn) {
            this.zzn = false;
            RemoteMediaClient remoteMediaClient = this.zzj;
            if (remoteMediaClient != null) {
                remoteMediaClient.removeListener(this);
            }
            if (!PlatformVersion.isAtLeastLollipop()) {
                ((AudioManager) this.zzb.getSystemService("audio")).abandonAudioFocus(null);
            }
            this.zzd.zzl(null);
            this.zzf.zzc();
            zzb zzbVar = this.zzg;
            if (zzbVar != null) {
                zzbVar.zzc();
            }
            MediaSessionCompat mediaSessionCompat = this.zzl;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.setSessionActivity(null);
                this.zzl.setCallback(null);
                this.zzl.setMetadata(new MediaMetadataCompat.Builder().build());
                zzh(0, null);
                this.zzl.setActive(false);
                this.zzl.release();
                this.zzl = null;
            }
            this.zzj = null;
            this.zzk = null;
            this.zzm = null;
            zzl();
            if (i == 0) {
                zzn();
            }
        }
    }

    public final void zzd(boolean z) {
        boolean z2;
        boolean z3;
        MediaQueueItem loadingItem;
        RemoteMediaClient remoteMediaClient = this.zzj;
        if (remoteMediaClient == null) {
            return;
        }
        MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
        int i = 6;
        if (!this.zzj.isBuffering()) {
            if (this.zzj.isPlaying()) {
                i = 3;
            } else if (this.zzj.isPaused()) {
                i = 2;
            } else if (!this.zzj.isLoadingNextItem() || (loadingItem = this.zzj.getLoadingItem()) == null || loadingItem.getMedia() == null) {
                i = 0;
            } else {
                mediaInfo = loadingItem.getMedia();
            }
        }
        i = (mediaInfo == null || mediaInfo.getMetadata() == null) ? 0 : 0;
        zzh(i, mediaInfo);
        if (!this.zzj.hasMediaSession()) {
            zzl();
            zzn();
        } else if (i != 0) {
            if (this.zzk != null && MediaNotificationService.isNotificationOptionsValid(this.zzc)) {
                Intent intent = new Intent(this.zzb, MediaNotificationService.class);
                intent.putExtra("extra_media_notification_force_update", z);
                intent.setPackage(this.zzb.getPackageName());
                intent.setAction(MediaNotificationService.ACTION_UPDATE_NOTIFICATION);
                intent.putExtra("extra_media_info", this.zzj.getMediaInfo());
                intent.putExtra("extra_remote_media_client_player_state", this.zzj.getPlayerState());
                intent.putExtra("extra_cast_device", this.zzk);
                MediaSessionCompat mediaSessionCompat = this.zzl;
                if (mediaSessionCompat != null) {
                    intent.putExtra("extra_media_session_token", mediaSessionCompat.getSessionToken());
                }
                MediaStatus mediaStatus = this.zzj.getMediaStatus();
                int queueRepeatMode = mediaStatus.getQueueRepeatMode();
                if (queueRepeatMode == 1 || queueRepeatMode == 2 || queueRepeatMode == 3) {
                    z2 = true;
                    z3 = true;
                } else {
                    Integer indexById = mediaStatus.getIndexById(mediaStatus.getCurrentItemId());
                    if (indexById != null) {
                        z3 = indexById.intValue() > 0;
                        z2 = indexById.intValue() < mediaStatus.getQueueItemCount() + (-1);
                    } else {
                        z2 = false;
                        z3 = false;
                    }
                }
                intent.putExtra("extra_can_skip_next", z2);
                intent.putExtra("extra_can_skip_prev", z3);
                zza.m369d("Starting notification service.", new Object[0]);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.zzb.startForegroundService(intent);
                } else {
                    this.zzb.startService(intent);
                }
            }
            if (this.zzj.isLoadingNextItem()) {
                return;
            }
            zzm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        zzm(false);
    }
}
