package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avb */
/* loaded from: classes2.dex */
public abstract class avb<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: aO */
    private static final Object[] f5163aO = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo4435a() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo4434b() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public avg mo4425c() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public abstract axf iterator();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract boolean mo4423e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public Object[] mo4433f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo4422g(Object[] objArr) {
        axf it = iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f5163aO);
    }

    Object writeReplace() {
        return new ave(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        atm.m4612j(objArr);
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] mo4433f = mo4433f();
            if (mo4433f == null) {
                objArr = axd.m4400l(objArr, size);
            } else {
                return Arrays.copyOfRange(mo4433f, mo4434b(), mo4435a(), objArr.getClass());
            }
        } else if (length > size) {
            objArr[size] = null;
        }
        mo4422g(objArr);
        return objArr;
    }
}
