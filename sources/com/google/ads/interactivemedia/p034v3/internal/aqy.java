package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqy */
/* loaded from: classes2.dex */
public final class aqy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<aqy> CREATOR = new ara(1);

    /* renamed from: a */
    private final String f4918a;

    /* renamed from: b */
    private final int f4919b;

    /* renamed from: c */
    private final String f4920c;

    public aqy(String str, int i, String str2) {
        this.f4918a = str;
        this.f4919b = i;
        this.f4920c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f4918a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f4919b);
        SafeParcelWriter.writeString(parcel, 3, this.f4920c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
