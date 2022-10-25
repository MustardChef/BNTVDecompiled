package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class zzel extends com.google.android.gms.internal.measurement.zzc implements zzei {
    public zzel() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzaq) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzaq.CREATOR), (zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzku) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzku.CREATOR), (zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zza((zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzaq) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzaq.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzku> zza = zza((zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR), com.google.android.gms.internal.measurement.zzb.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                byte[] zza2 = zza((zzaq) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzaq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String zzc = zzc((zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 12:
                zza((zzz) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzz.CREATOR), (zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zza((zzz) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzku> zza3 = zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.zza(parcel), (zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                List<zzku> zza4 = zza(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                List<zzz> zza5 = zza(parcel.readString(), parcel.readString(), (zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                List<zzz> zza6 = zza(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zza6);
                return true;
            case 18:
                zzd((zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                zza((Bundle) com.google.android.gms.internal.measurement.zzb.zza(parcel, Bundle.CREATOR), (zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                zze((zzn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
