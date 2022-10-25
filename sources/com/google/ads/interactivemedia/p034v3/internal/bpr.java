package com.google.ads.interactivemedia.p034v3.internal;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpr */
/* loaded from: classes2.dex */
final class bpr extends bpt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bpr(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: a */
    public final byte mo2934a(long j) {
        return Memory.peekByte((int) j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: b */
    public final double mo2933b(Object obj, long j) {
        return Double.longBitsToDouble(m2922m(obj, j));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: c */
    public final float mo2932c(Object obj, long j) {
        return Float.intBitsToFloat(m2923l(obj, j));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: d */
    public final void mo2931d(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray((int) j, bArr, (int) j2, (int) j3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: e */
    public final void mo2930e(Object obj, long j, boolean z) {
        if (bpu.f6400b) {
            bpu.m2906I(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            bpu.m2905J(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: f */
    public final void mo2929f(Object obj, long j, byte b) {
        if (bpu.f6400b) {
            bpu.m2906I(obj, j, b);
        } else {
            bpu.m2905J(obj, j, b);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: g */
    public final void mo2928g(Object obj, long j, double d) {
        m2918q(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: h */
    public final void mo2927h(Object obj, long j, float f) {
        m2919p(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpt
    /* renamed from: i */
    public final boolean mo2926i(Object obj, long j) {
        if (bpu.f6400b) {
            return bpu.m2880x(obj, j);
        }
        return bpu.m2879y(obj, j);
    }
}
