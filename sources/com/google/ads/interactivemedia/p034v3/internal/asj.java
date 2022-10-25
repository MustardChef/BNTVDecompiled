package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asj */
/* loaded from: classes2.dex */
public final class asj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<asj> CREATOR = new asl(1);

    /* renamed from: a */
    public final int f4986a;

    /* renamed from: b */
    public final String f4987b;

    /* renamed from: c */
    public final String f4988c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public asj(int i, String str, String str2) {
        this.f4986a = i;
        this.f4987b = str;
        this.f4988c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f4986a);
        SafeParcelWriter.writeString(parcel, 2, this.f4987b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f4988c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public asj(String str, String str2) {
        this(1, str, str2);
    }
}
