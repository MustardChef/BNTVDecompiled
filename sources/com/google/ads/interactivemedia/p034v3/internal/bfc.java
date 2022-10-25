package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfc */
/* loaded from: classes2.dex */
abstract class bfc implements azb {

    /* renamed from: a */
    public static final int f5630a = bbp.f5396a;

    /* renamed from: b */
    private final bfa f5631b;

    /* renamed from: c */
    private final bfa f5632c;

    public bfc(byte[] bArr) throws GeneralSecurityException {
        if (!bbp.m4200a(f5630a)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.f5631b = mo3732b(bArr, 1);
        this.f5632c = mo3732b(bArr, 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azb
    /* renamed from: a */
    public final byte[] mo3767a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        bfa bfaVar = this.f5631b;
        if (length > (Integer.MAX_VALUE - bfaVar.mo3734b()) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate(bfaVar.mo3734b() + length + 16);
        if (allocate.remaining() < length + this.f5631b.mo3734b() + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int position = allocate.position();
        this.f5631b.m3779e(allocate, bArr);
        allocate.position(position);
        byte[] bArr3 = new byte[this.f5631b.mo3734b()];
        allocate.get(bArr3);
        allocate.limit(allocate.limit() - 16);
        byte[] bArr4 = new byte[32];
        this.f5632c.m3780d(bArr3, 0).get(bArr4);
        int remaining = allocate.remaining();
        int i = remaining % 16;
        int i2 = i == 0 ? remaining : (remaining + 16) - i;
        ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr2);
        order.position(0);
        order.put(allocate);
        order.position(i2);
        order.putLong(0L);
        order.putLong(remaining);
        byte[] m3760a = bfo.m3760a(bArr4, order.array());
        allocate.limit(allocate.limit() + 16);
        allocate.put(m3760a);
        return allocate.array();
    }

    /* renamed from: b */
    abstract bfa mo3732b(byte[] bArr, int i) throws InvalidKeyException;
}
