package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blj */
/* loaded from: classes2.dex */
final class blj extends bld implements RandomAccess, bnj, bop {

    /* renamed from: a */
    private static final blj f6005a;

    /* renamed from: b */
    private boolean[] f6006b;

    /* renamed from: c */
    private int f6007c;

    static {
        blj bljVar = new blj(new boolean[0], 0);
        f6005a = bljVar;
        bljVar.mo3270b();
    }

    blj() {
        this(new boolean[10], 0);
    }

    /* renamed from: f */
    private final String m3516f(int i) {
        int i2 = this.f6007c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: g */
    private final void m3515g(int i) {
        if (i < 0 || i >= this.f6007c) {
            throw new IndexOutOfBoundsException(m3516f(i));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        m3538a();
        if (i < 0 || i > (i2 = this.f6007c)) {
            throw new IndexOutOfBoundsException(m3516f(i));
        }
        boolean[] zArr = this.f6006b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f6006b, i, zArr2, i + 1, this.f6007c - i);
            this.f6006b = zArr2;
        }
        this.f6006b[i] = booleanValue;
        this.f6007c++;
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m3538a();
        bnk.m3260i(collection);
        if (!(collection instanceof blj)) {
            return super.addAll(collection);
        }
        blj bljVar = (blj) collection;
        int i = bljVar.f6007c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f6007c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f6006b;
            if (i3 > zArr.length) {
                this.f6006b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(bljVar.f6006b, 0, this.f6006b, this.f6007c, bljVar.f6007c);
            this.f6007c = i3;
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
        if (i < this.f6007c) {
            throw new IllegalArgumentException();
        }
        return new blj(Arrays.copyOf(this.f6006b, i), this.f6007c);
    }

    /* renamed from: e */
    public final void m3517e(boolean z) {
        m3538a();
        int i = this.f6007c;
        boolean[] zArr = this.f6006b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f6006b = zArr2;
        }
        boolean[] zArr3 = this.f6006b;
        int i2 = this.f6007c;
        this.f6007c = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof blj)) {
            return super.equals(obj);
        }
        blj bljVar = (blj) obj;
        if (this.f6007c != bljVar.f6007c) {
            return false;
        }
        boolean[] zArr = bljVar.f6006b;
        for (int i = 0; i < this.f6007c; i++) {
            if (this.f6006b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        m3515g(i);
        return Boolean.valueOf(this.f6006b[i]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f6007c; i2++) {
            i = (i * 31) + bnk.m3268a(this.f6006b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int i = this.f6007c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f6006b[i2] == booleanValue) {
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
        m3515g(i);
        boolean[] zArr = this.f6006b;
        boolean z = zArr[i];
        if (i < this.f6007c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f6007c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        m3538a();
        if (i2 >= i) {
            boolean[] zArr = this.f6006b;
            System.arraycopy(zArr, i2, zArr, i, this.f6007c - i2);
            this.f6007c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        m3538a();
        m3515g(i);
        boolean[] zArr = this.f6006b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6007c;
    }

    private blj(boolean[] zArr, int i) {
        this.f6006b = zArr;
        this.f6007c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m3517e(((Boolean) obj).booleanValue());
        return true;
    }
}
