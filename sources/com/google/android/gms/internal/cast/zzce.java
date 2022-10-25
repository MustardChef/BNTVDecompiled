package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzce extends zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzce(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
    }

    public final void zze() throws RemoteException {
        zzd(3, zza());
    }

    public final void zzf(zzcd zzcdVar, zzcg zzcgVar, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcdVar);
        zzc.zzf(zza, zzcgVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzd(7, zza);
    }

    public final void zzg(zzcd zzcdVar, PendingIntent pendingIntent, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcdVar);
        zzc.zzd(zza, pendingIntent);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzd(8, zza);
    }

    public final void zzh(zzcd zzcdVar, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcdVar);
        zza.writeInt(i);
        zzd(5, zza);
    }

    public final void zzi(zzcd zzcdVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcdVar);
        zzd(6, zza);
    }
}
