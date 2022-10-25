package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blw */
/* loaded from: classes2.dex */
public abstract class blw {

    /* renamed from: e */
    public static final /* synthetic */ int f6044e = 0;

    /* renamed from: f */
    private static volatile int f6045f = 100;

    /* renamed from: a */
    int f6046a;

    /* renamed from: b */
    final int f6047b = f6045f;

    /* renamed from: c */
    final int f6048c = Integer.MAX_VALUE;

    /* renamed from: d */
    bly f6049d;

    /* renamed from: F */
    public static int m3458F(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* renamed from: G */
    public static long m3457G(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: H */
    public static blw m3456H(byte[] bArr, int i, int i2, boolean z) {
        blt bltVar = new blt(bArr, i, i2);
        try {
            bltVar.mo3452e(i2);
            return bltVar;
        } catch (bnm e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: A */
    public abstract void mo3462A(int i);

    /* renamed from: C */
    public abstract boolean mo3461C() throws IOException;

    /* renamed from: D */
    public abstract boolean mo3460D() throws IOException;

    /* renamed from: E */
    public abstract boolean mo3459E(int i) throws IOException;

    /* renamed from: b */
    public abstract double mo3455b() throws IOException;

    /* renamed from: c */
    public abstract float mo3454c() throws IOException;

    /* renamed from: d */
    public abstract int mo3453d();

    /* renamed from: e */
    public abstract int mo3452e(int i) throws bnm;

    /* renamed from: f */
    public abstract int mo3451f() throws IOException;

    /* renamed from: g */
    public abstract int mo3450g() throws IOException;

    /* renamed from: h */
    public abstract int mo3449h() throws IOException;

    /* renamed from: k */
    public abstract int mo3448k() throws IOException;

    /* renamed from: l */
    public abstract int mo3447l() throws IOException;

    /* renamed from: m */
    public abstract int mo3446m() throws IOException;

    /* renamed from: n */
    public abstract int mo3445n() throws IOException;

    /* renamed from: o */
    public abstract long mo3444o() throws IOException;

    /* renamed from: p */
    public abstract long mo3443p() throws IOException;

    /* renamed from: t */
    public abstract long mo3442t() throws IOException;

    /* renamed from: u */
    public abstract long mo3441u() throws IOException;

    /* renamed from: v */
    public abstract long mo3440v() throws IOException;

    /* renamed from: w */
    public abstract bls mo3439w() throws IOException;

    /* renamed from: x */
    public abstract String mo3438x() throws IOException;

    /* renamed from: y */
    public abstract String mo3437y() throws IOException;

    /* renamed from: z */
    public abstract void mo3436z(int i) throws bnm;
}
