package com.google.android.gms.cast.framework.media;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.p002v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.media.app.NotificationCompat;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaNotificationService extends Service {
    public static final String ACTION_UPDATE_NOTIFICATION = "com.google.android.gms.cast.framework.action.UPDATE_NOTIFICATION";
    private static final Logger zza = new Logger("MediaNotificationService");
    private static Runnable zzb;
    private NotificationOptions zzc;
    private ImagePicker zzd;
    private ComponentName zze;
    private ComponentName zzf;
    private int[] zzh;
    private long zzi;
    private com.google.android.gms.cast.framework.media.internal.zzb zzj;
    private ImageHints zzk;
    private Resources zzl;
    private zzn zzm;
    private zzo zzn;
    private NotificationManager zzo;
    private Notification zzp;
    private CastContext zzq;
    private List<NotificationCompat.Action> zzg = new ArrayList();
    private final BroadcastReceiver zzr = new zzl(this);

    public static boolean isNotificationOptionsValid(CastOptions castOptions) {
        NotificationOptions notificationOptions;
        CastMediaOptions castMediaOptions = castOptions.getCastMediaOptions();
        if (castMediaOptions == null || (notificationOptions = castMediaOptions.getNotificationOptions()) == null) {
            return false;
        }
        zzg zzm = notificationOptions.zzm();
        if (zzm == null) {
            return true;
        }
        List<NotificationAction> zzf = zzf(zzm);
        int[] zzg = zzg(zzm);
        int size = zzf == null ? 0 : zzf.size();
        if (zzf == null || zzf.isEmpty()) {
            zza.m367e(String.valueOf(NotificationActionsProvider.class.getSimpleName()).concat(" doesn't provide any action."), new Object[0]);
        } else if (zzf.size() > 5) {
            zza.m367e(String.valueOf(NotificationActionsProvider.class.getSimpleName()).concat(" provides more than 5 actions."), new Object[0]);
        } else if (zzg != null && (r2 = zzg.length) != 0) {
            for (int i : zzg) {
                if (i < 0 || i >= size) {
                    zza.m367e(String.valueOf(NotificationActionsProvider.class.getSimpleName()).concat("provides a compact view action whose index is out of bounds."), new Object[0]);
                }
            }
            return true;
        } else {
            zza.m367e(String.valueOf(NotificationActionsProvider.class.getSimpleName()).concat(" doesn't provide any actions for compact view."), new Object[0]);
        }
        return false;
    }

    public static void zza() {
        Runnable runnable = zzb;
        if (runnable != null) {
            runnable.run();
        }
    }

    private static List<NotificationAction> zzf(zzg zzgVar) {
        try {
            return zzgVar.zzf();
        } catch (RemoteException e) {
            zza.m366e(e, "Unable to call %s on %s.", "getNotificationActions", zzg.class.getSimpleName());
            return null;
        }
    }

    private static int[] zzg(zzg zzgVar) {
        try {
            return zzgVar.zzg();
        } catch (RemoteException e) {
            zza.m366e(e, "Unable to call %s on %s.", "getCompactViewActionIndices", zzg.class.getSimpleName());
            return null;
        }
    }

    private final void zzh() {
        this.zzg = new ArrayList();
        for (String str : this.zzc.getActions()) {
            NotificationCompat.Action zzk = zzk(str);
            if (zzk != null) {
                this.zzg.add(zzk);
            }
        }
        this.zzh = (int[]) this.zzc.getCompatActionIndices().clone();
    }

    private final void zzi(zzg zzgVar) {
        NotificationCompat.Action zzk;
        int[] zzg = zzg(zzgVar);
        this.zzh = zzg == null ? null : (int[]) zzg.clone();
        List<NotificationAction> zzf = zzf(zzgVar);
        this.zzg = new ArrayList();
        if (zzf == null) {
            return;
        }
        for (NotificationAction notificationAction : zzf) {
            String action = notificationAction.getAction();
            if (action.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || action.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || action.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || action.equals(MediaIntentReceiver.ACTION_FORWARD) || action.equals(MediaIntentReceiver.ACTION_REWIND) || action.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || action.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                zzk = zzk(notificationAction.getAction());
            } else {
                Intent intent = new Intent(notificationAction.getAction());
                intent.setComponent(this.zze);
                zzk = new NotificationCompat.Action.Builder(notificationAction.getIconResId(), notificationAction.getContentDescription(), zzch.zzb(this, 0, intent, zzch.zza)).build();
            }
            if (zzk != null) {
                this.zzg.add(zzk);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final NotificationCompat.Action zzk(String str) {
        char c;
        int pauseDrawableResId;
        int zzb2;
        switch (str.hashCode()) {
            case -1699820260:
                if (str.equals(MediaIntentReceiver.ACTION_REWIND)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -945151566:
                if (str.equals(MediaIntentReceiver.ACTION_SKIP_NEXT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -945080078:
                if (str.equals(MediaIntentReceiver.ACTION_SKIP_PREV)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -668151673:
                if (str.equals(MediaIntentReceiver.ACTION_STOP_CASTING)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -124479363:
                if (str.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 235550565:
                if (str.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1362116196:
                if (str.equals(MediaIntentReceiver.ACTION_FORWARD)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        PendingIntent pendingIntent = null;
        switch (c) {
            case 0:
                zzn zznVar = this.zzm;
                int i = zznVar.zzc;
                boolean z = zznVar.zzb;
                if (i == 2) {
                    pauseDrawableResId = this.zzc.getStopLiveStreamDrawableResId();
                    zzb2 = this.zzc.getStopLiveStreamTitleResId();
                } else {
                    pauseDrawableResId = this.zzc.getPauseDrawableResId();
                    zzb2 = this.zzc.zzb();
                }
                if (!z) {
                    pauseDrawableResId = this.zzc.getPlayDrawableResId();
                }
                if (!z) {
                    zzb2 = this.zzc.zzc();
                }
                Intent intent = new Intent(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
                intent.setComponent(this.zze);
                return new NotificationCompat.Action.Builder(pauseDrawableResId, this.zzl.getString(zzb2), zzch.zzb(this, 0, intent, zzch.zza)).build();
            case 1:
                if (this.zzm.zzf) {
                    Intent intent2 = new Intent(MediaIntentReceiver.ACTION_SKIP_NEXT);
                    intent2.setComponent(this.zze);
                    pendingIntent = zzch.zzb(this, 0, intent2, zzch.zza);
                }
                return new NotificationCompat.Action.Builder(this.zzc.getSkipNextDrawableResId(), this.zzl.getString(this.zzc.zzd()), pendingIntent).build();
            case 2:
                if (this.zzm.zzg) {
                    Intent intent3 = new Intent(MediaIntentReceiver.ACTION_SKIP_PREV);
                    intent3.setComponent(this.zze);
                    pendingIntent = zzch.zzb(this, 0, intent3, zzch.zza);
                }
                return new NotificationCompat.Action.Builder(this.zzc.getSkipPrevDrawableResId(), this.zzl.getString(this.zzc.zze()), pendingIntent).build();
            case 3:
                long j = this.zzi;
                Intent intent4 = new Intent(MediaIntentReceiver.ACTION_FORWARD);
                intent4.setComponent(this.zze);
                intent4.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j);
                PendingIntent zzb3 = zzch.zzb(this, 0, intent4, zzch.zza | 134217728);
                int forwardDrawableResId = this.zzc.getForwardDrawableResId();
                int zzf = this.zzc.zzf();
                if (j == 10000) {
                    forwardDrawableResId = this.zzc.getForward10DrawableResId();
                    zzf = this.zzc.zzg();
                } else if (j == 30000) {
                    forwardDrawableResId = this.zzc.getForward30DrawableResId();
                    zzf = this.zzc.zzh();
                }
                return new NotificationCompat.Action.Builder(forwardDrawableResId, this.zzl.getString(zzf), zzb3).build();
            case 4:
                long j2 = this.zzi;
                Intent intent5 = new Intent(MediaIntentReceiver.ACTION_REWIND);
                intent5.setComponent(this.zze);
                intent5.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j2);
                PendingIntent zzb4 = zzch.zzb(this, 0, intent5, zzch.zza | 134217728);
                int rewindDrawableResId = this.zzc.getRewindDrawableResId();
                int zzi = this.zzc.zzi();
                if (j2 == 10000) {
                    rewindDrawableResId = this.zzc.getRewind10DrawableResId();
                    zzi = this.zzc.zzj();
                } else if (j2 == 30000) {
                    rewindDrawableResId = this.zzc.getRewind30DrawableResId();
                    zzi = this.zzc.zzk();
                }
                return new NotificationCompat.Action.Builder(rewindDrawableResId, this.zzl.getString(zzi), zzb4).build();
            case 5:
                Intent intent6 = new Intent(MediaIntentReceiver.ACTION_STOP_CASTING);
                intent6.setComponent(this.zze);
                return new NotificationCompat.Action.Builder(this.zzc.getDisconnectDrawableResId(), this.zzl.getString(this.zzc.zzl()), zzch.zzb(this, 0, intent6, zzch.zza)).build();
            case 6:
                Intent intent7 = new Intent(MediaIntentReceiver.ACTION_DISCONNECT);
                intent7.setComponent(this.zze);
                return new NotificationCompat.Action.Builder(this.zzc.getDisconnectDrawableResId(), this.zzl.getString(this.zzc.zzl(), ""), PendingIntent.getBroadcast(this, 0, intent7, 0)).build();
            default:
                zza.m367e("Action: %s is not a pre-defined action.", str);
                return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.zzo = (NotificationManager) getSystemService("notification");
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        this.zzq = sharedInstance;
        CastMediaOptions castMediaOptions = (CastMediaOptions) Preconditions.checkNotNull(sharedInstance.getCastOptions().getCastMediaOptions());
        this.zzc = (NotificationOptions) Preconditions.checkNotNull(castMediaOptions.getNotificationOptions());
        this.zzd = castMediaOptions.getImagePicker();
        this.zzl = getResources();
        this.zze = new ComponentName(getApplicationContext(), castMediaOptions.getMediaIntentReceiverClassName());
        if (!TextUtils.isEmpty(this.zzc.getTargetActivityClassName())) {
            this.zzf = new ComponentName(getApplicationContext(), this.zzc.getTargetActivityClassName());
        } else {
            this.zzf = null;
        }
        this.zzi = this.zzc.getSkipStepMs();
        int dimensionPixelSize = this.zzl.getDimensionPixelSize(this.zzc.zza());
        this.zzk = new ImageHints(1, dimensionPixelSize, dimensionPixelSize);
        this.zzj = new com.google.android.gms.cast.framework.media.internal.zzb(getApplicationContext(), this.zzk);
        ComponentName componentName = this.zzf;
        if (componentName != null) {
            registerReceiver(this.zzr, new IntentFilter(componentName.flattenToString()));
        }
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_media_notification", "Cast", 2);
            notificationChannel.setShowBadge(false);
            this.zzo.createNotificationChannel(notificationChannel);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.google.android.gms.cast.framework.media.internal.zzb zzbVar = this.zzj;
        if (zzbVar != null) {
            zzbVar.zzc();
        }
        if (this.zzf != null) {
            try {
                unregisterReceiver(this.zzr);
            } catch (IllegalArgumentException e) {
                zza.m366e(e, "Unregistering trampoline BroadcastReceiver failed", new Object[0]);
            }
        }
        zzb = null;
        this.zzo.cancel(1);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, final int i2) {
        WebImage webImage;
        zzn zznVar;
        MediaInfo mediaInfo = (MediaInfo) Preconditions.checkNotNull((MediaInfo) intent.getParcelableExtra("extra_media_info"));
        MediaMetadata mediaMetadata = (MediaMetadata) Preconditions.checkNotNull(mediaInfo.getMetadata());
        zzn zznVar2 = new zzn(intent.getIntExtra("extra_remote_media_client_player_state", 0) == 2, mediaInfo.getStreamType(), mediaMetadata.getString(MediaMetadata.KEY_TITLE), ((CastDevice) Preconditions.checkNotNull((CastDevice) intent.getParcelableExtra("extra_cast_device"))).getFriendlyName(), (MediaSessionCompat.Token) intent.getParcelableExtra("extra_media_session_token"), intent.getBooleanExtra("extra_can_skip_next", false), intent.getBooleanExtra("extra_can_skip_prev", false));
        if (intent.getBooleanExtra("extra_media_notification_force_update", false) || (zznVar = this.zzm) == null || zznVar2.zzb != zznVar.zzb || zznVar2.zzc != zznVar.zzc || !CastUtils.zza(zznVar2.zzd, zznVar.zzd) || !CastUtils.zza(zznVar2.zze, zznVar.zze) || zznVar2.zzf != zznVar.zzf || zznVar2.zzg != zznVar.zzg) {
            this.zzm = zznVar2;
            zzj();
        }
        ImagePicker imagePicker = this.zzd;
        if (imagePicker != null) {
            webImage = imagePicker.onPickImage(mediaMetadata, this.zzk);
        } else {
            webImage = mediaMetadata.hasImages() ? mediaMetadata.getImages().get(0) : null;
        }
        zzo zzoVar = new zzo(webImage);
        zzo zzoVar2 = this.zzn;
        if (zzoVar2 == null || !CastUtils.zza(zzoVar.zza, zzoVar2.zza)) {
            this.zzj.zza(new zzm(this, zzoVar));
            this.zzj.zzb(zzoVar.zza);
        }
        startForeground(1, this.zzp);
        zzb = new Runnable(this, i2) { // from class: com.google.android.gms.cast.framework.media.zzk
            private final MediaNotificationService zza;
            private final int zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.stopSelf(this.zzb);
            }
        };
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj() {
        if (this.zzm == null) {
            return;
        }
        zzo zzoVar = this.zzn;
        PendingIntent pendingIntent = null;
        NotificationCompat.Builder visibility = new NotificationCompat.Builder(this, "cast_media_notification").setLargeIcon(zzoVar == null ? null : zzoVar.zzb).setSmallIcon(this.zzc.getSmallIconDrawableResId()).setContentTitle(this.zzm.zzd).setContentText(this.zzl.getString(this.zzc.getCastingToDeviceStringResId(), this.zzm.zze)).setOngoing(true).setShowWhen(false).setVisibility(1);
        ComponentName componentName = this.zzf;
        if (componentName != null) {
            Intent intent = new Intent();
            intent.putExtra("targetActivity", componentName);
            intent.setAction(componentName.flattenToString());
            pendingIntent = zzch.zzb(this, 1, intent, zzch.zza | 134217728);
        }
        if (pendingIntent != null) {
            visibility.setContentIntent(pendingIntent);
        }
        zzg zzm = this.zzc.zzm();
        if (zzm != null) {
            zza.m365i("actionsProvider != null", new Object[0]);
            zzi(zzm);
        } else {
            zza.m365i("actionsProvider == null", new Object[0]);
            zzh();
        }
        for (NotificationCompat.Action action : this.zzg) {
            visibility.addAction(action);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
            int[] iArr = this.zzh;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.zzm.zza;
            if (token != null) {
                mediaStyle.setMediaSession(token);
            }
            visibility.setStyle(mediaStyle);
        }
        Notification build = visibility.build();
        this.zzp = build;
        startForeground(1, build);
    }
}
