package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzaf extends com.google.android.gms.internal.cast.zzb implements zzag {
    public zzaf() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb(parcel.readInt());
                return true;
            case 2:
                zze((ApplicationMetadata) com.google.android.gms.internal.cast.zzc.zzc(parcel, ApplicationMetadata.CREATOR), parcel.readString(), parcel.readString(), com.google.android.gms.internal.cast.zzc.zza(parcel));
                return true;
            case 3:
                zzf(parcel.readInt());
                return true;
            case 4:
                zzj(parcel.readString(), parcel.readDouble(), com.google.android.gms.internal.cast.zzc.zza(parcel));
                return true;
            case 5:
                zzm(parcel.readString(), parcel.readString());
                return true;
            case 6:
                zzn(parcel.readString(), parcel.createByteArray());
                return true;
            case 7:
                zzh(parcel.readInt());
                return true;
            case 8:
                zzg(parcel.readInt());
                return true;
            case 9:
                zzi(parcel.readInt());
                return true;
            case 10:
                zzo(parcel.readString(), parcel.readLong(), parcel.readInt());
                return true;
            case 11:
                zzp(parcel.readString(), parcel.readLong());
                return true;
            case 12:
                zzl((zza) com.google.android.gms.internal.cast.zzc.zzc(parcel, zza.CREATOR));
                return true;
            case 13:
                zzk((zzy) com.google.android.gms.internal.cast.zzc.zzc(parcel, zzy.CREATOR));
                return true;
            case 14:
                zzc(parcel.readInt());
                return true;
            case 15:
                zzd(parcel.readInt());
                return true;
            default:
                return false;
        }
    }
}
