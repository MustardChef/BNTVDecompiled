package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbx implements Parcelable.Creator<MediaQueueContainerMetadata> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaQueueContainerMetadata createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        double d = 0.0d;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 4) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, MediaMetadata.CREATOR);
            } else if (fieldId == 5) {
                arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, WebImage.CREATOR);
            } else if (fieldId == 6) {
                d = SafeParcelReader.readDouble(parcel, readHeader);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MediaQueueContainerMetadata(i, str, arrayList, arrayList2, d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaQueueContainerMetadata[] newArray(int i) {
        return new MediaQueueContainerMetadata[i];
    }
}
