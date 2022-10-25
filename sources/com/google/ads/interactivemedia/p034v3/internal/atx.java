package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atx */
/* loaded from: classes2.dex */
public final class atx extends aua implements NavigableSet {

    /* renamed from: b */
    final /* synthetic */ auf f5091b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public atx(auf aufVar, NavigableMap navigableMap) {
        super(aufVar, navigableMap);
        this.f5091b = aufVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.aua
    /* renamed from: a */
    public final NavigableMap mo4593b() {
        return (NavigableMap) super.mo4593b();
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return mo4593b().ceilingKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new atx(this.f5091b, mo4593b().descendingMap());
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return mo4593b().floorKey(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aua, java.util.SortedSet, java.util.NavigableSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return mo4593b().higherKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return mo4593b().lowerKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return axd.m4389w(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return axd.m4389w(descendingIterator());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aua, java.util.SortedSet, java.util.NavigableSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aua, java.util.SortedSet, java.util.NavigableSet
    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return new atx(this.f5091b, mo4593b().headMap(obj, z));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return new atx(this.f5091b, mo4593b().subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return new atx(this.f5091b, mo4593b().tailMap(obj, z));
    }
}
