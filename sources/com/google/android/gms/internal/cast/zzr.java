package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzr extends zzb implements zzs {
    public zzr() {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzu zztVar;
        switch (i) {
            case 1:
                Bundle bundle = (Bundle) zzc.zzc(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zztVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                    if (queryLocalInterface instanceof zzu) {
                        zztVar = (zzu) queryLocalInterface;
                    } else {
                        zztVar = new zzt(readStrongBinder);
                    }
                }
                zzb(bundle, zztVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzc((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 3:
                zzd((Bundle) zzc.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zze = zze((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                zzc.zzb(parcel2, zze);
                return true;
            case 5:
                zzf(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzg();
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zzh = zzh();
                parcel2.writeNoException();
                zzc.zzb(parcel2, zzh);
                return true;
            case 8:
                Bundle zzi = zzi(parcel.readString());
                parcel2.writeNoException();
                zzc.zze(parcel2, zzi);
                return true;
            case 9:
                String zzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(zzj);
                return true;
            case 10:
                parcel2.writeNoException();
                parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return true;
            case 11:
                zzk();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
