package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ax */
/* loaded from: classes2.dex */
public final class C2568ax implements Comparable<C2568ax>, Parcelable {
    public static final Parcelable.Creator<C2568ax> CREATOR = new C2800j(3);

    /* renamed from: a */
    public final int f5238a;

    /* renamed from: b */
    public final int f5239b;

    /* renamed from: c */
    public final int f5240c;

    public C2568ax() {
        this.f5238a = -1;
        this.f5239b = -1;
        this.f5240c = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2568ax(Parcel parcel) {
        this.f5238a = parcel.readInt();
        this.f5239b = parcel.readInt();
        this.f5240c = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(C2568ax c2568ax) {
        C2568ax c2568ax2 = c2568ax;
        int i = this.f5238a - c2568ax2.f5238a;
        if (i == 0) {
            int i2 = this.f5239b - c2568ax2.f5239b;
            return i2 == 0 ? this.f5240c - c2568ax2.f5240c : i2;
        }
        return i;
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
            C2568ax c2568ax = (C2568ax) obj;
            if (this.f5238a == c2568ax.f5238a && this.f5239b == c2568ax.f5239b && this.f5240c == c2568ax.f5240c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f5238a * 31) + this.f5239b) * 31) + this.f5240c;
    }

    public final String toString() {
        int i = this.f5238a;
        int i2 = this.f5239b;
        int i3 = this.f5240c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5238a);
        parcel.writeInt(this.f5239b);
        parcel.writeInt(this.f5240c);
    }
}
