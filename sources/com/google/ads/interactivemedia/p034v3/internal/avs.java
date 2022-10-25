package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avs */
/* loaded from: classes2.dex */
public final class avs extends avt implements NavigableMap {

    /* renamed from: a */
    private static final avs f5188a = new avs(avw.m4468x(awo.f5210a), avg.m4515n());
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    private final transient awx f5189b;

    /* renamed from: c */
    private final transient avg f5190c;

    /* renamed from: d */
    private transient avs f5191d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avs(awx awxVar, avg avgVar) {
        this(awxVar, avgVar, null);
    }

    avs(awx awxVar, avg avgVar, avs avsVar) {
        this.f5189b = awxVar;
        this.f5190c = avgVar;
        this.f5191d = avsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static avs m4482l(Comparator comparator) {
        return awo.f5210a.equals(comparator) ? f5188a : new avs(avw.m4468x(comparator), avg.m4515n());
    }

    /* renamed from: n */
    public static avs m4480n() {
        return f5188a;
    }

    /* renamed from: r */
    private final avs m4476r(int i, int i2) {
        if (i == 0) {
            if (i2 == size()) {
                return this;
            }
            i = 0;
        }
        if (i == i2) {
            return m4482l(comparator());
        }
        return new avs(this.f5189b.m4436B(i, i2), this.f5190c.subList(i, i2));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj
    /* renamed from: a */
    final avb mo4445a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj
    /* renamed from: b */
    public final avb mo4485b() {
        return this.f5190c;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return axd.m4396p(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((avw) this.f5189b).f5195a;
    }

    @Override // java.util.NavigableMap
    public final /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return this.f5189b.descendingSet();
    }

    @Override // java.util.NavigableMap
    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        avs avsVar = this.f5191d;
        if (avsVar == null) {
            if (isEmpty()) {
                return m4482l(awp.m4451b(comparator()).mo4426a());
            }
            return new avs((awx) this.f5189b.descendingSet(), this.f5190c.mo4521h(), this);
        }
        return avsVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj
    /* renamed from: e */
    final avo mo4444e() {
        if (!isEmpty()) {
            return new avl(this);
        }
        return aww.f5227a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj
    /* renamed from: f */
    final avo mo4443f() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().mo4425c().get(0);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.f5189b.first();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return axd.m4396p(floorEntry(obj));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj
    /* renamed from: h */
    public final /* synthetic */ avo mo4484h() {
        return this.f5189b;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return axd.m4396p(higherEntry(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avj
    /* renamed from: i */
    public final boolean mo4442i() {
        return this.f5189b.mo4423e() || this.f5190c.mo4423e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj, java.util.Map
    public final /* synthetic */ Set keySet() {
        return this.f5189b;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().mo4425c().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.f5189b.last();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return axd.m4396p(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    /* renamed from: m */
    public final avs headMap(Object obj, boolean z) {
        awx awxVar = this.f5189b;
        atm.m4612j(obj);
        return m4476r(0, awxVar.m4427z(obj, z));
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.f5189b;
    }

    @Override // java.util.NavigableMap
    /* renamed from: o */
    public final avs subMap(Object obj, boolean z, Object obj2, boolean z2) {
        atm.m4612j(obj);
        atm.m4612j(obj2);
        if (comparator().compare(obj, obj2) > 0) {
            throw new IllegalArgumentException(atm.m4620b("expected fromKey <= toKey but %s > %s", obj, obj2));
        }
        return headMap(obj2, z2).tailMap(obj, z);
    }

    @Override // java.util.NavigableMap
    /* renamed from: p */
    public final avs tailMap(Object obj, boolean z) {
        awx awxVar = this.f5189b;
        atm.m4612j(obj);
        return m4476r(awxVar.m4437A(obj, z), size());
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f5190c.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj, java.util.Map
    public final /* synthetic */ Collection values() {
        return this.f5190c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avj
    Object writeReplace() {
        return new avr(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r4 < 0) goto L3;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avj, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(java.lang.Object r4) {
        /*
            r3 = this;
            com.google.ads.interactivemedia.v3.internal.awx r0 = r3.f5189b
            r1 = -1
            if (r4 != 0) goto L7
        L5:
            r4 = -1
            goto L12
        L7:
            com.google.ads.interactivemedia.v3.internal.avg r2 = r0.f5235d     // Catch: java.lang.ClassCastException -> L5
            java.util.Comparator r0 = r0.f5195a     // Catch: java.lang.ClassCastException -> L5
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch: java.lang.ClassCastException -> L5
            if (r4 >= 0) goto L12
            goto L5
        L12:
            if (r4 != r1) goto L16
            r4 = 0
            return r4
        L16:
            com.google.ads.interactivemedia.v3.internal.avg r0 = r3.f5190c
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.avs.get(java.lang.Object):java.lang.Object");
    }
}
