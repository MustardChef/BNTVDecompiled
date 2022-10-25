package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yu */
/* loaded from: classes2.dex */
public final class C3226yu {

    /* renamed from: a */
    public final String f9539a;

    private C3226yu(String str) {
        this.f9539a = str;
    }

    /* renamed from: a */
    public static C3226yu m503a(C2621cj c2621cj) {
        String str;
        c2621cj.m2643G(2);
        int m2633i = c2621cj.m2633i();
        int i = m2633i >> 1;
        int m2633i2 = (c2621cj.m2633i() >> 3) | ((m2633i & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else if (i != 9) {
            return null;
        } else {
            str = "avc3";
        }
        String str2 = m2633i2 < 10 ? ".0" : ".";
        StringBuilder sb = new StringBuilder(str.length() + 24 + str2.length());
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(str2);
        sb.append(m2633i2);
        return new C3226yu(sb.toString());
    }
}
