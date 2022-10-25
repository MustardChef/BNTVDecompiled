package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmo */
/* loaded from: classes2.dex */
final class bmo extends bld implements RandomAccess, bnj, bop {

    /* renamed from: a */
    private static final bmo f6165a;

    /* renamed from: b */
    private double[] f6166b;

    /* renamed from: c */
    private int f6167c;

    static {
        bmo bmoVar = new bmo(new double[0], 0);
        f6165a = bmoVar;
        bmoVar.mo3270b();
    }

    bmo() {
        this(new double[10], 0);
    }

    /* renamed from: f */
    private final String m3345f(int i) {
        int i2 = this.f6167c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: g */
    private final void m3344g(int i) {
        if (i < 0 || i >= this.f6167c) {
            throw new IndexOutOfBoundsException(m3345f(i));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        m3538a();
        if (i < 0 || i > (i2 = this.f6167c)) {
            throw new IndexOutOfBoundsException(m3345f(i));
        }
        double[] dArr = this.f6166b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f6166b, i, dArr2, i + 1, this.f6167c - i);
            this.f6166b = dArr2;
        }
        this.f6166b[i] = doubleValue;
        this.f6167c++;
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m3538a();
        bnk.m3260i(collection);
        if (!(collection instanceof bmo)) {
            return super.addAll(collection);
        }
        bmo bmoVar = (bmo) collection;
        int i = bmoVar.f6167c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f6167c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f6166b;
            if (i3 > dArr.length) {
                this.f6166b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(bmoVar.f6166b, 0, this.f6166b, this.f6167c, bmoVar.f6167c);
            this.f6167c = i3;
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
        if (i < this.f6167c) {
            throw new IllegalArgumentException();
        }
        return new bmo(Arrays.copyOf(this.f6166b, i), this.f6167c);
    }

    /* renamed from: e */
    public final void m3346e(double d) {
        m3538a();
        int i = this.f6167c;
        double[] dArr = this.f6166b;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f6166b = dArr2;
        }
        double[] dArr3 = this.f6166b;
        int i2 = this.f6167c;
        this.f6167c = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bmo)) {
            return super.equals(obj);
        }
        bmo bmoVar = (bmo) obj;
        if (this.f6167c != bmoVar.f6167c) {
            return false;
        }
        double[] dArr = bmoVar.f6166b;
        for (int i = 0; i < this.f6167c; i++) {
            if (Double.doubleToLongBits(this.f6166b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        m3344g(i);
        return Double.valueOf(this.f6166b[i]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f6167c; i2++) {
            i = (i * 31) + bnk.m3266c(Double.doubleToLongBits(this.f6166b[i2]));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int i = this.f6167c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f6166b[i2] == doubleValue) {
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
        m3344g(i);
        double[] dArr = this.f6166b;
        double d = dArr[i];
        if (i < this.f6167c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f6167c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        m3538a();
        if (i2 >= i) {
            double[] dArr = this.f6166b;
            System.arraycopy(dArr, i2, dArr, i, this.f6167c - i2);
            this.f6167c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        m3538a();
        m3344g(i);
        double[] dArr = this.f6166b;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6167c;
    }

    private bmo(double[] dArr, int i) {
        this.f6166b = dArr;
        this.f6167c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m3346e(((Double) obj).doubleValue());
        return true;
    }
}
