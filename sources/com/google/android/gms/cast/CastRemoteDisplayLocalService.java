package com.google.android.gms.cast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.app.NotificationCompat;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class CastRemoteDisplayLocalService extends Service {
    private static final Logger zza = new Logger("CastRDLocalService");
    private static final int zzb = C3613R.C3615id.cast_notification_id;
    private static final Object zzc = new Object();
    private static AtomicBoolean zzd = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzu;
    private String zze;
    private WeakReference<Callbacks> zzf;
    private zzai zzg;
    private NotificationSettings zzh;
    private Notification zzi;
    private boolean zzj;
    private PendingIntent zzk;
    private CastDevice zzl;
    private Display zzm;
    private Context zzn;
    private ServiceConnection zzo;
    private Handler zzp;
    private MediaRouter zzq;
    private CastRemoteDisplayClient zzs;
    private boolean zzr = false;
    private final MediaRouter.Callback zzt = new zzz(this);
    private final IBinder zzv = new zzah(this);

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public interface Callbacks {
        void onRemoteDisplaySessionEnded(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void zza();
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static final class NotificationSettings {
        private Notification zza;
        private PendingIntent zzb;
        private String zzc;
        private String zzd;

        /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
        /* loaded from: classes2.dex */
        public static final class Builder {
            private NotificationSettings zza = new NotificationSettings(null);

            public NotificationSettings build() {
                if (this.zza.zza != null) {
                    if (TextUtils.isEmpty(this.zza.zzc)) {
                        if (TextUtils.isEmpty(this.zza.zzd)) {
                            if (this.zza.zzb != null) {
                                throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                            }
                        } else {
                            throw new IllegalArgumentException("notificationText requires using the default notification");
                        }
                    } else {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zza.zzc) && TextUtils.isEmpty(this.zza.zzd) && this.zza.zzb == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zza;
            }

            public Builder setNotification(Notification notification) {
                this.zza.zza = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent pendingIntent) {
                this.zza.zzb = pendingIntent;
                return this;
            }

            public Builder setNotificationText(String str) {
                this.zza.zzd = str;
                return this;
            }

            public Builder setNotificationTitle(String str) {
                this.zza.zzc = str;
                return this;
            }
        }

        private NotificationSettings() {
        }

        /* synthetic */ NotificationSettings(NotificationSettings notificationSettings, zzz zzzVar) {
            this.zza = notificationSettings.zza;
            this.zzb = notificationSettings.zzb;
            this.zzc = notificationSettings.zzc;
            this.zzd = notificationSettings.zzd;
        }

        /* synthetic */ NotificationSettings(zzz zzzVar) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Options {
        int zza = 2;

        public int getConfigPreset() {
            return this.zza;
        }

        public void setConfigPreset(int i) {
            this.zza = i;
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzc) {
            castRemoteDisplayLocalService = zzu;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zza.zzc(true);
    }

    public static void startService(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, NotificationSettings notificationSettings, Callbacks callbacks) {
        startServiceWithOptions(context, cls, str, castDevice, new Options(), notificationSettings, callbacks);
    }

    public static void startServiceWithOptions(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Callbacks callbacks) {
        Logger logger = zza;
        logger.m369d("Starting Service", new Object[0]);
        synchronized (zzc) {
            if (zzu != null) {
                logger.m362w("An existing service had not been stopped before starting one", new Object[0]);
                zzv(true);
            }
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
            Preconditions.checkNotNull(context, "activityContext is required.");
            Preconditions.checkNotNull(cls, "serviceClass is required.");
            Preconditions.checkNotNull(str, "applicationId is required.");
            Preconditions.checkNotNull(castDevice, "device is required.");
            Preconditions.checkNotNull(options, "options is required.");
            Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
            Preconditions.checkNotNull(callbacks, "callbacks is required.");
            if (notificationSettings.zza != null || notificationSettings.zzb != null) {
                if (zzd.getAndSet(true)) {
                    logger.m367e("Service is already being started, startService has been called twice", new Object[0]);
                    return;
                }
                Intent intent = new Intent(context, cls);
                context.startService(intent);
                ConnectionTracker.getInstance().bindService(context, intent, new zzab(str, castDevice, options, notificationSettings, context, callbacks), 64);
                return;
            }
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    public static void stopService() {
        zzv(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zze(CastRemoteDisplayLocalService castRemoteDisplayLocalService, String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        castRemoteDisplayLocalService.zzx("startRemoteDisplaySession");
        Preconditions.checkMainThread("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzc) {
            if (zzu != null) {
                zza.m362w("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            zzu = castRemoteDisplayLocalService;
            castRemoteDisplayLocalService.zzf = new WeakReference<>(callbacks);
            castRemoteDisplayLocalService.zze = str;
            castRemoteDisplayLocalService.zzl = castDevice;
            castRemoteDisplayLocalService.zzn = context;
            castRemoteDisplayLocalService.zzo = serviceConnection;
            if (castRemoteDisplayLocalService.zzq == null) {
                castRemoteDisplayLocalService.zzq = MediaRouter.getInstance(castRemoteDisplayLocalService.getApplicationContext());
            }
            Preconditions.checkNotNull(castRemoteDisplayLocalService.zze, "applicationId is required.");
            MediaRouteSelector build = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(castRemoteDisplayLocalService.zze)).build();
            castRemoteDisplayLocalService.zzx("addMediaRouterCallback");
            castRemoteDisplayLocalService.zzq.addCallback(build, castRemoteDisplayLocalService.zzt, 4);
            castRemoteDisplayLocalService.zzi = notificationSettings.zza;
            castRemoteDisplayLocalService.zzg = new zzai(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intentFilter.addAction("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
            castRemoteDisplayLocalService.registerReceiver(castRemoteDisplayLocalService.zzg, intentFilter);
            NotificationSettings notificationSettings2 = new NotificationSettings(notificationSettings, null);
            castRemoteDisplayLocalService.zzh = notificationSettings2;
            if (notificationSettings2.zza == null) {
                castRemoteDisplayLocalService.zzj = true;
                castRemoteDisplayLocalService.zzi = castRemoteDisplayLocalService.zzw(false);
            } else {
                castRemoteDisplayLocalService.zzj = false;
                castRemoteDisplayLocalService.zzi = castRemoteDisplayLocalService.zzh.zza;
            }
            castRemoteDisplayLocalService.startForeground(zzb, castRemoteDisplayLocalService.zzi);
            castRemoteDisplayLocalService.zzx("startRemoteDisplay");
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
            Preconditions.checkNotNull(castRemoteDisplayLocalService.zzn, "activityContext is required.");
            intent.setPackage(castRemoteDisplayLocalService.zzn.getPackageName());
            PendingIntent zzb2 = com.google.android.gms.internal.cast.zzch.zzb(castRemoteDisplayLocalService, 0, intent, com.google.android.gms.internal.cast.zzch.zza);
            zzae zzaeVar = new zzae(castRemoteDisplayLocalService);
            Preconditions.checkNotNull(castRemoteDisplayLocalService.zze, "applicationId is required.");
            castRemoteDisplayLocalService.zzs.zze(castDevice, castRemoteDisplayLocalService.zze, options.getConfigPreset(), zzb2, zzaeVar).addOnCompleteListener(new zzaf(castRemoteDisplayLocalService));
            Callbacks callbacks2 = castRemoteDisplayLocalService.zzf.get();
            if (callbacks2 == null) {
                return true;
            }
            callbacks2.onServiceCreated(castRemoteDisplayLocalService);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(CastRemoteDisplayLocalService castRemoteDisplayLocalService, NotificationSettings notificationSettings) {
        Preconditions.checkMainThread("updateNotificationSettingsInternal must be called on the main thread");
        if (castRemoteDisplayLocalService.zzh != null) {
            if (castRemoteDisplayLocalService.zzj) {
                if (notificationSettings.zza == null) {
                    if (notificationSettings.zzb != null) {
                        castRemoteDisplayLocalService.zzh.zzb = notificationSettings.zzb;
                    }
                    if (!TextUtils.isEmpty(notificationSettings.zzc)) {
                        castRemoteDisplayLocalService.zzh.zzc = notificationSettings.zzc;
                    }
                    if (!TextUtils.isEmpty(notificationSettings.zzd)) {
                        castRemoteDisplayLocalService.zzh.zzd = notificationSettings.zzd;
                    }
                    castRemoteDisplayLocalService.zzi = castRemoteDisplayLocalService.zzw(true);
                } else {
                    throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
                }
            } else {
                Preconditions.checkNotNull(notificationSettings.zza, "notification is required.");
                Notification notification = notificationSettings.zza;
                castRemoteDisplayLocalService.zzi = notification;
                castRemoteDisplayLocalService.zzh.zza = notification;
            }
            castRemoteDisplayLocalService.startForeground(zzb, castRemoteDisplayLocalService.zzi);
            return;
        }
        throw new IllegalStateException("No current notification settings to update");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        Callbacks callbacks = castRemoteDisplayLocalService.zzf.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
        }
        stopService();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(CastRemoteDisplayLocalService castRemoteDisplayLocalService, Display display) {
        if (display == null) {
            zza.m367e("Cast Remote Display session created without display", new Object[0]);
            return;
        }
        castRemoteDisplayLocalService.zzm = display;
        if (castRemoteDisplayLocalService.zzj) {
            Notification zzw = castRemoteDisplayLocalService.zzw(true);
            castRemoteDisplayLocalService.zzi = zzw;
            castRemoteDisplayLocalService.startForeground(zzb, zzw);
        }
        Callbacks callbacks = castRemoteDisplayLocalService.zzf.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionStarted(castRemoteDisplayLocalService);
        }
        Preconditions.checkNotNull(castRemoteDisplayLocalService.zzm, "display is required.");
        castRemoteDisplayLocalService.onCreatePresentation(castRemoteDisplayLocalService.zzm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu(boolean z) {
        zzx("Stopping Service");
        Preconditions.checkMainThread("stopServiceInstanceInternal must be called on the main thread");
        if (!z && this.zzq != null) {
            zzx("Setting default route");
            MediaRouter mediaRouter = this.zzq;
            mediaRouter.selectRoute(mediaRouter.getDefaultRoute());
        }
        if (this.zzg != null) {
            zzx("Unregistering notification receiver");
            unregisterReceiver(this.zzg);
        }
        zzx("stopRemoteDisplaySession");
        zzx("stopRemoteDisplay");
        this.zzs.stopRemoteDisplay().addOnCompleteListener(new zzag(this));
        Callbacks callbacks = this.zzf.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionEnded(this);
        }
        onDismissPresentation();
        zzx("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
        if (this.zzq != null) {
            Preconditions.checkMainThread("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzx("removeMediaRouterCallback");
            this.zzq.removeCallback(this.zzt);
        }
        Context context = this.zzn;
        ServiceConnection serviceConnection = this.zzo;
        if (context != null && serviceConnection != null) {
            try {
                ConnectionTracker.getInstance().unbindService(context, serviceConnection);
            } catch (IllegalArgumentException unused) {
                zzx("No need to unbind service, already unbound");
            }
        }
        this.zzo = null;
        this.zzn = null;
        this.zze = null;
        this.zzi = null;
        this.zzm = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzv(boolean z) {
        Logger logger = zza;
        logger.m369d("Stopping Service", new Object[0]);
        zzd.set(false);
        synchronized (zzc) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzu;
            if (castRemoteDisplayLocalService == null) {
                logger.m367e("Service is already being stopped", new Object[0]);
                return;
            }
            zzu = null;
            if (castRemoteDisplayLocalService.zzp != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    castRemoteDisplayLocalService.zzp.post(new zzac(castRemoteDisplayLocalService, z));
                } else {
                    castRemoteDisplayLocalService.zzu(z);
                }
            }
        }
    }

    private final Notification zzw(boolean z) {
        int i;
        int i2;
        zzx("createDefaultNotification");
        String str = this.zzh.zzc;
        String str2 = this.zzh.zzd;
        if (z) {
            i = C3613R.string.cast_notification_connected_message;
            i2 = C3613R.C3614drawable.cast_ic_notification_on;
        } else {
            i = C3613R.string.cast_notification_connecting_message;
            i2 = C3613R.C3614drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(str)) {
            str = (String) getPackageManager().getApplicationLabel(getApplicationInfo());
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(i, new Object[]{this.zzl.getFriendlyName()});
        }
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(this, "cast_remote_display_local_service").setContentTitle(str).setContentText(str2).setContentIntent(this.zzh.zzb).setSmallIcon(i2).setOngoing(true);
        String string = getString(C3613R.string.cast_notification_disconnect);
        if (this.zzk == null) {
            Preconditions.checkNotNull(this.zzn, "activityContext is required.");
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intent.setPackage(this.zzn.getPackageName());
            this.zzk = com.google.android.gms.internal.cast.zzch.zzb(this, 0, intent, com.google.android.gms.internal.cast.zzch.zza | 134217728);
        }
        return ongoing.addAction(17301560, string, this.zzk).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzx(String str) {
        zza.m369d("[Instance: %s] %s", this, str);
    }

    protected Display getCastRemoteDisplay() {
        return this.zzm;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        zzx("onBind");
        return this.zzv;
    }

    @Override // android.app.Service
    public void onCreate() {
        zzx("onCreate");
        super.onCreate();
        com.google.android.gms.internal.cast.zzci zzciVar = new com.google.android.gms.internal.cast.zzci(getMainLooper());
        this.zzp = zzciVar;
        zzciVar.postDelayed(new zzaa(this), 100L);
        if (this.zzs == null) {
            this.zzs = CastRemoteDisplay.getClient(this);
        }
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_remote_display_local_service", getString(C3613R.string.cast_notification_default_channel_name), 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        zzx("onStartCommand");
        this.zzr = true;
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
        Preconditions.checkNotNull(this.zzp, "Service is not ready yet.");
        this.zzp.post(new zzad(this, notificationSettings));
    }
}
