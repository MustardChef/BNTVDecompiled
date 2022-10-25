package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ask */
/* loaded from: classes2.dex */
public final class ask extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ask> CREATOR = new asl(0);

    /* renamed from: a */
    public final int f4989a;

    /* renamed from: b */
    private afr f4990b = null;

    /* renamed from: c */
    private byte[] f4991c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ask(int i, byte[] bArr) {
        this.f4989a = i;
        this.f4991c = bArr;
        m4687b();
    }

    /* renamed from: a */
    public final afr m4688a() {
        if (this.f4990b == null) {
            try {
                this.f4990b = afr.m5555c(this.f4991c, bmr.m3341a());
                this.f4991c = null;
            } catch (bnm | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        m4687b();
        return this.f4990b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f4989a);
        byte[] bArr = this.f4991c;
        if (bArr == null) {
            bArr = this.f4990b.mo3176ar();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* renamed from: b */
    private final void m4687b() {
        afr afrVar = this.f4990b;
        if (afrVar != null || this.f4991c == null) {
            if (afrVar == null || this.f4991c != null) {
                if (afrVar == null || this.f4991c == null) {
                    if (afrVar != null || this.f4991c != null) {
                        throw new IllegalStateException("Impossible");
                    }
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Invalid internal representation - full");
            }
        }
    }
}
