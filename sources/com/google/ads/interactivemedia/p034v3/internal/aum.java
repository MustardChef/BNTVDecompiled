package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aum */
/* loaded from: classes2.dex */
final class aum extends auo {
    /* renamed from: f */
    static final auo m4570f(int i) {
        auo auoVar;
        auo auoVar2;
        auo auoVar3;
        if (i < 0) {
            auoVar3 = auo.f5116b;
            return auoVar3;
        } else if (i > 0) {
            auoVar2 = auo.f5117c;
            return auoVar2;
        } else {
            auoVar = auo.f5115a;
            return auoVar;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.auo
    /* renamed from: a */
    public final int mo4569a() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.auo
    /* renamed from: b */
    public final auo mo4568b(int i, int i2) {
        return m4570f(i < i2 ? -1 : i > i2 ? 1 : 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.auo
    /* renamed from: c */
    public final auo mo4567c(Object obj, Object obj2, Comparator comparator) {
        return m4570f(comparator.compare(obj, obj2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.auo
    /* renamed from: d */
    public final auo mo4566d(boolean z, boolean z2) {
        return m4570f(axn.m4379b(z, z2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.auo
    /* renamed from: e */
    public final auo mo4565e(boolean z, boolean z2) {
        return m4570f(axn.m4379b(z2, z));
    }
}
