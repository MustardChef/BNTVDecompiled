package com.google.android.gms.internal.safetynet;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* loaded from: classes3.dex */
public abstract class zzh extends zzb implements zzg {
    public zzh() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    @Override // com.google.android.gms.internal.safetynet.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), (com.google.android.gms.safetynet.zza) zzc.zza(parcel, com.google.android.gms.safetynet.zza.CREATOR));
        } else if (i == 2) {
            zza(parcel.readString());
        } else if (i == 3) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), (SafeBrowsingData) zzc.zza(parcel, SafeBrowsingData.CREATOR));
        } else if (i == 4) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), zzc.zza(parcel));
        } else if (i == 6) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), (com.google.android.gms.safetynet.zzf) zzc.zza(parcel, com.google.android.gms.safetynet.zzf.CREATOR));
        } else if (i == 8) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), (com.google.android.gms.safetynet.zzd) zzc.zza(parcel, com.google.android.gms.safetynet.zzd.CREATOR));
        } else if (i == 15) {
            zza((Status) zzc.zza(parcel, Status.CREATOR), (com.google.android.gms.safetynet.zzh) zzc.zza(parcel, com.google.android.gms.safetynet.zzh.CREATOR));
        } else if (i == 10) {
            zzb((Status) zzc.zza(parcel, Status.CREATOR), zzc.zza(parcel));
        } else if (i != 11) {
            return false;
        } else {
            zza((Status) zzc.zza(parcel, Status.CREATOR));
        }
        return true;
    }
}
