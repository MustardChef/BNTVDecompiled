package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qp */
/* loaded from: classes2.dex */
public final class HandlerC3005qp extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3007qr f8629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3005qp(C3007qr c3007qr, Looper looper) {
        super(looper);
        this.f8629a = c3007qr;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        C3007qr.m1301a(this.f8629a, message);
    }
}
