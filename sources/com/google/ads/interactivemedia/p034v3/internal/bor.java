package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bor */
/* loaded from: classes2.dex */
final class bor extends bld implements RandomAccess {

    /* renamed from: a */
    private static final bor f6346a;

    /* renamed from: b */
    private Object[] f6347b;

    /* renamed from: c */
    private int f6348c;

    static {
        bor borVar = new bor(new Object[0], 0);
        f6346a = borVar;
        borVar.mo3270b();
    }

    bor() {
        this(new Object[10], 0);
    }

    /* renamed from: e */
    public static bor m3116e() {
        return f6346a;
    }

    /* renamed from: f */
    private final String m3115f(int i) {
        int i2 = this.f6348c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: g */
    private final void m3114g(int i) {
        if (i < 0 || i >= this.f6348c) {
            throw new IndexOutOfBoundsException(m3115f(i));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        m3538a();
        if (i < 0 || i > (i2 = this.f6348c)) {
            throw new IndexOutOfBoundsException(m3115f(i));
        }
        Object[] objArr = this.f6347b;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f6347b, i, objArr2, i + 1, this.f6348c - i);
            this.f6347b = objArr2;
        }
        this.f6347b[i] = obj;
        this.f6348c++;
        this.modCount++;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnj
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ bnj mo3117d(int i) {
        if (i < this.f6348c) {
            throw new IllegalArgumentException();
        }
        return new bor(Arrays.copyOf(this.f6347b, i), this.f6348c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        m3114g(i);
        return this.f6347b[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i2;
        m3538a();
        m3114g(i);
        Object[] objArr = this.f6347b;
        Object obj = objArr[i];
        if (i < this.f6348c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.f6348c--;
        this.modCount++;
        return obj;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        m3538a();
        m3114g(i);
        Object[] objArr = this.f6347b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6348c;
    }

    private bor(Object[] objArr, int i) {
        this.f6347b = objArr;
        this.f6348c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bld, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        m3538a();
        int i = this.f6348c;
        Object[] objArr = this.f6347b;
        if (i == objArr.length) {
            this.f6347b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f6347b;
        int i2 = this.f6348c;
        this.f6348c = i2 + 1;
        objArr2[i2] = obj;
        this.modCount++;
        return true;
    }
}
