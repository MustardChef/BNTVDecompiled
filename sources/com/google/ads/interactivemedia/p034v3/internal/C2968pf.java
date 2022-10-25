package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pf */
/* loaded from: classes2.dex */
final class C2968pf implements Parcelable.Creator {

    /* renamed from: a */
    private final /* synthetic */ int f8448a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2968pf(int i) {
        this.f8448a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.f8448a != 0 ? new C2970ph(parcel) : new C2969pg(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return this.f8448a != 0 ? new C2970ph[i] : new C2969pg[i];
    }
}
