package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnz */
/* loaded from: classes2.dex */
final class bnz extends bld implements RandomAccess, bnj, bop {

    /* renamed from: a */
    private static final bnz f6299a;

    /* renamed from: b */
    private long[] f6300b;

    /* renamed from: c */
    private int f6301c;

    static {
        bnz bnzVar = new bnz(new long[0], 0);
        f6299a = bnzVar;
        bnzVar.mo3270b();
    }

    bnz() {
        this(new long[10], 0);
    }

    /* renamed from: g */
    private final String m3198g(int i) {
        int i2 = this.f6301c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: h */
    private final void m3197h(int i) {
        if (i < 0 || i >= this.f6301c) {
            throw new IndexOutOfBoundsException(m3198g(i));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        m3538a();
        if (i < 0 || i > (i2 = this.f6301c)) {
            throw new IndexOutOfBoundsException(m3198g(i));
        }
        long[] jArr = this.f6300b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f6300b, i, jArr2, i + 1, this.f6301c - i);
            this.f6300b = jArr2;
        }
        this.f6300b[i] = longValue;
        this.f6301c++;
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m3538a();
        bnk.m3260i(collection);
        if (!(collection instanceof bnz)) {
            return super.addAll(collection);
        }
        bnz bnzVar = (bnz) collection;
        int i = bnzVar.f6301c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f6301c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f6300b;
            if (i3 > jArr.length) {
                this.f6300b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(bnzVar.f6300b, 0, this.f6300b, this.f6301c, bnzVar.f6301c);
            this.f6301c = i3;
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
        if (i < this.f6301c) {
            throw new IllegalArgumentException();
        }
        return new bnz(Arrays.copyOf(this.f6300b, i), this.f6301c);
    }

    /* renamed from: e */
    public final long m3200e(int i) {
        m3197h(i);
        return this.f6300b[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bnz)) {
            return super.equals(obj);
        }
        bnz bnzVar = (bnz) obj;
        if (this.f6301c != bnzVar.f6301c) {
            return false;
        }
        long[] jArr = bnzVar.f6300b;
        for (int i = 0; i < this.f6301c; i++) {
            if (this.f6300b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public final void m3199f(long j) {
        m3538a();
        int i = this.f6301c;
        long[] jArr = this.f6300b;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f6300b = jArr2;
        }
        long[] jArr3 = this.f6300b;
        int i2 = this.f6301c;
        this.f6301c = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return Long.valueOf(m3200e(i));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f6301c; i2++) {
            i = (i * 31) + bnk.m3266c(this.f6300b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int i = this.f6301c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f6300b[i2] == longValue) {
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
        m3197h(i);
        long[] jArr = this.f6300b;
        long j = jArr[i];
        if (i < this.f6301c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f6301c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        m3538a();
        if (i2 >= i) {
            long[] jArr = this.f6300b;
            System.arraycopy(jArr, i2, jArr, i, this.f6301c - i2);
            this.f6301c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        m3538a();
        m3197h(i);
        long[] jArr = this.f6300b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6301c;
    }

    private bnz(long[] jArr, int i) {
        this.f6300b = jArr;
        this.f6301c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m3199f(((Long) obj).longValue());
        return true;
    }
}
