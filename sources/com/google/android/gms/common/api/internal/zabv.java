package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zabv extends com.google.android.gms.internal.base.zap {
    final /* synthetic */ ListenerHolder zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zabv(ListenerHolder listenerHolder, Looper looper) {
        super(looper);
        this.zaa = listenerHolder;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Preconditions.checkArgument(message.what == 1);
        this.zaa.notifyListenerInternal((ListenerHolder.Notifier) message.obj);
    }
}
