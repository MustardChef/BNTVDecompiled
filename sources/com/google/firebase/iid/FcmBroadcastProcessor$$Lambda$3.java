package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes3.dex */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$3 implements Continuation {
    static final Continuation $instance = new FcmBroadcastProcessor$$Lambda$3();

    private FcmBroadcastProcessor$$Lambda$3() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return FcmBroadcastProcessor.lambda$bindToMessagingService$3$FcmBroadcastProcessor(task);
    }
}
