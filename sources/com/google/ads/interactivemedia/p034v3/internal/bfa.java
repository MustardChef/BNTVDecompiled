package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfa */
/* loaded from: classes2.dex */
abstract class bfa implements bfn {

    /* renamed from: b */
    private static final int[] f5627b = m3775i(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: a */
    int[] f5628a;

    /* renamed from: c */
    private final int f5629c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bfa(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f5628a = m3775i(bArr);
        this.f5629c = i;
    }

    /* renamed from: f */
    static void m3778f(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int m3774j = m3774j(i5 ^ iArr[i4], 16);
        iArr[i4] = m3774j;
        int i6 = iArr[i3] + m3774j;
        iArr[i3] = i6;
        int m3774j2 = m3774j(iArr[i2] ^ i6, 12);
        iArr[i2] = m3774j2;
        int i7 = iArr[i] + m3774j2;
        iArr[i] = i7;
        int m3774j3 = m3774j(iArr[i4] ^ i7, 8);
        iArr[i4] = m3774j3;
        int i8 = iArr[i3] + m3774j3;
        iArr[i3] = i8;
        iArr[i2] = m3774j(iArr[i2] ^ i8, 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static void m3777g(int[] iArr, int[] iArr2) {
        int[] iArr3 = f5627b;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static void m3776h(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            m3778f(iArr, 0, 4, 8, 12);
            m3778f(iArr, 1, 5, 9, 13);
            m3778f(iArr, 2, 6, 10, 14);
            m3778f(iArr, 3, 7, 11, 15);
            m3778f(iArr, 0, 5, 10, 15);
            m3778f(iArr, 1, 6, 11, 12);
            m3778f(iArr, 2, 7, 8, 13);
            m3778f(iArr, 3, 4, 9, 14);
        }
    }

    /* renamed from: i */
    static int[] m3775i(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    /* renamed from: j */
    private static int m3774j(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bfn
    /* renamed from: a */
    public final byte[] mo3761a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > Integer.MAX_VALUE - mo3734b()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate(mo3734b() + length);
        m3779e(allocate, bArr);
        return allocate.array();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract int mo3734b();

    /* renamed from: c */
    abstract int[] mo3733c(int[] iArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final ByteBuffer m3780d(byte[] bArr, int i) {
        int[] mo3733c = mo3733c(m3775i(bArr), i);
        int[] iArr = (int[]) mo3733c.clone();
        m3776h(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            mo3733c[i2] = mo3733c[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(mo3733c, 0, 16);
        return order;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final void m3779e(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - mo3734b() < bArr.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] m3737b = bfu.m3737b(mo3734b());
        byteBuffer.put(m3737b);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int remaining = wrap.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer m3780d = m3780d(m3737b, this.f5629c + i2);
            if (i2 == i - 1) {
                bfo.m3754g(byteBuffer, wrap, m3780d, remaining % 64);
            } else {
                bfo.m3754g(byteBuffer, wrap, m3780d, 64);
            }
        }
    }
}
