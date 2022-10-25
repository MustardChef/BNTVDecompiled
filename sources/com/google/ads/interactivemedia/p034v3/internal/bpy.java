package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpy */
/* loaded from: classes2.dex */
public final class bpy {

    /* renamed from: a */
    private static final bpv f6409a;

    static {
        if (bpu.m2913B() && bpu.m2912C()) {
            int i = ble.f5993a;
        }
        f6409a = new bpw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ int m2869c(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return m2859m(b, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return m2860l(b, bArr[i]);
        }
        return m2861k(b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static int m2868d(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f6409a.mo2875a(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static int m2867e(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new bpx(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(i3 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: f */
    public static int m2866f(int i, byte[] bArr, int i2, int i3) {
        return f6409a.mo2874b(i, bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static String m2865g(ByteBuffer byteBuffer, int i, int i2) throws bnm {
        bpv bpvVar = f6409a;
        if (byteBuffer.hasArray()) {
            return bpvVar.mo2873c(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        }
        return byteBuffer.isDirect() ? bpvVar.mo2872d(byteBuffer, i, i2) : bpv.m2876f(byteBuffer, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static String m2864h(byte[] bArr, int i, int i2) throws bnm {
        return f6409a.mo2873c(bArr, i, i2);
    }

    /* renamed from: i */
    public static boolean m2863i(byte[] bArr) {
        return f6409a.m2877e(bArr, 0, bArr.length);
    }

    /* renamed from: j */
    public static boolean m2862j(byte[] bArr, int i, int i2) {
        return f6409a.m2877e(bArr, i, i2);
    }

    /* renamed from: k */
    private static int m2861k(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static int m2860l(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static int m2859m(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }
}
