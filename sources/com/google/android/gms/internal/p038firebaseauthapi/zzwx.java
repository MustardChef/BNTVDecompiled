package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx */
/* loaded from: classes3.dex */
public final class zzwx implements zztz<zzwx> {
    private static final String zza = "zzwx";
    private String zzb;
    private String zzc;
    private Boolean zzd;
    private String zze;
    private String zzf;
    private zzwo zzg;
    private String zzh;
    private String zzi;
    private long zzj;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzwx zza(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("email", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("passwordHash", null));
            this.zzd = Boolean.valueOf(jSONObject.optBoolean("emailVerified", false));
            this.zze = Strings.emptyToNull(jSONObject.optString("displayName", null));
            this.zzf = Strings.emptyToNull(jSONObject.optString("photoUrl", null));
            this.zzg = zzwo.zzc(jSONObject.optJSONArray("providerUserInfo"));
            this.zzh = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzi = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzj = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzj;
    }

    public final String zze() {
        return this.zzb;
    }

    public final List<zzwm> zzf() {
        zzwo zzwoVar = this.zzg;
        if (zzwoVar != null) {
            return zzwoVar.zza();
        }
        return null;
    }
}
