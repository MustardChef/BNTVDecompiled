package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mq */
/* loaded from: classes2.dex */
public final class HandlerC2898mq extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2906my f8134a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2898mq(C2906my c2906my, Looper looper) {
        super(looper);
        this.f8134a = c2906my;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        List<C2895mn> list;
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null) {
            return;
        }
        list = this.f8134a.f8154j;
        for (C2895mn c2895mn : list) {
            if (c2895mn.m1640n(bArr)) {
                c2895mn.m1644i(message.what);
                return;
            }
        }
    }
}
