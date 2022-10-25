package com.google.android.gms.internal.p037authapiphone;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzk */
/* loaded from: classes.dex */
public abstract class zzk extends zza implements zzl {
    public zzk() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // com.google.android.gms.internal.p037authapiphone.zza
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((Status) zzd.zza(parcel, Status.CREATOR));
            return true;
        }
        return false;
    }
}
