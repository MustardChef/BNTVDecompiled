package com.google.android.gms.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.safetynet.zzx;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes3.dex */
final class zzn extends TaskApiCall<zzx, Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(SafetyNetClient safetyNetClient) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzx zzxVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((com.google.android.gms.internal.safetynet.zzi) zzxVar.getService()).zzb();
    }
}
