package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abb */
/* loaded from: classes2.dex */
final class abb {

    /* renamed from: a */
    private final byte[] f2946a = new byte[8];

    /* renamed from: b */
    private final ArrayDeque f2947b = new ArrayDeque();

    /* renamed from: c */
    private final abi f2948c = new abi();

    /* renamed from: d */
    private abc f2949d;

    /* renamed from: e */
    private int f2950e;

    /* renamed from: f */
    private int f2951f;

    /* renamed from: g */
    private long f2952g;

    /* renamed from: d */
    private final long m5945d(InterfaceC3230yy interfaceC3230yy, int i) throws IOException {
        interfaceC3230yy.mo495g(this.f2946a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.f2946a[i2] & 255);
        }
        return j;
    }

    /* renamed from: a */
    public final void m5948a(abc abcVar) {
        this.f2949d = abcVar;
    }

    /* renamed from: b */
    public final void m5947b() {
        this.f2950e = 0;
        this.f2947b.clear();
        this.f2948c.m5906e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
        if (r0 == 1) goto L38;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m5946c(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 768
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.abb.m5946c(com.google.ads.interactivemedia.v3.internal.yy):boolean");
    }
}
