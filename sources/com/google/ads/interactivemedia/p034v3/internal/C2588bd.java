package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bd */
/* loaded from: classes2.dex */
public final class C2588bd {

    /* renamed from: a */
    public static final C2588bd f5439a = new C2588bd(new C2587bc[0]);

    /* renamed from: b */
    public final int f5440b;

    /* renamed from: c */
    private final C2587bc[] f5441c;

    /* renamed from: d */
    private int f5442d;

    public C2588bd(C2587bc... c2587bcArr) {
        this.f5441c = c2587bcArr;
        this.f5440b = c2587bcArr.length;
    }

    /* renamed from: a */
    public final int m4122a(C2587bc c2587bc) {
        for (int i = 0; i < this.f5440b; i++) {
            if (this.f5441c[i] == c2587bc) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public final C2587bc m4121b(int i) {
        return this.f5441c[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2588bd c2588bd = (C2588bd) obj;
            if (this.f5440b == c2588bd.f5440b && Arrays.equals(this.f5441c, c2588bd.f5441c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f5442d;
        if (i == 0) {
            int hashCode = Arrays.hashCode(this.f5441c);
            this.f5442d = hashCode;
            return hashCode;
        }
        return i;
    }
}
