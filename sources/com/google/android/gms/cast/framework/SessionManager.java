package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.Toast;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class SessionManager {
    private static final Logger zza = new Logger("SessionManager");
    private final zzaj zzb;
    private final Context zzc;

    public SessionManager(zzaj zzajVar, Context context) {
        this.zzb = zzajVar;
        this.zzc = context;
    }

    public void addSessionManagerListener(SessionManagerListener<Session> sessionManagerListener) throws NullPointerException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        addSessionManagerListener(sessionManagerListener, Session.class);
    }

    public void endCurrentSession(boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            zza.m365i("End session for %s", this.zzc.getPackageName());
            this.zzb.zzj(true, z);
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "endCurrentSession", zzaj.class.getSimpleName());
        }
    }

    public CastSession getCurrentCastSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Session currentSession = getCurrentSession();
        if (currentSession == null || !(currentSession instanceof CastSession)) {
            return null;
        }
        return (CastSession) currentSession;
    }

    public Session getCurrentSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return (Session) ObjectWrapper.unwrap(this.zzb.zze());
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "getWrappedCurrentSession", zzaj.class.getSimpleName());
            return null;
        }
    }

    public void removeSessionManagerListener(SessionManagerListener<Session> sessionManagerListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        removeSessionManagerListener(sessionManagerListener, Session.class);
    }

    public void startSession(Intent intent) {
        try {
            zza.m365i("Start session for %s", this.zzc.getPackageName());
            Bundle extras = intent.getExtras();
            if (extras != null && extras.getString("CAST_INTENT_TO_CAST_ROUTE_ID_KEY") != null) {
                String string = extras.getString("CAST_INTENT_TO_CAST_DEVICE_NAME_KEY");
                if (!extras.getBoolean("CAST_INTENT_TO_CAST_NO_TOAST_KEY")) {
                    Toast.makeText(this.zzc, this.zzc.getString(C3616R.string.cast_connecting_to_device, string), 0).show();
                }
                this.zzb.zzm(new Bundle(extras));
                intent.removeExtra("CAST_INTENT_TO_CAST_ROUTE_ID_KEY");
            }
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "startSession", zzaj.class.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        try {
            return this.zzb.zzl();
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "addCastStateListener", zzaj.class.getSimpleName());
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(CastStateListener castStateListener) throws NullPointerException {
        Preconditions.checkNotNull(castStateListener);
        try {
            this.zzb.zzh(new zzo(castStateListener));
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "addCastStateListener", zzaj.class.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(CastStateListener castStateListener) {
        try {
            this.zzb.zzi(new zzo(castStateListener));
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "removeCastStateListener", zzaj.class.getSimpleName());
        }
    }

    public final IObjectWrapper zzd() {
        try {
            return this.zzb.zzk();
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "getWrappedThis", zzaj.class.getSimpleName());
            return null;
        }
    }

    public <T extends Session> void addSessionManagerListener(SessionManagerListener<T> sessionManagerListener, Class<T> cls) throws NullPointerException {
        Objects.requireNonNull(sessionManagerListener, "SessionManagerListener can't be null");
        Preconditions.checkNotNull(cls);
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            this.zzb.zzf(new zzau(sessionManagerListener, cls));
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "addSessionManagerListener", zzaj.class.getSimpleName());
        }
    }

    public <T extends Session> void removeSessionManagerListener(SessionManagerListener<T> sessionManagerListener, Class cls) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sessionManagerListener == null) {
            return;
        }
        try {
            this.zzb.zzg(new zzau(sessionManagerListener, cls));
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "removeSessionManagerListener", zzaj.class.getSimpleName());
        }
    }
}
