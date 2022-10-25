package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayc */
/* loaded from: classes2.dex */
public abstract class ayc extends aup implements Future, ayq {
    protected ayc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ayc(byte[] bArr) {
        this();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aup
    /* renamed from: a */
    protected /* bridge */ /* synthetic */ Object mo4337a() {
        throw null;
    }

    /* renamed from: b */
    protected abstract ayq mo4336b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public /* bridge */ /* synthetic */ Future mo4335c() {
        throw null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return mo4335c().cancel(z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayq
    /* renamed from: g */
    public final void mo4321g(Runnable runnable, Executor executor) {
        mo4336b().mo4321g(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        return mo4335c().get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return mo4335c().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return mo4335c().isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return mo4335c().get(j, timeUnit);
    }
}
