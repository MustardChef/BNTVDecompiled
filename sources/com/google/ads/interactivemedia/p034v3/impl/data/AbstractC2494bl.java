package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2459ad.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bl */
/* loaded from: classes2.dex */
public abstract class AbstractC2494bl {
    public static AbstractC2494bl create(long j, EnumC2492bj enumC2492bj, EnumC2493bk enumC2493bk) {
        return new C2459ad(j, enumC2492bj, enumC2493bk, null);
    }

    public abstract EnumC2492bj component();

    public abstract AbstractC2497bo loggableException();

    public abstract EnumC2493bk method();

    public abstract long timestamp();

    static AbstractC2494bl create(long j, EnumC2492bj enumC2492bj, EnumC2493bk enumC2493bk, AbstractC2497bo abstractC2497bo) {
        return new C2459ad(j, enumC2492bj, enumC2493bk, abstractC2497bo);
    }

    public static AbstractC2494bl create(long j, EnumC2492bj enumC2492bj, EnumC2493bk enumC2493bk, Throwable th) {
        return create(j, enumC2492bj, enumC2493bk, AbstractC2497bo.create(th));
    }
}
