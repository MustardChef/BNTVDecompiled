package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.l */
/* loaded from: classes2.dex */
public final class C2854l implements Comparator<C2827k>, Parcelable {
    public static final Parcelable.Creator<C2854l> CREATOR = new C2800j(1);

    /* renamed from: a */
    public final String f7955a;

    /* renamed from: b */
    public final int f7956b;

    /* renamed from: c */
    private final C2827k[] f7957c;

    /* renamed from: d */
    private int f7958d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2854l(Parcel parcel) {
        this.f7955a = parcel.readString();
        C2827k[] c2827kArr = (C2827k[]) C2628cq.m2578E((C2827k[]) parcel.createTypedArray(C2827k.CREATOR));
        this.f7957c = c2827kArr;
        this.f7956b = c2827kArr.length;
    }

    /* renamed from: c */
    public static C2854l m1734c(C2854l c2854l, C2854l c2854l2) {
        String str;
        C2827k[] c2827kArr;
        C2827k[] c2827kArr2;
        ArrayList arrayList = new ArrayList();
        if (c2854l != null) {
            str = c2854l.f7955a;
            for (C2827k c2827k : c2854l.f7957c) {
                if (c2827k.m1839b()) {
                    arrayList.add(c2827k);
                }
            }
        } else {
            str = null;
        }
        if (c2854l2 != null) {
            if (str == null) {
                str = c2854l2.f7955a;
            }
            int size = arrayList.size();
            for (C2827k c2827k2 : c2854l2.f7957c) {
                if (c2827k2.m1839b()) {
                    UUID uuid = c2827k2.f7780a;
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (((C2827k) arrayList.get(i)).f7780a.equals(uuid)) {
                                break;
                            }
                            i++;
                        } else {
                            arrayList.add(c2827k2);
                            break;
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C2854l(str, arrayList);
    }

    /* renamed from: a */
    public final C2827k m1736a(int i) {
        return this.f7957c[i];
    }

    /* renamed from: b */
    public final C2854l m1735b(String str) {
        return C2628cq.m2563T(this.f7955a, str) ? this : new C2854l(str, false, this.f7957c);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(C2827k c2827k, C2827k c2827k2) {
        C2827k c2827k3 = c2827k;
        C2827k c2827k4 = c2827k2;
        if (C2692f.f7207a.equals(c2827k3.f7780a)) {
            return !C2692f.f7207a.equals(c2827k4.f7780a) ? 1 : 0;
        }
        return c2827k3.f7780a.compareTo(c2827k4.f7780a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2854l c2854l = (C2854l) obj;
            if (C2628cq.m2563T(this.f7955a, c2854l.f7955a) && Arrays.equals(this.f7957c, c2854l.f7957c)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7955a);
        parcel.writeTypedArray(this.f7957c, 0);
    }

    public final int hashCode() {
        int i = this.f7958d;
        if (i == 0) {
            String str = this.f7955a;
            int hashCode = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f7957c);
            this.f7958d = hashCode;
            return hashCode;
        }
        return i;
    }

    public C2854l(String str, List list) {
        this(str, false, (C2827k[]) list.toArray(new C2827k[0]));
    }

    private C2854l(String str, boolean z, C2827k... c2827kArr) {
        this.f7955a = str;
        c2827kArr = z ? (C2827k[]) c2827kArr.clone() : c2827kArr;
        this.f7957c = c2827kArr;
        this.f7956b = c2827kArr.length;
        Arrays.sort(c2827kArr, this);
    }

    public C2854l(String str, C2827k... c2827kArr) {
        this(str, true, c2827kArr);
    }

    public C2854l(List list) {
        this(null, false, (C2827k[]) list.toArray(new C2827k[0]));
    }
}
