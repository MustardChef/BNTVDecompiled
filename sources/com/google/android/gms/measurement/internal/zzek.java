package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzek extends com.google.android.gms.internal.measurement.zza implements zzei {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzaq zzaqVar, zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zzaqVar);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(1, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzku zzkuVar, zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zzkuVar);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(2, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(4, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzaq zzaqVar, String str, String str2) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zzaqVar);
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb(5, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zzb(zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(6, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzku> zza(zzn zznVar, boolean z) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, z);
        Parcel zza = zza(7, m338a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzku.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final byte[] zza(zzaq zzaqVar, String str) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zzaqVar);
        m338a_.writeString(str);
        Parcel zza = zza(9, m338a_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeLong(j);
        m338a_.writeString(str);
        m338a_.writeString(str2);
        m338a_.writeString(str3);
        zzb(10, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final String zzc(zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        Parcel zza = zza(11, m338a_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzz zzzVar, zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zzzVar);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(12, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzz zzzVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zzzVar);
        zzb(13, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzku> zza(String str, String str2, boolean z, zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, z);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        Parcel zza = zza(14, m338a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzku.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzku> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        m338a_.writeString(str3);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, z);
        Parcel zza = zza(15, m338a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzku.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzz> zza(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        Parcel zza = zza(16, m338a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzz> zza(String str, String str2, String str3) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        m338a_.writeString(str3);
        Parcel zza = zza(17, m338a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zzd(zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(18, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(Bundle bundle, zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, bundle);
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(19, m338a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zze(zzn zznVar) throws RemoteException {
        Parcel m338a_ = m338a_();
        com.google.android.gms.internal.measurement.zzb.zza(m338a_, zznVar);
        zzb(20, m338a_);
    }
}
