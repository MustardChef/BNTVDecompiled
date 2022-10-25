package com.google.ads.interactivemedia.p034v3.internal;

import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qx */
/* loaded from: classes2.dex */
final class C3013qx {

    /* renamed from: a */
    private int f8665a = 0;

    /* renamed from: b */
    private int f8666b = -1;

    /* renamed from: c */
    private int f8667c = 0;

    /* renamed from: d */
    private int[] f8668d;

    /* renamed from: e */
    private int f8669e;

    public C3013qx() {
        int[] iArr = new int[16];
        this.f8668d = iArr;
        this.f8669e = iArr.length - 1;
    }

    /* renamed from: a */
    public final int m1268a() {
        int i = this.f8667c;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f8668d;
        int i2 = this.f8665a;
        int i3 = iArr[i2];
        this.f8665a = (i2 + 1) & this.f8669e;
        this.f8667c = i - 1;
        return i3;
    }

    /* renamed from: b */
    public final void m1267b(int i) {
        int i2 = this.f8667c;
        int[] iArr = this.f8668d;
        int length = iArr.length;
        if (i2 == length) {
            int i3 = length + length;
            if (i3 >= 0) {
                int[] iArr2 = new int[i3];
                int i4 = this.f8665a;
                int i5 = length - i4;
                System.arraycopy(iArr, i4, iArr2, 0, i5);
                System.arraycopy(this.f8668d, 0, iArr2, i5, i4);
                this.f8665a = 0;
                this.f8666b = this.f8667c - 1;
                this.f8668d = iArr2;
                this.f8669e = iArr2.length - 1;
                iArr = iArr2;
            } else {
                throw new IllegalStateException();
            }
        }
        int i6 = (this.f8666b + 1) & this.f8669e;
        this.f8666b = i6;
        iArr[i6] = i;
        this.f8667c++;
    }

    /* renamed from: c */
    public final void m1266c() {
        this.f8665a = 0;
        this.f8666b = -1;
        this.f8667c = 0;
    }

    /* renamed from: d */
    public final boolean m1265d() {
        return this.f8667c == 0;
    }
}
