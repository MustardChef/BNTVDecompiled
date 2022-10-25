package com.google.android.gms.cast.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzac extends com.google.android.gms.internal.cast.zzb implements zzad {
    public zzac() {
        super("com.google.android.gms.cast.internal.IBundleCallback");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((Bundle) com.google.android.gms.internal.cast.zzc.zzc(parcel, Bundle.CREATOR));
            return true;
        }
        return false;
    }
}
