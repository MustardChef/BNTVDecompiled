package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvj */
/* loaded from: classes3.dex */
public final class zzvj implements zztz<zzvj> {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzvj";
    private String zzb;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzvj zza(String str) throws zzpp {
        zzd(str);
        return this;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }

    public final String zzc() {
        return this.zzb;
    }

    public final zzvj zzd(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e) {
            String str2 = zza;
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 52 + String.valueOf(message).length());
            sb.append("Failed to parse error for string [");
            sb.append(str);
            sb.append("] with exception: ");
            sb.append(message);
            Log.e(str2, sb.toString());
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 35);
            sb2.append("Failed to parse error for string [");
            sb2.append(str);
            sb2.append("]");
            throw new zzpp(sb2.toString(), e);
        }
    }
}
