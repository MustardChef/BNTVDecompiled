package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aua */
/* loaded from: classes2.dex */
public class aua extends atv implements SortedSet {

    /* renamed from: c */
    final /* synthetic */ auf f5094c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aua(auf aufVar, SortedMap sortedMap) {
        super(aufVar, sortedMap);
        this.f5094c = aufVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public SortedMap mo4593b() {
        return (SortedMap) this.f5201d;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return mo4593b().comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return mo4593b().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new aua(this.f5094c, mo4593b().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return mo4593b().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new aua(this.f5094c, mo4593b().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new aua(this.f5094c, mo4593b().tailMap(obj));
    }
}
