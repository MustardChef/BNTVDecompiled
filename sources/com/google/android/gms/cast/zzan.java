package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzan implements Parcelable.Creator<zzam> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzam createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzak zzakVar = null;
        zzak zzakVar2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                zzakVar = (zzak) SafeParcelReader.createParcelable(parcel, readHeader, zzak.CREATOR);
            } else if (fieldId == 3) {
                zzakVar2 = (zzak) SafeParcelReader.createParcelable(parcel, readHeader, zzak.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzam(zzakVar, zzakVar2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzam[] newArray(int i) {
        return new zzam[i];
    }
}
