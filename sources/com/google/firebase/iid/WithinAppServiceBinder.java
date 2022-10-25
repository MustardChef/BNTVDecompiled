package com.google.firebase.iid;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.WithinAppServiceConnection;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes3.dex */
public class WithinAppServiceBinder extends Binder {
    private final IntentHandler intentHandler;

    /* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
    /* loaded from: classes3.dex */
    public interface IntentHandler {
        Task<Void> handle(Intent intent);
    }

    public WithinAppServiceBinder(IntentHandler intentHandler) {
        this.intentHandler = intentHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void send(final WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        this.intentHandler.handle(bindRequest.intent).addOnCompleteListener(FirebaseIidExecutors.directExecutor(), new OnCompleteListener(bindRequest) { // from class: com.google.firebase.iid.WithinAppServiceBinder$$Lambda$0
            private final WithinAppServiceConnection.BindRequest arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = bindRequest;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task task) {
                this.arg$1.finish();
            }
        });
    }
}
