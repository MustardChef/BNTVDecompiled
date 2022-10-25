package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axy */
/* loaded from: classes2.dex */
public abstract class axy extends ayp {

    /* renamed from: a */
    private final Executor f5288a;

    /* renamed from: b */
    final /* synthetic */ axz f5289b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public axy(axz axzVar, Executor executor) {
        this.f5289b = axzVar;
        atm.m4612j(executor);
        this.f5288a = executor;
    }

    /* renamed from: c */
    abstract void mo4343c(Object obj);

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: d */
    final void mo4309d(Throwable th) {
        this.f5289b.f5290a = null;
        if (th instanceof ExecutionException) {
            this.f5289b.m4366p(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.f5289b.cancel(false);
        } else {
            this.f5289b.m4366p(th);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: e */
    final void mo4308e(Object obj) {
        this.f5289b.f5290a = null;
        mo4343c(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final void m4342f() {
        try {
            this.f5288a.execute(this);
        } catch (RejectedExecutionException e) {
            this.f5289b.m4366p(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: g */
    final boolean mo4307g() {
        return this.f5289b.isDone();
    }
}
