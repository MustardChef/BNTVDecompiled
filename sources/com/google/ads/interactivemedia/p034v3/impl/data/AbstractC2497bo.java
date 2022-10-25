package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2460ae.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bo */
/* loaded from: classes2.dex */
public abstract class AbstractC2497bo {
    static AbstractC2497bo create(String str, String str2) {
        return new C2460ae(str, str2);
    }

    public static AbstractC2497bo create(Throwable th) {
        return new C2460ae(th.getClass().getName(), th.getMessage());
    }

    public abstract String message();

    public abstract String name();
}
