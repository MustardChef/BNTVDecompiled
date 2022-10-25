package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe */
/* loaded from: classes3.dex */
public final class zzxe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxe> CREATOR = new zzxf();
    public final int zza;
    private List<String> zzb;

    public zzxe() {
        this(null);
    }

    public static zzxe zzb(zzxe zzxeVar) {
        return new zzxe(zzxeVar.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<String> zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxe(int i, List<String> list) {
        this.zza = i;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, Strings.emptyToNull(list.get(i2)));
            }
            this.zzb = Collections.unmodifiableList(list);
            return;
        }
        this.zzb = Collections.emptyList();
    }

    public zzxe(List<String> list) {
        this.zza = 1;
        this.zzb = new ArrayList();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzb.addAll(list);
    }
}
