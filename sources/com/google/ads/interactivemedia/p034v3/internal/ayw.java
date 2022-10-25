package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Callable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayw */
/* loaded from: classes2.dex */
final class ayw extends ayp {

    /* renamed from: a */
    final /* synthetic */ ayx f5309a;

    /* renamed from: b */
    private final Callable f5310b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ayw(ayx ayxVar, Callable callable) {
        this.f5309a = ayxVar;
        atm.m4612j(callable);
        this.f5310b = callable;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: a */
    final Object mo4311a() throws Exception {
        return this.f5310b.call();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: b */
    final String mo4310b() {
        return this.f5310b.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: d */
    final void mo4309d(Throwable th) {
        this.f5309a.m4366p(th);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: e */
    final void mo4308e(Object obj) {
        this.f5309a.mo4313k(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayp
    /* renamed from: g */
    final boolean mo4307g() {
        return this.f5309a.isDone();
    }
}
