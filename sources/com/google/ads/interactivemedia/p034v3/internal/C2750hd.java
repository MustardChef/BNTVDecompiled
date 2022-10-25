package com.google.ads.interactivemedia.p034v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.hd */
/* loaded from: classes2.dex */
final class C2750hd extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C2751he f7488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2750hd(C2751he c2751he) {
        this.f7488a = c2751he;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        final C2751he c2751he = this.f7488a;
        C2751he.m2104c(c2751he).post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.hc
            @Override // java.lang.Runnable
            public final void run() {
                C2751he.m2103d(C2751he.this);
            }
        });
    }
}
