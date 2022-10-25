package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.g */
/* loaded from: classes2.dex */
public final class C2719g {

    /* renamed from: a */
    public final int f7336a;

    /* renamed from: b */
    public final int f7337b;

    /* renamed from: c */
    public final int f7338c;

    /* renamed from: d */
    public final byte[] f7339d;

    /* renamed from: e */
    private int f7340e;

    public C2719g(int i, int i2, int i3, byte[] bArr) {
        this.f7336a = i;
        this.f7337b = i2;
        this.f7338c = i3;
        this.f7339d = bArr;
    }

    /* renamed from: a */
    public static int m2295a(int i) {
        if (i != 1) {
            if (i != 9) {
                return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
            }
            return 6;
        }
        return 1;
    }

    /* renamed from: b */
    public static int m2294b(int i) {
        if (i != 1) {
            if (i != 16) {
                if (i != 18) {
                    return (i == 6 || i == 7) ? 3 : -1;
                }
                return 7;
            }
            return 6;
        }
        return 3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2719g c2719g = (C2719g) obj;
            if (this.f7336a == c2719g.f7336a && this.f7337b == c2719g.f7337b && this.f7338c == c2719g.f7338c && Arrays.equals(this.f7339d, c2719g.f7339d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f7340e;
        if (i == 0) {
            int hashCode = ((((((this.f7336a + 527) * 31) + this.f7337b) * 31) + this.f7338c) * 31) + Arrays.hashCode(this.f7339d);
            this.f7340e = hashCode;
            return hashCode;
        }
        return i;
    }

    public final String toString() {
        int i = this.f7336a;
        int i2 = this.f7337b;
        int i3 = this.f7338c;
        boolean z = this.f7339d != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }
}
