package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zacl implements Runnable {
    final /* synthetic */ zaco zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zacl(zaco zacoVar) {
        this.zaa = zacoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zacn zacnVar;
        zacnVar = this.zaa.zah;
        zacnVar.zaa(new ConnectionResult(4));
    }
}
