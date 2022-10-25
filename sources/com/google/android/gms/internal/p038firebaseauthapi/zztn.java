package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztn */
/* loaded from: classes3.dex */
public interface zztn extends IInterface {
    void zzd(zzwg zzwgVar) throws RemoteException;

    void zze(zzwg zzwgVar, zzvz zzvzVar) throws RemoteException;

    void zzf(zzvl zzvlVar) throws RemoteException;

    void zzg(zzwr zzwrVar) throws RemoteException;

    void zzh(Status status) throws RemoteException;

    void zzi() throws RemoteException;

    void zzj() throws RemoteException;

    void zzk(String str) throws RemoteException;

    void zzl(String str) throws RemoteException;

    void zzm(PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zzn(String str) throws RemoteException;

    void zzo(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zzp() throws RemoteException;

    void zzq(zzno zznoVar) throws RemoteException;

    void zzr(zznq zznqVar) throws RemoteException;
}
