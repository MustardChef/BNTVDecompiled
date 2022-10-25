package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awp */
/* loaded from: classes2.dex */
public abstract class awp implements Comparator {
    /* renamed from: b */
    public static awp m4451b(Comparator comparator) {
        if (comparator instanceof awp) {
            return (awp) comparator;
        }
        return new aul(comparator);
    }

    /* renamed from: c */
    public static awp m4450c() {
        return awo.f5210a;
    }

    /* renamed from: a */
    public awp mo4426a() {
        return new awz(this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    /* renamed from: d */
    public final awp m4449d(ath athVar) {
        return new auk(athVar, this);
    }

    /* renamed from: e */
    public final List m4448e(Iterable iterable) {
        Object[] m4421A = axd.m4421A(iterable);
        Arrays.sort(m4421A, this);
        List asList = Arrays.asList(m4421A);
        atm.m4612j(asList);
        if (asList instanceof Collection) {
            return new ArrayList(asList);
        }
        return axd.m4392t(asList.iterator());
    }
}
