package com.google.android.gms.internal.p037authapiphone;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzi */
/* loaded from: classes.dex */
public final class zzi extends zzb implements zzj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    @Override // com.google.android.gms.internal.p037authapiphone.zzj
    public final void zza(zzl zzlVar) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzlVar);
        zza(1, zza);
    }

    @Override // com.google.android.gms.internal.p037authapiphone.zzj
    public final void zza(String str, zzl zzlVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzlVar);
        zza(2, zza);
    }

    @Override // com.google.android.gms.internal.p037authapiphone.zzj
    public final void zza(IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iStatusCallback);
        zza(3, zza);
    }

    @Override // com.google.android.gms.internal.p037authapiphone.zzj
    public final void zza(zzf zzfVar) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzfVar);
        zza(4, zza);
    }

    @Override // com.google.android.gms.internal.p037authapiphone.zzj
    public final void zza(String str, zzh zzhVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzhVar);
        zza(5, zza);
    }
}
