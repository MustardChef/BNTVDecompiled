package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asr */
/* loaded from: classes2.dex */
public final class asr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<asr> CREATOR = new asl(2);

    /* renamed from: a */
    public final int f5006a;

    /* renamed from: b */
    public final int f5007b;

    /* renamed from: c */
    public final String f5008c;

    /* renamed from: d */
    public final String f5009d;

    /* renamed from: e */
    public final int f5010e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public asr(int i, int i2, int i3, String str, String str2) {
        this.f5006a = i;
        this.f5007b = i2;
        this.f5008c = str;
        this.f5009d = str2;
        this.f5010e = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f5006a);
        SafeParcelWriter.writeInt(parcel, 2, this.f5007b);
        SafeParcelWriter.writeString(parcel, 3, this.f5008c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f5009d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f5010e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public asr(int i, String str, String str2) {
        this(1, 1, aph.m4840b(i), str, str2);
    }
}
