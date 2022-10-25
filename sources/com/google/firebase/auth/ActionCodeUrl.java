package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public class ActionCodeUrl {
    private static final Map<String, Integer> zzg = new zzc();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    private ActionCodeUrl(String str) {
        String zzb = zzb(str, "apiKey");
        this.zza = zzb;
        String zzb2 = zzb(str, "oobCode");
        this.zzb = zzb2;
        String zzb3 = zzb(str, "mode");
        this.zzc = zzb3;
        if (zzb == null || zzb2 == null || zzb3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.zzd = zzb(str, "continueUrl");
        this.zze = zzb(str, "languageCode");
        this.zzf = zzb(str, "tenantId");
    }

    public static ActionCodeUrl parseLink(String str) {
        Preconditions.checkNotEmpty(str);
        try {
            return new ActionCodeUrl(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static final String zzb(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(parse.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public String getApiKey() {
        return this.zza;
    }

    public String getCode() {
        return this.zzb;
    }

    public String getContinueUrl() {
        return this.zzd;
    }

    public String getLanguageCode() {
        return this.zze;
    }

    public int getOperation() {
        Map<String, Integer> map = zzg;
        if (map.containsKey(this.zzc)) {
            return map.get(this.zzc).intValue();
        }
        return 3;
    }

    public final String zza() {
        return this.zzf;
    }
}
