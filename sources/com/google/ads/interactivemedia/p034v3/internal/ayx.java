package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayx */
/* loaded from: classes2.dex */
public final class ayx extends aym implements RunnableFuture {

    /* renamed from: a */
    private volatile ayp f5311a;

    ayx(Callable callable) {
        super((char[]) null);
        this.f5311a = new ayw(this, callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static ayx m4304q(Callable callable) {
        return new ayx(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static ayx m4303r(Runnable runnable, Object obj) {
        return new ayx(Executors.callable(runnable, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.axo
    /* renamed from: e */
    public final String mo4306e() {
        ayp aypVar = this.f5311a;
        if (aypVar != null) {
            String obj = aypVar.toString();
            StringBuilder sb = new StringBuilder(obj.length() + 7);
            sb.append("task=[");
            sb.append(obj);
            sb.append("]");
            return sb.toString();
        }
        return super.mo4306e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.axo
    /* renamed from: h */
    protected final void mo4305h() {
        ayp aypVar;
        if (m4370l() && (aypVar = this.f5311a) != null) {
            aypVar.m4322h();
        }
        this.f5311a = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        ayp aypVar = this.f5311a;
        if (aypVar != null) {
            aypVar.run();
        }
        this.f5311a = null;
    }
}
