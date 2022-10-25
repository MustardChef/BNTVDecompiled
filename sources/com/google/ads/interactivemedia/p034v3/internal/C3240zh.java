package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zh */
/* loaded from: classes2.dex */
public final class C3240zh {

    /* renamed from: a */
    public int f9563a;

    /* renamed from: b */
    public String f9564b;

    /* renamed from: c */
    public int f9565c;

    /* renamed from: d */
    public int f9566d;

    /* renamed from: e */
    public int f9567e;

    /* renamed from: f */
    public int f9568f;

    /* renamed from: g */
    public int f9569g;

    /* renamed from: a */
    public final boolean m480a(int i) {
        boolean m467m;
        int i2;
        int i3;
        int i4;
        int i5;
        String[] strArr;
        int[] iArr;
        int m468l;
        int[] iArr2;
        int[] iArr3;
        int i6;
        int[] iArr4;
        int[] iArr5;
        int i7;
        int[] iArr6;
        m467m = C3241zi.m467m(i);
        if (!m467m || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.f9563a = i2;
        strArr = C3241zi.f9570a;
        this.f9564b = strArr[3 - i3];
        iArr = C3241zi.f9571b;
        int i8 = iArr[i5];
        this.f9566d = i8;
        if (i2 == 2) {
            i8 /= 2;
            this.f9566d = i8;
        } else if (i2 == 0) {
            i8 /= 4;
            this.f9566d = i8;
        }
        int i9 = (i >>> 9) & 1;
        m468l = C3241zi.m468l(i2, i3);
        this.f9569g = m468l;
        if (i3 == 3) {
            if (i2 == 3) {
                iArr6 = C3241zi.f9572c;
                i7 = iArr6[i4 - 1];
            } else {
                iArr5 = C3241zi.f9573d;
                i7 = iArr5[i4 - 1];
            }
            this.f9568f = i7;
            this.f9565c = (((i7 * 12) / i8) + i9) * 4;
        } else {
            if (i2 == 3) {
                if (i3 == 2) {
                    iArr4 = C3241zi.f9574e;
                    i6 = iArr4[i4 - 1];
                } else {
                    iArr3 = C3241zi.f9575f;
                    i6 = iArr3[i4 - 1];
                }
                this.f9568f = i6;
                this.f9565c = ((i6 * 144) / i8) + i9;
            } else {
                iArr2 = C3241zi.f9576g;
                int i10 = iArr2[i4 - 1];
                this.f9568f = i10;
                this.f9565c = (((i3 == 1 ? 72 : 144) * i10) / i8) + i9;
            }
        }
        this.f9567e = ((i >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
