package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzaf extends com.google.android.gms.internal.cast.zza implements zzah {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISession");
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final IObjectWrapper zze() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final String zzf() throws RemoteException {
        Parcel zzb = zzb(2, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final String zzg() throws RemoteException {
        Parcel zzb = zzb(3, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final boolean zzh() throws RemoteException {
        Parcel zzb = zzb(5, zza());
        boolean zza = com.google.android.gms.internal.cast.zzc.zza(zzb);
        zzb.recycle();
        return zza;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final boolean zzi() throws RemoteException {
        Parcel zzb = zzb(6, zza());
        boolean zza = com.google.android.gms.internal.cast.zzc.zza(zzb);
        zzb.recycle();
        return zza;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final boolean zzj() throws RemoteException {
        Parcel zzb = zzb(7, zza());
        boolean zza = com.google.android.gms.internal.cast.zzc.zza(zzb);
        zzb.recycle();
        return zza;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final boolean zzk() throws RemoteException {
        Parcel zzb = zzb(8, zza());
        boolean zza = com.google.android.gms.internal.cast.zzc.zza(zzb);
        zzb.recycle();
        return zza;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final boolean zzl() throws RemoteException {
        Parcel zzb = zzb(9, zza());
        boolean zza = com.google.android.gms.internal.cast.zzc.zza(zzb);
        zzb.recycle();
        return zza;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final boolean zzm() throws RemoteException {
        Parcel zzb = zzb(10, zza());
        boolean zza = com.google.android.gms.internal.cast.zzc.zza(zzb);
        zzb.recycle();
        return zza;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzo(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzp(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(13, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzq(boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzb(zza, z);
        zzc(14, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzr(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(15, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzs(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(16, zza);
    }
}
