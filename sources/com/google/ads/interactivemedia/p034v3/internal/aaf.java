package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aaf */
/* loaded from: classes2.dex */
public final class aaf extends aaq {
    public static final Parcelable.Creator<aaf> CREATOR = new aag(1);

    /* renamed from: a */
    public final String f2887a;

    /* renamed from: b */
    public final String f2888b;

    /* renamed from: c */
    public final int f2889c;

    /* renamed from: d */
    public final byte[] f2890d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aaf(Parcel parcel) {
        super(ApicFrame.f9671ID);
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2887a = readString;
        this.f2888b = parcel.readString();
        this.f2889c = parcel.readInt();
        this.f2890d = (byte[]) C2628cq.m2578E(parcel.createByteArray());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2548aj
    /* renamed from: a */
    public final void mo1383a(C2545ag c2545ag) {
        c2545ag.m5471t(this.f2890d, this.f2889c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aaf aafVar = (aaf) obj;
            if (this.f2889c == aafVar.f2889c && C2628cq.m2563T(this.f2887a, aafVar.f2887a) && C2628cq.m2563T(this.f2888b, aafVar.f2888b) && Arrays.equals(this.f2890d, aafVar.f2890d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f2889c + 527) * 31;
        String str = this.f2887a;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2888b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f2890d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq
    public final String toString() {
        String str = this.f2917f;
        String str2 = this.f2887a;
        String str3 = this.f2888b;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2887a);
        parcel.writeString(this.f2888b);
        parcel.writeInt(this.f2889c);
        parcel.writeByteArray(this.f2890d);
    }

    public aaf(String str, String str2, int i, byte[] bArr) {
        super(ApicFrame.f9671ID);
        this.f2887a = str;
        this.f2888b = str2;
        this.f2889c = i;
        this.f2890d = bArr;
    }
}
