package com.google.android.gms.internal.safetynet;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* loaded from: classes3.dex */
public interface zzg extends IInterface {
    void zza(Status status) throws RemoteException;

    void zza(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException;

    void zza(Status status, com.google.android.gms.safetynet.zza zzaVar) throws RemoteException;

    void zza(Status status, com.google.android.gms.safetynet.zzd zzdVar) throws RemoteException;

    void zza(Status status, com.google.android.gms.safetynet.zzf zzfVar) throws RemoteException;

    void zza(Status status, com.google.android.gms.safetynet.zzh zzhVar) throws RemoteException;

    void zza(Status status, boolean z) throws RemoteException;

    void zza(String str) throws RemoteException;

    void zzb(Status status, boolean z) throws RemoteException;
}
