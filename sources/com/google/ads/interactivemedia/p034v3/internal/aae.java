package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aae */
/* loaded from: classes2.dex */
public final class aae implements InterfaceC2548aj {
    public static final Parcelable.Creator<aae> CREATOR = new aad();

    /* renamed from: a */
    public final int f2881a;

    /* renamed from: b */
    public final String f2882b;

    /* renamed from: c */
    public final String f2883c;

    /* renamed from: d */
    public final String f2884d;

    /* renamed from: e */
    public final boolean f2885e;

    /* renamed from: f */
    public final int f2886f;

    public aae(int i, String str, String str2, String str3, boolean z, int i2) {
        boolean z2 = true;
        if (i2 != -1 && i2 <= 0) {
            z2 = false;
        }
        C2616ce.m2687f(z2);
        this.f2881a = i;
        this.f2882b = str;
        this.f2883c = str2;
        this.f2884d = str3;
        this.f2885e = z;
        this.f2886f = i2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2548aj
    /* renamed from: a */
    public final /* synthetic */ void mo1383a(C2545ag c2545ag) {
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
            aae aaeVar = (aae) obj;
            if (this.f2881a == aaeVar.f2881a && C2628cq.m2563T(this.f2882b, aaeVar.f2882b) && C2628cq.m2563T(this.f2883c, aaeVar.f2883c) && C2628cq.m2563T(this.f2884d, aaeVar.f2884d) && this.f2885e == aaeVar.f2885e && this.f2886f == aaeVar.f2886f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f2881a + 527) * 31;
        String str = this.f2882b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2883c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2884d;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f2885e ? 1 : 0)) * 31) + this.f2886f;
    }

    public final String toString() {
        String str = this.f2883c;
        String str2 = this.f2882b;
        int i = this.f2881a;
        int i2 = this.f2886f;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80 + String.valueOf(str2).length());
        sb.append("IcyHeaders: name=\"");
        sb.append(str);
        sb.append("\", genre=\"");
        sb.append(str2);
        sb.append("\", bitrate=");
        sb.append(i);
        sb.append(", metadataInterval=");
        sb.append(i2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2881a);
        parcel.writeString(this.f2882b);
        parcel.writeString(this.f2883c);
        parcel.writeString(this.f2884d);
        C2628cq.m2564S(parcel, this.f2885e);
        parcel.writeInt(this.f2886f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aae(Parcel parcel) {
        this.f2881a = parcel.readInt();
        this.f2882b = parcel.readString();
        this.f2883c = parcel.readString();
        this.f2884d = parcel.readString();
        this.f2885e = C2628cq.m2555aa(parcel);
        this.f2886f = parcel.readInt();
    }
}
