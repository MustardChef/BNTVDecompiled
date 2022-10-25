package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apr */
/* loaded from: classes2.dex */
public final class apr extends apl implements apt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public apr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: b */
    public final int mo4802b() throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: c */
    public final arl mo4801c(arl arlVar, arl arlVar2) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: d */
    public final arl mo4800d(arl arlVar, arl arlVar2) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4807d(m4814a, arlVar);
        apn.m4807d(m4814a, arlVar2);
        Parcel m4813v = m4813v(6, m4814a);
        arl m4734b = ark.m4734b(m4813v.readStrongBinder());
        m4813v.recycle();
        return m4734b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: e */
    public final String mo4799e(arl arlVar, String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: f */
    public final String mo4798f(arl arlVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: g */
    public final String mo4797g(arl arlVar, byte[] bArr) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4807d(m4814a, arlVar);
        m4814a.writeByteArray(null);
        Parcel m4813v = m4813v(12, m4814a);
        String readString = m4813v.readString();
        m4813v.recycle();
        return readString;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: h */
    public final String mo4796h(arl arlVar, arl arlVar2, arl arlVar3, arl arlVar4) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: i */
    public final String mo4795i(arl arlVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: j */
    public final String mo4794j() throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: k */
    public final String mo4793k(arl arlVar, arl arlVar2, arl arlVar3) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: l */
    public final void mo4792l(arl arlVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: m */
    public final void mo4791m(arl arlVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: n */
    public final void mo4790n(String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: o */
    public final void mo4789o(String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: p */
    public final boolean mo4788p(arl arlVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: q */
    public final boolean mo4787q(arl arlVar) throws RemoteException {
        Parcel m4814a = m4814a();
        apn.m4807d(m4814a, arlVar);
        Parcel m4813v = m4813v(4, m4814a);
        boolean m4806e = apn.m4806e(m4813v);
        m4813v.recycle();
        return m4806e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: r */
    public final boolean mo4786r() throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: s */
    public final boolean mo4785s(String str, boolean z) throws RemoteException {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apt
    /* renamed from: t */
    public final boolean mo4784t() throws RemoteException {
        throw null;
    }
}
