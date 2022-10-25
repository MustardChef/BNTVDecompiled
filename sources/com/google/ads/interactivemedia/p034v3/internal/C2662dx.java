package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dx */
/* loaded from: classes2.dex */
public class C2662dx {

    /* renamed from: a */
    private int f7077a;

    public C2662dx() {
    }

    public C2662dx(byte[] bArr) {
        this.f7077a = 0;
    }

    /* renamed from: a */
    public final void m2467a(int i) {
        this.f7077a = i | this.f7077a;
    }

    /* renamed from: b */
    public void mo1278b() {
        this.f7077a = 0;
    }

    /* renamed from: c */
    public final void m2466c(int i) {
        this.f7077a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean m2465d(int i) {
        return (this.f7077a & i) == i;
    }

    /* renamed from: e */
    public final boolean m2464e() {
        return m2465d(268435456);
    }

    /* renamed from: f */
    public final boolean m2463f() {
        return m2465d(Integer.MIN_VALUE);
    }

    /* renamed from: g */
    public final boolean m2462g() {
        return m2465d(4);
    }

    /* renamed from: h */
    public final boolean m2461h() {
        return m2465d(1);
    }

    /* renamed from: i */
    public final int m2460i() {
        return this.f7077a;
    }

    /* renamed from: j */
    public final void m2459j(Object obj, Object obj2) {
        if (this.f7077a == 0 && obj != obj2) {
            if (obj == null) {
                this.f7077a = -1;
            } else if (obj2 == null) {
                this.f7077a = 1;
            } else if (obj.getClass().isArray()) {
                int i = 0;
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    long[] jArr2 = (long[]) obj2;
                    if (this.f7077a == 0 && jArr != jArr2) {
                        int length = jArr.length;
                        int length2 = jArr2.length;
                        if (length != length2) {
                            this.f7077a = length >= length2 ? 1 : -1;
                            return;
                        }
                        while (i < jArr.length && this.f7077a == 0) {
                            this.f7077a = (jArr[i] > jArr2[i] ? 1 : (jArr[i] == jArr2[i] ? 0 : -1));
                            i++;
                        }
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    int[] iArr2 = (int[]) obj2;
                    if (this.f7077a != 0 || iArr == iArr2) {
                        return;
                    }
                    int length3 = iArr.length;
                    int length4 = iArr2.length;
                    if (length3 != length4) {
                        this.f7077a = length3 >= length4 ? 1 : -1;
                        return;
                    }
                    for (int i2 = 0; i2 < iArr.length && this.f7077a == 0; i2++) {
                        int i3 = iArr[i2];
                        int i4 = iArr2[i2];
                        this.f7077a = i3 == i4 ? 0 : i3 < i4 ? -1 : 1;
                    }
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    short[] sArr2 = (short[]) obj2;
                    if (this.f7077a != 0 || sArr == sArr2) {
                        return;
                    }
                    int length5 = sArr.length;
                    int length6 = sArr2.length;
                    if (length5 != length6) {
                        this.f7077a = length5 >= length6 ? 1 : -1;
                        return;
                    }
                    while (i < sArr.length && this.f7077a == 0) {
                        this.f7077a = sArr[i] - sArr2[i];
                        i++;
                    }
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    char[] cArr2 = (char[]) obj2;
                    if (this.f7077a != 0 || cArr == cArr2) {
                        return;
                    }
                    int length7 = cArr.length;
                    int length8 = cArr2.length;
                    if (length7 != length8) {
                        this.f7077a = length7 >= length8 ? 1 : -1;
                        return;
                    }
                    while (i < cArr.length && this.f7077a == 0) {
                        this.f7077a = cArr[i] - cArr2[i];
                        i++;
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = (byte[]) obj2;
                    if (this.f7077a != 0 || bArr == bArr2) {
                        return;
                    }
                    int length9 = bArr.length;
                    int length10 = bArr2.length;
                    if (length9 != length10) {
                        this.f7077a = length9 >= length10 ? 1 : -1;
                        return;
                    }
                    while (i < bArr.length && this.f7077a == 0) {
                        this.f7077a = bArr[i] - bArr2[i];
                        i++;
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    double[] dArr2 = (double[]) obj2;
                    if (this.f7077a != 0 || dArr == dArr2) {
                        return;
                    }
                    int length11 = dArr.length;
                    int length12 = dArr2.length;
                    if (length11 != length12) {
                        this.f7077a = length11 >= length12 ? 1 : -1;
                        return;
                    }
                    while (i < dArr.length && this.f7077a == 0) {
                        this.f7077a = Double.compare(dArr[i], dArr2[i]);
                        i++;
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    float[] fArr2 = (float[]) obj2;
                    if (this.f7077a != 0 || fArr == fArr2) {
                        return;
                    }
                    int length13 = fArr.length;
                    int length14 = fArr2.length;
                    if (length13 != length14) {
                        this.f7077a = length13 >= length14 ? 1 : -1;
                        return;
                    }
                    while (i < fArr.length && this.f7077a == 0) {
                        this.f7077a = Float.compare(fArr[i], fArr2[i]);
                        i++;
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    boolean[] zArr2 = (boolean[]) obj2;
                    if (this.f7077a != 0 || zArr == zArr2) {
                        return;
                    }
                    int length15 = zArr.length;
                    int length16 = zArr2.length;
                    if (length15 != length16) {
                        this.f7077a = length15 >= length16 ? 1 : -1;
                        return;
                    }
                    while (i < zArr.length && this.f7077a == 0) {
                        boolean z = zArr[i];
                        if (z != zArr2[i]) {
                            if (z) {
                                this.f7077a = 1;
                            } else {
                                this.f7077a = -1;
                            }
                        }
                        i++;
                    }
                } else {
                    Object[] objArr = (Object[]) obj;
                    Object[] objArr2 = (Object[]) obj2;
                    if (this.f7077a != 0 || objArr == objArr2) {
                        return;
                    }
                    int length17 = objArr.length;
                    int length18 = objArr2.length;
                    if (length17 != length18) {
                        this.f7077a = length17 >= length18 ? 1 : -1;
                        return;
                    }
                    while (i < objArr.length && this.f7077a == 0) {
                        m2459j(objArr[i], objArr2[i]);
                        i++;
                    }
                }
            } else {
                this.f7077a = ((Comparable) obj).compareTo(obj2);
            }
        }
    }

    /* renamed from: k */
    public final C2662dx m2458k(Object obj, Object obj2) {
        m2459j(obj, obj2);
        return this;
    }
}
