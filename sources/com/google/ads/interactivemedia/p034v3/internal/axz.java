package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axz */
/* loaded from: classes2.dex */
public final class axz extends axs {

    /* renamed from: a */
    private axy f5290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public axz(avb avbVar, Executor executor, Callable callable) {
        super(avbVar);
        this.f5290a = new axx(this, callable, executor);
        m4349r();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.axo
    /* renamed from: i */
    protected final void mo4341i() {
        axy axyVar = this.f5290a;
        if (axyVar != null) {
            axyVar.m4322h();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.axs
    /* renamed from: q */
    final void mo4340q() {
        axy axyVar = this.f5290a;
        if (axyVar != null) {
            axyVar.m4342f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.axs
    /* renamed from: t */
    public final void mo4339t(axr axrVar) {
        super.mo4339t(axrVar);
        if (axrVar == axr.OUTPUT_FUTURE_DONE) {
            this.f5290a = null;
        }
    }
}
