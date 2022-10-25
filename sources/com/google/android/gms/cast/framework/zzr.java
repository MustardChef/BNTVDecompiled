package com.google.android.gms.cast.framework;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public interface zzr extends IInterface {
    void zzb(String str, String str2) throws RemoteException;

    void zzc(String str, LaunchOptions launchOptions) throws RemoteException;

    void zzd(String str) throws RemoteException;

    void zze(int i) throws RemoteException;
}
