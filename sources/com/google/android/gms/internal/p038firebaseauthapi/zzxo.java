package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxo */
/* loaded from: classes3.dex */
public final class zzxo implements zzty {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzxo() {
    }

    public static zzxo zzb(String str, String str2, boolean z) {
        zzxo zzxoVar = new zzxo();
        zzxoVar.zzb = Preconditions.checkNotEmpty(str);
        zzxoVar.zzc = Preconditions.checkNotEmpty(str2);
        zzxoVar.zzf = z;
        return zzxoVar;
    }

    public static zzxo zzc(String str, String str2, boolean z) {
        zzxo zzxoVar = new zzxo();
        zzxoVar.zza = Preconditions.checkNotEmpty(str);
        zzxoVar.zzd = Preconditions.checkNotEmpty(str2);
        zzxoVar.zzf = z;
        return zzxoVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzty
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zzd(String str) {
        this.zze = str;
    }
}
