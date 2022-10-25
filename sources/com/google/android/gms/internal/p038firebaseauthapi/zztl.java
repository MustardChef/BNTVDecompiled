package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztl */
/* loaded from: classes3.dex */
public final class zztl extends zza implements zztn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zztl(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzd(zzwg zzwgVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzwgVar);
        zzJ(1, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zze(zzwg zzwgVar, zzvz zzvzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzwgVar);
        zzc.zzb(zza, zzvzVar);
        zzJ(2, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzf(zzvl zzvlVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzvlVar);
        zzJ(3, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzg(zzwr zzwrVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzwrVar);
        zzJ(4, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzh(Status status) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, status);
        zzJ(5, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzi() throws RemoteException {
        zzJ(6, zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzj() throws RemoteException {
        zzJ(7, zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzk(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzJ(8, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzJ(9, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzm(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, phoneAuthCredential);
        zzJ(10, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzJ(11, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzo(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, status);
        zzc.zzb(zza, phoneAuthCredential);
        zzJ(12, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzp() throws RemoteException {
        zzJ(13, zza());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzq(zzno zznoVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zznoVar);
        zzJ(14, zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzr(zznq zznqVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zznqVar);
        zzJ(15, zza);
    }
}
