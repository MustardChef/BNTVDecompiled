package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bm */
/* loaded from: classes2.dex */
public final class C2597bm {

    /* renamed from: a */
    public static final C2597bm f6056a = new C2597bm(0, 0, 0, 1.0f);

    /* renamed from: b */
    public final int f6057b;

    /* renamed from: c */
    public final int f6058c;

    /* renamed from: d */
    public final int f6059d;

    /* renamed from: e */
    public final float f6060e;

    public C2597bm(int i, int i2, int i3, float f) {
        this.f6057b = i;
        this.f6058c = i2;
        this.f6059d = i3;
        this.f6060e = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2597bm) {
            C2597bm c2597bm = (C2597bm) obj;
            if (this.f6057b == c2597bm.f6057b && this.f6058c == c2597bm.f6058c && this.f6059d == c2597bm.f6059d && this.f6060e == c2597bm.f6060e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f6057b + bqk.f6556bP) * 31) + this.f6058c) * 31) + this.f6059d) * 31) + Float.floatToRawIntBits(this.f6060e);
    }
}
