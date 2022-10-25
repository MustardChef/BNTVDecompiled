package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ata */
/* loaded from: classes2.dex */
public final class ata extends apl implements atc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: e */
    public final void mo4632e() throws RemoteException {
        m4812w(3, m4814a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: f */
    public final void mo4631f(int i) throws RemoteException {
        Parcel m4814a = m4814a();
        m4814a.writeInt(i);
        m4812w(7, m4814a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: g */
    public final void mo4630g(int i) throws RemoteException {
        Parcel m4814a = m4814a();
        m4814a.writeInt(i);
        m4812w(6, m4814a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: h */
    public final void mo4629h(byte[] bArr) throws RemoteException {
        Parcel m4814a = m4814a();
        m4814a.writeByteArray(bArr);
        m4812w(5, m4814a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: i */
    public final void mo4628i(arl arlVar, String str) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4807d(m4814a, arlVar);
        m4814a.writeString(str);
        m4814a.writeString(null);
        m4812w(8, m4814a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: j */
    public final void mo4627j() throws RemoteException {
        Parcel m4814a = m4814a();
        m4814a.writeIntArray(null);
        m4812w(4, m4814a);
    }
}
