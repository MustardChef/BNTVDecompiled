package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import okhttp3.internal.http.HttpStatusCodes;
import okio.Utf8;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ye */
/* loaded from: classes2.dex */
public final class C3210ye {

    /* renamed from: a */
    public static final /* synthetic */ int f9476a = 0;

    /* renamed from: b */
    private static final int[] f9477b = {1, 2, 3, 6};

    /* renamed from: c */
    private static final int[] f9478c = {OpusUtil.SAMPLE_RATE, 44100, 32000};

    /* renamed from: d */
    private static final int[] f9479d = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};

    /* renamed from: e */
    private static final int[] f9480e = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: f */
    private static final int[] f9481f = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: g */
    private static final int[] f9482g = {69, 87, 104, 121, 139, 174, 208, 243, bqk.f6536aw, 348, HttpStatusCodes.HTTP_EXPECTATION_FAILED, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: a */
    public static int m553a(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f9477b[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    /* renamed from: b */
    public static int m552b(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return m548f((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    /* renamed from: c */
    public static C2962p m551c(C2621cj c2621cj, String str, String str2, C2854l c2854l) {
        int i = f9478c[(c2621cj.m2633i() & 192) >> 6];
        int m2633i = c2621cj.m2633i();
        int i2 = f9480e[(m2633i & 56) >> 3];
        if ((m2633i & 4) != 0) {
            i2++;
        }
        C2935o c2935o = new C2935o();
        c2935o.m1545S(str);
        c2935o.m1532ae(MimeTypes.AUDIO_AC3);
        c2935o.m1556H(i2);
        c2935o.m1531af(i);
        c2935o.m1551M(c2854l);
        c2935o.m1542V(str2);
        return c2935o.m1506v();
    }

    /* renamed from: d */
    public static C2962p m550d(C2621cj c2621cj, String str, String str2, C2854l c2854l) {
        c2621cj.m2643G(2);
        int i = f9478c[(c2621cj.m2633i() & 192) >> 6];
        int m2633i = c2621cj.m2633i();
        int i2 = f9480e[(m2633i & 14) >> 1];
        if ((m2633i & 1) != 0) {
            i2++;
        }
        if (((c2621cj.m2633i() & 30) >> 1) > 0 && (2 & c2621cj.m2633i()) != 0) {
            i2 += 2;
        }
        String str3 = (c2621cj.m2641a() <= 0 || (c2621cj.m2633i() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC;
        C2935o c2935o = new C2935o();
        c2935o.m1545S(str);
        c2935o.m1532ae(str3);
        c2935o.m1556H(i2);
        c2935o.m1531af(i);
        c2935o.m1551M(c2854l);
        c2935o.m1542V(str2);
        return c2935o.m1506v();
    }

    /* renamed from: e */
    public static C3209yd m549e(C2620ci c2620ci) {
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        int m2661c;
        int i5;
        int i6;
        int i7;
        int i8;
        int m2662b = c2620ci.m2662b();
        c2620ci.m2655i(40);
        int m2661c2 = c2620ci.m2661c(5);
        c2620ci.m2657g(m2662b);
        if (m2661c2 > 10) {
            c2620ci.m2655i(16);
            int m2661c3 = c2620ci.m2661c(2);
            if (m2661c3 == 0) {
                r1 = 0;
            } else if (m2661c3 == 1) {
                r1 = 1;
            } else if (m2661c3 == 2) {
                r1 = 2;
            }
            c2620ci.m2655i(3);
            int m2661c4 = c2620ci.m2661c(11) + 1;
            int i9 = m2661c4 + m2661c4;
            int m2661c5 = c2620ci.m2661c(2);
            if (m2661c5 == 3) {
                i6 = f9479d[c2620ci.m2661c(2)];
                m2661c = 3;
                i5 = 6;
            } else {
                m2661c = c2620ci.m2661c(2);
                i5 = f9477b[m2661c];
                i6 = f9478c[m2661c5];
            }
            int i10 = i5 * 256;
            int m2661c6 = c2620ci.m2661c(3);
            boolean m2653k = c2620ci.m2653k();
            int i11 = f9480e[m2661c6] + (m2653k ? 1 : 0);
            c2620ci.m2655i(10);
            if (c2620ci.m2653k()) {
                c2620ci.m2655i(8);
            }
            if (m2661c6 == 0) {
                c2620ci.m2655i(5);
                if (c2620ci.m2653k()) {
                    c2620ci.m2655i(8);
                }
                i7 = 0;
            } else {
                i7 = m2661c6;
            }
            if (r1 == 1) {
                if (c2620ci.m2653k()) {
                    c2620ci.m2655i(16);
                }
                r1 = 1;
            }
            if (c2620ci.m2653k()) {
                if (i7 > 2) {
                    c2620ci.m2655i(2);
                }
                if ((i7 & 1) != 0 && i7 > 2) {
                    c2620ci.m2655i(6);
                }
                if ((i7 & 4) != 0) {
                    c2620ci.m2655i(6);
                }
                if (m2653k && c2620ci.m2653k()) {
                    c2620ci.m2655i(5);
                }
                if (r1 == 0) {
                    if (c2620ci.m2653k()) {
                        c2620ci.m2655i(6);
                    }
                    if (i7 == 0 && c2620ci.m2653k()) {
                        c2620ci.m2655i(6);
                    }
                    if (c2620ci.m2653k()) {
                        c2620ci.m2655i(6);
                    }
                    int m2661c7 = c2620ci.m2661c(2);
                    if (m2661c7 == 1) {
                        c2620ci.m2655i(5);
                    } else if (m2661c7 == 2) {
                        c2620ci.m2655i(12);
                    } else if (m2661c7 == 3) {
                        int m2661c8 = c2620ci.m2661c(5);
                        if (c2620ci.m2653k()) {
                            c2620ci.m2655i(5);
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(4);
                            }
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(4);
                            }
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(4);
                            }
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(4);
                            }
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(4);
                            }
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(4);
                            }
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(4);
                            }
                            if (c2620ci.m2653k()) {
                                if (c2620ci.m2653k()) {
                                    c2620ci.m2655i(4);
                                }
                                if (c2620ci.m2653k()) {
                                    c2620ci.m2655i(4);
                                }
                            }
                        }
                        if (c2620ci.m2653k()) {
                            c2620ci.m2655i(5);
                            if (c2620ci.m2653k()) {
                                c2620ci.m2655i(7);
                                if (c2620ci.m2653k()) {
                                    c2620ci.m2655i(8);
                                    c2620ci.m2655i((m2661c8 + 2) * 8);
                                    c2620ci.m2660d();
                                }
                            }
                        }
                        c2620ci.m2655i((m2661c8 + 2) * 8);
                        c2620ci.m2660d();
                    }
                    if (i7 < 2) {
                        if (c2620ci.m2653k()) {
                            c2620ci.m2655i(14);
                        }
                        if (m2661c6 == 0 && c2620ci.m2653k()) {
                            c2620ci.m2655i(14);
                        }
                    }
                    if (c2620ci.m2653k()) {
                        if (m2661c == 0) {
                            c2620ci.m2655i(5);
                            m2661c = 0;
                        } else {
                            for (int i12 = 0; i12 < i5; i12++) {
                                if (c2620ci.m2653k()) {
                                    c2620ci.m2655i(5);
                                }
                            }
                        }
                    }
                }
            }
            if (c2620ci.m2653k()) {
                c2620ci.m2655i(5);
                if (i7 == 2) {
                    c2620ci.m2655i(4);
                }
                if (i7 >= 6) {
                    c2620ci.m2655i(2);
                }
                if (c2620ci.m2653k()) {
                    i8 = 8;
                    c2620ci.m2655i(8);
                } else {
                    i8 = 8;
                }
                if (i7 == 0 && c2620ci.m2653k()) {
                    c2620ci.m2655i(i8);
                }
                if (m2661c5 < 3) {
                    c2620ci.m2656h();
                }
            }
            if (r1 == 0 && m2661c != 3) {
                c2620ci.m2656h();
            }
            if (r1 == 2 && (m2661c == 3 || c2620ci.m2653k())) {
                c2620ci.m2655i(6);
            }
            str = (c2620ci.m2653k() && c2620ci.m2661c(6) == 1 && c2620ci.m2661c(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i2 = i9;
            i4 = i10;
            i = i6;
            i3 = i11;
        } else {
            c2620ci.m2655i(32);
            int m2661c9 = c2620ci.m2661c(2);
            String str2 = m2661c9 == 3 ? null : MimeTypes.AUDIO_AC3;
            int m548f = m548f(m2661c9, c2620ci.m2661c(6));
            c2620ci.m2655i(8);
            int m2661c10 = c2620ci.m2661c(3);
            if ((m2661c10 & 1) != 0 && m2661c10 != 1) {
                c2620ci.m2655i(2);
            }
            if ((m2661c10 & 4) != 0) {
                c2620ci.m2655i(2);
            }
            if (m2661c10 == 2) {
                c2620ci.m2655i(2);
            }
            i = m2661c9 < 3 ? f9478c[m2661c9] : -1;
            str = str2;
            i2 = m548f;
            i3 = f9480e[m2661c10] + (c2620ci.m2653k() ? 1 : 0);
            i4 = 1536;
        }
        return new C3209yd(str, i3, i, i2, i4);
    }

    /* renamed from: f */
    private static int m548f(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= 3 || i2 < 0 || i3 >= 19) {
            return -1;
        }
        int i4 = f9478c[i];
        if (i4 == 44100) {
            int i5 = f9482g[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = f9481f[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
