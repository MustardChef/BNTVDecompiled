package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class Session {
    private static final Logger zza = new Logger(RtspHeaders.SESSION);
    private final zzah zzb;
    private final zzat zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public Session(Context context, String str, String str2) {
        zzat zzatVar = new zzat(this, null);
        this.zzc = zzatVar;
        this.zzb = com.google.android.gms.internal.cast.zzm.zzb(context, str, str2, zzatVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void end(boolean z);

    public final String getCategory() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzf();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "getCategory", zzah.class.getSimpleName());
            }
        }
        return null;
    }

    public final String getSessionId() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzg();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "getSessionId", zzah.class.getSimpleName());
            }
        }
        return null;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return 0L;
    }

    public boolean isConnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzh();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "isConnected", zzah.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isConnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzi();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "isConnecting", zzah.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isDisconnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzk();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "isDisconnected", zzah.class.getSimpleName());
            }
        }
        return true;
    }

    public boolean isDisconnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzj();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "isDisconnecting", zzah.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isResuming() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzl();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "isResuming", zzah.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isSuspended() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zzm();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "isSuspended", zzah.class.getSimpleName());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyFailedToResumeSession(int i) {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                zzahVar.zzr(i);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "notifyFailedToResumeSession", zzah.class.getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyFailedToStartSession(int i) {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                zzahVar.zzo(i);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "notifyFailedToStartSession", zzah.class.getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifySessionEnded(int i) {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                zzahVar.zzp(i);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "notifySessionEnded", zzah.class.getSimpleName());
            }
        }
    }

    protected final void notifySessionResumed(boolean z) {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                zzahVar.zzq(z);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "notifySessionResumed", zzah.class.getSimpleName());
            }
        }
    }

    protected final void notifySessionStarted(String str) {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                zzahVar.zzn(str);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "notifySessionStarted", zzah.class.getSimpleName());
            }
        }
    }

    protected final void notifySessionSuspended(int i) {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                zzahVar.zzs(i);
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "notifySessionSuspended", zzah.class.getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResuming(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStarting(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void resume(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void start(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(Bundle bundle) {
    }

    public final IObjectWrapper zzj() {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            try {
                return zzahVar.zze();
            } catch (RemoteException e) {
                zza.m368d(e, "Unable to call %s on %s.", "getWrappedObject", zzah.class.getSimpleName());
            }
        }
        return null;
    }
}
