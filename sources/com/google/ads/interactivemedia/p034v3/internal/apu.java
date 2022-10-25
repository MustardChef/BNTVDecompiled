package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apu */
/* loaded from: classes2.dex */
public final class apu extends apl implements apv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public apu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apv
    /* renamed from: e */
    public final IBinder mo4783e(arl arlVar, arl arlVar2, byte[] bArr) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4807d(m4814a, arlVar);
        apn.m4807d(m4814a, arlVar2);
        m4814a.writeByteArray(bArr);
        Parcel m4813v = m4813v(3, m4814a);
        IBinder readStrongBinder = m4813v.readStrongBinder();
        m4813v.recycle();
        return readStrongBinder;
    }
}
