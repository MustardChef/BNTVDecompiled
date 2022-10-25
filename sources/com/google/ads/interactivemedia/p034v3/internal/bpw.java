package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpw */
/* loaded from: classes2.dex */
final class bpw extends bpv {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bpv
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo2875a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bpw.mo2875a(java.lang.CharSequence, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
        if (r13[r14] <= (-65)) goto L11;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bpv
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo2874b(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bpw.mo2874b(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bpv
    /* renamed from: c */
    public final String mo2873c(byte[] bArr, int i, int i2) throws bnm {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = bArr[i];
            if (!bqd.m2789e(b)) {
                break;
            }
            i++;
            bqd.m2792b(b, cArr, i4);
            i4++;
        }
        while (i < i3) {
            int i5 = i + 1;
            byte b2 = bArr[i];
            if (bqd.m2789e(b2)) {
                int i6 = i4 + 1;
                bqd.m2792b(b2, cArr, i4);
                i = i5;
                while (true) {
                    i4 = i6;
                    if (i < i3) {
                        byte b3 = bArr[i];
                        if (!bqd.m2789e(b3)) {
                            break;
                        }
                        i++;
                        i6 = i4 + 1;
                        bqd.m2792b(b3, cArr, i4);
                    }
                }
            } else if (bqd.m2788f(b2)) {
                if (i5 < i3) {
                    bqd.m2791c(b2, bArr[i5], cArr, i4);
                    i = i5 + 1;
                    i4++;
                } else {
                    throw bnm.m3255d();
                }
            } else if (bqd.m2787g(b2)) {
                if (i5 < i3 - 1) {
                    int i7 = i5 + 1;
                    bqd.m2790d(b2, bArr[i5], bArr[i7], cArr, i4);
                    i = i7 + 1;
                    i4++;
                } else {
                    throw bnm.m3255d();
                }
            } else if (i5 < i3 - 2) {
                int i8 = i5 + 1;
                int i9 = i8 + 1;
                bqd.m2793a(b2, bArr[i5], bArr[i8], bArr[i9], cArr, i4);
                i4 += 2;
                i = i9 + 1;
            } else {
                throw bnm.m3255d();
            }
        }
        return new String(cArr, 0, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bpv
    /* renamed from: d */
    public final String mo2872d(ByteBuffer byteBuffer, int i, int i2) throws bnm {
        return m2876f(byteBuffer, i, i2);
    }
}
