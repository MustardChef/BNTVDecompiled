package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2458ac.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bh */
/* loaded from: classes2.dex */
public abstract class AbstractC2490bh {
    public static AbstractC2490bh create(String str, String str2, boolean z, String str3, int i) {
        return new C2458ac(str, str2, z, str3, i);
    }

    public abstract String appSetId();

    public abstract int appSetIdScope();

    public abstract String deviceId();

    public abstract String idType();

    public abstract boolean isLimitedAdTracking();
}
