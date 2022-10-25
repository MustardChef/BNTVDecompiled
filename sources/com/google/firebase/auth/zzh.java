package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzh implements Parcelable.Creator<FacebookAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ FacebookAuthCredential createFromParcel(Parcel parcel) {
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
        return new FacebookAuthCredential(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ FacebookAuthCredential[] newArray(int i) {
        return new FacebookAuthCredential[i];
    }
}
