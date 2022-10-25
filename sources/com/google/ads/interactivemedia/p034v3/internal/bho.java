package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bho */
/* loaded from: classes2.dex */
public final class bho {

    /* renamed from: a */
    private static final int f5741a;

    static {
        String property = System.getProperty("java.version");
        int i = 1;
        try {
            String[] split = property.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt != 1) {
                i = parseInt;
            } else if (split.length > 1) {
                i = Integer.parseInt(split[1]);
            }
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < property.length(); i2++) {
                    char charAt = property.charAt(i2);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb.append(charAt);
                }
                i = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i = -1;
            }
        }
        if (i == -1) {
            i = 6;
        }
        f5741a = i;
    }

    /* renamed from: a */
    public static int m3671a() {
        return f5741a;
    }

    /* renamed from: b */
    public static boolean m3670b() {
        return f5741a >= 9;
    }
}
