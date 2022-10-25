package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pg */
/* loaded from: classes2.dex */
public final class C2969pg implements Parcelable {
    public static final Parcelable.Creator<C2969pg> CREATOR = new C2968pf(0);

    /* renamed from: a */
    public final int f8449a;

    /* renamed from: b */
    public final int f8450b;

    /* renamed from: c */
    public final String f8451c;

    /* renamed from: d */
    public final String f8452d;

    /* renamed from: e */
    public final String f8453e;

    /* renamed from: f */
    public final String f8454f;

    public C2969pg(int i, int i2, String str, String str2, String str3, String str4) {
        this.f8449a = i;
        this.f8450b = i2;
        this.f8451c = str;
        this.f8452d = str2;
        this.f8453e = str3;
        this.f8454f = str4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2969pg(Parcel parcel) {
        this.f8449a = parcel.readInt();
        this.f8450b = parcel.readInt();
        this.f8451c = parcel.readString();
        this.f8452d = parcel.readString();
        this.f8453e = parcel.readString();
        this.f8454f = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2969pg c2969pg = (C2969pg) obj;
            if (this.f8449a == c2969pg.f8449a && this.f8450b == c2969pg.f8450b && TextUtils.equals(this.f8451c, c2969pg.f8451c) && TextUtils.equals(this.f8452d, c2969pg.f8452d) && TextUtils.equals(this.f8453e, c2969pg.f8453e) && TextUtils.equals(this.f8454f, c2969pg.f8454f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.f8449a * 31) + this.f8450b) * 31;
        String str = this.f8451c;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8452d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8453e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8454f;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8449a);
        parcel.writeInt(this.f8450b);
        parcel.writeString(this.f8451c);
        parcel.writeString(this.f8452d);
        parcel.writeString(this.f8453e);
        parcel.writeString(this.f8454f);
    }
}
