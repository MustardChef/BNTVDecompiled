package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anp */
/* loaded from: classes2.dex */
public final class anp extends alx {

    /* renamed from: a */
    public Long f4724a;

    /* renamed from: b */
    public Boolean f4725b;

    /* renamed from: c */
    public Boolean f4726c;

    public anp() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.alx
    /* renamed from: b */
    protected final HashMap mo4862b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.f4724a);
        hashMap.put(1, this.f4725b);
        hashMap.put(2, this.f4726c);
        return hashMap;
    }

    public anp(String str) {
        HashMap a = m5009a(str);
        if (a != null) {
            this.f4724a = (Long) a.get(0);
            this.f4725b = (Boolean) a.get(1);
            this.f4726c = (Boolean) a.get(2);
        }
    }
}
