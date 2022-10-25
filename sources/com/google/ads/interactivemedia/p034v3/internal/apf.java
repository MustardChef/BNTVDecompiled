package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apf */
/* loaded from: classes2.dex */
public final class apf {

    /* renamed from: a */
    private final Map f4834a = new HashMap();

    /* renamed from: a */
    public final AtomicReference m4842a(String str) {
        synchronized (this) {
            if (!this.f4834a.containsKey(str)) {
                this.f4834a.put(str, new AtomicReference());
            }
        }
        return (AtomicReference) this.f4834a.get(str);
    }
}
