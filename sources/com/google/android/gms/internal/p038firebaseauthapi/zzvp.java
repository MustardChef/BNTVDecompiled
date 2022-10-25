package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvp */
/* loaded from: classes3.dex */
public final class zzvp implements zztz<zzvp> {
    private static final String zza = "zzvp";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private long zzg;
    private List<zzwk> zzh;
    private String zzi;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzvp zza(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("localId", null);
            this.zzc = jSONObject.optString("email", null);
            this.zzd = jSONObject.optString("idToken", null);
            this.zze = jSONObject.optString("refreshToken", null);
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = jSONObject.optLong("expiresIn", 0L);
            this.zzh = zzwk.zzf(jSONObject.optJSONArray("mfaInfo"));
            this.zzi = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return this.zzf;
    }

    public final long zze() {
        return this.zzg;
    }

    public final List<zzwk> zzf() {
        return this.zzh;
    }

    public final String zzg() {
        return this.zzi;
    }

    public final boolean zzh() {
        return !TextUtils.isEmpty(this.zzi);
    }
}
