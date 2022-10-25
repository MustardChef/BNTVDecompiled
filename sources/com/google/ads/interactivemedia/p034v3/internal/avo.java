package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avo */
/* loaded from: classes2.dex */
public abstract class avo<E> extends avb<E> implements Set<E> {

    /* renamed from: a */
    private transient avg f5182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static int m4496k(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (highestOneBit * 0.7d < max);
            return highestOneBit;
        }
        atm.m4617e(max < 1073741824, "collection too large");
        return 1073741824;
    }

    /* renamed from: l */
    public static avo m4495l(Collection collection) {
        if ((collection instanceof avo) && !(collection instanceof SortedSet)) {
            avo avoVar = (avo) collection;
            if (!avoVar.mo4423e()) {
                return avoVar;
            }
        }
        Object[] array = collection.toArray();
        return m4497j(array.length, array);
    }

    /* renamed from: m */
    public static avo m4494m(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            if (length == 1) {
                return m4492o(objArr[0]);
            }
            return m4497j(length, (Object[]) objArr.clone());
        }
        return aww.f5227a;
    }

    /* renamed from: n */
    public static avo m4493n() {
        return aww.f5227a;
    }

    /* renamed from: o */
    public static avo m4492o(Object obj) {
        return new axb(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: c */
    public avg mo4425c() {
        avg avgVar = this.f5182a;
        if (avgVar == null) {
            avg mo4438i = mo4438i();
            this.f5182a = mo4438i;
            return mo4438i;
        }
        return avgVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public abstract axf iterator();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof avo) && mo4439h() && ((avo) obj).mo4439h() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: h */
    boolean mo4439h() {
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return axd.m4410b(this);
    }

    /* renamed from: i */
    avg mo4438i() {
        return avg.m4519j(toArray());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    Object writeReplace() {
        return new avn(toArray());
    }

    /* renamed from: j */
    private static avo m4497j(int i, Object... objArr) {
        if (i != 0) {
            if (i == 1) {
                Object obj = objArr[0];
                obj.getClass();
                return m4492o(obj);
            }
            int m4496k = m4496k(i);
            Object[] objArr2 = new Object[m4496k];
            int i2 = m4496k - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj2 = objArr[i5];
                axd.m4399m(obj2, i5);
                int hashCode = obj2.hashCode();
                int m4418D = axd.m4418D(hashCode);
                while (true) {
                    int i6 = m4418D & i2;
                    Object obj3 = objArr2[i6];
                    if (obj3 != null) {
                        if (obj3.equals(obj2)) {
                            break;
                        }
                        m4418D++;
                    } else {
                        objArr[i4] = obj2;
                        objArr2[i6] = obj2;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                Object obj4 = objArr[0];
                obj4.getClass();
                return new axb(obj4);
            } else if (m4496k(i4) < m4496k / 2) {
                return m4497j(i4, objArr);
            } else {
                int length = objArr.length;
                if (i4 < (length >> 1) + (length >> 2)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new aww(objArr, i3, objArr2, i2, i4);
            }
        }
        return aww.f5227a;
    }
}
