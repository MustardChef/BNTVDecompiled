package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahn */
/* loaded from: classes2.dex */
final class ahn implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f4086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahn(int i) {
        this.f4086a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        Handler handler3;
        Runnable runnable2;
        if (this.f4086a == 0) {
            handler = ahq.f4089c;
            if (handler != null) {
                handler2 = ahq.f4089c;
                runnable = ahq.f4090d;
                handler2.post(runnable);
                handler3 = ahq.f4089c;
                runnable2 = ahq.f4091e;
                handler3.postDelayed(runnable2, 200L);
                return;
            }
            return;
        }
        ahq.m5241g(ahq.m5244d());
    }
}
