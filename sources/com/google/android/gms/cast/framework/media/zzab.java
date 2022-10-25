package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzab implements Parcelable.Creator<NotificationOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ NotificationOptions createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<String> arrayList = null;
        int[] iArr = null;
        String str = null;
        IBinder iBinder = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 3:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 4:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 10:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 11:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 12:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    i9 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    i10 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 18:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 19:
                    i14 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 20:
                    i15 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 21:
                    i16 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 22:
                    i17 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 23:
                    i18 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 24:
                    i19 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 25:
                    i20 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 26:
                    i21 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 27:
                    i22 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 28:
                    i23 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 29:
                    i24 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 30:
                    i25 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 31:
                    i26 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 32:
                    i27 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 33:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new NotificationOptions(arrayList, iArr, j, str, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ NotificationOptions[] newArray(int i) {
        return new NotificationOptions[i];
    }
}
