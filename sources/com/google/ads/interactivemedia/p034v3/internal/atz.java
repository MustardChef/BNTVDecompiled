package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atz */
/* loaded from: classes2.dex */
public class atz extends ats implements SortedMap {

    /* renamed from: d */
    SortedSet f5092d;

    /* renamed from: e */
    final /* synthetic */ auf f5093e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public atz(auf aufVar, SortedMap sortedMap) {
        super(aufVar, sortedMap);
        this.f5093e = aufVar;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return mo4596h().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return mo4596h().firstKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public SortedMap mo4596h() {
        return (SortedMap) this.f5080a;
    }

    public SortedMap headMap(Object obj) {
        return new atz(this.f5093e, mo4596h().headMap(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.awg
    /* renamed from: i */
    public SortedSet mo4465g() {
        return new aua(this.f5093e, mo4596h());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ats, com.google.ads.interactivemedia.p034v3.internal.awg, java.util.AbstractMap, java.util.Map
    /* renamed from: j */
    public SortedSet keySet() {
        SortedSet sortedSet = this.f5092d;
        if (sortedSet == null) {
            SortedSet mo4465g = mo4465g();
            this.f5092d = mo4465g;
            return mo4465g;
        }
        return sortedSet;
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return mo4596h().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new atz(this.f5093e, mo4596h().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new atz(this.f5093e, mo4596h().tailMap(obj));
    }
}
