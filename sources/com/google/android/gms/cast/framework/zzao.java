package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzao extends com.google.android.gms.internal.cast.zzb implements zzap {
    public zzao() {
        super("com.google.android.gms.cast.framework.ISessionProxy");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper zzb = zzb();
                parcel2.writeNoException();
                com.google.android.gms.internal.cast.zzc.zzf(parcel2, zzb);
                return true;
            case 2:
                zzd((Bundle) com.google.android.gms.internal.cast.zzc.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
                zzf((Bundle) com.google.android.gms.internal.cast.zzc.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                zzg(com.google.android.gms.internal.cast.zzc.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                long zzi = zzi();
                parcel2.writeNoException();
                parcel2.writeLong(zzi);
                return true;
            case 6:
                parcel2.writeNoException();
                parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return true;
            case 7:
                zzc((Bundle) com.google.android.gms.internal.cast.zzc.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zze((Bundle) com.google.android.gms.internal.cast.zzc.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zzh((Bundle) com.google.android.gms.internal.cast.zzc.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
