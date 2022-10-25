package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aag */
/* loaded from: classes2.dex */
final class aag implements Parcelable.Creator {

    /* renamed from: a */
    private final /* synthetic */ int f2891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aag(int i) {
        this.f2891a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        switch (this.f2891a) {
            case 0:
                return new aah(parcel);
            case 1:
                return new aaf(parcel);
            case 2:
                return new aai(parcel);
            case 3:
                return new aaj(parcel);
            case 4:
                return new aak(parcel);
            case 5:
                return new aal(parcel);
            case 6:
                return new aar(parcel);
            case 7:
                return new aas(parcel);
            case 8:
                return new aat(parcel);
            case 9:
                return new aau(parcel);
            default:
                return new aav(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f2891a) {
            case 0:
                return new aah[i];
            case 1:
                return new aaf[i];
            case 2:
                return new aai[i];
            case 3:
                return new aaj[i];
            case 4:
                return new aak[i];
            case 5:
                return new aal[i];
            case 6:
                return new aar[i];
            case 7:
                return new aas[i];
            case 8:
                return new aat[i];
            case 9:
                return new aau[i];
            default:
                return new aav[i];
        }
    }
}
