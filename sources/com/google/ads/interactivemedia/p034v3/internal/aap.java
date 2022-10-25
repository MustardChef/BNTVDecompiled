package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aap */
/* loaded from: classes2.dex */
public final class aap extends AbstractC3257zy {

    /* renamed from: a */
    public static final aan f2915a = C2538aam.f2911a;

    /* renamed from: b */
    private final aan f2916b;

    public aap() {
        this(null);
    }

    public aap(aan aanVar) {
        this.f2916b = aanVar;
    }

    /* renamed from: d */
    private static int m5974d(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    /* renamed from: e */
    private static int m5973e(byte[] bArr, int i, int i2) {
        int m5972f = m5972f(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return m5972f;
        }
        while (true) {
            int length = bArr.length;
            if (m5972f >= length - 1) {
                return length;
            }
            if ((m5972f - i) % 2 == 0 && bArr[m5972f + 1] == 0) {
                return m5972f;
            }
            m5972f = m5972f(bArr, m5972f + 1);
        }
    }

    /* renamed from: f */
    private static int m5972f(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: g */
    private static int m5971g(C2621cj c2621cj, int i) {
        byte[] m2642H = c2621cj.m2642H();
        int m2639c = c2621cj.m2639c();
        int i2 = m2639c;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= m2639c + i) {
                return i;
            }
            if ((m2642H[i2] & 255) == 255 && m2642H[i3] == 0) {
                System.arraycopy(m2642H, i2 + 2, m2642H, i3, (i - (i2 - m2639c)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x026e, code lost:
        if (r9 == 67) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:218:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0508  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.ads.interactivemedia.p034v3.internal.aaq m5970h(int r34, com.google.ads.interactivemedia.p034v3.internal.C2621cj r35, boolean r36, int r37, com.google.ads.interactivemedia.p034v3.internal.aan r38) {
        /*
            Method dump skipped, instructions count: 1404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aap.m5970h(int, com.google.ads.interactivemedia.v3.internal.cj, boolean, int, com.google.ads.interactivemedia.v3.internal.aan):com.google.ads.interactivemedia.v3.internal.aaq");
    }

    /* renamed from: i */
    private static String m5969i(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    /* renamed from: j */
    private static String m5968j(int i) {
        return i != 1 ? i != 2 ? i != 3 ? C3282C.ISO88591_NAME : "UTF-8" : "UTF-16BE" : C3282C.UTF16_NAME;
    }

    /* renamed from: k */
    private static String m5967k(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
        if ((r10 & 128) != 0) goto L31;
     */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m5966l(com.google.ads.interactivemedia.p034v3.internal.C2621cj r19, int r20, int r21, boolean r22) {
        /*
            r1 = r19
            r0 = r20
            int r2 = r19.m2639c()
        L8:
            int r3 = r19.m2641a()     // Catch: java.lang.Throwable -> Lae
            r4 = 1
            r5 = r21
            if (r3 < r5) goto Laa
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L22
            int r7 = r19.m2637e()     // Catch: java.lang.Throwable -> Lae
            long r8 = r19.m2626p()     // Catch: java.lang.Throwable -> Lae
            int r10 = r19.m2629m()     // Catch: java.lang.Throwable -> Lae
            goto L2c
        L22:
            int r7 = r19.m2631k()     // Catch: java.lang.Throwable -> Lae
            int r8 = r19.m2631k()     // Catch: java.lang.Throwable -> Lae
            long r8 = (long) r8
            r10 = 0
        L2c:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 == 0) goto L37
            goto L3b
        L37:
            r1.m2644F(r2)
            return r4
        L3b:
            r7 = 4
            if (r0 != r7) goto L6a
            if (r22 != 0) goto L6a
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4c
            r1.m2644F(r2)
            return r6
        L4c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r11 = r11 & r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 24
            long r8 = r8 >> r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L6a:
            if (r0 != r7) goto L7a
            r3 = r10 & 64
            if (r3 == 0) goto L71
            goto L72
        L71:
            r4 = 0
        L72:
            r3 = r10 & 1
            r18 = r4
            r4 = r3
            r3 = r18
            goto L8a
        L7a:
            if (r0 != r3) goto L88
            r3 = r10 & 32
            if (r3 == 0) goto L82
            r3 = 1
            goto L83
        L82:
            r3 = 0
        L83:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L89
            goto L8a
        L88:
            r3 = 0
        L89:
            r4 = 0
        L8a:
            if (r4 == 0) goto L8e
            int r3 = r3 + 4
        L8e:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L97
            r1.m2644F(r2)
            return r6
        L97:
            int r3 = r19.m2641a()     // Catch: java.lang.Throwable -> Lae
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La4
            r1.m2644F(r2)
            return r6
        La4:
            int r3 = (int) r8
            r1.m2643G(r3)     // Catch: java.lang.Throwable -> Lae
            goto L8
        Laa:
            r1.m2644F(r2)
            return r4
        Lae:
            r0 = move-exception
            r1.m2644F(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aap.m5966l(com.google.ads.interactivemedia.v3.internal.cj, int, int, boolean):boolean");
    }

    /* renamed from: m */
    private static byte[] m5965m(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return C2628cq.f6966f;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3257zy
    /* renamed from: b */
    protected final C2549ak mo424b(ByteBuffer byteBuffer) {
        return m5975c(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.p034v3.internal.C2549ak m5975c(byte[] r13, int r14) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aap.m5975c(byte[], int):com.google.ads.interactivemedia.v3.internal.ak");
    }
}
