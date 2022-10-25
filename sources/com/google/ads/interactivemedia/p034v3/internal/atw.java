package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atw */
/* loaded from: classes2.dex */
final class atw extends atz implements NavigableMap {

    /* renamed from: c */
    final /* synthetic */ auf f5090c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public atw(auf aufVar, NavigableMap navigableMap) {
        super(aufVar, navigableMap);
        this.f5090c = aufVar;
    }

    /* renamed from: c */
    final Map.Entry m4601c(Iterator it) {
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Collection mo4455a = this.f5090c.mo4455a();
            mo4455a.addAll((Collection) entry.getValue());
            it.remove();
            return axd.m4393s(entry.getKey(), this.f5090c.mo4586b(mo4455a));
        }
        return null;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry ceilingEntry = mo4596h().ceilingEntry(obj);
        if (ceilingEntry == null) {
            return null;
        }
        return m4602a(ceilingEntry);
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return mo4596h().ceilingKey(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.atz
    /* renamed from: d */
    public final NavigableMap mo4596h() {
        return (NavigableMap) super.mo4596h();
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return ((atw) descendingMap()).keySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return new atw(this.f5090c, mo4596h().descendingMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.atz
    /* renamed from: e */
    public final NavigableSet mo4595i() {
        return new atx(this.f5090c, mo4596h());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atz, com.google.ads.interactivemedia.p034v3.internal.ats, com.google.ads.interactivemedia.p034v3.internal.awg, java.util.AbstractMap, java.util.Map
    /* renamed from: f */
    public final NavigableSet keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        Map.Entry firstEntry = mo4596h().firstEntry();
        if (firstEntry == null) {
            return null;
        }
        return m4602a(firstEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        Map.Entry floorEntry = mo4596h().floorEntry(obj);
        if (floorEntry == null) {
            return null;
        }
        return m4602a(floorEntry);
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return mo4596h().floorKey(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atz, java.util.SortedMap, java.util.NavigableMap
    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        Map.Entry higherEntry = mo4596h().higherEntry(obj);
        if (higherEntry == null) {
            return null;
        }
        return m4602a(higherEntry);
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return mo4596h().higherKey(obj);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        Map.Entry lastEntry = mo4596h().lastEntry();
        if (lastEntry == null) {
            return null;
        }
        return m4602a(lastEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry lowerEntry = mo4596h().lowerEntry(obj);
        if (lowerEntry == null) {
            return null;
        }
        return m4602a(lowerEntry);
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return mo4596h().lowerKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return m4601c(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return m4601c(descendingMap().entrySet().iterator());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atz, java.util.SortedMap, java.util.NavigableMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atz, java.util.SortedMap, java.util.NavigableMap
    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return new atw(this.f5090c, mo4596h().headMap(obj, z));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return new atw(this.f5090c, mo4596h().subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return new atw(this.f5090c, mo4596h().tailMap(obj, z));
    }
}
