package com.google.android.gms.cast.framework.media;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public interface zzg extends IInterface {
    IObjectWrapper zze() throws RemoteException;

    List<NotificationAction> zzf() throws RemoteException;

    int[] zzg() throws RemoteException;
}
