package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anj */
/* loaded from: classes2.dex */
public final class anj extends alx {

    /* renamed from: a */
    public long f4714a;

    /* renamed from: b */
    public long f4715b;

    public anj() {
        this.f4714a = -1L;
        this.f4715b = -1L;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.alx
    /* renamed from: b */
    protected final HashMap mo4862b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, Long.valueOf(this.f4714a));
        hashMap.put(1, Long.valueOf(this.f4715b));
        return hashMap;
    }

    public anj(String str) {
        this.f4714a = -1L;
        this.f4715b = -1L;
        HashMap a = m5009a(str);
        if (a != null) {
            this.f4714a = ((Long) a.get(0)).longValue();
            this.f4715b = ((Long) a.get(1)).longValue();
        }
    }
}
