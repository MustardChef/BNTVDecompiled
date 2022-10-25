package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztm */
/* loaded from: classes3.dex */
public abstract class zztm extends zzb implements zztn {
    public zztm() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzd((zzwg) zzc.zza(parcel, zzwg.CREATOR));
                return true;
            case 2:
                zze((zzwg) zzc.zza(parcel, zzwg.CREATOR), (zzvz) zzc.zza(parcel, zzvz.CREATOR));
                return true;
            case 3:
                zzf((zzvl) zzc.zza(parcel, zzvl.CREATOR));
                return true;
            case 4:
                zzg((zzwr) zzc.zza(parcel, zzwr.CREATOR));
                return true;
            case 5:
                zzh((Status) zzc.zza(parcel, Status.CREATOR));
                return true;
            case 6:
                zzi();
                return true;
            case 7:
                zzj();
                return true;
            case 8:
                zzk(parcel.readString());
                return true;
            case 9:
                zzl(parcel.readString());
                return true;
            case 10:
                zzm((PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 11:
                zzn(parcel.readString());
                return true;
            case 12:
                zzo((Status) zzc.zza(parcel, Status.CREATOR), (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 13:
                zzp();
                return true;
            case 14:
                zzq((zzno) zzc.zza(parcel, zzno.CREATOR));
                return true;
            case 15:
                zzr((zznq) zzc.zza(parcel, zznq.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
