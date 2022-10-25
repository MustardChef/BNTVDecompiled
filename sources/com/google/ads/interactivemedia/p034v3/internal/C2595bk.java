package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bk */
/* loaded from: classes2.dex */
public final class C2595bk {

    /* renamed from: a */
    private final C2587bc f5886a;

    /* renamed from: b */
    private final int[] f5887b;

    /* renamed from: c */
    private final int f5888c;

    /* renamed from: d */
    private final boolean[] f5889d;

    public C2595bk(C2587bc c2587bc, int[] iArr, int i, boolean[] zArr) {
        int i2 = c2587bc.f5406a;
        boolean z = false;
        if (i2 == iArr.length && i2 == zArr.length) {
            z = true;
        }
        C2616ce.m2687f(z);
        this.f5886a = c2587bc;
        this.f5887b = (int[]) iArr.clone();
        this.f5888c = i;
        this.f5889d = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2595bk c2595bk = (C2595bk) obj;
            if (this.f5888c == c2595bk.f5888c && this.f5886a.equals(c2595bk.f5886a) && Arrays.equals(this.f5887b, c2595bk.f5887b) && Arrays.equals(this.f5889d, c2595bk.f5889d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f5886a.hashCode() * 31) + Arrays.hashCode(this.f5887b)) * 31) + this.f5888c) * 31) + Arrays.hashCode(this.f5889d);
    }
}
