package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqt */
/* loaded from: classes2.dex */
public abstract class aqt extends apm implements aqu {
    public aqt() {
        super("com.google.android.gms.ads.signalsdk.INetworkRequestCallback");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.apm
    /* renamed from: a */
    protected final boolean mo4634a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i == 1) {
            mo4736c((aqz) apn.m4810a(parcel, aqz.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            mo4737b(parcel.readInt());
        }
        return true;
    }
}
