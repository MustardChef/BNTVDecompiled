package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zact implements Runnable {
    final /* synthetic */ Result zaa;
    final /* synthetic */ zacv zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zact(zacv zacvVar, Result result) {
        this.zab = zacvVar;
        this.zaa = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        zacu zacuVar;
        zacu zacuVar2;
        WeakReference weakReference2;
        GoogleApiClient googleApiClient;
        ResultTransform resultTransform;
        zacu zacuVar3;
        zacu zacuVar4;
        WeakReference weakReference3;
        try {
            try {
                BasePendingResult.zaa.set(true);
                resultTransform = this.zab.zaa;
                PendingResult onSuccess = ((ResultTransform) Preconditions.checkNotNull(resultTransform)).onSuccess(this.zaa);
                zacuVar3 = this.zab.zah;
                zacuVar4 = this.zab.zah;
                zacuVar3.sendMessage(zacuVar4.obtainMessage(0, onSuccess));
                BasePendingResult.zaa.set(false);
                zacv zacvVar = this.zab;
                zacv.zan(this.zaa);
                weakReference3 = this.zab.zag;
                googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient == null) {
                    return;
                }
            } catch (RuntimeException e) {
                zacuVar = this.zab.zah;
                zacuVar2 = this.zab.zah;
                zacuVar.sendMessage(zacuVar2.obtainMessage(1, e));
                BasePendingResult.zaa.set(false);
                zacv zacvVar2 = this.zab;
                zacv.zan(this.zaa);
                weakReference2 = this.zab.zag;
                googleApiClient = (GoogleApiClient) weakReference2.get();
                if (googleApiClient == null) {
                    return;
                }
            }
            googleApiClient.zap(this.zab);
        } catch (Throwable th) {
            BasePendingResult.zaa.set(false);
            zacv zacvVar3 = this.zab;
            zacv.zan(this.zaa);
            weakReference = this.zab.zag;
            GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.zab);
            }
            throw th;
        }
    }
}
