package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aal */
/* loaded from: classes2.dex */
public final class aal extends aaq {
    public static final Parcelable.Creator<aal> CREATOR = new aag(5);

    /* renamed from: a */
    public final String f2907a;

    /* renamed from: b */
    public final String f2908b;

    /* renamed from: c */
    public final String f2909c;

    /* renamed from: d */
    public final byte[] f2910d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aal(Parcel parcel) {
        super(GeobFrame.f9675ID);
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2907a = readString;
        this.f2908b = parcel.readString();
        this.f2909c = parcel.readString();
        this.f2910d = (byte[]) C2628cq.m2578E(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aal aalVar = (aal) obj;
            if (C2628cq.m2563T(this.f2907a, aalVar.f2907a) && C2628cq.m2563T(this.f2908b, aalVar.f2908b) && C2628cq.m2563T(this.f2909c, aalVar.f2909c) && Arrays.equals(this.f2910d, aalVar.f2910d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2907a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f2908b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2909c;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f2910d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq
    public final String toString() {
        String str = this.f2917f;
        String str2 = this.f2907a;
        String str3 = this.f2908b;
        String str4 = this.f2909c;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 36 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", filename=");
        sb.append(str3);
        sb.append(", description=");
        sb.append(str4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2907a);
        parcel.writeString(this.f2908b);
        parcel.writeString(this.f2909c);
        parcel.writeByteArray(this.f2910d);
    }

    public aal(String str, String str2, String str3, byte[] bArr) {
        super(GeobFrame.f9675ID);
        this.f2907a = str;
        this.f2908b = str2;
        this.f2909c = str3;
        this.f2910d = bArr;
    }
}
