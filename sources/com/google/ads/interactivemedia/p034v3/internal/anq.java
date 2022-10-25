package com.google.ads.interactivemedia.p034v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anq */
/* loaded from: classes2.dex */
public final class anq extends BroadcastReceiver {

    /* renamed from: a */
    private boolean f4727a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anq(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(this, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m4912a() {
        return this.f4727a;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.f4727a = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f4727a = false;
        }
    }
}
