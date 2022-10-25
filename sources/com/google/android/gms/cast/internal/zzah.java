package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzah extends com.google.android.gms.internal.cast.zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastService");
    }

    public final void zze(IStatusCallback iStatusCallback, String[] strArr, String str, List list) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, iStatusCallback);
        zza.writeStringArray(strArr);
        zza.writeString(str);
        zza.writeTypedList(null);
        zzd(2, zza);
    }

    public final void zzf(zzad zzadVar, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzadVar);
        zza.writeStringArray(strArr);
        zzd(5, zza);
    }

    public final void zzg(zzad zzadVar, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzadVar);
        zza.writeStringArray(strArr);
        zzd(6, zza);
    }

    public final void zzh(zzad zzadVar, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzadVar);
        zza.writeStringArray(strArr);
        zzd(7, zza);
    }
}
