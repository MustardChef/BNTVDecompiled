package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aax */
/* loaded from: classes2.dex */
final class aax implements Parcelable.Creator {

    /* renamed from: a */
    private final /* synthetic */ int f2936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aax(int i) {
        this.f2936a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = this.f2936a;
        if (i != 0) {
            return i != 1 ? new aaz(parcel) : new aaw(parcel);
        }
        return new aay(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        int i2 = this.f2936a;
        if (i2 != 0) {
            return i2 != 1 ? new aaz[i] : new aaw[i];
        }
        return new aay[i];
    }
}
