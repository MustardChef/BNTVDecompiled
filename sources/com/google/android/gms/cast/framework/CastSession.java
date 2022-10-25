package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.mediarouter.media.MediaTransferReceiver;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class CastSession extends Session {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = new Logger("CastSession");
    private final Context zzc;
    private final Set<Cast.Listener> zzd;
    private final zzx zze;
    private final CastOptions zzf;
    private final com.google.android.gms.cast.framework.media.internal.zzp zzg;
    private com.google.android.gms.cast.zzq zzh;
    private RemoteMediaClient zzi;
    private CastDevice zzj;
    private Cast.ApplicationConnectionResult zzk;
    private final zzf zzl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CastSession(Context context, String str, String str2, CastOptions castOptions, com.google.android.gms.cast.framework.media.internal.zzp zzpVar) {
        super(context, str, str2);
        zzf zzfVar = zzf.zza;
        this.zzd = new HashSet();
        this.zzc = context.getApplicationContext();
        this.zzf = castOptions;
        this.zzg = zzpVar;
        this.zzl = zzfVar;
        this.zze = com.google.android.gms.internal.cast.zzm.zzc(context, castOptions, zzj(), new zzl(this, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(CastSession castSession, int i) {
        castSession.zzg.zzc(i);
        com.google.android.gms.cast.zzq zzqVar = castSession.zzh;
        if (zzqVar != null) {
            zzqVar.zzc();
            castSession.zzh = null;
        }
        castSession.zzj = null;
        RemoteMediaClient remoteMediaClient = castSession.zzi;
        if (remoteMediaClient != null) {
            remoteMediaClient.zza(null);
            castSession.zzi = null;
        }
        castSession.zzk = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(CastSession castSession, String str, Task task) {
        if (castSession.zze == null) {
            return;
        }
        try {
            if (task.isSuccessful()) {
                Cast.ApplicationConnectionResult applicationConnectionResult = (Cast.ApplicationConnectionResult) task.getResult();
                castSession.zzk = applicationConnectionResult;
                if (applicationConnectionResult.getStatus() == null || !applicationConnectionResult.getStatus().isSuccess()) {
                    if (applicationConnectionResult.getStatus() != null) {
                        zzb.m369d("%s() -> failure result", str);
                        castSession.zze.zzi(applicationConnectionResult.getStatus().getStatusCode());
                        return;
                    }
                } else {
                    zzb.m369d("%s() -> success result", str);
                    RemoteMediaClient remoteMediaClient = new RemoteMediaClient(new com.google.android.gms.cast.internal.zzan(null));
                    castSession.zzi = remoteMediaClient;
                    remoteMediaClient.zza(castSession.zzh);
                    castSession.zzi.zzb();
                    castSession.zzg.zzb(castSession.zzi, castSession.getCastDevice());
                    castSession.zze.zzh((ApplicationMetadata) Preconditions.checkNotNull(applicationConnectionResult.getApplicationMetadata()), applicationConnectionResult.getApplicationStatus(), (String) Preconditions.checkNotNull(applicationConnectionResult.getSessionId()), applicationConnectionResult.getWasLaunched());
                    return;
                }
            } else {
                Exception exception = task.getException();
                if (exception instanceof ApiException) {
                    castSession.zze.zzi(((ApiException) exception).getStatusCode());
                    return;
                }
            }
            castSession.zze.zzi(2476);
        } catch (RemoteException e) {
            zzb.m368d(e, "Unable to call %s on %s.", "methods", zzx.class.getSimpleName());
        }
    }

    private final void zzk(Bundle bundle) {
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        this.zzj = fromBundle;
        if (fromBundle == null) {
            if (isResuming()) {
                notifyFailedToResumeSession(2153);
                return;
            } else {
                notifyFailedToStartSession(2151);
                return;
            }
        }
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            zzqVar.zzc();
            this.zzh = null;
        }
        zzb.m369d("Acquiring a connection to Google Play Services for %s", this.zzj);
        CastDevice castDevice = (CastDevice) Preconditions.checkNotNull(this.zzj);
        Bundle bundle2 = new Bundle();
        CastOptions castOptions = this.zzf;
        CastMediaOptions castMediaOptions = castOptions == null ? null : castOptions.getCastMediaOptions();
        NotificationOptions notificationOptions = castMediaOptions == null ? null : castMediaOptions.getNotificationOptions();
        boolean z = castMediaOptions != null && castMediaOptions.zza();
        Intent intent = new Intent(this.zzc, MediaTransferReceiver.class);
        intent.setPackage(this.zzc.getPackageName());
        boolean z2 = !this.zzc.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", notificationOptions != null);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", z2);
        Cast.CastOptions.Builder builder = new Cast.CastOptions.Builder(castDevice, new zzm(this, null));
        builder.zza(bundle2);
        com.google.android.gms.cast.zzq zza2 = Cast.zza(this.zzc, builder.build());
        zza2.zza(new zzn(this, null));
        this.zzh = zza2;
        zza2.zzb();
    }

    public void addCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.add(listener);
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void end(boolean z) {
        zzx zzxVar = this.zze;
        if (zzxVar != null) {
            try {
                zzxVar.zzj(z, 0);
            } catch (RemoteException e) {
                zzb.m368d(e, "Unable to call %s on %s.", "disconnectFromDevice", zzx.class.getSimpleName());
            }
            notifySessionEnded(0);
        }
    }

    public int getActiveInputState() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            return zzqVar.zzl();
        }
        return -1;
    }

    public Cast.ApplicationConnectionResult getApplicationConnectionResult() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            return zzqVar.zzn();
        }
        return null;
    }

    public String getApplicationStatus() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            return zzqVar.zzo();
        }
        return null;
    }

    @Pure
    public CastDevice getCastDevice() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    @Override // com.google.android.gms.cast.framework.Session
    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        RemoteMediaClient remoteMediaClient = this.zzi;
        if (remoteMediaClient == null) {
            return 0L;
        }
        return remoteMediaClient.getStreamDuration() - this.zzi.getApproximateStreamPosition();
    }

    public int getStandbyState() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            return zzqVar.zzm();
        }
        return -1;
    }

    public double getVolume() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            return zzqVar.zzi();
        }
        return 0.0d;
    }

    public boolean isMute() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        return zzqVar != null && zzqVar.zzk();
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void onResuming(Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void onStarting(Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }

    public void removeCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.remove(listener);
        }
    }

    public void removeMessageReceivedCallbacks(String str) throws IOException, IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            zzqVar.zzq(str);
        }
    }

    public void requestStatus() throws IOException, IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            zzqVar.zzd();
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void resume(Bundle bundle) {
        zzk(bundle);
    }

    public PendingResult<Status> sendMessage(String str, String str2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar == null) {
            return PendingResults.immediatePendingResult(new Status(17));
        }
        return com.google.android.gms.internal.cast.zzal.zza(zzqVar.zze(str, str2), zzg.zza, zzh.zza);
    }

    public void setMessageReceivedCallbacks(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            zzqVar.zzp(str, messageReceivedCallback);
        }
    }

    public void setMute(boolean z) throws IOException, IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            zzqVar.zzj(z);
        }
    }

    public void setVolume(double d) throws IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzh;
        if (zzqVar != null) {
            zzqVar.zzh(d);
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void start(Bundle bundle) {
        zzk(bundle);
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected final void zza(Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }

    public final com.google.android.gms.cast.framework.media.internal.zzp zzb() {
        return this.zzg;
    }
}
