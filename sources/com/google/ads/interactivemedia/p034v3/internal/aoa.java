package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aoa */
/* loaded from: classes2.dex */
public final class aoa extends alx {

    /* renamed from: a */
    public Long f4774a;

    /* renamed from: b */
    public Long f4775b;

    /* renamed from: c */
    public Long f4776c;

    /* renamed from: d */
    public Long f4777d;

    public aoa() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.alx
    /* renamed from: b */
    protected final HashMap mo4862b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.f4774a);
        hashMap.put(1, this.f4775b);
        hashMap.put(2, this.f4776c);
        hashMap.put(3, this.f4777d);
        return hashMap;
    }

    public aoa(String str) {
        HashMap a = m5009a(str);
        if (a != null) {
            this.f4774a = (Long) a.get(0);
            this.f4775b = (Long) a.get(1);
            this.f4776c = (Long) a.get(2);
            this.f4777d = (Long) a.get(3);
        }
    }
}
