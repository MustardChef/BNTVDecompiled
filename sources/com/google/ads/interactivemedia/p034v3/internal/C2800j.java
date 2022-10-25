package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.j */
/* loaded from: classes2.dex */
final class C2800j implements Parcelable.Creator {

    /* renamed from: a */
    private final /* synthetic */ int f7641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2800j(int i) {
        this.f7641a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = this.f7641a;
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? new C2568ax(parcel) : new C2549ak(parcel);
            }
            return new C2854l(parcel);
        }
        return new C2827k(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        int i2 = this.f7641a;
        if (i2 != 0) {
            if (i2 != 1) {
                return i2 != 2 ? new C2568ax[i] : new C2549ak[i];
            }
            return new C2854l[i];
        }
        return new C2827k[i];
    }
}
