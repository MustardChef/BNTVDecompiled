package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aab */
/* loaded from: classes2.dex */
public final class aab extends AbstractC3257zy {
    /* renamed from: c */
    public static final aaa m5981c(C2621cj c2621cj) {
        String m2623s = c2621cj.m2623s();
        C2616ce.m2689d(m2623s);
        String m2623s2 = c2621cj.m2623s();
        C2616ce.m2689d(m2623s2);
        return new aaa(m2623s, m2623s2, c2621cj.m2627o(), c2621cj.m2627o(), Arrays.copyOfRange(c2621cj.m2642H(), c2621cj.m2639c(), c2621cj.m2638d()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3257zy
    /* renamed from: b */
    protected final C2549ak mo424b(ByteBuffer byteBuffer) {
        return new C2549ak(m5981c(new C2621cj(byteBuffer.array(), byteBuffer.limit())));
    }
}
