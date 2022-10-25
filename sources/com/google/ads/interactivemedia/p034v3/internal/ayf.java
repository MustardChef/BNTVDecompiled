package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayf */
/* loaded from: classes2.dex */
public final class ayf implements Runnable {

    /* renamed from: a */
    final Future f5295a;

    /* renamed from: b */
    final aye f5296b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ayf(Future future, aye ayeVar) {
        this.f5295a = future;
        this.f5296b = ayeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable m4289a;
        Future future = this.f5295a;
        if (!(future instanceof ayz) || (m4289a = aza.m4289a((ayz) future)) == null) {
            try {
                this.f5296b.mo4333b(ayu.m4317c(this.f5295a));
                return;
            } catch (Error e) {
                e = e;
                this.f5296b.mo4334a(e);
                return;
            } catch (RuntimeException e2) {
                e = e2;
                this.f5296b.mo4334a(e);
                return;
            } catch (ExecutionException e3) {
                this.f5296b.mo4334a(e3.getCause());
                return;
            }
        }
        this.f5296b.mo4334a(m4289a);
    }

    public final String toString() {
        return atm.m4609m(this).m4624a(this.f5296b).toString();
    }
}
