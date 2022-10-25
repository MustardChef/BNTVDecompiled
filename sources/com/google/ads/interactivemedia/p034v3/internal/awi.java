package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awi */
/* loaded from: classes2.dex */
public final class awi extends awk {

    /* renamed from: a */
    final /* synthetic */ Comparator f5206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awi(Comparator comparator) {
        this.f5206a = comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.awk
    /* renamed from: a */
    public final Map mo4459a() {
        return new TreeMap(this.f5206a);
    }
}
