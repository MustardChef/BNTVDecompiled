package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aay */
/* loaded from: classes2.dex */
public final class aay implements InterfaceC2548aj {
    public static final Parcelable.Creator<aay> CREATOR = new aax(0);

    /* renamed from: a */
    public final long f2937a;

    /* renamed from: b */
    public final long f2938b;

    /* renamed from: c */
    public final long f2939c;

    /* renamed from: d */
    public final long f2940d;

    /* renamed from: e */
    public final long f2941e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aay(Parcel parcel) {
        this.f2937a = parcel.readLong();
        this.f2938b = parcel.readLong();
        this.f2939c = parcel.readLong();
        this.f2940d = parcel.readLong();
        this.f2941e = parcel.readLong();
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
            aay aayVar = (aay) obj;
            if (this.f2937a == aayVar.f2937a && this.f2938b == aayVar.f2938b && this.f2939c == aayVar.f2939c && this.f2940d == aayVar.f2940d && this.f2941e == aayVar.f2941e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((ayu.m4314f(this.f2937a) + 527) * 31) + ayu.m4314f(this.f2938b)) * 31) + ayu.m4314f(this.f2939c)) * 31) + ayu.m4314f(this.f2940d)) * 31) + ayu.m4314f(this.f2941e);
    }

    public final String toString() {
        long j = this.f2937a;
        long j2 = this.f2938b;
        long j3 = this.f2939c;
        long j4 = this.f2940d;
        long j5 = this.f2941e;
        StringBuilder sb = new StringBuilder((int) bqk.f6576bj);
        sb.append("Motion photo metadata: photoStartPosition=");
        sb.append(j);
        sb.append(", photoSize=");
        sb.append(j2);
        sb.append(", photoPresentationTimestampUs=");
        sb.append(j3);
        sb.append(", videoStartPosition=");
        sb.append(j4);
        sb.append(", videoSize=");
        sb.append(j5);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2937a);
        parcel.writeLong(this.f2938b);
        parcel.writeLong(this.f2939c);
        parcel.writeLong(this.f2940d);
        parcel.writeLong(this.f2941e);
    }
}
