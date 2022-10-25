package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.Sniffer;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aco */
/* loaded from: classes2.dex */
final class aco {

    /* renamed from: a */
    private static final int[] f3229a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, Sniffer.BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};

    /* renamed from: a */
    public static boolean m5829a(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return m5827c(interfaceC3230yy, true);
    }

    /* renamed from: b */
    public static boolean m5828b(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return m5827c(interfaceC3230yy, false);
    }

    /* renamed from: c */
    private static boolean m5827c(InterfaceC3230yy interfaceC3230yy, boolean z) throws IOException {
        boolean z2;
        long mo500b = interfaceC3230yy.mo500b();
        long j = -1;
        long j2 = 4096;
        int i = (mo500b > (-1L) ? 1 : (mo500b == (-1L) ? 0 : -1));
        if (i != 0 && mo500b <= 4096) {
            j2 = mo500b;
        }
        int i2 = (int) j2;
        C2621cj c2621cj = new C2621cj(64);
        boolean z3 = false;
        int i3 = 0;
        boolean z4 = false;
        while (i3 < i2) {
            c2621cj.m2648B(8);
            if (!interfaceC3230yy.mo492k(c2621cj.m2642H(), z3 ? 1 : 0, 8, true)) {
                break;
            }
            long m2626p = c2621cj.m2626p();
            int m2637e = c2621cj.m2637e();
            int i4 = 16;
            if (m2626p == 1) {
                interfaceC3230yy.mo496f(c2621cj.m2642H(), 8, 8);
                c2621cj.m2645E(16);
                m2626p = c2621cj.m2627o();
            } else {
                if (m2626p == 0) {
                    long mo500b2 = interfaceC3230yy.mo500b();
                    if (mo500b2 != j) {
                        m2626p = (mo500b2 - interfaceC3230yy.mo499c()) + 8;
                    }
                }
                i4 = 8;
            }
            long j3 = i4;
            if (m2626p < j3) {
                return z3;
            }
            i3 += i4;
            if (m2637e == 1836019574) {
                i2 += (int) m2626p;
                if (i != 0 && i2 > mo500b) {
                    i2 = (int) mo500b;
                }
                j = -1;
            } else if (m2637e == 1836019558 || m2637e == 1836475768) {
                z2 = true;
                break;
            } else {
                long j4 = mo500b;
                if ((i3 + m2626p) - j3 >= i2) {
                    break;
                }
                int i5 = (int) (m2626p - j3);
                i3 += i5;
                if (m2637e == 1718909296) {
                    if (i5 < 8) {
                        return false;
                    }
                    c2621cj.m2648B(i5);
                    interfaceC3230yy.mo496f(c2621cj.m2642H(), 0, i5);
                    int i6 = i5 >> 2;
                    for (int i7 = 0; i7 < i6; i7++) {
                        if (i7 == 1) {
                            c2621cj.m2643G(4);
                        } else {
                            int m2637e2 = c2621cj.m2637e();
                            if ((m2637e2 >>> 8) != 3368816) {
                                if (m2637e2 == 1751476579) {
                                    m2637e2 = Sniffer.BRAND_HEIC;
                                }
                                int[] iArr = f3229a;
                                for (int i8 = 0; i8 < 29; i8++) {
                                    if (iArr[i8] != m2637e2) {
                                    }
                                }
                                continue;
                            }
                            z4 = true;
                            break;
                        }
                    }
                    if (!z4) {
                        return false;
                    }
                } else if (i5 != 0) {
                    interfaceC3230yy.mo497e(i5);
                }
                mo500b = j4;
                j = -1;
                z3 = false;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }
}
