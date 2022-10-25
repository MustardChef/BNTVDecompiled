package com.google.ads.interactivemedia.p034v3.internal;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dq */
/* loaded from: classes2.dex */
public final class C2655dq {

    /* renamed from: a */
    private static final Pattern f7056a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* renamed from: b */
    private static final Pattern f7057b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    /* renamed from: a */
    public static long m2474a(String str, String str2) {
        long j = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(str);
                sb.append("]");
                Log.e("HttpUtil", sb.toString());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        Matcher matcher = f7056a.matcher(str2);
        if (matcher.matches()) {
            try {
                String group = matcher.group(2);
                C2616ce.m2689d(group);
                long parseLong = Long.parseLong(group);
                String group2 = matcher.group(1);
                C2616ce.m2689d(group2);
                long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
                if (j < 0) {
                    return parseLong2;
                }
                if (j != parseLong2) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(str2).length());
                    sb2.append("Inconsistent headers [");
                    sb2.append(str);
                    sb2.append("] [");
                    sb2.append(str2);
                    sb2.append("]");
                    Log.w("HttpUtil", sb2.toString());
                    return Math.max(j, parseLong2);
                }
                return j;
            } catch (NumberFormatException unused2) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 27);
                sb3.append("Unexpected Content-Range [");
                sb3.append(str2);
                sb3.append("]");
                Log.e("HttpUtil", sb3.toString());
                return j;
            }
        }
        return j;
    }

    /* renamed from: b */
    public static long m2473b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f7057b.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            C2616ce.m2689d(group);
            return Long.parseLong(group);
        }
        return -1L;
    }

    /* renamed from: c */
    public static String m2472c(long j, long j2) {
        if (j == 0) {
            if (j2 == -1) {
                return null;
            }
            j = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j);
        sb.append("-");
        if (j2 != -1) {
            sb.append((j + j2) - 1);
        }
        return sb.toString();
    }
}
