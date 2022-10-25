package com.google.ads.interactivemedia.p034v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avw */
/* loaded from: classes2.dex */
public abstract class avw extends avx implements NavigableSet, axc {

    /* renamed from: a */
    final transient Comparator f5195a;

    /* renamed from: b */
    transient avw f5196b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avw(Comparator comparator) {
        this.f5195a = comparator;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static awx m4468x(Comparator comparator) {
        if (awo.f5210a.equals(comparator)) {
            return awx.f5234c;
        }
        return new awx(avg.m4515n(), comparator);
    }

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        return axd.m4420B(tailSet(obj, true));
    }

    @Override // java.util.SortedSet, com.google.ads.interactivemedia.p034v3.internal.axc
    public final Comparator comparator() {
        return this.f5195a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public abstract axf iterator();

    @Override // java.util.SortedSet
    public Object first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        return axd.m4387y(headSet(obj, true).descendingIterator());
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        return axd.m4420B(tailSet(obj, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final int m4473j(Object obj, Object obj2) {
        return this.f5195a.compare(obj, obj2);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        return axd.m4387y(headSet(obj, false).descendingIterator());
    }

    /* renamed from: p */
    abstract avw mo4432p();

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    /* renamed from: q */
    public final avw descendingSet() {
        avw avwVar = this.f5196b;
        if (avwVar == null) {
            avw mo4432p = mo4432p();
            this.f5196b = mo4432p;
            mo4432p.f5196b = this;
            return mo4432p;
        }
        return avwVar;
    }

    @Override // java.util.NavigableSet
    /* renamed from: r */
    public final avw headSet(Object obj, boolean z) {
        atm.m4612j(obj);
        return mo4431s(obj, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public abstract avw mo4431s(Object obj, boolean z);

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet
    /* renamed from: t */
    public final avw subSet(Object obj, boolean z, Object obj2, boolean z2) {
        atm.m4612j(obj);
        atm.m4612j(obj2);
        atm.m4618d(this.f5195a.compare(obj, obj2) <= 0);
        return mo4430u(obj, z, obj2, z2);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    /* renamed from: u */
    abstract avw mo4430u(Object obj, boolean z, Object obj2, boolean z2);

    @Override // java.util.NavigableSet
    /* renamed from: v */
    public final avw tailSet(Object obj, boolean z) {
        atm.m4612j(obj);
        return mo4429w(obj, z);
    }

    /* renamed from: w */
    abstract avw mo4429w(Object obj, boolean z);

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb
    Object writeReplace() {
        return new avv(this.f5195a, toArray());
    }

    @Override // java.util.NavigableSet
    /* renamed from: y */
    public abstract axf descendingIterator();
}
