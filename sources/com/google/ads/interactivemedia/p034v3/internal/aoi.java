package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aoi */
/* loaded from: classes2.dex */
public final class aoi extends ape {
    public aoi(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "glZYRiAaVgXhfq7gmv5KdTlxK1u1W7CDU+wEOCdR48SsabliUSLxOyNuMGeUOQq8", "BXtZidg/K24z5N/YUAEC4oPRR4OaYUycAQjBgFG9Ir4=", agaVar, i, 5, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        this.f4833g.m5446S(-1L);
        this.f4833g.m5447R(-1L);
        int[] iArr = (int[]) this.f4830d.invoke(null, this.f4827a.m4908b());
        synchronized (this.f4833g) {
            this.f4833g.m5446S(iArr[0]);
            this.f4833g.m5447R(iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                this.f4833g.m5448Q(i);
            }
        }
    }
}
