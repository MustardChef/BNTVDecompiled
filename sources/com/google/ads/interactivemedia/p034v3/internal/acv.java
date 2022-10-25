package com.google.ads.interactivemedia.p034v3.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acv */
/* loaded from: classes2.dex */
public final class acv {

    /* renamed from: a */
    private static final Pattern f3280a = Pattern.compile("^NOTE([ \t].*)?$");

    /* renamed from: a */
    public static long m5820a(String str) throws NumberFormatException {
        String[] m2546aj = C2628cq.m2546aj(str, "\\.");
        long j = 0;
        for (String str2 : C2628cq.m2547ai(m2546aj[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (m2546aj.length == 2) {
            j2 += Long.parseLong(m2546aj[1]);
        }
        return j2 * 1000;
    }

    /* renamed from: b */
    public static Matcher m5819b(C2621cj c2621cj) {
        String m2624r;
        while (true) {
            String m2624r2 = c2621cj.m2624r();
            if (m2624r2 == null) {
                return null;
            }
            if (f3280a.matcher(m2624r2).matches()) {
                do {
                    m2624r = c2621cj.m2624r();
                    if (m2624r != null) {
                    }
                } while (!m2624r.isEmpty());
            } else {
                Matcher matcher = acu.f3279a.matcher(m2624r2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    /* renamed from: c */
    public static void m5818c(C2621cj c2621cj) throws C2555ao {
        int m2639c = c2621cj.m2639c();
        if (m5817d(c2621cj)) {
            return;
        }
        c2621cj.m2644F(m2639c);
        String valueOf = String.valueOf(c2621cj.m2624r());
        throw C2555ao.m4866a(valueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(valueOf) : new String("Expected WEBVTT. Got "), null);
    }

    /* renamed from: d */
    public static boolean m5817d(C2621cj c2621cj) {
        String m2624r = c2621cj.m2624r();
        return m2624r != null && m2624r.startsWith("WEBVTT");
    }
}
