package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tn */
/* loaded from: classes2.dex */
final class C3084tn {

    /* renamed from: a */
    public final int f8927a;

    /* renamed from: b */
    public final boolean f8928b;

    public C3084tn(int i, boolean z) {
        this.f8927a = i;
        this.f8928b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C3084tn c3084tn = (C3084tn) obj;
            if (this.f8927a == c3084tn.f8927a && this.f8928b == c3084tn.f8928b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f8927a * 31) + (this.f8928b ? 1 : 0);
    }
}
