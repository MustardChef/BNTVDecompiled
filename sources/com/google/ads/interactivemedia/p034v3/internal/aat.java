package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aat */
/* loaded from: classes2.dex */
public final class aat extends aaq {
    public static final Parcelable.Creator<aat> CREATOR = new aag(8);

    /* renamed from: a */
    public final String f2926a;

    /* renamed from: b */
    public final byte[] f2927b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aat(Parcel parcel) {
        super(PrivFrame.f9679ID);
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2926a = readString;
        this.f2927b = (byte[]) C2628cq.m2578E(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aat aatVar = (aat) obj;
            if (C2628cq.m2563T(this.f2926a, aatVar.f2926a) && Arrays.equals(this.f2927b, aatVar.f2927b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2926a;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.f2927b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq
    public final String toString() {
        String str = this.f2917f;
        String str2 = this.f2926a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": owner=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2926a);
        parcel.writeByteArray(this.f2927b);
    }

    public aat(String str, byte[] bArr) {
        super(PrivFrame.f9679ID);
        this.f2926a = str;
        this.f2927b = bArr;
    }
}
