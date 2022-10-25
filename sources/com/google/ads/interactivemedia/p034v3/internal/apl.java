package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apl */
/* loaded from: classes2.dex */
public class apl implements IInterface {

    /* renamed from: a */
    private final IBinder f4855a;

    /* renamed from: b */
    private final String f4856b;

    /* JADX INFO: Access modifiers changed from: protected */
    public apl(IBinder iBinder, String str) {
        this.f4855a = iBinder;
        this.f4856b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel m4814a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4856b);
        return obtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4855a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public final Parcel m4813v(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f4855a.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public final void m4812w(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f4855a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public final void m4811x(Parcel parcel) throws RemoteException {
        try {
            this.f4855a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
