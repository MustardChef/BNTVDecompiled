package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqv */
/* loaded from: classes2.dex */
public final class aqv extends apl implements aqx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aqv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.signalsdk.ISignalSdkService");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqx
    /* renamed from: e */
    public final void mo4745e(aqy aqyVar, aqu aquVar) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4808c(m4814a, aqyVar);
        apn.m4807d(m4814a, aquVar);
        m4811x(m4814a);
    }
}
