package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzcc extends zzb implements zzcd {
    public zzcc() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb(parcel.readInt(), parcel.readInt(), (Surface) zzc.zzc(parcel, Surface.CREATOR));
        } else if (i == 2) {
            zzd(parcel.readInt());
        } else if (i == 3) {
            zzf();
        } else if (i == 4) {
            zzc();
        } else if (i != 5) {
            return false;
        } else {
            zze(zzc.zza(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
