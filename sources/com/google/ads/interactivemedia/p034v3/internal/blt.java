package com.google.ads.interactivemedia.p034v3.internal;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blt */
/* loaded from: classes2.dex */
public final class blt extends blw {

    /* renamed from: f */
    private final byte[] f6017f;

    /* renamed from: g */
    private int f6018g;

    /* renamed from: h */
    private int f6019h;

    /* renamed from: i */
    private int f6020i;

    /* renamed from: j */
    private final int f6021j;

    /* renamed from: k */
    private int f6022k;

    /* renamed from: l */
    private int f6023l = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ blt(byte[] bArr, int i, int i2) {
        this.f6017f = bArr;
        this.f6018g = i2 + i;
        this.f6020i = i;
        this.f6021j = i;
    }

    /* renamed from: I */
    private final void m3496I() {
        int i = this.f6018g + this.f6019h;
        this.f6018g = i;
        int i2 = i - this.f6021j;
        int i3 = this.f6023l;
        if (i2 <= i3) {
            this.f6019h = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f6019h = i4;
        this.f6018g = i - i4;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: A */
    public final void mo3462A(int i) {
        this.f6023l = i;
        m3496I();
    }

    /* renamed from: B */
    public final void m3497B(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f6018g;
            int i3 = this.f6020i;
            if (i <= i2 - i3) {
                this.f6020i = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw bnm.m3253f();
        }
        throw bnm.m3250i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: C */
    public final boolean mo3461C() throws IOException {
        return this.f6020i == this.f6018g;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: D */
    public final boolean mo3460D() throws IOException {
        return m3491r() != 0;
    }

    /* renamed from: a */
    public final byte m3495a() throws IOException {
        int i = this.f6020i;
        if (i == this.f6018g) {
            throw bnm.m3250i();
        }
        byte[] bArr = this.f6017f;
        this.f6020i = i + 1;
        return bArr[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: b */
    public final double mo3455b() throws IOException {
        return Double.longBitsToDouble(m3492q());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: c */
    public final float mo3454c() throws IOException {
        return Float.intBitsToFloat(m3494i());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: d */
    public final int mo3453d() {
        return this.f6020i - this.f6021j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: e */
    public final int mo3452e(int i) throws bnm {
        if (i >= 0) {
            int mo3453d = i + mo3453d();
            if (mo3453d >= 0) {
                int i2 = this.f6023l;
                if (mo3453d <= i2) {
                    this.f6023l = mo3453d;
                    m3496I();
                    return i2;
                }
                throw bnm.m3250i();
            }
            throw bnm.m3252g();
        }
        throw bnm.m3253f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: f */
    public final int mo3451f() throws IOException {
        return m3493j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: g */
    public final int mo3450g() throws IOException {
        return m3494i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: h */
    public final int mo3449h() throws IOException {
        return m3493j();
    }

    /* renamed from: i */
    public final int m3494i() throws IOException {
        int i = this.f6020i;
        if (this.f6018g - i < 4) {
            throw bnm.m3250i();
        }
        byte[] bArr = this.f6017f;
        this.f6020i = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: k */
    public final int mo3448k() throws IOException {
        return m3494i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: l */
    public final int mo3447l() throws IOException {
        return m3458F(m3493j());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: m */
    public final int mo3446m() throws IOException {
        if (mo3461C()) {
            this.f6022k = 0;
            return 0;
        }
        int m3493j = m3493j();
        this.f6022k = m3493j;
        if (bqb.m2853a(m3493j) != 0) {
            return m3493j;
        }
        throw bnm.m3256c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: n */
    public final int mo3445n() throws IOException {
        return m3493j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: o */
    public final long mo3444o() throws IOException {
        return m3492q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: p */
    public final long mo3443p() throws IOException {
        return m3491r();
    }

    /* renamed from: q */
    public final long m3492q() throws IOException {
        int i = this.f6020i;
        if (this.f6018g - i < 8) {
            throw bnm.m3250i();
        }
        byte[] bArr = this.f6017f;
        this.f6020i = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* renamed from: s */
    final long m3490s() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m3495a = m3495a();
            j |= (m3495a & Byte.MAX_VALUE) << i;
            if ((m3495a & 128) == 0) {
                return j;
            }
        }
        throw bnm.m3254e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: t */
    public final long mo3442t() throws IOException {
        return m3492q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: u */
    public final long mo3441u() throws IOException {
        return m3457G(m3491r());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: v */
    public final long mo3440v() throws IOException {
        return m3491r();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: w */
    public final bls mo3439w() throws IOException {
        int m3493j = m3493j();
        if (m3493j > 0) {
            int i = this.f6018g;
            int i2 = this.f6020i;
            if (m3493j <= i - i2) {
                bls m3503u = bls.m3503u(this.f6017f, i2, m3493j);
                this.f6020i += m3493j;
                return m3503u;
            }
        }
        if (m3493j != 0) {
            if (m3493j > 0) {
                int i3 = this.f6018g;
                int i4 = this.f6020i;
                if (m3493j <= i3 - i4) {
                    int i5 = m3493j + i4;
                    this.f6020i = i5;
                    return bls.m3500x(Arrays.copyOfRange(this.f6017f, i4, i5));
                }
            }
            if (m3493j <= 0) {
                throw bnm.m3253f();
            }
            throw bnm.m3250i();
        }
        return bls.f6015b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: x */
    public final String mo3438x() throws IOException {
        int m3493j = m3493j();
        if (m3493j > 0) {
            int i = this.f6018g;
            int i2 = this.f6020i;
            if (m3493j <= i - i2) {
                String str = new String(this.f6017f, i2, m3493j, bnk.f6265b);
                this.f6020i += m3493j;
                return str;
            }
        }
        if (m3493j == 0) {
            return "";
        }
        if (m3493j < 0) {
            throw bnm.m3253f();
        }
        throw bnm.m3250i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: y */
    public final String mo3437y() throws IOException {
        int m3493j = m3493j();
        if (m3493j > 0) {
            int i = this.f6018g;
            int i2 = this.f6020i;
            if (m3493j <= i - i2) {
                String m2864h = bpy.m2864h(this.f6017f, i2, m3493j);
                this.f6020i += m3493j;
                return m2864h;
            }
        }
        if (m3493j == 0) {
            return "";
        }
        if (m3493j <= 0) {
            throw bnm.m3253f();
        }
        throw bnm.m3250i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: z */
    public final void mo3436z(int i) throws bnm {
        if (this.f6022k != i) {
            throw bnm.m3257b();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: E */
    public final boolean mo3459E(int i) throws IOException {
        int mo3446m;
        int m2852b = bqb.m2852b(i);
        int i2 = 0;
        if (m2852b == 0) {
            if (this.f6018g - this.f6020i < 10) {
                while (i2 < 10) {
                    if (m3495a() < 0) {
                        i2++;
                    }
                }
                throw bnm.m3254e();
            }
            while (i2 < 10) {
                byte[] bArr = this.f6017f;
                int i3 = this.f6020i;
                this.f6020i = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                }
            }
            throw bnm.m3254e();
            return true;
        } else if (m2852b == 1) {
            m3497B(8);
            return true;
        } else if (m2852b == 2) {
            m3497B(m3493j());
            return true;
        } else if (m2852b != 3) {
            if (m2852b != 4) {
                if (m2852b == 5) {
                    m3497B(4);
                    return true;
                }
                throw bnm.m3258a();
            }
            return false;
        } else {
            do {
                mo3446m = mo3446m();
                if (mo3446m == 0) {
                    break;
                }
            } while (mo3459E(mo3446m));
            mo3436z(bqb.m2851c(bqb.m2853a(i), 4));
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m3493j() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f6020i
            int r1 = r5.f6018g
            if (r1 != r0) goto L7
            goto L6c
        L7:
            byte[] r2 = r5.f6017f
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.f6020i = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6c
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L23
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L69
        L23:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L30
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2e:
            r1 = r3
            goto L69
        L30:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L69
        L3e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6c
        L69:
            r5.f6020i = r1
            return r0
        L6c:
            long r0 = r5.m3490s()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.blt.m3493j():int");
    }

    /* renamed from: r */
    public final long m3491r() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.f6020i;
        int i3 = this.f6018g;
        if (i3 != i2) {
            byte[] bArr = this.f6017f;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.f6020i = i4;
                return b;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << Ascii.f9767SO);
                    if (i8 >= 0) {
                        j = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            long j5 = (bArr[i5] << 28) ^ i9;
                            if (j5 < 0) {
                                int i10 = i7 + 1;
                                long j6 = j5 ^ (bArr[i7] << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i10 + 1;
                                    j5 = j6 ^ (bArr[i10] << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i10 = i7 + 1;
                                        j6 = j5 ^ (bArr[i7] << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i10 + 1;
                                            j = (j6 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                i10 = i7 + 1;
                                                if (bArr[i7] >= 0) {
                                                    j2 = j;
                                                    i5 = i10;
                                                    this.f6020i = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j3 ^ j6;
                                i5 = i10;
                                this.f6020i = i5;
                                return j2;
                            }
                            j4 = 266354560;
                            j = j5 ^ j4;
                        }
                    }
                    i5 = i7;
                    j2 = j;
                    this.f6020i = i5;
                    return j2;
                }
                i = i6 ^ (-128);
                j2 = i;
                this.f6020i = i5;
                return j2;
            }
        }
        return m3490s();
    }
}
