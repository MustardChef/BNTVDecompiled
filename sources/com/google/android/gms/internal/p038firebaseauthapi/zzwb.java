package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb */
/* loaded from: classes3.dex */
public final class zzwb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwb> CREATOR = new zzwc();
    private final List<zzvz> zza;

    public zzwb() {
        this.zza = new ArrayList();
    }

    public static zzwb zzb(zzwb zzwbVar) {
        Preconditions.checkNotNull(zzwbVar);
        List<zzvz> list = zzwbVar.zza;
        zzwb zzwbVar2 = new zzwb();
        if (list != null && !list.isEmpty()) {
            zzwbVar2.zza.addAll(list);
        }
        return zzwbVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzvz> zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwb(List<zzvz> list) {
        List<zzvz> unmodifiableList;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.zza = unmodifiableList;
    }
}
