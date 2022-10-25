package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aoz */
/* loaded from: classes2.dex */
public final class aoz extends ape {

    /* renamed from: h */
    private static volatile Long f4815h;

    /* renamed from: i */
    private static final Object f4816i = new Object();

    public aoz(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "M8X9pjLXmkUmNpxAUiXCS0VzRrfgsx47JCdWPtF77o1zbxjaTxGH9o3y3XsfapA3", "IGAB4+J/PDJStxsBeRODYeAaV8Ap48L0bK2MK3UJNBs=", agaVar, i, 33, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        if (f4815h == null) {
            synchronized (f4816i) {
                if (f4815h == null) {
                    f4815h = (Long) this.f4830d.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f4833g) {
            this.f4833g.m5402az(f4815h.longValue());
        }
    }
}
