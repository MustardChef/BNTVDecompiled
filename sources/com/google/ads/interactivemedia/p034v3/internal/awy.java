package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awy */
/* loaded from: classes2.dex */
final class awy extends awp implements Serializable {

    /* renamed from: a */
    static final awy f5236a = new awy();
    private static final long serialVersionUID = 0;

    private awy() {
    }

    private Object readResolve() {
        return f5236a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp
    /* renamed from: a */
    public final awp mo4426a() {
        return awo.f5210a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        atm.m4612j(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}
