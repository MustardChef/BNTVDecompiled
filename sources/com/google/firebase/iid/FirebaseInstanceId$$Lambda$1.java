package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes3.dex */
final /* synthetic */ class FirebaseInstanceId$$Lambda$1 implements Executor {
    static final Executor $instance = new FirebaseInstanceId$$Lambda$1();

    private FirebaseInstanceId$$Lambda$1() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
