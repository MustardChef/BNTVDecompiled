package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes.dex */
public interface IFragmentWrapper extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    /* loaded from: classes.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (queryLocalInterface instanceof IFragmentWrapper) {
                return (IFragmentWrapper) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    IObjectWrapper zzb = zzb();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, zzb);
                    return true;
                case 3:
                    Bundle zzc = zzc();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, zzc);
                    return true;
                case 4:
                    int zzd = zzd();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzd);
                    return true;
                case 5:
                    IFragmentWrapper zze = zze();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, zze);
                    return true;
                case 6:
                    IObjectWrapper zzf = zzf();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, zzf);
                    return true;
                case 7:
                    boolean zzg = zzg();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzg);
                    return true;
                case 8:
                    String zzh = zzh();
                    parcel2.writeNoException();
                    parcel2.writeString(zzh);
                    return true;
                case 9:
                    IFragmentWrapper zzi = zzi();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, zzi);
                    return true;
                case 10:
                    int zzj = zzj();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzj);
                    return true;
                case 11:
                    boolean zzk = zzk();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzk);
                    return true;
                case 12:
                    IObjectWrapper zzl = zzl();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, zzl);
                    return true;
                case 13:
                    boolean zzm = zzm();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzm);
                    return true;
                case 14:
                    boolean zzn = zzn();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzn);
                    return true;
                case 15:
                    boolean zzo = zzo();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzo);
                    return true;
                case 16:
                    boolean zzp = zzp();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzp);
                    return true;
                case 17:
                    boolean zzq = zzq();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzq);
                    return true;
                case 18:
                    boolean zzr = zzr();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzr);
                    return true;
                case 19:
                    boolean zzs = zzs();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, zzs);
                    return true;
                case 20:
                    zzt(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    zzu(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    zzv(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    zzw(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    zzx(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    zzy((Intent) zzc.zzc(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    zzz((Intent) zzc.zzc(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zzA(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    void zzA(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzb() throws RemoteException;

    Bundle zzc() throws RemoteException;

    int zzd() throws RemoteException;

    IFragmentWrapper zze() throws RemoteException;

    IObjectWrapper zzf() throws RemoteException;

    boolean zzg() throws RemoteException;

    String zzh() throws RemoteException;

    IFragmentWrapper zzi() throws RemoteException;

    int zzj() throws RemoteException;

    boolean zzk() throws RemoteException;

    IObjectWrapper zzl() throws RemoteException;

    boolean zzm() throws RemoteException;

    boolean zzn() throws RemoteException;

    boolean zzo() throws RemoteException;

    boolean zzp() throws RemoteException;

    boolean zzq() throws RemoteException;

    boolean zzr() throws RemoteException;

    boolean zzs() throws RemoteException;

    void zzt(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzu(boolean z) throws RemoteException;

    void zzv(boolean z) throws RemoteException;

    void zzw(boolean z) throws RemoteException;

    void zzx(boolean z) throws RemoteException;

    void zzy(Intent intent) throws RemoteException;

    void zzz(Intent intent, int i) throws RemoteException;
}
