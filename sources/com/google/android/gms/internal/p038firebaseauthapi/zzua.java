package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzua */
/* loaded from: classes3.dex */
public final class zzua {
    private final int zza;

    public zzua(String str) {
        int i = -1;
        try {
            List<String> zzc = zzae.zzb("[.-]").zzc(str);
            if (zzc.size() == 1) {
                i = Integer.parseInt(str);
                str = str;
            } else {
                str = str;
                if (zzc.size() >= 3) {
                    int parseInt = (Integer.parseInt(zzc.get(0)) * 1000000) + (Integer.parseInt(zzc.get(1)) * 1000);
                    int parseInt2 = Integer.parseInt(zzc.get(2));
                    i = parseInt + parseInt2;
                    str = parseInt2;
                }
            }
        } catch (IllegalArgumentException e) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", str, e));
            }
        }
        this.zza = i;
    }

    public static zzua zzb() {
        return new zzua(zzc());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzc() {
        String version = LibraryVersion.getInstance().getVersion("firebase-auth");
        return (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) ? "-1" : version;
    }

    public final String zza() {
        return String.format("X%s", Integer.toString(this.zza));
    }
}
