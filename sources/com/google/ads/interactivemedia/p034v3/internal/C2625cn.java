package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cn */
/* loaded from: classes2.dex */
public final class C2625cn {

    /* renamed from: a */
    private long[] f6952a = new long[10];

    /* renamed from: b */
    private Object[] f6953b = new Object[10];

    /* renamed from: c */
    private int f6954c;

    /* renamed from: d */
    private int f6955d;

    /* renamed from: f */
    private final Object m2592f() {
        C2616ce.m2685h(this.f6955d > 0);
        Object[] objArr = this.f6953b;
        int i = this.f6954c;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f6954c = (i + 1) % objArr.length;
        this.f6955d--;
        return obj;
    }

    /* renamed from: a */
    public final synchronized int m2597a() {
        return this.f6955d;
    }

    /* renamed from: b */
    public final synchronized Object m2596b() {
        if (this.f6955d == 0) {
            return null;
        }
        return m2592f();
    }

    /* renamed from: c */
    public final synchronized Object m2595c(long j) {
        Object obj;
        obj = null;
        while (this.f6955d > 0 && j - this.f6952a[this.f6954c] >= 0) {
            obj = m2592f();
        }
        return obj;
    }

    /* renamed from: d */
    public final synchronized void m2594d(long j, Object obj) {
        int i = this.f6955d;
        if (i > 0) {
            if (j <= this.f6952a[((this.f6954c + i) - 1) % this.f6953b.length]) {
                m2593e();
            }
        }
        int length = this.f6953b.length;
        if (this.f6955d >= length) {
            int i2 = length + length;
            long[] jArr = new long[i2];
            Object[] objArr = new Object[i2];
            int i3 = this.f6954c;
            int i4 = length - i3;
            System.arraycopy(this.f6952a, i3, jArr, 0, i4);
            System.arraycopy(this.f6953b, this.f6954c, objArr, 0, i4);
            int i5 = this.f6954c;
            if (i5 > 0) {
                System.arraycopy(this.f6952a, 0, jArr, i4, i5);
                System.arraycopy(this.f6953b, 0, objArr, i4, this.f6954c);
            }
            this.f6952a = jArr;
            this.f6953b = objArr;
            this.f6954c = 0;
        }
        int i6 = this.f6954c;
        int i7 = this.f6955d;
        Object[] objArr2 = this.f6953b;
        int length2 = (i6 + i7) % objArr2.length;
        this.f6952a[length2] = j;
        objArr2[length2] = obj;
        this.f6955d = i7 + 1;
    }

    /* renamed from: e */
    public final synchronized void m2593e() {
        this.f6954c = 0;
        this.f6955d = 0;
        Arrays.fill(this.f6953b, (Object) null);
    }
}
