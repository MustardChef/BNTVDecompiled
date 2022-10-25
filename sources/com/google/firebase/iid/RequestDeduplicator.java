package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes3.dex */
class RequestDeduplicator {
    private final Executor executor;
    private final Map<Pair<String, String>, Task<InstanceIdResult>> getTokenRequests = new ArrayMap();

    /* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
    /* loaded from: classes3.dex */
    interface GetTokenRequest {
        Task<InstanceIdResult> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<InstanceIdResult> getOrStartGetTokenRequest(String str, String str2, GetTokenRequest getTokenRequest) {
        final Pair pair = new Pair(str, str2);
        Task<InstanceIdResult> task = this.getTokenRequests.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        Task continueWithTask = getTokenRequest.start().continueWithTask(this.executor, new Continuation(this, pair) { // from class: com.google.firebase.iid.RequestDeduplicator$$Lambda$0
            private final RequestDeduplicator arg$1;
            private final Pair arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                this.arg$1.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.arg$2, task2);
                return task2;
            }
        });
        this.getTokenRequests.put(pair, continueWithTask);
        return continueWithTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(pair);
        }
        return task;
    }
}
