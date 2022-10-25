package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqz */
/* loaded from: classes2.dex */
public final class aqz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<aqz> CREATOR = new ara(0);

    /* renamed from: a */
    private final String f4921a;

    public aqz(String str) {
        this.f4921a = str;
    }

    /* renamed from: a */
    public final String m4744a() {
        return this.f4921a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, m4744a(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
