package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn */
/* loaded from: classes3.dex */
public final class zzmn implements Parcelable.Creator<zzmm> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzmm createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzmm(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzmm[] newArray(int i) {
        return new zzmm[i];
    }
}
