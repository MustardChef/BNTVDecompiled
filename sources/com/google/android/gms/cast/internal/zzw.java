package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzw extends GmsClient<zzae> {
    private BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> zzA;
    private BaseImplementation.ResultHolder<Status> zzB;
    private ApplicationMetadata zzf;
    private final CastDevice zzg;
    private final Cast.Listener zzh;
    private final Map<String, Cast.MessageReceivedCallback> zzi;
    private final long zzj;
    private final Bundle zzk;
    private zzv zzl;
    private String zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private double zzr;
    private com.google.android.gms.cast.zzam zzs;
    private int zzt;
    private int zzu;
    private final AtomicLong zzv;
    private String zzw;
    private String zzx;
    private Bundle zzy;
    private final Map<Long, BaseImplementation.ResultHolder<Status>> zzz;
    private static final Logger zze = new Logger("CastClientImpl");
    private static final Object zzC = new Object();
    private static final Object zzD = new Object();

    public zzw(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, long j, Cast.Listener listener, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzg = castDevice;
        this.zzh = listener;
        this.zzj = j;
        this.zzk = bundle;
        this.zzi = new HashMap();
        this.zzv = new AtomicLong(0L);
        this.zzz = new HashMap();
        zzY();
        zzG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzT(zzw zzwVar, zzy zzyVar) {
        boolean z;
        boolean z2;
        boolean z3;
        ApplicationMetadata zze2 = zzyVar.zze();
        if (!CastUtils.zza(zze2, zzwVar.zzf)) {
            zzwVar.zzf = zze2;
            zzwVar.zzh.onApplicationMetadataChanged(zze2);
        }
        double zza = zzyVar.zza();
        if (Double.isNaN(zza) || Math.abs(zza - zzwVar.zzr) <= 1.0E-7d) {
            z = false;
        } else {
            zzwVar.zzr = zza;
            z = true;
        }
        boolean zzb = zzyVar.zzb();
        if (zzb != zzwVar.zzn) {
            zzwVar.zzn = zzb;
            z = true;
        }
        Double.isNaN(zzyVar.zzg());
        Logger logger = zze;
        logger.m369d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(zzwVar.zzp));
        Cast.Listener listener = zzwVar.zzh;
        if (listener != null && (z || zzwVar.zzp)) {
            listener.onVolumeChanged();
        }
        int zzc = zzyVar.zzc();
        if (zzc != zzwVar.zzt) {
            zzwVar.zzt = zzc;
            z2 = true;
        } else {
            z2 = false;
        }
        logger.m369d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(zzwVar.zzp));
        Cast.Listener listener2 = zzwVar.zzh;
        if (listener2 != null && (z2 || zzwVar.zzp)) {
            listener2.onActiveInputStateChanged(zzwVar.zzt);
        }
        int zzd = zzyVar.zzd();
        if (zzd != zzwVar.zzu) {
            zzwVar.zzu = zzd;
            z3 = true;
        } else {
            z3 = false;
        }
        logger.m369d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(zzwVar.zzp));
        Cast.Listener listener3 = zzwVar.zzh;
        if (listener3 != null && (z3 || zzwVar.zzp)) {
            listener3.onStandbyStateChanged(zzwVar.zzu);
        }
        if (!CastUtils.zza(zzwVar.zzs, zzyVar.zzf())) {
            zzwVar.zzs = zzyVar.zzf();
        }
        zzwVar.zzp = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzU(zzw zzwVar, zza zzaVar) {
        boolean z;
        String zza = zzaVar.zza();
        if (CastUtils.zza(zza, zzwVar.zzm)) {
            z = false;
        } else {
            zzwVar.zzm = zza;
            z = true;
        }
        zze.m369d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(zzwVar.zzo));
        Cast.Listener listener = zzwVar.zzh;
        if (listener != null && (z || zzwVar.zzo)) {
            listener.onApplicationStatusChanged();
        }
        zzwVar.zzo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzY() {
        this.zzq = false;
        this.zzt = -1;
        this.zzu = -1;
        this.zzf = null;
        this.zzm = null;
        this.zzr = 0.0d;
        zzG();
        this.zzn = false;
        this.zzs = null;
    }

    private final void zzZ(BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder) {
        synchronized (zzC) {
            BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder2 = this.zzA;
            if (resultHolder2 != null) {
                resultHolder2.setResult(new zzq(new Status(2002), null, null, null, false));
            }
            this.zzA = resultHolder;
        }
    }

    private final void zzaa(BaseImplementation.ResultHolder<Status> resultHolder) {
        synchronized (zzD) {
            if (this.zzB != null) {
                resultHolder.setResult(new Status(2001));
            } else {
                this.zzB = resultHolder;
            }
        }
    }

    private final void zzab() {
        zze.m369d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzi) {
            this.zzi.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac(long j, int i) {
        BaseImplementation.ResultHolder<Status> remove;
        synchronized (this.zzz) {
            remove = this.zzz.remove(Long.valueOf(j));
        }
        if (remove != null) {
            remove.setResult(new Status(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzad(int i) {
        synchronized (zzD) {
            BaseImplementation.ResultHolder<Status> resultHolder = this.zzB;
            if (resultHolder != null) {
                resultHolder.setResult(new Status(i));
                this.zzB = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        if (queryLocalInterface instanceof zzae) {
            return (zzae) queryLocalInterface;
        }
        return new zzae(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        Logger logger = zze;
        logger.m369d("disconnect(); ServiceListener=%s, isConnected=%b", this.zzl, Boolean.valueOf(isConnected()));
        zzv zzvVar = this.zzl;
        this.zzl = null;
        if (zzvVar == null || zzvVar.zzq() == null) {
            logger.m369d("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzab();
        try {
            try {
                ((zzae) getService()).zze();
            } catch (RemoteException | IllegalStateException e) {
                zze.m368d(e, "Error while disconnecting the controller interface", new Object[0]);
            }
        } finally {
            super.disconnect();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        Bundle bundle = this.zzy;
        if (bundle != null) {
            this.zzy = null;
            return bundle;
        }
        return super.getConnectionHint();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        zze.m369d("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzw, this.zzx);
        this.zzg.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzj);
        Bundle bundle2 = this.zzk;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        zzv zzvVar = new zzv(this);
        this.zzl = zzvVar;
        bundle.putParcelable(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new BinderWrapper(zzvVar));
        String str = this.zzw;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.zzx;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        zzab();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        zze.m369d("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 2300) {
            this.zzq = true;
            this.zzo = true;
            this.zzp = true;
        } else {
            this.zzq = false;
        }
        if (i == 2300) {
            Bundle bundle2 = new Bundle();
            this.zzy = bundle2;
            bundle2.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    public final int zzA() throws IllegalStateException {
        checkConnected();
        return this.zzu;
    }

    public final void zzB(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        CastUtils.throwIfInvalidNamespace(str);
        zzC(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzi) {
                this.zzi.put(str, messageReceivedCallback);
            }
            zzae zzaeVar = (zzae) getService();
            if (zzF()) {
                zzaeVar.zzl(str);
            }
        }
    }

    public final void zzC(String str) throws IllegalArgumentException, RemoteException {
        Cast.MessageReceivedCallback remove;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.zzi) {
                remove = this.zzi.remove(str);
            }
            if (remove != null) {
                try {
                    ((zzae) getService()).zzm(str);
                    return;
                } catch (IllegalStateException e) {
                    zze.m368d(e, "Error unregistering namespace (%s)", str);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }

    public final ApplicationMetadata zzD() throws IllegalStateException {
        checkConnected();
        return this.zzf;
    }

    public final String zzE() throws IllegalStateException {
        checkConnected();
        return this.zzm;
    }

    final boolean zzF() {
        zzv zzvVar;
        return (!this.zzq || (zzvVar = this.zzl) == null || zzvVar.zzr()) ? false : true;
    }

    final double zzG() {
        Preconditions.checkNotNull(this.zzg, "device should not be null");
        if (this.zzg.hasCapability(2048)) {
            return 0.02d;
        }
        return (!this.zzg.hasCapability(4) || this.zzg.hasCapability(1) || "Chromecast Audio".equals(this.zzg.getModelName())) ? 0.05d : 0.02d;
    }

    public final void zzH(int i) {
        synchronized (zzC) {
            BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder = this.zzA;
            if (resultHolder != null) {
                resultHolder.setResult(new zzq(new Status(i), null, null, null, false));
                this.zzA = null;
            }
        }
    }

    public final void zzp(String str, String str2, BaseImplementation.ResultHolder<Status> resultHolder) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 524288) {
            zze.m362w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        CastUtils.throwIfInvalidNamespace(str);
        long incrementAndGet = this.zzv.incrementAndGet();
        try {
            this.zzz.put(Long.valueOf(incrementAndGet), resultHolder);
            zzae zzaeVar = (zzae) getService();
            if (zzF()) {
                zzaeVar.zzk(str, str2, incrementAndGet);
            } else {
                zzac(incrementAndGet, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
            }
        } catch (Throwable th) {
            this.zzz.remove(Long.valueOf(incrementAndGet));
            throw th;
        }
    }

    public final void zzq(String str, LaunchOptions launchOptions, BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder) throws IllegalStateException, RemoteException {
        zzZ(resultHolder);
        zzae zzaeVar = (zzae) getService();
        if (zzF()) {
            zzaeVar.zzn(str, launchOptions);
        } else {
            zzH(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    public final void zzr(String str, String str2, zzbl zzblVar, BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder) throws IllegalStateException, RemoteException {
        zzZ(resultHolder);
        zzbl zzblVar2 = new zzbl();
        zzae zzaeVar = (zzae) getService();
        if (zzF()) {
            zzaeVar.zzo(str, str2, zzblVar2);
        } else {
            zzH(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    public final void zzs(BaseImplementation.ResultHolder<Status> resultHolder) throws IllegalStateException, RemoteException {
        zzaa(resultHolder);
        zzae zzaeVar = (zzae) getService();
        if (zzF()) {
            zzaeVar.zzf();
        } else {
            zzad(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    public final void zzt(String str, BaseImplementation.ResultHolder<Status> resultHolder) throws IllegalStateException, RemoteException {
        zzaa(resultHolder);
        zzae zzaeVar = (zzae) getService();
        if (zzF()) {
            zzaeVar.zzg(str);
        } else {
            zzad(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    public final void zzu() throws IllegalStateException, RemoteException {
        zzae zzaeVar = (zzae) getService();
        if (zzF()) {
            zzaeVar.zzh();
        }
    }

    public final void zzv(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d);
            throw new IllegalArgumentException(sb.toString());
        }
        zzae zzaeVar = (zzae) getService();
        if (zzF()) {
            zzaeVar.zzi(d, this.zzr, this.zzn);
        }
    }

    public final void zzw(boolean z) throws IllegalStateException, RemoteException {
        zzae zzaeVar = (zzae) getService();
        if (zzF()) {
            zzaeVar.zzj(z, this.zzr, this.zzn);
        }
    }

    public final double zzx() throws IllegalStateException {
        checkConnected();
        return this.zzr;
    }

    public final boolean zzy() throws IllegalStateException {
        checkConnected();
        return this.zzn;
    }

    public final int zzz() throws IllegalStateException {
        checkConnected();
        return this.zzt;
    }
}
