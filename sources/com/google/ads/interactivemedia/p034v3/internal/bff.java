package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bff */
/* loaded from: classes2.dex */
public final class bff implements azg {

    /* renamed from: a */
    private static final byte[] f5633a = new byte[0];

    /* renamed from: b */
    private final bfh f5634b;

    /* renamed from: c */
    private final String f5635c;

    /* renamed from: d */
    private final byte[] f5636d;

    /* renamed from: e */
    private final bfd f5637e;

    /* renamed from: f */
    private final int f5638f;

    public bff(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, bfd bfdVar) throws GeneralSecurityException {
        bfo.m3757d(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.f5634b = new bfh(eCPublicKey);
        this.f5636d = bArr;
        this.f5635c = str;
        this.f5638f = i;
        this.f5637e = bfdVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azg
    /* renamed from: a */
    public final byte[] mo3771a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        bfg m3768a = this.f5634b.m3768a(this.f5635c, this.f5636d, bArr2, this.f5637e.mo3773a(), this.f5638f);
        byte[] m4183a = this.f5637e.mo3772b(m3768a.m3769b()).m4183a(bArr, f5633a);
        byte[] m3770a = m3768a.m3770a();
        return ByteBuffer.allocate(m3770a.length + m4183a.length).put(m3770a).put(m4183a).array();
    }
}
