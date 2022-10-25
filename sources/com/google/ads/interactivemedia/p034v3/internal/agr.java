package com.google.ads.interactivemedia.p034v3.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agr */
/* loaded from: classes2.dex */
public final class agr extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ags f4014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public agr(ags agsVar) {
        this.f4014a = agsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        KeyguardManager keyguardManager;
        if (intent == null) {
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            ags.m5323b(this.f4014a, true);
        } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            ags.m5323b(this.f4014a, false);
        } else if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null || keyguardManager.inKeyguardRestrictedInputMode()) {
        } else {
            ags.m5323b(this.f4014a, false);
        }
    }
}
