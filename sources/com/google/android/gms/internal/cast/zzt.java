package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzt extends zza implements zzu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
    }

    @Override // com.google.android.gms.internal.cast.zzu
    public final void zze(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzd(zza, bundle);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.internal.cast.zzu
    public final void zzf(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzd(zza, bundle);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.internal.cast.zzu
    public final void zzg(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzd(zza, bundle);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.internal.cast.zzu
    public final void zzh(String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzd(zza, bundle);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.internal.cast.zzu
    public final void zzi(String str, Bundle bundle, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzd(zza, bundle);
        zza.writeInt(i);
        zzc(6, zza);
    }
}
