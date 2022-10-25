package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Future;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axs */
/* loaded from: classes2.dex */
public abstract class axs extends axw {

    /* renamed from: a */
    private static final Logger f5281a = Logger.getLogger(axs.class.getName());

    /* renamed from: b */
    private avb f5282b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public axs(avb avbVar) {
        super(avbVar.size());
        atm.m4612j(avbVar);
        this.f5282b = avbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.axo
    /* renamed from: e */
    public final String mo4306e() {
        avb avbVar = this.f5282b;
        return avbVar != null ? "futures=".concat(avbVar.toString()) : super.mo4306e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.axo
    /* renamed from: h */
    protected final void mo4305h() {
        avb avbVar = this.f5282b;
        mo4339t(axr.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (avbVar != null)) {
            boolean m4370l = m4370l();
            axf it = avbVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(m4370l);
            }
        }
    }

    /* renamed from: q */
    abstract void mo4340q();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public final void m4349r() {
        avb avbVar = this.f5282b;
        avbVar.getClass();
        if (avbVar.isEmpty()) {
            mo4340q();
            return;
        }
        Runnable runnable = new Runnable(null) { // from class: com.google.ads.interactivemedia.v3.internal.axq

            /* renamed from: b */
            public final /* synthetic */ avb f5277b = null;

            @Override // java.lang.Runnable
            public final void run() {
                axs.this.m4348s((avb) null);
            }
        };
        axf it = this.f5282b.iterator();
        while (it.hasNext()) {
            ((ayq) it.next()).mo4321g(runnable, aya.f5291a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public final /* synthetic */ void m4348s(avb avbVar) {
        int m4345v = m4345v();
        atm.m4614h(m4345v >= 0, "Less than 0 remaining futures");
        if (m4345v == 0) {
            m4344w();
            mo4340q();
            mo4339t(axr.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo4339t(axr axrVar) {
        atm.m4612j(axrVar);
        this.f5282b = null;
    }
}
