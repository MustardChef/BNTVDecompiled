package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ak */
/* loaded from: classes2.dex */
public final class C2549ak implements Parcelable {
    public static final Parcelable.Creator<C2549ak> CREATOR = new C2800j(2);

    /* renamed from: a */
    private final InterfaceC2548aj[] f4278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2549ak(Parcel parcel) {
        this.f4278a = new InterfaceC2548aj[parcel.readInt()];
        int i = 0;
        while (true) {
            InterfaceC2548aj[] interfaceC2548ajArr = this.f4278a;
            if (i >= interfaceC2548ajArr.length) {
                return;
            }
            interfaceC2548ajArr[i] = (InterfaceC2548aj) parcel.readParcelable(InterfaceC2548aj.class.getClassLoader());
            i++;
        }
    }

    public C2549ak(InterfaceC2548aj... interfaceC2548ajArr) {
        this.f4278a = interfaceC2548ajArr;
    }

    /* renamed from: a */
    public final int m5127a() {
        return this.f4278a.length;
    }

    /* renamed from: b */
    public final InterfaceC2548aj m5126b(int i) {
        return this.f4278a[i];
    }

    /* renamed from: c */
    public final C2549ak m5125c(InterfaceC2548aj... interfaceC2548ajArr) {
        return interfaceC2548ajArr.length == 0 ? this : new C2549ak((InterfaceC2548aj[]) C2628cq.m2550af(this.f4278a, interfaceC2548ajArr));
    }

    /* renamed from: d */
    public final C2549ak m5124d(C2549ak c2549ak) {
        return c2549ak == null ? this : m5125c(c2549ak.f4278a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f4278a, ((C2549ak) obj).f4278a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4278a);
    }

    public final String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.f4278a));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new String("entries=");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4278a.length);
        for (InterfaceC2548aj interfaceC2548aj : this.f4278a) {
            parcel.writeParcelable(interfaceC2548aj, 0);
        }
    }

    public C2549ak(List list) {
        this.f4278a = (InterfaceC2548aj[]) list.toArray(new InterfaceC2548aj[0]);
    }
}
