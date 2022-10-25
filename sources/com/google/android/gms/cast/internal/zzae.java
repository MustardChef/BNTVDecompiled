package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbl;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzae extends com.google.android.gms.internal.cast.zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void zze() throws RemoteException {
        zzd(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzd(4, zza());
    }

    public final void zzg(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(5, zza);
    }

    public final void zzh() throws RemoteException {
        zzd(6, zza());
    }

    public final void zzi(double d, double d2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeDouble(d);
        zza.writeDouble(d2);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z);
        zzd(7, zza);
    }

    public final void zzj(boolean z, double d, boolean z2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzb(zza, z);
        zza.writeDouble(d);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z2);
        zzd(8, zza);
    }

    public final void zzk(String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzd(9, zza);
    }

    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(11, zza);
    }

    public final void zzm(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(12, zza);
    }

    public final void zzn(String str, LaunchOptions launchOptions) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        com.google.android.gms.internal.cast.zzc.zzd(zza, launchOptions);
        zzd(13, zza);
    }

    public final void zzo(String str, String str2, zzbl zzblVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.cast.zzc.zzd(zza, zzblVar);
        zzd(14, zza);
    }

    public final void zzp() throws RemoteException {
        zzd(17, zza());
    }

    public final void zzq(zzag zzagVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzagVar);
        zzd(18, zza);
    }

    public final void zzr() throws RemoteException {
        zzd(19, zza());
    }
}
