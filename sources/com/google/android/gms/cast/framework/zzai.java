package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzai extends com.google.android.gms.internal.cast.zza implements zzaj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISessionManager");
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final IObjectWrapper zze() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final void zzf(zzal zzalVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzalVar);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final void zzg(zzal zzalVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzalVar);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final void zzh(zzz zzzVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzzVar);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final void zzi(zzz zzzVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzf(zza, zzzVar);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final void zzj(boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzb(zza, true);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z2);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final IObjectWrapper zzk() throws RemoteException {
        Parcel zzb = zzb(7, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final int zzl() throws RemoteException {
        Parcel zzb = zzb(8, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.cast.framework.zzaj
    public final void zzm(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzd(zza, bundle);
        zzc(9, zza);
    }
}
