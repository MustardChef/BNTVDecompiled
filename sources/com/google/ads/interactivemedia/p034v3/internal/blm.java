package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blm */
/* loaded from: classes2.dex */
public final class blm extends blq {
    private static final long serialVersionUID = 1;

    /* renamed from: c */
    private final int f6011c;

    /* renamed from: d */
    private final int f6012d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public blm(byte[] bArr, int i, int i2) {
        super(bArr);
        m3506q(i, i + i2, bArr.length);
        this.f6011c = i;
        this.f6012d = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blq, com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: a */
    public final byte mo3057a(int i) {
        m3511A(i, this.f6012d);
        return this.f6013a[this.f6011c + i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blq, com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: b */
    final byte mo3056b(int i) {
        return this.f6013a[this.f6011c + i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blq
    /* renamed from: c */
    protected final int mo3514c() {
        return this.f6011c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blq, com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: d */
    public final int mo3054d() {
        return this.f6012d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blq, com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: e */
    protected final void mo3053e(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f6013a, this.f6011c + i, bArr, i2, i3);
    }

    Object writeReplace() {
        return bls.m3500x(m3509C());
    }
}
