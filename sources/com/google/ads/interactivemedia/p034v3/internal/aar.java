package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aar */
/* loaded from: classes2.dex */
public final class aar extends aaq {
    public static final Parcelable.Creator<aar> CREATOR = new aag(6);

    /* renamed from: a */
    public final String f2918a;

    /* renamed from: b */
    public final String f2919b;

    /* renamed from: c */
    public final String f2920c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aar(Parcel parcel) {
        super(InternalFrame.f9677ID);
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2918a = readString;
        this.f2919b = parcel.readString();
        this.f2920c = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aar aarVar = (aar) obj;
            if (C2628cq.m2563T(this.f2919b, aarVar.f2919b) && C2628cq.m2563T(this.f2918a, aarVar.f2918a) && C2628cq.m2563T(this.f2920c, aarVar.f2920c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2918a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f2919b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2920c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq
    public final String toString() {
        String str = this.f2917f;
        String str2 = this.f2918a;
        String str3 = this.f2919b;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": domain=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2917f);
        parcel.writeString(this.f2918a);
        parcel.writeString(this.f2920c);
    }

    public aar(String str, String str2, String str3) {
        super(InternalFrame.f9677ID);
        this.f2918a = str;
        this.f2919b = str2;
        this.f2920c = str3;
    }
}
