package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zan extends zabq {
    final /* synthetic */ Dialog zaa;
    final /* synthetic */ zao zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zan(zao zaoVar, Dialog dialog) {
        this.zab = zaoVar;
        this.zaa = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabq
    public final void zaa() {
        this.zab.zaa.zaa();
        if (this.zaa.isShowing()) {
            this.zaa.dismiss();
        }
    }
}
