package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aah */
/* loaded from: classes2.dex */
public final class aah extends aaq {
    public static final Parcelable.Creator<aah> CREATOR = new aag(0);

    /* renamed from: a */
    public final byte[] f2892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public aah(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            r2.<init>(r0)
            byte[] r3 = r3.createByteArray()
            java.lang.Object r3 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.m2578E(r3)
            byte[] r3 = (byte[]) r3
            r2.f2892a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aah.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aah aahVar = (aah) obj;
            if (this.f2917f.equals(aahVar.f2917f) && Arrays.equals(this.f2892a, aahVar.f2892a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f2917f.hashCode() + 527) * 31) + Arrays.hashCode(this.f2892a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2917f);
        parcel.writeByteArray(this.f2892a);
    }

    public aah(String str, byte[] bArr) {
        super(str);
        this.f2892a = bArr;
    }
}
