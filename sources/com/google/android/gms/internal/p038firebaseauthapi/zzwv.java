package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwv */
/* loaded from: classes3.dex */
public final class zzwv implements zztz<zzwv> {
    private static final String zza = "zzwv";
    private String zzb;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzwv zza(String str) throws zzpp {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("sessionInfo", null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
