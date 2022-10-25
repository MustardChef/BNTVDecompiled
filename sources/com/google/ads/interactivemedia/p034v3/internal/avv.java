package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avv */
/* loaded from: classes2.dex */
final class avv implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final Comparator f5193a;

    /* renamed from: b */
    final Object[] f5194b;

    public avv(Comparator comparator, Object[] objArr) {
        this.f5193a = comparator;
        this.f5194b = objArr;
    }

    Object readResolve() {
        avu avuVar = new avu(this.f5193a);
        avuVar.m4474h(this.f5194b);
        return avuVar.m4475g();
    }
}
