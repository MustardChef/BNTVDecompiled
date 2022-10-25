package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zabk implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ zabl zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabk(zabl zablVar) {
        this.zaa = zablVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        Handler handler;
        handler = this.zaa.zaa.zat;
        handler.post(new zabj(this));
    }
}
