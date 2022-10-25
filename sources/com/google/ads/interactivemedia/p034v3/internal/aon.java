package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aon */
/* loaded from: classes2.dex */
public final class aon extends ape {

    /* renamed from: h */
    private static volatile Long f4805h;

    /* renamed from: i */
    private static final Object f4806i = new Object();

    public aon(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "hUIXYyX7voAFfmX9K6Tyj7UNRMoApsO3NHhichzgf1HY6Km4YpCnpT8GA4sfwulx", "RhEw32BK9OU3wzUC3Jj98VTZvnt6yWz3Jzx/x8tD2qo=", agaVar, i, 22, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        if (f4805h == null) {
            synchronized (f4806i) {
                if (f4805h == null) {
                    f4805h = (Long) this.f4830d.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f4833g) {
            this.f4833g.m5425ac(f4805h.longValue());
        }
    }
}
