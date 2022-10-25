package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ara */
/* loaded from: classes2.dex */
public final class ara implements Parcelable.Creator {

    /* renamed from: a */
    private final /* synthetic */ int f4923a;

    public ara(int i) {
        this.f4923a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return this.f4923a != 0 ? new aqy[i] : new aqz[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        if (this.f4923a == 0) {
            int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
            while (parcel.dataPosition() < validateObjectHeader) {
                int readHeader = SafeParcelReader.readHeader(parcel);
                if (SafeParcelReader.getFieldId(readHeader) == 1) {
                    str = SafeParcelReader.createString(parcel, readHeader);
                } else {
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
            return new aqz(str);
        }
        int validateObjectHeader2 = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        String str2 = "";
        while (parcel.dataPosition() < validateObjectHeader2) {
            int readHeader2 = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader2);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader2);
            } else if (fieldId == 2) {
                i = SafeParcelReader.readInt(parcel, readHeader2);
            } else if (fieldId == 3) {
                str2 = SafeParcelReader.createString(parcel, readHeader2);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader2);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader2);
        return new aqy(str, i, str2);
    }
}
