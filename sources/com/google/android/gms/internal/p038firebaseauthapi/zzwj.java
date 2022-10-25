package com.google.android.gms.internal.p038firebaseauthapi;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwj */
/* loaded from: classes3.dex */
public final class zzwj {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;

    public static zzwj zzc(String str) throws UnsupportedEncodingException {
        try {
            zzwj zzwjVar = new zzwj();
            JSONObject jSONObject = new JSONObject(str);
            zzwjVar.zza = jSONObject.optString("iss");
            zzwjVar.zzb = jSONObject.optString("aud");
            zzwjVar.zzc = jSONObject.optString("sub");
            zzwjVar.zzd = Long.valueOf(jSONObject.optLong("iat"));
            zzwjVar.zze = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return zzwjVar;
        } catch (JSONException e) {
            if (Log.isLoggable("JwtToken", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 41);
                sb.append("Failed to read JwtToken from JSONObject. ");
                sb.append(valueOf);
                Log.d("JwtToken", sb.toString());
            }
            String valueOf2 = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 41);
            sb2.append("Failed to read JwtToken from JSONObject. ");
            sb2.append(valueOf2);
            throw new UnsupportedEncodingException(sb2.toString());
        }
    }

    public final Long zza() {
        return this.zzd;
    }

    public final Long zzb() {
        return this.zze;
    }
}
