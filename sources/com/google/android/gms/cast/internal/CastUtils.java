package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class CastUtils {
    private static final Pattern zza = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");
    private static final Random zzb = new Random(SystemClock.elapsedRealtime());

    private CastUtils() {
    }

    public static JSONObject jsonStringToJsonObject(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static double millisecToSec(long j) {
        return j / 1000.0d;
    }

    public static String optStringOrNull(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    public static long secToMillisec(double d) {
        return (long) (d * 1000.0d);
    }

    public static void throwIfInvalidNamespace(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if (str.length() == 11) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static long[] toLongArray(Collection<Long> collection) {
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (Long l : collection) {
            jArr[i] = l.longValue();
            i++;
        }
        return jArr;
    }

    public static long[] toLongArraySafely(JSONArray jSONArray) {
        try {
            return zzi(jSONArray);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static <T> boolean zza(T t, T t2) {
        if (t == null && t2 == null) {
            return true;
        }
        return (t == null || t2 == null || !t.equals(t2)) ? false : true;
    }

    public static long zzb() {
        return zzb.nextLong();
    }

    public static int zzc(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static String zzd(String str) {
        return str.length() != 0 ? "urn:x-cast:".concat(str) : new String("urn:x-cast:");
    }

    public static String zze(String str) {
        if (zza.matcher(str).matches()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '_' || charAt == '-' || charAt == '.' || charAt == ':'))) {
                sb.append(String.format("%%%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String zzf(Locale locale) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append('-');
            sb.append(variant);
        }
        return sb.toString();
    }

    public static int[] zzg(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer num : collection) {
            iArr[i] = num.intValue();
            i++;
        }
        return iArr;
    }

    public static List<Integer> zzh(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static long[] zzi(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        long[] jArr = new long[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            jArr[i] = jSONArray.getLong(i);
        }
        return jArr;
    }

    public static JSONObject zzj(JSONObject jSONObject, String str) {
        if (jSONObject.has("customData")) {
            return jSONObject.optJSONObject("customData");
        }
        return null;
    }
}
