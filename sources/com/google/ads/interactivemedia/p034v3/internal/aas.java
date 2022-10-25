package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aas */
/* loaded from: classes2.dex */
public final class aas extends aaq {
    public static final Parcelable.Creator<aas> CREATOR = new aag(7);

    /* renamed from: a */
    public final int f2921a;

    /* renamed from: b */
    public final int f2922b;

    /* renamed from: c */
    public final int f2923c;

    /* renamed from: d */
    public final int[] f2924d;

    /* renamed from: e */
    public final int[] f2925e;

    public aas(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super(MlltFrame.f9678ID);
        this.f2921a = i;
        this.f2922b = i2;
        this.f2923c = i3;
        this.f2924d = iArr;
        this.f2925e = iArr2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aas aasVar = (aas) obj;
            if (this.f2921a == aasVar.f2921a && this.f2922b == aasVar.f2922b && this.f2923c == aasVar.f2923c && Arrays.equals(this.f2924d, aasVar.f2924d) && Arrays.equals(this.f2925e, aasVar.f2925e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.f2921a + 527) * 31) + this.f2922b) * 31) + this.f2923c) * 31) + Arrays.hashCode(this.f2924d)) * 31) + Arrays.hashCode(this.f2925e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2921a);
        parcel.writeInt(this.f2922b);
        parcel.writeInt(this.f2923c);
        parcel.writeIntArray(this.f2924d);
        parcel.writeIntArray(this.f2925e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aas(Parcel parcel) {
        super(MlltFrame.f9678ID);
        this.f2921a = parcel.readInt();
        this.f2922b = parcel.readInt();
        this.f2923c = parcel.readInt();
        this.f2924d = (int[]) C2628cq.m2578E(parcel.createIntArray());
        this.f2925e = (int[]) C2628cq.m2578E(parcel.createIntArray());
    }
}
