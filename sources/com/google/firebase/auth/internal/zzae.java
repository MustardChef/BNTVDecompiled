package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzae extends MultiFactorResolver {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    private final List<PhoneMultiFactorInfo> zza = new ArrayList();
    private final zzag zzb;
    private final String zzc;
    private final com.google.firebase.auth.zze zzd;
    private final zzx zze;

    public zzae(List<PhoneMultiFactorInfo> list, zzag zzagVar, String str, com.google.firebase.auth.zze zzeVar, zzx zzxVar) {
        for (PhoneMultiFactorInfo phoneMultiFactorInfo : list) {
            if (phoneMultiFactorInfo instanceof PhoneMultiFactorInfo) {
                this.zza.add(phoneMultiFactorInfo);
            }
        }
        this.zzb = (zzag) Preconditions.checkNotNull(zzagVar);
        this.zzc = Preconditions.checkNotEmpty(str);
        this.zzd = zzeVar;
        this.zze = zzxVar;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo phoneMultiFactorInfo : this.zza) {
            arrayList.add(phoneMultiFactorInfo);
        }
        return arrayList;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc)).zzv(multiFactorAssertion, this.zzb, this.zze).continueWithTask(new zzad(this));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
