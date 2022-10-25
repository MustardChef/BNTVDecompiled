package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzad extends zza implements zzab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzab
    public final void zza(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel m338a_ = m338a_();
        m338a_.writeString(str);
        m338a_.writeString(str2);
        zzb.zza(m338a_, bundle);
        m338a_.writeLong(j);
        zzb(1, m338a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzab
    public final int zza() throws RemoteException {
        Parcel zza = zza(2, m338a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
