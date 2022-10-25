package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zabj implements Runnable {
    final /* synthetic */ zabk zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabj(zabk zabkVar) {
        this.zaa = zabkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        Api.Client client2;
        client = this.zaa.zaa.zac;
        client2 = this.zaa.zaa.zac;
        client.disconnect(String.valueOf(client2.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
