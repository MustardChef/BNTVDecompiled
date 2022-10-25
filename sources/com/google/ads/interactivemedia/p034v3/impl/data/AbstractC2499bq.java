package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2461af.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bq */
/* loaded from: classes2.dex */
public abstract class AbstractC2499bq {
    public static AbstractC2499bq create(EnumC2498bp enumC2498bp, String str, String str2, String str3, String str4, int i, int i2) {
        return new C2461af(enumC2498bp, str, str2, str4, str3, i, i2);
    }

    public abstract int connectionTimeoutMs();

    public abstract String content();

    /* renamed from: id */
    public abstract String mo6002id();

    public abstract int readTimeoutMs();

    public abstract EnumC2498bp requestType();

    public abstract String url();

    public abstract String userAgent();
}
