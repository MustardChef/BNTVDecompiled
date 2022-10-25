package com.google.ads.interactivemedia.p034v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avg */
/* loaded from: classes2.dex */
public abstract class avg<E> extends avb<E> implements List<E>, RandomAccess {

    /* renamed from: a */
    private static final axg f5171a = new axg(awq.f5211a, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static avg m4519j(Object[] objArr) {
        return m4518k(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static avg m4518k(Object[] objArr, int i) {
        if (i == 0) {
            return awq.f5211a;
        }
        return new awq(objArr, i);
    }

    /* renamed from: l */
    public static avg m4517l(Collection collection) {
        if (collection instanceof avb) {
            avg mo4425c = ((avb) collection).mo4425c();
            return mo4425c.mo4423e() ? m4519j(mo4425c.toArray()) : mo4425c;
        }
        return m4508u(collection.toArray());
    }

    /* renamed from: m */
    public static avg m4516m(Object[] objArr) {
        if (objArr.length == 0) {
            return awq.f5211a;
        }
        return m4508u((Object[]) objArr.clone());
    }

    /* renamed from: n */
    public static avg m4515n() {
        return awq.f5211a;
    }

    /* renamed from: o */
    public static avg m4514o(Object obj) {
        return m4508u(obj);
    }

    /* renamed from: p */
    public static avg m4513p(Object obj, Object obj2) {
        return m4508u(obj, obj2);
    }

    /* renamed from: q */
    public static avg m4512q(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return m4508u(obj, obj2, obj3, obj4, obj5);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* renamed from: t */
    public static avm m4509t() {
        return new avm(null);
    }

    /* renamed from: u */
    private static avg m4508u(Object... objArr) {
        axd.m4398n(objArr, objArr.length);
        return m4519j(objArr);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    @Deprecated
    /* renamed from: c */
    public final avg mo4425c() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: d */
    public final axf mo4424d() {
        return listIterator();
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (anx.m4882b(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!anx.m4882b(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: g */
    int mo4422g(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
        return size;
    }

    /* renamed from: h */
    public avg mo4521h() {
        return size() <= 1 ? this : new avd(this);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    /* renamed from: i */
    public avg subList(int i, int i2) {
        atm.m4615g(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 != 0) {
            return new avf(this, i, i3);
        }
        return awq.f5211a;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    /* renamed from: r */
    public final axg listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: s */
    public final axg listIterator(int i) {
        atm.m4610l(i, size());
        return isEmpty() ? f5171a : new axg(this, i);
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    Object writeReplace() {
        return new ave(toArray());
    }
}
