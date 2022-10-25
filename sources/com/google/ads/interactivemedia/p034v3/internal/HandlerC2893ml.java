package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ml */
/* loaded from: classes2.dex */
public final class HandlerC2893ml extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2895mn f8104a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2893ml(C2895mn c2895mn, Looper looper) {
        super(looper);
        this.f8104a = c2895mn;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Pair pair = (Pair) message.obj;
        Object obj = pair.first;
        Object obj2 = pair.second;
        int i = message.what;
        if (i == 0) {
            C2895mn.m1645g(this.f8104a, obj, obj2);
        } else if (i != 1) {
        } else {
            C2895mn.m1646f(this.f8104a, obj, obj2);
        }
    }
}
