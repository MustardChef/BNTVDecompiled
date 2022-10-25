package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvo */
/* loaded from: classes3.dex */
public final class zzvo implements zzty {
    private static final String zza = "zzvo";
    private static final Logger zzb = new Logger(zzvo.class.getSimpleName(), new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;

    public zzvo(EmailAuthCredential emailAuthCredential, String str) {
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zzb());
        this.zzd = Preconditions.checkNotEmpty(emailAuthCredential.zzd());
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzty
    public final String zza() throws JSONException {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.zzd);
        String code = parseLink != null ? parseLink.getCode() : null;
        String zza2 = parseLink != null ? parseLink.zza() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzc);
        if (code != null) {
            jSONObject.put("oobCode", code);
        }
        if (zza2 != null) {
            jSONObject.put("tenantId", zza2);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        return jSONObject.toString();
    }
}
