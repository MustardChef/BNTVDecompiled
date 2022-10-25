package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aak */
/* loaded from: classes2.dex */
public final class aak extends aaq {
    public static final Parcelable.Creator<aak> CREATOR = new aag(4);

    /* renamed from: a */
    public final String f2904a;

    /* renamed from: b */
    public final String f2905b;

    /* renamed from: c */
    public final String f2906c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aak(Parcel parcel) {
        super(CommentFrame.f9674ID);
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2904a = readString;
        this.f2905b = parcel.readString();
        this.f2906c = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aak aakVar = (aak) obj;
            if (C2628cq.m2563T(this.f2905b, aakVar.f2905b) && C2628cq.m2563T(this.f2904a, aakVar.f2904a) && C2628cq.m2563T(this.f2906c, aakVar.f2906c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2904a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f2905b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2906c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aaq
    public final String toString() {
        String str = this.f2917f;
        String str2 = this.f2904a;
        String str3 = this.f2905b;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": language=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2917f);
        parcel.writeString(this.f2904a);
        parcel.writeString(this.f2906c);
    }

    public aak(String str, String str2, String str3) {
        super(CommentFrame.f9674ID);
        this.f2904a = str;
        this.f2905b = str2;
        this.f2906c = str3;
    }
}
