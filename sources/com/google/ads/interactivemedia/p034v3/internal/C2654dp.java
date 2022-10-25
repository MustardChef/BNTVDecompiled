package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dp */
/* loaded from: classes2.dex */
public final class C2654dp {

    /* renamed from: a */
    private final Map f7054a = new HashMap();

    /* renamed from: b */
    private Map f7055b;

    /* renamed from: a */
    public final synchronized Map m2475a() {
        if (this.f7055b == null) {
            this.f7055b = Collections.unmodifiableMap(new HashMap(this.f7054a));
        }
        return this.f7055b;
    }
}
