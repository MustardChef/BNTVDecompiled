package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aoj */
/* loaded from: classes2.dex */
public final class aoj extends ape {

    /* renamed from: h */
    private static volatile Long f4800h;

    /* renamed from: i */
    private static final Object f4801i = new Object();

    public aoj(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "9GRJeHWq4dh2BvJK4ycB7gT7rSPz0ZkF1/0dgXOpChUtvNoPNNrpav7wZxlsKwP4", "wAGvvwsR6C1vDVsIyeUg+KWcunmHMDzvTAjP5mYaviw=", agaVar, i, 44, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        if (f4800h == null) {
            synchronized (f4801i) {
                if (f4800h == null) {
                    f4800h = (Long) this.f4830d.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f4833g) {
            this.f4833g.m5444U(f4800h.longValue());
        }
    }
}
