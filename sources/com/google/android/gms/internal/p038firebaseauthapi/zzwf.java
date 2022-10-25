package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwf */
/* loaded from: classes3.dex */
public final class zzwf implements zztz<zzwf> {
    private static final String zza = "zzwf";
    private List<String> zzb;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzwf zza(String str) throws zzpp {
        zzc(str);
        return this;
    }

    public final List<String> zzb() {
        return this.zzb;
    }

    public final zzwf zzc(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.zzb.add(optJSONArray.getString(i));
                }
            }
            return this;
        } catch (JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }
}
