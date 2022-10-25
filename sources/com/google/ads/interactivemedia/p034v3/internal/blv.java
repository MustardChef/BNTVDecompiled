package com.google.ads.interactivemedia.p034v3.internal;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blv */
/* loaded from: classes2.dex */
final class blv extends blw {

    /* renamed from: f */
    private final InputStream f6036f;

    /* renamed from: g */
    private final byte[] f6037g;

    /* renamed from: h */
    private int f6038h;

    /* renamed from: i */
    private int f6039i;

    /* renamed from: j */
    private int f6040j;

    /* renamed from: k */
    private int f6041k;

    /* renamed from: l */
    private int f6042l;

    /* renamed from: m */
    private int f6043m = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ blv(InputStream inputStream) {
        bnk.m3259j(inputStream, TvContractCompat.PARAM_INPUT);
        this.f6036f = inputStream;
        this.f6037g = new byte[4096];
        this.f6038h = 0;
        this.f6040j = 0;
        this.f6042l = 0;
    }

    /* renamed from: I */
    private static int m3475I(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        try {
            return inputStream.read(bArr, i, i2);
        } catch (bnm e) {
            e.m3249j();
            throw e;
        }
    }

    /* renamed from: J */
    private final List m3474J(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.f6036f.read(bArr, i2, min - i2);
                if (read == -1) {
                    throw bnm.m3250i();
                }
                this.f6042l += read;
                i2 += read;
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    /* renamed from: K */
    private final void m3473K() {
        int i = this.f6038h + this.f6039i;
        this.f6038h = i;
        int i2 = this.f6042l + i;
        int i3 = this.f6043m;
        if (i2 <= i3) {
            this.f6039i = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f6039i = i4;
        this.f6038h = i - i4;
    }

    /* renamed from: L */
    private final void m3472L(int i) throws IOException {
        if (m3471M(i)) {
            return;
        }
        if (i > (Integer.MAX_VALUE - this.f6042l) - this.f6040j) {
            throw bnm.m3251h();
        }
        throw bnm.m3250i();
    }

    /* renamed from: M */
    private final boolean m3471M(int i) throws IOException {
        int i2 = this.f6040j;
        int i3 = this.f6038h;
        if (i2 + i <= i3) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        int i4 = this.f6042l;
        if (i <= (Integer.MAX_VALUE - i4) - i2 && i4 + i2 + i <= this.f6043m) {
            if (i2 > 0) {
                if (i3 > i2) {
                    byte[] bArr = this.f6037g;
                    System.arraycopy(bArr, i2, bArr, 0, i3 - i2);
                }
                i4 = this.f6042l + i2;
                this.f6042l = i4;
                i3 = this.f6038h - i2;
                this.f6038h = i3;
                this.f6040j = 0;
            }
            int m3475I = m3475I(this.f6036f, this.f6037g, i3, Math.min(4096 - i3, (Integer.MAX_VALUE - i4) - i3));
            if (m3475I == 0 || m3475I < -1 || m3475I > 4096) {
                String valueOf = String.valueOf(this.f6036f.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb2.append(valueOf);
                sb2.append("#read(byte[]) returned invalid result: ");
                sb2.append(m3475I);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            } else if (m3475I > 0) {
                this.f6038h += m3475I;
                m3473K();
                if (this.f6038h >= i) {
                    return true;
                }
                return m3471M(i);
            } else {
                return false;
            }
        }
        return false;
    }

    /* renamed from: N */
    private final byte[] m3470N(int i) throws IOException {
        if (i == 0) {
            return bnk.f6266c;
        }
        if (i >= 0) {
            int i2 = this.f6042l;
            int i3 = this.f6040j;
            int i4 = i2 + i3 + i;
            if ((-2147483647) + i4 <= 0) {
                int i5 = this.f6043m;
                if (i4 > i5) {
                    m3476B((i5 - i2) - i3);
                    throw bnm.m3250i();
                }
                int i6 = this.f6038h - i3;
                int i7 = i - i6;
                if (i7 >= 4096) {
                    try {
                        if (i7 > this.f6036f.available()) {
                            return null;
                        }
                    } catch (bnm e) {
                        e.m3249j();
                        throw e;
                    }
                }
                byte[] bArr = new byte[i];
                System.arraycopy(this.f6037g, this.f6040j, bArr, 0, i6);
                this.f6042l += this.f6038h;
                this.f6040j = 0;
                this.f6038h = 0;
                while (i6 < i) {
                    int m3475I = m3475I(this.f6036f, bArr, i6, i - i6);
                    if (m3475I == -1) {
                        throw bnm.m3250i();
                    }
                    this.f6042l += m3475I;
                    i6 += m3475I;
                }
                return bArr;
            }
            throw bnm.m3251h();
        }
        throw bnm.m3253f();
    }

    /* renamed from: O */
    private final byte[] m3469O(int i) throws IOException {
        byte[] m3470N = m3470N(i);
        if (m3470N != null) {
            return m3470N;
        }
        int i2 = this.f6040j;
        int i3 = this.f6038h;
        int i4 = i3 - i2;
        this.f6042l += i3;
        this.f6040j = 0;
        this.f6038h = 0;
        List<byte[]> m3474J = m3474J(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f6037g, i2, bArr, 0, i4);
        for (byte[] bArr2 : m3474J) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: A */
    public final void mo3462A(int i) {
        this.f6043m = i;
        m3473K();
    }

    /* renamed from: B */
    public final void m3476B(int i) throws IOException {
        int i2 = this.f6038h;
        int i3 = this.f6040j;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.f6040j = i3 + i;
        } else if (i >= 0) {
            int i5 = this.f6042l;
            int i6 = i5 + i3;
            int i7 = this.f6043m;
            if (i6 + i > i7) {
                m3476B((i7 - i5) - i3);
                throw bnm.m3250i();
            }
            this.f6042l = i6;
            this.f6038h = 0;
            this.f6040j = 0;
            while (i4 < i) {
                try {
                    long j = i - i4;
                    try {
                        long skip = this.f6036f.skip(j);
                        int i8 = (skip > 0L ? 1 : (skip == 0L ? 0 : -1));
                        if (i8 < 0 || skip > j) {
                            String valueOf = String.valueOf(this.f6036f.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        } else if (i8 == 0) {
                            break;
                        } else {
                            i4 += (int) skip;
                        }
                    } catch (bnm e) {
                        e.m3249j();
                        throw e;
                    }
                } finally {
                    this.f6042l += i4;
                    m3473K();
                }
            }
            if (i4 >= i) {
                return;
            }
            int i9 = this.f6038h;
            int i10 = i9 - this.f6040j;
            this.f6040j = i9;
            m3472L(1);
            while (true) {
                int i11 = i - i10;
                int i12 = this.f6038h;
                if (i11 <= i12) {
                    this.f6040j = i11;
                    return;
                }
                i10 += i12;
                this.f6040j = i12;
                m3472L(1);
            }
        } else {
            throw bnm.m3253f();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: C */
    public final boolean mo3461C() throws IOException {
        return this.f6040j == this.f6038h && !m3471M(1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: D */
    public final boolean mo3460D() throws IOException {
        return m3464r() != 0;
    }

    /* renamed from: a */
    public final byte m3468a() throws IOException {
        if (this.f6040j == this.f6038h) {
            m3472L(1);
        }
        byte[] bArr = this.f6037g;
        int i = this.f6040j;
        this.f6040j = i + 1;
        return bArr[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: b */
    public final double mo3455b() throws IOException {
        return Double.longBitsToDouble(m3465q());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: c */
    public final float mo3454c() throws IOException {
        return Float.intBitsToFloat(m3467i());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: d */
    public final int mo3453d() {
        return this.f6042l + this.f6040j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: e */
    public final int mo3452e(int i) throws bnm {
        if (i >= 0) {
            int i2 = i + this.f6042l + this.f6040j;
            int i3 = this.f6043m;
            if (i2 <= i3) {
                this.f6043m = i2;
                m3473K();
                return i3;
            }
            throw bnm.m3250i();
        }
        throw bnm.m3253f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: f */
    public final int mo3451f() throws IOException {
        return m3466j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: g */
    public final int mo3450g() throws IOException {
        return m3467i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: h */
    public final int mo3449h() throws IOException {
        return m3466j();
    }

    /* renamed from: i */
    public final int m3467i() throws IOException {
        int i = this.f6040j;
        if (this.f6038h - i < 4) {
            m3472L(4);
            i = this.f6040j;
        }
        byte[] bArr = this.f6037g;
        this.f6040j = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: k */
    public final int mo3448k() throws IOException {
        return m3467i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: l */
    public final int mo3447l() throws IOException {
        return m3458F(m3466j());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: m */
    public final int mo3446m() throws IOException {
        if (mo3461C()) {
            this.f6041k = 0;
            return 0;
        }
        int m3466j = m3466j();
        this.f6041k = m3466j;
        if (bqb.m2853a(m3466j) != 0) {
            return m3466j;
        }
        throw bnm.m3256c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: n */
    public final int mo3445n() throws IOException {
        return m3466j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: o */
    public final long mo3444o() throws IOException {
        return m3465q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: p */
    public final long mo3443p() throws IOException {
        return m3464r();
    }

    /* renamed from: q */
    public final long m3465q() throws IOException {
        int i = this.f6040j;
        if (this.f6038h - i < 8) {
            m3472L(8);
            i = this.f6040j;
        }
        byte[] bArr = this.f6037g;
        this.f6040j = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* renamed from: s */
    final long m3463s() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m3468a = m3468a();
            j |= (m3468a & Byte.MAX_VALUE) << i;
            if ((m3468a & 128) == 0) {
                return j;
            }
        }
        throw bnm.m3254e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: t */
    public final long mo3442t() throws IOException {
        return m3465q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: u */
    public final long mo3441u() throws IOException {
        return m3457G(m3464r());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: v */
    public final long mo3440v() throws IOException {
        return m3464r();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: w */
    public final bls mo3439w() throws IOException {
        int m3466j = m3466j();
        int i = this.f6038h;
        int i2 = this.f6040j;
        if (m3466j <= i - i2 && m3466j > 0) {
            bls m3503u = bls.m3503u(this.f6037g, i2, m3466j);
            this.f6040j += m3466j;
            return m3503u;
        } else if (m3466j != 0) {
            byte[] m3470N = m3470N(m3466j);
            if (m3470N != null) {
                return bls.m3504t(m3470N);
            }
            int i3 = this.f6040j;
            int i4 = this.f6038h;
            int i5 = i4 - i3;
            this.f6042l += i4;
            this.f6040j = 0;
            this.f6038h = 0;
            List<byte[]> m3474J = m3474J(m3466j - i5);
            byte[] bArr = new byte[m3466j];
            System.arraycopy(this.f6037g, i3, bArr, 0, i5);
            for (byte[] bArr2 : m3474J) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i5, length);
                i5 += length;
            }
            return bls.m3500x(bArr);
        } else {
            return bls.f6015b;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: x */
    public final String mo3438x() throws IOException {
        int m3466j = m3466j();
        if (m3466j > 0) {
            int i = this.f6038h;
            int i2 = this.f6040j;
            if (m3466j <= i - i2) {
                String str = new String(this.f6037g, i2, m3466j, bnk.f6265b);
                this.f6040j += m3466j;
                return str;
            }
        }
        if (m3466j == 0) {
            return "";
        }
        if (m3466j <= this.f6038h) {
            m3472L(m3466j);
            String str2 = new String(this.f6037g, this.f6040j, m3466j, bnk.f6265b);
            this.f6040j += m3466j;
            return str2;
        }
        return new String(m3469O(m3466j), bnk.f6265b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: y */
    public final String mo3437y() throws IOException {
        byte[] m3469O;
        int m3466j = m3466j();
        int i = this.f6040j;
        int i2 = this.f6038h;
        if (m3466j <= i2 - i && m3466j > 0) {
            m3469O = this.f6037g;
            this.f6040j = i + m3466j;
        } else if (m3466j == 0) {
            return "";
        } else {
            if (m3466j <= i2) {
                m3472L(m3466j);
                m3469O = this.f6037g;
                this.f6040j = m3466j;
            } else {
                m3469O = m3469O(m3466j);
            }
            i = 0;
        }
        return bpy.m2864h(m3469O, i, m3466j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blw
    /* renamed from: z */
    public final void mo3436z(int i) throws bnm {
        if (this.f6041k != i) {
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
            if (this.f6038h - this.f6040j < 10) {
                while (i2 < 10) {
                    if (m3468a() < 0) {
                        i2++;
                    }
                }
                throw bnm.m3254e();
            }
            while (i2 < 10) {
                byte[] bArr = this.f6037g;
                int i3 = this.f6040j;
                this.f6040j = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                }
            }
            throw bnm.m3254e();
            return true;
        } else if (m2852b == 1) {
            m3476B(8);
            return true;
        } else if (m2852b == 2) {
            m3476B(m3466j());
            return true;
        } else if (m2852b != 3) {
            if (m2852b != 4) {
                if (m2852b == 5) {
                    m3476B(4);
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
    public final int m3466j() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f6040j
            int r1 = r5.f6038h
            if (r1 != r0) goto L7
            goto L6c
        L7:
            byte[] r2 = r5.f6037g
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.f6040j = r3
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
            r5.f6040j = r1
            return r0
        L6c:
            long r0 = r5.m3463s()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.blv.m3466j():int");
    }

    /* renamed from: r */
    public final long m3464r() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.f6040j;
        int i3 = this.f6038h;
        if (i3 != i2) {
            byte[] bArr = this.f6037g;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.f6040j = i4;
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
                                                    this.f6040j = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j3 ^ j6;
                                i5 = i10;
                                this.f6040j = i5;
                                return j2;
                            }
                            j4 = 266354560;
                            j = j5 ^ j4;
                        }
                    }
                    i5 = i7;
                    j2 = j;
                    this.f6040j = i5;
                    return j2;
                }
                i = i6 ^ (-128);
                j2 = i;
                this.f6040j = i5;
                return j2;
            }
        }
        return m3463s();
    }
}
