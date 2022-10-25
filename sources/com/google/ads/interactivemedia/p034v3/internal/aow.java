package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aow */
/* loaded from: classes2.dex */
public final class aow extends ape {

    /* renamed from: h */
    private final StackTraceElement[] f4812h;

    public aow(anw anwVar, aga agaVar, int i, StackTraceElement[] stackTraceElementArr, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "xd283h5qAcacM5zVZnbCaCYEYmyBvCzSWmcoDFc838gJ/DBCdoedE0EgOC5ZJs5s", "KFN28huBDzw/UNPPRO5YgG4GEIzzfegN1j75wmksmGk=", agaVar, i, 45, null, null, null);
        this.f4812h = stackTraceElementArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        int i;
        StackTraceElement[] stackTraceElementArr = this.f4812h;
        if (stackTraceElementArr != null) {
            anp anpVar = new anp((String) this.f4830d.invoke(null, stackTraceElementArr));
            synchronized (this.f4833g) {
                this.f4833g.m5417ak(anpVar.f4724a.longValue());
                if (anpVar.f4725b.booleanValue()) {
                    aga agaVar = this.f4833g;
                    if (anpVar.f4726c.booleanValue()) {
                        i = afw.f3908a;
                    } else {
                        i = afw.f3909b;
                    }
                    agaVar.m5431aG(i);
                } else {
                    this.f4833g.m5431aG(afw.f3910c);
                }
            }
        }
    }
}
