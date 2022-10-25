package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Callable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aom */
/* loaded from: classes2.dex */
public final class aom implements Callable {

    /* renamed from: a */
    private final anw f4803a;

    /* renamed from: b */
    private final aga f4804b;

    public aom(anw anwVar, aga agaVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f4803a = anwVar;
        this.f4804b = agaVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.f4803a.m4899k() != null) {
            this.f4803a.m4899k().get();
        }
        afr m4907c = this.f4803a.m4907c();
        if (m4907c != null) {
            try {
                synchronized (this.f4804b) {
                    aga agaVar = this.f4804b;
                    byte[] mo3176ar = m4907c.mo3176ar();
                    agaVar.mo3309aN(mo3176ar, mo3176ar.length, bmr.m3341a());
                }
                return null;
            } catch (bnm | NullPointerException unused) {
                return null;
            }
        }
        return null;
    }
}
