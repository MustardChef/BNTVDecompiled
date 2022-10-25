package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aca */
/* loaded from: classes2.dex */
public final class aca {

    /* renamed from: a */
    private static final byte[] f3132a = C2628cq.m2554ab("OpusHead");

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ae, code lost:
        if (r3 != 13) goto L51;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair m5879a(com.google.ads.interactivemedia.p034v3.internal.abs r11) {
        /*
            com.google.ads.interactivemedia.v3.internal.cj r11 = r11.f3106a
            r0 = 8
            r11.m2644F(r0)
            r1 = 0
            r2 = r1
            r3 = r2
        La:
            int r4 = r11.m2641a()
            if (r4 < r0) goto Lda
            int r4 = r11.m2639c()
            int r5 = r11.m2637e()
            int r6 = r11.m2637e()
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r6 != r7) goto L75
            r11.m2644F(r4)
            int r2 = r4 + r5
            r11.m2643G(r0)
            m5877c(r11)
        L2c:
            int r6 = r11.m2639c()
            if (r6 >= r2) goto L73
            int r6 = r11.m2639c()
            int r7 = r11.m2637e()
            int r8 = r11.m2637e()
            r9 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r8 != r9) goto L6e
            r11.m2644F(r6)
            int r6 = r6 + r7
            r11.m2643G(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L4f:
            int r7 = r11.m2639c()
            if (r7 >= r6) goto L5f
            com.google.ads.interactivemedia.v3.internal.aj r7 = com.google.ads.interactivemedia.p034v3.internal.ach.m5849a(r11)
            if (r7 == 0) goto L4f
            r2.add(r7)
            goto L4f
        L5f:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L66
            goto L73
        L66:
            com.google.ads.interactivemedia.v3.internal.ak r6 = new com.google.ads.interactivemedia.v3.internal.ak
            r6.<init>(r2)
            r2 = r6
            goto Ld4
        L6e:
            int r6 = r6 + r7
            r11.m2644F(r6)
            goto L2c
        L73:
            r2 = r1
            goto Ld4
        L75:
            r7 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r6 != r7) goto Ld4
            r11.m2644F(r4)
            int r3 = r4 + r5
            r6 = 12
            r11.m2643G(r6)
        L84:
            int r7 = r11.m2639c()
            if (r7 >= r3) goto Ld3
            int r7 = r11.m2639c()
            int r8 = r11.m2637e()
            int r9 = r11.m2637e()
            r10 = 1935766900(0x73617574, float:1.7862687E31)
            if (r9 != r10) goto Lce
            r3 = 14
            if (r8 >= r3) goto La0
            goto Ld3
        La0:
            r3 = 5
            r11.m2643G(r3)
            int r3 = r11.m2633i()
            r7 = 1123024896(0x42f00000, float:120.0)
            if (r3 == r6) goto Lb1
            r6 = 13
            if (r3 == r6) goto Lb5
            goto Ld3
        Lb1:
            if (r3 != r6) goto Lb5
            r7 = 1131413504(0x43700000, float:240.0)
        Lb5:
            r3 = 1
            r11.m2643G(r3)
            int r6 = r11.m2633i()
            com.google.ads.interactivemedia.v3.internal.ak r8 = new com.google.ads.interactivemedia.v3.internal.ak
            com.google.ads.interactivemedia.v3.internal.aj[] r3 = new com.google.ads.interactivemedia.p034v3.internal.InterfaceC2548aj[r3]
            com.google.ads.interactivemedia.v3.internal.aaz r9 = new com.google.ads.interactivemedia.v3.internal.aaz
            r9.<init>(r7, r6)
            r6 = 0
            r3[r6] = r9
            r8.<init>(r3)
            r3 = r8
            goto Ld4
        Lce:
            int r7 = r7 + r8
            r11.m2644F(r7)
            goto L84
        Ld3:
            r3 = r1
        Ld4:
            int r4 = r4 + r5
            r11.m2644F(r4)
            goto La
        Lda:
            android.util.Pair r11 = android.util.Pair.create(r2, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aca.m5879a(com.google.ads.interactivemedia.v3.internal.abs):android.util.Pair");
    }

    /* renamed from: b */
    public static C2549ak m5878b(abr abrVar) {
        aaw aawVar;
        abs m5892b = abrVar.m5892b(Atom.TYPE_hdlr);
        abs m5892b2 = abrVar.m5892b(Atom.TYPE_keys);
        abs m5892b3 = abrVar.m5892b(Atom.TYPE_ilst);
        if (m5892b == null || m5892b2 == null || m5892b3 == null || m5873g(m5892b.f3106a) != 1835299937) {
            return null;
        }
        C2621cj c2621cj = m5892b2.f3106a;
        c2621cj.m2644F(12);
        int m2637e = c2621cj.m2637e();
        String[] strArr = new String[m2637e];
        for (int i = 0; i < m2637e; i++) {
            int m2637e2 = c2621cj.m2637e();
            c2621cj.m2643G(4);
            strArr[i] = c2621cj.m2621u(m2637e2 - 8);
        }
        C2621cj c2621cj2 = m5892b3.f3106a;
        c2621cj2.m2644F(8);
        ArrayList arrayList = new ArrayList();
        while (c2621cj2.m2641a() > 8) {
            int m2639c = c2621cj2.m2639c();
            int m2637e3 = c2621cj2.m2637e();
            int m2637e4 = c2621cj2.m2637e() - 1;
            if (m2637e4 < 0 || m2637e4 >= m2637e) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(m2637e4);
                Log.w("AtomParsers", sb.toString());
            } else {
                String str = strArr[m2637e4];
                int i2 = m2639c + m2637e3;
                int i3 = ach.f3194b;
                while (true) {
                    int m2639c2 = c2621cj2.m2639c();
                    if (m2639c2 >= i2) {
                        aawVar = null;
                        break;
                    }
                    int m2637e5 = c2621cj2.m2637e();
                    if (c2621cj2.m2637e() != 1684108385) {
                        c2621cj2.m2644F(m2639c2 + m2637e5);
                    } else {
                        int m2637e6 = c2621cj2.m2637e();
                        int m2637e7 = c2621cj2.m2637e();
                        int i4 = m2637e5 - 16;
                        byte[] bArr = new byte[i4];
                        c2621cj2.m2649A(bArr, 0, i4);
                        aawVar = new aaw(str, bArr, m2637e7, m2637e6);
                        break;
                    }
                }
                if (aawVar != null) {
                    arrayList.add(aawVar);
                }
            }
            c2621cj2.m2644F(m2639c + m2637e3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C2549ak(arrayList);
    }

    /* renamed from: c */
    public static void m5877c(C2621cj c2621cj) {
        int m2639c = c2621cj.m2639c();
        c2621cj.m2643G(4);
        if (c2621cj.m2637e() != 1751411826) {
            m2639c += 4;
        }
        c2621cj.m2644F(m2639c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b7, code lost:
        if (r14 == 0) goto L637;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x078c, code lost:
        if (r22 == null) goto L591;
     */
    /* JADX WARN: Removed duplicated region for block: B:378:0x07ff  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0a01  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0ad7  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0aec  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0b3d  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0b52  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0b55  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0bb6  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0bc6  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0c8d  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x0cd8  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0cda  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x0cf2  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x0d56  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0d58  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x0d5d  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x0d60  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0d63  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x0d67  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0d6c  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0d70  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x0d74  */
    /* JADX WARN: Removed duplicated region for block: B:589:0x0d82  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0e3d  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x0d4f A[EDGE_INSN: B:618:0x0d4f->B:569:0x0d4f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0acb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019d  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List m5876d(com.google.ads.interactivemedia.p034v3.internal.abr r56, com.google.ads.interactivemedia.p034v3.internal.C3237ze r57, long r58, com.google.ads.interactivemedia.p034v3.internal.C2854l r60, boolean r61, com.google.ads.interactivemedia.p034v3.internal.ath r62) throws com.google.ads.interactivemedia.p034v3.internal.C2555ao {
        /*
            Method dump skipped, instructions count: 3662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aca.m5876d(com.google.ads.interactivemedia.v3.internal.abr, com.google.ads.interactivemedia.v3.internal.ze, long, com.google.ads.interactivemedia.v3.internal.l, boolean, com.google.ads.interactivemedia.v3.internal.ath):java.util.List");
    }

    /* renamed from: e */
    private static int m5875e(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    /* renamed from: f */
    private static int m5874f(C2621cj c2621cj) {
        int m2633i = c2621cj.m2633i();
        int i = m2633i & 127;
        while ((m2633i & 128) == 128) {
            m2633i = c2621cj.m2633i();
            i = (i << 7) | (m2633i & 127);
        }
        return i;
    }

    /* renamed from: g */
    private static int m5873g(C2621cj c2621cj) {
        c2621cj.m2644F(16);
        return c2621cj.m2637e();
    }

    /* renamed from: h */
    private static Pair m5872h(abr abrVar) {
        abs m5892b = abrVar.m5892b(Atom.TYPE_elst);
        if (m5892b == null) {
            return null;
        }
        C2621cj c2621cj = m5892b.f3106a;
        c2621cj.m2644F(8);
        int m5888f = abt.m5888f(c2621cj.m2637e());
        int m2630l = c2621cj.m2630l();
        long[] jArr = new long[m2630l];
        long[] jArr2 = new long[m2630l];
        for (int i = 0; i < m2630l; i++) {
            jArr[i] = m5888f == 1 ? c2621cj.m2625q() : c2621cj.m2626p();
            jArr2[i] = m5888f == 1 ? c2621cj.m2627o() : c2621cj.m2637e();
            if (c2621cj.m2618x() == 1) {
                c2621cj.m2643G(2);
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    /* renamed from: i */
    private static Pair m5871i(C2621cj c2621cj, int i) {
        c2621cj.m2644F(i + 12);
        c2621cj.m2643G(1);
        m5874f(c2621cj);
        c2621cj.m2643G(2);
        int m2633i = c2621cj.m2633i();
        if ((m2633i & 128) != 0) {
            c2621cj.m2643G(2);
        }
        if ((m2633i & 64) != 0) {
            c2621cj.m2643G(c2621cj.m2629m());
        }
        if ((m2633i & 32) != 0) {
            c2621cj.m2643G(2);
        }
        c2621cj.m2643G(1);
        m5874f(c2621cj);
        String m4970g = C2554an.m4970g(c2621cj.m2633i());
        if (MimeTypes.AUDIO_MPEG.equals(m4970g) || MimeTypes.AUDIO_DTS.equals(m4970g) || MimeTypes.AUDIO_DTS_HD.equals(m4970g)) {
            return Pair.create(m4970g, null);
        }
        c2621cj.m2643G(12);
        c2621cj.m2643G(1);
        int m5874f = m5874f(c2621cj);
        byte[] bArr = new byte[m5874f];
        c2621cj.m2649A(bArr, 0, m5874f);
        return Pair.create(m4970g, bArr);
    }

    /* renamed from: j */
    private static Pair m5870j(C2621cj c2621cj) {
        c2621cj.m2644F(8);
        int m5888f = abt.m5888f(c2621cj.m2637e());
        c2621cj.m2643G(m5888f == 0 ? 8 : 16);
        long m2626p = c2621cj.m2626p();
        c2621cj.m2643G(m5888f == 0 ? 4 : 8);
        int m2629m = c2621cj.m2629m();
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) (((m2629m >> 10) & 31) + 96));
        sb.append((char) (((m2629m >> 5) & 31) + 96));
        sb.append((char) ((m2629m & 31) + 96));
        return Pair.create(Long.valueOf(m2626p), sb.toString());
    }

    /* renamed from: k */
    private static Pair m5869k(C2621cj c2621cj, int i, int i2) throws C2555ao {
        Integer num;
        acq acqVar;
        Pair create;
        int i3;
        int i4;
        byte[] bArr;
        int m2639c = c2621cj.m2639c();
        while (m2639c - i < i2) {
            c2621cj.m2644F(m2639c);
            int m2637e = c2621cj.m2637e();
            C2539ab.m5956h(m2637e > 0, "childAtomSize must be positive");
            if (c2621cj.m2637e() == 1936289382) {
                int i5 = m2639c + 8;
                int i6 = -1;
                int i7 = 0;
                String str = null;
                Integer num2 = null;
                while (i5 - m2639c < m2637e) {
                    c2621cj.m2644F(i5);
                    int m2637e2 = c2621cj.m2637e();
                    int m2637e3 = c2621cj.m2637e();
                    if (m2637e3 == 1718775137) {
                        num2 = Integer.valueOf(c2621cj.m2637e());
                    } else if (m2637e3 == 1935894637) {
                        c2621cj.m2643G(4);
                        str = c2621cj.m2621u(4);
                    } else if (m2637e3 == 1935894633) {
                        i6 = i5;
                        i7 = m2637e2;
                    }
                    i5 += m2637e2;
                }
                if (C3282C.CENC_TYPE_cenc.equals(str) || C3282C.CENC_TYPE_cbc1.equals(str) || C3282C.CENC_TYPE_cens.equals(str) || C3282C.CENC_TYPE_cbcs.equals(str)) {
                    C2539ab.m5956h(num2 != null, "frma atom is mandatory");
                    C2539ab.m5956h(i6 != -1, "schi atom is mandatory");
                    int i8 = i6 + 8;
                    while (true) {
                        if (i8 - i6 >= i7) {
                            num = num2;
                            acqVar = null;
                            break;
                        }
                        c2621cj.m2644F(i8);
                        int m2637e4 = c2621cj.m2637e();
                        if (c2621cj.m2637e() == 1952804451) {
                            int m2637e5 = c2621cj.m2637e();
                            c2621cj.m2643G(1);
                            if (abt.m5888f(m2637e5) == 0) {
                                c2621cj.m2643G(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int m2633i = c2621cj.m2633i();
                                i3 = m2633i & 15;
                                i4 = (m2633i & 240) >> 4;
                            }
                            boolean z = c2621cj.m2633i() == 1;
                            int m2633i2 = c2621cj.m2633i();
                            byte[] bArr2 = new byte[16];
                            c2621cj.m2649A(bArr2, 0, 16);
                            if (z && m2633i2 == 0) {
                                int m2633i3 = c2621cj.m2633i();
                                byte[] bArr3 = new byte[m2633i3];
                                c2621cj.m2649A(bArr3, 0, m2633i3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = num2;
                            acqVar = new acq(z, str, m2633i2, bArr2, i4, i3, bArr);
                        } else {
                            i8 += m2637e4;
                        }
                    }
                    C2539ab.m5956h(acqVar != null, "tenc atom is mandatory");
                    int i9 = C2628cq.f6961a;
                    create = Pair.create(num, acqVar);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            m2639c += m2637e;
        }
        return null;
    }

    /* renamed from: l */
    private static ByteBuffer m5868l() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0169  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m5867m(com.google.ads.interactivemedia.p034v3.internal.C2621cj r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, com.google.ads.interactivemedia.p034v3.internal.C2854l r29, com.google.ads.interactivemedia.p034v3.internal.abw r30, int r31) throws com.google.ads.interactivemedia.p034v3.internal.C2555ao {
        /*
            Method dump skipped, instructions count: 969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aca.m5867m(com.google.ads.interactivemedia.v3.internal.cj, int, int, int, int, java.lang.String, boolean, com.google.ads.interactivemedia.v3.internal.l, com.google.ads.interactivemedia.v3.internal.abw, int):void");
    }
}
