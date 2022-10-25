package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.esp.VersionInfo;
import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2531v.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bc */
/* loaded from: classes2.dex */
public abstract class AbstractC2485bc {
    public static AbstractC2485bc create(int i, int i2, int i3) {
        return new C2531v(i, i2, i3);
    }

    public static AbstractC2485bc create(VersionInfo versionInfo) {
        return create(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public abstract int major();

    public abstract int micro();

    public abstract int minor();
}
