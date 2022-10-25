package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzdi implements Parcelable.Creator<SessionState> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SessionState createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaLoadRequestData mediaLoadRequestData = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                mediaLoadRequestData = (MediaLoadRequestData) SafeParcelReader.createParcelable(parcel, readHeader, MediaLoadRequestData.CREATOR);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SessionState(mediaLoadRequestData, CastUtils.jsonStringToJsonObject(str));
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SessionState[] newArray(int i) {
        return new SessionState[i];
    }
}
