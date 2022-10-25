package com.google.android.gms.internal.p038firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvr */
/* loaded from: classes3.dex */
public final class zzvr implements zztz<zzvr> {
    private static final String zza = "zzvr";
    private String zzb;
    private String zzc;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzvr zza(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("idToken", null);
            this.zzc = jSONObject.optString("refreshToken", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }
}
