package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zy */
/* loaded from: classes2.dex */
public abstract class AbstractC3257zy {
    /* renamed from: a */
    public final C2549ak m425a(C2669ed c2669ed) {
        ByteBuffer byteBuffer = c2669ed.f7092b;
        C2616ce.m2689d(byteBuffer);
        boolean z = false;
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z = true;
        }
        C2616ce.m2687f(z);
        if (c2669ed.m2463f()) {
            return null;
        }
        return mo424b(byteBuffer);
    }

    /* renamed from: b */
    protected abstract C2549ak mo424b(ByteBuffer byteBuffer);
}
