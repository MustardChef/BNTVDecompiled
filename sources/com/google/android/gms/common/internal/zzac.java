package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public final class zzac extends com.google.android.gms.internal.common.zza implements zzae {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzae
    public final boolean zze(com.google.android.gms.common.zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzd(zza, zzsVar);
        com.google.android.gms.internal.common.zzc.zzf(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zza2 = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.common.internal.zzae
    public final com.google.android.gms.common.zzq zzf(com.google.android.gms.common.zzn zznVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzd(zza, zznVar);
        Parcel zzB = zzB(6, zza);
        com.google.android.gms.common.zzq zzqVar = (com.google.android.gms.common.zzq) com.google.android.gms.internal.common.zzc.zzc(zzB, com.google.android.gms.common.zzq.CREATOR);
        zzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzae
    public final boolean zzg() throws RemoteException {
        Parcel zzB = zzB(7, zza());
        boolean zza = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza;
    }
}
