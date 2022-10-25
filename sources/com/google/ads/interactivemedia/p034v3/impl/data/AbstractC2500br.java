package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2462ag.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.br */
/* loaded from: classes2.dex */
public abstract class AbstractC2500br {
    public static final String UNKNOWN_CONTENT_TYPE = "unknown";

    private static AbstractC2500br create(String str, String str2, String str3, int i) {
        return new C2462ag(str, str2, str3, i);
    }

    public static AbstractC2500br forError(String str, int i) {
        return create(str, "", "unknown", i);
    }

    public static AbstractC2500br forResponse(String str, String str2) {
        return forResponse(str, str2, "unknown");
    }

    public abstract String content();

    public abstract String contentType();

    public abstract int errorCode();

    /* renamed from: id */
    public abstract String mo6001id();

    public static AbstractC2500br forResponse(String str, String str2, String str3) {
        return create(str, str2, str3, 0);
    }
}
