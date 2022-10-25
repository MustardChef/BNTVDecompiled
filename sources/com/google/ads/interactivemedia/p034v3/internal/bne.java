package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bne */
/* loaded from: classes2.dex */
final class bne extends bld implements RandomAccess, bni, bop {

    /* renamed from: a */
    private static final bne f6261a;

    /* renamed from: b */
    private int[] f6262b;

    /* renamed from: c */
    private int f6263c;

    static {
        bne bneVar = new bne(new int[0], 0);
        f6261a = bneVar;
        bneVar.mo3270b();
    }

    bne() {
        this(new int[10], 0);
    }

    /* renamed from: f */
    public static bne m3274f() {
        return f6261a;
    }

    /* renamed from: h */
    private final String m3272h(int i) {
        int i2 = this.f6263c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: i */
    private final void m3271i(int i) {
        if (i < 0 || i >= this.f6263c) {
            throw new IndexOutOfBoundsException(m3272h(i));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        m3538a();
        if (i < 0 || i > (i2 = this.f6263c)) {
            throw new IndexOutOfBoundsException(m3272h(i));
        }
        int[] iArr = this.f6262b;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f6262b, i, iArr2, i + 1, this.f6263c - i);
            this.f6262b = iArr2;
        }
        this.f6262b[i] = intValue;
        this.f6263c++;
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m3538a();
        bnk.m3260i(collection);
        if (!(collection instanceof bne)) {
            return super.addAll(collection);
        }
        bne bneVar = (bne) collection;
        int i = bneVar.f6263c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f6263c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f6262b;
            if (i3 > iArr.length) {
                this.f6262b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(bneVar.f6262b, 0, this.f6262b, this.f6263c, bneVar.f6263c);
            this.f6263c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnj
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ bnj mo3117d(int i) {
        if (i < this.f6263c) {
            throw new IllegalArgumentException();
        }
        return new bne(Arrays.copyOf(this.f6262b, i), this.f6263c);
    }

    /* renamed from: e */
    public final int m3275e(int i) {
        m3271i(i);
        return this.f6262b[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bne)) {
            return super.equals(obj);
        }
        bne bneVar = (bne) obj;
        if (this.f6263c != bneVar.f6263c) {
            return false;
        }
        int[] iArr = bneVar.f6262b;
        for (int i = 0; i < this.f6263c; i++) {
            if (this.f6262b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public final void m3273g(int i) {
        m3538a();
        int i2 = this.f6263c;
        int[] iArr = this.f6262b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f6262b = iArr2;
        }
        int[] iArr3 = this.f6262b;
        int i3 = this.f6263c;
        this.f6263c = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return Integer.valueOf(m3275e(i));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f6263c; i2++) {
            i = (i * 31) + this.f6262b[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i = this.f6263c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f6262b[i2] == intValue) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        int i2;
        m3538a();
        m3271i(i);
        int[] iArr = this.f6262b;
        int i3 = iArr[i];
        if (i < this.f6263c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i2 - i) - 1);
        }
        this.f6263c--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        m3538a();
        if (i2 >= i) {
            int[] iArr = this.f6262b;
            System.arraycopy(iArr, i2, iArr, i, this.f6263c - i2);
            this.f6263c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        m3538a();
        m3271i(i);
        int[] iArr = this.f6262b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6263c;
    }

    private bne(int[] iArr, int i) {
        this.f6262b = iArr;
        this.f6263c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m3273g(((Integer) obj).intValue());
        return true;
    }
}
