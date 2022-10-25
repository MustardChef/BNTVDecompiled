package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ape */
/* loaded from: classes2.dex */
public abstract class ape implements Callable {

    /* renamed from: a */
    protected final anw f4827a;

    /* renamed from: b */
    protected final String f4828b;

    /* renamed from: c */
    protected final String f4829c;

    /* renamed from: d */
    protected Method f4830d;

    /* renamed from: e */
    protected final int f4831e;

    /* renamed from: f */
    protected final int f4832f;

    /* renamed from: g */
    protected final aga f4833g;

    public ape(anw anwVar, String str, String str2, aga agaVar, int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        getClass().getSimpleName();
        this.f4827a = anwVar;
        this.f4828b = str;
        this.f4829c = str2;
        this.f4833g = agaVar;
        this.f4831e = i;
        this.f4832f = i2;
    }

    /* renamed from: a */
    protected abstract void mo4844a() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() throws Exception {
        mo4843f();
        return null;
    }

    /* renamed from: f */
    public void mo4843f() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method m4901i = this.f4827a.m4901i(this.f4828b, this.f4829c);
            this.f4830d = m4901i;
            if (m4901i == null) {
                return;
            }
            mo4844a();
            amu m4906d = this.f4827a.m4906d();
            if (m4906d == null || (i = this.f4831e) == Integer.MIN_VALUE) {
                return;
            }
            m4906d.m4985c(this.f4832f, i, (System.nanoTime() - nanoTime) / 1000, null, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
