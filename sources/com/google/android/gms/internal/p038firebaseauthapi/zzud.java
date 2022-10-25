package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Locale;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzud */
/* loaded from: classes3.dex */
public final class zzud {
    public static String zza() {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        zzb(sb, locale);
        if (!locale.equals(Locale.US)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            zzb(sb, Locale.US);
        }
        return sb.toString();
    }

    private static void zzb(StringBuilder sb, Locale locale) {
        String language = locale.getLanguage();
        if (language != null) {
            sb.append(language);
            String country = locale.getCountry();
            if (country != null) {
                sb.append("-");
                sb.append(country);
            }
        }
    }
}
