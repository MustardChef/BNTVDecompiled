package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzac extends com.google.android.gms.internal.cast.zza implements zzae {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.IReconnectionService");
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final void zze() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final int zzf(Intent intent, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzd(zza, intent);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zzb = zzb(2, zza);
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final IBinder zzg(Intent intent) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzd(zza, intent);
        Parcel zzb = zzb(3, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        zzb.recycle();
        return readStrongBinder;
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final void zzh() throws RemoteException {
        zzc(4, zza());
    }
}
