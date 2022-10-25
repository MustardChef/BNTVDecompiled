package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.af */
/* loaded from: classes2.dex */
public final class C2544af {

    /* renamed from: a */
    private static final HashSet f3653a = new HashSet();

    /* renamed from: b */
    private static String f3654b = "media3.common";

    /* renamed from: a */
    public static synchronized String m5677a() {
        String str;
        synchronized (C2544af.class) {
            str = f3654b;
        }
        return str;
    }

    /* renamed from: b */
    public static synchronized void m5676b(String str) {
        synchronized (C2544af.class) {
            if (f3653a.add(str)) {
                String str2 = f3654b;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + str.length());
                sb.append(str2);
                sb.append(", ");
                sb.append(str);
                f3654b = sb.toString();
            }
        }
    }
}
