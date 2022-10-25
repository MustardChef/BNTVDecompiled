package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzr implements Parcelable.Creator<CastDevice> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ CastDevice createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        ArrayList arrayList = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        byte[] bArr = null;
        String str9 = null;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 10:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 11:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 12:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    str8 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 15:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 16:
                    str9 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 17:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new CastDevice(str, str2, str3, str4, str5, i, arrayList, i2, i3, str6, str7, i4, str8, bArr, str9, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ CastDevice[] newArray(int i) {
        return new CastDevice[i];
    }
}
