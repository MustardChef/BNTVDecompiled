package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qv */
/* loaded from: classes2.dex */
public final class C3011qv {

    /* renamed from: a */
    private long f8662a;

    /* renamed from: b */
    private long f8663b;

    /* renamed from: c */
    private boolean f8664c;

    /* renamed from: d */
    private final long m1269d(long j) {
        return this.f8662a + Math.max(0L, ((this.f8663b - 529) * 1000000) / j);
    }

    /* renamed from: a */
    public final long m1272a(C2962p c2962p) {
        return m1269d(c2962p.f8386z);
    }

    /* renamed from: b */
    public final long m1271b(C2962p c2962p, C2669ed c2669ed) {
        if (this.f8663b == 0) {
            this.f8662a = c2669ed.f7094d;
        }
        if (this.f8664c) {
            return c2669ed.f7094d;
        }
        ByteBuffer byteBuffer = c2669ed.f7092b;
        C2616ce.m2689d(byteBuffer);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int m477c = C3241zi.m477c(i);
        if (m477c == -1) {
            this.f8664c = true;
            this.f8663b = 0L;
            this.f8662a = c2669ed.f7094d;
            Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return c2669ed.f7094d;
        }
        long m1269d = m1269d(c2962p.f8386z);
        this.f8663b += m477c;
        return m1269d;
    }

    /* renamed from: c */
    public final void m1270c() {
        this.f8662a = 0L;
        this.f8663b = 0L;
        this.f8664c = false;
    }
}
