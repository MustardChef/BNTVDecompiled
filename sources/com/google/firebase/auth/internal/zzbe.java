package com.google.firebase.auth.internal;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzbe {
    private boolean zza;
    private String zzb;

    private zzbe() {
    }

    public static zzbe zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, Object> zza = zzaz.zza(str);
        try {
            zzbe zzbeVar = new zzbe();
            Object obj = zza.get("basicIntegrity");
            boolean z = false;
            if (obj != null && ((Boolean) obj).booleanValue()) {
                z = true;
            }
            zzbeVar.zza = z;
            String str2 = (String) zza.get("advice");
            if (str2 == null) {
                str2 = "";
            }
            zzbeVar.zzb = str2;
            return zzbeVar;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final boolean zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
