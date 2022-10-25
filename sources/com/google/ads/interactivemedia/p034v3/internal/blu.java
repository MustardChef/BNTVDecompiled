package com.google.ads.interactivemedia.p034v3.internal;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blu */
/* loaded from: classes2.dex */
final class blu extends blw {

    /* renamed from: f */
    private final Iterable f6024f;

    /* renamed from: g */
    private final Iterator f6025g;

    /* renamed from: h */
    private ByteBuffer f6026h;

    /* renamed from: i */
    private int f6027i;

    /* renamed from: j */
    private int f6028j;

    /* renamed from: l */
    private int f6030l;

    /* renamed from: n */
    private long f6032n;

    /* renamed from: o */
    private long f6033o;

    /* renamed from: p */
    private long f6034p;

    /* renamed from: q */
    private long f6035q;

    /* renamed from: k */
    private int f6029k = Integer.MAX_VALUE;

    /* renamed from: m */
    private int f6031m = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ blu(Iterable iterable, int i) {
        this.f6027i = i;
        this.f6024f = iterable;
        this.f6025g = iterable.iterator();
        if (i == 0) {
            this.f6026h = bnk.f6267d;
            this.f6032n = 0L;
            this.f6033o = 0L;
            this.f6035q = 0L;
            this.f6034p = 0L;
            return;
        }
        m3484M();
    }

    /* renamed from: I */
    private final int m3488I() {
        return (int) (((this.f6027i - this.f6031m) - this.f6032n) + this.f6033o);
    }

    /* renamed from: J */
    private final long m3487J() {
        return this.f6035q - this.f6032n;
    }

    /* renamed from: K */
    private final void m3486K() throws bnm {
        if (!this.f6025g.hasNext()) {
            throw bnm.m3250i();
        }
        m3484M();
    }

    /* renamed from: L */
    private final void m3485L() {
        int i = this.f6027i + this.f6028j;
        this.f6027i = i;
        int i2 = this.f6029k;
        if (i <= i2) {
            this.f6028j = 0;
            return;
        }
        int i3 = i - i2;
        this.f6028j = i3;
        this.f6027i = i - i3;
    }

    /* renamed from: M */
    private final void m3484M() {
        ByteBuffer byteBuffer = (ByteBuffer) this.f6025g.next();
        this.f6026h = byteBuffer;
        this.f6031m += (int) (this.f6032n - this.f6033o);
        long position = byteBuffer.position();
        this.f6032n = position;
        this.f6033o = position;
        this.f6035q = this.f6026h.limit();
        long m2899e = bpu.m2899e(this.f6026h);
        this.f6034p = m2899e;
        this.f6032n += m2899e;
        this.f6033o += m2899e;
        this.f6035q += m2899e;
    }

