package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zza implements Parcelable.Creator<AdBreakClipInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ AdBreakClipInfo createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        VastAdsRequest vastAdsRequest = null;
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
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 10:
                    str8 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 11:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    str9 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    vastAdsRequest = (VastAdsRequest) SafeParcelReader.createParcelable(parcel, readHeader, VastAdsRequest.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new AdBreakClipInfo(str, str2, j, str3, str4, str5, str6, str7, str8, j2, str9, vastAdsRequest);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ AdBreakClipInfo[] newArray(int i) {
        return new AdBreakClipInfo[i];
    }
}
