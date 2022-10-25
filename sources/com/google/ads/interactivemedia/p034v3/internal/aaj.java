package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aaj */
/* loaded from: classes2.dex */
public final class aaj extends aaq {
    public static final Parcelable.Creator<aaj> CREATOR = new aag(3);

    /* renamed from: a */
    public final String f2899a;

    /* renamed from: b */
    public final boolean f2900b;

    /* renamed from: c */
    public final boolean f2901c;

    /* renamed from: d */
    public final String[] f2902d;

    /* renamed from: e */
    private final aaq[] f2903e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aaj(Parcel parcel) {
        super(ChapterTocFrame.f9673ID);
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2899a = readString;
        this.f2900b = parcel.readByte() != 0;
        this.f2901c = parcel.readByte() != 0;
        this.f2902d = (String[]) C2628cq.m2578E(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f2903e = new aaq[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f2903e[i2] = (aaq) parcel.readParcelable(aaq.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aaj aajVar = (aaj) obj;
            if (this.f2900b == aajVar.f2900b && this.f2901c == aajVar.f2901c && C2628cq.m2563T(this.f2899a, aajVar.f2899a) && Arrays.equals(this.f2902d, aajVar.f2902d) && Arrays.equals(this.f2903e, aajVar.f2903e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((((this.f2900b ? 1 : 0) + 527) * 31) + (this.f2901c ? 1 : 0)) * 31;
        String str = this.f2899a;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2899a);
        parcel.writeByte(this.f2900b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2901c ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f2902d);
        parcel.writeInt(this.f2903e.length);
        for (aaq aaqVar : this.f2903e) {
            parcel.writeParcelable(aaqVar, 0);
        }
    }

    public aaj(String str, boolean z, boolean z2, String[] strArr, aaq[] aaqVarArr) {
        super(ChapterTocFrame.f9673ID);
        this.f2899a = str;
        this.f2900b = z;
        this.f2901c = z2;
        this.f2902d = strArr;
        this.f2903e = aaqVarArr;
    }
}
