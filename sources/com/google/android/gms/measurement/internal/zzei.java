package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public interface zzei extends IInterface {
    List<zzku> zza(zzn zznVar, boolean z) throws RemoteException;

    List<zzz> zza(String str, String str2, zzn zznVar) throws RemoteException;

    List<zzz> zza(String str, String str2, String str3) throws RemoteException;

    List<zzku> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzku> zza(String str, String str2, boolean z, zzn zznVar) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzn zznVar) throws RemoteException;

    void zza(zzaq zzaqVar, zzn zznVar) throws RemoteException;

    void zza(zzaq zzaqVar, String str, String str2) throws RemoteException;

    void zza(zzku zzkuVar, zzn zznVar) throws RemoteException;

    void zza(zzn zznVar) throws RemoteException;

    void zza(zzz zzzVar) throws RemoteException;

    void zza(zzz zzzVar, zzn zznVar) throws RemoteException;

    byte[] zza(zzaq zzaqVar, String str) throws RemoteException;

    void zzb(zzn zznVar) throws RemoteException;

    String zzc(zzn zznVar) throws RemoteException;

    void zzd(zzn zznVar) throws RemoteException;

    void zze(zzn zznVar) throws RemoteException;
}
