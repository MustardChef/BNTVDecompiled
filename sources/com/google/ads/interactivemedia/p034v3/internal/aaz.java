package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aaz */
/* loaded from: classes2.dex */
public final class aaz implements InterfaceC2548aj {
    public static final Parcelable.Creator<aaz> CREATOR = new aax(2);

    /* renamed from: a */
    public final float f2942a;

    /* renamed from: b */
    public final int f2943b;

    public aaz(float f, int i) {
        this.f2942a = f;
        this.f2943b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aaz(Parcel parcel) {
        this.f2942a = parcel.readFloat();
        this.f2943b = parcel.readInt();
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
            aaz aazVar = (aaz) obj;
            if (this.f2942a == aazVar.f2942a && this.f2943b == aazVar.f2943b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f2942a).hashCode() + 527) * 31) + this.f2943b;
    }

    public final String toString() {
        float f = this.f2942a;
        int i = this.f2943b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("smta: captureFrameRate=");
        sb.append(f);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f2942a);
        parcel.writeInt(this.f2943b);
    }
}
