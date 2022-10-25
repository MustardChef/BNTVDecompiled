package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bma */
/* loaded from: classes2.dex */
public final class bma extends bnv {

    /* renamed from: b */
    private static final Logger f6061b = Logger.getLogger(bma.class.getName());

    /* renamed from: c */
    private static final boolean f6062c = bpu.m2913B();

    /* renamed from: a */
    bmb f6063a;

    /* renamed from: d */
    private final byte[] f6064d;

    /* renamed from: e */
    private final int f6065e;

    /* renamed from: f */
    private int f6066f;

    private bma() {
        super((char[]) null);
    }

    /* synthetic */ bma(byte[] bArr) {
        super((char[]) null);
    }

    bma(byte[] bArr, int i) {
        this(null);
        Objects.requireNonNull(bArr, "buffer");
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i)));
        }
        this.f6064d = bArr;
        this.f6066f = 0;
        this.f6065e = i;
    }

    /* renamed from: A */
    public static long m3427A(long j) {
        return (j >> 63) ^ (j + j);
    }

    /* renamed from: B */
    public static bma m3426B(byte[] bArr) {
        return new bma(bArr, bArr.length);
    }

    /* renamed from: a */
    public static int m3401a(byte[] bArr) {
        return m3377l(bArr.length);
    }

    /* renamed from: ag */
    public static int m3394ag(int i) {
        return m3368u(i) + 1;
    }

    /* renamed from: ah */
    public static int m3393ah(int i) {
        return m3368u(i) + 8;
    }

    /* renamed from: ai */
    public static int m3392ai(int i) {
        return m3368u(i) + 4;
    }

    /* renamed from: aj */
    public static int m3391aj(int i) {
        return m3368u(i) + 8;
    }

    /* renamed from: ak */
    public static int m3390ak(int i) {
        return m3368u(i) + 4;
    }

    /* renamed from: al */
    public static int m3389al(int i) {
        return m3368u(i) + 4;
    }

    /* renamed from: am */
    public static int m3388am(int i) {
        return m3368u(i) + 8;
    }

    /* renamed from: b */
    public static int m3387b(int i, bls blsVar) {
        return m3368u(i) + m3386c(blsVar);
    }

    /* renamed from: c */
    public static int m3386c(bls blsVar) {
        return m3377l(blsVar.mo3054d());
    }

    /* renamed from: d */
    public static int m3385d(int i, int i2) {
        return m3368u(i) + m3381h(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: e */
    public static int m3384e(int i, boj bojVar, boy boyVar) {
        int m3368u = m3368u(i);
        int i2 = m3368u + m3368u;
        blb blbVar = (blb) bojVar;
        int mo3285ao = blbVar.mo3285ao();
        if (mo3285ao == -1) {
            mo3285ao = boyVar.mo3040a(blbVar);
            blbVar.mo3284aq(mo3285ao);
        }
        return i2 + mo3285ao;
    }

    @Deprecated
    /* renamed from: f */
    public static int m3383f(boj bojVar) {
        return bojVar.mo3175as();
    }

    /* renamed from: g */
    public static int m3382g(int i, int i2) {
        return m3368u(i) + m3381h(i2);
    }

    /* renamed from: h */
    public static int m3381h(int i) {
        if (i >= 0) {
            return m3366w(i);
        }
        return 10;
    }

    /* renamed from: i */
    public static int m3380i(int i, long j) {
        return m3368u(i) + m3364y(j);
    }

    /* renamed from: j */
    public static int m3379j(int i, bns bnsVar) {
        return m3368u(i) + m3378k(bnsVar);
    }

    /* renamed from: k */
    public static int m3378k(bns bnsVar) {
        return m3377l(bnsVar.m3243a());
    }

    /* renamed from: l */
    static int m3377l(int i) {
        return m3366w(i) + i;
    }

    /* renamed from: m */
    public static int m3376m(boj bojVar) {
        return m3377l(bojVar.mo3175as());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static int m3375n(boj bojVar, boy boyVar) {
        blb blbVar = (blb) bojVar;
        int mo3285ao = blbVar.mo3285ao();
        if (mo3285ao == -1) {
            mo3285ao = boyVar.mo3040a(blbVar);
            blbVar.mo3284aq(mo3285ao);
        }
        return m3377l(mo3285ao);
    }

    /* renamed from: o */
    public static int m3374o(int i, int i2) {
        return m3368u(i) + m3373p(i2);
    }

    /* renamed from: p */
    public static int m3373p(int i) {
        return m3366w(m3363z(i));
    }

    /* renamed from: q */
    public static int m3372q(int i, long j) {
        return m3368u(i) + m3371r(j);
    }

    /* renamed from: r */
    public static int m3371r(long j) {
        return m3364y(m3427A(j));
    }

    /* renamed from: s */
    public static int m3370s(int i, String str) {
        return m3368u(i) + m3369t(str);
    }

    /* renamed from: t */
    public static int m3369t(String str) {
        int length;
        try {
            length = bpy.m2867e(str);
        } catch (bpx unused) {
            length = str.getBytes(bnk.f6265b).length;
        }
        return m3377l(length);
    }

    /* renamed from: u */
    public static int m3368u(int i) {
        return m3366w(bqb.m2851c(i, 0));
    }

    /* renamed from: v */
    public static int m3367v(int i, int i2) {
        return m3368u(i) + m3366w(i2);
    }

    /* renamed from: w */
    public static int m3366w(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: x */
    public static int m3365x(int i, long j) {
        return m3368u(i) + m3364y(j);
    }

    /* renamed from: y */
    public static int m3364y(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    /* renamed from: z */
    public static int m3363z(int i) {
        return (i >> 31) ^ (i + i);
    }

    /* renamed from: C */
    public final void m3425C() {
        if (m3417K() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: D */
    final void m3424D(String str, bpx bpxVar) throws IOException {
        f6061b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) bpxVar);
        byte[] bytes = str.getBytes(bnk.f6265b);
        try {
            int length = bytes.length;
            m3397ad(length);
            m3406V(bytes, 0, length);
        } catch (blz e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new blz(e2);
        }
    }

    /* renamed from: E */
    public final void m3423E(int i, double d) throws IOException {
        m3410R(i, Double.doubleToRawLongBits(d));
    }

    /* renamed from: F */
    public final void m3422F(int i, float f) throws IOException {
        m3412P(i, Float.floatToRawIntBits(f));
    }

    @Deprecated
    /* renamed from: G */
    public final void m3421G(boj bojVar) throws IOException {
        bojVar.mo3172bj(this);
    }

    /* renamed from: H */
    public final void m3420H(int i, int i2) throws IOException {
        m3398ac(i, m3363z(i2));
    }

    /* renamed from: I */
    public final void m3419I(int i, long j) throws IOException {
        m3396ae(i, m3427A(j));
    }

    /* renamed from: K */
    public final int m3417K() {
        return this.f6065e - this.f6066f;
    }

    /* renamed from: N */
    public final void m3414N(int i, boolean z) throws IOException {
        m3399ab(i, 0);
        m3416L(z ? (byte) 1 : (byte) 0);
    }

    /* renamed from: O */
    public final void m3413O(int i, bls blsVar) throws IOException {
        m3399ab(i, 2);
        m3397ad(blsVar.mo3054d());
        blsVar.mo3042p(this);
    }

    /* renamed from: P */
    public final void m3412P(int i, int i2) throws IOException {
        m3399ab(i, 5);
        m3411Q(i2);
    }

    /* renamed from: Q */
    public final void m3411Q(int i) throws IOException {
        try {
            byte[] bArr = this.f6064d;
            int i2 = this.f6066f;
            int i3 = i2 + 1;
            this.f6066f = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            this.f6066f = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            this.f6066f = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.f6066f = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new blz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6066f), Integer.valueOf(this.f6065e), 1), e);
        }
    }

    /* renamed from: R */
    public final void m3410R(int i, long j) throws IOException {
        m3399ab(i, 1);
        m3409S(j);
    }

    /* renamed from: S */
    public final void m3409S(long j) throws IOException {
        try {
            byte[] bArr = this.f6064d;
            int i = this.f6066f;
            int i2 = i + 1;
            this.f6066f = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i2 + 1;
            this.f6066f = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i3 + 1;
            this.f6066f = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i4 + 1;
            this.f6066f = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i5 + 1;
            this.f6066f = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.f6066f = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.f6066f = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f6066f = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new blz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6066f), Integer.valueOf(this.f6065e), 1), e);
        }
    }

    /* renamed from: T */
    public final void m3408T(int i, int i2) throws IOException {
        m3399ab(i, 0);
        m3407U(i2);
    }

    /* renamed from: U */
    public final void m3407U(int i) throws IOException {
        if (i >= 0) {
            m3397ad(i);
        } else {
            m3395af(i);
        }
    }

    /* renamed from: V */
    public final void m3406V(byte[] bArr, int i, int i2) throws IOException {
        m3415M(bArr, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: W */
    public final void m3405W(int i, boj bojVar, boy boyVar) throws IOException {
        m3399ab(i, 2);
        blb blbVar = (blb) bojVar;
        int mo3285ao = blbVar.mo3285ao();
        if (mo3285ao == -1) {
            mo3285ao = boyVar.mo3040a(blbVar);
            blbVar.mo3284aq(mo3285ao);
        }
        m3397ad(mo3285ao);
        boyVar.mo3033j(bojVar, this.f6063a);
    }

    /* renamed from: X */
    public final void m3404X(int i, boj bojVar) throws IOException {
        m3399ab(1, 3);
        m3398ac(2, i);
        m3399ab(3, 2);
        m3397ad(bojVar.mo3175as());
        bojVar.mo3172bj(this);
        m3399ab(1, 4);
    }

    /* renamed from: Y */
    public final void m3403Y(int i, bls blsVar) throws IOException {
        m3399ab(1, 3);
        m3398ac(2, i);
        m3413O(3, blsVar);
        m3399ab(1, 4);
    }

    /* renamed from: Z */
    public final void m3402Z(int i, String str) throws IOException {
        m3399ab(i, 2);
        m3400aa(str);
    }

    /* renamed from: aa */
    public final void m3400aa(String str) throws IOException {
        int i = this.f6066f;
        try {
            int m3366w = m3366w(str.length() * 3);
            int m3366w2 = m3366w(str.length());
            if (m3366w2 == m3366w) {
                int i2 = i + m3366w2;
                this.f6066f = i2;
                int m2868d = bpy.m2868d(str, this.f6064d, i2, m3417K());
                this.f6066f = i;
                m3397ad((m2868d - i) - m3366w2);
                this.f6066f = m2868d;
                return;
            }
            m3397ad(bpy.m2867e(str));
            this.f6066f = bpy.m2868d(str, this.f6064d, this.f6066f, m3417K());
        } catch (bpx e) {
            this.f6066f = i;
            m3424D(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new blz(e2);
        }
    }

    /* renamed from: ab */
    public final void m3399ab(int i, int i2) throws IOException {
        m3397ad(bqb.m2851c(i, i2));
    }

    /* renamed from: ac */
    public final void m3398ac(int i, int i2) throws IOException {
        m3399ab(i, 0);
        m3397ad(i2);
    }

    /* renamed from: ad */
    public final void m3397ad(int i) throws IOException {
        if (f6062c) {
            int i2 = ble.f5993a;
        }
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.f6064d;
                int i3 = this.f6066f;
                this.f6066f = i3 + 1;
                bArr[i3] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new blz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6066f), Integer.valueOf(this.f6065e), 1), e);
            }
        }
        byte[] bArr2 = this.f6064d;
        int i4 = this.f6066f;
        this.f6066f = i4 + 1;
        bArr2[i4] = (byte) i;
    }

    /* renamed from: ae */
    public final void m3396ae(int i, long j) throws IOException {
        m3399ab(i, 0);
        m3395af(j);
    }

    /* renamed from: L */
    public final void m3416L(byte b) throws IOException {
        try {
            byte[] bArr = this.f6064d;
            int i = this.f6066f;
            this.f6066f = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new blz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6066f), Integer.valueOf(this.f6065e), 1), e);
        }
    }

    /* renamed from: M */
    public final void m3415M(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.f6064d, this.f6066f, i2);
            this.f6066f += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new blz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6066f), Integer.valueOf(this.f6065e), Integer.valueOf(i2)), e);
        }
    }

    /* renamed from: af */
    public final void m3395af(long j) throws IOException {
        if (f6062c && m3417K() >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.f6064d;
                int i = this.f6066f;
                this.f6066f = i + 1;
                bpu.m2886r(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.f6064d;
            int i2 = this.f6066f;
            this.f6066f = i2 + 1;
            bpu.m2886r(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.f6064d;
                int i3 = this.f6066f;
                this.f6066f = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new blz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6066f), Integer.valueOf(this.f6065e), 1), e);
            }
        }
        byte[] bArr4 = this.f6064d;
        int i4 = this.f6066f;
        this.f6066f = i4 + 1;
        bArr4[i4] = (byte) j;
    }
}
