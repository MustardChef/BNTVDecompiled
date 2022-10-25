package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ass */
/* loaded from: classes2.dex */
public final class ass extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ass> CREATOR = new asl(3);

    /* renamed from: a */
    public final int f5011a;

    /* renamed from: b */
    public final byte[] f5012b;

    /* renamed from: c */
    public final int f5013c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ass(int i, byte[] bArr, int i2) {
        this.f5011a = i;
        this.f5012b = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.f5013c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f5011a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f5012b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f5013c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ass() {
        this(1, null, 1);
    }
}
