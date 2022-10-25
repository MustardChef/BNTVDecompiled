package androidx.core.p005os;

import android.os.Parcel;

/* renamed from: androidx.core.os.ParcelCompat */
/* loaded from: classes.dex */
public final class ParcelCompat {
    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    private ParcelCompat() {
    }
}
