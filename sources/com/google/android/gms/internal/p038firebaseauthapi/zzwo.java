package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo */
/* loaded from: classes3.dex */
public final class zzwo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwo> CREATOR = new zzwp();
    private final List<zzwm> zza;

    public zzwo() {
        this.zza = new ArrayList();
    }

    public static zzwo zzb(zzwo zzwoVar) {
        List<zzwm> list = zzwoVar.zza;
        zzwo zzwoVar2 = new zzwo();
        if (list != null) {
            zzwoVar2.zza.addAll(list);
        }
        return zzwoVar2;
    }

    public static zzwo zzc(JSONArray jSONArray) throws JSONException {
        zzwm zzwmVar;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzwo(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                zzwmVar = new zzwm(Strings.emptyToNull(jSONObject.optString("federatedId", null)), Strings.emptyToNull(jSONObject.optString("displayName", null)), Strings.emptyToNull(jSONObject.optString("photoUrl", null)), Strings.emptyToNull(jSONObject.optString("providerId", null)), null, Strings.emptyToNull(jSONObject.optString("phoneNumber", null)), Strings.emptyToNull(jSONObject.optString("email", null)));
            } else {
                zzwmVar = new zzwm();
            }
            arrayList.add(zzwmVar);
        }
        return new zzwo(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzwm> zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwo(List<zzwm> list) {
        if (list == null || list.isEmpty()) {
            this.zza = Collections.emptyList();
        } else {
            this.zza = Collections.unmodifiableList(list);
        }
    }
}
