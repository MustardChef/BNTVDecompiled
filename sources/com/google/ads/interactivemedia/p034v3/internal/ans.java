package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ans */
/* loaded from: classes2.dex */
public final class ans extends alx {

    /* renamed from: a */
    public Long f4733a;

    /* renamed from: b */
    public Long f4734b;

    public ans() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.alx
    /* renamed from: b */
    protected final HashMap mo4862b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.f4733a);
        hashMap.put(1, this.f4734b);
        return hashMap;
    }

    public ans(String str) {
        HashMap a = m5009a(str);
        if (a != null) {
            this.f4733a = (Long) a.get(0);
            this.f4734b = (Long) a.get(1);
        }
    }
}
