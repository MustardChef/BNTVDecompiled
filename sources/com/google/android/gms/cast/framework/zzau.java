package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzau<T extends Session> extends zzak {
    @NotOnlyInitialized
    private final SessionManagerListener<T> zza;
    private final Class<T> zzb;

    public zzau(SessionManagerListener<T> sessionManagerListener, Class<T> cls) {
        this.zza = sessionManagerListener;
        this.zzb = cls;
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionStarting(this.zzb.cast(session));
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzd(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionStarted(this.zzb.cast(session), str);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionStartFailed(this.zzb.cast(session), i);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionEnding(this.zzb.cast(session));
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionEnded(this.zzb.cast(session), i);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzh(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionResuming(this.zzb.cast(session), str);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzi(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionResumed(this.zzb.cast(session), z);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzj(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionResumeFailed(this.zzb.cast(session), i);
    }

    @Override // com.google.android.gms.cast.framework.zzal
    public final void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionSuspended(this.zzb.cast(session), i);
    }
}
