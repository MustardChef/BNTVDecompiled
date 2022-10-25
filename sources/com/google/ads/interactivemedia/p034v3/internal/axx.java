package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axx */
/* loaded from: classes2.dex */
final class axx extends axy {

    /* renamed from: a */
    final /* synthetic */ axz f5286a;

    /* renamed from: c */
    private final Callable f5287c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public axx(axz axzVar, Callable callable, Executor executor) {
        super(axzVar, executor);
        this.f5286a = axzVar;
        atm.m4612j(callable);
        this.f5287c = callable;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: a */
    final Object mo4311a() throws Exception {
        return this.f5287c.call();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: b */
    final String mo4310b() {
        return this.f5287c.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.axy
    /* renamed from: c */
    final void mo4343c(Object obj) {
        this.f5286a.mo4313k(obj);
    }
}
