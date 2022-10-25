package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzv extends com.google.android.gms.internal.cast.zza implements zzx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastSession");
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zze(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzd(zza, null);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzf(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzg(ConnectionResult connectionResult) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzd(zza, connectionResult);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzh(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzd(zza, applicationMetadata);
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.cast.zzc.zzb(zza, z);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzi(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzj(boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.cast.zzc.zzb(zza, z);
        zza.writeInt(0);
        zzc(6, zza);
    }
}
