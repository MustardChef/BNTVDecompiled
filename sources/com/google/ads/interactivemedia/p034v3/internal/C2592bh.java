package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bh */
/* loaded from: classes2.dex */
public final class C2592bh {

    /* renamed from: a */
    public static final C2592bh f5709a = new C2592bh(avj.m4504d());

    /* renamed from: b */
    private final avj f5710b;

    private C2592bh(Map map) {
        this.f5710b = avj.m4505c(map);
    }

    /* renamed from: a */
    public final C2591bg m3699a(C2587bc c2587bc) {
        return (C2591bg) this.f5710b.get(c2587bc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f5710b.equals(((C2592bh) obj).f5710b);
    }

    public final int hashCode() {
        return this.f5710b.hashCode();
    }
}
