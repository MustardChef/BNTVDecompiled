package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zt */
/* loaded from: classes2.dex */
public final class C3252zt {

    /* renamed from: a */
    public final int f9618a;

    /* renamed from: b */
    public final byte[] f9619b;

    /* renamed from: c */
    public final int f9620c;

    /* renamed from: d */
    public final int f9621d;

    public C3252zt(int i, byte[] bArr, int i2, int i3) {
        this.f9618a = i;
        this.f9619b = bArr;
        this.f9620c = i2;
        this.f9621d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C3252zt c3252zt = (C3252zt) obj;
            if (this.f9618a == c3252zt.f9618a && this.f9620c == c3252zt.f9620c && this.f9621d == c3252zt.f9621d && Arrays.equals(this.f9619b, c3252zt.f9619b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f9618a * 31) + Arrays.hashCode(this.f9619b)) * 31) + this.f9620c) * 31) + this.f9621d;
    }
}
