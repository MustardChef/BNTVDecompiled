package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cl */
/* loaded from: classes2.dex */
public final class C2623cl implements InterfaceC2604bt {

    /* renamed from: a */
    private Message f6949a;

    private C2623cl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2623cl(byte[] bArr) {
    }

    /* renamed from: d */
    private final void m2610d() {
        this.f6949a = null;
        C2624cm.m2599k(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2604bt
    /* renamed from: a */
    public final void mo2613a() {
        Message message = this.f6949a;
        C2616ce.m2689d(message);
        message.sendToTarget();
        m2610d();
    }

    /* renamed from: b */
    public final boolean m2612b(Handler handler) {
        Message message = this.f6949a;
        C2616ce.m2689d(message);
        boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        m2610d();
        return sendMessageAtFrontOfQueue;
    }

    /* renamed from: c */
    public final void m2611c(Message message) {
        this.f6949a = message;
    }
}