    /* renamed from: N */
    private final void m3483N(byte[] bArr, int i) throws IOException {
        if (i > m3488I()) {
            if (i > 0) {
                throw bnm.m3250i();
            }
            return;
        }
        int i2 = i;
        while (i2 > 0) {
            if (m3487J() == 0) {
                m3486K();
            }
            int min = Math.min(i2, (int) m3487J());
            long j = min;
            bpu.m2888p(this.f6032n, bArr, i - i2, j);
            i2 -= min;
            this.f6032n += j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: A */
    public final void mo3462A(int i) {
        this.f6029k = i;
        m3485L();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: C */
    public final boolean mo3461C() throws IOException {
        return (((long) this.f6031m) + this.f6032n) - this.f6033o == ((long) this.f6027i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: D */
    public final boolean mo3460D() throws IOException {
        return m3478r() != 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: E */
    public final boolean mo3459E(int i) throws IOException {
        int mo3446m;
        int m2852b = bqb.m2852b(i);
        if (m2852b == 0) {
            for (int i2 = 0; i2 < 10; i2++) {
                if (m3482a() >= 0) {
                    return true;
                }
            }
            throw bnm.m3254e();
        } else if (m2852b == 1) {
            m3489B(8);
            return true;
        } else if (m2852b == 2) {
            m3489B(m3480j());
            return true;
        } else if (m2852b != 3) {
            if (m2852b != 4) {
                if (m2852b == 5) {
                    m3489B(4);
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

    /* renamed from: a */
    public final byte m3482a() throws IOException {
        if (m3487J() == 0) {
            m3486K();
        }
        long j = this.f6032n;
        this.f6032n = 1 + j;
        return bpu.m2903a(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: b */
    public final double mo3455b() throws IOException {
        return Double.longBitsToDouble(m3479q());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: c */
    public final float mo3454c() throws IOException {
        return Float.intBitsToFloat(m3481i());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: d */
    public final int mo3453d() {
        return (int) ((this.f6031m + this.f6032n) - this.f6033o);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: e */
    public final int mo3452e(int i) throws bnm {
        if (i >= 0) {
            int mo3453d = i + mo3453d();
            int i2 = this.f6029k;
            if (mo3453d <= i2) {
                this.f6029k = mo3453d;
                m3485L();
                return i2;
            }
            throw bnm.m3250i();
        }
        throw bnm.m3253f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: f */
    public final int mo3451f() throws IOException {
        return m3480j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: g */
    public final int mo3450g() throws IOException {
        return m3481i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: h */
    public final int mo3449h() throws IOException {
        return m3480j();
    }

    /* renamed from: i */
    public final int m3481i() throws IOException {
        if (m3487J() >= 4) {
            long j = this.f6032n;
            this.f6032n = 4 + j;
            return ((bpu.m2903a(j + 3) & 255) << 24) | (bpu.m2903a(j) & 255) | ((bpu.m2903a(1 + j) & 255) << 8) | ((bpu.m2903a(2 + j) & 255) << 16);
        }
        return (m3482a() & 255) | ((m3482a() & 255) << 8) | ((m3482a() & 255) << 16) | ((m3482a() & 255) << 24);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: k */
    public final int mo3448k() throws IOException {
        return m3481i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: l */
    public final int mo3447l() throws IOException {
        return m3458F(m3480j());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: m */
    public final int mo3446m() throws IOException {
        if (mo3461C()) {
            this.f6030l = 0;
            return 0;
        }
        int m3480j = m3480j();
        this.f6030l = m3480j;
        if (bqb.m2853a(m3480j) != 0) {
            return m3480j;
        }
        throw bnm.m3256c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: n */
    public final int mo3445n() throws IOException {
        return m3480j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: o */
    public final long mo3444o() throws IOException {
        return m3479q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: p */
    public final long mo3443p() throws IOException {
        return m3478r();
    }

    /* renamed from: q */
    public final long m3479q() throws IOException {
        if (m3487J() >= 8) {
            long j = this.f6032n;
            this.f6032n = 8 + j;
            return ((bpu.m2903a(j + 7) & 255) << 56) | (bpu.m2903a(j) & 255) | ((bpu.m2903a(1 + j) & 255) << 8) | ((bpu.m2903a(2 + j) & 255) << 16) | ((bpu.m2903a(3 + j) & 255) << 24) | ((bpu.m2903a(4 + j) & 255) << 32) | ((bpu.m2903a(5 + j) & 255) << 40) | ((bpu.m2903a(6 + j) & 255) << 48);
        }
        return (m3482a() & 255) | ((m3482a() & 255) << 8) | ((m3482a() & 255) << 16) | ((m3482a() & 255) << 24) | ((m3482a() & 255) << 32) | ((m3482a() & 255) << 40) | ((m3482a() & 255) << 48) | ((m3482a() & 255) << 56);
    }

    /* renamed from: s */
    final long m3477s() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m3482a = m3482a();
            j |= (m3482a & Byte.MAX_VALUE) << i;
            if ((m3482a & 128) == 0) {
                return j;
            }
        }
        throw bnm.m3254e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: t */
    public final long mo3442t() throws IOException {
        return m3479q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: u */
    public final long mo3441u() throws IOException {
        return m3457G(m3478r());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: v */
    public final long mo3440v() throws IOException {
        return m3478r();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: w */
    public final bls mo3439w() throws IOException {
        int m3480j = m3480j();
        if (m3480j > 0) {
            long j = m3480j;
            long j2 = this.f6035q;
            long j3 = this.f6032n;
            if (j <= j2 - j3) {
                byte[] bArr = new byte[m3480j];
                bpu.m2888p(j3, bArr, 0L, j);
                this.f6032n += j;
                return bls.m3500x(bArr);
            }
        }
        if (m3480j > 0 && m3480j <= m3488I()) {
            byte[] bArr2 = new byte[m3480j];
            m3483N(bArr2, m3480j);
            return bls.m3500x(bArr2);
        } else if (m3480j == 0) {
            return bls.f6015b;
        } else {
            if (m3480j < 0) {
                throw bnm.m3253f();
            }
            throw bnm.m3250i();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: x */
    public final String mo3438x() throws IOException {
        int m3480j = m3480j();
        if (m3480j > 0) {
            long j = m3480j;
            long j2 = this.f6035q;
            long j3 = this.f6032n;
            if (j <= j2 - j3) {
                byte[] bArr = new byte[m3480j];
                bpu.m2888p(j3, bArr, 0L, j);
                String str = new String(bArr, bnk.f6265b);
                this.f6032n += j;
                return str;
            }
        }
        if (m3480j > 0 && m3480j <= m3488I()) {
            byte[] bArr2 = new byte[m3480j];
            m3483N(bArr2, m3480j);
            return new String(bArr2, bnk.f6265b);
        } else if (m3480j == 0) {
            return "";
        } else {
            if (m3480j < 0) {
                throw bnm.m3253f();
            }
            throw bnm.m3250i();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: y */
    public final String mo3437y() throws IOException {
        int m3480j = m3480j();
        if (m3480j > 0) {
            long j = m3480j;
            long j2 = this.f6035q;
            long j3 = this.f6032n;
            if (j <= j2 - j3) {
                String m2865g = bpy.m2865g(this.f6026h, (int) (j3 - this.f6033o), m3480j);
                this.f6032n += j;
                return m2865g;
            }
        }
        if (m3480j >= 0 && m3480j <= m3488I()) {
            byte[] bArr = new byte[m3480j];
            m3483N(bArr, m3480j);
            return bpy.m2864h(bArr, 0, m3480j);
        } else if (m3480j == 0) {
            return "";
        } else {
            if (m3480j <= 0) {
                throw bnm.m3253f();
            }
            throw bnm.m3250i();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: z */
    public final void mo3436z(int i) throws bnm {
        if (this.f6030l != i) {
            throw bnm.m3257b();
        }
    }

    /* renamed from: B */
    public final void m3489B(int i) throws IOException {
        if (i < 0 || i > ((this.f6027i - this.f6031m) - this.f6032n) + this.f6033o) {
            if (i < 0) {
                throw bnm.m3253f();
            }
            throw bnm.m3250i();
        }
        while (i > 0) {
            if (m3487J() == 0) {
                m3486K();
            }
            int min = Math.min(i, (int) m3487J());
            i -= min;
            this.f6032n += min;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r4) >= 0) goto L13;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m3480j() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.f6032n
            long r2 = r10.f6035q
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto La
            goto L8c
        La:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r0)
            if (r0 < 0) goto L1a
            long r4 = r10.f6032n
            long r4 = r4 + r2
            r10.f6032n = r4
            return r0
        L1a:
            long r6 = r10.f6035q
            long r8 = r10.f6032n
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L8c
            long r6 = r4 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L33
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L89
        L33:
            long r4 = r6 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L42
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L40:
            r6 = r4
            goto L89
        L42:
            long r6 = r4 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L52
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L89
        L52:
            long r4 = r6 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.ads.interactivemedia.p034v3.internal.bpu.m2903a(r4)
            if (r1 < 0) goto L8c
        L89:
            r10.f6032n = r6
            return r0
        L8c:
            long r0 = r10.m3477s()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.blu.m3480j():int");
    }

    /* renamed from: r */
    public final long m3478r() throws IOException {
        long m2903a;
        long j;
        long j2;
        int i;
        long j3 = this.f6032n;
        if (this.f6035q != j3) {
            long j4 = j3 + 1;
            byte m2903a2 = bpu.m2903a(j3);
            if (m2903a2 >= 0) {
                this.f6032n++;
                return m2903a2;
            } else if (this.f6035q - this.f6032n >= 10) {
                long j5 = j4 + 1;
                int m2903a3 = m2903a2 ^ (bpu.m2903a(j4) << 7);
                if (m2903a3 >= 0) {
                    long j6 = j5 + 1;
                    int m2903a4 = m2903a3 ^ (bpu.m2903a(j5) << Ascii.f9767SO);
                    if (m2903a4 >= 0) {
                        m2903a = m2903a4 ^ 16256;
                    } else {
                        j5 = j6 + 1;
                        int m2903a5 = m2903a4 ^ (bpu.m2903a(j6) << Ascii.NAK);
                        if (m2903a5 < 0) {
                            i = m2903a5 ^ (-2080896);
                        } else {
                            j6 = j5 + 1;
                            long m2903a6 = m2903a5 ^ (bpu.m2903a(j5) << 28);
                            if (m2903a6 < 0) {
                                long j7 = j6 + 1;
                                long m2903a7 = m2903a6 ^ (bpu.m2903a(j6) << 35);
                                if (m2903a7 < 0) {
                                    j = -34093383808L;
                                } else {
                                    j6 = j7 + 1;
                                    m2903a6 = m2903a7 ^ (bpu.m2903a(j7) << 42);
                                    if (m2903a6 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        j7 = j6 + 1;
                                        m2903a7 = m2903a6 ^ (bpu.m2903a(j6) << 49);
                                        if (m2903a7 < 0) {
                                            j = -558586000294016L;
                                        } else {
                                            j6 = j7 + 1;
                                            m2903a = (m2903a7 ^ (bpu.m2903a(j7) << 56)) ^ 71499008037633920L;
                                            if (m2903a < 0) {
                                                long j8 = 1 + j6;
                                                if (bpu.m2903a(j6) >= 0) {
                                                    j5 = j8;
                                                    this.f6032n = j5;
                                                    return m2903a;
                                                }
                                            }
                                        }
                                    }
                                }
                                m2903a = m2903a7 ^ j;
                                j5 = j7;
                                this.f6032n = j5;
                                return m2903a;
                            }
                            j2 = 266354560;
                            m2903a = m2903a6 ^ j2;
                        }
                    }
                    j5 = j6;
                    this.f6032n = j5;
                    return m2903a;
                }
                i = m2903a3 ^ (-128);
                m2903a = i;
                this.f6032n = j5;
                return m2903a;
            }
        }
        return m3477s();
    }
}
