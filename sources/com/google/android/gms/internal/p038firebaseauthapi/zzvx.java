package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvx */
/* loaded from: classes3.dex */
public final class zzvx extends AbstractSafeParcelable implements zztz<zzvx> {
    public static final Parcelable.Creator<zzvx> CREATOR = new zzvy();
    private static final String zza = "zzvx";
    private zzwb zzb;

    public zzvx() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzvx zza(String str) throws zzpp {
        zzwb zzwbVar;
        int i;
        zzvz zzvzVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("users")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                Parcelable.Creator<zzwb> creator = zzwb.CREATOR;
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        if (jSONObject2 == null) {
                            zzvzVar = new zzvz();
                            i = i2;
                        } else {
                            i = i2;
                            zzvzVar = new zzvz(Strings.emptyToNull(jSONObject2.optString("localId", null)), Strings.emptyToNull(jSONObject2.optString("email", null)), jSONObject2.optBoolean("emailVerified", z), Strings.emptyToNull(jSONObject2.optString("displayName", null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", null)), zzwo.zzc(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", null)), Strings.emptyToNull(jSONObject2.optString("phoneNumber", null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzwk.zzf(jSONObject2.optJSONArray("mfaInfo")));
                        }
                        arrayList.add(zzvzVar);
                        i2 = i + 1;
                        z = false;
                    }
                    zzwbVar = new zzwb(arrayList);
                }
                zzwbVar = new zzwb(new ArrayList());
            } else {
                zzwbVar = new zzwb();
            }
            this.zzb = zzwbVar;
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final List<zzvz> zzb() {
        return this.zzb.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvx(zzwb zzwbVar) {
        zzwb zzb;
        if (zzwbVar != null) {
            zzb = zzwb.zzb(zzwbVar);
        } else {
            zzb = new zzwb();
        }
        this.zzb = zzb;
    }
}
