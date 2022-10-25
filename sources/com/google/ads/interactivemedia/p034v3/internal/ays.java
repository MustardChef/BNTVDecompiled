package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.internal.axo;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ays */
/* loaded from: classes2.dex */
final class ays extends axo.AbstractC2578i implements Runnable {

    /* renamed from: a */
    private final Runnable f5307a;

    public ays(Runnable runnable) {
        atm.m4612j(runnable);
        this.f5307a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.axo
    /* renamed from: e */
    public final String mo4306e() {
        String valueOf = String.valueOf(this.f5307a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5307a.run();
        } catch (Throwable th) {
            m4366p(th);
            ato.m4606b(th);
            throw new RuntimeException(th);
        }
    }
}
