package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aq */
/* loaded from: classes2.dex */
public final class C2559aq {

    /* renamed from: a */
    public static final C2559aq f4867a = new C2559aq(1.0f, 1.0f);

    /* renamed from: b */
    public final float f4868b;

    /* renamed from: c */
    public final float f4869c;

    /* renamed from: d */
    private final int f4870d;

    public C2559aq(float f, float f2) {
        C2616ce.m2687f(f > 0.0f);
        C2616ce.m2687f(f2 > 0.0f);
        this.f4868b = f;
        this.f4869c = f2;
        this.f4870d = Math.round(f * 1000.0f);
    }

    /* renamed from: a */
    public final long m4776a(long j) {
        return j * this.f4870d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2559aq c2559aq = (C2559aq) obj;
            if (this.f4868b == c2559aq.f4868b && this.f4869c == c2559aq.f4869c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.f4868b) + 527) * 31) + Float.floatToRawIntBits(this.f4869c);
    }

    public final String toString() {
        return C2628cq.m2577F("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f4868b), Float.valueOf(this.f4869c));
    }
}
