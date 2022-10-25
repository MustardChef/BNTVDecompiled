package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbp implements Parcelable.Creator<MediaInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaInfo createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        MediaMetadata mediaMetadata = null;
        ArrayList arrayList = null;
        TextTrackStyle textTrackStyle = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str4 = null;
        VastAdsRequest vastAdsRequest = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    mediaMetadata = (MediaMetadata) SafeParcelReader.createParcelable(parcel, readHeader, MediaMetadata.CREATOR);
                    break;
                case 6:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 7:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, MediaTrack.CREATOR);
                    break;
                case 8:
                    textTrackStyle = (TextTrackStyle) SafeParcelReader.createParcelable(parcel, readHeader, TextTrackStyle.CREATOR);
                    break;
                case 9:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 10:
                    arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, AdBreakInfo.CREATOR);
                    break;
                case 11:
                    arrayList3 = SafeParcelReader.createTypedList(parcel, readHeader, AdBreakClipInfo.CREATOR);
                    break;
                case 12:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    vastAdsRequest = (VastAdsRequest) SafeParcelReader.createParcelable(parcel, readHeader, VastAdsRequest.CREATOR);
                    break;
                case 14:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 15:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 16:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 17:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 18:
                    str8 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MediaInfo(str, i, str2, mediaMetadata, j, arrayList, textTrackStyle, str3, arrayList2, arrayList3, str4, vastAdsRequest, j2, str5, str6, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MediaInfo[] newArray(int i) {
        return new MediaInfo[i];
    }
}
