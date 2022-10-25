package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p038firebaseauthapi.zzwg;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    private zzwg zza;
    private zzt zzb;
    private final String zzc;
    private String zzd;
    private List<zzt> zze;
    private List<String> zzf;
    private String zzg;
    private Boolean zzh;
    private zzz zzi;
    private boolean zzj;
    private com.google.firebase.auth.zze zzk;
    private zzbb zzl;

    public zzx(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = ExifInterface.GPS_MEASUREMENT_2D;
        zzb(list);
    }

    public static FirebaseUser zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzxVar = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzxVar2 = (zzx) firebaseUser;
            zzxVar.zzg = zzxVar2.zzg;
            zzxVar.zzd = zzxVar2.zzd;
            zzxVar.zzi = zzxVar2.zzi;
        } else {
            zzxVar.zzi = null;
        }
        if (firebaseUser.zze() != null) {
            zzxVar.zzf(firebaseUser.zze());
        }
        if (!firebaseUser.isAnonymous()) {
            zzxVar.zzj();
        }
        return zzxVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzb.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* bridge */ /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getTenantId() {
        Map map;
        zzwg zzwgVar = this.zza;
        if (zzwgVar == null || zzwgVar.zze() == null || (map = (Map) zzay.zza(this.zza.zze()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID)) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zzb.getUid();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean isAnonymous() {
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzwg zzwgVar = this.zza;
            String signInProvider = zzwgVar != null ? zzay.zza(zzwgVar.zze()).getSignInProvider() : "";
            boolean z = false;
            if (this.zze.size() <= 1 && (signInProvider == null || !signInProvider.equals("custom"))) {
                z = true;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<String> zza() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUser zzb(List<? extends UserInfo> list) {
        Preconditions.checkNotNull(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzb = (zzt) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzt) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = this.zze.get(0);
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* bridge */ /* synthetic */ FirebaseUser zzc() {
        zzj();
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp zzd() {
        return FirebaseApp.getInstance(this.zzc);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zzwg zze() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzf(zzwg zzwgVar) {
        this.zza = (zzwg) Preconditions.checkNotNull(zzwgVar);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzg() {
        return this.zza.zzi();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzh() {
        return this.zza.zze();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzi(List<MultiFactorInfo> list) {
        Parcelable.Creator<zzbb> creator = zzbb.CREATOR;
        zzbb zzbbVar = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (MultiFactorInfo multiFactorInfo : list) {
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                }
            }
            zzbbVar = new zzbb(arrayList);
        }
        this.zzl = zzbbVar;
    }

    public final zzx zzj() {
        this.zzh = false;
        return this;
    }

    public final zzx zzk(String str) {
        this.zzg = str;
        return this;
    }

    public final List<zzt> zzl() {
        return this.zze;
    }

    public final void zzm(zzz zzzVar) {
        this.zzi = zzzVar;
    }

    public final void zzn(boolean z) {
        this.zzj = z;
    }

    public final boolean zzo() {
        return this.zzj;
    }

    public final void zzp(com.google.firebase.auth.zze zzeVar) {
        this.zzk = zzeVar;
    }

    public final com.google.firebase.auth.zze zzq() {
        return this.zzk;
    }

    public final List<MultiFactorInfo> zzr() {
        zzbb zzbbVar = this.zzl;
        if (zzbbVar != null) {
            return zzbbVar.zza();
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzwg zzwgVar, zzt zztVar, String str, String str2, List<zzt> list, List<String> list2, String str3, Boolean bool, zzz zzzVar, boolean z, com.google.firebase.auth.zze zzeVar, zzbb zzbbVar) {
        this.zza = zzwgVar;
        this.zzb = zztVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzzVar;
        this.zzj = z;
        this.zzk = zzeVar;
        this.zzl = zzbbVar;
    }
}
