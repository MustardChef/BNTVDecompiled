package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bf */
/* loaded from: classes2.dex */
public final class C2590bf {

    /* renamed from: a */
    private final InterfaceC2589be[] f5625a;

    /* renamed from: b */
    private int f5626b;

    public C2590bf(InterfaceC2589be... interfaceC2589beArr) {
        this.f5625a = interfaceC2589beArr;
        int length = interfaceC2589beArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f5625a, ((C2590bf) obj).f5625a);
    }

    public final int hashCode() {
        int i = this.f5626b;
        if (i == 0) {
            int hashCode = Arrays.hashCode(this.f5625a) + 527;
            this.f5626b = hashCode;
            return hashCode;
        }
        return i;
    }
}
