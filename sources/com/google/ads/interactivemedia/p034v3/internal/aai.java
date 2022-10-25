package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aai */
/* loaded from: classes2.dex */
public final class aai extends aaq {
    public static final Parcelable.Creator<aai> CREATOR = new aag(2);

    /* renamed from: a */
    public final String f2893a;

    /* renamed from: b */
    public final int f2894b;

    /* renamed from: c */
    public final int f2895c;

    /* renamed from: d */
    public final long f2896d;

    /* renamed from: e */
    public final long f2897e;

    /* renamed from: g */
    private final aaq[] f2898g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aai(Parcel parcel) {
        super(ChapterFrame.f9672ID);
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2893a = readString;
        this.f2894b = parcel.readInt();
        this.f2895c = parcel.readInt();
        this.f2896d = parcel.readLong();
        this.f2897e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f2898g = new aaq[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f2898g[i2] = (aaq) parcel.readParcelable(aaq.class.getClassLoader());
        }
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
            aai aaiVar = (aai) obj;
            if (this.f2894b == aaiVar.f2894b && this.f2895c == aaiVar.f2895c && this.f2896d == aaiVar.f2896d && this.f2897e == aaiVar.f2897e && C2628cq.m2563T(this.f2893a, aaiVar.f2893a) && Arrays.equals(this.f2898g, aaiVar.f2898g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((this.f2894b + 527) * 31) + this.f2895c) * 31) + ((int) this.f2896d)) * 31) + ((int) this.f2897e)) * 31;
        String str = this.f2893a;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2893a);
        parcel.writeInt(this.f2894b);
        parcel.writeInt(this.f2895c);
        parcel.writeLong(this.f2896d);
        parcel.writeLong(this.f2897e);
        parcel.writeInt(this.f2898g.length);
        for (aaq aaqVar : this.f2898g) {
            parcel.writeParcelable(aaqVar, 0);
        }
    }

    public aai(String str, int i, int i2, long j, long j2, aaq[] aaqVarArr) {
        super(ChapterFrame.f9672ID);
        this.f2893a = str;
        this.f2894b = i;
        this.f2895c = i2;
        this.f2896d = j;
        this.f2897e = j2;
        this.f2898g = aaqVarArr;
    }
}
