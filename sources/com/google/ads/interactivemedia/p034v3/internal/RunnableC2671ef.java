package com.google.ads.interactivemedia.p034v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ef */
/* loaded from: classes2.dex */
public final class RunnableC2671ef extends BroadcastReceiver implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2673eh f7099a;

    /* renamed from: b */
    private final InterfaceC2672eg f7100b;

    /* renamed from: c */
    private final Handler f7101c;

    public RunnableC2671ef(C2673eh c2673eh, Handler handler, InterfaceC2672eg interfaceC2672eg) {
        this.f7099a = c2673eh;
        this.f7101c = handler;
        this.f7100b = interfaceC2672eg;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f7101c.post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
