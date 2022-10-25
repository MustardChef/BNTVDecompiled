package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzs extends com.google.android.gms.internal.cast.zza implements zzu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastContext");
    }

    @Override // com.google.android.gms.cast.framework.zzu
    public final Bundle zze() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        Bundle bundle = (Bundle) com.google.android.gms.internal.cast.zzc.zzc(zzb, Bundle.CREATOR);
        zzb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.cast.framework.zzu
    public final zzaj zzf() throws RemoteException {
        zzaj zzaiVar;
        Parcel zzb = zzb(5, zza());
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzaiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
            if (queryLocalInterface instanceof zzaj) {
                zzaiVar = (zzaj) queryLocalInterface;
            } else {
                zzaiVar = new zzai(readStrongBinder);
            }
        }
        zzb.recycle();
        return zzaiVar;
    }

    @Override // com.google.android.gms.cast.framework.zzu
    public final zzab zzg() throws RemoteException {
        zzab zzaaVar;
        Parcel zzb = zzb(6, zza());
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzaaVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
            if (queryLocalInterface instanceof zzab) {
                zzaaVar = (zzab) queryLocalInterface;
            } else {
                zzaaVar = new zzaa(readStrongBinder);
            }
        }
        zzb.recycle();
        return zzaaVar;
    }

    @Override // com.google.android.gms.cast.framework.zzu
    public final void zzh(String str, Map map) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeMap(map);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.cast.framework.zzu
    public final boolean zzi() throws RemoteException {
        Parcel zzb = zzb(12, zza());
        boolean zza = com.google.android.gms.internal.cast.zzc.zza(zzb);
        zzb.recycle();
        return zza;
    }
}
