package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2468am.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bu */
/* loaded from: classes2.dex */
public abstract class AbstractC2503bu {
    public static AbstractC2502bt builder() {
        return new C2466ak();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean attached();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2479ax bounds();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String detailedReason();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hidden();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract FriendlyObstructionPurpose purpose();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String type();
}
