package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aov */
/* loaded from: classes2.dex */
public final class aov extends ape {

    /* renamed from: h */
    private final boolean f4811h;

    public aov(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "yRC8yDQzUDrmroLbdHZh1cdlZfd8ub/FsIslAHpddfKGkTWa/jUYdNJ0tT+5diCM", "HM4qeDzacgZSWStWAwQJTi2Amm6uvEB2WlZumyUY0B8=", agaVar, i, 61, null, null, null);
        this.f4811h = anwVar.m4893q();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.f4830d.invoke(null, this.f4827a.m4908b(), Boolean.valueOf(this.f4811h))).longValue();
        synchronized (this.f4833g) {
            this.f4833g.m5418aj(longValue);
        }
    }
}
