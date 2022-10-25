package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import java.util.Collection;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class CastMediaControlIntent {
    public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
    public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
    public static final int ERROR_CODE_REQUEST_FAILED = 1;
    public static final int ERROR_CODE_SESSION_START_FAILED = 2;
    public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
    public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
    public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
    public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
    public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
    public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
    public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";

    private CastMediaControlIntent() {
    }

    public static String categoryForRemotePlayback() {
        return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", null, null, false, true);
    }

    public static String languageTagForLocale(Locale locale) {
        return CastUtils.zzf(locale);
    }

    private static String zza(String str, String str2, Collection<String> collection, boolean z, boolean z2) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            String upperCase = str2.toUpperCase();
            if (!upperCase.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException(str2.length() != 0 ? "Invalid application ID: ".concat(str2) : new String("Invalid application ID: "));
            }
            sb.append("/");
            sb.append(upperCase);
        }
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str2 == null) {
                sb.append("/");
            }
            sb.append("/");
            boolean z3 = true;
            for (String str3 : collection) {
                CastUtils.throwIfInvalidNamespace(str3);
                if (!z3) {
                    sb.append(",");
                }
                sb.append(CastUtils.zze(str3));
                z3 = false;
            }
        }
        if (str2 == null && collection == null) {
            sb.append("/");
        }
        if (collection == null) {
            sb.append("/");
        }
        sb.append("//ALLOW_IPV6");
        return sb.toString();
    }

    public static String categoryForCast(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        }
        return zza("com.google.android.gms.cast.CATEGORY_CAST", str, null, false, true);
    }

    public static String categoryForRemotePlayback(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("applicationId cannot be null or empty");
        }
        return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", str, null, false, true);
    }

    public static String categoryForCast(String str, Collection<String> collection) {
        if (str != null) {
            if (collection == null) {
                throw new IllegalArgumentException("namespaces cannot be null");
            }
            return zza("com.google.android.gms.cast.CATEGORY_CAST", str, collection, false, true);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    public static String categoryForCast(Collection<String> collection) throws IllegalArgumentException {
        if (collection == null) {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
        return zza("com.google.android.gms.cast.CATEGORY_CAST", null, collection, false, true);
    }
}
