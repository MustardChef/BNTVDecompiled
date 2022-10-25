package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmx */
/* loaded from: classes2.dex */
final class bmx extends bld implements RandomAccess, bnj, bop {

    /* renamed from: a */
    private static final bmx f6244a;

    /* renamed from: b */
    private float[] f6245b;

    /* renamed from: c */
    private int f6246c;

    static {
        bmx bmxVar = new bmx(new float[0], 0);
        f6244a = bmxVar;
        bmxVar.mo3270b();
    }

    bmx() {
        this(new float[10], 0);
    }

    /* renamed from: f */
    private final String m3315f(int i) {
        int i2 = this.f6246c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: g */
    private final void m3314g(int i) {
        if (i < 0 || i >= this.f6246c) {
            throw new IndexOutOfBoundsException(m3315f(i));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        m3538a();
        if (i < 0 || i > (i2 = this.f6246c)) {
            throw new IndexOutOfBoundsException(m3315f(i));
        }
        float[] fArr = this.f6245b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f6245b, i, fArr2, i + 1, this.f6246c - i);
            this.f6245b = fArr2;
        }
        this.f6245b[i] = floatValue;
        this.f6246c++;
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m3538a();
        bnk.m3260i(collection);
        if (!(collection instanceof bmx)) {
            return super.addAll(collection);
        }
        bmx bmxVar = (bmx) collection;
        int i = bmxVar.f6246c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f6246c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f6245b;
            if (i3 > fArr.length) {
                this.f6245b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(bmxVar.f6245b, 0, this.f6245b, this.f6246c, bmxVar.f6246c);
            this.f6246c = i3;
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
        if (i < this.f6246c) {
            throw new IllegalArgumentException();
        }
        return new bmx(Arrays.copyOf(this.f6245b, i), this.f6246c);
    }

    /* renamed from: e */
    public final void m3316e(float f) {
        m3538a();
        int i = this.f6246c;
        float[] fArr = this.f6245b;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f6245b = fArr2;
        }
        float[] fArr3 = this.f6245b;
        int i2 = this.f6246c;
        this.f6246c = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bmx)) {
            return super.equals(obj);
        }
        bmx bmxVar = (bmx) obj;
        if (this.f6246c != bmxVar.f6246c) {
            return false;
        }
        float[] fArr = bmxVar.f6245b;
        for (int i = 0; i < this.f6246c; i++) {
            if (Float.floatToIntBits(this.f6245b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        m3314g(i);
        return Float.valueOf(this.f6245b[i]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f6246c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f6245b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            int i = this.f6246c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f6245b[i2] == floatValue) {
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
        m3314g(i);
        float[] fArr = this.f6245b;
        float f = fArr[i];
        if (i < this.f6246c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f6246c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        m3538a();
        if (i2 >= i) {
            float[] fArr = this.f6245b;
            System.arraycopy(fArr, i2, fArr, i, this.f6246c - i2);
            this.f6246c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        m3538a();
        m3314g(i);
        float[] fArr = this.f6245b;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6246c;
    }

    private bmx(float[] fArr, int i) {
        this.f6245b = fArr;
        this.f6246c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m3316e(((Float) obj).floatValue());
        return true;
    }
}
