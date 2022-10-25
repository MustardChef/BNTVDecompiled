package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asm */
/* loaded from: classes2.dex */
public final class C2562asm extends apl implements asn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C2562asm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.asn
    /* renamed from: e */
    public final ask mo4686e(asj asjVar) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4808c(m4814a, asjVar);
        Parcel m4813v = m4813v(1, m4814a);
        ask askVar = (ask) apn.m4810a(m4813v, ask.CREATOR);
        m4813v.recycle();
        return askVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.asn
    /* renamed from: f */
    public final ass mo4685f(asr asrVar) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4808c(m4814a, asrVar);
        Parcel m4813v = m4813v(3, m4814a);
        ass assVar = (ass) apn.m4810a(m4813v, ass.CREATOR);
        m4813v.recycle();
        return assVar;
    }
}
