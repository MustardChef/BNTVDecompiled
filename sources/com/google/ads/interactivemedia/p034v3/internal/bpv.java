package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpv */
/* loaded from: classes2.dex */
public abstract class bpv {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static final String m2876f(ByteBuffer byteBuffer, int i, int i2) throws bnm {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
            if (!bqd.m2789e(b)) {
                break;
            }
            i++;
            bqd.m2792b(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (bqd.m2789e(b2)) {
                int i7 = i5 + 1;
                bqd.m2792b(b2, cArr, i5);
                i = i6;
                while (true) {
                    i5 = i7;
                    if (i < i3) {
                        byte b3 = byteBuffer.get(i);
                        if (!bqd.m2789e(b3)) {
                            break;
                        }
                        i++;
                        i7 = i5 + 1;
                        bqd.m2792b(b3, cArr, i5);
                    }
                }
            } else if (bqd.m2788f(b2)) {
                if (i6 < i3) {
                    bqd.m2791c(b2, byteBuffer.get(i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw bnm.m3255d();
                }
            } else if (bqd.m2787g(b2)) {
                if (i6 < i3 - 1) {
                    int i8 = i6 + 1;
                    bqd.m2790d(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                    i = i8 + 1;
                    i5++;
                } else {
                    throw bnm.m3255d();
                }
            } else if (i6 < i3 - 2) {
                int i9 = i6 + 1;
                int i10 = i9 + 1;
                bqd.m2793a(b2, byteBuffer.get(i6), byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                i5 += 2;
                i = i10 + 1;
            } else {
                throw bnm.m3255d();
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract int mo2875a(CharSequence charSequence, byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract int mo2874b(int i, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract String mo2873c(byte[] bArr, int i, int i2) throws bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract String mo2872d(ByteBuffer byteBuffer, int i, int i2) throws bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean m2877e(byte[] bArr, int i, int i2) {
        return mo2874b(0, bArr, i, i2) == 0;
    }
}
