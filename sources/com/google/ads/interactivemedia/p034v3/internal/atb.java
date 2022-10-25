package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atb */
/* loaded from: classes2.dex */
public final class atb extends apm implements atc {
    public atb() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    /* renamed from: b */
    public static atc m4633b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
        return queryLocalInterface instanceof atc ? (atc) queryLocalInterface : new ata(iBinder);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apm
    /* renamed from: a */
    protected final boolean mo4634a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i) {
            case 2:
                ark.m4734b(parcel.readStrongBinder());
                parcel.readString();
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                break;
            case 5:
                parcel.createByteArray();
                break;
            case 6:
                parcel.readInt();
                break;
            case 7:
                parcel.readInt();
                break;
            case 8:
                ark.m4734b(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: e */
    public final void mo4632e() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: f */
    public final void mo4631f(int i) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: g */
    public final void mo4630g(int i) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: h */
    public final void mo4629h(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: i */
    public final void mo4628i(arl arlVar, String str) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atc
    /* renamed from: j */
    public final void mo4627j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public atb(byte[] bArr) {
        this();
    }
}
