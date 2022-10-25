package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.k */
/* loaded from: classes2.dex */
public final class C2827k implements Parcelable {
    public static final Parcelable.Creator<C2827k> CREATOR = new C2800j(0);

    /* renamed from: a */
    public final UUID f7780a;

    /* renamed from: b */
    public final String f7781b;

    /* renamed from: c */
    public final String f7782c;

    /* renamed from: d */
    public final byte[] f7783d;

    /* renamed from: e */
    private int f7784e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2827k(Parcel parcel) {
        this.f7780a = new UUID(parcel.readLong(), parcel.readLong());
        this.f7781b = parcel.readString();
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f7782c = readString;
        this.f7783d = parcel.createByteArray();
    }

    /* renamed from: a */
    public final C2827k m1840a(byte[] bArr) {
        return new C2827k(this.f7780a, this.f7781b, this.f7782c, bArr);
    }

    /* renamed from: b */
    public final boolean m1839b() {
        return this.f7783d != null;
    }

    /* renamed from: c */
    public final boolean m1838c(UUID uuid) {
        return C2692f.f7207a.equals(this.f7780a) || uuid.equals(this.f7780a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C2827k) {
            if (obj == this) {
                return true;
            }
            C2827k c2827k = (C2827k) obj;
            return C2628cq.m2563T(this.f7781b, c2827k.f7781b) && C2628cq.m2563T(this.f7782c, c2827k.f7782c) && C2628cq.m2563T(this.f7780a, c2827k.f7780a) && Arrays.equals(this.f7783d, c2827k.f7783d);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f7784e;
        if (i == 0) {
            int hashCode = this.f7780a.hashCode() * 31;
            String str = this.f7781b;
            int hashCode2 = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f7782c.hashCode()) * 31) + Arrays.hashCode(this.f7783d);
            this.f7784e = hashCode2;
            return hashCode2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7780a.getMostSignificantBits());
        parcel.writeLong(this.f7780a.getLeastSignificantBits());
        parcel.writeString(this.f7781b);
        parcel.writeString(this.f7782c);
        parcel.writeByteArray(this.f7783d);
    }

    public C2827k(UUID uuid, String str, String str2, byte[] bArr) {
        C2616ce.m2689d(uuid);
        this.f7780a = uuid;
        this.f7781b = str;
        C2616ce.m2689d(str2);
        this.f7782c = str2;
        this.f7783d = bArr;
    }

    public C2827k(UUID uuid, String str, byte[] bArr) {
        this(uuid, null, str, bArr);
    }
}
