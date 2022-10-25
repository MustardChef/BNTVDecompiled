package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aav */
/* loaded from: classes2.dex */
public final class aav extends aaq {
    public static final Parcelable.Creator<aav> CREATOR = new aag(10);

    /* renamed from: a */
    public final String f2930a;

    /* renamed from: b */
    public final String f2931b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public aav(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.f2930a = r0
            java.lang.String r3 = r3.readString()
            r2.f2931b = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aav.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aav aavVar = (aav) obj;
            if (this.f2917f.equals(aavVar.f2917f) && C2628cq.m2563T(this.f2930a, aavVar.f2930a) && C2628cq.m2563T(this.f2931b, aavVar.f2931b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f2917f.hashCode() + 527) * 31;
        String str = this.f2930a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2931b;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq
    public final String toString() {
        String str = this.f2917f;
        String str2 = this.f2931b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": url=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2917f);
        parcel.writeString(this.f2930a);
        parcel.writeString(this.f2931b);
    }

    public aav(String str, String str2, String str3) {
        super(str);
        this.f2930a = str2;
        this.f2931b = str3;
    }
}
