package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2528s.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.az */
/* loaded from: classes2.dex */
public abstract class AbstractC2481az {
    public static AbstractC2481az create(String str, String str2, String str3, String str4) {
        return new C2528s(str, str2, str3, str4);
    }

    public abstract String addtlConsent();

    public abstract String gdprApplies();

    public abstract String tcString();

    public abstract String uspString();
}
