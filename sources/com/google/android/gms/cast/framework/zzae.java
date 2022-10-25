package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public interface zzae extends IInterface {
    void zze() throws RemoteException;

    int zzf(Intent intent, int i, int i2) throws RemoteException;

    IBinder zzg(Intent intent) throws RemoteException;

    void zzh() throws RemoteException;
}
