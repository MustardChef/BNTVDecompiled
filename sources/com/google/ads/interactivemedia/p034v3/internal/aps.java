package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aps */
/* loaded from: classes2.dex */
public abstract class aps extends apm implements apt {
    public aps() {
        super("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apm
    /* renamed from: a */
    protected final boolean mo4634a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i) {
            case 1:
                parcel2.writeNoException();
                parcel2.writeString(mo4794j());
                return true;
            case 2:
                mo4790n(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                boolean p = mo4788p(ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                apn.m4809b(parcel2, p);
                return true;
            case 4:
                boolean q = mo4787q(ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                apn.m4809b(parcel2, q);
                return true;
            case 5:
                mo4789o(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                arl d = mo4800d(ark.m4734b(parcel.readStrongBinder()), ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                apn.m4807d(parcel2, d);
                return true;
            case 7:
                String f = mo4798f(ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(f);
                return true;
            case 8:
                String e = mo4799e(ark.m4734b(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(e);
                return true;
            case 9:
                mo4792l(ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                arl c = mo4801c(ark.m4734b(parcel.readStrongBinder()), ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                apn.m4807d(parcel2, c);
                return true;
            case 11:
                boolean s = mo4785s(parcel.readString(), apn.m4806e(parcel));
                parcel2.writeNoException();
                apn.m4809b(parcel2, s);
                return true;
            case 12:
                String g = mo4797g(ark.m4734b(parcel.readStrongBinder()), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeString(g);
                return true;
            case 13:
                String i2 = mo4795i(ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(i2);
                return true;
            case 14:
                String k = mo4793k(ark.m4734b(parcel.readStrongBinder()), ark.m4734b(parcel.readStrongBinder()), ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(k);
                return true;
            case 15:
                mo4791m(ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 16:
            default:
                return false;
            case 17:
                String h = mo4796h(ark.m4734b(parcel.readStrongBinder()), ark.m4734b(parcel.readStrongBinder()), ark.m4734b(parcel.readStrongBinder()), ark.m4734b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(h);
                return true;
            case 18:
                boolean r = mo4786r();
                parcel2.writeNoException();
                apn.m4809b(parcel2, r);
                return true;
            case 19:
                boolean t = mo4784t();
                parcel2.writeNoException();
                apn.m4809b(parcel2, t);
                return true;
            case 20:
                int b = mo4802b();
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
        }
    }
}
