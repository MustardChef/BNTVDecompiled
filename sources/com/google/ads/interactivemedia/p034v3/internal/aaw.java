package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aaw */
/* loaded from: classes2.dex */
public final class aaw implements InterfaceC2548aj {
    public static final Parcelable.Creator<aaw> CREATOR = new aax(1);

    /* renamed from: a */
    public final String f2932a;

    /* renamed from: b */
    public final byte[] f2933b;

    /* renamed from: c */
    public final int f2934c;

    /* renamed from: d */
    public final int f2935d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aaw(Parcel parcel) {
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2932a = readString;
        this.f2933b = (byte[]) C2628cq.m2578E(parcel.createByteArray());
        this.f2934c = parcel.readInt();
        this.f2935d = parcel.readInt();
    }

    public aaw(String str, byte[] bArr, int i, int i2) {
        this.f2932a = str;
        this.f2933b = bArr;
        this.f2934c = i;
        this.f2935d = i2;
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
            aaw aawVar = (aaw) obj;
            if (this.f2932a.equals(aawVar.f2932a) && Arrays.equals(this.f2933b, aawVar.f2933b) && this.f2934c == aawVar.f2934c && this.f2935d == aawVar.f2935d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f2932a.hashCode() + 527) * 31) + Arrays.hashCode(this.f2933b)) * 31) + this.f2934c) * 31) + this.f2935d;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f2932a);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2932a);
        parcel.writeByteArray(this.f2933b);
        parcel.writeInt(this.f2934c);
        parcel.writeInt(this.f2935d);
    }
}
