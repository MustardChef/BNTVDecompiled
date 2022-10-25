package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aaa */
/* loaded from: classes2.dex */
public final class aaa implements InterfaceC2548aj {
    public static final Parcelable.Creator<aaa> CREATOR;

    /* renamed from: f */
    private static final C2962p f2871f;

    /* renamed from: g */
    private static final C2962p f2872g;

    /* renamed from: a */
    public final String f2873a;

    /* renamed from: b */
    public final String f2874b;

    /* renamed from: c */
    public final long f2875c;

    /* renamed from: d */
    public final long f2876d;

    /* renamed from: e */
    public final byte[] f2877e;

    /* renamed from: h */
    private int f2878h;

    static {
        C2935o c2935o = new C2935o();
        c2935o.m1532ae(MimeTypes.APPLICATION_ID3);
        f2871f = c2935o.m1506v();
        C2935o c2935o2 = new C2935o();
        c2935o2.m1532ae(MimeTypes.APPLICATION_SCTE35);
        f2872g = c2935o2.m1506v();
        CREATOR = new C3258zz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aaa(Parcel parcel) {
        String readString = parcel.readString();
        int i = C2628cq.f6961a;
        this.f2873a = readString;
        this.f2874b = parcel.readString();
        this.f2875c = parcel.readLong();
        this.f2876d = parcel.readLong();
        this.f2877e = (byte[]) C2628cq.m2578E(parcel.createByteArray());
    }

    public aaa(String str, String str2, long j, long j2, byte[] bArr) {
        this.f2873a = str;
        this.f2874b = str2;
        this.f2875c = j;
        this.f2876d = j2;
        this.f2877e = bArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2548aj
    /* renamed from: a */
    public final /* synthetic */ void mo1383a(C2545ag c2545ag) {
    }

    /* renamed from: b */
    public final C2962p m5982b() {
        char c;
        String str = this.f2873a;
        int hashCode = str.hashCode();
        if (hashCode == -1468477611) {
            if (str.equals(EventMessage.SCTE35_SCHEME_ID)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != -795945609) {
            if (hashCode == 1303648457 && str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals(EventMessage.ID3_SCHEME_ID_AOM)) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0 || c == 1) {
            return f2871f;
        }
        if (c != 2) {
            return null;
        }
        return f2872g;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aaa aaaVar = (aaa) obj;
            if (this.f2875c == aaaVar.f2875c && this.f2876d == aaaVar.f2876d && C2628cq.m2563T(this.f2873a, aaaVar.f2873a) && C2628cq.m2563T(this.f2874b, aaaVar.f2874b) && Arrays.equals(this.f2877e, aaaVar.f2877e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2878h;
        if (i == 0) {
            String str = this.f2873a;
            int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            String str2 = this.f2874b;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.f2875c;
            long j2 = this.f2876d;
            int hashCode3 = ((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + Arrays.hashCode(this.f2877e);
            this.f2878h = hashCode3;
            return hashCode3;
        }
        return i;
    }

    public final String toString() {
        String str = this.f2873a;
        long j = this.f2876d;
        long j2 = this.f2875c;
        String str2 = this.f2874b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j);
        sb.append(", durationMs=");
        sb.append(j2);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2873a);
        parcel.writeString(this.f2874b);
        parcel.writeLong(this.f2875c);
        parcel.writeLong(this.f2876d);
        parcel.writeByteArray(this.f2877e);
    }
}
