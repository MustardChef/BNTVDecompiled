package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bl */
/* loaded from: classes2.dex */
public final class C2596bl {

    /* renamed from: a */
    public static final C2596bl f5989a = new C2596bl(avg.m4515n());

    /* renamed from: b */
    private final avg f5990b;

    public C2596bl(List list) {
        this.f5990b = avg.m4517l(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f5990b.equals(((C2596bl) obj).f5990b);
    }

    public final int hashCode() {
        return this.f5990b.hashCode();
    }
}
