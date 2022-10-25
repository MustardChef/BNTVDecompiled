package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zacu extends com.google.android.gms.internal.base.zap {
    final /* synthetic */ zacv zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacu(zacv zacvVar, Looper looper) {
        super(looper);
        this.zaa = zacvVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        zacv zacvVar;
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                throw runtimeException;
            }
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(70);
            sb.append("TransformationResultHandler received unknown message type: ");
            sb.append(i2);
            Log.e("TransformedResultImpl", sb.toString());
            return;
        }
        PendingResult<?> pendingResult = (PendingResult) message.obj;
        obj = this.zaa.zae;
        synchronized (obj) {
            zacvVar = this.zaa.zab;
            zacv zacvVar2 = (zacv) Preconditions.checkNotNull(zacvVar);
            if (pendingResult == null) {
                zacvVar2.zak(new Status(13, "Transform returned null"));
            } else if (pendingResult instanceof zack) {
                zacvVar2.zak(((zack) pendingResult).zaa());
            } else {
                zacvVar2.zaa(pendingResult);
            }
        }
    }
}
