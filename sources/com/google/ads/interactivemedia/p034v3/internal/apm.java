package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apm */
/* loaded from: classes2.dex */
public class apm extends Binder implements IInterface {
    /* JADX INFO: Access modifiers changed from: protected */
    public apm(String str) {
        attachInterface(this, str);
    }

    /* renamed from: a */
    protected boolean mo4634a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i > 16777215) {
            if (super.onTransact(i, parcel, parcel2, i2)) {
                return true;
            }
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
        }
        return mo4634a(i, parcel, parcel2);
    }
}
