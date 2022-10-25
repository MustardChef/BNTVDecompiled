package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzag extends MultiFactorSession {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    private String zza;
    private String zzb;
    private List<PhoneMultiFactorInfo> zzc;

    private zzag() {
    }

    public static zzag zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzag zzagVar = new zzag();
        zzagVar.zza = str;
        return zzagVar;
    }

    public static zzag zzb(List<MultiFactorInfo> list, String str) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotEmpty(str);
        zzag zzagVar = new zzag();
        zzagVar.zzc = new ArrayList();
        for (MultiFactorInfo multiFactorInfo : list) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzagVar.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            }
        }
        zzagVar.zzb = str;
        return zzagVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zza != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(String str, String str2, List<PhoneMultiFactorInfo> list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
    }
}
