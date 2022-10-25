package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zab implements PendingResult.StatusListener {
    final /* synthetic */ Batch zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zab(Batch batch) {
        this.zaa = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Object obj;
        int i;
        boolean z;
        boolean z2;
        Status status2;
        PendingResult[] pendingResultArr;
        obj = this.zaa.zai;
        synchronized (obj) {
            if (this.zaa.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                this.zaa.zag = true;
            } else if (!status.isSuccess()) {
                this.zaa.zaf = true;
            }
            Batch.zad(this.zaa);
            i = this.zaa.zae;
            if (i == 0) {
                z = this.zaa.zag;
                if (z) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                } else {
                    z2 = this.zaa.zaf;
                    if (z2) {
                        status2 = new Status(13);
                    } else {
                        status2 = Status.RESULT_SUCCESS;
                    }
                    Batch batch = this.zaa;
                    pendingResultArr = batch.zah;
                    batch.setResult(new BatchResult(status2, pendingResultArr));
                }
            }
        }
    }
}
