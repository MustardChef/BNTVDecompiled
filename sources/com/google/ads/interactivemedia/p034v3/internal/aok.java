package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aok */
/* loaded from: classes2.dex */
public final class aok extends ape {

    /* renamed from: h */
    private final long f4802h;

    public aok(anw anwVar, aga agaVar, long j, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "llxemQySqp4ImE2+K1SCPJZsWjXNCqydynC9yBT/03FiPJ85o8JSvF0iMBwiw5vV", "Do3k5DuMuAsRGeDxKZVVE8+FSftLk9ZlBUPdFxDzrUE=", agaVar, i, 25, null, null, null);
        this.f4802h = j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.f4830d.invoke(null, new Object[0])).longValue();
        synchronized (this.f4833g) {
            this.f4833g.m5439Z(longValue);
            long j = this.f4802h;
            if (j != 0) {
                this.f4833g.m5404ax(longValue - j);
                this.f4833g.m5403ay(this.f4802h);
            }
        }
    }
}
