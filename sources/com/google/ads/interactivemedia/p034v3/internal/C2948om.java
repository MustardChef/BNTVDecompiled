package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.om */
/* loaded from: classes2.dex */
final class C2948om extends AbstractC3120uw {

    /* renamed from: a */
    private byte[] f8251a;

    public C2948om(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, int i, byte[] bArr) {
        super(interfaceC2637cz, c2642dd, c2962p, i, bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3120uw
    /* renamed from: a */
    protected final void mo856a(byte[] bArr, int i) {
        this.f8251a = Arrays.copyOf(bArr, i);
    }

    /* renamed from: b */
    public final byte[] m1472b() {
        return this.f8251a;
    }
}
