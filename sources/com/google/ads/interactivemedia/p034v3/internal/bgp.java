package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgp */
/* loaded from: classes2.dex */
public final class bgp extends bgm {

    /* renamed from: a */
    private final bhy f5698a = new bhy();

    /* renamed from: a */
    public final Set m3711a() {
        return this.f5698a.entrySet();
    }

    /* renamed from: b */
    public final void m3710b(String str, bgm bgmVar) {
        bhy bhyVar = this.f5698a;
        if (bgmVar == null) {
            bgmVar = bgo.f5697a;
        }
        bhyVar.put(str, bgmVar);
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof bgp) && ((bgp) obj).f5698a.equals(this.f5698a));
    }

    public final int hashCode() {
        return this.f5698a.hashCode();
    }
}
