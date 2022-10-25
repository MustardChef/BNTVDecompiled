package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asl */
/* loaded from: classes2.dex */
public final class asl implements Parcelable.Creator {

    /* renamed from: a */
    private final /* synthetic */ int f4992a;

    public asl(int i) {
        this.f4992a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        int i2 = this.f4992a;
        if (i2 != 0) {
            if (i2 != 1) {
                return i2 != 2 ? new ass[i] : new asr[i];
            }
            return new asj[i];
        }
        return new ask[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = this.f4992a;
        byte[] bArr = null;
        byte[] bArr2 = null;
        String str = null;
        int i2 = 0;
        if (i == 0) {
            int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
            while (parcel.dataPosition() < validateObjectHeader) {
                int readHeader = SafeParcelReader.readHeader(parcel);
                int fieldId = SafeParcelReader.getFieldId(readHeader);
                if (fieldId == 1) {
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                } else if (fieldId == 2) {
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                } else {
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
            return new ask(i2, bArr);
        } else if (i == 1) {
            int validateObjectHeader2 = SafeParcelReader.validateObjectHeader(parcel);
            String str2 = null;
            int i3 = 0;
            while (parcel.dataPosition() < validateObjectHeader2) {
                int readHeader2 = SafeParcelReader.readHeader(parcel);
                int fieldId2 = SafeParcelReader.getFieldId(readHeader2);
                if (fieldId2 == 1) {
                    i3 = SafeParcelReader.readInt(parcel, readHeader2);
                } else if (fieldId2 == 2) {
                    str = SafeParcelReader.createString(parcel, readHeader2);
                } else if (fieldId2 == 3) {
                    str2 = SafeParcelReader.createString(parcel, readHeader2);
                } else {
                    SafeParcelReader.skipUnknownField(parcel, readHeader2);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader2);
            return new asj(i3, str, str2);
        } else if (i == 2) {
            int validateObjectHeader3 = SafeParcelReader.validateObjectHeader(parcel);
            String str3 = null;
            String str4 = null;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (parcel.dataPosition() < validateObjectHeader3) {
                int readHeader3 = SafeParcelReader.readHeader(parcel);
                int fieldId3 = SafeParcelReader.getFieldId(readHeader3);
                if (fieldId3 == 1) {
                    i4 = SafeParcelReader.readInt(parcel, readHeader3);
                } else if (fieldId3 == 2) {
                    i5 = SafeParcelReader.readInt(parcel, readHeader3);
                } else if (fieldId3 == 3) {
                    str3 = SafeParcelReader.createString(parcel, readHeader3);
                } else if (fieldId3 == 4) {
                    str4 = SafeParcelReader.createString(parcel, readHeader3);
                } else if (fieldId3 == 5) {
                    i6 = SafeParcelReader.readInt(parcel, readHeader3);
                } else {
                    SafeParcelReader.skipUnknownField(parcel, readHeader3);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader3);
            return new asr(i4, i5, i6, str3, str4);
        } else {
            int validateObjectHeader4 = SafeParcelReader.validateObjectHeader(parcel);
            int i7 = 0;
            while (parcel.dataPosition() < validateObjectHeader4) {
                int readHeader4 = SafeParcelReader.readHeader(parcel);
                int fieldId4 = SafeParcelReader.getFieldId(readHeader4);
                if (fieldId4 == 1) {
                    i2 = SafeParcelReader.readInt(parcel, readHeader4);
                } else if (fieldId4 == 2) {
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader4);
                } else if (fieldId4 == 3) {
                    i7 = SafeParcelReader.readInt(parcel, readHeader4);
                } else {
                    SafeParcelReader.skipUnknownField(parcel, readHeader4);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader4);
            return new ass(i2, bArr2, i7);
        }
    }
}
