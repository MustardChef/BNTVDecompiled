package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zaay extends zabq {
    private final WeakReference<zaaz> zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaay(zaaz zaazVar) {
        this.zaa = new WeakReference<>(zaazVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabq
    public final void zaa() {
        zaaz zaazVar = this.zaa.get();
        if (zaazVar == null) {
            return;
        }
        zaaz.zah(zaazVar);
    }
}
