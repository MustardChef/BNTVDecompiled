package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn */
/* loaded from: classes3.dex */
public final class zzxn implements zztz<zzxn> {
    private static final String zza = "zzxn";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private List<zzwk> zzi;
    private String zzj;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("localId", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("email", null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("displayName", null));
            this.zze = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzf = Strings.emptyToNull(jSONObject.optString("photoUrl", null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzh = jSONObject.optLong("expiresIn", 0L);
            this.zzi = zzwk.zzf(jSONObject.optJSONArray("mfaInfo"));
            this.zzj = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final List<zzwk> zze() {
        return this.zzi;
    }

    public final String zzf() {
        return this.zzj;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzj);
    }
}
