package com.google.android.gms.cast.internal.media;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zza {
    private static final Logger zza = new Logger("MetadataUtils");
    private static final String[] zzb;
    private static final String zzc;

    static {
        String[] strArr = {"Z", "+hh", "+hhmm", "+hh:mm"};
        zzb = strArr;
        String valueOf = String.valueOf(strArr[0]);
        zzc = valueOf.length() != 0 ? "yyyyMMdd'T'HHmmss".concat(valueOf) : new String("yyyyMMdd'T'HHmmss");
    }

    public static void zza(List<WebImage> list, JSONArray jSONArray) {
        try {
            list.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public static String zzc(Calendar calendar) {
        if (calendar == null) {
            zza.m369d("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = zzc;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String format = simpleDateFormat.format(calendar.getTime());
        return format.endsWith("+0000") ? format.replace("+0000", zzb[0]) : format;
    }

    public static Calendar zzd(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            zza.m369d("Input string is empty or null", new Object[0]);
            return null;
        }
        String zze = zze(str);
        if (TextUtils.isEmpty(zze)) {
            zza.m369d("Invalid date format", new Object[0]);
            return null;
        }
        String zzf = zzf(str);
        if (TextUtils.isEmpty(zzf)) {
            str2 = "yyyyMMdd";
        } else {
            String valueOf = String.valueOf(zze);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(zzf).length());
            sb.append(valueOf);
            sb.append(ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(zzf);
            zze = sb.toString();
            str2 = zzf.length() == 6 ? "yyyyMMdd'T'HHmmss" : zzc;
        }
        Calendar gregorianCalendar = GregorianCalendar.getInstance();
        try {
            gregorianCalendar.setTime(new SimpleDateFormat(str2).parse(zze));
            return gregorianCalendar;
        } catch (ParseException e) {
            zza.m366e(e, "Error parsing string", new Object[0]);
            return null;
        }
    }

    private static String zze(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return str.substring(0, 8);
            } catch (IndexOutOfBoundsException e) {
                zza.m366e(e, "Error extracting the date", new Object[0]);
                return null;
            }
        }
        zza.m369d("Input string is empty or null", new Object[0]);
        return null;
    }

    private static String zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            zza.m369d("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != 8) {
            zza.m369d("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == 6) {
                return substring;
            }
            char charAt = substring.charAt(6);
            if (charAt == '+' || charAt == '-') {
                int length = substring.length();
                String[] strArr = zzb;
                if (length == strArr[1].length() + 6 || length == strArr[2].length() + 6 || length == strArr[3].length() + 6) {
                    return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                }
            } else if (charAt == 'Z' && substring.length() == zzb[0].length() + 6) {
                return String.valueOf(substring.substring(0, substring.length() - 1)).concat("+0000");
            } else {
                return null;
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            zza.m366e(e, "Error extracting the time substring: %s", new Object[0]);
            return null;
        }
    }

    public static JSONArray zzb(List<WebImage> list) {
        Objects.requireNonNull(list);
        JSONArray jSONArray = new JSONArray();
        for (WebImage webImage : list) {
            jSONArray.put(webImage.toJson());
        }
        return jSONArray;
    }
}
