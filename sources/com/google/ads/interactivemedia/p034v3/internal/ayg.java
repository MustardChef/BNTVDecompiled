package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayg */
/* loaded from: classes2.dex */
public final class ayg {

    /* renamed from: a */
    private final avg f5297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ayg(avg avgVar) {
        this.f5297a = avgVar;
    }

    /* renamed from: a */
    public final ayq m4332a(Callable callable, Executor executor) {
        return new axz(this.f5297a, executor, callable);
    }
}
