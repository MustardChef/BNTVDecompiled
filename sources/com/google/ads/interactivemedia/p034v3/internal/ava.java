package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ava */
/* loaded from: classes2.dex */
public class ava {

    /* renamed from: a */
    Object[] f5160a;

    /* renamed from: b */
    int f5161b;

    /* renamed from: c */
    boolean f5162c;

    ava() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ava(byte[] bArr) {
        this();
        axd.m4413I(4, "initialCapacity");
        this.f5160a = new Object[4];
        this.f5161b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m4527a(int i, int i2) {
        int i3 = i + (i >> 1) + 1;
        if (i3 < i2) {
            int highestOneBit = Integer.highestOneBit(i2 - 1);
            i3 = highestOneBit + highestOneBit;
        }
        if (i3 < 0) {
            return Integer.MAX_VALUE;
        }
        return i3;
    }

    /* renamed from: d */
    private final void m4524d(int i) {
        Object[] objArr = this.f5160a;
        int length = objArr.length;
        if (length < i) {
            this.f5160a = Arrays.copyOf(objArr, m4527a(length, i));
            this.f5162c = false;
        } else if (this.f5162c) {
            this.f5160a = (Object[]) objArr.clone();
            this.f5162c = false;
        }
    }

    /* renamed from: b */
    public final void m4526b(Object... objArr) {
        int length = objArr.length;
        axd.m4398n(objArr, length);
        m4524d(this.f5161b + length);
        System.arraycopy(objArr, 0, this.f5160a, this.f5161b, length);
        this.f5161b += length;
    }

    /* renamed from: c */
    public final void m4525c(Object obj) {
        atm.m4612j(obj);
        m4524d(this.f5161b + 1);
        Object[] objArr = this.f5160a;
        int i = this.f5161b;
        this.f5161b = i + 1;
        objArr[i] = obj;
    }
}
