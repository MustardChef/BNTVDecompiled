package com.google.ads.interactivemedia.p034v3.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apn */
/* loaded from: classes2.dex */
public final class apn {
    static {
        apn.class.getClassLoader();
    }

    private apn() {
    }

    /* renamed from: a */
    public static Parcelable m4810a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: b */
    public static void m4809b(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: c */
    public static void m4808c(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static void m4807d(Parcel parcel, IInterface iInterface) {
        if (iInterface == 0) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface);
        }
    }

    /* renamed from: e */
    public static boolean m4806e(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
