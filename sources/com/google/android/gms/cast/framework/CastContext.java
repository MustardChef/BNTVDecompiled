package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.cast.zzjt;
import com.google.android.gms.internal.cast.zzkt;
import com.google.android.gms.tasks.OnSuccessListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class CastContext {
    public static final String OPTIONS_PROVIDER_CLASS_NAME_KEY = "com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME";
    private static final Logger zza = new Logger("CastContext");
    private static final Object zzb = new Object();
    private static CastContext zzc;
    private final Context zzd;
    private final zzu zze;
    private final SessionManager zzf;
    private final zzp zzg;
    private final PrecacheManager zzh;
    private final MediaNotificationManager zzi;
    private final CastOptions zzj;
    private final com.google.android.gms.internal.cast.zzag zzk;
    private final List<SessionProvider> zzl;
    private com.google.android.gms.internal.cast.zzo zzm;
    private CastReasonCodes zzn;

    private CastContext(Context context, CastOptions castOptions, List<SessionProvider> list, com.google.android.gms.internal.cast.zzag zzagVar) throws zzar {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        this.zzj = castOptions;
        this.zzk = zzagVar;
        this.zzl = list;
        zzi();
        try {
            zzu zza2 = com.google.android.gms.internal.cast.zzm.zza(applicationContext, castOptions, zzagVar, zzh());
            this.zze = zza2;
            try {
                this.zzg = new zzp(zza2.zzg());
                try {
                    SessionManager sessionManager = new SessionManager(zza2.zzf(), applicationContext);
                    this.zzf = sessionManager;
                    this.zzi = new MediaNotificationManager(sessionManager);
                    this.zzh = new PrecacheManager(castOptions, sessionManager, new com.google.android.gms.cast.internal.zzn(applicationContext));
                    new com.google.android.gms.cast.internal.zzn(applicationContext).zzb(new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"}).addOnSuccessListener(new OnSuccessListener(this) { // from class: com.google.android.gms.cast.framework.zza
                        private final CastContext zza;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zza = this;
                        }

                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            this.zza.zzf((Bundle) obj);
                        }
                    });
                    new com.google.android.gms.cast.internal.zzn(applicationContext).zzd(new String[]{"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"}).addOnSuccessListener(new OnSuccessListener(this) { // from class: com.google.android.gms.cast.framework.zzb
                        private final CastContext zza;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zza = this;
                        }

                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            this.zza.zze((Bundle) obj);
                        }
                    });
                } catch (RemoteException e) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e);
                }
            } catch (RemoteException e2) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e2);
            }
        } catch (RemoteException e3) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e3);
        }
    }

    public static CastContext getSharedInstance() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return zzc;
    }

    public static CastContext zza(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return getSharedInstance(context);
        } catch (RuntimeException e) {
            zza.m367e("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e);
            return null;
        }
    }

    private static OptionsProvider zzg(Context context) throws IllegalStateException {
        try {
            Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                zza.m367e("Bundle is null", new Object[0]);
            }
            String string = bundle.getString(OPTIONS_PROVIDER_CLASS_NAME_KEY);
            if (string == null) {
                throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
            }
            return (OptionsProvider) Class.forName(string).asSubclass(OptionsProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        }
    }

    private final Map<String, IBinder> zzh() {
        HashMap hashMap = new HashMap();
        com.google.android.gms.internal.cast.zzo zzoVar = this.zzm;
        if (zzoVar != null) {
            hashMap.put(zzoVar.getCategory(), this.zzm.zza());
        }
        List<SessionProvider> list = this.zzl;
        if (list != null) {
            for (SessionProvider sessionProvider : list) {
                Preconditions.checkNotNull(sessionProvider, "Additional SessionProvider must not be null.");
                String checkNotEmpty = Preconditions.checkNotEmpty(sessionProvider.getCategory(), "Category for SessionProvider must not be null or empty string.");
                Preconditions.checkArgument(!hashMap.containsKey(checkNotEmpty), String.format("SessionProvider for category %s already added", checkNotEmpty));
                hashMap.put(checkNotEmpty, sessionProvider.zza());
            }
        }
        return hashMap;
    }

    @RequiresNonNull({"castOptions", "mediaRouter", "appContext"})
    private final void zzi() {
        this.zzm = !TextUtils.isEmpty(this.zzj.getReceiverApplicationId()) ? new com.google.android.gms.internal.cast.zzo(this.zzd, this.zzj, this.zzk) : null;
    }

    private static final boolean zzj(CastSession castSession, double d, boolean z) {
        if (z) {
            try {
                double volume = castSession.getVolume() + d;
                if (volume > 1.0d) {
                    volume = 1.0d;
                }
                castSession.setVolume(volume);
            } catch (IOException | IllegalStateException e) {
                zza.m367e("Unable to call CastSession.setVolume(double).", e);
            }
        }
        return true;
    }

    @Deprecated
    public void addAppVisibilityListener(AppVisibilityListener appVisibilityListener) throws IllegalStateException, NullPointerException {
    }

    public void addCastStateListener(CastStateListener castStateListener) throws IllegalStateException, NullPointerException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(castStateListener);
        this.zzf.zzb(castStateListener);
    }

    public CastOptions getCastOptions() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public int getCastReasonCodeForCastStatusCode(int i) {
        CastReasonCodes castReasonCodes = this.zzn;
        if (castReasonCodes == null) {
            zza.m362w("castReasonCodes hasn't been initialized yet", new Object[0]);
            return 0;
        }
        return castReasonCodes.zza(i);
    }

    public int getCastState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzf.zza();
    }

    public MediaNotificationManager getMediaNotificationManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    public MediaRouteSelector getMergedSelector() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return MediaRouteSelector.fromBundle(this.zze.zze());
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "getMergedSelectorAsBundle", zzu.class.getSimpleName());
            return null;
        }
    }

    public PrecacheManager getPrecacheManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    public SessionManager getSessionManager() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzf;
    }

    @Deprecated
    public boolean isAppVisible() throws IllegalStateException {
        return false;
    }

    public boolean onDispatchVolumeKeyEventBeforeJellyBean(KeyEvent keyEvent) {
        CastSession currentCastSession;
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (PlatformVersion.isAtLeastJellyBean() || (currentCastSession = this.zzf.getCurrentCastSession()) == null || !currentCastSession.isConnected()) {
            return false;
        }
        double volumeDeltaBeforeIceCreamSandwich = getCastOptions().getVolumeDeltaBeforeIceCreamSandwich();
        boolean z = keyEvent.getAction() == 0;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 24) {
            zzj(currentCastSession, volumeDeltaBeforeIceCreamSandwich, z);
            return true;
        } else if (keyCode != 25) {
            return false;
        } else {
            zzj(currentCastSession, -volumeDeltaBeforeIceCreamSandwich, z);
            return true;
        }
    }

    @Deprecated
    public void removeAppVisibilityListener(AppVisibilityListener appVisibilityListener) throws IllegalStateException {
    }

    public void removeCastStateListener(CastStateListener castStateListener) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (castStateListener == null) {
            return;
        }
        this.zzf.zzc(castStateListener);
    }

    public void setLaunchCredentialsData(CredentialsData credentialsData) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder(this.zzj.getLaunchOptions());
        builder.setCredentialsData(credentialsData);
        this.zzj.zzb(builder.build());
        zzi();
    }

    public void setReceiverApplicationId(String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (TextUtils.equals(str, this.zzj.getReceiverApplicationId())) {
            return;
        }
        this.zzj.zza(str);
        zzi();
        try {
            this.zze.zzh(str, zzh());
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "setReceiverApplicationId", zzu.class.getSimpleName());
        }
        CastButtonFactory.zza(this.zzd);
    }

    public final boolean zzb() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return this.zze.zzi();
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "hasActivityInRecents", zzu.class.getSimpleName());
            return false;
        }
    }

    public final zzp zzc() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(com.google.android.gms.internal.cast.zzd zzdVar, SharedPreferences sharedPreferences, Bundle bundle) {
        Preconditions.checkNotNull(this.zzf);
        String packageName = this.zzd.getPackageName();
        new com.google.android.gms.internal.cast.zzh(sharedPreferences, zzdVar, bundle, packageName).zza(this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Bundle bundle) {
        this.zzn = new CastReasonCodes(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Bundle bundle) {
        boolean z = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED");
        boolean z2 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED");
        if (!z) {
            if (!z2) {
                return;
            }
            z2 = true;
        }
        String packageName = this.zzd.getPackageName();
        String format = String.format(Locale.ROOT, "%s.%s", this.zzd.getPackageName(), "client_cast_analytics_data");
        TransportRuntime.initialize(this.zzd);
        Transport transport = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("CAST_SENDER_SDK", zzkt.class, zzd.zza);
        long j = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE");
        final SharedPreferences sharedPreferences = this.zzd.getApplicationContext().getSharedPreferences(format, 0);
        final com.google.android.gms.internal.cast.zzd zza2 = com.google.android.gms.internal.cast.zzd.zza(sharedPreferences, transport, j);
        if (z) {
            new com.google.android.gms.cast.internal.zzn(this.zzd).zzc(new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"}).addOnSuccessListener(new OnSuccessListener(this, zza2, sharedPreferences) { // from class: com.google.android.gms.cast.framework.zzc
                private final CastContext zza;
                private final com.google.android.gms.internal.cast.zzd zzb;
                private final SharedPreferences zzc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = zza2;
                    this.zzc = sharedPreferences;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.zza.zzd(this.zzb, this.zzc, (Bundle) obj);
                }
            });
        }
        if (z2) {
            Preconditions.checkNotNull(sharedPreferences);
            Preconditions.checkNotNull(zza2);
            com.google.android.gms.internal.cast.zzl.zza(sharedPreferences, zza2, packageName);
            com.google.android.gms.internal.cast.zzl.zzb(zzjt.CAST_CONTEXT);
        }
    }

    public static CastContext getSharedInstance(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (zzc == null) {
            synchronized (zzb) {
                if (zzc == null) {
                    OptionsProvider zzg = zzg(context.getApplicationContext());
                    CastOptions castOptions = zzg.getCastOptions(context.getApplicationContext());
                    try {
                        zzc = new CastContext(context, castOptions, zzg.getAdditionalSessionProviders(context.getApplicationContext()), new com.google.android.gms.internal.cast.zzag(MediaRouter.getInstance(context), castOptions));
                    } catch (zzar e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return zzc;
    }
}
