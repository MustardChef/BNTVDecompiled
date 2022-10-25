package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awo */
/* loaded from: classes2.dex */
public final class awo extends awp implements Serializable {

    /* renamed from: a */
    static final awo f5210a = new awo();
    private static final long serialVersionUID = 0;

    private awo() {
    }

    private Object readResolve() {
        return f5210a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp
    /* renamed from: a */
    public final awp mo4426a() {
        return awy.f5236a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        atm.m4612j(comparable);
        atm.m4612j(comparable2);
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
