package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lx */
/* loaded from: classes2.dex */
public final class C2878lx {

    /* renamed from: a */
    final long f8071a;

    /* renamed from: b */
    final long f8072b;

    public C2878lx(long j, long j2) {
        this.f8071a = j;
        this.f8072b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2878lx c2878lx = (C2878lx) obj;
            if (this.f8071a == c2878lx.f8071a && this.f8072b == c2878lx.f8072b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f8071a) * 31) + ((int) this.f8072b);
    }
}
