package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ph */
/* loaded from: classes2.dex */
public final class C2970ph implements InterfaceC2548aj {
    public static final Parcelable.Creator<C2970ph> CREATOR = new C2968pf(1);

    /* renamed from: a */
    public final String f8455a;

    /* renamed from: b */
    public final String f8456b;

    /* renamed from: c */
    public final List f8457c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2970ph(Parcel parcel) {
        this.f8455a = parcel.readString();
        this.f8456b = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((C2969pg) parcel.readParcelable(C2969pg.class.getClassLoader()));
        }
        this.f8457c = Collections.unmodifiableList(arrayList);
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
            C2970ph c2970ph = (C2970ph) obj;
            if (TextUtils.equals(this.f8455a, c2970ph.f8455a) && TextUtils.equals(this.f8456b, c2970ph.f8456b) && this.f8457c.equals(c2970ph.f8457c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8455a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8456b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f8457c.hashCode();
    }

    public final String toString() {
        String str;
        String str2 = this.f8455a;
        if (str2 != null) {
            String str3 = this.f8456b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 5 + String.valueOf(str3).length());
            sb.append(" [");
            sb.append(str2);
            sb.append(", ");
            sb.append(str3);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "";
        }
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(valueOf) : new String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8455a);
        parcel.writeString(this.f8456b);
        int size = this.f8457c.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((Parcelable) this.f8457c.get(i2), 0);
        }
    }

    public C2970ph(String str, String str2, List list) {
        this.f8455a = str;
        this.f8456b = str2;
        this.f8457c = Collections.unmodifiableList(new ArrayList(list));
    }
}
