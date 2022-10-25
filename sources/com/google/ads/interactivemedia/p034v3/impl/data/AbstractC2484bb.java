package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.esp.VersionInfo;
import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2530u.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bb */
/* loaded from: classes2.dex */
public abstract class AbstractC2484bb {
    public static AbstractC2484bb create(VersionInfo versionInfo, VersionInfo versionInfo2, String str, String str2) {
        return create(AbstractC2485bc.create(versionInfo), AbstractC2485bc.create(versionInfo2), str, str2);
    }

    public abstract AbstractC2485bc adapterVersion();

    public abstract String name();

    public abstract AbstractC2485bc sdkVersion();

    public abstract String signals();

    public static AbstractC2484bb create(AbstractC2485bc abstractC2485bc, AbstractC2485bc abstractC2485bc2, String str, String str2) {
        return new C2530u(abstractC2485bc, abstractC2485bc2, str, str2);
    }
}
