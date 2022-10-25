package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zze;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxi */
/* loaded from: classes3.dex */
public final class zzxi implements zztz<zzxi> {
    private static final String zza = "zzxi";
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private boolean zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private List<zzwk> zzs;
    private String zzt;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzxi zza(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optBoolean("needConfirmation", false);
            jSONObject.optBoolean("needEmail", false);
            this.zzc = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zze = jSONObject.optLong("expiresIn", 0L);
            this.zzf = Strings.emptyToNull(jSONObject.optString("localId", null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("email", null));
            this.zzh = Strings.emptyToNull(jSONObject.optString("displayName", null));
            this.zzi = Strings.emptyToNull(jSONObject.optString("photoUrl", null));
            this.zzj = Strings.emptyToNull(jSONObject.optString("providerId", null));
            this.zzk = Strings.emptyToNull(jSONObject.optString("rawUserInfo", null));
            this.zzl = jSONObject.optBoolean("isNewUser", false);
            this.zzm = jSONObject.optString("oauthAccessToken", null);
            this.zzn = jSONObject.optString("oauthIdToken", null);
            this.zzp = Strings.emptyToNull(jSONObject.optString("errorMessage", null));
            this.zzq = Strings.emptyToNull(jSONObject.optString("pendingToken", null));
            this.zzr = Strings.emptyToNull(jSONObject.optString("tenantId", null));
            this.zzs = zzwk.zzf(jSONObject.optJSONArray("mfaInfo"));
            this.zzt = Strings.emptyToNull(jSONObject.optString("mfaPendingCredential", null));
            this.zzo = Strings.emptyToNull(jSONObject.optString("oauthTokenSecret", null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzk;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final long zzh() {
        return this.zze;
    }

    public final boolean zzi() {
        return this.zzl;
    }

    public final String zzj() {
        return this.zzp;
    }

    public final boolean zzk() {
        return this.zzb || !TextUtils.isEmpty(this.zzp);
    }

    public final String zzl() {
        return this.zzr;
    }

    public final List<zzwk> zzm() {
        return this.zzs;
    }

    public final String zzn() {
        return this.zzt;
    }

    public final boolean zzo() {
        return !TextUtils.isEmpty(this.zzt);
    }

    public final zze zzp() {
        if (TextUtils.isEmpty(this.zzm) && TextUtils.isEmpty(this.zzn)) {
            return null;
        }
        return zze.zzb(this.zzj, this.zzn, this.zzm, this.zzq, this.zzo);
    }
}
