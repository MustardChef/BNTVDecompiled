package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbo implements Parcelable.Creator<MediaError> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaError createFromParcel(Parcel parcel) {
        int readHeader;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        long j = 0;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        while (true) {
            long j2 = j;
            while (parcel.dataPosition() < validateObjectHeader) {
                readHeader = SafeParcelReader.readHeader(parcel);
                int fieldId = SafeParcelReader.getFieldId(readHeader);
                if (fieldId == 2) {
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                } else if (fieldId != 3) {
                    if (fieldId == 4) {
                        num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    } else if (fieldId == 5) {
                        str3 = SafeParcelReader.createString(parcel, readHeader);
                    } else if (fieldId == 6) {
                        str = SafeParcelReader.createString(parcel, readHeader);
                    } else {
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                    }
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
            return new MediaError(str2, j2, num, str3, CastUtils.jsonStringToJsonObject(str));
            j = SafeParcelReader.readLong(parcel, readHeader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaError[] newArray(int i) {
        return new MediaError[i];
    }
}
